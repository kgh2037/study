package study10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class PostAddress {

	public static void main(String[] args) throws Exception {
		String addresslist = "C:\\kgh\\resource\\post1.csv";
		
			FileReader fr = new FileReader(addresslist);
			BufferedReader br = new BufferedReader(fr);
			
			String readData = "";
			String address = "";
			while(true) {
					if((readData = br.readLine()) != null) {
						if(readData.contains("구리시")) {
							address += readData + "\n";
						}
					} else {
						break;
					}
				}br.close();
				File guri = new File("C:\\kgh\\resource\\post_guri.txt");
				FileWriter fw = new FileWriter(guri,false);
				fw.write(address);
				System.out.println("구리시를 포함한 우편주소 추출 완료");
				fw.close();
		}
	}