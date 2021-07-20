package edu.cs401group3.crm.common.message;

import java.io.Serializable;
import java.util.Map;

public class Message implements MessageInterface, Serializable{
	private String type;
	private String status;
	private Map<String, String> content;
	
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setStatus(String status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setContent(Map<String, String> content) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, String> getContent() {
		// TODO Auto-generated method stub
		return null;
	}

}
