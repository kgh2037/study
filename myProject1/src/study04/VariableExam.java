package study04;

class Score {
	int kor;
	int eng;
}

public class VariableExam {

	public static void main(String[] args) {
		
		Score a1 = new Score();
		a1.kor = 100;
		a1.eng = 90;
		int avg = (a1.kor+a1.eng)/2;
		
		System.out.print("국어 : " + a1.kor);
		System.out.print(" , 영어 : " + a1.eng);
		System.out.print(" , 평균 : " + avg);
	}

}
