package com.raj.interview.questions;

import java.util.Scanner;

/*
 * This question asked in ProKarma
 * 
 * 0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610
 */
public class FibonacciSeries {

	public static void main(String[] args) {
		printFibonacciSeries();
	}

	private static void printFibonacciSeries() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter No : ");
		try {
			int count = sc.nextInt();
			if (count > 0) {
				int[] feb = new int[count];
				feb[0] = 0;
				feb[1] = 1;
				for (int i = 2; i < count; i++) {
					feb[i] = feb[i - 1] + feb[i - 2];
				}
				for (int i = 0; i < feb.length; i++)
					System.out.print(feb[i] + " ");
			}
			sc.close();
		} catch (NumberFormatException e) {
			System.out.println("Only Numbers are allowed");
		}
	}
}
