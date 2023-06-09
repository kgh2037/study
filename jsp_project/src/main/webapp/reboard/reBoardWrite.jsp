<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>layout2</title>
<link rel = "stylesheet" href = "../css/layout.css">
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
			<form name = "frm" method = "post" action = "reBoardWriteSave.jsp">
			<table>
			
			   <caption style = "font-size = 20px; font-weigh:bold">(답변형)등록화면</caption>
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
 <%@ include file="../include/footer.jsp" %>
    </footer>
</div>
</body>
</html>