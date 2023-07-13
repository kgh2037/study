package study06;

public class BankServiceImpl implements BankService{
	private int Mymoney;
	
	public int getMoney() {
		return Mymoney;
	}
	@Override
	public void moneyInput(int money) {
		Mymoney += money;
		System.out.print("입금액 : " + money + " ");
		moneyPrint();
	}
	@Override
	public void moneyOutput(int money) {
		if (Mymoney < money) {
			System.out.println("보유잔고보다 출금요청액이 큽니다. 재확인해주세요.");
		} else {
			Mymoney -= money;
			System.out.print("출금액 : " + money + " ");
			moneyPrint();
		}
	}
	@Override
	public void moneyPrint() {
		System.out.println("잔액 : " + Mymoney);
	}
}