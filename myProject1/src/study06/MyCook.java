package study06;

class MyCook implements Cookie {
	@Override
	public void makeCookie() {
		System.out.println("내가 만든 까까");
	}
	@Override
	public void makeSalad() {
		System.out.println("내가 만든 싸라드");
	}
}