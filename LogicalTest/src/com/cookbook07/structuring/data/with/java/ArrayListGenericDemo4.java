package com.cookbook07.structuring.data.with.java;

import java.util.ArrayList;

public class ArrayListGenericDemo4 {
	
	public static void main(String[] args) {
		ArrayList<String> data = new ArrayList<>();
		data.add("hello");
		data.add("goodbye");
		// data.add(new Date()); This won't compile!
		data.forEach(s -> System.out.println(s));
	}
}