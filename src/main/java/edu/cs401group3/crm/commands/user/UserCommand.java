package edu.cs401group3.crm.commands.user;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

import edu.cs401group3.crm.common.message.StorageMessage;
import edu.cs401group3.crm.fileio.FileOperation;
import edu.cs401group3.crm.server.storage.StorageQueue;

/** UserCommand Class.
 * 
 * UserCommands cover operation pertaining to Users.<br>
 * Creating a User, editing a User or Deleting a User.
 * 
 * @author Nicholas Krone
*/
public class UserCommand {
	private Logger logger = Logger.getLogger("CRMServer");
	StorageQueue queue = StorageQueue.getInstance();
	FileOperation fileio;

	/** Create a new UserCommand
	 * 
	 */
	public UserCommand() {
		fileio = new FileOperation();
	}
	
	/** Add a new User to the Server database.
	 * 
	 * @param user A User object to be added.
	 */
	public synchronized void addUser(User user) {
		Path userDb = Paths.get(".crm/Users.db");
		Path userData = Paths.get(".crm/" + user.getName());
		Path userDataF = Paths.get(userData.toString() + "/data.txt");
		
		logger.info("Adding User to Database");
		fileio.insertLineInFile(userDb, user.getName());
		logger.info("Creating User folder");
		fileio.createFolder(userData);
		
		// Test - remove after
		StorageMessage msg = new StorageMessage();
		msg.getContent().put("user", user);
		msg.getContent().put("target", userDataF);
		msg.getContent().put("data", "Test data\n\nTest data\n\nHope this works!");
		queue.enqueue(msg);

	}

	/** Delete a User from the Server database.
	 * 
	 * @param user A User object to be removed.
	 */
	public synchronized void deleteUser(User user) {
		Path userDb = Paths.get(".crm/Users.db");
		Path userData = Paths.get(".crm/" + user.getName());
		
		logger.info("Deleting User from Database");
		fileio.deleteLineFromFile(userDb, user.getName());
		
		logger.info("Deleting User folder");
		fileio.deleteFolder(userData);
	}
	
	/** Edit a User in the Server database.
	 * 
	 * @param user A User object to be edited.
	 */
	public synchronized void editUser(User user) {
		Path userData = Paths.get(".crm/" + user.getName() + "data.txt");
		Path userDataF = Paths.get(userData.toString() + "/data.txt");
		StorageMessage msg = new StorageMessage();
		msg.getContent().put("user", user);
		msg.getContent().put("target", userDataF);
		msg.getContent().put("data", user.getData());
		queue.enqueue(msg);
	}
}
