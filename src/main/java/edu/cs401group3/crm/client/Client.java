package edu.cs401group3.crm.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import edu.cs401group3.crm.commands.user.User;
import edu.cs401group3.crm.common.message.AuthenticationMessage;
import edu.cs401group3.crm.common.message.CommandMessage;
import edu.cs401group3.crm.common.message.Message;
import edu.cs401group3.crm.common.message.StorageMessage;
import edu.cs401group3.crm.server.storage.StorageManager;

public class Client {
    private String address;
    private String port;
    private Socket socket;
    private Scanner scanner;
    
    private String username;
    private String password;
    
    private User user;

    OutputStream outputStream;
    ObjectOutput objectOutputStream;
    InputStream inputStream;
    ObjectInput objectInputStream;

    public Client() {}
    
    private Socket login() {
    	AuthenticationMessage authMessage;
        scanner = new Scanner(System.in);
        
        System.out.println("Username: ");
        username = scanner.nextLine();

        System.out.println("Password: ");
        password = scanner.nextLine();
        
        user = new User(username);
        System.out.println("Current user status: " + user.getStatus());
        
        System.out.print("Enter server address [localhost]: ");
        this.address = scanner.nextLine();
        if (address.equals(""))
            address = "localhost";

        System.out.print("Enter server port [7777]: ");
        this.port = scanner.nextLine();

        if (port.equals(""))
            port = "7777";

        try {
            socket = new Socket(address, Integer.parseInt(port));

            outputStream = socket.getOutputStream();
            objectOutputStream = new ObjectOutputStream(outputStream);
            inputStream = socket.getInputStream();
            objectInputStream = new ObjectInputStream(inputStream);
            
            authMessage = new AuthenticationMessage(username, password);
            authMessage.getContent().put("user", user); // Add user object to message
            objectOutputStream.writeObject(authMessage);
            Message reply = (Message) objectInputStream.readObject();
            
            if (reply.getStatus().equals("success")) {
            	System.out.println("Logged in!");
            	user = (User) reply.getContent().get("user");
            	System.out.println("Updated user status: " + user.getStatus());
            }
                        
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        System.out.println("Connected to " + address + ":" + port);
        return socket;
    }
    
    public void session() throws IOException {
    	Socket sock = null;
        Message msg;
        boolean is_logged_in = false;

        sock = login();
        if (sock == null) {
            return;
        }

        System.out.println("Logged in");
        is_logged_in = true;

        try {
            scanner = new Scanner(System.in);

            while (is_logged_in) {

                // Output (write) data to server
                System.out.print("> ");
                String messageType = scanner.nextLine();

                if (messageType.equals("command")) {
                	msg = new CommandMessage(null);
                }
                else if (messageType.equals("storage")) {
                	msg = new StorageMessage();
                	Map<String, Object> data = new HashMap<String, Object>();
                	System.out.println("Key: ");
                	String key = scanner.nextLine();
                	
                	System.out.println("Value: ");
                	String value = scanner.nextLine();

                	// Should be a User class but for now use a string
                	data.put("user", user);
                	data.put(key, value);
                	msg.setContent(data);
                	System.out.println("Just added entry: " + key + " - " + msg.getContent().get(key));
                }
                else if (messageType.equals("logout")) {
                	break;
                }
                else {
                	msg = new Message();
                }
       
                objectOutputStream.writeObject(msg);
  
                // Input (read) data from server
                msg = (Message) objectInputStream.readObject();
                if (msg.getStatus().equals("success"))
                    System.out.println("Server replied: " + msg.getStatus() + "\n");
            
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("Closing socket");
            socket.close();
            scanner.close();
        }
    }
    
    public CommandMessage createMessage(String command, Map<String, Object> data) {
    	data.put("user", user);
    	return new CommandMessage(data);
    }

	public static void main(String[] args) {
		Client client = new Client();
		try {
			client.session();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
