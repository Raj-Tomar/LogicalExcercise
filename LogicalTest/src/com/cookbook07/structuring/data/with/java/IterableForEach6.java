package com.cookbook07.structuring.data.with.java;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class IterableForEach6 {
	
	private final static String SEP = "===================";
	
	public static void main(String[] args) {
		Collection<String> c =	// Declare a Collection (a Collection is an Iterable). 
				Arrays.asList("One", "Two", "Three"); // Populate itwith Arrays.asList, passing a literal array into the asList() method
		
		// 1 Iterable.forEach method (Java 8)
		// 2 Java "foreach" loop (Java 5)
		// 3 java.util.Iterator (Java 2)
		// 4 Three-part for loop
		// 5 "while" loop
		// 6 Enumeration

		// 1
		c.forEach(s -> System.out.println(s)); // Invoke the collection’s forEach() method, passing a lambda expression
		System.out.println(SEP);
		
		// 2
		for (String string : c) {
			System.out.println(string);
		}
		System.out.println(SEP);
		
		// 3 & 5
		int i = 0;
		Iterator<String> it = c.iterator();
		// Process the data structure using an iterator.
		// This part of the code does not know or care
		// if the data is an an array, a List, a Vector, or whatever.
		while (it.hasNext()) {
			Object o = it.next();
			System.out.println("Element " + i++ + " = " + o);
		}
		System.out.println(SEP);
		
		// 4
		String[] str = (String[]) c.toArray();
		for (int a = 0; a < str.length; a++) {
			System.out.println("Element " + i++ + " = " + str[a]);
		}
		System.out.println(SEP);
		
		// 6
		
	}
}