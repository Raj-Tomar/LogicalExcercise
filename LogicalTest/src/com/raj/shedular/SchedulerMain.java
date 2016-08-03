package com.raj.shedular;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class SchedulerMain extends TimerTask{
	
	Date now; // to display current time
	
	public static void main(String[] args)throws InterruptedException {

		Timer time = new Timer(); // Instantiate Timer Object
		SchedulerMain st = new SchedulerMain(); 
		time.schedule(st, 0, 1000 * 60); // Create Repetitively task for every 1 secs

		/*for (int i = 0; i <= 5; i++) {
			System.out.println("Execution in Main Thread...." + i);
			Thread.sleep(2000);
			if (i == 5) {
				System.out.println("Application Terminates");
				System.exit(0);
			}
		}*/
	}

	@Override
	public void run() {
		now = new Date(); // initialize date
		System.out.println("Time is :" + now); // Display current time
	}
}
