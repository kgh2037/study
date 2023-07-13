package study05;

class StudentVO {  //getset 자동 생성 alt + shift + s > r > alt + a 
	public String name;
	public int year;
	private int eng;
	private int kor;
	
	public void seteng(int eng) {
		this.eng = eng;
	}
	public void setkor(int kor) {
		this.kor = kor;
	}
	public int geteng() {
		return eng;
	}
	public int getkor() {
		return kor;
	}
}
public class StudentInfo extends StudentVO{
	private int sum;
	private int avg;
	
	public int sum() {
		sum = geteng() + getkor();
		return sum;
	}
	public int avg() {
		avg = (geteng()+getkor())/2;
		return avg;
	}
	
	public static void main(String[] args) {
		StudentInfo s =new StudentInfo();
		s.name = "김철수";
		s.year = 1;
		s.seteng(90);
		s.setkor(80);
		s.getkor();
		System.out.println("이름 : " + s.name);
		System.out.println("학년 : " + s.year);
		System.out.println("총합 : " + s.sum());
		System.out.println("평균 : " + s.avg());
		
	
	}
}