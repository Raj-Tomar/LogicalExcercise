package com.raj.date.time;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class DateTimeDifference {

	public static void main(String[] args) throws ParseException {
		zonedDateTimeDifference();
		System.out.println("Difference : "+differenceBetweenGivenDates("2017-03-13 14:02:26"));
		System.out.println(secondToYears(844756));
	}

	public static String differenceBetweenGivenDates(String dateStart) {

		Long diffSeconds = null;
		Long diffMinutes = null;
		Long diffHours = null;
		Long diffDays = null;

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStop = sdf.format(cal.getTime());
		System.out.println("dateStart : " + dateStart);
		System.out.println("dateStop  : " + dateStop);

		// HH converts hour in 24 hours format (0-23), day calculation
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date d1 = null;
		Date d2 = null;

		try {
			d1 = format.parse(dateStart);
			d2 = format.parse(dateStop);

			// in milliseconds
			long diff = d2.getTime() - d1.getTime();

			diffSeconds = diff / 1000 % 60;
			diffMinutes = diff / (60 * 1000) % 60;
			diffHours = diff / (60 * 60 * 1000) % 24;
			diffDays = diff / (24 * 60 * 60 * 1000);
			
			System.out.println(diffDays + " days, ");
			System.out.println(diffHours + " hours, ");
			System.out.println(diffMinutes + " minutes, ");
			System.out.println(diffSeconds + " seconds.");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return diffHours.toString() + "." + diffMinutes.toString() + diffSeconds.toString();
	}

	public static void zonedDateTimeDifference() throws ParseException {

		DateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

		Date date1 = utcFormat.parse("2016-08-15T22:56:02.038Z");
		Date date2 = utcFormat.parse("2016-08-17T22:56:02.038Z");

		DateFormat pstFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		pstFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

		String date3 = pstFormat.format(new Date());

		System.out.println(date3);

		// in milliseconds
		long difference = date2.getTime() - date1.getTime();

		System.out.println(difference + " Miliseconds ");

		long diffSeconds = difference / 1000 % 60;
		long diffMinutes = difference / (60 * 1000) % 60;
		long diffHours = difference / (60 * 60 * 1000) % 24;
		long diffDays = difference / (24 * 60 * 60 * 1000);

		System.out.println(diffSeconds + " seconds.");
		System.out.println(diffMinutes + " minutes, ");
		System.out.println(diffHours + " hours, ");
		System.out.println(diffDays + " days, ");

		ZonedDateTime zd1 = ZonedDateTime.parse("2016-11-06T02:56:02.038" + "Z");
		ZonedDateTime zd2 = ZonedDateTime.parse("2016-11-08T22:56:02.038" + "Z");
		long millis = zd2.toInstant().toEpochMilli() - zd1.toInstant().toEpochMilli();
		System.out.println(millis);
		long noOfDay = millis / (24 * 60 * 60 * 1000);
		System.out.println(noOfDay);

		String s1 = zd1.toLocalDate().toString() + " " + zd1.toLocalTime().toString();
		String s2 = zd2.toLocalDate().toString() + " " + zd2.toLocalTime().toString();
		System.out.println("date1 : " + s1);
		System.out.println("date2 : " + s2);

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		df.setTimeZone(TimeZone.getTimeZone("GMT"));
		Date dt1 = df.parse(s1);
		Date dt2 = df.parse(s2);
		long milieSeconds = dt2.getTime() - dt1.getTime();
		System.out.println(milieSeconds);
		long days = milieSeconds / (24 * 60 * 60 * 1000);
		System.out.println(days);

	}
	
	public static String secondToYears(long seconds) {
		double numyears = Math.floor(seconds / 31536000);
		double numdays = Math.floor((seconds % 31536000) / 86400);
		double numhours = Math.floor(((seconds % 31536000) % 86400) / 3600);
		double numminutes = Math.floor((((seconds % 31536000) % 86400) % 3600) / 60);
		double numseconds = (((seconds % 31536000) % 86400) % 3600) % 60;
		
		
		long secondsIn = seconds;
		long dayCount = TimeUnit.SECONDS.toDays(secondsIn);
		long secondsCount = secondsIn - TimeUnit.DAYS.toSeconds(dayCount);
		long hourCount = TimeUnit.SECONDS.toHours(secondsCount);
		secondsCount -= TimeUnit.HOURS.toSeconds(hourCount);
		long minutesCount = TimeUnit.SECONDS.toMinutes(secondsCount);
		secondsCount -= TimeUnit.MINUTES.toSeconds(minutesCount);
		
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%d %s, ", dayCount, (dayCount == 1) ? "day" : "days"));
		StringBuilder sb2 = new StringBuilder();
		sb2.append(sb.toString());
		sb2.append(String.format("%02d:%02d:%02d %s", hourCount, minutesCount, secondsCount, (hourCount == 1) ? "hour" : "hours"));
		sb.append(String.format("%d %s, ", hourCount, (hourCount == 1) ? "hour" : "hours"));
		sb.append(String.format("%d %s and ", minutesCount, (minutesCount == 1) ? "minute" : "minutes"));
		sb.append(String.format("%d %s.", secondsCount, (secondsCount == 1) ? "second" : "seconds"));
		System.out.printf("You entered %s seconds, which is %s (%s)%n", new DecimalFormat("#,###").format(secondsIn), sb, sb2);
		
		return numyears + " years " + numdays + " days " + numhours + " hours " + numminutes + " minutes " + numseconds + " seconds";
	}
}
