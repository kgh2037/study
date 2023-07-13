package study04;

public class myMath {

	public static void main(String[] args) {
		double a1 = 12.123456;
		
		double result1 = myPoint(a1, 2);
		System.out.println(result1);
		double result2 = myPoint(a1, 3);
		System.out.println(result2);
		double result3 = myPoint(a1, 4);
		System.out.println(result3);
	}
	
	public static double myPoint(double a1, int p1) {
		//int a2 = (int)(a1 * 100);
		//double a3 = a2/(double)100;
		
		int a2 = (int)(a1 * Math.pow(10,p1));
		double a3 = a2/(double)Math.pow(10,p1);
		return a3;
	}
}