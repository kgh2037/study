<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../../include/oracleCon.jsp" %>
<%
String unq = request.getParameter("product_id");
String sql1 = "select product_id, product_name, product_price, product_info, product_date, company, manager_id from product_tbl_10";
Statement stmt1 = connection.createStatement();
ResultSet rs1 = stmt1.executeQuery(sql1);

   rs1.next();
   String product_id = rs1.getString("product_id");   
   String product_name = rs1.getString("product_name");   
   String product_price = rs1.getString("product_price");   
   String product_info = rs1.getString("product_info");   
   String manager_id = rs1.getString("manager_id");   
   String product_date = rs1.getString("product_date");   
   String company = rs1.getString("company"); 

   if(product_id == null ||product_id.equals("")){
%>
   <script>
   alert("잘못된 접근입니다.");
   location = "productList.jsp";
   </script>
<%   
   return;
   }
%>
<!DOCTYPE html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>상품 수정</title>
<link rel = "stylesheet" href = "../css/layout2.css">
</head>
<body>
<div class="wrap">
    <header>
      <div class="top_header">
       <div style="width:600px; margin-left:300px; text-align:center;">
			<font size = 30px; padding = center; color = white;><b><%= "쇼핑몰관리" %></b></font>
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
		<form name="frm" method="post" action="productModifySave.jsp">
			
			<input type="hidden" name="product_id" value="<%=product_id %>">
			
			<table>
			   <caption style="font-size:20px;
			               font-weight:bold;">상품 수정</caption>
			   <colgrop>
			      <col width="20%"/>
			      <col width="*"/>
			   </colgrop>
			       <tr>
      <th style="background-color: yellow;">상품ID</th>
      <td>
         <input type = "text" name = "product_id" style = "width:99%;" value = "<%= product_id%>">
      </td>
   </tr>
   <tr>
      <th style="background-color: yellow;">이름</th>
      <td>
         <input type = "text" name = "product_name" style = "width:99%;" value = "<%= product_name%>">
      </td>
   </tr>
   <tr>
      <th style="background-color: yellow;">단가</th>
      <td>
         <input type = "text" name = "product_price" style = "width:99%;" value = "<%= product_price%>">
      </td>
   </tr>
   <tr>
      <th style="background-color: yellow;">상품정보</th>
      <td>
         <textarea name = "product_info" style = "width:99%; height:100px;"><%= product_info%></textarea>
      </td>
   </tr>
   <tr>
      <th style="background-color: yellow;">등록일자</th>
      <td>
		<input type = "text" name = "product_date" style = "width:99%;" value = "<%= product_date%>">
      </td>
   </tr>
   <tr>
      <th style="background-color: yellow;">공급업체</th>
      <td>
		<input type = "text" name = "company" style = "width:99%;" value = "<%= company%>">
      </td>
   </tr>
   <tr>
      <th style="background-color: yellow;">담당자</th>
      <td>
		<input type = "text" name = "manager_id" style = "width:99%;" value = "<%= manager_id%>">
      </td>
   </tr>
			   </table>
			<div style="width:600px; margin-top:10px; text-align:center;">
			   <button type="submit" onclick="fn_submit(); return false;">저장</button>
			    <button type="button" onclick="location='productList.jsp'">조회</button>
			</div>
			</form>
       </article>
    </section>
</div>
</body>
</html>