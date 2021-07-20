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
import java.util.Properties;

import edu.cs401group3.crm.server.clienthandler.ClientHandler;
import edu.cs401group3.crm.server.storage.StorageManager;
import edu.cs401group3.crm.common.Log;

class Server {
	private final int port;
	private final String defaultPropertyPath = "src/main/resources/server.properties";
	private boolean server_good;
	private ServerSocket server;
	private Log log = new Log();
	
	public Server(int port) {
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
				System.out.println("New client connected: " + client.getInetAddress().getHostAddress());
				log.LOGGER.info("New client connected: " + client.getInetAddress().getHostAddress());
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
				System.out.println("Failed to close socket ... oh well");
			}
		}
	}
	
	private void checkServerStorage() {
		Path path = Paths.get(".crm");
		try {			
			if (! Files.exists(path)) {
				boolean bool = new File(".crm").mkdirs();
				new File(".crm/Users.db").createNewFile();
			}
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
			 System.out.println("server.properties does not exist, using default port 7777");
	     }
		
		Server server = new Server(port);
		server.start();
	}
}
	