package com.cookbook04.pattern.matching.with.regular.expressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Grep7 {
	public static void main(String[] args) throws IOException {
		BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(args.length);
		if (args.length != 1) {
			System.err.println("Usage: Match Lines pattern");
			System.exit(1);
		}
		Pattern patt = Pattern.compile(args[0]);
		Matcher matcher = patt.matcher("");
		String line = null;
		while ((line = is.readLine()) != null) {
			matcher.reset(line);
			if (matcher.find()) {
				System.out.println("MATCH: " + line);
			}
		}
	}
}
