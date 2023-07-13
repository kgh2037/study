package study07;

import java.util.Calendar;

public class Calendar_method2 {

	public static void main(String[] args) {
		int y = 2023;
		int m = 11;
		int d = 15;
		
		Calendar cal1 = Calendar.getInstance();
		cal1.set(y,m,d);
		
		int yy = cal1.get(Calendar.YEAR);
		int mm = cal1.get(Calendar.MONTH) +1;
		int dd = cal1.get(Calendar.DATE);
		System.out.println(yy + "/" + mm + "/" + dd);
	
	}
}