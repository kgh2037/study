package study05;

public class CherryInfo {
	static String name = "체리";
	static int price = 5000;
	static void discount() {
		price = price - (price/10);
	}
}