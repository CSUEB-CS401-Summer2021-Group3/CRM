package edu.cs401group3.crm.objects;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.cs401group3.crm.objects.Manager;

class ManagerTest {
	
	@Test
	void testCreateManager() {
		Manager tempMan = new Manager();
		tempMan.setId(88888);
		tempMan.setClientUsername("Nick");
		tempMan.setRole("Founder");
		
		boolean mod = false;
		
		if(tempMan.getClientUsername().equals("Nick") && tempMan.getRole().equals("Founder")) {
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
