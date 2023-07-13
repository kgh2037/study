package study02;

public class StringTest1 {

	public static void main(String[] args) {
		
		String str = "   javascript   ";
		System.out.println("원문 : " + str);
		System.out.println("원문길이 : " + str.length() );
		
		System.out.println("단어 바꾸기 : " + str.replace("java", "Oracle"));
		System.out.println("공백 지우기 : " + str.replace(" ", ""));
		
		str = str.trim();
				System.out.println("여백삭제 : " + str);
			
		System.out.println(str.substring(0,4));
		System.out.println(str.substring(4));
		
		str = "java,html";
		String[] array = str.split(",");
		System.out.println(array[0]);
		System.out.println(array[1]);
		
		String s1 = "java";
		String s2 = "java";
		String s3 = new String("java");
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s1.equals(s3));
		System.out.println(s2.equals(s3));
		
	}
}