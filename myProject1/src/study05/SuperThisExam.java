package study05;

class Program1 {
	public void pgName() {
		System.out.println("JAVA");
	}
}
class Program2 extends Program1 {
	public void pgName() {  //상위 class인 Program1의 pgName을 overriding
		System.out.println("JSP");
	}
	public void programAll() {
		super.pgName(); //상위 class Program1 class의 pgName / 상속관계에서만 사용
		//this.pgName(); //Program2 class의 pgName
	}
}
public class SuperThisExam {
	public static void main(String[] args) {
		Program2 p2 = new Program2(); //참조class 참조변수 = new 생성자 > 인스턴스 처리
		p2.pgName();
		p2.programAll();
	}
}