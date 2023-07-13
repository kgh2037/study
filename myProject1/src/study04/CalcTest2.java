package study04;

import java.util.Scanner;

public class CalcTest2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] score = new int[5];
		for (int i=0;i<score.length;i++) {
			System.out.print(i+1 + "번째 점수를 입력하세요 : ");
			score[i] = scanner.nextInt();
		}
		System.out.println("점수의 합 : " + arraySum(score));
		System.out.println("평균 : " + arraySum(score)/score.length);
	}
	public static int arraySum(int[] score) {
		int hap = 0;
		for (int i=0;i<score.length;i++) {
			hap += score[i];
		} return hap; 
	}	

}
