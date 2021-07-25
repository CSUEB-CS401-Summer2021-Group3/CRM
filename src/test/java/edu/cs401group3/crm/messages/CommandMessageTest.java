package edu.cs401group3.crm.messages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.cs401group3.crm.commands.Commands;
import edu.cs401group3.crm.common.message.CommandMessage;

class CommandMessageTest {

	@Test
	void CommandMessageValidateType() {
		CommandMessage msg = new CommandMessage(Commands.DUMMY_COMMAND, null);
		assert(msg.getType().equals("command"));	
	}
	
	@Test
	void CommandMessageValidateCommandSetAddUser() {
		CommandMessage msg = new CommandMessage(Commands.ADD_USER, null);
		assert(msg.getCommand() == Commands.ADD_USER);
		assert(msg.getCommandName().equals("ADD_USER"));
	}
	
	@Test
	void CommandMessageValidateCommandSetDeleteUser() {
		CommandMessage msg = new CommandMessage(Commands.DELETE_USER, null);
		assert(msg.getCommand() == Commands.DELETE_USER);
		assert(msg.getCommandName().equals("DELETE_USER"));
	}
		
	@Test
	void CommandMessageValidateCommandSetEditUser() {
		CommandMessage msg = new CommandMessage(Commands.EDIT_USER, null);
		assert(msg.getCommand() == Commands.EDIT_USER);
		assert(msg.getCommandName().equals("EDIT_USER"));
	}
}
