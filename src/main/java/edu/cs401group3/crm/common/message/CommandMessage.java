package edu.cs401group3.crm.common.message;

import java.io.Serializable;
import java.util.Map;

import edu.cs401group3.crm.commands.Commands;

/** CommandMessage Class.
 * Messages are passed between Client and Server using ObjectStream.<br>
 * 
 * A CommandMessage contains the command to be ran on the Server and any content required to run that command.
 * @author Nicholas Krone
*/
public class CommandMessage extends Message implements Serializable {
	private final String type = "command";
	private String status;
	private Commands command;
	
	/** Create new Command Message.<br>
	 * 
	 * Provided a Commands operation code and content, create a new CommandMessage for execution.
	 */
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
	
	/** Get Command.<br>
	 * Get the operation to execute.
	 * 
	 * @return A Commands enum
	 */
	public Commands getCommand() {
		return command;
	}

	/** Get Command Name.<br>
	 * Get the name of the operation to execute.<br>
	 * 
	 * @return A String representation of the command to execute.
	 */
	public String getCommandName() {
		return command.toString();
	}
}
