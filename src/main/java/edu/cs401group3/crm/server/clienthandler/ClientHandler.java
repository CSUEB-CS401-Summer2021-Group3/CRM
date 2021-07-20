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

import edu.cs401group3.crm.common.message.AuthenticationMessage;
import edu.cs401group3.crm.common.message.Message;
import edu.cs401group3.crm.server.storage.StorageQueue;

public class ClientHandler implements Runnable {
	private final Socket clientSocket;
	private StorageQueue queue = StorageQueue.getInstance();
	
	public ClientHandler(Socket socket) {
		this.clientSocket = socket;
	}
	
	public void run() {
		PrintWriter out = null;
		BufferedReader in = null;
		boolean is_logged_in = false;
    
		try {
                InputStream inputStream = clientSocket.getInputStream();
				OutputStream outputStream = clientSocket.getOutputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

				while (true) {
                    Message msg = (Message) objectInputStream.readObject();
                    
					// First check if we get a login request
					if (msg.getType().equals("authentication")) {
						AuthenticationMessage authMessage = (AuthenticationMessage) msg;
						is_logged_in = true;
						authMessage.setStatus("success");
						objectOutputStream.writeObject(authMessage);
						
						System.out.println("Client: " + clientSocket.getInetAddress().getHostAddress() + " logged in: ");

						continue;
					}
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
					System.out.println("Client: " + clientSocket.getInetAddress().getHostAddress() + " message: " + msg.getType());
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
