<%@page import="java.security.DrbgParameters.Reseed"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/oracleCon.jsp"%>    
<%@page import="java.util.Calendar"%>
    
    
<% 
// 파라미터 값을 받음
String yy = request.getParameter("yy");
String mm = request.getParameter("mm");

// Calendar 클래스의 인스턴스(객체)화
Calendar cal = Calendar.getInstance();


//  현재 시점의  년,월,일
int y  = cal.get(Calendar.YEAR); //출력년도
int m  = cal.get(Calendar.MONTH); //출력월
int d2 = cal.get(Calendar.DATE);

// 현재 시점의 년-월-일 변수처리 ::   달력의 날짜와 비교하기 위해
String today = y+"-"+(m+1)+"-"+d2;

if(yy != null && mm != null && !yy.equals("") && !mm.equals("")) {
	
	// 유효성체크
	boolean yy_chk = yy.matches("[0-9]{4}");    // true or false
	boolean mm_chk = mm.matches("[0-9]{1,2}");  // true or false
	if (yy_chk == true && mm_chk == true) {
	y = Integer.parseInt(yy);
	m = Integer.parseInt(mm)-1;    // 달력시스템은 -1 로 자료 요청해야함
	}
}

//출력하는 달의 1일의 요일을 얻기 위한 세팅
cal.set(y,m,1);   //2023-06-01 ( 현재의 달은 맞고 출력하면 5가 나옴 )
//출력하는 달 1일의  요일 얻음
int dayOfweek = cal.get(Calendar.DAY_OF_WEEK);    //5 요일 
//출력하는 달 1일의  마지막날 얻음
int lastday =cal.getActualMaximum(Calendar.DATE);  //30

//"이전"버튼 세팅
int b_yy=y;
int b_mm=(m+1)-1;

if (b_mm == 0) {
	b_mm = 12;
	b_yy = y-1;
}
//"다음"버튼 세팅
int n_yy=y;
int n_mm=m+2;

if (n_mm == 13) {
	n_mm = 1;
	n_yy = y+1;
}
%>
<!DOCTYPE html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>planMain</title>
<link rel = "stylesheet" href = "../css/layout.css">
</head>
<style>
	.cal_table {
		width : 80%;
	}
	.cal_table th {
	
	}
	.cal_table td{
   text-align : left;
   padding : 5px;
   height : 50px;
   width : 50px;
}
</style>


<body>
<div class="wrap">
    <header>
      <div class="top_header">

      </div>
    </header>
    <nav>
       <div class="nav_left_space">&nbsp;</div>
      <div class="nav_center_space"> 
 <%@ include file="../include/navmenu.jsp" %>
      </div>
      <div class="nav_right_space">&nbsp;</div>
    </nav>
   <aside>
 <%@ include file="../include/aside.jsp" %>
   </aside>
    <section>
       <article>
			<div>
				<form name="frm" method="post" action="cal2.jsp">
					<!-- <input type="text" name="yy" size="4">년 -->
					<select name="yy">
					<%
					cal = Calendar.getInstance();
					int j_yy = cal.get(Calendar.YEAR);
					for(int j=(j_yy-10); j<=(j_yy+10); j++) {
					%>
					<option value="<%=j %>"><%=j %></option>
					<%
					}
					%>
					</select>년
					
					
					<!-- <input type="text" name="mm" size="2">월 -->
					<select name="mm">
					<%
					for(int k=1; k<=12; k++) {
					%>
					<option value="<%=k %>"><%=k %></option>
					<%
					}
					%>
					</select>월
					
					<input type="submit" value="달력보기">
				</form>
					
				</div>
				
				
				<div>
				<input type="button" value="이전"
				onclick="location='cal2.jsp?yy=<%=b_yy%>&mm=<%=b_mm%>'">
				<%=y %>년<%=m+1 %>월
				<input type="button" value="다음"
				onclick="location='cal2.jsp?yy=<%=n_yy%>&mm=<%=n_mm%>'">
				</div>
				
				
				<table class = "cal_table"> 
				   <tr>
				      <th>일</th>
				      <th>월</th>
				      <th>화</th>
				      <th>수</th>
				      <th>목</th>
				      <th>금</th>
				      <th>토</th>
				   </tr>
				   <tr >
				      <%
				      int cnt=0;
				      for(int i=1;i<dayOfweek;i++){   //1~4
				         out.print("<td></td>");
				         cnt++;
				      }
				      
				      String sql = "";
				      
				      for (int d=1; d<=lastday; d++){
				         cnt++;
				         String color = "#555555";
				      if (cnt == 1 ){
				         color = "red";
				      } else if (cnt == 7) {
				    	 color = "blue";
				      }
				      String v_date = y+"-"+(m+1)+"-"+d; 
				      if (today.equals(v_date)) {
				    	  color = "green";
				      }
				      
			         String send_m = (m+1)<10?"0"+(m+1):(m+1)+"";
			         String send_d = d<10?"0" +d:d+"";
			         String send_date = y+"-"+send_m+"-"+send_d;
				      
				     sql = "select substr(title,1,20) as title from sche_mgr "
				    		+"where to_char(sche_date,'yyyy-mm-dd') = '"+send_date+"' ";
				    		 
				     Statement stmt = connection.createStatement();
				     ResultSet rs = stmt.executeQuery(sql);
				     String title = "";
				     if(rs.next()) {
				    	 title = rs.getString("title");
				     }
				      
				      %>
				      <td><a href="planWrite.jsp?date=<%=send_date%>">
				      		<font color="<%=color %>"><%= d %><br><%= title %></font>
				      </a></td>
				      <%  if(cnt==7){
				            out.print("</tr><tr>");
				            cnt=0;
				         }
				      }
				      if (cnt != 0) {
				      while( cnt < 7 ) {
				    	  out.print("<td></td>");
				    	  cnt++;
				      }
				      }
				      %>
				      </tr>
				</table>
       </article>
    </section>
    <footer>
 <%@ include file="../include/footer.jsp" %>
    </footer>
</div>
</body>
</html>