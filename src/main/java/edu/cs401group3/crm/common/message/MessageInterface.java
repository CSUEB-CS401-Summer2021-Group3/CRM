package edu.cs401group3.crm.common.message;

import java.util.Map;

public interface MessageInterface {	
	String getType();
	
	void setStatus(String status);
	
	String getStatus();
	
	void setContent(Map<String, Object> content);
	
	Map<String, Object> getContent();
	
	
}
