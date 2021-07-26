package edu.cs401group3.crm.commands.user;

import java.io.Serializable;

//User stub
//TODO - Remove when User implementation is completed (issue 4)
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String status;
	private String data;
	private String salt;
	private String password;
	
	public User(String name) {
		this.name = name;
		this.status = "not logged in";
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getData() {
		return data;
	}
	public void Setsalt(String nsalt) {
		this.salt=nsalt;
	}
	public String Getsalt(){
		return this.salt;
	}
	public void Setpassword(String npassword) {
		this.password=npassword;
	}
	public String Getpassword(){
		return this.password;
	}
	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
