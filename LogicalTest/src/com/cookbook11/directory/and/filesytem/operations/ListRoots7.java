package com.cookbook11.directory.and.filesytem.operations;

import java.io.File;

public class ListRoots7 {

	public static void main(String[] args) {
		File[] drives = File.listRoots(); // Get list of names
		for (File dr : drives) {
			System.out.println(dr); // Print the list
		}

	}
}
