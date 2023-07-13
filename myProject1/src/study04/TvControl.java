package study04;

public class TvControl {
	boolean power = false;
	int channel = 0;
	public void power() {
		power =! power;
	}
	public void channelup() {
		channel +=1;
	}
	public void channeldown() {
		channel -=1;
	}
}