package study04;


class BookInfo {
	int price = 10000;
	String title = "JAVA 기초";
}

public class ObjectTest1 {
	int a = 10;
	int b = 20;

	public static void main(String[] args) {
		ObjectTest1 t1 = new ObjectTest1();
		System.out.println(t1.a + t1.b);
		
		BookInfo info = new BookInfo();
		System.out.println(info.title + ":" +info.price);
	}

}
