package com.cookbook03.string.and.things;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class CheckSum6 {

	public static void main(String[] args) {
		
		final String fileName = "abc.txt";

		try {
			InputStream is = CheckSum6.class.getResourceAsStream(fileName);
			// wrap a BufferedReader around FileReader
			// BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			System.out.println("Sum : " + process(bufferedReader));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

	/**
	 * CheckSum one text file, given an open BufferedReader. 
	 * Checksum does not include line endings, 
	 * so will give the same value for given text on any platform. 
	 * Do not use on binary files!
	 */
	public static int process(BufferedReader is) {
		int sum = 0;
		try {
			String inputLine;
			while ((inputLine = is.readLine()) != null) {
				int i;
				for (i = 0; i < inputLine.length(); i++) {
					sum += inputLine.charAt(i);
				}
			}
		} catch (IOException e) {
			throw new RuntimeException("IOException: " + e);
		}
		return sum;
	}

}
