package emp;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import comm.DbConnect;

public class EmpInsert extends DbConnect {

	public static void main(String[] args) throws Exception{
		Statement stmt = Connection().createStatement();
		
		Scanner scanner = new Scanner(System.in);
	      System.out.println("---- 사원 정보 입력 ----");
	      System.out.print("1.사원번호 >> ");
	      String empno = scanner.next();
	      
	      String sql2 = "select count(*) cnt from emp where empno = '"+empno+"' ";
	      ResultSet rs = stmt.executeQuery(sql2);
	      rs.next();
	      int cnt =0;
	      if( rs.next() ) {
	    	  cnt = rs.getInt("cnt");
	      } else {	//sql 적용오류
	    	  return;	//메소드 종류
	      	}
	      if(cnt>0) {
	    	  System.out.println("이미 사용중인 사원번호 입니다.");
	    	  return;
	      } 
	      
	      System.out.print("2.사원이름 >> ");
	      String ename = scanner.next();
	      System.out.print("3.담당업무 >> ");
	      String job = scanner.next();
	      System.out.print("4.직속상관 >> ");
	      String mgr = scanner.next();
	      System.out.print("5.입사일 >> ");
	      String hiredate = scanner.next();
	      System.out.print("6.급여 >> ");
	      String sal = scanner.next();
	      System.out.print("7.상여 >> ");
	      String comm = scanner.next();
	      System.out.print("8.부서번호 >> ");
	      String deptno = scanner.next();
	      
	      String sql = "insert into emp values('"+empno+"', '"+ename+"', '"+job+"',"
	      		+ " '"+mgr+"', '"+hiredate+"', '"+sal+"', '"+comm+"', '"+deptno+"')";
	      
        int result = stmt.executeUpdate(sql);
	      	  
	      if(result > 0) {
	    	  System.out.println("저장완료");
	      } else {
	    	  System.out.println("저장실패");
	      }
    }
}