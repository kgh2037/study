<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="com.DbConnect"%>
    
<%

String code = request.getParameter("code");
Connection connect = DbConnect.oracleCon();

String sql = "select title from pollmain where code = '"+code+"' ";
Statement stmt = connect.createStatement();
ResultSet rs = stmt.executeQuery(sql);
rs.next();
String title = rs.getString("title");

String sql2 = "select code, item from pollsub where code like '"+code+"%' ";
ResultSet rs2 = stmt.executeQuery(sql2);
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>

<script>
	function fn_submit() {
		if(document.frm.item.value == "" {
			alert("항목을 선택해주세요.");
			return false;
		}
		document.frm.submint();
	}
</script>

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
<form name = "frm" method="post" action="/project_servlet1/voteSave">
	<table class = "table1">
		<tr colspan = "3">
			<th width> <%=title %> </th>
		</tr>
		<% 
		int cnt=0;
		while(rs2.next()) {
			String subCode = rs2.getString("code");
			String item = rs2.getString("item");
		cnt++;
		%>
		 <tr>
			<td <%if(cnt%2==0) {%> bgcolor="#e8f4fb" <%} %> >
				<input type="radio" name="subCode" value="<%=subCode%>">
				<%=item %>
		    </td>
		   </tr>
	
		<%
		}
		%>
	</table>
	
	<div>
		<button type="submit" onclick="fn_submit();return false;">투표하기</button>
	</div>
</form>
</body>
</html>