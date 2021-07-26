package edu.cs401group3.crm.server.clienthandler;

import java.util.Map;

import edu.cs401group3.crm.commands.user.User;
import edu.cs401group3.crm.common.message.AuthenticationMessage;

public class auth {
	public auth() {}
	public static boolean check(AuthenticationMessage msg) {
		Object uname,upws_hashed;
		Map<String, Object> content;
		content=msg.getContent();
		uname=content.get("user");
		upws_hashed=content.get("password");
		User user = (User) msg.getContent().get("user");
		if(upws_hashed==user.Getpassword()) {
			return true;
		}
		return false;
		
	}
}
