<%@page import="javax.naming.spi.DirStateFactory.Result"%>
<%@page import="javax.naming.spi.DirStateFactory.Result"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/oracleCon.jsp"%>  
<%
String dong = request.getParameter("dong");
dong = dong.trim();
if(dong.equals("")){
%>
	<script>
		alert("동(면,리)을 입력해주세요.");
		history.back();
	</script>
<%
	return;
}

String sql = "select a1, a2 || ' ' || a3 || ' ' || a4 || ' ' || a5 || ' ' || a6 || ' ' || a7 as addr from post where a4 like '%"+dong+"%' or a5 like '%"+dong+"%' ";
Statement stmt = connection.createStatement();
ResultSet rs = stmt.executeQuery(sql);
rs.next();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<script>
	function fn_action() {
		var address = document.frm.address.value;
		var postnum = address.substring(0,6);
		var addr = address.substring(7);
		alert(postnum);
		alert(addr);
		
		opener.frm.zipcode.value = postnum;
		opener.frm.addr.value = addr;
		self.close();
	}
	</script>

<body>

	<form name = "frm">
		<div>
			<select name = "address">
				<option value = ""> -- </option>
				<%
				while(rs.next() ) {
					String postnum = rs.getString("a1");
					String addr = rs.getString("addr");
				%>
				<option value = "<%= postnum%> <%= addr%>"><%= postnum%> <%= addr%></option>			
				<%
				}
				%>s
			</select>
				<br>
				<button type = "button" onclick = "fn_action()">적용</button>
			</div>	
		</form>

</body>
</html>