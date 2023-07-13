package study08;

public class Test_throws {

	public static void main(String[] args) {
		
			try {
				methodTest();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}
	static void methodTest() throws Exception { //try-catch 강제
		System.out.println("test");
	}

}
