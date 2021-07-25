import java.util.Scanner;
import java.util.*;

// No need of linked-list of Client def.

public class Client {
	
	// Default variables...
	private String clientUsername;
	private String clientPassword;
	// private String clientRole; (obsolete)
	private String clientName;
	private String clientPhone;
	private String clientEmail;
	private String clientCompanyName;
	private String clientCompanyNumber; // Phone.java potentially.
	
	
	// Default constructor
	public Client() {
		this.clientUsername = "DEFAULT";
		this.clientPassword = "DEFAULT";
		this.clientName = "DEFAULT";
		this.clientPhone = "DEFAULT";
		this.clientEmail = "DEFAULT";
		this.clientCompanyName = "DEFAULT";
	}
	
	
	// Should deal with the setters...
	public Client(String CUser, String CPass, String CName, String CPhone, String CEmail, String CCompName, String CCompNum) {
		this.clientUsername = CUser;
		this.clientPassword = CPass;
		this.clientName = CName;
		this.clientPhone = CPhone;
		this.clientEmail = CEmail;
		// Depending on the extends class, these will be defined as null.
		this.clientCompanyName = CCompName;
		this.clientCompanyNumber = CCompNum;
	}
	
	
	/**
	* Mutators for setters, which will set the appropriate information for the Customer user.
	* @param Must have the correct data type of String. (CName, CPhone, CEmail, CCompName, and CCompNum)
	* @return No return.
	*/
	public void setClientName(String CName) {
		this.clientName = CName;
	}
	public void setClientPhone(String CPhone) {
		this.clientPhone = CPhone;
	}
	public void setClientEmail(String CEmail) {
		this.clientEmail = CEmail;
	}
	public void setClientCompany(String CCompName) {
		this.clientCompanyName = CCompName;
	}
	public void setClientCompanyNumber(String CCompNum) {
		this.clientCompanyNumber = CCompNum;
	}
	public void setClientUsername(String CUser) {
		this.clientUsername = CUser;
	}
	public void setClientPassword(String CPass) {
		this.clientPassword = CPass;
	}
	
	
	/**
	* Mutators for getters, which will set the appropriate information for the Customer user.
	* @param New variable holder must match the return data type. 
	* @return Returns the appropriate data to the client.
	*/
	public String getClientName() {
		return clientName;
	}
	public String getClientPhone() {
		return clientPhone;
	}
	public String getClientEmail() {
		return clientEmail;
	}
	public String getClientCompany() {
		return clientCompanyName;
	}
	public String getClientCompanyNumber() {
		return clientCompanyNumber;
	}
	public String getClientUsername() {
		return clientUsername;
	}
	public String getClientPassword() {
		return clientPassword;
	}
	
	/**
	* Override function for the GUI
	* @return Returns the String for the customer information.
	*/
	@Override
	public String toString() {
		String temp = " NEW CUSTOMER CREATED! " + "\n\n Confirmation Reciept: ";
		temp += "\n Username: " + clientUsername +"\n Name: " + clientName + "\n Email: " + clientEmail  + "\n Phone: " + clientPhone;
		return temp;
	}
	
	
	
	
	
	/**
	* Will proceed the login authentication of the login functionality. 
	* @param Passing string values through username and password. 
	* @return No return.
	*/
	public void Login(String CUser, String CPass) {
		
	}
	
	/**
	* Will proceed the login authentication of the login functionality. 
	* @param Passing string values through username and password. 
	* @return No return.
	*/
	public void Search() {
		
	}
	
	/**
	* Will proceed the login authentication of the login functionality. 
	* @param Passing string values through username and password. 
	* @return No return.
	*/
	public void addRecord() {
		
	}

}
