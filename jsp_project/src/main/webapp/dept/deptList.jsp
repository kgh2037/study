<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page import="oracle.jdbc.driver.OracleDriver" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    <% request.setCharacterEncoding("utf-8"); %>
 <%
	    Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","c##java","1234");
 		Statement stmt = connection.createStatement();
 		String sql = "select deptno,dname,loc from dept order by deptno desc";
	 	ResultSet rs = stmt.executeQuery(sql); 
 %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deptList</title>
</head>
<body>
<script>
function fn_delete(deptno) {
	if(confirm("정말 삭제 하시겠습니까?")) {
		location="deptDelete.jsp?deptno="+deptno; 
	}
}
</script>
	

<table border = "1" width = "500">
	<colgroup>
		<col width="15%"/>
		<col width="20%"/>
		<col width="35%"/>
		<col width="*%"/>
		<col width="10%"/>
	</colgroup>
	<tr>
		<th>순번</th>
		<th>부서번호</th>
		<th>부서이름</th>
		<th>부서위치</th>
	</tr>
	<%
	int cnt=0;
	while( rs.next() ) {
		cnt++;
		String deptno = rs.getString("deptno");
		String dname = rs.getString("dname");
		String loc = rs.getString("loc");
	%>
	<tr>
		<th><%=cnt %></th>
		<th><a href="deptModify.jsp?deptno=<%=deptno%>"><%=deptno %></a></th>
		<th><%=dname %></th>
		<th><%=loc %></th>
		<th><button type = "button" onclick="fn_delete('<%=deptno %>')">삭제</button></th>
		<%-- <th><button type = "button" onclick="location='deptDelete.jsp?deptno=<%=deptno %>'" >삭제</button></th> --%>
	</tr>
	<%
	}
	%>	

</table>
	<br>
	<div style=margin-left:440px >
		<a href="deptWrite.jsp"><input type="button" value="글쓰기"></a>
	</div>
	
	<div style="padding-bottom:10px;">
   <button type="button" onclick="location ='deptWrite.jsp'">부서등록</button>
	</div>

</body>
</html>