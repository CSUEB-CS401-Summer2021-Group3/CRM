package edu.cs401group3.crm.messages;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import edu.cs401group3.crm.common.message.AuthenticationMessage;

public class AuthenticationMessageTest {

	@Test
	public void AuthenticationMessageTestType() {
		AuthenticationMessage msg = new AuthenticationMessage(null, null);
		assertEquals(msg.getType(), "authentication");	
	}
	
	@Test
	public void AuthenticationMessageTestSetGetStatus() {
		AuthenticationMessage msg = new AuthenticationMessage(null, null);
		assertEquals(msg.getStatus(), "pending");
		
		msg.setStatus("accepted");
		assertEquals(msg.getStatus(),"accepted"); 	
	}

	@Test
	public void AuthenticationMessageTestSetContent() {
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
	public void AuthenticationMessageTestGetContent() {
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
