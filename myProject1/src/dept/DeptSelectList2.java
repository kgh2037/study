package dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeptSelectList2 {

   public static void main(String[] args) throws Exception {
	   Class.forName("oracle.jdbc.OracleDriver");
	   Connection con = DriverManager.getConnection( "jdbc:oracle:thin:@//localhost:1521/orcl",
			   "c##java", "1234");

	   String sql = "select deptno, dname, loc from dept";
	   ResultSet rs = con.createStatement().executeQuery(sql);

	   while(rs.next()) {
	   	String deptno = rs.getString("deptno");
	   	String dname = rs.getString("dname");
	   	String loc = rs.getString("loc");

	   System.out.println( deptno + dname + loc);
	   }
      }
   }
