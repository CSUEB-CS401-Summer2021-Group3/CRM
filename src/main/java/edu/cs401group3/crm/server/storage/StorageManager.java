package edu.cs401group3.crm.server.storage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

import edu.cs401group3.crm.commands.user.User;
import edu.cs401group3.crm.common.message.StorageMessage;

/** StorageManager Class.
 * The StorageManager runs in a background thread and polls the StorageQueue for StorageMessages to save to a datafile.<br> 
 * 
 * 
 * @author Nicholas Krone
*/
public class StorageManager implements Runnable {

	private StorageQueue queue = StorageQueue.getInstance();
	private String directory = ".crm";
	private Logger logger;

	public StorageManager() {
		logger = Logger.getLogger("CRMServer");

	}

	@Override
	public void run() {
		logger.info("Starting storage checker!");
		while (true) {
			StorageMessage msg = null;
			try {
				msg = queue.dequeue();				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (msg != null) {
				logger.info("Non-null message!");
				String data = "";

				if (msg.getOperation() == StorageOperation.WRITE) {					
					try {
						logger.info("Perform write operation");
						User user = (User) msg.getContent().get("user");
						data = user.getData(); // For now we do this until we know exactly the format of the data to save
						
						FileWriter fw = new FileWriter(".crm/" + user + "/" + "data.txt", true);
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(data);
						bw.newLine();
						bw.close();
						logger.info("WROTE SOMETHING!");
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else if (msg.getOperation() == StorageOperation.READ) {
					logger.info("Perform read operation");
					User user = (User) msg.getContent().get("user");
					data = user.getData(); // For now we do this until we know exactly the format of the data to save
				}
			}
			else {}
		}
	}
	
	public void getUserFile(User user) {
		
	}
}