package study04;

import java.util.Arrays;
import java.util.Scanner;

public class middleTest {

	public static int middleNum(int[] num) {
		Arrays.sort(num);
		if(num.length%2!=0) {
		int center = num[num.length/2];
		return center;
		} else {
			int center = ((num[num.length/2-1] + num[num.length/2+1])/2);
			return center;
		}
	}
}