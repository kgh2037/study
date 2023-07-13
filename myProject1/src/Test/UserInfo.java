package Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Scanner;

public class UserInfo {
	public static void Sign() throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("[ 회원등록 ]");
		System.out.print("아이디 >> ");
		String Id = scanner.next();
		System.out.print("생년월일 >> ");
		String birthday = scanner.next();
				String[] chkbd = birthday.split("-");
				if(Integer.parseInt(chkbd[0]) < 1900 || Integer.parseInt(chkbd[0]) > 2023
						|| Integer.parseInt(chkbd[1]) < 0 || Integer.parseInt(chkbd[1]) > 12
							|| Integer.parseInt(chkbd[2]) < 0 || Integer.parseInt(chkbd[2]) > 31
						||(Integer.parseInt(chkbd[1]) == 2 && Integer.parseInt(chkbd[2]) > 28)) {
					System.out.println("생년월일을 다시 입력해주세요.");
					return;
				}
		System.out.print("핸드폰 >> ");
		String phoneNum = scanner.next();
				String pattern7 = "01(0|1|6)-[0-9]{3,4}-[0-9]{4}";
				if(!(phoneNum.matches(pattern7))) {
					System.out.println("핸드폰 번호를 다시 입력해주세요.");
					return;
				}
		String file = "C:\\html_test\\UserInfo.txt";
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String readData = "";
		String sameData = "";
		String info = Id +"/" + birthday + "/" + phoneNum;
		while(true) {
			if (( readData = br.readLine()) != null)  {
				String[] array = readData.split("/");
				if (array[0].equals(Id) && array[1].equals(birthday) && array[2].equals(phoneNum)) {
					System.out.println("존재하는 계정입니다.");
					return;
				} else {
					sameData += readData + "\n";
				}
			} else {
				break;
			}
		}
			File UserInfo = new File("C:\\html_test\\UserInfo.txt");
			UserInfo.createNewFile();
			FileWriter fw = new FileWriter(UserInfo,false);
			fw.write(sameData + info);
			System.out.println("회원가입이 완료되었습니다.");
			fw.close();
		}

	public static void List() throws Exception {
		System.out.println("==========================");
		System.out.println("[회원목록]");
		System.out.println("==========================");
		System.out.println("아이디 출생년도(나이) 핸드폰");
		
		
		String file = "C:\\html_test\\UserInfo.txt";
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String readData = "";
			int cnt = 0;
			while(true) {
				if (( readData = br.readLine()) != null)  {
					cnt++;
					String[] array = readData.split("/");
					String[] D = array[1].split("-");
						int born = Integer.parseInt(D[0]);
						Calendar cal = Calendar.getInstance();
						int year = cal.get(Calendar.YEAR);
						int age = year - born;
					
						System.out.println(array[0] +"\t" + D[0] + "(" + age
								+ ")   "+ array[2]);
				} else {
					break;
 				}
			}
	}
	public static void Info() throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("[ 상세정보 ] \n");
		System.out.print("아이디 >> ");
		String Id = scanner.next();
		
		
		String file = "C:\\html_test\\UserInfo.txt";
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String readData = "";
			int cnt = 0;
			while(true) {
				if (( readData = br.readLine()) != null)  {
					cnt++;
					String[] array = readData.split("/");
					if (readData.contains(Id)&& array[0].equals(Id)) {
						System.out.println("아이디 : " + array[0] + "\n출생일 : " + array[1] 
								+ "\n핸드폰 : " + array[2]);
						break;
					} 
				} else {
					System.out.println("미등록 아이디입니다.");
					break;
				}
			}
	}
	public static void Delete() throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("[ 삭제화면 ] \n");
		System.out.print("아이디 >> ");
		String Id = scanner.next();
		
		
		String file = "C:\\html_test\\UserInfo.txt";
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String readData = "";
			String delData = "";
			String sameData = "";
			int cnt = 0;
			while(true) {
				if (( readData = br.readLine()) != null)  {
					cnt++;
					String[] array = readData.split("/");
					if (readData.contains(Id)&& array[0].equals(Id)) {
						delData = readData;
					} else {
						sameData += readData + "\n";
					}
				} else {
					break;
				}
			}
			
			if (delData.equals("")) {
				System.out.println("미등록 아이디입니다.");
			} else {
				FileWriter fw = new FileWriter(file,false);
				fw.write(sameData);
				System.out.println("** 삭제완료 **");
				fw.close();
			}
	}

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1.등록  2.목록  3.상세  4.삭제 \n");
		int object = scanner.nextInt();
			switch (object) {
			case 1: 
				Sign();
				break;
			case 2:
				List();
				break;
			case 3:
				Info();
				break;
			case 4:
				Delete();
				break;
			} scanner.close(); 
	}

}