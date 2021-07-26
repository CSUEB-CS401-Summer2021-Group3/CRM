package edu.cs401group3.crm.common.message;

import java.io.Serializable;
import java.util.Map;

/** Message Class.
 * Messages are passed between Client and Server using ObjectStream.
 * 
 * Each Message serves a specific purpose and this interface establishes a contract for what a Message should implement.
 * @author Nicholas Krone
*/
public class Message implements MessageInterface, Serializable{
	private final String type = "generic";
	protected String status;
	protected Map<String, Object> content;
	
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
}
