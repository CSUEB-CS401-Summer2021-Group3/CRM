package edu.cs401group3.crm.common.message;

import java.io.Serializable;
import java.util.Map;

public class CommandMessage extends Message implements Serializable {
	private final String type = "command";
	private String status;
	private Map<String, Object> payload;
	
	public CommandMessage(Map<String, Object> payload) {
		this.payload= payload;
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
	public void setContent(Map<String, Object> content) {
		this.payload = content;
	}

	@Override
	public Map<String, Object> getContent() {
		return payload;
	}

}
