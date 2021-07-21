package edu.cs401group3.crm.client;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class saltTest {
	private salt test= new salt();
	@Test
	void test() {
		System.out.println(test.getsalt());
		
	}

}
