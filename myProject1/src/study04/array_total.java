package study04;

import java.util.Arrays;
import java.util.Scanner;

public class array_total {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] num = new int[5];
		for(int i=0;i<num.length;i++) {
			System.out.print(i+1 + "번째 배열의 값 입력 : ");
			num[i] = scanner.nextInt();
		}
		 System.out.println("최대값 : " + maxTest.maxNum(num));
		 System.out.println("최소값 : " + minTest.minNum(num));
		 //상기 방법은 클래스를 생성해서 사용하는 방법
		 //eclipse 기본제공 Arrays class 명령어 사용시 하기 코딩
		 //System.out.println(Arrays.stream(num).max().getAsInt());
		 //System.out.println(Arrays.stream(num).min().getAsInt());
		 System.out.println("중앙값 : " + middleTest.middleNum(num));
		 
		 //배열의 중앙값을 구하는 메서드는 없음
		 // Arrays.sort(num); //배열의 오름차순 정렬
		 //System.out.println(num[num.length/2]);
		// 배열 크기의 중앙에 위치한 지수를 출력
	}
}