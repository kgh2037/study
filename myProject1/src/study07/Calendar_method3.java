package study07;

import java.util.Calendar;

public class Calendar_method3 {

	public static void main(String[] args) {
		int y = 2023;
		int m = 11; //month는 0~11월로 구성되어 있음 >> 출력시 + 1 처리 
		int d = 15;
		
		Calendar cal = Calendar.getInstance();
		cal.set(y,m,d);
		
		int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
		String dayString = "";
		
		switch(dayofweek) {
		case Calendar.SUNDAY:
			dayString = "일요일";
			break;
		case Calendar.MONDAY:
			dayString = "월요일";
			break;
		case Calendar.TUESDAY:
			dayString = "화요일";
			break;
		case Calendar.WEDNESDAY:
			dayString = "수요일";
			break;
		case Calendar.THURSDAY:
			dayString = "목요일";
			break;
		case Calendar.FRIDAY:
			dayString = "금요일";
			break;
		case Calendar.SATURDAY:
			dayString = "토요일";
			break;
		}
		
				
		System.out.println("마지막 날짜 : " + cal.getActualMaximum(Calendar.DATE));
		System.out.println("요일 : " + dayString);
	}
}
