package edu.cs401group3.crm.commands.user;

import edu.cs401group3.crm.commands.CommandInterface;

public class AddUser implements CommandInterface{
	private UserCommand userCommand;
	private User user;
	
	public AddUser(User user) {
		this.userCommand = new UserCommand();
		this.user = user;
	}
	
	@Override
	public void execute() {
		userCommand.addUser(user);
	}

}
