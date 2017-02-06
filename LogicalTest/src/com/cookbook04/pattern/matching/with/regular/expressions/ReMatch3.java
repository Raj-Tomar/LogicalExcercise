package com.cookbook04.pattern.matching.with.regular.expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReMatch3 {
	public static void main(String[] argv) {
		String patt = "Q[^u]\\d+\\.";
		Pattern r = Pattern.compile(patt);
		String line = "Order QT300. Now!";
		Matcher m = r.matcher(line);
		if (m.find()) {
			System.out.println(patt + " matches \"" + 
					m.group(0) + "\" in \"" + line + "\"");
		} else {
			System.out.println("NO MATCH");
		}
		
		String patt2 = "Q[^u]\\d+\\.";
		Pattern r2 = Pattern.compile(patt2);
		Matcher m2 = r2.matcher(line);
		if (m2.find()) {
			System.out.println(patt2 + " matches \"" + 
					line.substring(m2.start(0), m2.end(0)) + "\" in \"" + line + "\"");
		} else {
			System.out.println("NO MATCH");
		}
	}
}
