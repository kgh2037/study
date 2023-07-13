package study02;

import java.util.Scanner;

public class test2 {

	public static void main(String[] args) {
		/* int time= 18;
		if (time != 18) {
			System.out.println("지금은 퇴근 시간이 아닙니다.");
		} else {
			System.out.println("퇴근 시간입니다. 10분 후 소등하겠습니다.");
		}
		System.out.println("--------------------------");
		
		if (!(time >=18)) {
			System.out.println("지금은 퇴근 시간이 아닙니다.");
		} else {
			System.out.println("퇴근 시간입니다. 10분 후 소등하겠습니다.");
		}
		System.out.println("--------------------------");
		
		boolean result = true;
		if (!result) {
			System.out.println("11");
		} else {
			System.out.println("22");
		} */
		
		System.out.println("== 풀어보기 1 ==");
		int kor = 45;
		int eng = 70;
		
		if (kor >= 60 && eng >= 60) {
			System.out.println("합격입니다.");
		} else if (kor >=60 || eng >= 60) {
			System.out.println("재시험 대상입니다.");
		} else {
			System.out.println("불합격 입니다.");
		}
		
		System.out.println("== 풀어보기 2 ==");
		int math = 77;
		String hackjum = ((math >= 90) ? "A학점" : (math >= 80) ? "B학점" :
			(math >= 70) ? "C학점" :(math >= 60) ? "D학점" : "F학점");
		System.out.println("점수가 " + math + "임으로 " + hackjum + " 입니다.");
		
		
		System.out.println("== 풀어보기 3 ==");
		int[] su = {12, 20, 55};
		for (var i=0; i<su.length; i++) {
		String sucase = (( su[i]%2==0 ) ? "짝수" : "홀수");
		String beasu = (( su[i]%10==0 ) ? "10의 배수 입니다." : "10의 배수가 아닙니다.");
		
		System.out.println(su[i] + "는 " + sucase + "이고 " + beasu);
		}
		
		System.out.print("값을 입력 해주세요 : ");
		Scanner scanner = new Scanner(System.in);
		int j = scanner.nextInt();
		String page = ((j>=1 && j<=10) ? "1페이지" : (j>=11 && j<=20) ? "2페이지"
				: (j>=21 && j<=30) ? "3페이지" : "잘못된 숫자 입력");
		
		System.out.println("입력된 값은 " + j + "로 " + page + 
				" 범위에 있습니다.");
		
	}
}