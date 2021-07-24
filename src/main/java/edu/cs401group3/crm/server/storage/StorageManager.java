package edu.cs401group3.crm.server.storage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.logging.Logger;

import edu.cs401group3.crm.commands.user.User;
import edu.cs401group3.crm.common.message.StorageMessage;

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

				User user = (User) msg.getContent().get("user");
				data = user.getData(); // For now we do this until we know exactly the format of the data to save
					
				try {
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
			else {}
		}
	}
}
