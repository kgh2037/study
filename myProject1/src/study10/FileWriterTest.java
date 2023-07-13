package study10;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileWriterTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("userid : ");
		String userid = scanner.next();
		System.out.print("userpass : ");
		String userpass = scanner.next();
		
		String txt = "userid : " + userid + "\n" + "userpass : "+ userpass;
		String fileName = "C:\\kgh\\html\\member_info.txt";
		try {
			File file = new File(fileName); //file or folder 인지 class
			//FileWriter fw = new FileWriter(file,true); //이어쓰기
			FileWriter fw = new FileWriter(file,false); //덮어쓰기
			fw.write(txt);
			System.out.println("input sucess");
			fw.close();
		}catch (Exception e) {
			System.out.println("생성 실패");
		}
	}

}
