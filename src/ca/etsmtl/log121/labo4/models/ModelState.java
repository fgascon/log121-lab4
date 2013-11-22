package ca.etsmtl.log121.labo4.models;

public interface ModelState {
	
	public String serialize();
	
	public void unserialize(String state) throws Exception;
}
