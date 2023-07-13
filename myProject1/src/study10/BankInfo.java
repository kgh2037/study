package study10;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class BankInfo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("name : ");
		String name = scanner.next();
		System.out.print("money : ");
		String money = scanner.next();
		
		String txt = name + " : " + money + "\n";
		String fileName = "C:\\kgh\\resource\\bankinfo.txt";
		try {
			File file = new File(fileName);
			FileWriter fw = new FileWriter(file,true);
			fw.write(txt);
			System.out.println("input sucess");
			fw.close();
		}catch (Exception e) {
			System.out.println("생성 실패");
		}
	}
}
