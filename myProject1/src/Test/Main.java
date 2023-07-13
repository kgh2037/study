package Test;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("1.등록  2.목록  3.상세  4.삭제 \n");
		System.out.print("번호선택 >> ");
		String object = scanner.next();
		
				File UserInfo = new File("C:\\html_test\\UserInfo.txt");
				FileWriter fw = new FileWriter(UserInfo,false);
				fw.write("");
				System.out.println("구리시를 포함한 우편주소 추출 완료");
				fw.close();
		}
	}