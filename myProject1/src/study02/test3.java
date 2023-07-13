package study02;

import java.util.Scanner;

public class test3 {

	public static void main(String[] args) {
		int a = 10;
		int b = 11;
		int sick = 0;
		System.out.print("연산 부호를 입력해 주세요: ");
		Scanner scanner = new Scanner(System.in);
		String i = scanner.next();
		switch (i) {
		case "+" : sick = (a+b);
		break;
		case "-" : sick = (a-b);
		break;
		case "/" : sick = (a%b);
		break;
		case "*" : sick = (a*b);
		break;
		}
		System.out.println(i + "부호를 넣은 계산 결과는 " + sick + " 입니다.");
		
		}
	}

