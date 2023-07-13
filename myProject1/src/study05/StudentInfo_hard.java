package study05;

class StudentVO2 {
	public String name;
	public int year;
	private int eng;
	private int kor;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	
	
}
class StudentInfo1 extends StudentVO2{
	private int sum;
	private int avg;
	
	public int sum() {
		sum = getEng() + getKor();
		return sum;
	}
	public int avg() {
		avg = (getEng()+getKor())/2;
		return avg;
	}
}
	
public class StudentInfo_hard {
	public static void main(String[] args) {
		StudentInfo1 s =new StudentInfo1();
		s.name = "김철수";
		s.year = 1;
		s.setEng(90);
		s.setKor(80);
		System.out.println("이름 : " + s.name);
		System.out.println("학년 : " + s.year);
		System.out.println("총합 : " + s.sum());
		System.out.println("평균 : " + s.avg());
		
	
	}
}