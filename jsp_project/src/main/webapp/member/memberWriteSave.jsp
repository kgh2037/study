<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/oracleCon.jsp"%>

<title>등록 처리 화면</title>

<%
String userid = request.getParameter("userid");
String userpw = request.getParameter("userpw");
String name = request.getParameter("name");
String gender = request.getParameter("gender");
String year = request.getParameter("year");
String month = request.getParameter("month");
String day = request.getParameter("day");
String p1 = request.getParameter("p1");
String p2 = request.getParameter("p2");
String p3 = request.getParameter("p3");
String zipcode = request.getParameter("zipcode");
String addr = request.getParameter("addr");
String[] hobby = request.getParameterValues("hobby");
String email = request.getParameter("email");
String homepage = request.getParameter("homepage");

String birth = year + "-" + month + "-" + day;
String phone = p1 + "-" + p2 + "-" + p3;

/* String hobbyStr = String.join("," , hobby); */

String hobby1 = "";
for (int i = 0; i<hobby.length; i++) {
	hobby1 += hobby[i]+",";
}
hobby1 = hobby1.substring(0,hobby1.length()-1);


%>
<%
if(userid == null || userpw == null || name == null ) {
%>
   <script>
   alert("잘못된 접근입니다.");
	self.close(); //browser close method
   </script>
<% 
   return;
}
%>
<%
String ptn1 = "^[0-9a-zA-Z]{1}[0-9a-zA-Z_-]{5,11}";
boolean chk1 = userid.matches(ptn1);
if (chk1 == false) {
%>
	<script>
		alsert("영문, 숫자(6~12자)로 아이디값은 ~~~~");
		history.go(-1); //history.back() 와 동일
	</script>
<% 
return;
}
String sql1 = "select count(*) cnt from memberinfo where userid = '"+userid+"' ";
Statement stmt = connection.createStatement();
ResultSet rs = stmt.executeQuery(sql1);
rs.next();

int cnt = rs.getInt("cnt");
if (cnt > 0) {
%>
	<script>
		alert("이미 사용중인 아이디입니다.");
		history.go(-1);
	</script>

<%
return;
}
%>
<%
String sql = "INSERT INTO memberinfo "
           + "VALUES(memberinfo_seq.NEXTVAL, '"+ userid +"','"+ userpw +"', "
           + " '"+name+"','"+gender+"','"+birth+"','"+phone+"','"+zipcode+"', "
           + " '"+addr+"','"+hobby1+"','"+email+"','"+homepage+"', sysdate)";
int result = stmt.executeUpdate(sql);
%>


<% 
if(result == 1){
%>
   <script>
   alert("저장완료");
   location = "/main/main.jsp";
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