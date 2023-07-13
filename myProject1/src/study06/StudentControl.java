package study06;

public class StudentControl {
	public static void main(String[] args) {
		int avg = 0;
		Studentimpl s1 = new Studentimpl();
		
		s1.setName("김건호");
		s1.setEng(70);
		s1.setKor(80);
		s1.sum();
		avg = s1.sum()/2;
		
		System.out.println("이름 : " + s1.getName());
		System.out.println("영어점수 : " + s1.getEng() + " / 국어점수 : " + s1.getKor());
		System.out.println("점수합계 : " + s1.sum());
		System.out.println("평균점수 : " + avg);
	}

}
