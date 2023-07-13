<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/oracleCon.jsp" %>

<%  
String viewPage = request.getParameter("viewPage");
if(viewPage == null){
   viewPage = "1";
}

int first_rn = (Integer.parseInt(viewPage)-1) * 10 + 1;
int last_rn = first_rn + 9;
%>

<% 
String sql0 = "SELECT count(*) total from reboard";
Statement stmt0 = connection.createStatement();
ResultSet rs0 = stmt0.executeQuery(sql0);
rs0.next();
int total = rs0.getInt("total");

int lastpage = (int)Math.ceil((double)total/10);

//out.print("lastpage : " + lastpage);

int number = total - (Integer.parseInt(viewPage)-1)*10;
%>

<%
String sql1 =  " select b.* from ( select rownum rn, a.* from ( "
           +"select unq ,title ,name ,hits ,to_char(rdate,'yyyy-mm-dd') as rdate, thread "
           +"from reboard order by gid desc,thread asc ) a ) b where rn >= "+first_rn+" and rn <=" + last_rn;
Statement stmt1 = connection.createStatement();
ResultSet rs1 = stmt1.executeQuery(sql1);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>

<style>
body {
   font-size : 15px;
   font-family : 맑은고딕;
}
table {
   width : 600px;
   border : 1px solid #ccc;
   border-collapse : collapse; 
}
th,td {
   border : 1px solid #555; 
   text-align : "center";
   padding : 5px;
}
caption {
   font-size: 25px;
   font-weight : bold;
   margin-bottom : 5px;
}
</style>

<body>
<table>
   <caption>답변 게시판 목록</caption>
   <colgroup>
      <col width = "10%"/>
      <col width = "*"/>
      <col width = "15%"/>
      <col width = "10%"/>
      <col width = "15%"/>
   </colgroup>
   <tr>
      <th>번호</th>
      <th>제목</th>
      <th>글쓴이</th>
      <th>조회수</th>
      <th>등록일</th>   
   </tr>
   
   <%
   while( rs1.next() ) {
      String unq = rs1.getString("unq");   
      String thread = rs1.getString("thread");   
      String title = rs1.getString("title");   
      String name = rs1.getString("name");   
      String hits = rs1.getString("hits");   
      String rdate = rs1.getString("rdate");   
      
      int thread_len = thread.length();
   %>
   		<tr>
   			<td><%=number %></td>
      <td>
		
		<%
		for (int i=1; i<thread_len; i++) {
			out.print("&nbsp&nbsp");
		}
		if(thread_len >1 ) {
			out.print("(re)");
		}
		%>
         <a href="reBoardDetail.jsp?unq=<%=unq%>"><%=title %></a></td>
   	
         <td><%=name %></td>
         <td><%=hits %></td>
         <td><%=rdate %></td>
      </tr>
   <%
      number--;
   }
   %>
</table>
<div style = "width : 600px; margin-top : 10px; text-align : center;"> 
   <%
   for(int i=1; i<=2; i++){
   %>
      <a href = "reBoardList.jsp?viewPage=<%=i %>"><%=i %></a>
   <% 
   }
   %>
</div>

<div style = "width : 600px; margin-top : 10px; text-align : right;">
   <button type = "button" onclick = "location = 'reBoardWrite.jsp'">글쓰기</button>
</div>
</body>
</html>