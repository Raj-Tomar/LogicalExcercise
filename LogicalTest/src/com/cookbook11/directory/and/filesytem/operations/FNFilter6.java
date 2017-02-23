package com.cookbook11.directory.and.filesytem.operations;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class FNFilter6 {

	public static void main(String[] args) {
		// Generate the selective list, with a one-use File object.
		String[] dirs = new java.io.File(".").list(new OnlyJava());
		Arrays.sort(dirs); // Sort it (Data Structuring chapter))
		for (String d : dirs) {
			System.out.println(d); // Print the list
		}
	}

	/**
	 * This class implements the FilenameFilter interface. The Accept method
	 * returns true for .java, .class and .jar files.
	 */
	private static class OnlyJava implements FilenameFilter {
		@Override
		public boolean accept(File dir, String s) {
			if (s.endsWith(".java") || s.endsWith(".class") || s.endsWith(".jar")) {
				return true;
			}
			// others: projects, ... ?
			return false;
		}
	}
}
