<%@page import="javax.print.DocFlavor.READER"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/oracleCon.jsp"%>    
<%
String userid = request.getParameter("userid");

String sql = "select count(*) as cnt from memberinfo where userid = '"+userid+"' ";
Statement stmt = connection.createStatement();
ResultSet rs = stmt.executeQuery(sql);
rs.next();
int cnt = rs.getInt("cnt");
String message  = "";
if (cnt == 0) {
	message = "사용 가능한 아이디입니다.";
} else {
	message = "이미 사용중인 아이디입니다.";
}

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div style = "width : 98; height : 98%; background : yellow; text-align : center;">

<%= message %> <br>
<button type = "button" action = >닫기</button>

</div>
</body>
</html>