package edu.cs401group3.crm.common.message;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationMessage extends Message implements Serializable{
	private final String type = "authentication";
	private String status;
	Map<String, Object> credentials;
	
	public AuthenticationMessage(String username, String password) {
		credentials = new HashMap<String, Object>();
		credentials.put("username", username);
		credentials.put("password", password);//not really password it's password+salt get hashed
		status = "pending";
	}
	
	public AuthenticationMessage(Map<String, Object> credentials) {
		this.credentials = credentials;
		status = "pending";
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getStatus() {
		return status;
	}

	@Override
	public void setContent(Map<String, Object> credentials) {
		this.credentials = credentials;
	}

	@Override
	public Map<String, Object> getContent() {
		return credentials;
	}

}
