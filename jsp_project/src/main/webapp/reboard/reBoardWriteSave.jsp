<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/oracleCon.jsp"%>

<title>등록 처리 화면</title>

<%
String title = request.getParameter("title");
String pass = request.getParameter("pass");
String name = request.getParameter("name");
String content = request.getParameter("content");
%>

<%
title = title.trim();
pass = pass.trim();

if(title.equals("") || pass.equals("")) {
%>
   <script>
   alert("제목 또는 암호를 입력해주세요.");
	history.back();
   </script>
<% 
   return;
}

%>
<%
String sql1 = "select nvl(max(gid),0)+1 as mygid from reboard";
Statement stmt1 = connection.createStatement();
ResultSet rs1 = stmt1.executeQuery(sql1);
rs1.next();
String mygid = rs1.getString("mygid");
%>

<%
String sql = "insert into reboard(unq, title, pass, name, content, rdate, gid, thread) " 
           + "values(reboard_seq.nextval, '"+ title +"','"+ pass +"', "
           + " '"+name+"','"+content+"', sysdate , '"+ mygid +"', 'a' )";
Statement stmt = connection.createStatement();
int result = stmt.executeUpdate(sql);
%>


<% 
if(result == 1){
%>
   <script>
   alert("저장완료");
   location = "reBoardList.jsp";
   </script>
<% 
} else {
%>
   <script>
   alert("저장실패");
   history.back();
   </script>
<%
}
%>