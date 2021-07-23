package edu.cs401group3.crm.commands.user;

import edu.cs401group3.crm.commands.CommandInterface;

public class DeleteUser implements CommandInterface{
	private UserCommand userCommand;
	private User user;
	
	public DeleteUser(User user) {
		this.userCommand = new UserCommand();
		this.user = user;
	}
	
	@Override
	public void execute() {
		userCommand.deleteUser(user);
	}

}
