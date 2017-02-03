package com.cookbook03.string.and.things;

import java.util.StringTokenizer;

public class StringTokenizerDemo3 {

	public final static int MAXFIELDS = 5;
	public final static String DELIM = "|";
	
	// Should be a JUnit test but is referred to in the book text,
	// so I can't move it to "tests" until the next edit.
	public static void main(String[] args) {
		printResults("A|B|C|D", process("A|B|C|D"));
		printResults("A||C|D", process("A||C|D"));
		printResults("A|||D|E", process("A|||D|E"));
	}

	/** Processes one String, returns it as an array of Strings */
	public static String[] process(String line) {
		String[] results = new String[MAXFIELDS];

		// Unless you ask StringTokenizer to give you the tokens,
		// it silently discards multiple null tokens.
		StringTokenizer st = new StringTokenizer(line, DELIM, true);

		int i = 0;
		// stuff each token into the current slot in the array.
		while (st.hasMoreTokens()) {
			String s = st.nextToken();
			if (s.equals(DELIM)) {
				if (i++ >= MAXFIELDS)
					throw new IllegalArgumentException("Input line " + line + " has too many fields");
				continue;
			}
			results[i] = s;
		}
		return results;
	}

	public static void printResults(String input, String[] outputs) {
		System.out.println("Input: " + input);
		for (String s : outputs)
			System.out.println("Output " + s + " was: " + s);
	}

}
