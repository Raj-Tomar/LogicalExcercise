package com.raj.date.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeDifference {

	public static void main(String[] args) throws ParseException {
		DateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

		Date date1 = utcFormat.parse("2016-08-15T22:56:02.038Z");
		Date date2 = utcFormat.parse("2016-08-17T22:56:02.038Z");

		DateFormat pstFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		pstFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		String date3 = pstFormat.format(new Date());
		
		System.out.println(date3);
		
		//in milliseconds
		long difference = date2.getTime() - date1.getTime();

		System.out.println(difference + " Miliseconds ");
		
		long diffSeconds = difference / 1000 % 60;
		long diffMinutes = difference / (60 * 1000) % 60;
		long diffHours 	 = difference / (60 * 60 * 1000) % 24;
		long diffDays 	 = difference / (24 * 60 * 60 * 1000);

		System.out.println(diffSeconds + " seconds.");
		System.out.println(diffMinutes + " minutes, ");
		System.out.println(diffHours + " hours, ");
		System.out.println(diffDays + " days, ");
	}
}
