import java.util.Scanner;
import java.util.*;


// Manager extends the functionality like User.
public class Manager extends User{
	
	// Constructor
	public Manager(int managerID, String managerRole, String managerManager, String username, String password, String managerName, String managerPhone, String managerEmail) {
		// Logic: Manager can have a manager as well...
		// Similar to the User class, there is not reason for Company information to be stored.
		super(managerID, managerRole, managerManager, username, password, managerName, managerPhone, managerEmail);
	}
	
	
	// Additional functionality for the Manager role.
	
	/**
	* Description:
	* @parma  
	* @return No return.
	*/
	

	public void editUser() {
		
	}
	
	public void importData() {
		
	}
	
	public void exportData() {
		
	}
	
	public void save() {
		
	}
	
}
