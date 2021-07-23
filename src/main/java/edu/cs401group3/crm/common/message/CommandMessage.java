package edu.cs401group3.crm.common.message;

import java.io.Serializable;
import java.util.Map;

import edu.cs401group3.crm.commands.Commands;

public class CommandMessage extends Message implements Serializable {
	private final String type = "command";
	private Commands command;
	
	public CommandMessage(Commands command, Map<String, Object> content) {
		this.command = command;
		this.content = content;
		status = "pending";
	}
}
