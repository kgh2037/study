<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/oracleCon.jsp"%>

<title>등록 처리 화면</title>

<%
String unq = request.getParameter("unq");
String title = request.getParameter("title");
String pass = request.getParameter("pass");
String name = request.getParameter("name");
String content = request.getParameter("content");
%>

<%
if(title == null || pass == null ) {
%>
   <script>
   alert("잘못된 경로로의 접근입니다.");
   location = "reBoardList.jsp"; //이전페이지로 GO
   </script>
<% 
   return; 
}
title = title.trim();
pass = pass.trim();
%>


<%
String sql = "select count(*) cnt from reBoard where unq = '"+unq+"' and pass = '"+pass+"'";
Statement stmt = connection.createStatement();
ResultSet rs = stmt.executeQuery(sql);
rs.next();
int cnt = rs.getInt("cnt");
if(cnt == 0) {
%>
	<script>
		alert("암호가 일치하지 않습니다.")
		history.back();
	</script>

<%
	return;
}
%>

<%
String sql2 = "update reBoard set title = '"+title+"', name = '"+name+"',content = '"+content+"',"
				+ " udate = sysdate where unq = '"+unq+"' ";
Statement stmt2 = connection.createStatement();
int result = stmt2.executeUpdate(sql2);
%>

<% 
if(result == 1){
%>
   <script>
   alert("변경완료");
   location = "board1List.jsp";
   </script>
<% 
} else {
%>
   <script>
   alert("변경실패");
   history.back();
   </script>
<%
}
%>