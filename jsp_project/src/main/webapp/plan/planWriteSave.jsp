<%@page import="java.awt.Taskbar.State"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/oracleCon.jsp" %>

<%
String date 	= request.getParameter("date");
String title 	= request.getParameter("title");
String hide 	= request.getParameter("hide");
String content 	= request.getParameter("content");
String gubun 	= request.getParameter("gubun");
//널값체크
if(date == null || title == null) {
%>	
	<script>
	alert("잘못된 경로로의 접근입니다.");
	history.back();
	</script>
<% 	
}
String userid = (String)session.getAttribute("SessionUserId");

String sql  = "merge into sche_mgr s "
        	+ "using dual "
        	+ "on (s.userid = '"+userid+"' and to_char(s.sche_date, 'yyyy-mm-dd') = '"+date+"') "
        	+ "when matched then "
        	+ "update set "
        	+ "title = '"+title+"', "
        	+ "hide = '"+hide+"', "
        	+ "content = '"+content+"' "
        	+ "when not matched then "
        	+ "insert (unq, userid, sche_date, title, hide, content) "
        	+ "values (sche_mgr_seq.nextval, '"+userid+"', '"+date+"', '"+title+"', '"+hide+"', '"+content+"')";

// if(gubun.equals("I")) {
// sql = "insert into sche_mgr(unq,userid,sche_date,title,hide,content) "
// 		   + "values (sche_mgr_seq.nextval,'"+userid+"','"+date+"','"+title+"','"+hide+"','"+content+"')";
// } else if(gubun.equals("U")){
// sql = "update sche_mgr set "
// 	+ "title = '"+title+"' ,"
// 	+ "hide = '"+hide+"' ,"
// 	+ "content = '"+content+"' "
// 	+ "where "
// 	+ "userid = '"+userid+"' and to_char(sche_date,'yyyy-mm-dd') = '"+date+"' ";
// }
Statement stmt = connection.createStatement();
int result = stmt.executeUpdate(sql);
if(result == 1) {
%>
	<script>
	alert("일정등록 완료!");
	location="planMain.jsp";
	</script>
<%
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>