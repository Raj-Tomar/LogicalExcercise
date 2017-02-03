package com.cookbook03.string.and.things;

import java.util.StringTokenizer;

public class StringBuilderDemo4 {

	public static void main(String[] argv) {
		final String SAMPLE_STRING = "Hello World";
		String s1 = "Hello" + ", " + "World";
		System.out.println(s1);
		// Build a StringBuilder, and append some things to it.
		StringBuilder sb2 = new StringBuilder();
		sb2.append("Hello");
		sb2.append(',');
		sb2.append(' ');
		sb2.append("World");
		// Get the StringBuilder's value as a String, and print it.
		String s2 = sb2.toString();
		System.out.println(s2);
		// Now do the above all over again, but in a more
		// concise (and typical "real-world" Java) fashion.
		System.out.println(new StringBuilder().append("Hello").append(',').append(' ').append("World"));

		// Method using regexp split
		StringBuilder sb1 = new StringBuilder();
		for (String word : SAMPLE_STRING.split(" ")) {
			if (sb1.length() > 0) {
				sb1.append(", ");
			}
			sb1.append(word);
		}
		System.out.println(sb1);
		// Method using a StringTokenizer
		StringTokenizer st = new StringTokenizer(SAMPLE_STRING);
		StringBuilder sb = new StringBuilder();
		while (st.hasMoreElements()) {
			sb.append(st.nextToken());
			if (st.hasMoreElements()) {
				sb.append(", ");
			}
		}
		System.out.println(sb);
	}
}