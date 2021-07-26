package edu.cs401group3.crm.objects;

import edu.cs401group3.crm.common.message.CommandMessage;
import edu.cs401group3.crm.common.Log;

import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.security.*;


// Sales class extends the capability of the Client class.
public class User extends Client{
	
	// Client class has similar variables, here are the new additions. 
	private int id;
	private String role;
	private String salesManager; // Since each client has a manager. 
	private static String internalPasswordSalt; // Temp
	private String salt;
	
	// Each Sales class should the option to do CRUD applications to their Client list.
	// Linked List approach...
	LinkedList<User> clientList = new LinkedList<>();
	
	// Default constructor
	public User() {
		this.id = 0000;
		this.role = "TEMP EMPLOYEE";
		this.role = "ADMIN";
	}
	//password is get hashed with salt
	public User(int userID, String userRole, String userMan, String username, String password, String userName, String userPhone, String userEmail) {
		// Certain information is not required for a Sales person, hence manually inputted null.
		super(username, password, userName, userPhone, userEmail, null, null);
		
		// New variables
		this.id = userID;
		this.role = userRole;
		this.salesManager = userMan;	
	}

	/**
	* Mutators for setters, which will set the appropriate information for the Sales user.
	* @param Must have the appropriate and valid data types. Integer for num and String for m and r.
	* @return No return.
	*/
	public void setId(int num) {
		// Implementation of a random number for the ID...
		this.id = num;
	}
	public void setRole(String r) {
		this.role = r;
	}
	public void setManagerName(String m) {
		this.salesManager = m;
	}
	public void setInternalPassword(String password){
		this.internalPasswordSalt = saltPassword(password);
	}


	
	/**
	* Mutators for getters, which will return the appropriate Sales user.
	* @param New variable holder must match the return data type. 
	* @return Returns the appropriate data to the user.
	*/
	public int getId() {
		return id;
	}
	public String getRole(){
		return role;
	}
	public String getManagerName() {
		return salesManager;
	}
	
	/**
	* Override function for the GUI
	* @return Returns the String for the sales class information.
	*/
	@Override
	public String toString() {
		String temp = " NEW SALES USER CREATED!" + "\n\n Confirmation Reciept: ";
		temp += "\n ID: " + id + "\n Role: " + role + "\n Manager: " + salesManager;
		return temp;
	}
	

	/**
	* Creates a password hash for the clientPassword in order to interact with the our Authentication model.
	* @param Pass in password string information, saves updated hash data.
	* @return No return.
	*/
	public static String saltPassword(String CPass) {
		MessageDigest md;
		
		try {
			// Hash computation
			// SHA-256 is a secure hash algo
			md = MessageDigest.getInstance("SHA-256");
			SecureRandom tempRand = new SecureRandom();
			
			byte[] salt = new byte[16];
			tempRand.nextBytes(salt);
			// Update on the server-side
			md.update(salt);
			byte[] hased = md.digest(CPass.getBytes(StandardCharsets.UTF_8));
			StringBuilder sb = new StringBuilder();
			
			for(byte i : hased)
				sb.append(String.format("%02x", i));
				internalPasswordSalt = sb.toString(); // Stores client data
				return internalPasswordSalt;

		}catch (Exception e) {
			System.out.println("NOT SUCCESSFUL. TRY AGAIN.");
		}

		return internalPasswordSalt;
	
	}





















	// Sales additional functionality. 
	// Would it require a linked-list approach?
	
	
	
	/**
	* Mutators for getters, which will return the appropriate Sales user.
	* @param New variable holder must match the return data type. 
	* @return Returns the appropriate data to the user.
	*/
	public void addClient(){
		CommandMessage tempCommand;
		

		
	}
	public void Setsalt(String nsalt) {
		this.salt=nsalt;
	}
	public String Getsalt(){
		return this.salt;
	}
	public String Getpassword() {
		return this.internalPasswordSalt;
	}
	public void editClient() {
		
	}
	public void removeClient() {
		
	}
	
	public void addRecord() {
		
	}
	public void editRecord() {
		
	}
	public void removeRecord() {
		
	}
	
	public void addGroup() {
		
	}
	public void editGroup() {
		
	}
	public void removeGroup() {
		
	}
	
   
}