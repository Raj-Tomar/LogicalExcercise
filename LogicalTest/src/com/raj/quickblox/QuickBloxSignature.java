package com.raj.quickblox;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Formatter;
import java.util.Random;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class QuickBloxSignature {
	private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
	
	final static String appId = "39492";
	final static String authKey = "3-4grVGyFMD3dPD";
	final static String authSecret = "JmgPtJsYv4RtgyG";

	public static void main(String[] args){
		long timestamp = System.currentTimeMillis()/1000;
		int nonce = new Random().nextInt();

		// Creating message where parameters are sorted by alphabetical order.
		String message = "application_id=" + appId + "&auth_key=" + authKey + "&nonce=" + nonce + "&timestamp=" + timestamp;
		String secret = authSecret;

		String hmac = null;
		try {
			hmac = calculateRFC2104HMAC(message, secret);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (SignatureException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		System.out.println(timestamp);
		System.out.println(nonce);
		System.out.println(hmac);
	} 
	

	@SuppressWarnings("resource")
	private static String toHexString(byte[] bytes) {
		Formatter formatter = new Formatter();
		
		for (byte b : bytes) {
			formatter.format("%02x", b);
		}

		return formatter.toString();
	}

	public static String calculateRFC2104HMAC(String data, String key)
		throws SignatureException, NoSuchAlgorithmException, InvalidKeyException
	{
		SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);
		Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
		mac.init(signingKey);
		return toHexString(mac.doFinal(data.getBytes()));
	}
}
