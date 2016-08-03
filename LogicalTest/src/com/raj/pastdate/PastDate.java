package com.raj.pastdate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class PastDate {

	    public static void main(String args[]){

	    	DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            Date myDate = new Date(System.currentTimeMillis());
            System.out.println("result is "+ dateFormat.format(myDate));
            Calendar cal = Calendar.getInstance();
            cal.setTime(myDate);
            cal.add(Calendar.DATE, -1);
            System.out.println(dateFormat.format(cal.getTime()));

	    }

}
