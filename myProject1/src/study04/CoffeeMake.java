package study04;

class CoffeeInfo {
	String name = "";
	int price = 0;
	static String maker = ""; //class 변수 선언으로 인하여 16번줄에서
	// coffee1.maker를 "가나"로 초기화 했으나 22번줄에서 최종적으로
	// coffee2.maker를 "홍콩"으로 초기화하여 maker값은 "홍콩"으로 초기화 됨
}

public class CoffeeMake {

	public static void main(String[] args) {

		CoffeeInfo coffee1 = new CoffeeInfo();
		coffee1.name = "아메리카노";
		coffee1.price = 3000;
		coffee1.maker = "가나";

		CoffeeInfo coffee2 = new CoffeeInfo();
		coffee2.name = "바닐라라떼";
		coffee2.price = 4500;
		coffee2.maker = "홍콩";
		
		System.out.println("커피 1 이름 :" + coffee1.name );
		System.out.println("커피 1 가격:" + coffee1.price );
		System.out.println("커피 1 원산지 :" + coffee1.maker );

		System.out.println("커피 2 이름 :" + coffee2.name );
		System.out.println("커피 2가격:" + coffee2.price );
		System.out.println("커피 2 원산지 :" + coffee2.maker );
	}

}
