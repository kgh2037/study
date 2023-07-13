package study04;

import java.util.Scanner;

public class CalcTest1_if {

	public static void main(String[] args) {
		System.out.print("사칙연산 부호 입력 : ");
		Scanner scanner = new Scanner(System.in);
		String c = scanner.next();
		int a = 100;
		int b = 20;
		myCalc(a,b,c);
	}
	
	public static void myCalc(int a, int b, String c) {
		int result = 0;
		if(c.equals("+")) {
			result = a+b;
			System.out.println(a + "+" + b + "=" + result);
		}else if(c.equals("-")) {
				result = a-b;
				System.out.println(a + "-" + b + "=" + result);
			}else if(c.equals("*")) {
					result = a*b;
					System.out.println(a + "*" + b + "=" + result);
			}else if(c.equals("/")) {
						result = a/b;
						System.out.println(a + "/" + b + "=" + result);
			}else {
				System.out.println("잘못된 부호 입니다.");
		}
	}
}