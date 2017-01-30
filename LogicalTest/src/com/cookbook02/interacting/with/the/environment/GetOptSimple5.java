package com.cookbook02.interacting.with.the.environment;

public class GetOptSimple5 {
	public static void main(String[] args) {
		GetOpt go = new GetOpt("h");
		char c;
		while ((c = go.getopt(args)) != 0) {
			switch (c) {
			case 'h':
				helpAndExit(0);
				break;
			default:
				System.err.println("Unknown option in " + args[go.getOptInd() - 1]);
				helpAndExit(1);
			}
		}
		System.out.println();
	}

	/**
	 * Stub for providing help on usage You can write a longer help than this,
	 * certainly.
	 */
	static void helpAndExit(int returnValue) {
		System.err.println("This would tell you how to use this program");
		System.exit(returnValue);
	}
}