package com.cookbook07.structuring.data.with.java;

import java.io.IOException;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class PreferencesDemo10 {

	public static void main(String[] args) throws IOException, BackingStoreException  {
		// Setup the Preferences for this application, by class.
		Preferences prefs = Preferences.userNodeForPackage(PreferencesDemo10.class);
		// Retrieve some preferences previously stored, with defaults in case
		// this is the first run.
		String text = prefs.get("textFontName", "lucida-bright");
		String display = prefs.get("displayFontName", "lucida-blackletter");
		System.out.println(text);
		System.out.println(display);
		// Assume the user chose new preference values: Store them back.
		prefs.put("textFontName", "times-roman");
		prefs.put("displayFontName", "helvetica");
		// Toss in a couple more values for the curious who want to look
		// at how Preferences values are actually stored.
		Preferences child = prefs.node("a/b");
		child.putInt("meaning", 42);
		child.putDouble("pi", Math.PI);
		// And dump the subtree from our first node on down, in XML.
		prefs.exportSubtree(System.out);

	}
}
