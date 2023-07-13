package study04;

import java.util.Scanner;

public class minTest {
	
	public static int minNum(int[] num) {
		int small = num[0];
		for(int i=0;i<num.length;i++) {
			small = Math.min(small,num[i]);
		}return small;
	}
}
