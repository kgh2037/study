<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page import="oracle.jdbc.driver.OracleDriver" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    <% request.setCharacterEncoding("utf-8"); %>
 <%
 		String colname = request.getParameter("colname");
 		String searchtxt = request.getParameter("searchtxt");
 		
 		String str="";
 		if(colname != null && !colname.equals("") && searchtxt != null && !searchtxt.equals("")) {
 			str = " and " + colname + "=" + searchtxt ;
 		}
 		
	    Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","c##java","1234");
 		Statement stmt = connection.createStatement();
 		String sql = "select e.empno, e.ename, d.dname, to_char(e.hiredate,'yyyy-mm-dd') as hiredate "
 									+ "from emp e, dept d where e.deptno = d.deptno " + str + " order by empno desc";
	 	ResultSet rs = stmt.executeQuery(sql); 
 %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empList</title>
</head>
	<style>
		body{
			font-size : 12px;
			color : #111111;
			font-family : 맑은고딕;
		}
		table{
			width : 600px;
			border : 1px solid #ccc
			border-collapse : collapse;
		}
		th, td {
			border:1px solid #ccc;
		}
	</style>
<body>
<script>
function fn_delete(deptno) {
	if(confirm("정말 삭제 하시겠습니까?")) {
		location="deptDelete.jsp?deptno="+deptno; 
	}
}
</script>
<div style="margin-bottom:5px;">
	<form name="frm" method="post" action="empList.jsp">
		<select name = "colname">
			<option value="empno">사원번호</option>
			<option value="ename">사원이름</option>
			<option value="dname">부서이름</option>
			<option value="hiredate">입사일</option>
		</select>
		<input type="text" name="searchtxt">
		<button type="submit">검색</button>
	</form>
	
	<button type = "button" onclick = "location='empWrite.jsp'">사원등록</button>
</div>	

<table border = "1" width = "500">
	<colgroup>
		<col width="10%"/>
		<col width="15%"/>
		<col width="15%"/>
		<col width="25%"/>
		<col width="25%"/>
		<col width="10%"/>
	</colgroup>
	<tr>
		<th>번호</th>
		<th>사원번호</th>
		<th>사원이름</th>
		<th>부서이름</th>
		<th>입사일</th>
		<th>삭제</th>
	</tr>
	<%
	int cnt=0;
	while( rs.next() ) {
		cnt++;
		String empno = rs.getString("empno");
		String ename = rs.getString("ename");
		String dname = rs.getString("dname");
		String hiredate = rs.getString("hiredate");
	%>
	<tr>
		<th><%=cnt %></th>
		<th><a href="empModify.jsp?empno=<%=empno%>"><%=empno %></a></th>
		<th><%=ename %></th>
		<th><%=dname %></th>
		<th><%=hiredate %></th>
		<th><button type = "button" onclick="fn_delete('<%=empno %>')">삭제</button></th>
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
   <button type="button" onclick="location ='empWrite.jsp'">사원등록</button>
	</div>

</body>
</html>