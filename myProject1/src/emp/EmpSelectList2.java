package emp;

import java.sql.*;

import comm.DbConnect;

public class EmpSelectList2 extends DbConnect {

	public static void main(String[] args) throws Exception{
		  
		Statement stmt = Connection().createStatement();
		
		String sql = "select * from emp order by empno asc";
		ResultSet rs = stmt.executeQuery(sql);
		int total = 0;
		System.out.println("[사원목록] 총 : " + total + "개");
		System.out.println("======================");

		ResultSetMetaData Data = rs.getMetaData();
	    int clcnt = Data.getColumnCount();


	    for (int i = 1; i <= clcnt; i++) {
            System.out.printf("%-12s", "[" + Data.getColumnName(i) + "]");
        }
        System.out.println();
        while (rs.next()) {
        	total++;
        	
            for (int i = 1; i <= clcnt; i++) {
            Object value = rs.getString(i);
            	
	            if (Data.getColumnName(i).equalsIgnoreCase("hiredate")) {
	            		String date2 = value.toString().substring(0, 10);
                        value = date2;
	            }
	            System.out.printf("%-12s", value);
            }
            System.out.println();
        }
        System.out.println("[사원목록] 총 : " + total + "개");
	}
}