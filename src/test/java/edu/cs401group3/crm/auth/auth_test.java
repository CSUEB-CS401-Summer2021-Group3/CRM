package edu.cs401group3.crm.auth;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import edu.cs401group3.crm.common.message.*;
import edu.cs401group3.crm.server.clienthandler.*;
import edu.cs401group3.crm.objects.User;

import org.junit.jupiter.api.Test;

class auth_test {
	User user= new User();
	Map<String, Object> credentials=new HashMap<String, Object>();
	AuthenticationMessage authmsg=new AuthenticationMessage(credentials);
	
	@Test
	void test() {
		user.setInternalPassword("a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3");
		credentials.put("username", "Tom");
		credentials.put("password", "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3");
		credentials.put("user", user);
		assertEquals(true,auth.check(authmsg));
		
	}

}
