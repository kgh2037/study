<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/oracleCon.jsp" %>

<%
String date = request.getParameter("date");
if(date == null || date.trim() == ""){
%>
	<script>
	alert("잘못된 접근입니다.");
	self.close();
	</script>
<%
}
%>

<%
String sql_10= "select title,content,hide from sche_mgr "
        +" where to_char(sche_date,'yyyy-mm-dd')='"+date+"' ";
	 Statement stmt = connection.createStatement();
	 ResultSet rs = stmt.executeQuery(sql_10);

String title = "";
String content = "";
String hide = "";
String gubun = "I"; //INSERT 상황
String title_msg = "일정등록";

if(rs.next()){
   title = rs.getString("title");
   content = rs.getString("content");
   hide = rs.getString("hide");
   gubun = "U"; //UPDATE 상황
   title_msg = "일정변경";
}

%>
<!DOCTYPE html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>layout2</title>
 <link rel="stylesheet" href="../css/layout.css">
</head>
<script>

function fn_delete(){
	if(confirm("일정을 삭제하시겠습니까?")){
		//폼 action 값을 변경후 전송
		document.frm.action = "planDelete.jsp";
		document.frm.submit();
	}
}
function fn_submit(){
	var f = document.frm;
	if(f.date.value == ""){
		alert("날짜를 입력하세요");
		return false;
	}
	if(f.title.value == ""){
		alert("제목을 입력하세요");
		f.title.focus();
		return false;
	}
}

</script>
<style>
.cal_table_td{
	text-align : left;
}
.textarea{
	text-align : left;
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
         <!--  nav menu S  -->
            <%@include file="../include/navmenu.jsp" %>
         <!--  nav menu E  -->
      </div>
      <div class="nav_right_space">&nbsp;</div>
    </nav>
   <aside>
       <!--  aside  menu S  -->
         <%@include file="../include/aside.jsp" %>
       <!--  aside  menu E  -->
   </aside>
    <section>
       <article>
   <!--  본문 S -->
<form name = "frm" method = "post" action = "planWriteSave.jsp">
<input type="hidden" name="gubun" value="<%=gubun %>">
<table>
	<caption><%=title_msg %></caption>
	<tr>
		<th>날짜</th>
		<td class = "cal_table_td"><input type = "date" name = "date" value ="<%=date%>" style = "width:150px;" readonly></td>
	</tr>
	<tr>
		<th>제목</th>
		<td class = "cal_table_td"><input type = "text" name = "title" value = "<%=title%>"></td>
	</tr>
	<tr>
		<th>공개</th>
		<td class = "cal_table_td">
		<input type = "radio" name = "hide" value = "Y"
		<% if(!hide.equals("N")){out.print("checked");} %>>보이기
		<input type = "radio" name = "hide" value = "N"
		<% if(hide.equals("N")){out.print("checked");} %>>안보이기
		</td>
	</tr>
	<tr>
		<th>내용</th>
		<td class = "cal_table_td">
			<textarea name = "content" style ="width: 80%; height : 200px;"><%=content %></textarea>
		</td>
	</tr>
</table>
<div width = "400" style = "margin-top : 10px; text-align : center;">
	<button type = "submit" onclick = "fn_submit()">등록</button>
	<button type = "reset">취소</button>
	<% 
	if( gubun.equals("U")){
	%>
	<button type = "button" onclick = "fn_delete()">일정삭제</button>
	<% 
	}
	%>
	
</div>
</form>
   <!--  본문 E -->
       </article>
    </section>
    <footer>
       <!--  footer  menu S  -->
         <%@include file="../include/footer.jsp" %>
       <!--  footer  menu E  -->
    </footer>
</div>
</body>
</html>