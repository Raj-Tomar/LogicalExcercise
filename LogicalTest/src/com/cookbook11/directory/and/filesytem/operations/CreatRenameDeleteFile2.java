package com.cookbook11.directory.and.filesytem.operations;

import java.io.File;
import java.io.IOException;

public class CreatRenameDeleteFile2 {

	public static void main(String[] args) throws IOException {
		String[] fileNames = { "a.text", "b.text", "c.text" };
		//createFiles(fileNames);
		//renameFiles(fileNames);
		deleteFiles(fileNames);
	}

	// Create File
	public static void createFiles(String[] fileNames) throws IOException {
		// Ensure that a filename (or something) was given in fileNames[0]
		if (fileNames.length == 0) {
			System.err.println("Usage: Creat filename");
			System.exit(1);
		}
		for (String a : fileNames) {
			// Constructing a File object doesn't affect the disk, but
			// the createNewFile() method does.
			new File(a).createNewFile();
		}
	}

	// Rename File
	public static void renameFiles(String[] fileNames) {
		// Ensure that a filename (or something) was given in fileNames[0]
		if (fileNames.length == 0) {
			System.err.println("Usage: Rename filename");
			System.exit(1);
		}
		for (String a : fileNames) {
			// Construct the file object. Does NOT create a file on disk!
			File f = new File(a); // backup of this source file.
			// Rename the backup file to "junk.dat"
			// Renaming requires a File object for the target.
			f.renameTo(new File("Renamed_" + a));
		}
	}

	// Delete File
	public static void deleteFiles(String[] fileNames) {
		// Ensure that a filename (or something) was given in fileNames[0]
		if (fileNames.length == 0) {
			System.err.println("Usage: Delete filename");
			System.exit(1);
		}
		for (String a : fileNames) {
			// Construct a File object for the backup created by editing
			// this source file. The file probably already exists.
			// Some text editors create backups by putting ~ at end of filename.
			File target = new File("Renamed_" + a);
			if (!target.exists()) {
				System.err.println("File " + "Renamed_" + a + " not present to begin with!");
				return;
			}
			// Now, delete it:
			if (target.delete())
				System.err.println("** Deleted " + "Renamed_" + a + " **");
			else
				System.err.println("Failed to delete " + "Renamed_" + a);
		}

	}

}
