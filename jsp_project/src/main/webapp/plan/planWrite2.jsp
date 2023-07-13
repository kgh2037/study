<%@page import="org.apache.jasper.TrimSpacesOption"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
String date = request.getParameter("date");

%>

<!DOCTYPE html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>planWrite</title>
  <link rel = "stylesheet" href = "../css/layout.css";>
</head>
<style>
td {
   text-align:left;
}
</style>
<script>
function fn_submit() {
   if( document.frm.title.value==null || document.frm.title.value.equals("") || ) {
      alert("제목을 입력해주세요");
      document.frm.title.focus();
      return;
   }   
   document.frm.submit();
}

function fn_back() {
   history.back();
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
      <!-- aside menu S -->
      <%@ include file = "../include/navmenu.jsp" %>
      <!-- aside menu E -->
      </div>
      <div class="nav_right_space">&nbsp;</div>
    </nav>
   <aside>
      <!-- aside menu S -->
      <%@ include file = "../include/aside.jsp" %>
      <!-- aside menu E -->
   </aside>
    <section>
       <article>
       <form name="frm" method="post" action="planWriteSave.jsp">       
       <table cellpadding="5">
       <caption style="margin-bottom:10px;"><h3>[일정등록]</h3></caption>
          <tr>
             <th>날짜</th>
             <td><input type="text" name="date" value="<%=date %>" readonly></td>
          </tr>
          <tr>
             <th>제목</th>
             <td><input type="text" name="title"></td>
          </tr>
          <tr>
             <th colspan="2">
             공개여부 
             <input type="radio" name="hide" value="Y"> 예
             <input type="radio" name="hide" value="N" checked> 아니오
             </th>
          </tr>
          <tr>
             <th>내용</th>
             <td><textarea name="content" style="width:98%; height:150px;"></textarea></td>
          </tr>
       
       </table>
       <div style="width:650px; text-align:center; margin-top:10px;">
          <button type="submit" onclick="fn_submit();return false;">저장</button>
          <button type="reset">지우기</button>
          <button type="button" onclick="fn_back();">뒤로가기</button>
       </div>
       </form>

      
       </article>
    </section>
    <footer>
        <!-- footer menu S -->
      <%@ include file = "../include/footer.jsp" %>
      <!-- footer menu E -->
    </footer>
</div>
</body>
</html>