<%@page import="conn.Cookies"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
Cookies cookies = new Cookies(request);
String cookie_id = cookies.getValue("CookieUserId");
if(cookie_id == null) {
	cookie_id = "";
}
%>
<!DOCTYPE html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>loginwrite</title>
 <link rel="stylesheet" href="../css/layout.css">
</head>

<script>
function fn_submit(){
   if(document.frm.userid == "" || document.frm.userpw == "") {
      alert("아이디와 암호를 확인해주세요");
      document.frm.userid.focus();
      return false;
   }
   document.frm.submit();
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
         <!--  nav menu S  -->
            <%@include file="../include/navmenu.jsp" %>
         <!--  nav menu E  -->
      </div>
      <div class="nav_right_space">&nbsp;</div>
    </nav>
   <aside>
       <!--  aside  menu S  -->
         <%@include file="../include/aside.jsp" %>
       <!--  aside  menu E  -->
   </aside>
    <section>
       <article>
   <!--  본문 S -->
   <form name = "frm" method = "post" action = "loginWriteSub.jsp">
   <table style = "width : 400px;">
         <tr>
            <th>아이디</th>
            <th><input type = "text" name = "userid" value = "<%=cookie_id%>"></th>
         </tr>
         <tr>
            <th>암호</th>
            <th><input type = "password" name = "userpw"></th>
         </tr>
         <tr>
            <th colspan = "2">
            <input type = "checkbox" name = "chk" value = "1"
            <%if(!cookie_id.equals(""))out.print("checked"); %>>아이디 기억하기</th>
         </tr>
      </table>
      <div style = "width : 400px; text-align : center; margin-top : 10px;">
         <button type = "submit" onclick = "fn_submit(); return false;">로그인</button>
         <button type = "reset">취소</button>
      </div>
   
   </form>
   <!--  본문 E -->
       </article>
    </section>
    <footer>
       <!--  footer  menu S  -->
         <%@include file="../include/footer.jsp" %>
       <!--  footer  menu E  -->
    </footer>
</div>
</body>
</html>