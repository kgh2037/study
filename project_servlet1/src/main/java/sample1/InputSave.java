package sample1;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DbConnect;

@WebServlet("/InputSave")
public class InputSave extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException{
		
		
		try {
			
			DbConnect db = new DbConnect(); //해당 파일이 HttpServlet을 이미 extends 하고 있기때문에 변수 선언을 통해서 연결
			Connection connection = db.oracleCon(); //
			
			req.setCharacterEncoding("utf-8"); //한글 깨짐 해결
			
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			String name = req.getParameter("name");
			
			System.out.println("아이디 : " + id);
			System.out.println("암호 : " + pwd);
			System.out.println("이름 : " + name);
		
		    
		    String sql = "insert into sample1 values ('"+id+"','"+pwd+"','"+name+"')";
		    Statement stmt = connection.createStatement();
		    
		    int result = stmt.executeUpdate(sql);
		    System.out.println("result : " + result);
		    
		    res.setContentType("text/html;charset=UTF-8");
		    PrintWriter out = res.getWriter();
		    out.print("<script>alert('저장완료');</script>");
		    
		} catch (Exception e) {
			
		}
		
	}
}
