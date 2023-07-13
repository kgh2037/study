package exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Statement;
import java.util.Calendar;

import comm.DbConnect;

public class DataInsert extends DbConnect{

	public static void main(String[] args) throws Exception {
//		String path = "c:/temp100/student_info.csv";
		String path = "c:/temp100/exam_score.csv";
		postImport(path);
	}
	public static void postImport(String path) throws Exception {
		Statement stmt = Connection().createStatement();					
		 
		Calendar cal = Calendar.getInstance();
		 long t1 = cal.getTimeInMillis();
		 
		 FileReader file = new FileReader(path);									
		 BufferedReader buffer = new BufferedReader(file);					
		 
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
				 
//				 String sql = "insert into student_info "
				 String sql = "insert into exam_score "
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
