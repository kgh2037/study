<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../../include/oracleCon.jsp" %>
<%
   String unq = request.getParameter("unq");
%>
<%
   Statement stmt = connection.createStatement();
         String sql1 = "select unq,name,title,content,rdate,pass "
               +"   from board1 "
               +" where unq='"+unq+"'";
   ResultSet rs1 = stmt.executeQuery(sql1);
   
   rs1.next();
   String title = rs1.getString("title");
   String name = rs1.getString("name");
   String pass = rs1.getString("pass");
   String content = rs1.getString("content");
   String rdate = rs1.getString("rdate");
%>
<%
   if(unq == null ||unq.equals("")){
%>
   <script>
   alert("잘못된 접근입니다.");
   location = "board1List.jsp";
   </script>
<%   
   return;
   }
%>
<!DOCTYPE html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>layout2</title>
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
      aside 영역
   </aside>
    <section>
       <article>
		<form name="frm" method="post" action="board1ModifySave.jsp">
			
			<input type="hidden" name="unq" value="<%=unq %>">
			
			<table>
			   <caption style="font-size:20px;
			               font-weight:bold;">수정화면</caption>
			   <colgrop>
			      <col width="20%"/>
			      <col width="*"/>
			   </colgrop>
			      <tr>
			         <th>제목</th>
			         <td>
			         <input type="text" name="title" style="width:99%;" value="<%=title %>" >
			      
			         </td>
			      </tr>
			      <tr>
			         <th>암호</th>
			         <td>
			         <input type="password" name="pass" style="width:99%;">
			         </td>
			      </tr>
			      <tr>
			         <th>글쓴이</th>
			         <td>
			         <input type="text" name="name" style="width:99%;" value="<%=name %>" readonly>
			         </td>
			      </tr>
			      <tr>
			         <th>내용</th>
			         <td>
			         <textarea name="content" style="width:99%;hight:100px;"><%=content %></textarea>
			         </td>
			      </tr>
			   </table>
			<div style="width:600px;
			          margin-top:10px;
			          text-align:center;">
			   <button type="submit" onclick="fn_submit(); return false;">저장</button>
			   <button type="reset">취소</button>
			</div>
			</form>
       </article>
    </section>
    <footer>
        Footer 영역
    </footer>
</div>
</body>
</html>