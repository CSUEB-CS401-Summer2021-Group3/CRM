package edu.cs401group3.crm.auth;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import edu.cs401group3.crm.commands.user.User;
import edu.cs401group3.crm.common.SHA256;
import edu.cs401group3.crm.common.message.AuthenticationMessage;
import edu.cs401group3.crm.server.clienthandler.auth;

class AuthTest {

	@Test
	void SHAtest() {
		assertEquals("a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3",new SHA256("123").getSHA());
	}
	
	@Test
	void Authtest() {
		//Set the informations
		User user= new User("Tom");
		Map<String, Object> credentials=new HashMap<String, Object>();
		AuthenticationMessage authmsg=new AuthenticationMessage(credentials);
		user.Setpassword("a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3");
		credentials.put("username", "Tom");
		credentials.put("password", "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3");
		credentials.put("user", user);
		//Check the information if matched
		assertEquals(true,auth.check(authmsg));
		
	}

}
