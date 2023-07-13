package study05;
class Product {
	private String name = "생산품명";
	private int price;
	String maker = "한국";
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int discount() {
		int result = price-(price/10);
		return result;
	}
}

public class Mouse extends Product {
	public int discount() {
		int price = getPrice()-(getPrice()/5);
		return price;
	}
	public static void main(String[] args) {
		Product m1 = new Product();
		Product m2 = new Product();
		m1.setName("파란마우스");
		m2.setName("검정마우스");
		m1.setPrice(5000);
		m2.setPrice(6000);
		m2.maker = "미국";
	
		System.out.println("제품명 : " + m1.getName() + " / 가격 : " + m1.getPrice() + " / 생산지 : " + m1.maker);
		System.out.println("제품명 : " + m2.getName() + " / 가격 : " + m2.getPrice() + " / 생산지 : " + m2.maker);
		m2.discount();
		System.out.println("할인 제품 안내");
		System.out.println("제품명 : " + m2.getName() + " / 가격 : " + m2.discount() + " / 생산지 : " + m2.maker);
	}
}