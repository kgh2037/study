package post;

import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Scanner;

import comm.DbConnect;

public class PostExportService extends DbConnect{

   public static void main(String[] args) throws Exception {
      
      //Post,Emp 데이터베이스를 특정 파일로 가져오기(export)
      System.out.println("[ Select Export Table ]");
      System.out.println("1.Post\n2.Emp");
      System.out.println("------------------------");
      
      Scanner scn = new Scanner(System.in);
      System.out.print("select num : ");
      int num = scn.nextInt();
      
      //고르시오
      switch(num) {
      case 1 : postExport();
      break;
      case 2 : empExport();
      break;
      default : System.out.println("없는 번호 입니다.");
      }
      
   }
   
   public static void postExport() throws Exception {
      
      Statement stmt = Connection().createStatement();
      System.out.println("Post 정보를 다운받는 중입니다.");
      
      //시작시간 설정
      Calendar cal = Calendar.getInstance();
      long t1 = cal.getTimeInMillis();
      String t1_str = t1+"";
      
      //시작시간으로 파일명 생성(파일중복생성 불가)
      //아다리 ㅈㄴ안맞아서 밀리초 00000에 생성하면 같은 파일 생기기도 하긴함
      //로또보다 확률 낮을듯 ㅋ
      String fileName = "post_"+t1_str.substring(t1_str.length()-5)+".txt";
       //만들어질 파일 경로와 이름
      String downFilepath = "c:/temp100/"+fileName;

      int cnt = 0;
      
      //sql작성 post1에서 다가져옴
      String sql = "select * from post2";
      //sql적용
      ResultSet rs= stmt.executeQuery(sql);
       //파일사용하는 메소드 객체화
        File file = new File(downFilepath);
        FileWriter fw = new FileWriter(file,true);
        while(rs.next()) {
              
              String a1 = rs.getString("a1");
               
              String a2 = rs.getString("a2");
               
              String a3 = rs.getString("a3");
               
              String a4 = rs.getString("a4");
               
              String a5 = rs.getString("a5");
               
              String a6 = rs.getString("a6");
               
              String a7 = rs.getString("a7");
              //변수 content에 한줄씩 저장하고 
              String content = a1+","+a2+" "+a3+" "+a4+" "+a5+" "+a6+" "+a7+"\n";
             
              //생성된 파일에 content 집어쳐넣기
               fw.write(content+"\n");
               cnt++;
        }
        fw.close();
        
        //시간구하깅
        cal = Calendar.getInstance();
         long t2 = cal.getTimeInMillis();
         
         long t3 = t2 - t1;
         
         System.out.println(t3+"밀리 초");
         System.out.println("총 "+cnt+"건 다운완료");
         System.out.println(downFilepath+"로 다운 완료");

   }      

   

   public static void empExport() throws Exception { 
      //Statement은 Java에서 SQL 문을 실행하기 위한 인터페이스입니다. 
      //Connection 객체의 createStatement 메서드를 호출하여 
      //Statement 객체를 생성합니다.
      //Statement 객체를 사용하면 sql문을 데이터베이스로 보내고 실행할 수 있다.
      
      //요약 : 데이터베이스 연결 후 sql문을 실행하기 위한 
      //객체(Statement) 생성
      Statement stmt = Connection().createStatement();
      System.out.println("emp 정보를 다운받는 중입니다.");
      
      //시작시간 설정
      Calendar cal = Calendar.getInstance();
      long t1 = cal.getTimeInMillis();
      String t1_str = t1+"";
      //시작시간으로 파일명 생성
      String fileName = "emp_"+t1_str.substring(t1_str.length()-5)+".txt";
       String downFilepath = "c:/temp100/"+fileName;
       
       int cnt = 0;
      //sql작성
       String sql = "select e1.empno empno,e1.ename ename,e1.job job,e2.ename mgr_name,d.dname dname,e1.hiredate as hiredate,to_char(sysdate,'yyyy')-to_char(e1.hiredate,'yyyy') year"
             + " from emp e1,emp e2,dept d "
              + "   where e1.mgr = e2.empno " 
             + " and e1.deptno = d.deptno"; 
       
      //executeQuery 메서드를 사용하여 결과를 ResultSet로
       //받아올 수 있다.
      ResultSet rs= stmt.executeQuery(sql);
      
      File file = new File(downFilepath);
        FileWriter fw = new FileWriter(file,true);
        
        while(rs.next()) {
              
              String empno = rs.getString("empno");
               
              String ename = rs.getString("ename");
               
              String job = rs.getString("job");
                              
              String mgr_name = rs.getString("mgr_name");
               
              String dname = rs.getString("dname");
               
              String hiredate = rs.getString("hiredate");
               
              String year = rs.getString("year");
               
              String content = empno+"\t"+ename+"\t"+job+"\t"+mgr_name+"\t"
                          +dname+"\t"+hiredate+"\t"+year+"\t";
               
            
            fw.write(content+"\n");
           
           cnt++;
        }
        fw.close();
        //시간구하깅
        cal = Calendar.getInstance();
         long t2 = cal.getTimeInMillis();
         
         long t3 = t2 - t1;
         
         System.out.println(t3+"밀리 초");
         System.out.println("총 "+cnt+"건 다운완료");
         System.out.println(downFilepath+"로 다운 완료");
       
   }

}