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
<title>deptWriteSave</title>
</head>
<body>
<% 
	String deptno = request.getParameter("deptno");
	String dname = request.getParameter("dname");
	String loc = request.getParameter("loc");

	if(deptno == null || deptno.equals("")) {
%>
	<script> 
		alert("부서번호를 입력해주세요."); 
		history.back();
	</script>
<%
	return;
	}	
	if(dname == null || dname.equals("")) {
%>
	<script> 
		alert("부서이름을 입력해주세요."); 
		history.back();
	</script>
<%
	return;
	}	
	if(dname == null || dname.equals("")) {
%>
	<script> 
		alert("부서위치를 입력해주세요."); 
		history.back();
	</script>
<%
	return;
	}	

	String sql = "insert into dept(deptno, dname, loc) values('"+deptno+"','"+dname+"','"+loc+"')";
	int result = stmt.executeUpdate(sql);
	if(result == 1) {
%>
	<script> 
		alert("저장완료."); 
		location = "deptList.jsp";
	</script>
	
<%
	} else {
		
%>		
	<script> 
		alert("저장실패!!"); 
		history.back();
	</script>
<%
	}
%>		
	


</body>
</html>