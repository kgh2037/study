package study08;

public class error_checker {

	public static void main(String[] args) {
		//eclipse 에서 캐치하지 못하는 error
		int a = 100;
		int b = 0;
		int[] c = {10, 20, 30};
		String d = "abc";
		System.out.println(c[1]); // 정상 출력 이후 error 발생시 미출력
		try { 
		System.out.println(a/b); //zero 
		System.out.println(c[7]); //배열에 없는 자리번호
		System.out.println(Integer.parseInt(d)); //문자열의 형변환
		System.out.println(d.charAt(4)); //없는 자리번호 
		} catch ( ArithmeticException e ) {
			System.out.println("zero 오류 발생");
		} catch ( ArrayIndexOutOfBoundsException e ) {
			System.out.println("배열 자리번호 오류 발생");
		} catch ( NumberFormatException e ) {
			System.out.println("형변환 오류 발생");
		} catch ( StringIndexOutOfBoundsException e ) {
			System.out.println("문자열 자리 번호 오류 발생");
		} catch ( Exception e ) {
			System.out.println("오류발생");
		}
		System.out.println(d.charAt(0));
	}

}
