package edu.cs401group3.crm.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {
	private String ciphertext;
	public SHA256() {}
	public SHA256(String plaintext) {
		getSHA256(plaintext);		
	}
	private void getSHA256(String str){
	      MessageDigest messageDigest;
	     String encodestr = "";
	     try {
	      messageDigest = MessageDigest.getInstance("SHA-256");
	      messageDigest.update(str.getBytes("UTF-8"));
	      encodestr = byte2Hex(messageDigest.digest());
	     } catch (NoSuchAlgorithmException e) {
	      e.printStackTrace();
	     } catch (UnsupportedEncodingException e) {
	      e.printStackTrace();
	     }
	     ciphertext= encodestr;
	    }
	
	private static String byte2Hex(byte[] bytes){
	     StringBuffer stringBuffer = new StringBuffer();
	     String temp = null;
	     for (int i=0;i<bytes.length;i++){
	      temp = Integer.toHexString(bytes[i] & 0xFF);
	      if (temp.length()==1){	      
	    	  stringBuffer.append("0");
	      }
	      stringBuffer.append(temp);
	     }
	     return stringBuffer.toString();
	    }
	public String getSHA() {
		return ciphertext;
	}
}