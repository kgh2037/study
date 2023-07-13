package study01;

public class Test04 {

	public static void main(String[] args) {
		int a = 150;
		int b = 7;
		System.out.println("a + b" + " = " + (a+b));
		System.out.println("a - b" + " = " + (a-b));
		System.out.println("a x b" + " = " + (a*b));
		System.out.println("a / b" + " = " + (a/b));
		System.out.println("a % b" + " = " + (a%b));
		System.out.println("======================");
		int eng = 90;
		int kor = 80;
		System.out.println("점수 합계 :" + (eng+kor));
		System.out.println("평균 점수 : "+ ((eng+kor)/2));
		System.out.println("======================");

		String firstName = "길동";
		System.out.println(firstName);
		
		System.out.println("홍" + firstName);
		System.out.println("김" + firstName);
		System.out.println("홍" + firstName + "100점");
		System.out.println("======================");

		String lastName = "갓";
		System.out.println(lastName + firstName);
		System.out.println("======================");

		
		String fruit = "사과";
		int price = 500;
		System.out.println(fruit + "의 가격은 " + price + "원 입니다.");
		System.out.println("======================");
		
		int eng2 = 90;
		int math = 100;
		System.out.println("영어 (" + eng2 + ") 수학 (" 
		+ math + ") 평균 (" + ((eng2+math)/2) + ")");
		System.out.println("======================");
	}

}
