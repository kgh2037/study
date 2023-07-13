package study03;

public class Mathtest2 {

	public static void main(String[] args) {
		for(int i=0; i<6; i++) {
			System.out.print((int)(Math.random()*45)+1);
			System.out.print(" ");
		}System.out.println();
		System.out.println("============================");
		
		int n1 = 1000;
		int n2 = 1200;
		System.out.println("max : "+Math.max(n1, n2) +
				" / min : "+Math.min(n1, n2));
		System.out.println("============================");
		
		int hap = 0;
		int[] a1 = { 90, 80, -40 };
		for (int i=0; i<a1.length; i++) {
			hap += Math.abs(a1[i]);
		} System.out.println("총합 : " + hap +
				" / 평균 : " + (hap/a1.length));
		System.out.println("============================");
		
		int[] a2= { 5, 45, 23, 2, 34, 21};
		int max = a2[0];
		int min = a2[0];
		for (int i=0; i<a2.length; i++) {
			max = Math.max(max, a2[i]);
			min = Math.min(min, a2[i]);
		}
		System.out.println("최대 값 : " + max +
				" / 최소 값 : " + min);
		System.out.println("============================");
		
		
	
		int[] lotto = new int [6];
		System.out.print((int)((Math.random()*1000)+1)+"회차 로또 번호 : " );
		for(int i=0; i<lotto.length; i++) {
			lotto[i] = (int)(Math.random()*45)+1;
				System.out.print(lotto[i] + " ");		
		}
	
	
	
	
	}
}