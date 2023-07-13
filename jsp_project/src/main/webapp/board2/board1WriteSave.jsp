<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- DB연결 -->
<%@ include file = "../include/oracleCon.jsp"%>

<title>등록 처리 화면</title>

<!-- 파라메터 값 설정 -->
<%
String title = request.getParameter("title");
String pass = request.getParameter("pass");
String name = request.getParameter("name");
String content = request.getParameter("content");
%>

<!-- 널값 체크(제목,암호) -->
<%
if(title == null || pass == null ) {
%>
   <script>
   alert("잘못된 경로로의 접근입니다.");
   location = "board1List.jsp"; //이전페이지로 GO
   </script>
<% 
   return; //jsp 종료
}
title = title.trim();
pass = pass.trim();
%>

<!-- 저장 -->

<%
String sql = "INSERT INTO board1(unq, title, pass, name, content, "
         +                "rdate, udate )" 
           + "VALUES(board1_seq.NEXTVAL, '"+ title +"','"+ pass +"', "
           + " '"+name+"','"+content+"', SYSDATE , SYSDATE )";
Statement stmt = connection.createStatement();
int result = stmt.executeUpdate(sql);
%>

<!-- 메시지 출력 -->

<% 
if(result == 1){
%>
   <script>
   alert("저장완료");
   location = "board1List.jsp";
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