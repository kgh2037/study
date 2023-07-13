package post;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import comm.DbConnect;

public class PostSearchService extends DbConnect{

	public static void main(String[] args) throws Exception {
	      System.out.println("[ 우편번호 검색 프로그램 ]");
	      System.out.println("1.우편번호 검색 2.시도 검색 3.구군검색 4.읍면동리 검색 5.건물명 검색");
	      System.out.println("------------------------");
	      
	      Scanner scanner = new Scanner(System.in);
	      System.out.print("메뉴선택 : ");
	      int menu = scanner.nextInt();
	      
	      try {
	      if( menu >= 1 && menu <= 5) {
	    	  addrSearch(menu);
	      } else {
	    	  System.out.println("잘못된 번호 입니다.");
	      }
			} catch (Exception e) {
				System.out.println("정상적이지 않은 값입니다.");
			}
}	 
	      
     public static void addrSearch(int number) throws Exception {
    	 
    	  Scanner scanner = new Scanner(System.in);
    	  
          System.out.print("검색 할 값을 입력해주세요>>");
//          String clValue = scanner.next();
          String clValue = scanner.nextLine().replaceAll("\\s", ""); //검색값을 구 리 시 처럼 검색할경우
          
          String where = "";
          switch(number){
             case 1 : where = "a1 = '"+clValue+"' ";
             break;
             case 2 : where = "a2 like " + "'%"+clValue+"%'" + " or a3 like " + "'%"+clValue+"%'";
             break;
             case 3 : where = "a3 like " + "'%"+clValue+"%'";
             break;
             case 4 : where = "a4 like " + "'%"+clValue+"%'" + " or a5 like " + "'%"+clValue+"%'";
             break;
             case 5 : where = "a7 like " + "'%"+clValue+"%'";
             break;
          }

    	 
    	 Statement stmt = Connection().createStatement();
         
         
    	 String sql = "select a1 || ' ' || a2 || ' ' ||a3 || ' ' || a4 || ' ' || a5 || ' ' || a6 || ' ' || a7 as address"
    	 		+ " from post where " + where;
    	 
    	 ResultSet rs =stmt.executeQuery(sql);
    	 
    	 System.out.println("[우편 주소 검색 결과]");
 		
 		int cnt = 0;
 		while(rs.next()) {
 			cnt++;
 			String report =rs.getString("address");
 			 report = report.replaceAll("\\s+", " ");
 			System.out.println(report);
 		}
 		if(cnt==0) {
 			System.out.println("***검색 결과가 없습니다.***");
 		} else {
 			System.out.println("검색결과 " + cnt + " 개");
 		}
     }
   }
