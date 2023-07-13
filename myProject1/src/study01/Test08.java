package study01;

public class Test08 {

	public static void main(String[] args) {
		
		
		
		//2차원 배열
		//int[][] kors = { { 30, 80, 90 }, { 60, 70, 90 }, { 50, 20, 70, 50 }};
		//3차원 배열
		int[][][] school = { { { 70, 90, 50 },
			{ 50, 20, 70 } } ,{ { 80, 90, 40 },{ 70, 90, 80 } } };
		
		// 2학년 2반 1번 학생 점수
		System.out.println( school[1][1][0]);
	}

}
