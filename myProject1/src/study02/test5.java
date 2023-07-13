package study02;

import java.util.Arrays;
import java.util.Scanner;

public class test5 {

	public static void main(String[] args) {
		
		for(var j=1; j<=17; j++) {
			if ( j%5==0 ) {
				System.out.print(" "+j +"**");
			} else {
				System.out.print(" "+j);
			}
		}System.out.println("");
		
		
		int[] months = {1, 3, 10};
		String season = "";
		for (var i=0; i<months.length; i++) {
			
		switch (months[i]) { 
		case 1 : case 2: case 12:
			season = "겨울";
		break;
	
		case 3 : case 4: case 5 :
			season = "봄";
		break;
	
		case 6: case 7: case 8 :
			season = "여름";
		break;
	
		case 9 : case 10:  case 11:
			season = "가을";
		break;
		}
		System.out.println(months[i]+ "월 : " + season);
		}System.out.println();
		
		for (var dan = 2; dan<=4; dan++) {
			for(var su = 1; su<=3; su++) {
				System.out.println(dan + "*" + su + " = " + (dan*su));
			}System.out.println();
		}
		
		/*
		String[] coffe = {"아메리카노", "카푸치노", "카페라떼", "오늘의커피"};
		int[] price = {3500, 4500, 4300, 3500};
		Scanner scanner = new Scanner(System.in);
		System.out.println("커피 번호를 선택해주세요.");
		System.out.print("1. 아메리카노 2.카푸치노 3.카페라떼 4.오늘의커피 5.주문취소");
		System.out.print("번호 >> ");
		var n = scanner.nextInt();
			switch (n) {
			case 1: break;
			case 2: break;
			case 3: break;
			case 4: break;
			case 5:
				System.out.println("주문을 취소했습니다. (종료)");
				break;
			} System.out.println(coffe[(n-1)] + "를 선택하셨습니다." );
			 System.out.println(price[(n-1)] + "를 선택하셨습니다." );
			 */
			 
		
		 for(int s = 1; s<=5; s++) {
			 for(int d = 1; d<=s; d++) {
			 System.out.print("*");
			 }System.out.println();
		 }
		 System.out.println();
		 
		 for(int v=5; v>=1; v--) {
			 for(int l=1; l<=v; l++) {
				 System.out.print("*");
			 }System.out.println("");
		 }
		 
		 
		 int[][] classA = { { 90, 80, 70 }, { 50, 100, 100 } };
		 int total = 0; //1학년 총합 값을 받을 초기화 매개변수
		 
		 int sum1 = 0;  // 1반 배열 지수의 총합을 받을 매개 변수
		 for (int i=0; i<classA[0].length; i++) {
			 sum1 += classA[0][i];
		 } int average1 = sum1 / classA[0].length;

		 int sum2 = 0; // 2반 배열 지수의 총합을 받을 매개 변수
		 for (int i=0; i<classA[1].length; i++) {
			 sum2 += classA[1][i];
		 } int average2 = sum2 / classA[1].length;
		 
		 total = sum1 + sum2;
		 int average3 = total/(classA[0].length+classA[1].length);
		 
		 System.out.println("1반 점수 총합 : " + sum1 + "점 / 평균점수 : " + average1);
		 System.out.println("2반 점수 총합 : " + sum2 + "점 / 평균점수 : " + average2);
		 System.out.println("1학년 점수 총합 : " + total + "점 / 평균점수 : " + average3);
	}
}