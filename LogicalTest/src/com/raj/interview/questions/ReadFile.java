package com.raj.interview.questions;

import java.io.BufferedReader;
import java.io.FileReader;

/*
 * This Question asked in Nisum
*/
public class ReadFile {

	private static final String fileName = "D:/Developement/Git/LogicalExcercise/LogicalTest/src/com/raj/interview/questions/test.txt";
	//private static final String fileName = "test.txt";
	
	public static void main(String[] args) {
		readFile();
	}
	
	public static void readFile(){
		// try-with-resources
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String currentLine;
			while((currentLine = br.readLine()) != null ){
				System.out.println(currentLine);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
