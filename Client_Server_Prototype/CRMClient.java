import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.io.IOException;


public class CRMClient {
    private String host;
    private String user;
    private String pass;
    private int port;

    public CRMClient(String host, int port, String user, String pass) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.pass = pass;
    }

    public boolean login() throws IOException {
        Scanner sc = new Scanner(System.in); //System.in is a standard input stream.
        // host = "localhost";
        // port = 7777;
        Socket socket = null;
        Message msg;
        String reply = "";
                
        try {
            socket = new Socket(host, port);
            System.out.println("Connected to " + host + ":" + port);
    
                // Output stream socket.
            OutputStream outputStream = socket.getOutputStream();

            // Create object output stream from the output stream to send an object through it
            ObjectOutput objectOutputStream = new ObjectOutputStream(outputStream);

            // get the input stream from the connected socket
            InputStream inputStream = socket.getInputStream();

            // create a ObjectInputStream so we can read data from it.
            ObjectInput objectInputStream = new ObjectInputStream(inputStream);

            msg = new Message("User: " + user + "\n" + "Password: " + pass);
            objectOutputStream.writeObject(msg);
            Message msgReply = (Message) objectInputStream.readObject();
            reply = msgReply.getText();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("Closing socket");
            sc.close();
            socket.close();
        }
        if (reply.equals("okay"))
            return true;
        else
            return false;
    }


    public void session() throws IOException {
        Scanner sc = new Scanner(System.in); //System.in is a standard input stream.
        // host = "localhost";
        // port = 7777;
        Socket socket = null;
        Message msg;
        
        System.out.print("Enter message info. <enter> to quit\n");
        
        try {
            socket = new Socket(host, port);
            System.out.println("Connected to " + host + ":" + port);
    
                // Output stream socket.
            OutputStream outputStream = socket.getOutputStream();

            // Create object output stream from the output stream to send an object through it
            ObjectOutput objectOutputStream = new ObjectOutputStream(outputStream);

            // get the input stream from the connected socket
            InputStream inputStream = socket.getInputStream();

            // create a ObjectInputStream so we can read data from it.
            ObjectInput objectInputStream = new ObjectInputStream(inputStream);

            msg = new Message("User: " + user + "\n" + "Password: " + pass);
            objectOutputStream.writeObject(msg);

            

            while (true) {
                msg = new Message(sc.next());
                System.out.println("Sending Message Objects");
                objectOutputStream.writeObject(msg);

                Message reply = (Message) objectInputStream.readObject();
                System.out.println(objectInputStream.available());
                printMessage(reply);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("Closing socket");
            socket.close();
            sc.close();
        }
    }

    private static void printMessage(Message msg) {
        System.out.println("ID: " + msg.getID());
        System.out.println("Type: " + msg.getType());
        System.out.println("Text: " + msg.getText());
    }
    
}
