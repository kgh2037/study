/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.76
 * Generated at: 2023-07-10 02:04:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import com.DbConnect;
import java.sql.Connection;

public final class pollModify_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.sql.Connection");
    _jspx_imports_classes.add("java.sql.ResultSet");
    _jspx_imports_classes.add("java.sql.Statement");
    _jspx_imports_classes.add("com.DbConnect");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

String code = request.getParameter("code");
//code의 null체크
if(code == null || code.equals("")) {

      out.write("\r\n");
      out.write("	<script>\r\n");
      out.write("	alert(\"잘못된 경로입니다.\");\r\n");
      out.write("	history.back();\r\n");
      out.write("	</script>\r\n");
 
}

      out.write('\r');
      out.write('\n');

Connection con = DbConnect.oracleCon();

String sql1 = "select code, title, to_char(sdate,'yyyy-mm-dd') sdate, "
			+ "to_char(edate,'yyyy-mm-dd') edate, use from pollmain where code = '"+code+"' ";
Statement stmt1 = con.createStatement();
ResultSet rs1 = stmt1.executeQuery(sql1);
rs1.next();
String title = rs1.getString("title");
String sdate = rs1.getString("sdate");
String edate = rs1.getString("edate");
String use = rs1.getString("use"); //Y OR N
String checked = "";
if(use.equals("N")) checked = "checked";

String sql2 = "select code,item FROM pollsub where code like '"+code+"%' ";
							//like 1001%
Statement stmt2 = con.createStatement();
ResultSet rs2 = stmt2.executeQuery(sql2);

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>설문수정</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("body {\r\n");
      out.write("	font-size : 12px;\r\n");
      out.write("	font-family : 맑은고딕;\r\n");
      out.write("	line-height : 2.0;\r\n");
      out.write("}\r\n");
      out.write(".table1 {\r\n");
      out.write("	width : 600px;\r\n");
      out.write("	border : 1px solid #ccc;\r\n");
      out.write("}\r\n");
      out.write(".table1 th,td {\r\n");
      out.write("	padding : 5px;\r\n");
      out.write("	border : 1px solid #ccc;\r\n");
      out.write("	border-collapse : collapse; /*cell간격*/\r\n");
      out.write("}\r\n");
      out.write("textarea {\r\n");
      out.write("	width : 98%;\r\n");
      out.write("	height : 30px;\r\n");
      out.write("	resize : none;\r\n");
      out.write("}\r\n");
      out.write(".input {\r\n");
      out.write("	width : 98%;\r\n");
      out.write("}\r\n");
      out.write(".div1 {\r\n");
      out.write("	width : 600px;\r\n");
      out.write("	text-align : center;\r\n");
      out.write("	margin-top : 10px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("function fn_submit() {\r\n");
      out.write("	\r\n");
      out.write("	var f = document.frm;\r\n");
      out.write("	\r\n");
      out.write("	if(f.title.value == \"\"){\r\n");
      out.write("		alert(\"제목을 입력하세요\");\r\n");
      out.write("		f.title.focus();\r\n");
      out.write("		return false;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	var cnt = 0;\r\n");
      out.write("	\r\n");
      out.write("	var len = document.getElementsByName(\"item\").length;\r\n");
      out.write("	//alert(len);\r\n");
      out.write("	\r\n");
      out.write("	for(var i=0; i<len; i++) {\r\n");
      out.write("		var item = document.getElementsByName(\"item\")[i];\r\n");
      out.write("		if(item.value != \"\") {\r\n");
      out.write("			cnt++;\r\n");
      out.write("		}\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	if(cnt == 0) {\r\n");
      out.write("		alert(\"설문항목은 1개 이상이어야합니다.\");\r\n");
      out.write("		f.item[0].focus();\r\n");
      out.write("		return false;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	if(f.sdate.value == \"\" || f.edate.value == \"\"){\r\n");
      out.write("		alert(\"설문기간을 선택해주세요\");\r\n");
      out.write("		f.sdate.focus();\r\n");
      out.write("		return false;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	f.submit();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<body>\r\n");
      out.write("<form name = \"frm\" method = \"post\" action = \"/project_servlet1/pollModifySave\">\r\n");
      out.write("\r\n");
      out.write("<input type=\"hidden\" name =\"code\" value=\"");
      out.print(code );
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("<table class = \"table1\">\r\n");
      out.write("	<tr>\r\n");
      out.write("		<th>설문제목</th>\r\n");
      out.write("		<td><textarea name = \"title\" class = \"textarea\">");
      out.print(title );
      out.write("</textarea></td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr>\r\n");
      out.write("		<th>설문항목</th>\r\n");
      out.write("		<td>\r\n");
      out.write("		");

		int cnt = 0;
		while(rs2.next()) {
			String code_sub = rs2.getString("code");
			String item = rs2.getString("item");
		
      out.write("\r\n");
      out.write("			<input type = \"text\" name = \"item\" value = \"");
      out.print(item );
      out.write("\" class = \"input\"><br>\r\n");
      out.write("		");

			cnt++;
		}
		while(cnt < 10) {
		
      out.write("\r\n");
      out.write("			<input type = \"text\" name = \"item\" class = \"input\"><br>\r\n");
      out.write("		");
 
			cnt++;
		}
		
      out.write("\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr>\r\n");
      out.write("		<th>설문기간</th>\r\n");
      out.write("		<td>\r\n");
      out.write("			<input type = \"date\" name = \"sdate\" value = \"");
      out.print(sdate);
      out.write("\"> ~\r\n");
      out.write("			<input type = \"date\" name = \"edate\" value = \"");
      out.print(edate);
      out.write("\">\r\n");
      out.write("			<input type = \"checkbox\" name = \"use\" value = \"N\" ");
      out.print(checked );
      out.write(">숨김\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr>\r\n");
      out.write("</table>\r\n");
      out.write("	<div class = \"div1\">\r\n");
      out.write("		<button type = \"button\" onclick = \"fn_submit();return false;\">저장</button>\r\n");
      out.write("		<button type = \"reset\">취소</button>\r\n");
      out.write("	</div>\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
