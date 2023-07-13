<%@page import="java.sql.*"%>
<%@ page import="oracle.jdbc.driver.OracleDriver" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ include file ="../include/oracleCon.jsp" %>
 <%
 		Statement stmt = connection.createStatement();
 %>   
 <% 
 String unq = request.getParameter("unq");
 String sql2 = "update notice set hits= (hits+1) where unq='"+unq+"' ";
 ResultSet rs2 = stmt.executeQuery(sql2);
 
 String sql = "select title, content from notice where unq = '"+unq+"'";
 ResultSet rs = stmt.executeQuery(sql);
 rs.next();
 String title = rs.getString("title");
 String content = rs.getString("content");
 
 %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticemodify</title>
</head>
<body>
<form name = "frm" method = "post" action = "notice_modify_save.jsp">
	<table border="1" width = "300">
		<tr>
			<th>제목</th>
				<td> <input type = "text" name="title" value ="<%=title %>"> </td>
		</tr>
		<tr>
			<th>내용</th>
				<td> <input type = "text" name="content" value ="<%=content %>"> </td>
		</tr>
		<tr>
			<th colspan = "2"> 
				<button type = "submit">저장</button>
				<button type = "button" onclick="location='notice_list.jsp'">목록</button>
			</th>
		</tr>
	</table>
</form>

</body>
</html>