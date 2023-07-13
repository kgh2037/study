package study04;

import java.util.Scanner;

public class ResultExam {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("수학 점수를 입력해 주세요. : ");
		int math = scanner.nextInt();
		System.out.print("영어 점수를 입력해 주세요. : ");
		int eng = scanner.nextInt();;
		exam(math,eng);
	}
	
	public static void exam(int math ,int eng) {
		String result = "";
		if (math>=60 && eng >= 60) {
			result = "점으로 합격입니다."; 
		} else if (math< 60 || eng<60) {
			result = "점으로 불합격입니다.";
		}
		System.out.println("수학 " + math + "점, 영어 " +
				eng + result); 
	} 
}
