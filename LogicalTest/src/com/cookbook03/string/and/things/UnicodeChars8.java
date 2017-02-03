package com.cookbook03.string.and.things;

public class UnicodeChars8 {

	public static void main(String[] args) {
		StringBuffer b = new StringBuffer();
		for (char c = 'a'; c < 'd'; c++) {
			b.append(c);
		}
		b.append('\u00a5'); // Japanese Yen symbol
		b.append('\u01FC'); // Roman AE with acute accent
		b.append('\u0391'); // GREEK Capital Alpha
		b.append('\u03A9'); // GREEK Capital Omega
		for (int i = 0; i < b.length(); i++) {
			System.out.printf("Character #%d (%04x) is %c%n", i, 
					(int) b.charAt(i), b.charAt(i));
		}
		System.out.println("Accumulated characters are " + b);
	}
}
