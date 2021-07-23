package edu.cs401group3.crm.common.message;

import java.io.Serializable;
import java.util.Map;

import edu.cs401group3.crm.commands.Commands;

public class CommandMessage extends Message implements Serializable {
	private final String type = "command";
	private String status;
	private Commands command;
	
	public CommandMessage(Commands command, Map<String, Object> content) {
		this.command = command;
		this.content = content;
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
		this.content = content;
	}

	@Override
	public Map<String, Object> getContent() {
		return content;
	}
	
	public Commands getCommand() {
		return command;
	}
	
	public String getCommandName() {
		return command.toString();
	}
}
