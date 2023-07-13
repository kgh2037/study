package study10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Bank {
	public static void plus() throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("[ 입 금 화면 ] \n");
		System.out.print("예금주명 : ");
		String name = scanner.next();
		System.out.print("입금액 : ");
		int money = scanner.nextInt();

		String file = "C:\\kgh\\resource\\bankinfo.txt";
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String readData = "";
			String sameData = "";
			String fixData = "";
			int sumMoney = 0;
			int cnt = 0;
			while(true) {
				if (( readData = br.readLine()) != null)  {
					String[] array = readData.split(" : ");
					cnt++;
					
					if (readData.contains(name) && array[0].equals(name)) {
						sumMoney = money + Integer.parseInt(array[1]);
						fixData = array[0] + " : " + sumMoney;
					} else {
						sameData += readData + "\n";
					}
				} else {
					break;
				}
			}
			if(fixData.equals("")) {
				if(!name.matches(".*\\d.*")) {
				fixData = name + " : " + money;
				System.out.println(name + "님의 계좌를 개설하였습니다.");
				System.out.println(name + "님의 잔액은 " + money + "입니다.");
				} else {
					System.out.println("잘못된 이름입니다.");
					return;
				}
			}
		FileWriter fw = new FileWriter(file,false); //덮어쓰기
		fw.write(sameData + fixData);
		System.out.println("input sucess");
		fw.close();
		
		System.out.println(name + "님의 계좌에" + money + "원이 입금되었습니다.");
		System.out.println(name + "님의 잔액은 " + sumMoney + "입니다.");
	}
	
	
	public static void minus() throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("[ 출 금 화 면 ] \n");
		System.out.print("예금주명 : ");
		String name = scanner.next();
		System.out.print("출금액 : ");
		int money = scanner.nextInt();
		
		String file = "C:\\kgh\\resource\\bankinfo.txt";
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String readData = "";
		String sameData = "";
		String fixData = "";
		int sumMoney = 0;
		int cnt = 0;
		while(true) {
			if (( readData = br.readLine()) != null)  {
				cnt++;
				String[] array = readData.split(" : ");
				if (readData.contains(name)&& array[0].equals(name)) {
					if(Integer.parseInt(array[1]) > money) {
					sumMoney = Integer.parseInt(array[1]) - money;
					fixData = array[0] + " : " + sumMoney;
					} else if(Integer.parseInt(array[1]) == money) { 
						sumMoney = Integer.parseInt(array[1]) - money;
						fixData = array[0] + " : " + sumMoney;
						}else {
						System.out.println("잔액이 부족합니다.");
						fixData = readData;
						return;
						}
				} else {
					sameData += readData + "\n";
				}
			} else {
				break;
			}
		}
		
		if(fixData.equals("")) {
			if(!name.matches(".*\\d.*")) {
			System.out.println("통장을 먼저 개설해주세요.");
			return;
			} else {
				System.out.println("잘못된 이름 형식입니다.");
				return;
			}
		} else {
			FileWriter fw = new FileWriter(file,false); //덮어쓰기
			fw.write(sameData + fixData);
			System.out.println("input sucess");
			fw.close();
		}
	System.out.println(name + "님의 계좌에서" + money + "원이 출금되었습니다.");
	System.out.println(name + "님의 잔액은 " + fixData + "원 입니다.");
}
	public static void state() throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("[ 잔 액 확 인 ] \n");
		System.out.print("예금주명 : ");
		String name = scanner.next();
		
		
		String file = "C:\\kgh\\resource\\bankinfo.txt";
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String readData = "";
			int cnt = 0;
			while(true) {
				if (( readData = br.readLine()) != null)  {
					cnt++;
					String[] array = readData.split(" : ");
					if (readData.contains(name)&& array[0].equals(name)) {
						System.out.println(array[0] + "님의 잔액 : " + array[1]);
						break;
					} 
				} else {
					System.out.println("개설된 계좌가 없습니다.");
					break;
				}
			}
	}
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.print("1. 입금  2. 출금  3.잔액확인");
		int object = scanner.nextInt();
			switch (object) {
			case 1: 
				plus();
				break;
			case 2:
				minus();
				break;
			case 3:
				state();
				break;
			} scanner.close(); 
	}
}