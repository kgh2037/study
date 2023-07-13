package study01;

public class Test05 {

	public static void main(String[] args) {
		int count = 1;
		System.out.println(count);
		count = 2;
		System.out.println(count);
		System.out.println("===============");
		
		int number = 1;
		System.out.println(number);
		number = number + 1;
		System.out.println(number);
		number = number + 1;
		System.out.println(number);
		number = number + 1;
		System.out.println(number);
		System.out.println("===============");
		
		int myMoney = 1000;
		myMoney = myMoney + 100;
		System.out.println("용돈 100원 받은 후 잔고 : " + myMoney);
		myMoney = myMoney + 50;
		System.out.println("용돈 50원 받은 후 잔고 : " + myMoney);
		myMoney = myMoney - 30;
		System.out.println("학용품 30원 구매 후 잔고 : " + myMoney);
		int fMoney = 500;
		myMoney = myMoney + fMoney;
		System.out.println("친구 돈 500원 삥듣은 후 잔고 : " + myMoney);
		System.out.println("===============");
		
		int Tom = 100;
		int day1 = 20;
		int day2 = 30;
		int day3 = -10;
		Tom = Tom + day1;
		Tom = Tom + day2;
		Tom = Tom + day3;
		System.out.println("Tom 의 총금액은 " + Tom + "만원입니다.");
		System.out.println("평균수입은 " + ((day1+day2+day3)/3) + "만원입니다.");
		System.out.println("===============");

		int number1 = 20;
		
		number1 += 1;
		System.out.println(number1);
		number1 += 5;
		System.out.println(number1);
		number1 -= 4;
		System.out.println(number1);
		number1 *= 2;
		System.out.println(number1);
		
	}

}
