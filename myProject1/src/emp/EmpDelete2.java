package emp;

import java.sql.*;
import java.util.Scanner;

import comm.DbConnect;

public class EmpDelete2 extends DbConnect {
 public static void main(String[] args) throws Exception{
	 Scanner scanner = new Scanner(System.in);
		Statement stmt = Connection().createStatement();
		
		String sql = "select * from emp order by empno asc";
		ResultSet rs = stmt.executeQuery(sql);
		ResultSetMetaData Data = rs.getMetaData();
	    int clcnt = Data.getColumnCount();
	    System.out.println("--직원 정보 삭제--");
	    System.out.print("삭제 직원 검색 ");
	    String clsearch = scanner.next();
	    String data = "";
	    int cnt = 0;
	    
	    while (rs.next()) 
		    for (int i = 1; i <= clcnt; i++) {
		    	Object value = rs.getString(i);
		    	data = Data.getColumnName(i);
		    	String sql2 = "select count(*) cnt from emp where " + data + " = '"+clsearch+"'";
		    	Statement stmt2 = Connection().createStatement();
		    	ResultSet rs2 = stmt2.executeQuery(sql2);
		    	rs2.next();
		    	cnt = rs2.getInt("cnt"); 						
		    	if ( cnt > 0 ) { 									
		    		System.out.println("해당 값을 지닌 항목은 '" + data + "'입니다.");
		    			if (cnt == 0) {
		    				return; 																
		    			}
		    	}
		    }
			    String sql3 = "delete from emp where " + data + " = '"+clsearch+"' " ;
			    int result = stmt.executeUpdate(sql3);
			    
			    if(result > 0) {
			    	System.out.println("삭제완료");
			    } else {
			    	System.out.println("삭제실패");
			    }
	    }
 	}
