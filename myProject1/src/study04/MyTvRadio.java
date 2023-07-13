package study04;

public class MyTvRadio {

	public static void main(String[] args) {
		commonControl tv = new commonControl();
		commonControl radio = new commonControl();
		
		
		tv.power();
		tv.power();
		tv.channel = 998;
		tv.channeldown();
		
		System.out.println("TV 전원 : " + tv.state);
		System.out.println("TV 채널 : " + tv.channel);
		
		tv.channelup();
		tv.channelup();
		
		System.out.println("TV 전원 : " + tv.state);
		System.out.println("TV 채널 : " + tv.channel);

		tv.channeldown();
		tv.channeldown();
		tv.channeldown();
		tv.channeldown();
		System.out.println("TV 전원 : " + tv.state);
		System.out.println("TV 채널 : " + tv.channel);

		tv.power();
		System.out.println("TV 전원 : " + tv.state);
		
		
		
		String onfoffr = radio.power ? "꺼짐" : "켜짐";
		System.out.println("라디오 전원 : " + onfoffr);
		System.out.println("라디오 채널 : " + radio.channel);
		
		radio.channelup();
		radio.channelup();
		radio.channelup();
		onfoffr = radio.power ? "꺼짐" : "켜짐";
		System.out.println("라디오 전원 : " + onfoffr);
		System.out.println("라디오 채널 : " + radio.channel);

		radio.channeldown();
		onfoffr = radio.power ? "꺼짐" : "켜짐";
		System.out.println("라디오 전원 : " + onfoffr);
		System.out.println("라디오 채널 : " + radio.channel);

		radio.channel = 91;
		System.out.println("라디오 채널 : " + radio.channel);
		radio.power();
		onfoffr = radio.power ? "꺼짐" : "켜짐";
		System.out.println("라디오 전원 : " + onfoffr);
		
	}
}