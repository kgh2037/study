package dept;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import comm.DbConnect;

public class DeptAdmin extends DbConnect {
	
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("[ 부서정보관리 시스템 ]");
		System.out.println("1.목록  2.추가  3.수정  4.삭제 \n");
		System.out.print("메뉴번호>>");
		int object = scanner.nextInt();
			switch (object) {
			case 1: 
				DeptSelectList();
				break;
			case 2:
				DeptInsert();
				break;
			case 3:
				DeptUpdate();
				break;
			case 4:
				DeptDelete();
				break;
			default : System.out.println("없는 번호 입니다.");
			} 
	}

	public static void DeptSelectList() throws Exception{
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
	public static void DeptInsert() throws Exception{
		Statement stmt = Connection().createStatement();
	    Scanner scanner = new Scanner(System.in);
	    
	    System.out.println("-- 부서정보 입력--");
	    System.out.println("1.부서번호>>");
	    String deptno = scanner.next();
	    
	    String sql2 = "select count(*) cnt from dept where deptno='"+deptno+"'";
	    ResultSet rs2 = stmt.executeQuery(sql2); //
	    rs2.next();	//존재유무 + 커서(포인트)를 아래로 내림
	    
	    int cnt = rs2.getInt("cnt");
	    if(cnt>0) {
	  	  System.out.println("이미 사용중인 번호입니다.");
	  	  System.out.println("종료합니다.");
	  	  return;
	    }
	    System.out.println("2.부서이름>>");
	    String dname = scanner.next();
	    System.out.println("3.부서위치>>");
	    String loc = scanner.next();
	    
	    
	    String sql= "insert into dept(deptno,dname,loc)"
	    				+"values ('"+deptno+"','"+dname+"','"+loc+"')"; //데이터 삽입
	    int result = stmt.executeUpdate(sql);	//executeUpdate : 데이터 입력,업데이트,제거
	    if(result>0) {
	  	  System.out.println("저장완료");
	    }
	  	  else {
	  		System.out.println("저장실패");	
	  	  }
	}
	public static void DeptUpdate() throws Exception{
		Statement stmt = Connection().createStatement();
	    Scanner scanner = new Scanner(System.in);
	   
	    System.out.println("변경 부서 정보 입력>>");
		     
	    
	    System.out.println("1.수정 부서번호>>");
	    String deptno = scanner.next();
	   
	    String sql2 ="select count(*) cnt from dept where deptno ='"+deptno+"'";
	    ResultSet rs2 = stmt.executeQuery(sql2);
	    rs2.next();
	    int cnt = rs2.getInt("cnt");
	    if(cnt==0) {
	  	  System.out.println("동일한 부서번호가 없습니다.");
	  	  System.out.println("종료합니다.");
	  	  return;
	    }
	    
	    System.out.println("2.부서이름>>");
	    String dname = scanner.next();
	    
	    
	    System.out.println("3.부서위치>>");
	    String loc = scanner.next();
	    
	    String sql= " update dept set dname='"+dname+"',loc='"+loc+"' where deptno ='"+deptno+"' "; //데이터 삽입
	    int result = stmt.executeUpdate(sql);	//executeUpdate : 데이터 입력,업데이트,제거
	    if(result>0) {
	  	  System.out.println("변경 완료");
	    }
	  	  else {
	  		System.out.println("변경 실패");	
	  	  }
	}
	public static void DeptDelete() throws Exception{
		Statement stmt = Connection().createStatement();
	    Scanner scanner = new Scanner(System.in);
	   
	    System.out.println("-- 삭제 부서정보 입력--");
	    System.out.println("1.부서번호>>");
	    String deptno = scanner.next();
	    
	    //값의 존재 유무
	    String sql2 = "select count(*) cnt from dept where deptno='"+deptno+"'";
			 ResultSet rs2 = stmt.executeQuery(sql2); //
		   rs2.next();	//존재유무 + 커서(포인트)를 아래로 내림
	   
		    int cnt = rs2.getInt("cnt");
		    if(cnt==0) {
		    	  System.out.println("동일한 부서번호가 없습니다.");
		    	  System.out.println("종료합니다.");
		    	  return;
		      }
	
	    String sql= "delete from dept "
	    				+" where deptno='"+deptno+"' "; //데이터 삽입
	    int result = stmt.executeUpdate(sql);	//executeUpdate : 데이터 입력,업데이트,제거
	    
	    if(result>0) {
	  	  System.out.println("삭제 완료");
	    }
	  	  else {
	  		System.out.println("삭제 실패");	
	  	  }
		}
	}