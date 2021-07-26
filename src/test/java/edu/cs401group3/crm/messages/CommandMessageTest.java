package edu.cs401group3.crm.messages;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.Test;

import edu.cs401group3.crm.commands.Commands;
import edu.cs401group3.crm.common.message.AuthenticationMessage;
import edu.cs401group3.crm.common.message.CommandMessage;

public class CommandMessageTest {

	@Test
	public void CommandMessageTestGetType() {
		CommandMessage msg = new CommandMessage(Commands.DUMMY_COMMAND, null);
		assertEquals(msg.getType(), "command");	
	}
	
	@Test
	public void CommandMessageTestSetGetStatus() {
		CommandMessage msg = new CommandMessage(Commands.DUMMY_COMMAND, null);
		assertEquals(msg.getStatus(), "pending");
		
		msg.setStatus("accepted");
		assertEquals(msg.getStatus(),"accepted"); 	
	}
	
	@Test
	public void CommandMessageTestCommandSetAddUser() {
		CommandMessage msg = new CommandMessage(Commands.ADD_USER, null);
		assertEquals(msg.getCommand(), Commands.ADD_USER);
		assertEquals(msg.getCommandName(), "ADD_USER");
	}
	
	@Test
	public void CommandMessageTestCommandSetDeleteUser() {
		CommandMessage msg = new CommandMessage(Commands.DELETE_USER, null);
		assertEquals(msg.getCommand(), Commands.DELETE_USER);
		assertEquals(msg.getCommandName(), "DELETE_USER");
	}
		
	@Test
	public void CommandMessageTestCommandSetEditUser() {
		CommandMessage msg = new CommandMessage(Commands.EDIT_USER, null);
		assertEquals(msg.getCommand(), Commands.EDIT_USER);
		assertEquals(msg.getCommandName(), "EDIT_USER");
	}
	
	@Test
	public void CommandMessageTestSetContent() {
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
	public void CommandMessageTestGetContent() {
		Map<String, Object> content = new HashMap<String, Object>();
		content.put("key", "value");
		
		AuthenticationMessage msg = new AuthenticationMessage(content);
		
		Map<String, Object> cntns = msg.getContent();

		for (Map.Entry<String, Object> entry: cntns.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();

			assertEquals(key, "key");
		    assertEquals(value.toString(), "value");
		}
	}
	
	@Test
	public void CommandMessageTestRandomCommand() {
		int size = Commands.values().length;
		int item = new Random().nextInt(size);
		Commands command = Commands.values()[item];
		CommandMessage msg = new CommandMessage(command, null);
		assertEquals(command, msg.getCommand());		
	}
}
