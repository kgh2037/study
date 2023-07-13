<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/oracleCon.jsp" %>

<%
String unq = request.getParameter("unq");
String pass = request.getParameter("pass");
String del = "작성자에 의해 삭제된 게시물입니다.";
%>
<%
String sql1 = "select gid, thread from reboard where unq = '"+unq+"' and pass = '"+pass+"' ";
Statement stmt1 = connection.createStatement();
ResultSet rs1 = stmt1.executeQuery(sql1);

if(!rs1.next()){
%>
	<script>
		alert("암호를 잘못 입력했습니다.");
		history.back();
	</script>

<%
	return;
}
String dbGid = rs1.getString("gid");
String dbThread = rs1.getString("thread");
String sql = "select count(*) as cnt from reboard where gid = '"+dbGid+"' and thread like '"+dbThread+"_' ";
Statement stmt = connection.createStatement();
ResultSet rs = stmt.executeQuery(sql);
rs.next();
int cnt = rs.getInt("cnt");

 String sql2="";
if(cnt > 0 ) {
	 sql2 = "update reboard set title = '"+del+"', content = '"+del+"' where unq = '"+unq+"' ";
} else {
	 sql2 = "delete from reboard where unq = '"+unq+"'";
}
	int result = stmt.executeUpdate(sql2);
	if(result == 1) {
	%>	
		<script>
		alert("삭제완료");
		location = "reBoardList.jsp";
		</script>
	<% 
	} else {
	%>
		<script>
		alert("뷁뉅궭뉅뛟");
		history.back();
		</script>
	<% 
	}
%>


