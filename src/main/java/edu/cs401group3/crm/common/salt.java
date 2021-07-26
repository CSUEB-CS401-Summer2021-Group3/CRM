package edu.cs401group3.crm.common;

import java.security.SecureRandom;


public class salt {
	public static final String ch="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private static String salt;
	private static void Salt() {}
    public String getsalt() {
    	SecureRandom random=new SecureRandom();
		int length=12;
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = ch.charAt(random.nextInt(ch.length()));
        }
        salt= new String(text);
    	return salt;
    }
}