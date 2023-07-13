package study10;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class test {

	public static void main(String[] args) throws IOException {
		File dir = new File("C:\\kgh\\html"); //file or folder 인지 class

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		File[] names = dir.listFiles();
		for(int i=0; i<names.length; i++) {
		
			//if(!(names[i].getName().indexOf("txt")==-1)) { //찾는단어가 없는경우가 아닐때 
			if(names[i].getName().contains("txt")) { //찾는단어가 있는경우 true일때
				System.out.print("<파일>\t");
				System.out.print(names[i].getName() + "\t");
				System.out.print(names[i].length() + "\t");
				System.out.println(df.format(names[i].lastModified()));
			} else {
			}
		}
	}
}
