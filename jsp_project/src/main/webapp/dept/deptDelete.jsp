<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>

 <%
    Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","c##java","1234");
 		Statement stmt = connection.createStatement();
 %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deptDelete</title>
</head>
<body>
<% 
	String deptno = request.getParameter("deptno");
%>
<%
	String sql = "delete from dept where deptno = '"+deptno+"'";
	int result = stmt.executeUpdate(sql);
	if(result == 1) {
%>
	<script> 
		alert("삭제완료."); 
		location = "deptList.jsp";
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