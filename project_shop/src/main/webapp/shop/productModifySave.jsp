<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/oracleCon.jsp"%>

<%
String product_id = request.getParameter("product_id");
String product_name = request.getParameter("product_name");
String product_price = request.getParameter("product_price");
String product_info = request.getParameter("product_info");
String manager_id = request.getParameter("manager_id");
String product_date = request.getParameter("product_date");
String company = request.getParameter("company");

%>

<%
if(product_id == null || product_name == null || product_price == null 
|| product_info == null || manager_id == null || product_date == null || company == null ) {
%>
   <script>
   alert("잘못된 경로로의 접근입니다.");
   location = "productList.jsp"; //이전페이지로 GO
   </script>
<% 
   return; 
}
product_id = product_id.trim();
product_name = product_name.trim();
product_price = product_price.trim();
product_info = product_info.trim();
manager_id = manager_id.trim();
company = company.trim();
%>

<%
String sql2 = "update product_tbl_10 set product_name = '"+product_name+"', product_price = '"+product_price+"',"
				+ " product_info = '"+product_info+"', manager_id = '"+manager_id+"', company = '"+company+"' where product_id = '"+product_id+"' ";
Statement stmt2 = connection.createStatement();
int result = stmt2.executeUpdate(sql2);
%>

<% 
if(result == 1){
%>
   <script>
   alert("변경완료");
   location = "productList.jsp";
   </script>
<% 
} else {
%>
   <script>
   alert("변경실패");
   history.back();
   </script>
<%
}
%>