package study03;

public class MethodTest2 {

	public static void main(String[] args) {
		num1();
		num2();
		num3();
		num4();
	}

	public static void num1() {
		for(int i=1;i<=10;i++) {
			System.out.print(i + " ");
		}System.out.println();
	}
		
	public static void num2() {
		for(int i=1;i<=20;i++) {
			System.out.print(i + " ");
		}System.out.println();
	}
	
	public static void num3() {
		int i = 1;
		while(i<=10) {
		 System.out.print(i + " ");
		 i++;  
		}System.out.println();
	}

	public static void num4() {
		int i=1;
		while(i<=20) {
		System.out.print(i + " ");
		++i;  
		}System.out.println();
	}
}