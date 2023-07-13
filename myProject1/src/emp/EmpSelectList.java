package emp;

import java.sql.ResultSet;
import java.sql.Statement;

import comm.DbConnect;

public class EmpSelectList extends DbConnect {

	public static void main(String[] args) throws Exception{
		  
	Statement stmt = Connection().createStatement(); //주소값에 기재
	
      String sql1 = "select count(*) as total from emp"; 
      ResultSet rs1 = stmt.executeQuery(sql1);
      int total = 0;
      if(rs1.next()) {
         total = rs1.getInt("total");
      } else {
         return;
      }
      
      String sql2 = "select empno"
               + "       ,ename"
               + "       ,job"
               + "       ,mgr"
               + "       ,to_char(hiredate,'yyyy-mm-dd')hiredate"
               + "       ,sal"
               + "       ,comm"
               + "       ,deptno "
               + "from emp "
               + "order by empno asc";
      //query적용
      ResultSet rs2 = stmt.executeQuery(sql2);
      
      System.out.println("[ 사원목록 ] 총 : " +total+ "개 입니다." );
      System.out.println("-------------------------");
	  int number = 0;
	  
      while(rs2.next()) {
          String empno = rs2.getString("empno");
          String ename = rs2.getString("ename");
          String job = rs2.getString("job");
          String mgr = rs2.getString("mgr");
          String hiredate = rs2.getString("hiredate");
          String sal = rs2.getString("sal");
          String comm = rs2.getString("comm");
          String deptno = rs2.getString("deptno");
          
          number++;
          
          System.out.println( number+empno+","+
									  			 ename+","+
									  			 job+","+
									  			 mgr+","+
									  			 hiredate+","+
									  			 sal+","+
									  			 comm+","+
									  			 deptno
									  			 );
          
//          System.out.printf("%-5s %-10s %-10s %-5s %-12s %-8s %-8s %-5s%n",
//                  empno, ename, job, mgr, hiredate, sal, comm, deptno);
      }
   }
}	