package study04;

class Tvinfo2 {
	String model;
	String color;
	int size;
	int price;
}
public class TvApp2 {

	public static void main(String[] args) {
		String ment[] = {"모델명 : ", "색상 : ", "크기 : ", "가격 : "};
		String[] array = new String[8];
		String type[] = {"M01TV, ","Red, ","50인치, ","150만원"};
		String type2[] = {"M02TV, ","Blue, ","55인치, ","200만원"};

		for(int i=0; i<array.length; i++) {
			if (i%2==0) {
					array[i] = ment[i/2];
			} else {
					array[i] = type[(i-1)/2];
				}
			System.out.print(array[i]);
		}
		System.out.println();

		for(int i=0; i<array.length; i++) {
			if (i%2==0) {
					array[i] = ment[i/2];
			} else {
					array[i] = type2[(i-1)/2];
				}
			System.out.print(array[i]);
		}
	} 
}
		
		
//		Tvinfo2 type1= new Tvinfo2();
//		type1.model = "M01TV"; 
//		type1.color = "Red";
//		type1.size = 50;
//		type1.price = 150;
//		
//		Tvinfo2 type2= new Tvinfo2();
//		type2.model = "M02TV"; 
//		type2.color = "Blue";
//		type2.size = 55;
//		type2.price = 200;

//		System.out.println("모델명 : " + type1.model + " , 색상 : "
//				+ type1.color + ", 크기 : " + type1.size + 
//				"인치 , 가격 : " + type1.price + "만원");
//		System.out.println("모델명 : " + type2.model + " , 색상 : "
//				+ type2.color + ", 크기 : " + type2.size + 
//				"인치 , 가격 : " + type2.price + "만원");