/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.76
 * Generated at: 2023-07-10 00:53:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class pollWrite_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>설문등록</title>\r\n");
      out.write("</head>\r\n");
      out.write("<style>\r\n");
      out.write("body{\r\n");
      out.write("   font-size:12px;\r\n");
      out.write("   font-family:맑은고딕;\r\n");
      out.write("   line-height:2.0;\r\n");
      out.write("}\r\n");
      out.write(".table1{\r\n");
      out.write("   width:600px;\r\n");
      out.write("   border:1px solid #ccc;\r\n");
      out.write("   border-collapse:collpase;\r\n");
      out.write("}\r\n");
      out.write(".table1 th,td{\r\n");
      out.write("   padding:5px;\r\n");
      out.write("   border:1px solid #ccc;\r\n");
      out.write("}\r\n");
      out.write(".textarea{\r\n");
      out.write("   width:98%; height:100px;\r\n");
      out.write("}\r\n");
      out.write(".input{\r\n");
      out.write("   width:98%;\r\n");
      out.write("}\r\n");
      out.write(".div1{\r\n");
      out.write("   width:600px;\r\n");
      out.write("   text-align:center;\r\n");
      out.write("   margin-top:10px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("   function fn_submit(){\r\n");
      out.write("      \r\n");
      out.write("      var f =document.frm;\r\n");
      out.write("      if(f.title.value==\"\"){\r\n");
      out.write("         alert(\"제목을 입력해주세요.\");\r\n");
      out.write("         f.title.focus();\r\n");
      out.write("         return false;\r\n");
      out.write("      }\r\n");
      out.write("      var cnt =0;\r\n");
      out.write("      var len = document.getElementsByName(\"item\").length;\r\n");
      out.write("      for(var i=0; i<len;i++){\r\n");
      out.write("         var item = document.getElementsByName(\"item\")[i];\r\n");
      out.write("         if( f.item[i].value !=\"\"){\r\n");
      out.write("            cnt++;\r\n");
      out.write("         }\r\n");
      out.write("         \r\n");
      out.write("      }\r\n");
      out.write("      if( cnt==0){\r\n");
      out.write("         alert(\"설문항목은 1개 이상이어야 합니다.\");\r\n");
      out.write("         f.item[0].focus();\r\n");
      out.write("         return false;\r\n");
      out.write("      }\r\n");
      out.write("      if(f.sdate.value ==\"\" || f.edate.value ==\"\"){\r\n");
      out.write("         alert(\"설문기간을 선택해주세요\");\r\n");
      out.write("         f.sdate.focus();\r\n");
      out.write("         return false;\r\n");
      out.write("      }\r\n");
      out.write("   f.submit();\r\n");
      out.write("   }\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<body>\r\n");
      out.write("<form name=\"frm\" method=\"post\" action=\"/project_sv/pollWriteSave\">\r\n");
      out.write("<table class=\"table1\">\r\n");
      out.write("   <tr>\r\n");
      out.write("      <th>설문제목</th>\r\n");
      out.write("      <td><textarea name=\"title\" class=\"textarea\"></textarea></td>\r\n");
      out.write("   </tr>\r\n");
      out.write("   <tr>\r\n");
      out.write("      <th>설문항목</th>\r\n");
      out.write("      <td>\r\n");
      out.write("      ");

      for(int i=1; i<=10; i++){
      
      out.write("   \r\n");
      out.write("      <input type=\"text\" name=\"item\" class=\"input\"><br>\r\n");
      out.write("      ");

      }
      
      out.write("\r\n");
      out.write("      </td>\r\n");
      out.write("   </tr>\r\n");
      out.write("   <tr>\r\n");
      out.write("      <th>설문기간</th>\r\n");
      out.write("      <td>\r\n");
      out.write("      <input type=\"date\" name=\"sdate\"> ~\r\n");
      out.write("      <input type=\"date\" name=\"edate\"> \r\n");
      out.write("      <input type=\"checkbox\" name=\"use\" value=\"N\">숨김 \r\n");
      out.write("      </td>\r\n");
      out.write("   </tr>\r\n");
      out.write("</table>\r\n");
      out.write("<div class=\"div1\">\r\n");
      out.write("   <button type=\"submit\" onclick=\"fn_submit();return false;\">저장</button>\r\n");
      out.write("   <button type=\"reset\">취소</button>\r\n");
      out.write("</div>\r\n");
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
