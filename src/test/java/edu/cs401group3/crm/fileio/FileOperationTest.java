package edu.cs401group3.crm.fileio;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.AfterEach;
import org.junit.After;
import org.junit.Test;

public class FileOperationTest {


	@Test
	public void FileOperationTestInsertLineInFile() {
		FileOperation fileio = new FileOperation();
		Path file = Paths.get("TestFile.txt");
		
		fileio.insertLineInFile(file, "TEST STRING");
		
		try (FileReader reader = new FileReader(file.toString());
		         BufferedReader buffReader = new BufferedReader(reader)) {
		         String line = buffReader.readLine();

		         int count = 1;
		         while (line != null) {
		             if (count == 1)
		            	 assertEquals("", line);
		             if (count == 2)
		            	 assertEquals("TEST STRING", line);
		             
		             count++;
		             line = buffReader.readLine();
		         }
		    } catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}	
	}

	@Test
	public void FileOperationTestFindLineInFile() {
		FileOperation fileio = new FileOperation();
		Path file = Paths.get("TestFile.txt");
		
		System.out.println(file.toAbsolutePath());
		
		fileio.insertLineInFile(file, "TEST STRING");
		
		boolean lineFound = fileio.findLineInFile(file, "TEST STRING");
		
		assertEquals(lineFound, true);
		
	}

	@Test
	public void FileOperationTestDeleteLineFromFile() {
		FileOperation fileio = new FileOperation();
		Path file = Paths.get("TestFile.txt");
		
		fileio.insertLineInFile(file, "TEST STRING");
		fileio.deleteLineFromFile(file, "TEST STRING");
		
		try (FileReader reader = new FileReader(file.toString());
		         BufferedReader buffReader = new BufferedReader(reader)) {
		         String line = buffReader.readLine();

		         int count = 1;
		         while (line != null) {
		             if (count == 1)
		            	 assertEquals("", line);
		             if (count == 2)
		            	 assertEquals("", line);
		             
		             count++;
		             line = buffReader.readLine();
		         }
		    } catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}		
	}

	@Test
	public void FileOperationTestCreateFolder() {
		FileOperation fileio = new FileOperation();
		Path file = Paths.get("DUMMYFOLDER");
		fileio.createFolder(file);
		
		assertEquals(true, Files.exists(file));
	}

	@Test
	public void FileOperationTestCreateFile() {
		FileOperation fileio = new FileOperation();
		Path file = Paths.get("TestFile.txt");
		fileio.createFile(file);
		assertEquals(true, Files.exists(file));
	}

	@Test
	public void FileOperationTestDeleteFolder() {
		FileOperation fileio = new FileOperation();
		Path file = Paths.get("DUMMYFOLDER");
		fileio.createFolder(file);
		
		assertEquals(true, Files.exists(file));
		
		fileio.deleteFolder(file);
		
		assertEquals(false, Files.exists(file));
	}
	
	@AfterEach
	public void removeTestFile() {
		new File("TestFile.txt").delete();
	}
	
	@AfterEach
	public void removeDummyFolder() {
		FileOperation fileio = new FileOperation();
		Path file = Paths.get("DUMMYFOLDER");
		fileio.deleteFolder(file);
	}
	
	@After
	public void removeFolder() {
		FileOperation fileio = new FileOperation();
		Path file = Paths.get("DUMMYFOLDER");
		fileio.deleteFolder(file);
	}

}
