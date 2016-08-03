package com.raj.matrix;

import java.util.Scanner;

public class Matrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int rows = 0;
		int columns = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter rows: ");
		rows = sc.nextInt();
		System.out.print("Enter colums: ");
		columns = sc.nextInt();
		inputMatrix(rows,columns);
		sc.close();
	}
	
	public static void inputMatrix(int rows, int columns){
		int[][] matrix = new int[rows][columns];
		Scanner sc = new Scanner(System.in);
	
		for(int i=0; i<rows; i++){
			for(int j=0; j<columns; j++ ){
				System.out.print("Enter element "+i+""+j+": ");
				matrix[i][j] = sc.nextInt();
			}
		}
		System.out.println("Your Matrix...");
		for(int i=0; i<rows; i++){
			for(int j=0; j<columns; j++ ){
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.println();
		}
		
		int temp[][] = new int[columns][rows];
		for(int i=0; i<columns; i++){
			for(int j=0; j<rows; j++ ){
				temp[i][j] = matrix[j][i];
			}
		}
		
		System.out.println("Transpose Matrix...");
		for(int i=0; i<columns; i++){
			for(int j=0; j<rows; j++ ){
				System.out.print(temp[i][j]+"\t");
			}
			System.out.println();
		}
		sc.close();
	}
}
