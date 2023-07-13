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
String gid = request.getParameter("gid");
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
String sql1 = "select gid, thread from reboard where unq = '"+unq+"'";
Statement stmt1 = connection.createStatement();
ResultSet rs1 = stmt1.executeQuery(sql1);
rs1.next();
String dbGid = rs1.getString("gid");
String dbThread = rs1.getString("thread");

String sql2 = "select nvl(max(thread),1) as maxThread from reboard where gid = '"+dbGid+"' and thread like '"+dbThread+"_'";
Statement stmt2 = connection.createStatement();
ResultSet rs2 = stmt2.executeQuery(sql2);
rs2.next();

String maxThread = rs2.getString("maxThread");
String myThread = "";
	
	if(maxThread.equals("1")) {
		myThread = dbThread + 'a';		
	} else {
		char lastWord = maxThread.charAt(maxThread.length()-1);
		lastWord++;
		myThread = dbThread + lastWord;
	}
%>
<%

String sql = "insert into reboard(unq, title, pass, name, content, rdate, gid, thread) " 
           + "values(reboard_seq.nextval, '"+title+"', '"+pass+"', "
           + "'"+name+"', '"+content+"', sysdate, '"+dbGid+"', '"+myThread+"')";
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