package edu.cs401group3.crm.objects;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.cs401group3.crm.objects.Admin;

class AdminTest {

	@Test
	void testCreateManager() {
		Admin tempMan = new Admin();
		tempMan.setClientName("Maple");
		tempMan.setClientEmail("temp@gmail.com");
		boolean mod = false;
		
		if(tempMan.getClientEmail().equals("Maple") && tempMan.getClientEmail().equals("temp@gmail.com")) {
			mod = true;
		}
		
		System.out.println(tempMan.toString().toString());
		assertTrue(mod);
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
