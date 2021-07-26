package edu.cs401group3.crm.common.message;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/** AuthenticationMessage Class.
 * Messages are passed between Client and Server using ObjectStream.<br>
 * 
 * An AuthenticationMessage is used for login and initial Client / Server communications.
 * @author Nicholas Krone
*/
public class AuthenticationMessage extends Message implements Serializable{
	private final String type = "authentication";
	private String status;
	Map<String, Object> credentials;
	
	/** Create a new AuthenticationMessage containing a username and password.
	 * 
	 * @param username A String representing the username of a User.
	 * @param password A String representing the password of a User.
	 */
	public AuthenticationMessage(String username, String password) {
		credentials = new HashMap<String, Object>();
		credentials.put("username", username);
		credentials.put("password", password);//not really password it's password+salt get hashed
		status = "pending";
	}

	/** Create a new AuthenticationMessage containing a payload.
	 * 
	 * @param credentials A Map containing the username and password already.
	 */
	public AuthenticationMessage(Map<String, Object> credentials) {
		this.credentials = credentials;
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
	public void setContent(Map<String, Object> credentials) {
		this.credentials = credentials;
	}

	@Override
	public Map<String, Object> getContent() {
		return credentials;
	}
}
