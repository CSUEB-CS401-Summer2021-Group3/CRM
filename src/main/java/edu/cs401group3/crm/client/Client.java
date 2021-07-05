package edu.cs401group3.crm.client;

import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private String address;
    private String port;
    private Socket socket;
    private Scanner scanner;

    OutputStream outputStream;
    ObjectOutput objectOutputStream;
    InputStream inputStream;
    ObjectInput objectInputStream;

    public Client() {}
    
    private Socket login() {
        scanner = new Scanner(System.in);
        
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
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        System.out.println("Connected to " + address + ":" + port);
        return socket;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client = new Client();
		client.login();

	}

}
