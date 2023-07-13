<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/oracleCon.jsp" %>

<!DOCTYPE html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>쇼핑몰관리</title>
	<link rel = "stylesheet" href = "../css/layout2.css">
</head>
<body>
<div class="wrap">
    <header>
      <div class="top_header" >
        <div style="width:600px; margin-left:300px; text-align:center;">
<font size = 30px; color = white;><b><%= "쇼핑몰관리" %></b></font>
      </div>
    </header>
    <nav>
      <div class="nav_center_space"> 
 <%@ include file="../include/navmenu.jsp" %>
      </div>
      <div class="nav_right_space">&nbsp;</div>
    </nav>
    <section>
       <article>
			<body>
		 <table style = "border-collapse: collapse; width : 800px; border: 0;">
		      <caption><font size = "4"><b>쇼핑몰관리 프로그램</b></font></caption>
		   
		   <tr>
		      <td style = "border : 0; text-align: left;">
		      <font size = "4">
		      쇼핑몰에서 상품 정보,매출정보 데이터베이스를 구축하고 쇼핑몰관리를 위한 프로그램을 작성하는 프로그램이다.
		      </font>
		      </td>
		   </tr>
		   
		   </table>
		
			<font size = "4"><%= "프로그램 작성 순서" %></font>
			<br>
			<font size = "4"><%= "1.상품정보 테이블을 생성한다." %></font>
			<br>
			<font size = "4"><%= "2.매출정보 테이블을 생성한다." %></font>
			<br>
			<font size = "4"><%= "3.상품정보 입력 화면프로그램을 작성한다." %></font>
			<br>
			<font size = "4"><%= "4.상품정보 조회/수정 프로그램을 작성한다." %></font>
			<br>
			<font size = "4"><%= "5.매출 정보 조회 프로그램을 작성한다." %></font>
			<br>  
			
			</body>
       </article>
    </section>
</div>
</body>
</html>