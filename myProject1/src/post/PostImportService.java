package post;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Statement;
import java.util.Calendar;

import comm.DbConnect;

public class PostImportService extends DbConnect{

	public static void main(String[] args) throws Exception {
		String path = "c:/temp100/post1.csv";
		postImport(path);
	}
	public static void postImport(String path) throws Exception {
		Statement stmt = Connection().createStatement();					//DB connect
		 
		Calendar cal = Calendar.getInstance();
		 long t1 = cal.getTimeInMillis();
		 
		 FileReader file = new FileReader(path);						//file Link				
		 BufferedReader buffer = new BufferedReader(file);					//Reader
		 
		 String rowData = "";
		 int cnt = 0;
		 while(true) {
			 if( (rowData = buffer.readLine()) != null ) {
				// System.out.println(rowData);
				 rowData = rowData.replace("'","''");
				 String[] datas = rowData.split(",");
//				 for (int i = 0; i < datas.length; i++) {
//					    datas[i] = datas[i].replace("'", "''");
//					}
				 
				 String sql = "insert into post2 (A1, A2, A3, A4, A5, A6, A7) "
				 		+ "values('"+datas[0]+"','"+datas[1]+"','"+datas[2]+"','"+datas[3]+"','"+datas[4]+"', "
				 				+ "'"+datas[5]+"','"+datas[6]+"')";
				 System.out.println(sql);
				 
				 int result = stmt.executeUpdate(sql);
				 if (result == 1) {
					 cnt++;
				 }
				 
			 } else {
				 break;
			 }
		 }
		 	cal = Calendar.getInstance();
			long t2 = cal.getTimeInMillis();
			
		System.out.println(t1-t2 + "밀리 초");
		 System.out.println("총 " + cnt + "건 입력완료");
		 file.close();
	 }
}
