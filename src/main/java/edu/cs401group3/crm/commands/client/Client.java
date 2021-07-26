package edu.cs401group3.crm.commands.client;

import java.util.ArrayList;
import java.util.List;

//Client stub
//TODO - Remove when Client implementation is completed (issue 4)
public class Client {
	private String name;
	List<Record> recordList;
	
	public Client(String name) {
		this.name = name;
		recordList = new ArrayList<Record>();
	}
}
