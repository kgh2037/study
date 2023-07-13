package study04;

class TvInfo {
	String model;
	String color;
	int size;
	int price;
}
public class TvApp {

	public static void main(String[] args) {
		TvInfo type1= new TvInfo();
		type1.model = "M01TV"; 
		type1.color = "Red";
		type1.size = 50;
		type1.price = 150;
		
		TvInfo type2= new TvInfo();
		type2.model = "M02TV"; 
		type2.color = "Blue";
		type2.size = 55;
		type2.price = 200;

		System.out.println("모델명 : " + type1.model + " , 색상 : "
				+ type1.color + ", 크기 : " + type1.size + 
				"인치 , 가격 : " + type1.price + "만원");
		System.out.println("모델명 : " + type2.model + " , 색상 : "
				+ type2.color + ", 크기 : " + type2.size + 
				"인치 , 가격 : " + type2.price + "만원");
	} 
}