package study08;

public class Test_throw {
	public static void methodTest() {
		
		try {
			//throw new Exception("헐"); //error 발생 목적으로 사용
			System.out.println(100/0);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) {
		methodTest();
	}
}
