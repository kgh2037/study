package study04;

import java.util.Scanner;

public class maxTest {

	public static int maxNum(int[] num) {
		int big = num[0];
		for(int i=0;i<num.length;i++) {
			big = Math.max(big,num[i]);
		}return big;
	}
}