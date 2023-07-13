<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/oracleCon.jsp" %>

<%
String userid = (String) session.getAttribute("SessionUserid");
String date = request.getParameter("date");
String title = request.getParameter("title");
String content = request.getParameter("content");
String hide = request.getParameter("hide");

Statement stmt1 = connection.createStatement();
String sql1   = "insert into sche_mgr(unq,userid,sche_date,title,content,hide)"
               + " values(sche_mgr_seq.nextval,'"+userid+"','"+date+"','"+title+"','"+content+"','"+hide+"' ) ";
int result1 = stmt1.executeUpdate(sql1);


%>

<%   


if( result1 == 1 ) {
%>
   <script>
      alert("저장완료");
      location="planMain.jsp";
   </script>
<%
} else {
%>
   <script>
      alert("저장실패");
      history.back();
   </script>
<%   
   return;
}

%>