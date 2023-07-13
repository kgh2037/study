<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/oracleCon.jsp" %>


<%
String sql1 = "select product_id, product_name, product_price, decode(manager_id,'E201','김사원','E202','이대리') as manager, to_char(product_date,'yyyy-mm-dd') product_date, company from product_tbl_10 order by product_id asc";
Statement stmt1 = connection.createStatement();
ResultSet rs1 = stmt1.executeQuery(sql1);

%> 
<!DOCTYPE html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>상품 목록 조회/수정 화면</title>
	<link rel = "stylesheet" href = "../css/layout2.css">
</head>
<body>
<div class="wrap">
    <header>
      <div class="top_header">
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
				   <caption>상품 조회/수정</caption>
				   <colgroup>
				      <col width = "10%"/>
				      <col width = "*"/>
				      <col width = "15%"/>
				      <col width = "10%"/>
				      <col width = "20%"/>
				      <col width = "15%"/>
				   </colgroup>
				   <tr>
				      <th>상품ID</th>
				      <th>이름</th>
				      <th>단가</th>
				      <th>담당자</th>
				      <th>등록일자</th>   
				      <th>공급업체</th>   
				   </tr>
				   
				   <%
				   while( rs1.next() ) {
				      String product_id = rs1.getString("product_id");   
				      String product_name = rs1.getString("product_name");   
				      String product_price = rs1.getString("product_price");   
				      String manager = rs1.getString("manager");   
				      String product_date = rs1.getString("product_date");   
				      String company = rs1.getString("company");   
				   %>
				      <tr>
				         <td><%=product_id %></td>
				         <td><a href="productModify.jsp?product_id=<%=product_id%>"><%=product_name %></a></td>
				         <td><%=product_price %></td>
				         <td><%=manager %></td>
				         <td><%=product_date %></td>
				         <td><%=company %></td>
				      </tr>
				   <%
				   }
				   %>
				</table>
       </article>
    </section>
</div>
</body>
</html>