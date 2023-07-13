<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/oracleCon.jsp" %>

<%
String unq = request.getParameter("unq");
String pass = request.getParameter("pass");
%>

<%
String sql = "delete from board1 where unq = '"+unq+"' and pass = '"+pass+"'";
Statement stmt = connection.createStatement();

int result = stmt.executeUpdate(sql);
if(result == 1) {
%>	
	<script>
	alert("삭제완료");
	location = "board1List.jsp";
	</script>
<% 
} else {
%>
	<script>
	alert("암호를 다시 확인해주세요!");
	history.back();
	</script>
<% 
	return;
}
%>