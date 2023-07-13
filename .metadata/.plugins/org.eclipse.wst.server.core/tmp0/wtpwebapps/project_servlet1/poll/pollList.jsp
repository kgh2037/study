<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.DbConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
Connection connect = DbConnect.oracleCon();

String sql = "SELECT code,  "
		   + "       title, "
           + "	     to_char(sdate,'yyyy/mm/dd') sdate,"
           + "	     to_char(edate,'yyyy/mm/dd') edate,"
           + "	     decode(use,'Y','사용','N','미사용') use  "
           + "FROM pollmain "
           + "ORDER BY code DESC ";
Statement stmt = connect.createStatement();
ResultSet rs = stmt.executeQuery(sql);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문목록 (관리자)</title>
</head>
<style>
body {
	font-size : 16px;
	font-family : 맑은고딕;
	line-height : 2.0;
}
.table1 {
	width : 700px;
	border : 1px solid #ccc;
	border-collapse : collapse; /*cell간격*/
}
.table1 th,td {
	padding : 5px;
	border : 1px solid #ccc;
	height : 45px;	
}

</style>
<body>
<table class = "table1">
	<tr>
		<th width = "10%">번호</th>
		<th width = "*%">제목</th>
		<th width = "30%">기간</th>
		<th width = "15%">결과보기</th>
		<th width = "15%">사용여부</th>
	</tr>
	<% 
	while(rs.next()) {
		String code = rs.getString("code");
		String title = rs.getString("title");
		String sdate = rs.getString("sdate");
		String edate = rs.getString("edate");
		String use = rs.getString("use");
	%>
	<tr align = "center">
		<td><%=code %></td>
		<td align = "left"><a href = "pollModify.jsp?code=<%=code %>"><%=title %></a></td>
		<td><%=sdate %>~<%=edate %></td>
		<td><button type = "button">결과보기</button></td>
		<td><%=use %></td>
	</tr>
	<%
	}
	%>
</table>
</body>
</html>