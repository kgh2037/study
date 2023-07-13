package study10;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileCompare {
	public static void main(String[] args) {
		String file1 = "C:\\kgh\\html\\member_info.txt";
		String file2 = "C:\\kgh\\html\\member_info2.txt";
		try {
			FileReader fr1 = new FileReader(file1);
			BufferedReader br1 = new BufferedReader(fr1);
			
			FileReader fr2 = new FileReader(file2);
			BufferedReader br2 = new BufferedReader(fr2);
			
			String a = "";
			String b = "";
			int cnt = 0;
			while(true) {
				if ((( a = br1.readLine()) != null) && (( b = br2.readLine()) != null)) {
					cnt++;
					if(!a.equals(b)) {
						System.out.println(file1 + " > " + cnt + "line : " + a);
						System.out.println(file2 + " > " + cnt + "line : " + b);
						System.out.println();
					}
				}else {
					break;
				}
			}
		}catch(Exception e) {
			}
	}
}