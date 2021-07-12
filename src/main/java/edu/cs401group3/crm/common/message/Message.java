package edu.cs401group3.crm.common.message;

import java.util.Map;

public interface Message {	
	String getType();
	
	void setStatus(String status);
	
	String getStatus();
	
	void setContent(Map<String, String> content);
	
	Map<String, String> getContent();
	
	
}
