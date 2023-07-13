package study06;

public class BankController {

	public static void main(String[] args) {
		BankServiceImpl n1 = new BankServiceImpl();
		n1.getMoney();
		n1.moneyPrint();
		n1.moneyInput(5000);
		n1.moneyInput(5000000);
		n1.moneyOutput(205021);
	}
}