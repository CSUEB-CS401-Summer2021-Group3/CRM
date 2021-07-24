package edu.cs401group3.crm.common.message;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationMessage extends Message implements Serializable{
	private final String type = "authentication";
	private String status;
	Map<String, String> credentials;
	
	public AuthenticationMessage(String user, String pws_hashed) {
		credentials = new HashMap<String, String>();
		credentials.put("user", user);
		credentials.put("pws_hashed", pws_hashed);
		status = "pending";
	}
	
	public AuthenticationMessage(Map<String, String> credentials) {
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
	public void setContent(Map<String, String> credentials) {
		this.credentials = credentials;
	}

	@Override
	public Map<String, String> getContent() {
		return credentials;
	}

}
