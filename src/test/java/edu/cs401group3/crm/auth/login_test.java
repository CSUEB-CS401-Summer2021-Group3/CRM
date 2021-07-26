package edu.cs401group3.crm.auth;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import edu.cs401group3.crm.common.message.*;
import edu.cs401group3.crm.server.clienthandler.*;
import edu.cs401group3.crm.objects.User;
import org.junit.Test;


public class login_test {
	User user= new User();
	Map<String, Object> credentials=new HashMap<String, Object>();
	AuthenticationMessage authmsg=new AuthenticationMessage(credentials);
	
	@Test
	public void test() {
		Object uname,upass;
		
		System.out.println("User name should be Tom");
		System.out.println("Password should be 123");
		user.setClientUsername("Tom");
		user.Setpassword("123");
		uname="Tom";
		credentials.put("username", uname);
		upass="123";
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
}
