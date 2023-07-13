package study01;

public class Test06 {

	public static void main(String[] args) {
		int a = 1;
		++a; 
		System.out.println(a);
		++a;
		System.out.println(a);
		a++;
		System.out.println(a);
		System.out.println("==================");
		
		int b = 1;
		++b; //2
		int c = ++b; //++b 임으로 증감되어 b=3 / c는 b의 값으로 초기화 함으로 3
		//int c = b++; //b++ 임으로 c를 ++b; 의 값 2로 초기화 한 뒤 증감하여 b=3 c=2 
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("==================");
		
		//System.out.println((100>200) ? "참" : "거짓");
		
		//String result = ((10 % 2 == 0) ? "참" : "거짓");
		//System.out.println(result);
		
		int apple = 88;
		String result2 = ((apple > 80) ? "A등급" : 
			(apple>=60) ? "B등급" : "C등급");
		System.out.println("사과의 당도는 " + apple + "임으로 " +
		result2 + "입니다.");
		
		int eng = 80;
		String state = ((eng > 80) ? "우수"  : "양호");
		System.out.println("영어 점수가 " + eng + "임으로 " + 
		state +"입니다.");
		System.out.println("==================");
		
		int gender = 1;
		String sex = ((gender <= 1 ) ? "남성" : "여성" );
		System.out.println("숫자가 " + gender + "임으로 " + 
		sex + " 입니다.");
		
		int number = 10;
		String type = ((number > 0) ? "양수" : (number < 0) ?
				"음수" : "0");
			System.out.println("숫자가 " + number + " 임으로 " + 
			type + " 입니다.");
			System.out.println("==================");

			//A학점 > 90점 B학점 > 80 C학점 > 70 D학점 > 60 F학점 이하
		int score = 92;
		String grade = ((score > 90) ? "A학점" : (score > 80) ? "B학점"
				: (score > 70) ? "C학점" : (score > 60) ? "D학점" : "F학점");
		System.out.println("점수가 " + score + " 임으로 " + grade + " 입니다.");
	}
}