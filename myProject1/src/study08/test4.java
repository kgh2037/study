package study08;

import java.util.Scanner;

public class test4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("핸드폰 번호를 입력해주세요 : ");
		String phone = scanner.next();
				//"010-222-1234";
		String pattern = "01(0|1|5)-[0-9]{3,4}-[0-9]{4}";
		if(phone.matches(pattern)) {
			System.out.println("올바른 핸드폰 번호");
		}else {
			System.out.println("핸드폰 번호를 다시 입력해주세요.");
		}
	}
}