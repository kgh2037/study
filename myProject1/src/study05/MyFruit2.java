package study05;

public class MyFruit2 extends AppleInfo {
	public static void main(String[] args) {
	MyFruit2 myFruit = new MyFruit2();
	System.out.println(myFruit.name);
	System.out.println(myFruit.price);
	myFruit.discount();
	System.out.println(myFruit.price);
	}
}