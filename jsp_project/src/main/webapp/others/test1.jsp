<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- JSP
<%
out.print("JAVA");
%>
<%="ORACLE" %><br> --%>
<!-- 출력시 = 만으로도 출력 가능  -->

<%-- 자바스크립트<br>
 <%
 String title ="JSP";
 int year =2023;
 out.print(title+"<br>");
 out.print(year);
 %>
 <%= title %><br>
 <%= year %> --%>
 
<%
for (int i=1;i<=10;i++){
	out.print(i+" ");
}
%>
<br>
<%
for (int i=1;i<=10;i++){
%>

<%=i+" "%>&nbsp;&nbsp;

<%
}
%>
<br>
<table border="1">
 	<tr align = "center">
 	<%
 	for (int i=1;i<=10;i++){
 	%>
		<td width="30"><%=i %></td>
 	<%
 	} 
 	%>
 	</tr>
 

 
</body>
</html>