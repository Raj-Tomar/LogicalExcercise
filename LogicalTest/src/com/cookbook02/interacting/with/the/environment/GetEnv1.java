package com.cookbook02.interacting.with.the.environment;

public class GetEnv1 {
	public static void main(String[] argv) {
		System.out.println("System.getenv(\"PATH\") = " + System.getenv("PATH"));
		System.out.println("System.getenv(\"CLASSPATH\") = " + System.getenv("CLASSPATH"));
	}
}