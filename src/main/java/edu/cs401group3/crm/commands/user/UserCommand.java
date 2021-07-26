package edu.cs401group3.crm.commands.user;

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

import edu.cs401group3.crm.common.message.StorageMessage;
import edu.cs401group3.crm.server.storage.StorageQueue;

/** UserCommand Class.
 * 
 * UserCommands cover operation pertaining to Users.<br>
 * Creating a User, editing a User or Deleting a User.
 * 
 * @author Nicholas Krone
*/
public class UserCommand {
	private Logger logger;
	StorageQueue queue = StorageQueue.getInstance();

	/** Create a new UserCommand
	 * 
	 */
	public UserCommand() {
		logger = Logger.getLogger("CRMServer");
	}
	
	public synchronized void addUser(User user) {
		Path path = Paths.get(".crm/Users.db");
		if (! findUserInFile(user)) {			
			try {
				Files.write(Paths.get(path.toString()), user.getName().getBytes(), StandardOpenOption.APPEND);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		checkUserFolder(user);
	}
	
	public synchronized void deleteUser(User user) {
		String username = user.getName();
		Path path = Paths.get(".crm/Users.db");
		File inputFile = new File(path.toString());
		File tempFile = new File("tempFile.txt");
		
		try {			
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
			String currentLine;
			
			
			while((currentLine = reader.readLine()) != null) {
				String trimmedLine = currentLine.trim();
				if(trimmedLine.equals(username)) continue;
				writer.write(currentLine + System.getProperty("line.separator"));
			}
			
			writer.close(); 
			reader.close(); 
			
			deleteUserFolder(user);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void editUser(User user) {
		StorageMessage msg = new StorageMessage();
		msg.getContent().put("user", user);
		queue.enqueue(msg);
	}
	
	private boolean findUserInFile(User user) {
		Path path = Paths.get(".crm/Users.db");
		String searchString = user.getName();
		boolean userExists = false;
		try (FileReader reader = new FileReader(path.toString());
		         BufferedReader buffReader = new BufferedReader(reader)) {
		         String line = buffReader.readLine();
		         while (line != null) {
		             if (line.contains(searchString)) {
		                 userExists = true;
		                 break;
		             }
		             line = buffReader.readLine();
		         }
		    } catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return userExists;
	}
	
	private synchronized void checkUserFolder(User user) {
		String username = user.getName();
		Path path = Paths.get(".crm/" + username);
		try {
			if (!Files.exists(path)) {
				logger.info("Creating .crm/" + username+ " folder");
				boolean bool = new File(".crm/" + username).mkdirs();
				logger.info("USER DIR MADE?: " + bool);
				new File(".crm/" + user + "/" + "data.txt").createNewFile();
			} 
			else {
				logger.info("File: .crm/" + username + " exists");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private synchronized void deleteUserFolder(User user) {
		String username = user.getName();
		File file = new File(".crm/" + username);
		String[] content = file.list();
		
		for (String s : content) {
			File currentFile = new File(file.getPath(), s);
			currentFile.delete();
		}
		file.delete();
	}
}
