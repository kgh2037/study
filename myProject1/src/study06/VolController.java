package study06;

public class VolController {

	
	public static void main(String[] args) {
		VolMake tv = new VolMake();
		VolMake radio = new VolMake();
		System.out.println("tv 볼륨 : " + tv.getVolLevel() + " / radio 볼륨 : " + radio.getVolLevel());
	
		tv.volUp(10);
		radio.volUp(30);
		System.out.println("tv 볼륨 : " + tv.getVolLevel() + " / radio 볼륨 : " + radio.getVolLevel());

		tv.volDown(5);
		radio.volDown(20);
		
		System.out.println("tv 볼륨 : " + tv.getVolLevel() + " / radio 볼륨 : " + radio.getVolLevel());
	}
}