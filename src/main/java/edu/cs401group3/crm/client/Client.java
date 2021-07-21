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

import edu.cs401group3.crm.common.message.AuthenticationMessage;
import edu.cs401group3.crm.common.message.CommandMessage;
import edu.cs401group3.crm.common.message.Message;
import edu.cs401group3.crm.common.message.StorageMessage;
import edu.cs401group3.crm.server.storage.StorageManager;
import edu.cs401group3.crm.common.SHA256;

public class Client {
    private String address;
    private String port;
    private Socket socket;
    private Scanner scanner;
    
    private String user;
    private String password;
    private String pws_hashed;// password with salt hashed
    private String salt;
    
    OutputStream outputStream;
    ObjectOutput objectOutputStream;
    InputStream inputStream;
    ObjectInput objectInputStream;

    public Client() {}
    
    private Socket login() {
    	AuthenticationMessage authMessage;
        scanner = new Scanner(System.in);
        
        System.out.println("Username: ");
        user = scanner.nextLine();

        System.out.println("Password: ");
        password = scanner.nextLine();
        
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
            
            //need a method pull the user's salt
            
            pws_hashed = new SHA256(password+salt).getSHA();
            
            authMessage = new AuthenticationMessage(user, pws_hashed);
            objectOutputStream.writeObject(authMessage);
            Message reply = (Message) objectInputStream.readObject();
            
            if (reply.getStatus().equals("success")) {
            	System.out.println("Logged in!");
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
                	Map<String, String> data = new HashMap<String, String>();
                	System.out.println("Key: ");
                	String key = scanner.nextLine();
                	
                	System.out.println("Value: ");
                	String value = scanner.nextLine();

                	// Should be a User class but for now use a string
                	data.put("user", user);
                	data.put(key, value);
                	msg.setContent(data);
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

	public static void main(String[] args) {
		Client client = new Client();
		try {
			client.session();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
