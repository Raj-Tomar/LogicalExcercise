package com.raj.patterns;

public class TrianglePattern {

	public static void main(String[] args) {
		DrawTrianglePattern(5);
	}
	
	public static void DrawTrianglePattern(int size) {
		for (int i = size; i > 0; i--) {
			System.out.print(" ");
			for (int j = size; j >= i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
