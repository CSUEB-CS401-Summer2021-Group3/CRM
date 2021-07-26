package edu.cs401group3.crm.users;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import edu.cs401group3.crm.objects.User;

class UserTest {
	
	// Creating a new sales user.
	@Test
	void testCreateUser() {
		User tempUser = new User();
		tempUser.setClientName("Harman");
		tempUser.setId(9999);
		tempUser.setRole("Founder");
		tempUser.setManagerName("Chris");
		System.out.println(tempUser.toString()); // Manually verify
		
		int holder = tempUser.getId();
		boolean mod = false;
		
		if(holder == 9999 && tempUser.getRole().equals("Founder") && tempUser.getManagerName().equals("Chris")) {
			mod = true;
		}
		assertTrue(mod);
	}
	
	
	// Is each manual check required for a mutator?
	@Test
	void testSetIdUser() {
		User anotherUser = new User();
		anotherUser.setId(12345);
		boolean mod = false;

		if(anotherUser.getId() == (12345)) {
			mod = true;
		}
		assertTrue(mod);
	}

}
