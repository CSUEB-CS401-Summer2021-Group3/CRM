package edu.cs401group3.crm.commands.user;

import edu.cs401group3.crm.commands.CommandInterface;

public class EditUser implements CommandInterface{
	private UserCommand userCommand;
	private User user;
	private User update;
	
	public EditUser(User user, User update) {
		this.userCommand = new UserCommand();
		this.user = user;
	}
	
	@Override
	public void execute() {
		userCommand.editUser(user);
	}

}
