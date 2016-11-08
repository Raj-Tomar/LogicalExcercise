package com.raj.date.time;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateAndCalendar {

	public static void main(String[] args){
		// get a calendar instance at December 31, 2009, at 11:30 p.m.
		// this way we can test that we are rolling over to the next hour,
		// tomorrow, next week, and next year properly.
		Calendar calendar = new GregorianCalendar(2009, 11, 31, 23, 30, 0);

		// get a Date instance to represent "now" (the current date);
		// we'll need it to reset our calendar during the following date examples.
		Date currentDate = calendar.getTime();
		System.out.format("today:      %s\n", currentDate);

		// get the date/time one hour from now
		calendar.setTime(currentDate);
		calendar.add(Calendar.HOUR_OF_DAY, 1);
		Date oneHour = calendar.getTime();
		System.out.format("one hour:   %s\n", oneHour);

		// get tomorrow's date
		calendar.setTime(currentDate);
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date tomorrow = calendar.getTime();
		System.out.format("tomorrow:   %s\n", tomorrow);

		// get next week's date
		// note: may want to use WEEK_OF_MONTH or WEEK_OF_YEAR
		calendar.setTime(currentDate);
		calendar.add(Calendar.DAY_OF_YEAR, 7);
		Date nextWeek = calendar.getTime();
		System.out.format("next week:  %s\n", nextWeek);

		// get next month
		calendar.setTime(currentDate);
		calendar.add(Calendar.MONTH, 1);
		Date nextMonth = calendar.getTime();
		System.out.format("next month: %s\n", nextMonth);

		// get next year
		calendar.setTime(currentDate);
		calendar.add(Calendar.YEAR, 1);
		Date nextYear = calendar.getTime();
		System.out.format("next year:  %s\n", nextYear);
	}
}
