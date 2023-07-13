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
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>게시판 글쓰기</title>
<link rel = "stylesheet" href = "../css/layout.css">
</head>
			<script>
			function fn_submit(){
			   var f = document.frm;
			   if(f.title.value == ""){
			      alert("제목을 입력해주세요");
			      f.title.focus();
			      return false;
			   }
			   if(f.pass.value == ""){
			      alert("암호를 입력해주세요");
			      f.pass.focus();
			      return false;
			   }
			   f.submit();
			}
			</script>

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

<form name = "frm" method = "post" action = "board1WriteSave.jsp">
<table>

   <caption>등록화면</caption>
   <colgroup>
      <col width = "20%"/>
      <col width = "*"/>
   </colgroup>
   <tr>
      <th>제목</th>
      <td>
         <input type = "text" name = "title" style = "width:99%;">
      </td>
   </tr>
   <tr>
      <th>암호</th>
      <td>
         <input type = "password" name = "pass" style = "width:99%;">
      </td>
   </tr>
   <tr>
      <th>글쓴이</th>
      <td>
         <input type = "text" name = "name" style = "width:99%;">
      </td>
   </tr>
   <tr>
      <th>내용</th>
      <td>
         <textarea name = "content" style = "width:99%; height:100px;"></textarea>
      </td>
   </tr>
   
</table>

<div>         
   <button type = "submit" onclick = "fn_submit();return false;">저장</button>
   <button type = "reset">취소</button>
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