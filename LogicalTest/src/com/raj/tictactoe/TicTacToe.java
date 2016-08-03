package com.raj.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Administrator
 *
 */
public class TicTacToe {

	public static String[][] board = new String[3][3];
	
	public static void main(String[] args){
		TicTacToe t = new TicTacToe();
		t.makeBoard();
		t.displayBoard();
		while(true){
			t.takInput();
		}
	}
	
	public void makeBoard(){
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				board[i][j] = "-";
			}
		}
	}
	
	public void displayBoard(){
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				System.out.print(board[i][j]+"\t");
			}
			System.out.println();
		}
		boolean w = winningCondition();
		if(w){
			System.out.println("Win");
			System.out.print("Do you want to play again?Y/N: ");
			Scanner sc = new Scanner(System.in);
			String choice = sc.next();
			if(choice.equalsIgnoreCase("y")){
				TicTacToe t = new TicTacToe();
				t.makeBoard();
				t.displayBoard();
				while(true){
					t.takInput();
				}
			}
			else{
				System.out.println("Thank You!");
				System.exit(0);
			}
			sc.close();
		}
	}
	
	public void takInput(){
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Row No: ");
			int row = sc.nextInt();
			System.out.print("Enter Column No: ");
			int column = sc.nextInt();
			sc.nextLine();
			if(!board[row-1][column-1].equals("-")){
				System.out.println("Not Empty, Enter Another location...");
				takInput();
			}
			System.out.print("Enter Element X/O: ");
			String ele = sc.nextLine();
			if(ele.equalsIgnoreCase("x") || ele.equalsIgnoreCase("o")){
				board[row-1][column-1] = ele;
				displayBoard();
			}else{
				System.out.println("Only 'X' or 'O' allowed");
				takInput();
			}
			sc.close();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Not Valid, Enter Another location...");
			takInput();
		} catch (InputMismatchException e) {
			System.out.println("Enter only Number...");
			takInput();
		}
	}
	
	public boolean winningCondition(){
		boolean win = false;
		// For X winning conditions...
		if(board[0][0].equalsIgnoreCase("x") && board[0][1].equalsIgnoreCase("x") && board[0][2].equalsIgnoreCase("x"))
			win = true;
		// For O winning Conditions...
		if(board[0][0].equalsIgnoreCase("o") && board[0][1].equalsIgnoreCase("o") && board[0][2].equalsIgnoreCase("o"))
			win = true;
		return win;
	}
}
