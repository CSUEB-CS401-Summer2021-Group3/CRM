package edu.cs401group3.crm.commands;

/** Command Interface.
 * 
 * Commands are executed by the CommandProcessor. Using the Command pattern, each action is contained as an executable class. 
 * @author Nicholas Krone
*/
public interface CommandInterface {

	void execute();
}
