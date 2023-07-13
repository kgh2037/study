package study05;


public class Books {
	String bookName = "JSP 기초";

	public static void main(String[] args) {
		Books myBook = new Books();
		Books yourBook = new Books("JAVA");
		System.out.println(myBook.bookName);
		System.out.println(yourBook.bookName);
	}
	
	public Books() {
		System.out.println("한빛미디어");
	}
	
	public Books(String name) {
		bookName = name;
	}
}