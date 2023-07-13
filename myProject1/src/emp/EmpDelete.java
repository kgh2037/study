package emp;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import comm.DbConnect;

public class EmpDelete extends DbConnect {
	public static void main(String[] args) throws Exception{
		Statement stmt = Connection().createStatement();
		
		Scanner scanner = new Scanner(System.in);
	      System.out.println("---- 삭제 정보 입력 ----");
	      System.out.print("1.사원번호 >> ");
	      int empno = scanner.nextInt();
	      try {
	  		delete(empno);
	  		} catch(Exception e) {
	  			
	  		}
	  	}
	      
public static void delete(int empno) throws Exception {
		
		Statement stmt = Connection().createStatement();
		String sql1 = "select count(*) cnt from emp "
						+" where empno='"+empno+"' ";
		ResultSet rs1 = stmt.executeQuery(sql1);
		
		rs1.next();
		int cnt = rs1.getInt("cnt");
		
		if (cnt ==0) {
			System.out.println("입력한 사원정보가 없습니다.");
			return;
		}
		//delete from emp where empno in('9001','9002')
		String sql2 = "delete from emp where empno ='"+empno+"'";
		int result = stmt.executeUpdate(sql2);
		if( result ==1 ) {
			System.out.println("삭제완료");
		}else {
			System.out.println("삭제실패");
		}
	}
}