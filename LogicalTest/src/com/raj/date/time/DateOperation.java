package com.raj.date.time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateOperation {

	public static void main(String[] args){
		DateOperation date = new DateOperation();
		date.dateOperation(new Date());
	}

	private void dateOperation(Date date) {
		//Date Example
		System.out.println(date);
		// 1. 7-Jun-2013
		System.out.println(new SimpleDateFormat("dd-MMM-yyyy").format(date));
		// 2. 07/06/2013
		System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(date));
		// 3. Jun 7, 2013
		System.out.println(new SimpleDateFormat("MMM dd, yyyy").format(date));
		// 4. Fri, June 7 2013
		System.out.println(new SimpleDateFormat("E, MMM dd yyyy").format(date));
		
		// Date and Time Example
		
		// 1. Friday, Jun 7, 2013 12:10:56 PM
		System.out.println(new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a").format(date));
	}
}
