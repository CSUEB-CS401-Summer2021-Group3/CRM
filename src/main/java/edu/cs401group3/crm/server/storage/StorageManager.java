package edu.cs401group3.crm.server.storage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import edu.cs401group3.crm.common.Log;
import edu.cs401group3.crm.common.message.StorageMessage;

public class StorageManager implements Runnable {

	private StorageQueue queue = StorageQueue.getInstance();
	private String directory = ".crm";
	private Log log = new Log();


	public StorageManager() {

	}

	@Override
	public void run() {
//		System.out.println("Starting storage checker!");
		while (true) {
			StorageMessage msg = null;
			try {
				msg = queue.dequeue();				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (msg != null) {
				log.LOGGER.info("Non-null message!");
				String data = "";
				for (Map.Entry<String, String> entry : msg.getContent().entrySet()) {
					data += entry.getKey() + ":" + entry.getValue().toString() + "\n";
//					System.out.println(entry.getKey() + ":" + entry.getValue().toString());
				}
				String user = msg.getContent().get("user");
				checkUserFolder(user);
					
				try {
					FileWriter fw = new FileWriter(".crm/" + user + "/" + "data.txt", true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(data);
					bw.newLine();
					bw.close();
					log.LOGGER.info("WROTE SOMETHING!");
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
			}
		}
	}

	public void checkUserFolder(String user) {
		Path path = Paths.get(".crm/" + user);
		try {
			if (!Files.exists(path)) {
				log.LOGGER.info("Creating .crm/" + user + " folder");
				boolean bool = new File(".crm/" + user).mkdirs();
				log.LOGGER.info("USER DIR MADE?: " + bool);
				new File(".crm/" + user + "/" + "data.txt").createNewFile();
			} 
			else {
				log.LOGGER.info("File: .crm/" + user + " exists");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
