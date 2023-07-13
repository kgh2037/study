package study07;

import java.util.Calendar;

public class unix_time {

	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTimeInMillis());
		
		long unixTime = cal.getTimeInMillis();
		System.out.println(unixTime/1000 + "초");
		
		cal.setTimeInMillis(unixTime);
		System.out.println(cal.get(Calendar.YEAR) + "/" +
				(cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DATE));
		
		long date = 1498137807001l;
		Calendar cal2 = Calendar.getInstance();
		cal2.setTimeInMillis(date);
		System.out.println(cal2.get(Calendar.YEAR) + "/" +
				(cal2.get(Calendar.MONTH) + 1) + "/" + cal2.get(Calendar.DATE));
		
	}
}