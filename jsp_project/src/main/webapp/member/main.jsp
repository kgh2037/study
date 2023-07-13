<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/oracleCon.jsp" %>

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
			
			<table>
				<tr>
					<th>아이디</th>
					<th></th>
				</tr>
			</table>
			
       </article>
    </section>
    <footer>
 <%@ include file="../include/footer.jsp" %>
    </footer>
</div>
</body>
</html>