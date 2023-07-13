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
<title>noticedelete</title>
</head>
<body>
<% 
	String unq = request.getParameter("unq");
%>
<%
	String sql = "delete from notice where unq = '"+unq+"'";
	int result = stmt.executeUpdate(sql);
	if(result == 1) {
%>
	<script> 
		alert("삭제완료."); 
		location = "notice_list.jsp";
	</script>
	
<%
	} else {
		
%>		
	<script> 
		alert("삭제실패!!"); 
		history.back();
	</script>
<%
	}
%>		
</body>
</html>