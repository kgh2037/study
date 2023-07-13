<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/oracleCon.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답변형 게시판</title>
</head>

<style>

body {
   font-size : 14px;
   font-family : 맑은 고딕;
}
table {
   width : 600px;
   border : 1px solid #555;
   border-collapse : collapse;
}
td,th {
   border-collapse : collapse;
   border : 1px solid #555;
   padding:5px;
}
caption {
   font-size: 25px;
   font-weight : bold;
   margin-bottom : 5px;
}
div {
   margin-top : 10px; 
   width : 600px; 
   text-align : center;
}
</style>
<script>
function fn_submit(){
   var f = document.frm;
   if(f.title.value == ""){
      alert("제목을 입력해주세요");
      f.title.focus();
      return false;
   }
   if(f.pass.value == ""){
      alert("암호를 입력해주세요");
      f.pass.focus();
      return false;
   }
   f.submit();
}
</script>
<body>
<%
String unq = request.getParameter("unq");
String gid = request.getParameter("gid");
String thread = request.getParameter("thread");
%>


<form name = "frm" method = "post" action = "reBoardReplySave.jsp">
        <input type="hidden" name = "unq" value="<%=unq %>">
<table>

   <caption style = "font-size = 20px; font-weigh:bold">(답변형)답글화면</caption>
   <colgroup>
      <col width = "20%"/>
      <col width = "*"/>
   </colgroup>
   <tr>
      <th>제목</th>
      <td>
         <input type = "text" name = "title" style = "width:99%;">
      </td>
   </tr>
   <tr>
      <th>암호</th>
      <td>
         <input type = "password" name = "pass" style = "width:99%;">
      </td>
   </tr>
   <tr>
      <th>글쓴이</th>
      <td>
         <input type = "text" name = "name" style = "width:99%;">
      </td>
   </tr>
   <tr>
      <th>내용</th>
      <td>
         <textarea name = "content" style = "width:99%; height:100px;"></textarea>
      </td>
   </tr>
   
</table>

<div>  
   <button type = "submit" onclick = "fn_submit();return false;">저장</button>
   <button type = "reset">취소</button>
</div>
</form>

</body>
</html>
