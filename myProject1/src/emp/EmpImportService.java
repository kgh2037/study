package emp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

import comm.DbConnect;

public class EmpImportService extends DbConnect{
	 public static void main(String[] args) throws Exception {

		 String path = "c:/temp100/emp_Info.txt";
		 empImport(path);
		
	}
	 public static void empImport(String file_path) throws Exception {
		 Statement stmt = Connection().createStatement();					//DB connect
		 
		 Calendar cal = Calendar.getInstance();
		 long t1 = cal.getTimeInMillis();
		 
		 FileReader file = new FileReader(file_path);						//file Link				
		 BufferedReader buffer = new BufferedReader(file);					//Reader
		 
		 String rowData = "";
		 int cnt = 0;
		 while(true) {
			 if( (rowData = buffer.readLine()) != null ) {
				// System.out.println(rowData);
				 
				 String[] datas = rowData.split("／");
				 
				 
				 String sql = "insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno)"
				 		+ "values( (select max(empno)+1 from emp) ,"
				 		+ "'"+datas[0]+"','"+datas[1]+"','"+datas[2]+"','"+datas[3]+"','"+datas[4]+"',"
				 				+ "'"+datas[5]+"','"+datas[6]+"')";
				 //System.out.println(sql);
				 
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
		 System.out.println("총 " + cnt + "건 입력완료");
		 file.close();
	 }
}

