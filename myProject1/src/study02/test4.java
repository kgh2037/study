package study02;

import java.util.Calendar;
import java.util.Scanner;

public class test4 {

	public static void main(String[] args) {
		
		System.out.println("==========풀어보기 1==========");
		String[] a = { "정답", "오답" };
		for (int i = 1; i<4; i++) {
			if(i==3) {
				System.out.println("문항 " + i + " :" + " 오답");
			} else {
				System.out.println("문항 " + i + " :" + " 정답");
			}
		}	
			
		System.out.println(); //	Calendar cal = Calendar.getInstance();
		System.out.println("==========풀어보기 2==========");
		for (int year = 2021; year<=2025; year++) {
			if(year%2023==0) {
				System.out.print(" (" + year + ")");
			} else {
				System.out.print(" "+year);
			}
		}
		System.out.println();
		
		System.out.println("==========풀어보기 3==========");
		System.out.println(" == 구구단 == ");
		Scanner scanner = new Scanner(System.in);
		int dan = scanner.nextInt();
		for (int su = 1; su<=9; su++) {
			System.out.println(dan + " x " + su + " = " + (dan*su));
		}
		
		System.out.println();
		System.out.println("==========풀어보기 4==========");
		System.out.print("별의 갯수를 입력 : ");
		int ea = scanner.nextInt();
		for (int star = 1; star<=ea; star++) {
			System.out.print(" *");
		}
	}
}