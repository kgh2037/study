<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/oracleCon.jsp" %>


<%
String sql1 = "select to_char(sale_date,'yyyy-mm-dd') sale_date ,sum(sale_price) sale_price "
				+ "from sale_tbl_10 group by sale_date order by sale_date desc";
Statement stmt1 = connection.createStatement();
ResultSet rs1 = stmt1.executeQuery(sql1);
%> 
<!DOCTYPE html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>매출현황 조회</title>
	<link rel = "stylesheet" href = "../css/layout2.css">
</head>
<body>
<div class="wrap">
    <header>
      <div class="top_header">
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
   <aside>
   </aside>
    <section>
       <article>
				<table>
				   <caption><font size="5"><b>상품 조회/수정</b></font></caption>
				   <colgroup>
				      <col width = "60%"/>
				      <col width = "*"/>
				   </colgroup>
				   <tr>
				      <th>판매일자</th>
				      <th>판매금액</th>
				   </tr>
				   
				   <%
				   while( rs1.next() ) {
					   	  String sale_date = rs1.getString("sale_date");   
					      String sale_price = rs1.getString("sale_price");   
					      
				      %>
				   
				      <tr>
				         <td><%=sale_date %></td>
				         <td><%=sale_price %></td>
				      </tr>
				   <%
				   }
				   %>
				</table>
				<%
				String sql2 = "select a.* from (select member_id, sum(sale_price) sale_price from "
						+ "sale_tbl_10 group by member_id order by sale_price desc) a where rownum='1'";
				Statement stmt2 = connection.createStatement();
				ResultSet rs2 = stmt2.executeQuery(sql2);
				
				while(rs2.next()) {
				String member_id = rs2.getString("member_id");  
				String sale_price = rs2.getString("sale_price");  
				%>
				   <div style="width:600px; margin-top:10px; text-align:center;">
				<tr style = text-align: left;><%="구매자 순위 1등" %></tr><br>
				<tr><%= member_id%></tr>
				<tr><%= sale_price%></tr>
				</div>
				<%
				   }
				   %>
       </article>
    </section>
</div>
</body>
</html>