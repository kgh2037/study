<%@page import="java.sql.*"%>
<%@ page import="oracle.jdbc.driver.OracleDriver" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ include file ="../include/oracleCon.jsp" %>
 <%
 		Statement stmt = connection.createStatement();
 %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empWriteSave</title>
</head>
<body>
<% 
	String empno = request.getParameter("empno");
	String ename = request.getParameter("ename");
	String sal = request.getParameter("sal");
	String hiredate = request.getParameter("hiredate");
	String job = request.getParameter("job");
	String mgr = request.getParameter("mgr");
	String comm = request.getParameter("comm");
	String deptno = request.getParameter("deptno");

	if(empno == null || empno.equals("")) {
%>
	<script> 
		alert("사원번호를 입력해주세요."); 
		history.back();
	</script>
		<%
			String sql1 = "select count(*) from emp where empno='"+empno+"' ";
			ResultSet rs1 = stmt.executeQuery(sql1);
			rs1.next();
			int cnt = rs1.getInt("cnt");
			if( cnt > 0 ) {
		%>
				<script>
					alert("이미 사용중인 사원번호입니다.");
					history.back();
				</script>
				
		<%
			return; /* jsp 에서 return은 jsp 종료 */
			}
		%>
<%
	return;
	}	
	if(ename == null || ename.equals("")) {
%>
	<script> 
		alert("사원이름을 입력해주세요."); 
		history.back();
	</script>
<%
	return;
	}	
	if(sal == null || sal.equals("")) {
%>
	<script> 
		alert("사원급여를 입력해주세요."); 
		history.back();
	</script>
<%
	return;
	}	
	if(hiredate == null || hiredate.equals("")) {
%>
	<script> 
		alert("입사일을 입력해주세요."); 
		history.back();
	</script>
<%
	return;
	}	
	if(job == null || job.equals("")) {
%>
	<script> 
		alert("업무를 입력해주세요."); 
		history.back();
	</script>
<%
	return;
	}	
	if(mgr == null || mgr.equals("")) {
%>
	<script> 
		alert("매니저를 입력해주세요."); 
		history.back();
	</script>
<%
	return;
	}	
	if(ename == null || ename.equals("")) {
%>
	<script> 
		alert("사원이름을 입력해주세요."); 
		history.back();
	</script>
<%
	return;
	}	
	if(comm == null || comm.equals("")) {
%>
	<script> 
		alert("부서번호를 입력해주세요."); 
		history.back();
	</script>
<%
	return;
	}	

	String sql = "insert into emp(empno, ename, sal, hiredate, job, mgr, comm, deptno) values('"+empno+"','"+ename+"','"+sal+"','"+hiredate+"','"+job+"','"+mgr+"','"+comm+"','"+deptno+"')";
	int result = stmt.executeUpdate(sql);
	if(result == 1) {
%>
	<script> 
		alert("저장완료."); 
		location = "empList.jsp";
	</script>
	
<%
	} else {
		
%>		
	<script> 
		alert("저장실패!!"); 
		history.back();
	</script>
<%
	}
%>		
	


</body>
</html>