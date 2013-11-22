package ca.etsmtl.log121.labo4.models;

public interface Model {
	
	public ModelState saveState();
	
	public void restoreState(ModelState state);
}
