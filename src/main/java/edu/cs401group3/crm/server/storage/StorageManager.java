package edu.cs401group3.crm.server.storage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicBoolean;
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
	private Logger logger = Logger.getLogger("CRMServer");
    private final AtomicBoolean running = new AtomicBoolean(false);

	public StorageManager() {}
	
	public StorageManager(String rootDir) {
		logger = Logger.getLogger("CRMServer");
	}
	
	
	public void setStop() {
		running.set(false);
	}

	@Override
	public void run() {
		logger.info("Starting storage checker!");
        running.set(true);
		while (running.get()) {
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
						if (user == null) {
							logger.info("Null user");
						}											
						
						Path targetPath = (Path) msg.getContent().get("target");
						data = (String) msg.getContent().get("data");
						
						logger.info(targetPath.toAbsolutePath().toString());
						logger.info(targetPath.getParent().toString());
						
						// Can't process anything if we have no path to write data to or no data to actually write
						if (targetPath == null || data == null) {
							logger.info("No target path described in StorageMessage");
							msg.setStatus("failed");
						}
						else {
							if (!Files.exists(targetPath)) {
								Files.createDirectories(targetPath.getParent());
								targetPath.toFile().createNewFile();
							}
							FileWriter fw = new FileWriter(targetPath.toString(), true);
							BufferedWriter bw = new BufferedWriter(fw);
							bw.write(data);
							bw.newLine();
							bw.close();
							logger.info("WROTE SOMETHING!");
							msg.setStatus("success");
						}
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
}