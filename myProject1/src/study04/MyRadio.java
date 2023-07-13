package study04;

public class MyRadio {

	public static void main(String[] args) {
		RadioControl radio = new RadioControl();
		String onfoff = radio.power ? "꺼짐" : "켜짐";
//		radio.power();
		
		System.out.println("전원 : " + onfoff);
		System.out.println("채널 : " + radio.channel);
		
		radio.channelup();
		radio.channelup();
		radio.channelup();
		onfoff = radio.power ? "꺼짐" : "켜짐";
		System.out.println("전원 : " + onfoff);
		System.out.println("채널 : " + radio.channel);

		radio.channeldown();
		onfoff = radio.power ? "꺼짐" : "켜짐";
		System.out.println("전원 : " + onfoff);
		System.out.println("채널 : " + radio.channel);

		radio.channel = 91;
		System.out.println("채널 : " + radio.channel);
		radio.power();
		onfoff = radio.power ? "꺼짐" : "켜짐";
		System.out.println("전원 : " + onfoff);
		
	}
}