package com.cookbook06.dates.and.times;

import java.time.LocalDate;
import java.time.Period;

/*
 * Adding to or Subtracting from a Date or Calendar
 * 
 */

public class DateAddSubtract6 {

	public static void main(String[] args) {
		/** Today's date */
		LocalDate now = LocalDate.now();
		Period p = Period.ofDays(700);
		LocalDate then = now.plus(p);
		System.out.printf("Seven hundred days from %s is %s%n", now, then);
		
		LocalDate before = now.minus(p);
		System.out.printf("Seven hundred days before %s is %s%n", now, before);
	
	}
}
