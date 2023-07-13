package study06;

import java.util.Random;

public class CarVolMake implements CarVolService {

	int volLevel = 0;
	int memory = 0;
	
	@Override
	public void volUp(int level) {
		volLevel += level;
	}
	@Override
	public void volDown(int level) {
		volLevel -= level;
	}
	@Override
	public void volOff() {
		volLevel = 0;
	}
	@Override
	public void volPause() {
		memory = volLevel;
		volLevel = 0;
	}
	@Override
	public void volResume() {
		volLevel = memory;
		memory = 0;
	}
	public void volRandom() {
		System.out.println("약기운에 취해 볼륨을 막 돌립니다.");
		Random volRandom = new Random();
		volLevel = volRandom.nextInt(100)+1;
		if (volLevel > 60) {
			System.out.println("볼륨이 " + volLevel + " 에 도달아 귀가 멀었습니다." );
			volLevel = 0;
			System.out.println("박쥐새끼마냥 주파수로 소리를 느끼며 볼륨을 조절합니다.");
			volLevel = volRandom.nextInt(20)+1;
		} 
	}
}