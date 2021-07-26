package edu.cs401group3.crm.server.clienthandler;

import java.util.Map;

import edu.cs401group3.crm.common.message.AuthenticationMessage;
import edu.cs401group3.crm.objects.User;

public class auth {
	public auth() {}
	public static boolean check(AuthenticationMessage msg) {
		User user = (User) msg.getContent().get("user");
		String uname=(String) msg.getContent().get("username");
		String upws_hashed=(String) msg.getContent().get("password");
		if(upws_hashed.equals(user.Getpassword())&&uname.equals(user.getClientUsername())) {
			return true;
		}
		else
		return false;
	}
}
