package study07;

import java.util.Calendar;

public class unix_time3 {
	public static void mian(String[] args) {
		/*
		Calendar cal = Calendar.getInstance();
		int y = 2023;
		int m = 6;
		int d = 1;
		
		cal.set(y, m, d);
		
		long unixTime = cal.getTimeInMillis();
		System.out.println(unixTime);

		Calendar cal2 = Calendar.getInstance();
		int y2 = 2023;
		int m2 = 11;
		int d2 = 02;
		
		cal2.set(y2, m2, d2);
		
		long unixTime2 = cal2.getTimeInMillis();
		
		
		long date = unixTime-unixTime2;
		
		*/
		
		
		Calendar cal3 = Calendar.getInstance();
		int y3 = 2023;
		int m3 = 11;
		int d3 = 2;
		
		cal3.set(y3, m3, d3);
		long unixTime = cal3.getTimeInMillis();
		
		cal3.setTimeInMillis(unixTime);
		System.out.println(cal3.get(Calendar.YEAR) + "/" +
				(cal3.get(Calendar.MONTH) + 1) + "/" + cal3.get(Calendar.DATE));
		}
}
