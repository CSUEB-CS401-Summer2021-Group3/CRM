package edu.cs401group3.crm.common.message;

import java.util.Map;

public class CommandMessage implements Message {
	private final String type = "command";
	private String status;
	private Map<String, String> payload;
	
	public CommandMessage(Map<String, String> payload) {
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
	public void setContent(Map<String, String> content) {
		this.payload = content;
	}

	@Override
	public Map<String, String> getContent() {
		return payload;
	}

}
