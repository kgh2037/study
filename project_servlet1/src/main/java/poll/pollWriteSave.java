package poll;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DbConnect;

@WebServlet("/pollWriteSave")
public class pollWriteSave extends HttpServlet {

	/**
	 *  @see 설문저장
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DbConnect db = new DbConnect(); 
		Connection connection = DbConnect.oracleCon();
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("title");
		String[] item = request.getParameterValues("item");
		String sdate = request.getParameter("sdate");
		String edate = request.getParameter("edate");
		String use = request.getParameter("use");
		
		if(title == null || title.trim().equals("")) {
			out.print("<script> alert('제목을 입력해주세요.'); history.back(); </script>");
			return;
		}
		
		if(use == null ) {
			use = "Y";
			
			String sql1 = "insert into pollmain(code, title, sdate, edate, use, rdate) "
							+"values(pollmain_seq.nextVal, '"+title+"', '"+sdate+"', '"+edate+"', '"+use+"', sysdate)";
			try {
				Statement stmt = connection.createStatement();
				int result = stmt.executeUpdate(sql1);
				int cnt = 0;
				if (result == 1 ) {
					
					for(int i=0; i<item.length; i++) {
						String  n = "";
						if(item[i] != null && !item[i].trim().equals("")) {
						cnt++;
						n = ((cnt<10)?"0":"")+cnt;
						String sql2 = "insert into pollsub(code,item) values(pollmain_seq.currval||'"+n+"', '"+item[i]+"')";
						stmt.executeQuery(sql2);
						}
					}
				} if(result ==1 && cnt > 0) {
					out.print("<script> alert('설문이 저장되었습니다.'); </script>");
				}
			} catch (SQLException e) {
			}
			
		}
	}

}
