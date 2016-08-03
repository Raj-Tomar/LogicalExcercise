package com.raj.string;

public class ReverseString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str = "raj";
		for(int i=str.length()-1; i>=0; i--){
			System.out.print(str.charAt(i));
		}
	}

}
