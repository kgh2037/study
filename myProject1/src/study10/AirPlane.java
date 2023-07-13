package study10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AirPlane {

	public static void main(String[] args) throws IOException {
		File dir = new File("C:\\kgh\\resource\\AirPlane_info");
		String fileName = "C:\\kgh\\resource\\AirPlane_info.txt";
		File[] file = dir.listFiles();
		
		File test = new File("C:\\kgh\\resource\\AirPlane_info.txt");
		if(test.exists()) {
			System.out.println("이미 생성된 파일입니다.");
			return;
		}
		
		for(int i=0; i<file.length; i++) {
			String filelist = file[i].getName();
		try {
			FileReader fr = new FileReader(dir + "\\" + filelist);
			BufferedReader br = new BufferedReader(fr);
			
			String a = "";
			int cnt = 0;
			while(true) {
					if((a = br.readLine()) != null) {
						cnt++;
						if(cnt == 5) {
							String[] array = a.split("/");
								File file1 = new File(fileName);
								FileWriter fw = new FileWriter(file1,true); //덮어쓰기
								fw.write(array[1] + "\n");
								fw.close();
							//System.out.println(array[1]);
						}
					} else {
						break;
					}
				}
			} catch(Exception e) {
				System.out.println("좆됨");
				}
		}
		System.out.println("input sucess");
	}
}