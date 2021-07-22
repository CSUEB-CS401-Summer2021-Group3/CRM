import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;



// Admin extends the functionality of the Client class.
public class Admin extends Client{
	
	Scanner sc = new Scanner(System.in);
	
	// Constructor
	public Admin(String adminUser, String adminPass, String adminName, String adminPhone, String adminEmail) {
		// Passed null for the company contact information.
		super(adminUser, adminPass, adminName, adminPhone, adminEmail, null, null);
	}
	
	
	
	
	// Admin extends Search(), addRecord(), and Login().
	// New functionality.
	
	/**
	* Description:
	* @parma  
	* @return No return.
	*/
	public void addUsers(){
		
		// Currently the method is focused on command-line interface...
		System.out.println("CREATING NEW PROFILE");
		
		// Must have an understanding of how to search if the sales client is already in our database...
		// Is there a need to look into each individual linked list?
		System.out.println("ENTER USERNAME: ");
		String tempUser = sc.nextLine();
		System.out.println("ENTER PASSWORD: ");
		String tempPass = sc.nextLine();
		// Successfully 
		
	}
	
	public void editUser() {
		
	}
	public void removeUser() {
		
	}
	// Not sure if this is required... 
	public void getUser() {
		
	}
	
}
