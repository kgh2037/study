package study10;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileReaderExample {

	public static void main(String[] args) throws Exception {
		FileReader file = new FileReader ("C:\\kgh\\html\\javascript_for.html");
		BufferedReader buffer = new BufferedReader(file);
		String rowData = "";
		while(true) {
			if((rowData = buffer.readLine()) != null) {
				System.out.println(rowData);
			} else {
				break;
			}
		}
		file.close();
	}

}
