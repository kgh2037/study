package study02;

public class test_levelup {

	public static void main(String[] args) {
		
		int[] score = {90, 70, 88};
		int sum = 0;
		for(int i =0; i<score.length; i++) {
			sum = sum + score[i];
		}
		System.out.println("총합 : " + sum);
		System.out.println("평균 : " + sum/score.length);
		
		String[] subject = { "java", "javascript", "linux"};
		
		for (int i = 0; i<subject.length; i++) {
			System.out.print(subject[i] + " ");
		}
		
	}
}