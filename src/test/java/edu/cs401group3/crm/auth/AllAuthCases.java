package edu.cs401group3.crm.auth;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.cs401group3.crm.common.SHA256;
import edu.cs401group3.crm.common.message.AuthenticationMessage;
import edu.cs401group3.crm.objects.User;
import edu.cs401group3.crm.server.clienthandler.auth;
import edu.cs401group3.crm.common.salt;

class AllAuthCases {

	
	
	@Test
	void Authtest() {
		User user= new User();
		Map<String, Object> credentials=new HashMap<String, Object>();
		AuthenticationMessage authmsg=new AuthenticationMessage(credentials);
		
		Scanner scanner;
		scanner = new Scanner(System.in);
		Object uname,upass;
		
		System.out.println("User name should be Tom");
		System.out.println("Password should be 123");
		//Creat a user Tom
		user.setClientUsername("Tom");
		user.Setpassword("123");
		
		//Let the user Enter his/her username and passowrd
		System.out.println("Enter the user name:");
		uname=scanner.nextLine();		
		System.out.println("Enter the user password:");
		upass=scanner.nextLine();
		//put the informations into authmessage class
		credentials.put("username", uname);
		credentials.put("password", upass);
		credentials.put("user", user);
		authmsg.setContent(credentials);
		
		if(auth.check(authmsg)) {
			System.out.println("Success!");
		}
		else {
			System.out.println("Wrong passowrd or username!");
		}
		
	    assertEquals(true,auth.check(authmsg));

	}
	
	@Test
	void SHA256_test() {
		String input;
		System.out.println("Enter A String,we will find it's SHA256");
		System.out.println("String 123 in SHA256 is a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3");
		Scanner scanner;
		scanner = new Scanner(System.in);
		input=scanner.nextLine();
		System.out.println("Your String in SHA256 is :");
		System.out.println(new SHA256(input).getSHA());
		assertEquals("a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3",new SHA256(input).getSHA());
	}
	
	@Test
	void salt_test() {
		salt Salt=new salt();
		System.out.println("Will creat 3 salt to see if they are random");
		for (int i=0;i<3;i++) {
		System.out.println(Salt.getsalt());
		}
	}
}
