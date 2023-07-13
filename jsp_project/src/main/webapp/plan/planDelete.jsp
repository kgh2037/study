<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- DB연결 -->
<%@ include file = "../include/oracleCon.jsp" %>
<!-- 세션인증 -->
<%@ include file = "../include/certify.jsp" %>
<%
String date = request.getParameter("date");
%>
<!-- 널값체크 -->
<%
  if( SessionMemberId == null || SessionMemberId.equals("")){
%>
   <script>
   alert("잘못된 경로로의 접근입니다.");
   history.back();
   </script>
<%
return;
}
 %>
<!-- SQL작성 -->
<% 
   String sql = "delete from sche_mgr where userid='"+SessionMemberId+"' and sche_date = '"+date+"' ";
   Statement stmt = connection.createStatement();
   int result = stmt.executeUpdate(sql);
   if (result == 1){
%>   
   <script>
   alert("일정삭제완료");
   location='planMain.jsp';
   </script>
<%
} else{
%>
   <script>
   alert("삭제실패");
   location='planMain.jsp';
   </script>
<%
}
%>