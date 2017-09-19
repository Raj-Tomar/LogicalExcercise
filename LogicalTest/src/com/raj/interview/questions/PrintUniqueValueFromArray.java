package com.raj.interview.questions;

/*
 * This question asked in ProKarma
 * e.g. 
 *  int[] arr = {1,1,3,4,4,5,4}
 *  output : [3,5,4] 
 * 
 */

public class PrintUniqueValueFromArray {

	public static void main(String[] args) {
		printUniqueValues();
	}

	private static void printUniqueValues() {
		int[] input = { 1, 1, 3, 4, 4, 5, 4, 4,4 };
		int current = input[0];
		boolean found = false;
		for (int i = 0; i < input.length; i++) {
			if (current == input[i] && !found) {
				found = true;
			} else if(current != input[i] ){
				System.out.print(" "+current);
				current = input[i];
				found = false;
			}
		}
	}
}
