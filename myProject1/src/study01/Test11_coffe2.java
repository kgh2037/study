package study01;

import java.util.Scanner;

public class Test11_coffe2 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		while (true) {
		System.out.println("== 드시려는 커피의 번호를 입력해주세요. ==");
		System.out.println("1. 아메리카노");
		System.out.println("2. 다방커피");
		System.out.print("* 커피번호 >> ");
		int n1 = scanner.nextInt();
		if(n1 == 1) {
			System.out.println(" 아메리카노를 고르셨습니다.");
			while (true) {
			System.out.println("1. 설탕 넣기");
			System.out.println("2. 설탕 없음");
			System.out.print("*설탕옵션 >> ");
			n1 = scanner.nextInt();
				if (n1 == 1) {
					System.out.println("설탕을 넣은 아메리카노가 나왔습니다.");
					break;
				} else if (n1 == 2) { 
					System.out.println("설탕 없는 아메리카노가 나왔습니다.");
					break;
				} else {
					System.out.println("잘못 고르셨습니다.");
				}
			}
		} else if (n1 == 2) { 
			System.out.println(" 다방커피를 고르셨습니다.");
			while(true) {
			System.out.println("1. 프림1 + 설탕 1 (연한맛)");
			System.out.println("2. 프림2 + 설탕 2 (단맛)");
			System.out.println("3. 프림3 + 설탕 3 (오모로시한맛)");
			System.out.print("*프림, 설탕 옵션 >> ");
			n1 = scanner.nextInt();
				if (n1 == 1) {
					System.out.println("연한맛의 다방커피가 나왔습니다.");
					break;
				} else if (n1 == 2) {
					System.out.println("단맛의 다방커피가 나왔습니다.");
					break;
				} else if (n1 == 3) {
					System.out.println("오모로시한맛의 다방커피가 나왔습니다.");
					break;
				} else {
					System.out.println("잘못 고르셨습니다.");
				}
			}
		} else {
			System.out.println(" 잘못 고르셨습니다.");
			}
		}
	}
}