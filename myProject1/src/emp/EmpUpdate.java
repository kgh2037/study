package emp;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import comm.DbConnect;

public class EmpUpdate extends DbConnect{
	public static void main(String[] args) throws Exception{
		
		Map<String,String> map = new HashMap<String,String>();
		
		
		Scanner scanner = new Scanner(System.in);
	      System.out.println("---- 사원 정보 입력 ----");
	      System.out.print("1.사원번호 >> ");
	      String empno = scanner.next();
	      
	      map.put("empno","1");
			map.put("ename","1");
			map.put("job","1");
			map.put("mgr","123");
			map.put("hiredate","1111-11-11");
			map.put("sal","2");
			map.put("comm","2");
			map.put("deptno","2");
			
			update(map);
		}
	      
	public static void update(Map map) throws Exception {
		Statement stmt = Connection().createStatement();
		
	      String sql2 = "select count(*) cnt from dept where deptno = '"+map.get("empno")+"' ";
	      ResultSet rs = stmt.executeQuery(sql2);
	      rs.next();
	      int cnt = rs.getInt("cnt"); 						
	      if (cnt > 0 ) { 									
	    	  System.out.println("이미 사용중인 사원번호 입니다.");
	    	  return; 																
	      }
	      
	      
	      String sql = "update emp set"
										+" ename='"+map.get("ename")+"' "
										+"  ,job='"+map.get("job")+"' "
										+"  ,mgr='"+map.get("mgr")+"' "
										+ " ,hiredate='"+map.get("hiredate")+"' "
										+ " ,sal='"+map.get("sal")+"' "
										+ " ,comm='"+map.get("comm")+"' "
										+ " ,deptno='"+map.get("deptno")+"' "
										+ " where empno = '"+map.get("empno")+"' ";
	      int result = stmt.executeUpdate(sql);
	      	  
	      if(result > 0) {
	    	  System.out.println("삭제완료");
	      } else {
	    	  System.out.println("삭제실패");
	      }
  }
}