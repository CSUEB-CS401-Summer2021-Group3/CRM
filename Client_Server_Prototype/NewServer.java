import java.io.*;
import java.net.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class NewServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ServerSocket server = null;

        try {

            server = new ServerSocket(7777);
            System.out.println("ServerSocket awaiting connections...");
            server.setReuseAddress(true);

			while (true) {

				Socket client = server.accept();

				// Displaying that new client is connected
				// to server
				System.out.println("New client connected: "
								+ client.getInetAddress()
										.getHostAddress());

				// create a new thread object
				ClientHandler clientSock
					= new ClientHandler(client);

				// This thread will handle the client separately
				new Thread(clientSock).start();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (server != null) {
				try {
					server.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
    }

    private static class ClientHandler implements Runnable {
		private final Socket clientSocket;

        public ClientHandler(Socket socket)
		{
			this.clientSocket = socket;
		}

		public void run()
		{
			PrintWriter out = null;
			BufferedReader in = null;
        
			try {
                    InputStream inputStream = clientSocket.getInputStream();
					OutputStream outputStream = clientSocket.getOutputStream();
                    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
 
                    while (true) {
                        Message msg = (Message) objectInputStream.readObject();
                        printMessage(msg);

						Message reply = new Message("Reply from server");
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
        
        private static void printMessage(Message msg) {
            System.out.println("ID: " + msg.getID());
            System.out.println("Type: " + msg.getType());
            System.out.println("Text: " + msg.getText());
        }
	}
}
