package edu.cs401group3.crm.client;

import java.security.SecureRandom;


public class salt {
	public static final String ra="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private static String salt;
	private static void Salt() {
		SecureRandom random=new SecureRandom();
		int length=random.nextInt(12);
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = ra.charAt(random.nextInt(ra.length()));
        }
        salt= String(text);
    

}
