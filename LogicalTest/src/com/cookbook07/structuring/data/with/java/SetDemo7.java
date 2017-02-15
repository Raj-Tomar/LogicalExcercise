package com.cookbook07.structuring.data.with.java;

import java.util.HashSet;
import java.util.Set;

public class SetDemo7 {

	public static void main(String[] args) {
		Set<String> hashSet = new HashSet<>();
		 hashSet.add("One");
		 hashSet.add("Two");
		 hashSet.add("One"); // DUPLICATE
		 hashSet.add("Three");
		 hashSet.forEach(s -> System.out.println(s));
		 
		 /*
		  *If you need a sorted Set, 
		  *there is in fact a SortedSet interface, 
		  *of which the most common implementation is a TreeSet 
		  * 
		  */
	}
}
