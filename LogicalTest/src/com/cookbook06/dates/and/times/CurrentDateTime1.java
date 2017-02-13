package com.cookbook06.dates.and.times;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/*
 * find today’s date and/or time
 * 
 */
public class CurrentDateTime1 {
	
	public static void main(String[] args) {
		LocalDate dNow = LocalDate.now();
		System.out.println(dNow);
		LocalTime tNow = LocalTime.now();
		System.out.println(tNow);
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
	}
}
