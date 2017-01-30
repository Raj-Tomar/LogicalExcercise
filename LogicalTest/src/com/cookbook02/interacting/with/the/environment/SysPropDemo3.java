package com.cookbook02.interacting.with.the.environment;

import java.io.IOException;

public class SysPropDemo3 {
	public static void main(String[] argv) throws IOException {
		String sysColor = System.getProperty("pencil_color");
		System.out.println(sysColor);
		if (argv.length == 0)
			System.getProperties().list(System.out);
		else {
			for (String s : argv) {
				System.out.println(s + " = " + System.getProperty(s));
			}
		}
	}
}
