package com.cookbook04.pattern.matching.with.regular.expressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReaderIter6 {

	public static void main(String[] args) throws IOException {

		// The RE pattern
		Pattern patt = Pattern.compile("[A-Za-z][a-z]+");
		
		// A FileReader (see the I/O chapter)
		InputStream is = ReaderIter6.class.getResourceAsStream("RegxSyntax.txt");
		BufferedReader r = new BufferedReader(new InputStreamReader(is));
		
		//BufferedReader r = new BufferedReader(new FileReader(args[0]));

		// For each line of input, try matching in it.
		String line;
		while ((line = r.readLine()) != null) {
			// For each match in the line, extract and print it.
			Matcher m = patt.matcher(line);
			while (m.find()) {
				// Simplest method:
				// System.out.println(m.group(0));
				// Get the starting position of the text
				int start = m.start(0);
				// Get ending position
				int end = m.end(0);
				// Print whatever matched.
				// Use CharacterIterator.substring(offset, end);
				System.out.println(line.substring(start, end));
			}
		}
		r.close();
	}
}
