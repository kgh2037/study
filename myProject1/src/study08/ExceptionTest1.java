package study08;

public class ExceptionTest1 {
	public void myRun(int a) {
		System.out.println("연산 결과 : " + a);
	}
	public static void main(String[] args) {
		ExceptionTest1 t = new ExceptionTest1();
		int result;
		for ( int i=4; i>=-4; i--) {
			try {
				result = 100/i;
				t.myRun(result);
			}catch (ArithmeticException e) {
				t.myRun(-1);
			}
		}
	}
}
