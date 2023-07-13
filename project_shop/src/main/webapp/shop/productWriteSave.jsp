<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/oracleCon.jsp"%>

<title>등록 처리 화면</title>

<%
String product_id = request.getParameter("product_id");
String product_name = request.getParameter("product_name");
String product_price = request.getParameter("product_price");
String product_info = request.getParameter("product_info");
String product_date = request.getParameter("product_date");
String company = request.getParameter("company");
String manager_id = request.getParameter("manager_id");
%>

<%
if(product_id == null || product_name == null 
|| product_price == null || product_info == null
|| product_date == null || company == null
|| manager_id == null) {
%>
   <script>
   alert("모든 정보를 입력해주세요.");
   location = "index.jsp";
   </script>
<% 
   return;
}
product_id = product_id.trim();
product_name = product_name.trim();
product_price = product_price.trim();
product_info = product_info.trim();
product_date = product_date.trim();
company = company.trim();
manager_id = manager_id.trim();
%>

<%
String sql = "insert into product_tbl_10 " 
           + "values('"+ product_id +"', '"+ product_name +"','"+ product_price +"', "
           + " '"+product_info+"','"+product_date+"', '"+company+"' , '"+manager_id+"' )";
Statement stmt = connection.createStatement();
int result = stmt.executeUpdate(sql);
%>


<% 
if(result == 1){
%>
   <script>
   alert("저장완료");
   location = "index.jsp";
   </script>
<% 
} else {
%>
   <script>
   alert("저장실패");
   history.back();
   </script>
<%
}
%>