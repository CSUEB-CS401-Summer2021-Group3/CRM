package edu.cs401group3.crm.messages;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.jupiter.api.Test;

import edu.cs401group3.crm.commands.Commands;
import edu.cs401group3.crm.common.message.CommandMessage;

class CommandMessageTest {

	@Test
	void CommandMessageValidateType() {
		CommandMessage msg = new CommandMessage(Commands.DUMMY_COMMAND, null);
		assertEquals(msg.getType(), "command");	
	}
	
	@Test
	void CommandMessageValidateSetGetStatus() {
		CommandMessage msg = new CommandMessage(Commands.DUMMY_COMMAND, null);
		assertEquals(msg.getStatus(), "pending");
		
		msg.setStatus("accepted");
		assertEquals(msg.getStatus(),"accepted"); 	
	}
	
	@Test
	void CommandMessageValidateCommandSetAddUser() {
		CommandMessage msg = new CommandMessage(Commands.ADD_USER, null);
		assertEquals(msg.getCommand(), Commands.ADD_USER);
		assertEquals(msg.getCommandName(), "ADD_USER");
	}
	
	@Test
	void CommandMessageValidateCommandSetDeleteUser() {
		CommandMessage msg = new CommandMessage(Commands.DELETE_USER, null);
		assertEquals(msg.getCommand(), Commands.DELETE_USER);
		assertEquals(msg.getCommandName(), "DELETE_USER");
	}
		
	@Test
	void CommandMessageValidateCommandSetEditUser() {
		CommandMessage msg = new CommandMessage(Commands.EDIT_USER, null);
		assertEquals(msg.getCommand(), Commands.EDIT_USER);
		assertEquals(msg.getCommandName(), "EDIT_USER");
	}
	
	@Test
	void CommandMessageValidateSetContent() {
		Map<String, Object> content = new HashMap<String, Object>();
		content.put("key", "value");
		
		CommandMessage msg = new CommandMessage(Commands.DUMMY_COMMAND, null);
		
		msg.setContent(content);
		
		for (Map.Entry<String, Object> entry: msg.getContent().entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();

			assertEquals(key, "key");
		    assertEquals(value.toString(), "value");
		}
		
	}
	
	@Test
	void CommandMessageValidateRandomCommand() {
		int size = Commands.values().length;
		int item = new Random().nextInt(size);
		Commands command = Commands.values()[item];
		CommandMessage msg = new CommandMessage(command, null);
		assertEquals(command, msg.getCommand());		
	}
}
