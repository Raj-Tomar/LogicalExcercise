package com.cookbook02.interacting.with.the.environment;

import java.io.File;

/**
 * Some things that are System Dependent. All methods are static.
 * 
 */
public class SysDep4 {
	final static String UNIX_NULL_DEV = "/dev/null";
	final static String WINDOWS_NULL_DEV = "NUL:";
	final static String FAKE_NULL_DEV = "jnk";
	
	public static void main(String[] args) {
		System.out.println(getDevNull());
		boolean isMacOS = System.getProperty("mrj.version") != null;
		System.out.println("isMacOS : "+isMacOS );
	}
	

	/**
	 * Return the name of the "Null Device" on platforms which support it, or
	 * "jnk" (to create an obviously well-named temp file) otherwise.
	 */
	public static String getDevNull() {
		if (new File(UNIX_NULL_DEV).exists()) {		// If /dev/null exists, use it.
			return UNIX_NULL_DEV;
		}
		String sys = System.getProperty("os.name"); // If not, ask System.properties if it knows the OS name.
		if (sys == null) {							// Nope, so give up, return jnk.
			return FAKE_NULL_DEV;
		}
		if (sys.startsWith("Windows")) {			// We know it’s Microsoft Windows, so use NUL:.
			return WINDOWS_NULL_DEV;
		}
		return FAKE_NULL_DEV;						// All else fails, go with jnk.
	}

}