<%@page import="java.util.Random"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calendar 클래스</title>
</head>
<body>
<%-- <%
Calendar cal = Calendar.getInstance();
%>
오늘은
<%= cal.get(Calendar.YEAR) %>년
<%= cal.get(Calendar.MONTH)+1 %>월
<%= cal.get(Calendar.DATE) %>일
입니다. <br><br><br> --%>

<%-- <%
Random random = new Random();
out.print("0이상 n이하의 랜덤 정수값 : " + random.nextInt(10) + " <br>");
out.print("랜덤 boolean 값 : " + random.nextBoolean() + " <br>");
out.print("랜덤 long 값 : " + random.nextLong() + " <br>");
out.print("랜덤 float 값 : " + random.nextFloat() + " <br>");
out.print("랜덤 double 값 : " + random.nextDouble() + " <br>");
out.print("랜덤 정규 분포의 난수 값 : " + random.nextGaussian() + " <br>");
%> --%>
<%
String str1 = "첫 번째 문장. first string";
String str2 = "첫 번째 문장. First string";
%>
<%-- 문자열 길이 : <%= str1.length() + "<br>" %> 
인덱스 5번 위치의 값 : <%= str1.charAt(5) + "<br>" %>
first 라는 단어의 위치 인덱스 번호 : <% =str1.indexOf("first")%> <br>
s라는 글자의 위치 인덱스 번호 : <%= str1.indexOf('s') %> <br>
인덱스 번호 5번부터 끝까지 : <%= str1.substring(5) %> <br>
인덱스 번호 5번부터 9번까지 : <%= str1.substring(5, 10) %> <br>
두 변수 값 동일 여부 : <%= str1.equals(str2) %> <br> --%>

<%-- <% 
String address = "123456 서울시 강남구 논현동77";
address = address.trim();
%>
1.길이 출력 : <%= "문자열 길이:"+ address.length() +"<br>" %>
2.우편번호 출력 : <%= "우편번호:"+address.substring(0,6) +"<br>" %>
3.주소만 출력 : <%= "주소:"+address.substring(6) +"<br>" %>
4.검색단어 "논현": <%=(address.indexOf("논현")>-1) ?"존재함":"존재안함" %> --%>


<%--
	String equlas = "";
if (address.indexOf("논현")>0){
	
	equlas ="존재함";
}else {
	equlas ="존재하지 않음";
}
out.print("검색단어:\"논현\""+equlas);
 --%>
 
 
<%
 String birthday = "20100115 20011225 19981102";
 String[] birthdays = birthday.split(" ");
 Calendar cal = Calendar.getInstance();
 int year2 = cal.get(Calendar.YEAR);
out.print("-------------------------------------------------<br>");
  out.print("전송데이터 : "+birthday+" <br>");
out.print("-------------------------------------------------<br>");
 for (int i=0; i<birthdays.length; i++) {
 	String year = birthdays[i].substring(0,4);
	String month = birthdays[i].substring(4,6);
	String date = birthdays[i].substring(6);
	int age = year2 - Integer.parseInt(year);
out.print("데이터 " + (i + 1) + ": 나이(만 "+age+" 세), 생일("+month+"월 "+date+"일)");
out.print("<br>-------------------------------------------------<br>");
 }
%> 


  
 </body>
</html>