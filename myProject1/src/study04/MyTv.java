package study04;

public class MyTv {

	public static void main(String[] args) {
		TvControl tv = new TvControl();
		String onfoff = tv.power ? "꺼짐" : "켜짐";
//		tv.power();
		tv.channel = 11;
		tv.channeldown();
		
		System.out.println("전원 : " + onfoff);
		System.out.println("채널 : " + tv.channel);
		
		tv.channelup();
		tv.channelup();
		onfoff = tv.power ? "꺼짐" : "켜짐";
		System.out.println("전원 : " + onfoff);
		System.out.println("채널 : " + tv.channel);

		tv.channeldown();
		tv.channeldown();
		tv.channeldown();
		tv.channeldown();
		onfoff = tv.power ? "꺼짐" : "켜짐";
		System.out.println("전원 : " + onfoff);
		System.out.println("채널 : " + tv.channel);

		tv.power();
		onfoff = tv.power ? "꺼짐" : "켜짐";
		System.out.println("전원 : " + onfoff);
		
	}
}