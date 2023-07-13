<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ include file ="../include/oracleCon.jsp" %>
 <%
 		Statement stmt = connection.createStatement();
 %>   
 <%
 		String colname = request.getParameter("colname");
 		String searchtxt = request.getParameter("searchtxt");
 		
 		String str="";
 		if(colname != null && !colname.equals("") && searchtxt != null && !searchtxt.equals("")) {
 			str = " where " + colname + " like '%" + searchtxt + "%'";
 		}
 		
 		String sql = "select unq, title, content, hits, rdate from notice"  + str + " order by unq desc";
	 	ResultSet rs = stmt.executeQuery(sql); 
 %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>notice_list</title>
</head>
	<style>
		body{
			font-size : 12px;
			color : #111111;
			font-family : 맑은고딕;
		}
		table{
			width : 600px;
			border : 1px solid #ccc
			border-collapse : collapse;
		}
		th, td {
			border:1px solid #ccc;
		}
	</style>
<body>
<script>
function fn_delete(unq) {
	if(confirm("정말 삭제 하시겠습니까?")) {
		location="notice_delete.jsp?unq="+unq; 
	}
}
</script>
<div style="margin-bottom:5px;">
	<form name="frm" method="post" action="notice_list.jsp">
		<select name = "colname">
			<option value="unq">게시글번호</option>
			<option value="title">제목</option>
			<option value="content">내용</option>
			<option value="hits">열람수</option>
			<option value="rdate">게시날짜</option>
		</select>
		<input type="text" name="searchtxt">
		<button type="submit">검색</button>
	</form>
	
</div>	

<table border = "1" width = "500">
	<colgroup>
		<col width="5%"/>
		<col width="52%"/>
		<col width="8%"/>
		<col width="25%"/>
		<col width="10%"/>
	</colgroup>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>열람수</th>
		<th>등록일</th>
		<th>삭제</th>
	</tr>
	<%
	while( rs.next() ) {
		String unq = rs.getString("unq");
		String title = rs.getString("title");
		String content = rs.getString("content");
		String hits = rs.getString("hits");
		String rdate = rs.getString("rdate");
	%>
	<tr>
		<th><%=unq %></th>
		<th><a href="notice_modify.jsp?unq=<%=unq%>"><%=title %></a></th>
		<th><%=hits %></th>
		<th><%=rdate %></th>
		<th><button type = "button" onclick="fn_delete('<%=unq %>')">삭제</button></th>
	</tr>
	<%
	}
	%>	

</table>
	<br>
	
	<div style="padding-bottom:10px;">
   <button type="button" onclick="location ='notice_write.jsp'">게시물등록</button>
	</div>

</body>
</html>