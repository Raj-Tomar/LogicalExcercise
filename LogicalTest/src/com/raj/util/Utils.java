package com.raj.util;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

public class Utils {
	
	static final String randomString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
	public static void main(String[] args) {
		generateRandomPassword();
		randomString(6);
		passworGenerator();
	}
	
	public static String generateRandomPassword() {
		SecureRandom random = new SecureRandom();
		String uuid = UUID.randomUUID().toString();
		System.out.println("uuid = " + uuid);
		String uid = UUID.randomUUID().toString().replaceAll("-", "");
		System.out.println("uid = " + uid);
		String password = new BigInteger(30, random).toString(32);
		System.out.println("generateRandomPassword() : "+password);
		return password;
		/*
		This works by choosing 130 bits from a cryptographically secure random bit generator, 
		and encoding them in base-32. 
		128 bits is considered to be cryptographically strong, 
		but each digit in a base 32 number can encode 5 bits, 
		so 128 is rounded up to the next multiple of 5. 
		This encoding is compact and efficient, with 5 random bits per character. 
		Compare this to a random UUID, which only has 3.4 bits per character in standard layout, 
		and only 122 random bits in total.

		If you allow session identifiers to be easily guessable (too short, flawed random number generator, etc.), 
		attackers can hijack other's sessions. 
		Note that SecureRandom objects are expensive to initialize, so you'll want to keep one around and reuse it.

		Here is alternative code for cheap, insecure random alpha-numeric strings. You can tweak the "symbols" if you want to use more characters.
		*/
	}
	
	public static String randomString( int len ){
		SecureRandom rnd = new SecureRandom();
		StringBuilder sb = new StringBuilder( len );
		for( int i = 0; i < len; i++ ) 
			sb.append( randomString.charAt( rnd.nextInt(randomString.length()) ) );
		String randomString = sb.toString();
		System.out.println("randomString() : "+randomString);
		return randomString;
	}
	
	public static String passworGenerator() {
		final String dCase = "abcdefghijklmnopqrstuvwxyz";
	    final String uCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    final String sChar = "!@#$%&*";
	    final String intChar = "0123456789";
	    Random r = new Random();
	    String password = "";
	    
	    while (password.length () != 16){
            int rPick = r.nextInt(4);
            if (rPick == 0){
                int spot = r.nextInt(25);
                password += dCase.charAt(spot);
            } else if (rPick == 1) {
                int spot = r.nextInt (25);
                password += uCase.charAt(spot);
            } else if (rPick == 2) {
                int spot = r.nextInt (7);
                password += sChar.charAt(spot);
            } else if (rPick == 3){
                int spot = r.nextInt (9);
                password += intChar.charAt (spot);
            }
        }
        System.out.println ("passworGenerator() : " + password);
        return password;
	}
}
