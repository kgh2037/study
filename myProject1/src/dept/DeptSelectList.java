package dept;

import java.sql.ResultSet;
import java.sql.Statement;

import comm.DbConnect;

public class DeptSelectList extends DbConnect {

   public static void main(String[] args) throws Exception {
     
      Statement stmt = Connection().createStatement();
      String sql2 = "select count(*) cnt from dept";
      ResultSet rs2 = stmt.executeQuery(sql2);
      rs2.next();
      
      int total = rs2.getInt("cnt");
      
      String sql = "select deptno, dname, loc from dept order by deptno asc ";
      ResultSet rs = stmt.executeQuery(sql);
      
      
      
      System.out.println("[ 부서목록 ] 총 : " + total + "개");
      System.out.println("======================");
      
      while(rs.next()) {
         String deptno = rs.getString("deptno");
         String dname = rs.getString("dname");
         String loc = rs.getString("loc");
         System.out.println(deptno + "," + dname+ "," +loc);
      }
   }
} 