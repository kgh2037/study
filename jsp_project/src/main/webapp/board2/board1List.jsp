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
String sql0 = "SELECT count(*) total from board1";
Statement stmt0 = connection.createStatement();
ResultSet rs0 = stmt0.executeQuery(sql0);
rs0.next();
int total = rs0.getInt("total");

int lastpage = (int)Math.ceil((double)total/10);

//out.print("lastpage : " + lastpage);

int number = total - (Integer.parseInt(viewPage)-1)*10;
%>

<%
String sql1 =  " SELECT b.* FROM ( "
           +" SELECT rownum rn, a.* FROM ( "
           +"          SELECT " 
           +"          unq ,title ,name ,hits ,to_char(rdate,'yyyy-mm-dd') as rdate "
           +"          FROM board1 " 
           +"          ORDER BY unq DESC ) a ) b "
           +" WHERE "
           +" rn >= "+first_rn+" and rn <=" + last_rn;
           //rn >=1  and rn<=10; --1page
           //rn >=11 and rn<=20; --2page
           //rn >=21 and rn<=30; --3page
           //rn >=31 and rn<=40; --4page
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
   <caption>게시판 목록</caption>
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
      String title = rs1.getString("title");   
      String name = rs1.getString("name");   
      String hits = rs1.getString("hits");   
      String rdate = rs1.getString("rdate");   
   %>
      <tr>
         <td><%=number %></td>
         <td><a href="board1Detail.jsp?unq=<%=unq%>"><%=title %></a></td>
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
   <!-- 페이징 처리 -->
   <!--1 2 3... -->
   <%
   for(int i=1; i<=2; i++){
   %>
      <a href = "board1List.jsp?viewPage=<%=i %>"><%=i %></a>
   <% 
   }
   %>
</div>

<div style = "width : 600px; margin-top : 10px; text-align : right;">
   <button type = "button" onclick = "location = 'board1Write.jsp'">글쓰기</button>
</div>
</body>
</html>