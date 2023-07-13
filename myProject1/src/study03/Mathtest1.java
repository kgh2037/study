package study03;

public class Mathtest1 {

	public static void main(String[] args) {
		System.out.println(Math.ceil(98.2)); //소수점 올림, 실수형
		System.out.println(Math.ceil(98.7));
		
		System.out.println(Math.floor(98.2)); //소수점 버림, 실수형
		System.out.println(Math.floor(98.7));
		
		System.out.println(Math.round(98.2)); //소수점 반올림, 정수형
		System.out.println(Math.round(98.7));

		System.out.println(Math.rint(98.2)); //소수점 반올림, 실수형
		System.out.println(Math.rint(98.7));

		System.out.println(Math.abs(-98.7)); //절대값 반환, 실수형
		System.out.println(Math.abs(98.7));
	
		System.out.println(Math.pow(10,2)); //10의 2승
		
		System.out.println(Math.sqrt(100)); //100의 제곱근 반환
	
		System.out.println(Math.max(10,20));
		System.out.println(Math.min(10,20));
		
		System.out.println(Math.random()); //더블형 램덤 실수 새성
		System.out.println(Math.random()*100);
		System.out.println((int)(Math.random()*100)); //인트형 랜덤 정수 생성

		int n1 = (int)(Math.random()*100); //0~99 정수값
		System.out.println(n1);
		int n2 = (int)(Math.random()*100)+1; //1~100 정수값
		System.out.println(n2);
		int n3 = (int)(Math.random()*45)+1; //1~45 정수값
		System.out.println(n3);
		
		
	}
}