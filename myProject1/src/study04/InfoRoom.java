package study04;

import java.util.Scanner;

public class InfoRoom {

	public static void main(String[] args) {
		System.out.print("면적>평 계산할 면적을 입력해주세요 : ");
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		roomSize(i);
	}
	
	public static int roomSize3(int a) {
		double i = a * 0.3025;
		return (int)i;
	}
	public static double roomSize2(int a) {
		double i = a * 0.3025;
		return i;
	}
	
	public static void roomSize(int a) {
		double i = Math.round(a * 0.3025);
		double j = Math.rint(a * 0.3025);
		System.out.println("입력하신 " +
		a + "평방미터는 " + (int)i + " 평입니다." );
		System.out.println("입력하신 " +
				a + "평방미터는 " + (int)j + " 평입니다." );
				
	}
	
	
	
	
	
}