package edu.cs401group3.crm.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Logger;

public class FileOperation {
	private Logger logger;
	
	public FileOperation() {
		logger = Logger.getLogger("CRMServer");
	}
	
	
	public void insertLineInFile(Path path, String line) {
		try {
			Files.write(Paths.get(path.toString()), line.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean findLineInFile(Path path, String searchStr) {
		boolean lineExists = false;
		
		try (FileReader reader = new FileReader(path.toString());
		         BufferedReader buffReader = new BufferedReader(reader)) {
		         String line = buffReader.readLine();

		         while (line != null) {
		             if (line.contains(searchStr)) {
		            	 lineExists = true;
		                 break;
		             }
		             line = buffReader.readLine();
		         }
		    } catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return lineExists;
	}
	
	public void deleteLineFromFile(Path path, String searchStr) {
		File inputFile = path.toFile();
		File tempFile = new File("tempFile.txt");
		
		try {			
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
			String currentLine;
			
			
			while((currentLine = reader.readLine()) != null) {
				String trimmedLine = currentLine.trim();
				if(trimmedLine.equals(searchStr)) continue;
				writer.write(currentLine + System.getProperty("line.separator"));
			}
			
			writer.close(); 
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createFolder(Path path) {
		if (!Files.exists(path)) {
			logger.info("Creating " + path.toString());
			
			boolean bool = path.toFile().mkdirs();
			logger.info("USER DIR MADE?: " + bool);
		} 
		else {
			logger.info("File: ");
		}
	}

	public void createFile(Path path) {
		try {
			if (!Files.exists(path)) {
				path.toFile().createNewFile();
			} 
			else {
				logger.info("File: " + path.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public void deleteFolder(Path path) {
		File file = path.toFile();
		String[] content = file.list();
		
		for (String s : content) {
			File currentFile = new File(file.getPath(), s);
			currentFile.delete();
		}
		file.delete();
	}
}
