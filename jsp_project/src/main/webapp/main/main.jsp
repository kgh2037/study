<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/oracleCon.jsp" %>

<%
String sql1 = "select a.* from (select unq, substr(title,1,10) as title, name, "
				+	"to_char(rdate,'yy-mm-dd') as rdate from board1 order by unq desc) a where rownum < 6 ";
Statement stmt1 = connection.createStatement();
ResultSet rs1 = stmt1.executeQuery(sql1);

String sql2 = "select a.* from (select unq, substr(title,1,10) as title, name, "
				+	"to_char(rdate,'yy-mm-dd') as rdate from reboard where thread = 'a' order by unq desc )a where rownum < 6 ";
Statement stmt2 = connection.createStatement();
ResultSet rs2 = stmt2.executeQuery(sql2);


%>

<!DOCTYPE html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>게시판 목록</title>
	<link rel = "stylesheet" href = "../css/layout.css">
</head>
<body>
<div class="wrap">
    <header>
      <div class="top_header">

      </div>
    </header>
    <nav>
       <div class="nav_left_space">&nbsp;</div>
      <div class="nav_center_space"> 
 <%@ include file="../include/navmenu.jsp" %>
      </div>
      <div class="nav_right_space">&nbsp;</div>
    </nav>
   <aside>
 <%@ include file="../include/aside.jsp" %>
   </aside>
    <section>
       <article>
				<table style = "width:500px;">
					<caption><b><h1>일반 게시판</h1></b></caption>
						<tr>
								<th width = "15%" > 번호 </th>
								<th> 제목 </th>
								<th width = "20%" > 글쓴이 </th>
								<th width = "20%" > 등록일 </th>
						</tr>
				<%
					int number1 = 0;
					while(rs1.next()) {
						String unq = rs1.getString("unq");
						String title = rs1.getString("title");
						String name = rs1.getString("name");
						String rdate = rs1.getString("rdate");
						number1++;
				%>
					<tr>
							<td><%= number1 %></td>
							<td style = "text-align:left;"><a href = "../board/board1Detail.jsp?unq=<%=unq%>"><%= title %></a></td>
							<td><%= name %></td>
							<td><%= rdate %></td>
					</tr>
				<%
					}
				%>
				</table>	
				<table style = "width:500px;">
					<caption><b><h1>답변 게시판</h1></b></caption>
						<tr>
								<th width = "15%" > 번호 </th>
								<th> 제목 </th>
								<th width = "20%" > 글쓴이 </th>
								<th width = "20%" > 등록일 </th>
						</tr>
						
				<%
						out.print("&nbsp&nbsp");
					int number2 = 0;
					while(rs2.next()) {
						String unq = rs2.getString("unq");
						String title = rs2.getString("title");
						String name = rs2.getString("name");
						String rdate = rs2.getString("rdate");
						number2++;
				%>
					<tr>
							<td><%= number2 %></td>
							<td style = "text-align:left;"><a href = "../board/board1Detail.jsp?unq=<%=unq%>"><%= title %></a></td>
							<td><%= name %></td>
							<td><%= rdate %></td>
					</tr>
				<%
					}
				%>
				</table>					
			
					

       </article>
    </section>
    <footer>
 <%@ include file="../include/footer.jsp" %>
    </footer>
</div>
</body>
</html>