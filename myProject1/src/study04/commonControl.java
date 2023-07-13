package study04;

public class commonControl {
	//인스턴스화 된 객체 앞에 static 선언시 class 호출을 통하여
	//재정의 후 사용 가능
	 boolean power = false;
	 int channel = 0;
	 String state = "";
	 
	public void power() {
		power =! power;
		state = power ? "꺼짐" : "켜짐";
	}
	public void channelup() {
		channel +=1;
		switch(channel) {
		case 999 :
			channel = 1;
			break;
		}
	}
	public void channeldown() {
		channel -=1;
		switch(channel) {
		case 0 :
			channel = 999;
			break;
		}
	}
}