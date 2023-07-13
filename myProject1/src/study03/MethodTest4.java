package study03;

import java.util.Calendar;

public class MethodTest4 {

	public static void main(String[] args) {
		myAge(1996);
	}
	public static void myAge(int a) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int age = year - a;
		System.out.println("나이 : " + age);
	}
}
