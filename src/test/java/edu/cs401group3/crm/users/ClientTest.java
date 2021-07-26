package edu.cs401group3.crm.users;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.cs401group3.crm.objects.Client;

class ClientTest {
	
	// Creating a new customer.
	@Test
	void testCreateClient() {
		Client tempClient  = new Client("harman0099", "1234r3h", "Harman","510-000-0001", "harman@gmail.com", "Service", "0000");
		System.out.println(tempClient.toString()); // Command-line verification 
		
		boolean mod = false;
		// Condition checks if the information matches with mutators.
		if(tempClient.getClientUsername().equals("harman0099") && tempClient.getClientPassword().equals("1234r3h") && tempClient.getClientName().equals("Harman") && tempClient.getClientPhone().equals("510-000-0001")
				&& tempClient.getClientEmail().equals("harman@gmail.com") && tempClient.getClientCompany().equals("Service") && tempClient.getClientCompanyNumber().equals("0000"))  {	
			mod = true;
		}
		
		assertTrue(mod);
	}
	
	
	
	// Is each manual check required for a mutator?
	@Test
	void testsetClientName() {
		Client newClient = new Client();
		newClient.setClientName("Harman");
		System.out.println(newClient.getClientName());  // Command-line verification 
		
		boolean mod = false;
		if(newClient.getClientName().equals("Harman")) {
			mod = true;
		}
		assertTrue(mod);
	}

	
	
	
}
