package edu.cs401group3.crm.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Properties;
import java.util.logging.Logger;

import edu.cs401group3.crm.server.clienthandler.ClientHandler;
import edu.cs401group3.crm.server.storage.StorageManager;
import edu.cs401group3.crm.common.Log;

/** Server Class.
 * CRM Server 
 * Multiple ClientHandlers are created in a new thread for each new Client that is connecting to the Server.
 * 
 * @author Nicholas Krone
*/
public class Server {
	private final int port;
	private final String defaultPropertyPath = "src/main/resources/server.properties";
	private boolean server_good;
	private ServerSocket server;
	private Logger logger;
	
	public Server(int port) {
		logger = Logger.getLogger("CRMServer");
		this.port = port;
		try {
			server = new ServerSocket(this.port);
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Failed to open new socket");
			server_good = false;
			server = null;
		}		
		server_good = true;
	}
	
	public void start() {
		if (! server_good) 
			return;
		
		try {
			server.setReuseAddress(true);
			checkServerStorage();
			StorageManager storageManager = new StorageManager();
			new Thread(storageManager).start();
			while (true) {
				Socket client = server.accept();				
				Log.LOGGER.info("New client connected: " + client.getInetAddress().getHostAddress());
				Log.LOGGER.info("New client connected: " + client.getInetAddress().getHostAddress());
				ClientHandler clientConnection = new ClientHandler(client);
				new Thread(clientConnection).start();				
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				server.close();				
			}
			catch (IOException e) {
				Log.LOGGER.info("Failed to close socket ... oh well");
			}
		}
	}
	
	private void checkServerStorage() {
		Path path = Paths.get(".crm");
		try {			
			if (! Files.exists(path)) {
				boolean bool = new File(".crm").mkdirs();
				new File(".crm/Users.db").createNewFile();
				createAdmin();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void createAdmin() {
		Path path = Paths.get(".crm/Users.db");
		try {
			Files.write(Paths.get(path.toString()), "Admin".getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String propertyPath = "";		
		int port = 7777;
		try (InputStream input = new FileInputStream("src/main/resources/server.properties")) {
			Properties prop = new Properties();
			prop.load(input);
			port = Integer.parseInt(prop.getProperty("server.port"));
		}  
		catch (IOException e) {
			 Log.LOGGER.info("server.properties does not exist, using default port 7777");
	     }
		
		Server server = new Server(port);
		server.start();
	}
}
	