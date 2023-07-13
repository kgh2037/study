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
<title>deptModifySave</title>
</head>
<body>
<% 
	String deptno = request.getParameter("deptno");
	String dname = request.getParameter("dname");
	String loc = request.getParameter("loc");
	
	if(deptno == null || deptno.equals("")) {
		
%>
		<script>
			alert("잘못된 경로의 접근입니다.")
			history.back();
		</script>
<% 
	}
	
	String sql = "update dept set dname='"+dname+"', loc='"+loc+"' where deptno='"+deptno+"' ";
	int result = stmt.executeUpdate(sql);
	
	if(result == 1) {
		
%>
	<script>
		alert("변경완료!");
		location = 'deptList.jsp';
	
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