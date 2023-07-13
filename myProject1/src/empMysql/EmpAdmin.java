package empMysql;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import comm.DbConnect;

public class EmpAdmin extends DbConnect{

	public static void main(String[] args) throws Exception{
		
		System.out.println("1.기본입출력");
		System.out.println("2.부서별출력");
		System.out.println("3.페이지별출력");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("번호입력 >> ");
		int number = scanner.nextInt();
		switch(number) {
		case 1 :
			empDml();
			break;
		case 2 :
			break;
		case 3 :
			break;
		}
	}
	public static void empDml() throws Exception {
		System.out.println("----------");
		System.out.println("1.기본출력");
		System.out.println("2.입력화면");
		System.out.println("3.수정화면");
		System.out.println("4.삭제화면");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("번호입력 >> ");
		int number = scanner.nextInt();
		switch(number) {
		case 1 :
			empSelectList();
			break;
		case 2 :
			empInsert();
			break;
		case 3 :
			empUpdate();
			break;
		case 4 :
			empDelete();
			break;
		}
	}
	public static void empSelectList() throws Exception {
		Statement stmt = mysqlConnect().createStatement();
		String sql = "select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp";
		ResultSet rs = stmt.executeQuery(sql);
		
		System.out.println("EMPNO   ENAME      JOB       MGR    HIREDATE  SAL   COMM DEPTNO");
		int cnt = 0;
		while(rs.next()) {
			cnt++;
			String empno = rs.getString("empno");
			String ename = rs.getString("ename");
			String job = rs.getString("job");
			String mgr = rs.getString("mgr");
			String hiredate = rs.getString("hiredate");
			String sal = rs.getString("sal");
			String comm = rs.getString("comm");
			String deptno = rs.getString("deptno");
			System.out.printf("%-7S %-7S %-12S %-5S %-10S %-5S %-5S %-4S%n", empno, ename, job, mgr, hiredate, sal, comm, deptno);
		}
	}
	public static void empInsert() throws Exception {
		Statement stmt = mysqlConnect().createStatement();
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
	      } else {	
	    	  return;	
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
	      
//	      String sql = "insert into emp values('"+empno+"', '"+ename+"', '"+job+"',"
//	      		+ " '"+mgr+"', '"+hiredate+"', '"+sal+"', '"+comm+"', '"+deptno+"')";
	      String sql = "insert into emp values( max(empno)+1, '"+ename+"', '"+job+"',"
	    		  + " '"+mgr+"', '"+hiredate+"', '"+sal+"', '"+comm+"', '"+deptno+"')";
	      
       int result = stmt.executeUpdate(sql);
       if(result > 0) {
	    	  System.out.println("저장완료");
	      } else {
	    	  System.out.println("저장실패");
	      }
	}
	public static void empUpdate() throws Exception {
		 Statement stmt = mysqlConnect().createStatement();
	      Scanner scanner = new Scanner(System.in);
	     
	      System.out.println("변경 사원 정보 입력>>");
		     
	      
	      System.out.println("1.수정할 사원 번호>>");
	      String empno = scanner.next();
	     
	      String sql2 ="select count(*) cnt from emp where empno ='"+empno+"'";
	      ResultSet rs2 = stmt.executeQuery(sql2);
	      rs2.next();
	      int cnt = rs2.getInt("cnt");
	      if(cnt==0) {
	    	  System.out.println("해당 사원이 없습니다.");
	    	  System.out.println("종료합니다.");
	    	  return;
	      }
	      
	      System.out.print("2.사원이름 >> ");
	      String ename = scanner.next();
	      if(ename.isEmpty()) {
	    	  scanner.close();
	    	  return;
	      }
	      String sename = "ename = '"+ename+"',";
	      System.out.print("3.담당업무 >> ");
	      String job = scanner.next();
	      String sjob= "job = '"+job+"',";
	      System.out.print("4.직속상관 >> ");
	      String mgr = scanner.next();
	      String smgr= "mgr = '"+mgr+"',";
	      System.out.print("5.입사일 >> ");
	      String hiredate = scanner.next();
	      String shiredate= "hiredate = '"+hiredate+"',";
	      System.out.print("6.급여 >> ");
	      String sal = scanner.next();
	      String ssal= "sal = '"+sal+"',";
	      System.out.print("7.상여 >> ");
	      String comm = scanner.next();
	      String scomm= "comm = '"+comm+"',";
	      System.out.print("8.부서번호 >> ");
	      String deptno = scanner.next();
	      String sdeptno= "deptno = '"+deptno+"'";
	      
//	      String sql= " update dept set ename = '"+ename+"',job = '"+job+"',mgr = '"+mgr+"'"
//	      				+ ",hiredate = '"+hiredate+"',sal = '"+sal+"',comm = '"+comm+"',deptno = '"+deptno+"'"
//	      					+ " where empno ='"+empno+"' "; 
	      
	      String sql= " update emp set " + sename + sjob + smgr + shiredate + ssal + scomm + sdeptno
	    		  + " where empno ='"+empno+"' "; 
	      
	      int result = stmt.executeUpdate(sql);
	      if(result>0) {
	    	  System.out.println("변경 완료");
	      }
	    	  else {
	    		System.out.println("변경 실패");	
	    	  }
	      }
	public static void empDelete() throws Exception {
		
	}
}
