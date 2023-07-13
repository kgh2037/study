package study06;

public class VolMake implements VolService {
	private int volLevel; //초기화 안할 경우 값 0
	
	public int getVolLevel() {
		return volLevel;
	}
	public VolMake() {
		volLevel = 1; //생성자로 인하여 volLevel = 1로 초기화
	}
	public void volUp(int level) {
		volLevel += level;
	}
	public void volDown(int level) {
		volLevel -= level;
	}
	
	
}