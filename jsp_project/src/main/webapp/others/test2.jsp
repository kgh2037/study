<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!
public int plus(int a, int b) {
	int c = a + b;
	return c;
}
public int minus(int a, int b) {
	int c = a - b;
	return c;
}
%>
<html>
<head>
<meta charset="UTF-8">
<title>선언부를 사용한 두 정수값의 곲</title>
</head>
<body>
<%
int value1 = 3;
int value2 = 9;

int result1 = plus(value1, value2);
int result2 = minus(value1, value2); 
%>
<%=value1 %> + <%=value2 %> = <%=result1 %> <br>
<%=value1 %> - <%=value2 %> = <%=result2 %>
</body>
</html>