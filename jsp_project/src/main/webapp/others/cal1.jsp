<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>달력</title>
</head>

	<style>
		table {
			border : 1px solid #777777;
			border-collapse : colapse;
			width : 350px;
		}
		th,td {
			text-align : center;
			border : 1px solid #777777;
		}
	</style>
	
<body>
<%
String yy = request.getParameter("yy");
String mm = request.getParameter("mm");
Calendar cal = Calendar.getInstance();

int year = cal.get(Calendar.YEAR);
int month = cal.get(Calendar.MONTH);
int day = cal.get(Calendar.DATE);

String today = year+"-"+(month+1)+"-"+ day;

	if(yy != null && mm != null && !yy.equals("") && !mm.equals("")) {
		
		Boolean yy_chk = yy.matches("[0-9]{4}");
		Boolean mm_chk = mm.matches("[0-9]{1,2}");
		if (yy_chk == true && mm_chk == true) {
		year = Integer.parseInt(yy);
		month = Integer.parseInt(mm)-1;
		}
	}
cal.set(year,month,1);
int dayOfweek = cal.get(Calendar.DAY_OF_WEEK);
int lastday = cal.getActualMaximum(Calendar.DATE);

int b_year;
int b_month = (month+1) - 1;
	if (b_month < 1 ) {
		b_year = year - 1;
		b_month = 12;
	}else {
		b_year = year;
	}	
int n_year;
int n_month = (month+1) + 1;
	if (n_month > 12) {
		n_year = year + 1;
		n_month = 1;
	}else {
		n_year = year;
	}
%>
<div>
	<form name="frm" method="post" action="cal1.jsp">
		<!-- <input type = "text" name="yy" size="4">년
		<input type = "text" name="mm" size="2">월 -->
		<select name = "yy">
		<%
		for (int j=2013; j<=2032; j++) {
			
		%>
			<option value="<%=j %>"><%=j %></option>
		<%
		}
		%>
		</select>
		<select name = "mm">
		<%
		for (int j=1; j<=12; j++) {
			
		%>
			<option value="<%=j %>"><%=j %></option>
		<%
		}
		%>
		</select>
		<input type = "submit" value ="달력보기">
	</form>	
</div>
 <div style=margin-left:80px>
	<form name="frm2" method="post" action="cal1.jsp">
			<input type="button" value="이전"
			onclick="location='cal1.jsp?yy=<%=b_year%>&mm=<%=b_month%>'">
			<%=year %>년<%=month+1 %>월
			<input type="button" value="다음"
			onclick="location='cal1.jsp?yy=<%=n_year%>&mm=<%=n_month%>'">
		</form>	
</div> 


<table border = "1" width = "350" > 
   <tr>
      <th>일</th>
      <th>월</th>
      <th>화</th>
      <th>수</th>
      <th>목</th>
      <th>금</th>
      <th>토</th>
   </tr>
   
   <tr>
<%
	int cnt = 0;
		for(int i =1; i<dayOfweek; i++) {
			out.print("<td></td>");
			cnt++;
		}
		
	   for(int d=1; d<=lastday; d++) {
		   cnt++;
		   String color = "555555";
		   if(cnt==1) {
			   color = "red";
		   }else if (cnt==7) {
			   color="blue";
		   }
		   String v_today =  year + "-" + (month+1) + "-" + d;
		   if(today.equals(v_today)) {
			  color="green";
		  }
		   
		  
   %>
      <td align ="center">
      	<font color= "<%= color%>"><%= d %></font>
      </td>
      <%
      if(cnt==7) {
    	  out.print("</tr><tr>");
    	  cnt=0;
      }
   }
	   if(cnt != 0) {
	   while(cnt < 7) {
		   out.print("<td></td>");
		   cnt++;
		   
	   }
	   }
      %>
      
      
      <!-- <% %> 으로 한번에 묶기 -->
<%-- <td>
   <% 
   int cnt = 0;
   for(int i =1; i<dayOfweek; i++) {
		out.print("<td></td>");
		cnt++;
	}
   for(int d=1; d<=30; d++ ){
   cnt++;
	   out.print("<td>" + d + "</td>");
	   if(cnt==7) {
    	  out.print("</tr><tr>");
    	  cnt=0;
      }
   }
   %>
	   </td> --%>
   </tr>
</table>

</body>
</html>