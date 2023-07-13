package emp;

import java.sql.*;
import java.util.Scanner;

import comm.DbConnect;

public class EmpInsert2 extends DbConnect {

	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		Statement stmt = Connection().createStatement();
		
		String sql = "select * from emp order by empno asc";
		ResultSet rs = stmt.executeQuery(sql);
		ResultSetMetaData Data = rs.getMetaData();
	    int clcnt = Data.getColumnCount();
	    System.out.print("직원 검색 ");
	    String clsearch = scanner.next();
	    
	    while (rs.next()) {
		    for (int i = 1; i <= clcnt; i++) {
		    	String value = rs.getString(i);
		    	String data = Data.getColumnName(i);
		    	String sql2 = "select count(*) cnt from emp where '"+value+"' = '"+clsearch+"' ";
		    	Statement stmt2 = Connection().createStatement();
		    	ResultSet rs2 = stmt2.executeQuery(sql2);
		    	rs2.next();
		    	int cnt = rs2.getInt("cnt"); 						
		    	if ( cnt > 0 ) { 									
		    		System.out.println("이미 사용중인 '"+data+"' 입니다.");
		    			if (cnt == 0) {
		    				return; 																
		    			}
    			}
		    }
	    }
	    ResultSet rs2 = stmt.executeQuery(sql);
	    Statement stmt2 = Connection().createStatement();
		    while(rs2.next()) {
		    	
		    String clValues = ""; 
		    
		     for (int i = 1; i <= clcnt; i++) {
		    	String data = Data.getColumnName(i);
		    	System.out.print(data + "값 입력 : ");
		    	String a = scanner.next();
		    	clValues += "'" + a + "', ";
		     }
		    clValues = clValues.substring(0, clValues.length() - 2);
		    String sql2 = "insert into emp values(" + clValues + ")";
		    int result = stmt2.executeUpdate(sql2);
		    
		    
		    if(result > 0) {
		    	System.out.println("저장완료");
		    } else {
		    	System.out.println("저장실패");
		    }
	    }
    }
}