<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/oracleCon.jsp"%>    
<!-- 파라메터 값 설정 -->
<%
	
	String userid = (String) session.getAttribute("SessionUserId");
	String pass1 = request.getParameter("pass1");
	String pass2 = request.getParameter("pass2");
	String pass3 = request.getParameter("pass3");
	
	String sql = "select count(*) cnt from memberinfo where userid = '"+userid+"' "
			+ " and userpw = '"+pass1+"' ";
	Statement stmt = connection.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	rs.next();
	
	int cnt = rs.getInt("cnt");
	if(cnt == 0) {
%>
	<script>
		alert("등록된 암호와 일치하지 않습니다.");
		history.back();
	</script>
		<%
		return;
	}
		%>

<% String sql2 = " update memberinfo set userpw ='"+pass2+"' where userid='"+userid+"'";
Statement stmt2 = connection.createStatement();
int result = stmt2.executeUpdate(sql2); 
%>
<%
if(result ==1){
%>
<script>
	alert("암호 변경 완료 \n 다음 로그인 시 적용됩니다.")
	opener.location = "../member/loginWrite.jsp";
	self.close();
</script>
<%
}else{
%>
<script>
	alert("암호 변경 실패")
	opener.location = "../member/loginWrite.jsp";
	self.close();
</script>
<% 
}
%>