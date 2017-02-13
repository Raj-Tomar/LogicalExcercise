package com.cookbook06.dates.and.times;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * Parsing Strings into Dates
 * convert user input into java.time objects. 
 */
public class DateParse4 {

	public static void main(String[] args) {

		String armisticeDate = "1914-11-11";
		LocalDate aLD = LocalDate.parse(armisticeDate);
		System.out.println("Date: " + aLD);
		String armisticeDateTime = "1914-11-11T11:11";
		LocalDateTime aLDT = LocalDateTime.parse(armisticeDateTime);
		System.out.println("Date/Time: " + aLDT);

		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd MMM uuuu");
		String anotherDate = "27 Jan 2011";
		LocalDate random = LocalDate.parse(anotherDate, df);
		System.out.println(anotherDate + " parses as " + random);
		
		/*
		 * As its name implies, 
		 * the DateTimeFormatter object is bidirectional; 
		 * it can both parse input and format output. 
		 * We could add this line to the DateParse example:
		 *  
		 */		
		System.out.println(aLD + " formats as " + df.format(aLD));

	}
}
