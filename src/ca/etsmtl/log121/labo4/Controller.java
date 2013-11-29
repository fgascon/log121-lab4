package ca.etsmtl.log121.labo4;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import ca.etsmtl.log121.labo4.commands.*;
import ca.etsmtl.log121.labo4.models.*;
import ca.etsmtl.log121.labo4.views.ImageView;
import ca.etsmtl.log121.labo4.views.PerspectiveView;


/**
 * 
 */
public class Controller
{
	
	/**
	 * 
	 */
	private final ImageModel imageModel;
	
	/**
	 * 
	 */
	private final ArrayList<Perspective> perspectives;
	
	/**
	 * 
	 */
	public Controller(int nbPerspective){
		imageModel = new ImageModel();
		perspectives = new ArrayList<Perspective>(nbPerspective);
		for(int i=0; i<nbPerspective; i++) {
			perspectives.add(new Perspective());
		}
	}
	
	public void observeImage(ImageView view) {
		imageModel.addObserver(view);
	}
	
	public void observePerspective(int perspectiveIndex, PerspectiveView view) {
		Perspective perspective = perspectives.get(perspectiveIndex);
		perspective.addObserver(view);
		MouseControl mouseControl = new MouseControl(perspective);
		view.addMouseListener(mouseControl);
		view.addMouseMotionListener(mouseControl);
		view.addMouseWheelListener(mouseControl);
	}
	
	public void loadImage(File file) throws IOException {
		imageModel.load(file);
	}
	
	/**
	 * 
	 */
	public void undo() {
		CommandManager commandManager = CommandManager.getInstance();
		if(commandManager.canUndo()) {
			commandManager.undo();
		}
	}
	/**
	public void popMenu(MouseEvent e){
		JPopupMenu popMenu = new JpopupMenu();
	}*/
	
	/**
	 * 
	 */
	public void redo() {
		CommandManager commandManager = CommandManager.getInstance();
		if(commandManager.canRedo()) {
			commandManager.redo();
		}
	}
	
	/**
	 * 
	 */
	public void copy(Perspective perspective) {
		CopyCommand copy = new CopyCommand(perspective);
		CommandManager.getInstance().execute(copy);
	}
	
	/**
	 * 
	 */
	public void paste(Perspective perspective) {
		PasteCommand paste = new PasteCommand(perspective);
		CommandManager.getInstance().execute(paste);
	}
	
	/**
	 * 
	 */
	public void translate(Perspective perspective, Coordonnee distance) {
		TranslationCommand translation = new TranslationCommand(perspective, distance);
		CommandManager commandManager = CommandManager.getInstance();
		commandManager.execute(translation);
	}
	
	/**
	 * 
	 */
	public void zoom(Perspective perspective, float unZoom) {
		//Perspective perspective = perspectives.get(perspectiveIndex);
		ZoomCommand zoom = new ZoomCommand(perspective, unZoom);
		CommandManager commandManager = CommandManager.getInstance();
		commandManager.execute(zoom);
	}
	
	/**
	 * 
	 * @throws IOException 
	 */
	public void save(File file) throws IOException {
		String content = imageModel.serialize();
		for(int i=0; i<perspectives.size(); i++) {
			content += ";" + perspectives.get(i).serialize();
		}
		FileAccess.writeFile(file, content);
	}
	
	/**
	 * 
	 * @throws Exception 
	 */
	public void open(File file) throws Exception {
		String content = FileAccess.readFile(file);
		String[] contentParts = content.split(";");
		if(contentParts.length != 3) {
			throw new Exception("Invalid file format");
		}
		imageModel.unserialize(contentParts[0]);
		for(int i=0; i<2; i++) {
			perspectives.get(i).unserialize(contentParts[i+1]);
		}
	}
	
	private class MouseControl extends MouseAdapter {
		
		private Perspective perspective;
		
		private Coordonnee translationBegin;
		
		public MouseControl(Perspective perspective) {
			this.perspective = perspective;
		}
		
		public void mouseClicked(MouseEvent event) {
			
			if (event.getButton() == 3){
				JPopupMenu popMenu = new JPopupMenu();
				JMenuItem zoom = new JMenuItem("Zoom 10%");
				
				zoom.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						zoom(perspective, 1.1f);
					}
				});
				popMenu.add(zoom);
				
				JMenuItem unZoom = new JMenuItem("Unzoom 10%");
				unZoom.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						zoom(perspective, 1/1.1f);
					}
				});
				popMenu.add(unZoom);
				
				JMenuItem copy = new JMenuItem("Copy");
				copy.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						copy(perspective);
					}
				});
				popMenu.add(copy);
				
				JMenuItem paste = new JMenuItem("Paste");
				paste.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						paste(perspective);
					}
				});
				popMenu.add(paste);	
				
				popMenu.show(event.getComponent(), event.getX(), event.getY());
				
								
			}
		}
		
		
		public void mouseReleased(MouseEvent event) {
			if(translationBegin != null) {
				Coordonnee translationEnd = new Coordonnee(event.getPoint());
				Coordonnee dragDistance = translationEnd.diff(translationBegin);
				if(dragDistance.getX() != 0 && dragDistance.getY() != 0) {
					translate(perspective, dragDistance);
				}
				translationBegin = null;
			}
		}
		
		public void mousePressed(MouseEvent event) {
			translationBegin = new Coordonnee(event.getPoint());
		}
		
		public void mouseDragged(MouseEvent event) {
			if(event.getSource() instanceof PerspectiveView) {
				PerspectiveView view = (PerspectiveView) event.getSource();
				if(translationBegin != null) {
					Coordonnee currentPosition = new Coordonnee(event.getPoint());
					Coordonnee dragDistance = currentPosition.diff(translationBegin);
					view.setPosition(perspective.getPosition().add(dragDistance));
				}
			}
		}
		
		/**public void popMenu(MouseEvent e){
			JPopupMenu popMenu = new JPopupMenu();
			JMenuItem unItem = new JMenuItem("Ta mere");
			popMenu.add(unItem);
			popMenu.show(e.getComponent(), e.getX(), e.getY());
		}*/
		
		public void mouseWheelMoved(MouseWheelEvent event) {
			 int rotation = event.getWheelRotation();
			 
			 if (rotation < 0)
				 zoom(perspective,(1f/0.9f));
			 if (rotation > 0)
				 zoom(perspective,0.9f);
		}
	}
}