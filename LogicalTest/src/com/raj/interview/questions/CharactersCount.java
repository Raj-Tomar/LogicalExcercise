package com.raj.interview.questions;

import java.util.HashMap;
import java.util.Map;

/*
 * This question asked in Nisum
 * 
 * Count the characters from String
 *  e.g. String str = "abcdabcdabcd";
 *  
 *  O/P
 *  a = 3
 *  b = 3
 *  c = 3
 *  d = 4
*/
public class CharactersCount {

	public static void main(String[] args) {
		String str = "sdwesdeseses";
		Map<Character, Integer> map = countCharacters(str);

		// more elegant way, this should be the standard way, recommend!
		for (Map.Entry<Character, Integer> m : map.entrySet()) {
			System.out.println(m.getKey() + " = " + m.getValue());
		}

		System.out.println("Java 8 Map Iterator");
		// Java 8 only, forEach and Lambda. recommend!
		map.forEach((k, v) -> System.out.println(k + " = " + v));
	}

	public static Map<Character, Integer> countCharacters(String str) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : str.toCharArray()) {
			if (map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				map.put(c, 1);
		}
		return map;
	}

}
