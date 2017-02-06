package com.cookbook04.pattern.matching.with.regular.expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringConvenience2 {
	
	public static void main(String[] argv) {
		String pattern = ".*Q[^u]\\d+\\..*";
		String line = "Order QT300. Now!";
		if (line.matches(pattern)) {
			System.out.println(line + " matches \"" + pattern + "\"");
		} else {
			System.out.println("NO MATCH");
		}
		
		Matcher m = Pattern.compile(pattern).matcher(line);
		if (m.find( )) {
			System.out.println(line + " matches \"" + pattern + "\"");
		}
	}
}