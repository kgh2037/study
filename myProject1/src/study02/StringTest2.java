package study02;

public class StringTest2 {

	public static void main(String[] args) {
		String subject = "  Html,mysql,java  ";
		
		System.out.println(subject);
		System.out.println(subject.replace("mysql","oracle"));
		System.out.println(subject.length());
		String subject2 = subject.trim();
		System.out.println(subject2);
		System.out.println(subject2.substring(11));
		System.out.println(subject2.indexOf(","));
		System.out.println(subject2.charAt(5));
		System.out.println(subject2.contains("javascript"));
		// String[] array = subject2.split(","); 
		//System.out.println(array[1]);하기 코드처럼 하면 배열 선언 생략가능
		System.out.println(subject2.split(",")[1]);
		System.out.println("=======================");
		
		String title = "자바프로그래밍 입문";
		String content = "자바를 이용하여 기초부터 중급까지 완성한다.";
		if (title.contains("자바") && content.contains("자바")) {
			System.out.println("자바라는 단어가 모두 포함되어 있습니다.");
		} else if (title.contains("자바") ||content.contains("자바")) {
			System.out.println("자바라는 단어가 한쪽만 포함되어 있습니다.");
		} else {
			System.out.println("자바라는 단어가 모두 포함되지 않았습니다.");
		}
			System.out.println("=======================");
			
			
		String jumsu = "eng:70,kor:90,math:88";
		String[] Array = jumsu.split(",");
		for(int i=0; i<Array.length; i++) {
		System.out.println(Array[i]);
		}
		System.out.println("=======================");
		//System.out.print(Array[0].length());
		System.out.print(Array[0].substring(4) + " ");
		System.out.print(Array[1].substring(4) + " ");
		System.out.print(Array[2].substring(5) + " ");
		System.out.println();
		System.out.println("=======================");

		
		String birthday = "1990/05/27";
		String[] date = birthday.split("/");
		/*System.out.print(date[0].length());
		System.out.print(date[1].length());
		System.out.print(date[2].length());*/
		System.out.print(date[0].substring(2) + "년 ");
		System.out.print(date[1].substring(1) + "월 ");
		System.out.print(date[2].substring(0) + "일 생");
		System.out.println();
		System.out.println("=======================");
		

		String str = "java";
		for(int i=0; i<str.length(); i++) {
			 for(int j=0; j<i; j++) {
			 System.out.print(" ");
			 }System.out.println(str.charAt(i));
		 }
	}
}