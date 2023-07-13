package study07;

import java.util.Calendar;

public class Calendar_method {
	
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int date = cal.get(Calendar.DATE);
		System.out.println(year + "/" + month + "/" + date);
		
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		System.out.println(hour + ":" + minute + ":" + second);
		
		System.out.println("am/pm : " + cal.get(Calendar.AM_PM));
		
		System.out.println("현재 요일 : " + cal.get(Calendar.DAY_OF_WEEK));
		System.out.println("올해 몇 번째 날 : " + cal.get(Calendar.DAY_OF_YEAR));
		System.out.println("올해 몇 번째 주 : " + cal.get(Calendar.WEEK_OF_YEAR));
		System.out.println("이번 달의 몇 번째 주 : " + cal.get(Calendar.WEEK_OF_MONTH));
		System.out.println("이번 달의 마지막 날 : " + cal.getActualMaximum(Calendar.DATE));
		
		
		cal.add(Calendar.DATE, 1);
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH);
		int d = cal.get(Calendar.DATE);
		System.out.println(y+ "/" + m + "/" + d);
		
		cal.add(Calendar.DATE, -2);
		cal.add(Calendar.YEAR, 1);
		cal.add(Calendar.MONTH, 1);
	}
}