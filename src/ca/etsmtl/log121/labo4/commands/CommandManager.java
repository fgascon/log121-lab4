package ca.etsmtl.log121.labo4.commands;


/**
 * 
 */
public class CommandManager
{
	
	private static final CommandManager instance = new CommandManager();
	
	/**
	 * 
	 */
	public static CommandManager getInstance() {
		return instance;
	}
	
	/**
	 * 
	 */
	public CommandManager(){
		
	}
	
	/**
	 * 
	 */
	public void undo() {
		// TODO : to implement	
	}
	
	/**
	 * 
	 */
	public void redo() {
		// TODO : to implement	
	}
}

