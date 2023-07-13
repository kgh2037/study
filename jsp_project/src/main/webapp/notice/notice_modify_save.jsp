<%@page import="java.sql.*"%>
<%@ page import="oracle.jdbc.driver.OracleDriver" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ include file ="../include/oracleCon.jsp" %>
 <%
 		Statement stmt = connection.createStatement();
 %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticemodifysave</title>
</head>
<body>
<% 
	String unq = request.getParameter("unq");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	if(unq == null || unq.equals("")) {
		
%>
		<script>
			alert("잘못된 경로의 접근입니다.")
			history.back();
		</script>
<% 
	}
	
	String sql = "update notice set title='"+title+"', content='"+content+"' where unq='"+unq+"' ";
	int result = stmt.executeUpdate(sql);
	
	if(result == 1) {
		
%>
	<script>
		alert("변경완료!");
		location = 'notice_list.jsp';
	
	</script>

<%
	} else { 
%>
	<script>
		alert("변경실패!");
		history.back();
	</script>
	
<%
	} 
%>
</body>
</html>