package com.cookbook11.directory.and.filesytem.operations;

import java.util.Arrays;

public class ListDirectory5 {

	public static void main(String[] args) {
		String[] dirs = new java.io.File(".").list(); // Get list of names
		Arrays.sort(dirs); // Sort it (see <<javacook-structure-SECT-8>>)
		for (String dir : dirs) {
			System.out.println(dir); // Print the list
		}
	}

}
