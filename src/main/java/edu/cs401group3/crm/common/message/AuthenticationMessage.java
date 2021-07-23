package edu.cs401group3.crm.common.message;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationMessage extends Message implements Serializable{
	private final String type = "authentication";

	public AuthenticationMessage(String username, String password) {
		content = new HashMap<String, Object>();
		content.put("username", username);
		content.put("password", password);
		status = "pending";
	}
	
	public AuthenticationMessage(Map<String, Object> content) {
		this.content = content;
		status = "pending";
	}
}
