package study04;

class MySubject1 { //클래스 변수(전역변수) > class 명으로 호출 가능
	static String title; //static : 공유메모리영역에 존재
	int price = 0; // 인스턴스(객체 변수) 
}	
public class MySchool {

	public static void main(String[] args) {
		MySubject1 st1 = new MySubject1();
		MySubject1 st2 = new MySubject1();
		
		st1.title = "java";
		st2.title = "oracle";
		st1.price = 100;
		st2.price = 200;
		
		System.out.println(st1.title);
		System.out.println(st2.title);
		System.out.println(st1.price);
		System.out.println(st2.price);
	}

}
