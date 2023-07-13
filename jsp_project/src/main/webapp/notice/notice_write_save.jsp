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
<title>notice_write_save</title>
</head>
<body>
<% 
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String rdate = request.getParameter("rdate");

 	if(title == null || title.equals("")) { 
%>
	<script> 
		alert("제목을 입력해주세요."); 
		history.back();
	</script> 
<%
 	return;
	}	 

	String sql = "insert into notice(unq, title, content, rdate) values(notice_unq.nextval,'"+title+"','"+content+"',sysdate)";
	int result = stmt.executeUpdate(sql);
	if(result == 1) {
%>
	<script> 
		alert("저장완료."); 
		location = "notice_list.jsp";
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