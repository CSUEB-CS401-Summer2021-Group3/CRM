package edu.cs401group3.crm.messages;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import edu.cs401group3.crm.common.message.AuthenticationMessage;

class AuthenticationMessageTest {

	@Test
	void AuthenticationMessageValidateType() {
		AuthenticationMessage msg = new AuthenticationMessage(null, null);
		assertEquals(msg.getType(), "authentication");	
	}
	
	@Test
	void AuthenticationMessageValidateSetGetStatus() {
		AuthenticationMessage msg = new AuthenticationMessage(null, null);
		assertEquals(msg.getStatus(), "pending");
		
		msg.setStatus("accepted");
		assertEquals(msg.getStatus(),"accepted"); 	
	}

	@Test
	void AuthenticationMessageValidateSetContent() {
		Map<String, Object> content = new HashMap<String, Object>();
		content.put("key", "value");
		
		AuthenticationMessage msg = new AuthenticationMessage(null, null);
		
		msg.setContent(content);
		
		for (Map.Entry<String, Object> entry: msg.getContent().entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();

			assertEquals(key, "key");
		    assertEquals(value.toString(), "value");
		}
	}

	@Test
	void AuthenticationMessageValidateGetContent() {
		Map<String, Object> content = new HashMap<String, Object>();
		content.put("key", "value");
		
		AuthenticationMessage msg = new AuthenticationMessage(content);

		Map<String, Object> cntns = msg.getContent();

		for (Map.Entry<String, Object> entry: cntns.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();

			assertEquals(key, "key");
		    assertEquals(value.toString(), "value");
		}
	}
}
