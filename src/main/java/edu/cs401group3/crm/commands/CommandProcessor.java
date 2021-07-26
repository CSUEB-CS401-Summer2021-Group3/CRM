package edu.cs401group3.crm.commands;

import edu.cs401group3.crm.commands.user.AddUser;
import edu.cs401group3.crm.commands.user.DeleteUser;
import edu.cs401group3.crm.commands.user.EditUser;
import edu.cs401group3.crm.commands.user.User;
import edu.cs401group3.crm.common.message.CommandMessage;
import edu.cs401group3.crm.common.Log;


public class CommandProcessor {
 
	public void processCommand(CommandMessage message) {
		Commands command = message.getCommand();
		switch (command) {
			case ADD_USER: 
				Log.LOGGER.info("ComProc: Add"); 
				Log.LOGGER.info(message.getContent().get("user").toString());
				AddUser add = new AddUser((User) message.getContent().get("user"));
				add.execute();
				break;
			case DELETE_USER:
				Log.LOGGER.info("ComProc: Delete"); 
				Log.LOGGER.info(message.getContent().get("user").toString());
				DeleteUser delete = new DeleteUser((User) message.getContent().get("user"));
				delete.execute();
				break;
			case EDIT_USER:
				Log.LOGGER.info("ComProc: Edit"); 
				Log.LOGGER.info(message.getContent().get("user").toString());
				EditUser edit = new EditUser((User) message.getContent().get("user"));
				edit.execute();
				break;
			
			case ADD_CLIENT: break;
			case DELETE_CLIENT: break;
			case EDIT_CLIENT: break;
			
			case ADD_RECORD: break;
			case DELETE_RECORD: break;
			case EDIT_RECORD: break;
			
			case ADD_GROUP: break;
			case DELETE_GROUP: break;
			case EDIT_GROUP: break;
			
			case IMPORT: break;
			case EXPORT: break;
			case SAVE: break;
		default:
			break;
		}
	}
}
