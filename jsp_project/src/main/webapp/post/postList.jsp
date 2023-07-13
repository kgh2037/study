<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/oracleCon.jsp" %>

<%
String viewPage = request.getParameter("viewPage");
String s_select = request.getParameter("s_select");
String s_word = request.getParameter("s_word");
if(viewPage == null){
   viewPage = "1" ;
}

String search = "";
if(s_select != null && s_word != null && 
   !s_select.equals("") && !s_word.equals("") ){
		if( s_select.equals("1")) {
		   search = "a1 like '%"+s_word+"%' ";
		} else if ( s_select.equals("2")) {
			search = "a3 like '%"+s_word+"%' or a4 like '%"+s_word+"%' or a5 like '%"+s_word+"%' ";
		}
} else {
	s_select = "";
	s_word = "";
   search = " 1=1 ";
}

int s_pageno = 0;
int e_pageno = 0;
// viewPage ->1,2,3,4,~10
// startno = 1, last = 10;
int vPage = Integer.parseInt(viewPage);
%>

<!-- 전체데이터 개수 -->
<%
String sql1 = "select count(*) total from post where " + search;
Statement stmt1 = connection.createStatement();
ResultSet rs1 = stmt1.executeQuery(sql1);
rs1.next();
int total = rs1.getInt("total");
int lastpageno = (int)Math.ceil(total/10);

s_pageno =  ((vPage-1)/10)*10+1;
e_pageno =    s_pageno+(10-1);
	if(lastpageno < e_pageno){
	   e_pageno = lastpageno;
	}

		int nextpageno = e_pageno + 1;
			if(e_pageno >= lastpageno ) {
				nextpageno = -1;
			}
		
			int befpageno = s_pageno - 1; //before 작동시 11page > 10page 이동

int s_index = (vPage-1)*10 + 1;
int e_index = s_index + (10-1);

			
String sql2 = " select p2.* from (select rownum rn, p1.* from(select a1 as postnum , a2||' '||a3||' '||a4||' '||a5||' '||a6||' '||a7 as address"
            +" from post where " + search +" order by a1) p1) p2 where rn between '"+s_index+"' and " + e_index;
Statement stmt2 = connection.createStatement();
ResultSet rs2 = stmt2.executeQuery(sql2);
%>

<!DOCTYPE html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>우편번호검색</title>
  <link rel="stylesheet" href="../css/layout.css">
</head>

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
       
          
	   <div style = "width:700px; text-align :left; margin-bottom:10px;">
			<form name="frm" method="post" action="postList.jsp">
			   <select name="s_select">
			      <option value="">- 선택 -</option>
			      <option value="1">- 우편번호 -</option>
			      <option value="2">- 주소 -</option>
			   </select>
			   <input type="text" name="s_word">
			   <button type="submit">검색</button>
			</form>
		</div>
     
   <table style="width:700px">
   <caption  style="font-size:20px;
                 font-weight:bold;">우편번호 검색</caption>
      <tr>
         <th width="50" >번호</th>
         <th width="70">우편번호</th>
         <th width="*">주소</th>
      </tr>
      <%
      int cnt = 11;
      while (rs2.next()) {
         cnt--;
         String postnum = rs2.getNString("postnum");
         String address = rs2.getNString("address");
      %>
         <tr>
            <td><%=cnt %></td>
            <td><%=postnum %></td>
            <td align="left"><%=address %></td>
         </tr>
      <% 
      }
      %>
   </table>
   <div style="width:700px;text-align:margin-top:10px">
   		<a href="<%=request.getRequestURI()%>?viewPage=1&s_select=<%=s_select%>&s_word=<%=s_word%>">[firstpage]</a>
   <%
   if(befpageno<=0) {
	   out.print("[before]");
   } else {
   %>
   		<a href="<%=request.getRequestURI()%>?viewPage=<%=befpageno %>&s_select=<%=s_select%>&s_word=<%=s_word%>">[before]</a>
   <%   
      }
   %>   
   &nbsp;&nbsp;
   <% 
      for(int i=s_pageno; i<=e_pageno; i++){
    	  	if(i == vPage) {
				out.print("<span style = \"font-weigt:bold;\">");    	  		
    	  	} else { 
    	  		out.print("<span>");
    	  	}
   %>
         <a href="<%=request.getRequestURI()%>?viewPage=<%=i%>&s_select=<%=s_select%>&s_word=<%=s_word%>">
         <%=i %>
         </a>

   <%   
      }
   %>   
   &nbsp;&nbsp;
   <%
   if(nextpageno == -1) {
	   out.print("[next]");
   } else {
   %>
   		<a href="<%=request.getRequestURI()%>?viewPage=<%=nextpageno %>&s_select=<%=s_select%>&s_word=<%=s_word%>">[next]</a>
   <%   
      }
   %>   
   <a href="<%=request.getRequestURI()%>?viewPage=<%=lastpageno%>&s_select=<%=s_select%>&s_word=<%=s_word%>">[lastpage]</a>
   </div>

   
   
       </article>
    </section>
    <footer>
      <%@ include file="../include/footer.jsp" %>
    </footer>
</div>
</body>
</html>