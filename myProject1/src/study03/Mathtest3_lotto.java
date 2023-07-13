package study03;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Mathtest3_lotto {

	public static void main(String[] args) {
		
		int[] lotto = new int [6];
		System.out.print("로또번호: ");
		for(int i=0; i<lotto.length; i++) {
		    int num;
		    do {
		        num = (int)(Math.random()*45)+1;
		    //} while (Arrays.asList(lotto).contains(num)); // check if num is already in lotto
		} while (IntStream.of(lotto).boxed().collect(Collectors.toList()).contains(num));
		    lotto[i] = num;
		    System.out.print(lotto[i] + " ");
		}
	}

}
