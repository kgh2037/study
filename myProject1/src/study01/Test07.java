package study01;



public class Test07 {

	public static void main(String[] args) {

		System.out.println("한글");
		//char c1 = 'a';
		//char c2 = 'b';
		// char c3 = "a"; //''만 사용 가능
		//char c4 = '가';
		
		//String[] colors = {"blue","yellow","green"};
		byte[] a1 = { 50, 60, 70 };
		//short[] a2 = { 60, 90, 100 };
		//int[] a3 = { 98, 88, 92 };
		long[] a4 = { 1000l, 3000l, 5000l };
		
		System.out.println( a1 );
		System.out.println( a1[0] + "," + a1[1] + "," + a1[2] );
		System.out.println( "long : " + a4[0]);
		
		float[] f1 = { 70.7f, 44.7f, 100.0f };
		System.out.println( "float : " + f1[0]);
		//double[] d1 = { 77.7, 33.12, 99.5 };
		
		double d2 = 12;
		System.out.println( "double : " + d2);
		}
	}