package com.cookbook11.directory.and.filesytem.operations;

import java.io.File;
import java.io.IOException;

public class TempFiles3 {

	public static void main(String[] args) throws IOException {
		// 1. Make an existing file temporary
		// Construct a File object for the backup created by editing
		// this source file. The file probably already exists.
		// My editor creates backups by putting ~ at the end of the name.
		File bkup = new File("Rename.java~");
		// Arrange to have it deleted when the program ends.
		bkup.deleteOnExit();
		// 2. Create a new temporary file.
		// Make a file object for raj.tmp, in the default temp directory
		File tmp = File.createTempFile("raj", ".tmp");
		// Report on the filename that it made up for us.
		System.out.println("Your temp file is " + tmp.getCanonicalPath());
		// Arrange for it to be deleted at exit.
		tmp.deleteOnExit();
		// Now do something with the temporary file, without having to
		// worry about deleting it later.
		writeDataInTemp(tmp.getCanonicalPath());

	}

	public static void writeDataInTemp(String tempnam) {
		// This version is dummy. Use your imagination.
	}

}
