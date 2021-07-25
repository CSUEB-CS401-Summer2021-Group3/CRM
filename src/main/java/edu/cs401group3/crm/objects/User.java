import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;


// Sales class extends the capability of the Client class.
public class User extends Client{
	
	// Client class has similar variables, here are the new additions. 
	int id;
	String role;
	String salesManager; // Since each client has a manager. 
	
	// Each Sales class should the option to do CRUD applications to their Client list.
	// Linked List approach...
	LinkedList<User> clientList = new LinkedList<>();
	
	// Default constructor
	public User() {
		this.id = 0000;
		this.role = "TEMP EMPLOYEE";
		this.role = "ADMIN";
	}
	
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
	
	// Sales additional functionality. 
	// Would it require a linked-list approach?
	
	
	
	/**
	* Mutators for getters, which will return the appropriate Sales user.
	* @param New variable holder must match the return data type. 
	* @return Returns the appropriate data to the user.
	*/
	public void addClient() {
		
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