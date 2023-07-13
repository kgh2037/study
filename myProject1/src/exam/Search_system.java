package exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Scanner;

import comm.DbConnect;

public class Search_system extends DbConnect {

	public static void main(String[] args) throws Exception {
		System.out.println("-----------------------------");
		System.out.println("       성적조회 시스템       ");
		System.out.println("-----------------------------");
		System.out.println("1.학생정보목록");
		System.out.println("2.학생성적조회");
		System.out.println("3.회원가입");
		System.out.println("4.정보수정");
		System.out.println("5.정보삭제");
		System.out.println("6.데이터임포트(초도 실행 이후 금지)");
		
		Scanner scanner = new Scanner(System.in);
	      System.out.print("메뉴선택 : ");
	      int menu = scanner.nextInt();
			switch (menu) {
			case 1: 
				StudentList();
				break;
			case 2:
				ExamScoreSearch();
				break;
			case 3:
				InsertData();
				break;
			case 4:
				UpdateData();
				break;
			case 5:
				DeleteData();
				break;
			case 6:
				InputData_Basic();
				break;
			default : System.out.println("없는 번호 입니다.");
			} 
}	 
	
	 public static void StudentList() throws Exception {
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("=======학생 목록 조회=======");
		 System.out.println("1. 전체 조회");
		 System.out.println("2. 학년 조회");
		 System.out.println("3. 학급 조회");
		 System.out.print("메뉴선택 : ");
	      int menu = scanner.nextInt();
		 
		 try {
		      if(menu >= 1 && menu <= 3) {
		    	  Search(menu);
		      }
		    	 else {
		    	  System.out.println("잘못된 번호 입니다.");
		      }
				} catch (Exception e) {
					System.out.println("정상적이지 않은 값입니다.");
				}
	}

			public static void Search(int number) throws Exception {
				 
				  Scanner scanner = new Scanner(System.in);
				  
			    String clValue = "";
			    String clValue2 = "";
			    
			    String where = "";
			    switch(number){
			    	case 1: 
			    		where = "";
			    		break;
			       case 2 :
			    	   System.out.print("검색할 학년을 입력해주세요>>");
			    	   clValue = scanner.nextLine().replaceAll("\\s", "");
			    	   where = "where grade = '"+clValue+"' ";
			       break;
			       case 3 : 
			    	   System.out.print("검색할 학년을 입력해주세요>>");
			    	   clValue = scanner.nextLine().replaceAll("\\s", "");
			    	   System.out.print("검색할 반을 입력해주세요>>");
			    	   clValue2 = scanner.nextLine().replaceAll("\\s", "");
			    	   where = "where grade = '"+clValue+"' and ban = '"+clValue2+"' ";
			       break;
			    }
			
				 
				 Statement stmt = Connection().createStatement();
			   
			   
				 String sql = "select userid, name, gender, to_char(birthday,'yyyy-mm-dd')birthday"
				 		+ " from student_info " + where;
				 
				 ResultSet rs =stmt.executeQuery(sql);
				 
				 System.out.println("     [검색 결과]      ");
				 System.out.println("번호  아이디      이름  성별   생년월일");
				
				int cnt = 0;
				while(rs.next()) {
					cnt++;
					String userid =rs.getString("userid");
					String name =rs.getString("name");
					String gender =rs.getString("gender");
					String birthday =rs.getString("birthday");
					System.out.printf("%-3s %-12s %-5s %-3s %-5s%n",
		               cnt, userid , name, gender, birthday);										
					}
				
				if(cnt==0) {
					System.out.println("***검색 결과가 없습니다.***");
				} else {
					System.out.println("총원 " + cnt + "명");
				}
			}
	 public static void ExamScoreSearch() throws Exception {
		 Scanner scanner = new Scanner(System.in);
		 Statement stmt = Connection().createStatement();
		 
		 System.out.print("검색할 학생 이름을 입력해주세요>>");
		 String clValue = scanner.nextLine().replaceAll("\\s", "");
		 System.out.print("학년을 입력해주세요>>");
  	     String clValue2 = scanner.nextLine().replaceAll("\\s", "");
  	     System.out.print("학기를 입력해주세요>>");
  	     String clValue3 = scanner.nextLine().replaceAll("\\s", "");
  	   
  	     String where = "e.name = '"+clValue+"' and e.grade = '"+clValue2+"' and e.hackgi = '"+clValue3+"'";
		   
		 String sql = "select i.userid as userid, e.name as name, e.grade as grade,"
			 		+ " e.ban as ban, e.hackgi as hackgi, e.eng as eng, e.kor as kor, e.math as math "
			 		+ " from student_info i, exam_score e "
			 		+ "where i.name = e.name and i.grade = e.grade and "+ where;
		 
//		 System.out.println(sql);
		 ResultSet rs =stmt.executeQuery(sql);
		 System.out.println("-----------------");
		 System.out.println("[성적조회결과]");
		
		 
		int cnt = 0;
		 int num = 0;
		 int totalnum = 0;
		 
		while(rs.next()) {
			
			cnt++;
			String ban = rs.getString("ban");
			String userid = rs.getString("userid");
			String name = rs.getString("name");
			String school = "하이미디어고등학교";
			String grade = rs.getString("grade");
			String hackgi = rs.getString("hackgi");
			int eng =rs.getInt("eng");
			int kor =rs.getInt("kor");
			int math =rs.getInt("math");
			int sum = eng + kor + math;
			int avg = sum/3;
			int banrank = 0;
			int totalrank = 0;
			
			//반 석차
			String sql2 = "select a.*, rank() over(order by avg desc) as banrank from (select (eng + kor + math)/3 as avg from exam_score where ban = " 
							+ rs.getString("ban") + " and grade = " + rs.getString("grade") + " and hackgi = " + rs.getString("hackgi")
							+" order by avg desc)a" ;
			

//			System.out.println(sql2);
			Statement stmt2 = Connection().createStatement();
			ResultSet rs2 =stmt2.executeQuery(sql2);
			while(rs2.next()) {
				num++;
				banrank = rs2.getInt("banrank");
			}
			//전교석차
			String sql3 = "select a.*, rank() over(order by avg desc) as totalrank from (select (eng + kor + math)/3 as avg from exam_score where "
						+ "grade = " + rs.getString("grade") + " and hackgi = " + rs.getString("hackgi")
						+" order by avg desc)a" ;
//			System.out.println(sql3);
			Statement stmt3 = Connection().createStatement();
			ResultSet rs3 = stmt3.executeQuery(sql3);
			while(rs3.next()) {
				totalnum++;
				totalrank = rs3.getInt("totalrank");
			}
			
			System.out.println("학생ID : " + userid);
			System.out.println("학생명 : " + name);
			System.out.println("소속학교 : " + school);
			System.out.println("학년 : " + grade + "학년");
			System.out.println("학기 : " + hackgi + "학기");
			System.out.println("영어 국어 수학 합계 평균 (반)석차 (전교)석차");
			System.out.printf("%-4s %-4s %-4s %-4s %-4s %-9s %-5s%n",
               eng, kor, math, sum, avg, banrank+"/"+num, totalrank+"/"+totalnum);										
			}
		
		if(cnt==0) {
			System.out.println("***검색 결과가 없습니다.***");
		} else {
		}
	}
	 public static void InsertData() throws Exception {
		 Scanner scanner = new Scanner(System.in);
		 Statement stmt = Connection().createStatement();
	      
	      System.out.println("회원 가입 화면");
	      System.out.println("1.아이디 >>");
	      String id = scanner.next();
	      
	      String sql2 = "select count(*) cnt from student_info where userid='"+id+"'";
	      ResultSet rs2 = stmt.executeQuery(sql2); //
	      rs2.next();
	      
	      int cnt = rs2.getInt("cnt");
	      if(cnt>0) {
	    	  System.out.println("이미 사용중인 아이디입니다.");
	    	  return;
	      }
	      System.out.println("2.이름 >>");
	      String sname = scanner.next();
	      System.out.println("3.생년월일 >>");
	      String sbirthday = scanner.next();
	      System.out.println("4.성별>>");
	      String sgender = scanner.next();
	      System.out.println("5.학년>>");
	      String sgrade = scanner.next();
	      System.out.println("5.반>>");
	      String sban = scanner.next();
	      
	      
	      String sql= "insert into student_info"
	      				+"values ('"+id+"','"+sname+"','"+sbirthday+"','"+sgender+"','"+sgrade+"','"+sban+"')";
	      int result = stmt.executeUpdate(sql);
	      if(result>0) {
	    	  System.out.println("저장완료");
	      }
	    	  else {
	    		System.out.println("저장실패");	
	    	  }
	      }
	 public static void UpdateData() throws Exception {
		 Scanner scanner = new Scanner(System.in);
		 Statement stmt = Connection().createStatement();
	      System.out.println("개인정보 변경 화면");
	      System.out.println("아이디 입력>>");
	      String id = scanner.next();
	     
	      String sql2 ="select count(*) cnt from student_info where userid ='"+id+"'";
	      ResultSet rs2 = stmt.executeQuery(sql2);
	      rs2.next();
	      int cnt = rs2.getInt("cnt");
	      if(cnt==0) {
	    	  System.out.println("회원 정보가 없습니다.");
	    	  System.out.println("아이디를 확인해주세요.");
	    	  return;
	      }
	      
	      System.out.println("1.변경할 이름>>");
	      String cname = scanner.next();
	      System.out.println("2.변경할 생년월일>>");
	      String cbirthday = scanner.next();
	      System.out.println("3.변경할 성별>>");
	      String cgender = scanner.next();
	      
	      String sql3= "update exam_score set name = '"+cname+"' where name in (select name from student_info where userid = '"+id+"')"; 
	      int result2 = stmt.executeUpdate(sql3);	
	      String sql= " update student_info set name='"+cname+"',birthday='"+cbirthday+"', gender='"+cgender+"' where userid ='"+id+"' "; //데이터 삽입
	      int result = stmt.executeUpdate(sql);	
	      
	      if(result>0 && result2>0) {
	    	  System.out.println("변경 완료");
	      }
	    	  else {
	    		System.out.println("변경 실패");	
	    	  }
	      }
	 public static void DeleteData() throws Exception {
		 Scanner scanner = new Scanner(System.in);
		 Statement stmt = Connection().createStatement();
		 Statement stmt2 = Connection().createStatement();
	     
	      System.out.println("정보 삭제 화면");
	      System.out.println("1. 아이디 >>");
	      String id = scanner.next();
	      
	      String sql2 = "select count(*) cnt from student_info where userid='"+id+"'";
			 ResultSet rs2 = stmt.executeQuery(sql2); 
		   rs2.next();
	     
		    int cnt = rs2.getInt("cnt");
		    if(cnt==0) {
		    	  System.out.println("회원 정보가 없습니다.");
		    	  return;
		      }

		  String sql3= " delete from exam_score where name in "
		    		+ "(select name from student_info where userid = '"+id+"')";
		  int result2 = stmt2.executeUpdate(sql3);	
	      String sql= "delete from student_info where userid='"+id+"' "; 
	      int result = stmt.executeUpdate(sql);	
	      
	      if(result>0 && result2>0) {
	    	  System.out.println("삭제 완료");
	      }
	    	  else {
	    		System.out.println("삭제 실패");	
	    	  }
	      }
	 public static void InputData_Basic() throws Exception {
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("초기 정보 적용 화면");
		 String path_i = "c:/temp100/student_info.csv";
		 String path_s = "c:/temp100/exam_score.csv";
			
			Statement stmt = Connection().createStatement();					
			 
			Calendar cal = Calendar.getInstance();
			 long t1 = cal.getTimeInMillis();
			 
			 FileReader file = new FileReader(path_s);									
			 BufferedReader buffer = new BufferedReader(file);					
			 
			 String rowData = "";
			 int cnt = 0;
			 while(true) {
				 if( (rowData = buffer.readLine()) != null ) {
					 rowData = rowData.replace("'","''");
					 String[] datas = rowData.split(",");
					 datas[0] = datas[0].replace("\uFEFF", "");
					 String sql = "insert into exam_score "
					 		+ "values('"+datas[0]+"','"+datas[1]+"','"+datas[2]+"','"+datas[3]+"','"+datas[4]+"', "
					 				+ "'"+datas[5]+"','"+datas[6]+"')";
					 System.out.println(sql);
					 
					 int result = stmt.executeUpdate(sql);
					 if (result == 1) {
						 cnt++;
					 }
					 
				 } else {
					 break;
				 }
			 }
			 Statement stmt2 = Connection().createStatement();					
				 
				 FileReader file2 = new FileReader(path_i);									
				 BufferedReader buffer2 = new BufferedReader(file2);					
				 
				 String rowData2 = "";
				 int cnt2 = 0;
			 while(true) {
				 if( (rowData2 = buffer2.readLine()) != null ) {
					 rowData2 = rowData2.replace("'","''");
					 String[] datas = rowData2.split(",");
					 datas[0] = datas[0].replace("\uFEFF", "");
					 String sql2 = "insert into student_info "
					 		+ "values('"+datas[0]+"','"+datas[1]+"','"+datas[2]+"','"+datas[3]+"','"+datas[4]+"', "
					 				+ "'"+datas[5]+"')";
					 System.out.println(sql2);
					 
					 int result2 = stmt2.executeUpdate(sql2);
					 if (result2 == 1) {
						 cnt2++;
					 }
					 
				 } else {
					 break;
				 }
			 }
			 	cal = Calendar.getInstance();
				long t2 = cal.getTimeInMillis();
				
			System.out.println(t1-t2 + "밀리 초");
			 System.out.println("시험 성적 " + cnt + "건 입력완료");
			 System.out.println("학생 정보 " + cnt2 + "건 입력완료");
			 file.close();
		 }
		 
}