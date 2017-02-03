package com.cookbook03.string.and.things;

import java.util.StringTokenizer;

public class StringTokenizerDemo2 {
	
	public final static String BR = "=====================================";
	
	public static void main(String[] args) {

		StringTokenizer st1 = new StringTokenizer("Hello World of Java");
		while (st1.hasMoreTokens( ))
			System.out.println("Token: " + st1.nextToken( ));

		System.out.println(BR);

		StringTokenizer st2 = new StringTokenizer("Hello, World|of|Java", ", |");
		while (st2.hasMoreElements( ))
			System.out.println("Token: " + st2.nextElement( ));

		System.out.println(BR);
		
		StringTokenizer st3 =
				new StringTokenizer("Hello, World|of|Java", ", |", true);
		while (st3.hasMoreElements( ))
			System.out.println("Token: " + st3.nextElement( ));
		
		System.out.println(BR);

	}

}
