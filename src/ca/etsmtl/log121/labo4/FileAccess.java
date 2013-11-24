package ca.etsmtl.log121.labo4;

import java.io.*;

public class FileAccess {
	
	public static final String readFile(File file) throws IOException {
		
		//open the file
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		//read the file
		StringBuilder fileContent = new StringBuilder();
		try {
			String line;
			while((line = reader.readLine()) != null) {
				fileContent.append(line).append("\n");
			}
		} catch (IOException exception) {
			throw exception;
		} finally {
			reader.close();
		}
		
		return fileContent.toString();
	}
	
	public static final String writeFile(File file, String fileContent) throws IOException {
		
		//open the file
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		
		//write to the file
		try {
			writer.write(fileContent);
		} catch (IOException exception) {
			throw exception;
		} finally {
			writer.close();
		}
		
		return fileContent.toString();
	}
}
