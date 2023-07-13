package study06;

public class CarVolController {

	public static void main(String[] args) {
		CarVolMake carAudio = new CarVolMake();
		
		carAudio.volUp(30);
		carAudio.volDown(5);
		System.out.println("차량볼륨 : " + carAudio.volLevel);
		carAudio.volPause();
		System.out.println("잠시멈춤 : " + carAudio.volLevel);
		carAudio.volResume();
		System.out.println("재시작 : " + carAudio.volLevel);
		carAudio.volRandom();
		System.out.println("차량볼륨 : " + carAudio.volLevel);
		carAudio.volOff();
		System.out.println("오디오종료 : " + carAudio.volLevel);
		
	}
}