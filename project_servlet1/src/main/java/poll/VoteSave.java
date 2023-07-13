package poll;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DbConnect;

@WebServlet("/voteSave")
public class VoteSave extends HttpServlet {

	/**
	 *  @see 설문저장
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DbConnect db = new DbConnect(); 
		Connection connection = DbConnect.oracleCon();
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("utf-8");
		String subCode = request.getParameter("subCode");
		
		try {
			String sql = "update pollsub set vote = vote+1 where code = '"+subCode+"'";
			Statement stmt = connection.createStatement();
			int result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
		}
		out.print("<script> alert('투표완료!'); self.close(); </script>");
	}
}