package study01;

public class Test09 {

	public static void main(String[] args) {
		
		int[][] jumsu = new int[2][3]; 
		jumsu[0][0] = 85;
		jumsu[0][1] = 95;
		jumsu[0][2] = 90;
		
		jumsu[1][0] = 65;
		jumsu[1][1] = 70;
		jumsu[1][2] = 85;
		
		int[][] jumsu2 = { { 85, 95, 90 }, { 65, 70, 85 } };
		//상기 Array 선언과 동일
		
		System.out.println("[0][0] : " + jumsu[0][0]);
		System.out.println("[0][0] : " + jumsu2[0][0]);
		System.out.println("=============================");
		System.out.println("[1][0] : " + jumsu[1][0]);
		System.out.println("[1][0] : " + jumsu2[1][0]);
		System.out.println("=============================");
		System.out.println(jumsu.length);
		System.out.println(jumsu2.length); //배열의 길이
		System.out.println("=============================");
		System.out.println(jumsu[0].length);
		System.out.println(jumsu2[0].length); //첫번째 배열의 변수 수
		System.out.println("=============================");
		System.out.println(jumsu[1].length);
		System.out.println(jumsu2[1].length); //두번째 배열의 변수 수
		System.out.println("=============================");
		
		int[][] points = { { 10, 20, 30 }, { 100, 200, 300 } };
		System.out.println("[0][0] : " + points[0][0]);
		System.out.println("[1][1] : " + points[1][1]);
		System.out.println("=============================");

		String[][] names = { { "java", "jsp", "html" },
				{ "Oracle", "Mysql", "MongoDB" } };
		System.out.println("[0][0] : " + names[0][0]);
		System.out.println("[0][1] : " + names[0][1]);
		System.out.println("[0][2] : " + names[0][2]);
		
	}
}