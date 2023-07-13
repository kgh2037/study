package study05;

import java.util.Scanner;

public class Student1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Person1 s1 = new Person1();
		s1.name = "홍길동";
		
		System.out.print("나이를 입력해 주세요 : ");
		int a1 = scanner.nextInt();
		s1.setage(a1);
		s1.height = 170;
		System.out.print("체중을 입력해 주세요 : ");
		int a2 = scanner.nextInt();
		s1.setWeight(a2);
		
		
		System.out.println("성명 : " + s1.name);
		System.out.println("나이 : " + s1.getage());
		System.out.println("체중 : " + s1.getWeight());
	}
}