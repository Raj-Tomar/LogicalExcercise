package com.cookbook06.dates.and.times;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/*
 * Interfacing with Legacy Date and Calendar Classes
 * 
 */
public class LegacyDates7 {

	public static void main(String[] args) {
		
		// There and back again, via Date
		Date legacyDate = new Date();
		System.out.println(legacyDate);
		LocalDateTime newDate = LocalDateTime.ofInstant(legacyDate.toInstant(), ZoneId.systemDefault());
		System.out.println(newDate);

		// And via Calendar
		Calendar c = Calendar.getInstance();
		System.out.println(c);
		LocalDateTime newCal = LocalDateTime.ofInstant(c.toInstant(), ZoneId.systemDefault());
		System.out.println(newCal);

	}
}
