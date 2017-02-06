package com.cookbook04.pattern.matching.with.regular.expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReMatchTwoFields4 {
	public static void main(String[] args) {
		String inputLine = "Adams, John Quincy";
		// Construct an RE with parens to "grab" both field1 and field2
		Pattern r = Pattern.compile("(.*), (.*)");
		Matcher m = r.matcher(inputLine);
		if (!m.matches())
			throw new IllegalArgumentException("Bad input");
		System.out.println(m.group(2) + ' ' + m.group(1));
	}
}