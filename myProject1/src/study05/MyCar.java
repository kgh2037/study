package study05;

public class MyCar {
	int maxSpeed;
	String carName;
	String carColor;
	
	public MyCar(String Name, int speed) {
		carName = Name;
		maxSpeed = speed;
	}
	public MyCar(String Name, int speed, String color) {
		carName = Name;
		maxSpeed = speed;
		carColor = color;
	}
	
	public void maxSpeedUpdate(int speed) {
		maxSpeed = (maxSpeed + speed);
	}

	public static void main(String[] args) {
		MyCar car1 = new MyCar("소나타",230);
		MyCar car2 = new MyCar("그랜져",300,"white");
		System.out.println("차량명 : " + car1.carName + " / 최고속도 : " + car1.maxSpeed);
		System.out.println("차량명 : " + car2.carName + " / 최고속도 : " + car2.maxSpeed);
		car1.maxSpeedUpdate(-20);
		System.out.println(car1.carName + ":" + car1.maxSpeed);
	}
}