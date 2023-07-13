package study05;

public class overloading {

	public void sum() {
		System.out.println(10+10);
	}
	
	public void sum(int a) {
		System.out.println(a+10);
	}
	
	public void sum(int a, int b) {
		System.out.println(a+b);
	}
	
	public void sum(int a, int b, int c) {
		System.out.println(a+b+c);
	}
	
	public void sum(String str, int a, int b) {
		System.out.println(str);
		System.out.println(a+b);
	}
	
	public static void main(String[] args) {

	}

}
