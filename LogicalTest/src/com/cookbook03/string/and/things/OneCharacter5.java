package com.cookbook03.string.and.things;

public class OneCharacter5 {

	public static void main(String[] args) {
		//strCharAt();
		forEachChar();
	}

	public static void strCharAt() {
		String a = "A quick bronze fox lept a lazy bovine";
		for (int i = 0; i < a.length(); i++) // Don't use foreach
			System.out.println("Char " + i + " is " + a.charAt(i));

	}

	public static void forEachChar() {
		String s = "Hello world";
		// for (char ch : s) {...} Does not work, in Java 7
		for (char ch : s.toCharArray()) {
			System.out.println(ch);
		}

	}
}
