package study10;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class DirList {

	public static void main(String[] args) throws IOException {
		File dir = new File("C:\\kgh\\html"); //file or folder 인지 class

		/*		if(dir.exists()==false) {
			dir.mkdirs();
		}
		File file1 = new File("C:\\kgh\\html\\javascript_for.html");
		if(file1.exists()==false) {
			file1.createNewFile();
		}
*/
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		File[] names = dir.listFiles();
		for(int i=0; i<names.length; i++) {
			if(names[i].isDirectory()) {
				System.out.print("<폴더>\t");
			} else {
				System.out.print("<파일>\t");
				System.out.print(names[i].getName() + "\t");
				System.out.print(names[i].length() + "\t");
				System.out.println(df.format(names[i].lastModified()));
			}
		}
	}

}
