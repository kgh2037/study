package study07;

import java.util.Calendar;

public class unix_time2 {
	public static void main(String[] args) {
	Calendar cal = Calendar.getInstance();
	int y = 2023;
	int m = 12;
	int d = 31;
	
	cal.set( y, m, d );
	System.out.println( y + "/" + m + "/" + d );
	
	long unixTime = cal.getTimeInMillis();
	System.out.println(unixTime);
	}
}