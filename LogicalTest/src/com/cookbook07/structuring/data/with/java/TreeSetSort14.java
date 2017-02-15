package com.cookbook07.structuring.data.with.java;

import java.util.TreeSet;

public class TreeSetSort14 {

	public static void main(String[] args) {
		// A TreeSet keeps objects in sorted order. Use a Comparator
		// published by String for case-insensitive sorting order.
		TreeSet<String> theSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
		theSet.add("Gosling");
		theSet.add("da Vinci");
		theSet.add("van Gogh");
		theSet.add("Java To Go");
		theSet.add("Vanguard");
		theSet.add("Darwin");
		theSet.add("Darwin"); // TreeSet is Set, ignores duplicates.
		System.out.printf("Our set contains %d elements", theSet.size());
		System.out.println();
		// Since it is sorted we can easily get various subsets
		System.out.println("Lowest (alphabetically) is " + theSet.first());
		// Print how many elements are greater than "k"
		// Should be 2 - "van Gogh" and "Vanguard"

		System.out.println(theSet.tailSet("k").toArray().length + " elements higher than \"k\"");
		// Print the whole list in sorted order
		System.out.println("Sorted list:");
		theSet.forEach(name -> System.out.println(name));
		
		/*
		 * if you have a Hashtable or HashMap, 
		 * you can convert it to a TreeMap, 
		 * and therefore get it sorted, 
		 * 
		 * just by passing it to the TreeMap constructor:
		 * TreeMap sorted = new TreeMap(unsortedHashMap);  
		 *  
		 */ 
	}
}
