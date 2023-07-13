package study10;

import java.io.File;

public class FileDelete {

	public static void main(String[] args) {
		String path = "C:\\kgh\\html\\member_info.txt";
		File file = new File(path);
		if(file.exists()) {
			if(file.delete()) {
				System.out.println("삭제 O");
			} else {
				System.out.println("삭제 X");
			}
		}else {
			System.out.println("파일 존재 X");
		}
		//file.mkdir(); // 파일 생성 method
	}

}
