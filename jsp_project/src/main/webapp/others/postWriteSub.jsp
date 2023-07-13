<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- IPV6 방식으로 IP를 리턴 -->
나의 IP = <%=request.getRemoteAddr() %> <br>
데이터길이 = <%= request.getContentLength() %> <br>
인코딩 = <%= request.getCharacterEncoding()%> <br>
컨텐츠타입 = <%= request.getContentType() %> <br>
프로토콜 = <%= request.getProtocol() %> <br>
전송방식 = <%= request.getMethod() %> <br>
URL = <%= request.getRequestURL() %> <br>
컨텍스트 경로 = <%= request.getContextPath() %> <br>
서버명 = <%= request.getServerName() %> <br>
서버포트 = <%= request.getServerPort() %>
</body>
</html>