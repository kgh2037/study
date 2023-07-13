package study06;

abstract class GoodsInfo {
	public int quantity;
	abstract public void quantityUp(int n);
	abstract public void quantityDown(int n);
	public void quantityZero() {
		quantity = 0;
	}
}

public class Goods extends GoodsInfo {

	public void quantityUp(int i) {
		quantity += i;
	}
	public void quantityDown(int i) {
		quantity -= i;
		if(quantity < 0) {
			quantityZero();
		}
	}
	public static void main(String[] args) {
		Goods goods = new Goods();
		
		System.out.println("상품 잔량 : " + goods.quantity);
		goods.quantityUp(300);
		goods.quantityDown(50);
		System.out.println("상품 잔량 : " + goods.quantity);
		goods.quantityDown(60);
		System.out.println("상품 잔량 : " + goods.quantity);
		goods.quantityDown(200);
		System.out.println("상품 잔량 : " + goods.quantity);
	}
}