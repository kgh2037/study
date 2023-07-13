<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/oracleCon.jsp" %>
<%
String sql2 = "select max(product_id)+1 as max_id, to_char(sysdate,'yyyy/mm/dd') today from product_tbl_10";
Statement stmt2 = connection.createStatement();
ResultSet rs2 = stmt2.executeQuery(sql2);
rs2.next();
int max_id = rs2.getInt("max_id");
String today = rs2.getString("today");
%>    
<!DOCTYPE html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>상품 등록</title>
<link rel = "stylesheet" href = "../css/layout2.css">
</head>
			<script>
			function fn_submit(){
			   var f = document.frm;
			   if(f.product_id.value == ""){
			      alert("상품ID를 입력해주세요");
			      f.product_id.focus();
			      return false;
			   }
			   if(f.product_name.value == ""){
			      alert("상품이름을 입력해주세요");
			      f.product_name.focus();
			      return false;
			   }
			   if(f.product_price.value == ""){
			      alert("단가를 입력해주세요");
			      f.product_price.focus();
			      return false;
			   }
			   if(f.product_info.value == ""){
			      alert("상품정보를 입력해주세요");
			      f.product_info.focus();
			      return false;
			   }
			   if(f.product_date.value == ""){
			      alert("등록일자를 입력해주세요");
			      f.product_date.focus();
			      return false;
			   }
			   if(f.company.value == ""){
			      alert("공급업체를 입력해주세요");
			      f.company.focus();
			      return false;
			   }
			   if(f.manager_id.value == ""){
			      alert("담당자를 입력해주세요");
			      f.manager_id.focus();
			      return false;
			   }
			   f.submit();
			}
			</script>

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
    <section>
       <article>

<form name = "frm" method = "post" action = "productWriteSave.jsp">
<table>

   <caption><font size = 5px;><b>상품 등록</font></b></caption>
   <colgroup>
      <col width = "20%"/>
      <col width = "*"/>
   </colgroup>
   <tr>
      <th style="background-color: yellow;">상품ID</th>
      <td>
         <input type = "text" name = "product_id" style = "width:99%;" value = "<%= max_id%>">
      </td>
   </tr>
   <tr>
      <th style="background-color: yellow;">이름</th>
      <td>
         <input type = "text" name = "product_name" style = "width:99%;">
      </td>
   </tr>
   <tr>
      <th style="background-color: yellow;">단가</th>
      <td>
         <input type = "text" name = "product_price" style = "width:99%;">
      </td>
   </tr>
   <tr>
      <th style="background-color: yellow;">상품정보</th>
      <td>
         <textarea name = "product_info" style = "width:99%; height:100px;"></textarea>
      </td>
   </tr>
   <tr>
      <th style="background-color: yellow;">등록일자</th>
      <td>
		<input type = "text" name = "product_date" style = "width:99%;" value = "<%= today%>">
      </td>
   </tr>
   <tr>
      <th style="background-color: yellow;">공급업체</th>
      <td>
		<input type = "text" name = "company" style = "width:99%;">
      </td>
   </tr>
   <tr>
      <th style="background-color: yellow;">담당자</th>
      <td>
		<input type = "text" name = "manager_id" style = "width:99%;">
      </td>
   </tr>
   
</table>
<div style="width:600px; margin-top:10px; text-align:center;">  
   <button type = "submit" onclick = "fn_submit();return false;">등록</button>
   <button type="button" onclick="location='productList.jsp'">조회</button>
</div>

</form>

       </article>
    </section>
</div>
</body>
</html>