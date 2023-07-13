package study02;

public class test5_Array {

	public static void main(String[] args) {
		char[][] asterisks = new char[5][5];

		for (int i = 0; i < 5; i++) {
		    for (int j = 0; j <= i; j++) {
		        asterisks[i][j] = '*';
		    }
		}

		for (int i = 0; i < 5; i++) {
		    for (int j = 0; j < 5; j++) {
		        if (asterisks[i][j] == '*') {
		            System.out.print("*");
		        } else {
		            System.out.print(" ");
		        }
		    }
		    System.out.println();
		}

		int[][] classA = { { 90, 80, 70 }, { 50, 100, 100 } };
		 int[] hap = new int [2];
		 for (int i=0; i<classA.length; i++) {
			 for (int j=0; j<classA[i].length; j++) {
			 hap[i] += classA[i][j];
			 }
		 }
		 System.out.println("1반 점수 총합 : " + hap[0] + "점 / 평균점수 : " + hap[0]/classA[0].length);
		 System.out.println("2반 점수 총합 : " + hap[1] + "점 / 평균점수 : " + hap[0]/classA[0].length);
		 System.out.println("1학년 점수 총합 : " + (hap[0] + hap[1]) + "점 / 평균점수 : " 
		 + ((hap[0] + hap[1]) / (classA[0].length + classA[1].length)) );
		
		
	}

}
