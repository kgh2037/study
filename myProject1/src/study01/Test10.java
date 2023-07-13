package study01;

import java.util.Scanner;

public class Test10 {

	public static void main(String[] args) {
		
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("성명 입력 : ");
		String name = scanner.next();
		
	
		System.out.print("연차 입력 : ");
		int emp_A_year = scanner.nextInt();
		
		String level = ((emp_A_year >= 15) ?  "특급" 
				: (emp_A_year >= 10) ? "고급" 
						: (emp_A_year >= 6) ? "중급" : "초급" );
		
		System.out.println(name + "사원의 년차는 " + emp_A_year + "년으로 " 
		+ level + "입니다.");
		
		System.out.println("===================================");
		
	
		System.out.println("성별 코드 입력 : ");
		String gender = scanner.next();
		String sex = ((gender.equals("M")) || (gender.equals("m")) ? "남성" : 
			((gender.equals("F")) || (gender.equals("f"))) ? "여성" : "잘못된 코드");
		System.out.println("입력하신 코드는 " + gender + " 임으로 "
				+ sex + "입니다.");
		
		}
	}
