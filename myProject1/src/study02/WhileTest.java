package study02;

import java.util.Scanner;

public class WhileTest {

	public static void main(String[] args) {
		
		
		//do-while 문
		int z = 1;
		do {
			System.out.print(z + " ");
			z++;
		} while (z<=10);
		System.out.println();
		
		
		
		
		
		int a = 1;
		while(a<=5) {
			System.out.print(a+ " ");
			++a;
		}
		System.out.println();
		int b = 10;
		while(b>=1) {
			System.out.print(b+" ");
			--b;
		}
		System.out.println();
	
		int[] month = {1,3,5,10,12};
		int idx = 0;
		while(idx < month.length) {
			System.out.print(month[idx] + "월 ");
			idx++;
		}
		System.out.println();
		
		

		while(true) {
			System.out.print("양수를 입력해주세요 >> ");
			Scanner scanner = new Scanner(System.in);
			int c = scanner.nextInt();
			if(c == -1) {
				System.out.println("반복문을 종료합니다.");
				break;
			}
			System.out.println(c + " 를 입력했습니다.");
		}	
		
	}
}