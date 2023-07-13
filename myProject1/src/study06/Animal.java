package study06;

abstract class Sound {
	abstract void cry();
}
class Cat extends Sound {
	void cry() {
		System.out.println("미야아아아아아ㅗㅇ오오오옹!!");
	}
}

class Dog extends Sound {
	void cry() {
		System.out.println("머어어엉ㅁ어어어멍엉");
	}
}
public class Animal {
	public static void main(String[] args) {
		
		// Sound a = new Sound(); error event. 추상 class 는 instanse 생성 불가 
		Cat cat = new Cat();
		Dog dog = new Dog();
		cat.cry();
		dog.cry();
	}

}
