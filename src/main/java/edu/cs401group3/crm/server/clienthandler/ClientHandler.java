package edu.cs401group3.crm.server.clienthandler;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Logger;

import edu.cs401group3.crm.commands.CommandProcessor;
import edu.cs401group3.crm.commands.user.User;
import edu.cs401group3.crm.common.message.Message;
import edu.cs401group3.crm.common.message.AuthenticationMessage;
import edu.cs401group3.crm.common.message.CommandMessage;

/** ClientHandler Class.
 * ClientHandler handles the connection between a single Client and the Server.<br>
 * Multiple ClientHandlers are created in a new thread for each new Client that is connecting to the Server.
 * 
 * @author Nicholas Krone
*/
public class ClientHandler implements Runnable {
	private final Socket clientSocket;
	private CommandProcessor commandProcessor;
	private Logger logger;
	
	/** Create a new ClientHandler with a given Client socket
	 * 
	 * @param socket A Socket which contains the communications stream from a single Client.
	 */
	public ClientHandler(Socket socket) {
		logger = Logger.getLogger("CRMServer");
		this.clientSocket = socket;
		commandProcessor = new CommandProcessor();
	}
	
	public void run() {
		PrintWriter out = null;
		BufferedReader in = null;
		boolean is_logged_in = false;
    
		try {
				logger.info("Client handler processing new connection");
                InputStream inputStream = clientSocket.getInputStream();
				OutputStream outputStream = clientSocket.getOutputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

				while (true) {
                    Message msg = (Message) objectInputStream.readObject();
                    
					// First check if we get a login request
                    // Should be done by some sort of authentication manager
					if (msg.getType().equals("authentication")) {
						logger.info("Auth message received, validating...");
						AuthenticationMessage authMessage = (AuthenticationMessage) msg;
						is_logged_in = true;
						
						// Get user data
						
						// check authentication here
						authMessage.setStatus("success"); //set message status
						
						logger.info("Credentials valid");
						User user = (User) authMessage.getContent().get("user"); //set inner user object status to logged in
						user.setStatus("logged in");
						objectOutputStream.writeObject(authMessage);						
						logger.info("Client: " + clientSocket.getInetAddress().getHostAddress() + " logged in: ");

						continue;
					}
					else {
						if (! is_logged_in) {
							logger.info("Invalid message received: " + msg.getType());
							continue;
						}
					}

//					TODO Handle logout
//					else if (msg.getType().equals("logout")) {
//						is_logged_in = false;
//						msg.setStatus("success");
//						objectOutputStream.writeObject(msg);
//						System.out.println("Client: " + clientSocket.getInetAddress().getHostAddress() + " logged out");
//						break;
//					}

					// Never process requests if the client is not logged in
					if (! is_logged_in)
						continue;

					// Begin processing
					logger.info("Client: " + clientSocket.getInetAddress().getHostAddress() + " message: " + msg.getType());
										
					if (msg.getType().equals("command")) {
						logger.info("Command Message Received");
						CommandMessage command = (CommandMessage) msg;
						logger.info(command.getCommandName());
						commandProcessor.processCommand(command);
					}
					
					Message reply = (Message) msg;
					msg.setStatus("success");
					objectOutputStream.writeObject(reply);
                }
		}
        catch (EOFException e) {
            e.printStackTrace();	
        }
        catch (SocketTimeoutException e) {
            e.printStackTrace();
        }
		catch (IOException e) {
			e.printStackTrace();
		}
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
					clientSocket.close();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
