/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.29
 * Generated at: 2020-01-03 08:40:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class SignUp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("file:/C:/Users/ADMIN/.m2/repository/org/springframework/spring-webmvc/5.2.2.RELEASE/spring-webmvc-5.2.2.RELEASE.jar", Long.valueOf(1577271149778L));
    _jspx_dependants.put("/WEB-INF/view/css/index.css", Long.valueOf(1577973930969L));
    _jspx_dependants.put("jar:file:/C:/Users/ADMIN/.m2/repository/org/springframework/spring-webmvc/5.2.2.RELEASE/spring-webmvc-5.2.2.RELEASE.jar!/META-INF/spring-form.tld", Long.valueOf(1575343110000L));
    _jspx_dependants.put("jar:file:/C:/Users/ADMIN/.m2/repository/org/springframework/security/spring-security-taglibs/5.2.1.RELEASE/spring-security-taglibs-5.2.1.RELEASE.jar!/META-INF/security.tld", Long.valueOf(1572875998000L));
    _jspx_dependants.put("file:/C:/Users/ADMIN/.m2/repository/org/springframework/security/spring-security-taglibs/5.2.1.RELEASE/spring-security-taglibs-5.2.1.RELEASE.jar", Long.valueOf(1578030484133L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsec_005fcsrfInput_005fnobody;

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
    _005fjspx_005ftagPool_005fsec_005fcsrfInput_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fsec_005fcsrfInput_005fnobody.release();
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
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<html>\r\n");
      out.write("<style>\r\n");
      out.write("    ");
      out.write("body {\r\n");
      out.write("    width:100%;\r\n");
      out.write("    height:auto;\r\n");
      out.write("}\r\n");
      out.write(".topbox{\r\n");
      out.write("    margin-top: 60px;\r\n");
      out.write("    border: none;\r\n");
      out.write("    background-color: white;\r\n");
      out.write("    color: black;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#top-box{\r\n");
      out.write("    border: none;\r\n");
      out.write("    background-color: white;\r\n");
      out.write("    color: black;\r\n");
      out.write("}\r\n");
      out.write("nav .navbar-header{\r\n");
      out.write("    padding:10px;\r\n");
      out.write("}\r\n");
      out.write(".navbar-header .heading {\r\n");
      out.write("    color:black;\r\n");
      out.write("    font-size: x-large;\r\n");
      out.write("    font-weight: bold;\r\n");
      out.write("    margin:30px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".navbar-right {\r\n");
      out.write("    margin:0px;\r\n");
      out.write("    margin-right:40px;\r\n");
      out.write("    margin-left:40px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".navbar .navbar-right li a {\r\n");
      out.write("    color:black;\r\n");
      out.write("    font-size: medium;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".navbar .navbar-right li a:hover {\r\n");
      out.write("    color:black;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".navbar .navbar-right li a.active {\r\n");
      out.write("    margin: 10px 10px;\r\n");
      out.write("    padding:4px;\r\n");
      out.write("    border:none;\r\n");
      out.write("    border-bottom:5px solid black;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("main {\r\n");
      out.write("    margin-top: 100px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("main h2 {\r\n");
      out.write("    color: black;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("main form div {\r\n");
      out.write("    margin:20px 0px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("button {\r\n");
      out.write("    width:100px;\r\n");
      out.write("    background-color: black;\r\n");
      out.write("    color: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".row{\r\n");
      out.write("    background-color: lightcyan;\r\n");
      out.write("    border: 1px solid black;\r\n");
      out.write("    border-radius: 5%;\r\n");
      out.write("    margin-top: 5px;\r\n");
      out.write("    margin-bottom: 5px;\r\n");
      out.write("    margin-left: 5px;\r\n");
      out.write("    margin-right: 5px;\r\n");
      out.write("    padding-left: 15px;\r\n");
      out.write("}\r\n");
      out.write("#create\r\n");
      out.write("{\r\n");
      out.write("    background-color:white;\r\n");
      out.write("    border: none;\r\n");
      out.write("}\r\n");
      out.write("#cd{\r\n");
      out.write("    color:red;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#top-box{\r\n");
      out.write("    background-color: white;\r\n");
      out.write("    border: none;\r\n");
      out.write("}\r\n");
      out.write("/*body {font-family: Arial, Helvetica, sans-serif;}*/\r\n");
      out.write("/** {box-sizing: border-box}*/\r\n");
      out.write("\r\n");
      out.write("/* Full-width input fields */\r\n");
      out.write("input[type=text], input[type=password] {\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    padding: 15px;\r\n");
      out.write("    margin: 5px 0 22px 0;\r\n");
      out.write("    display: inline-block;\r\n");
      out.write("    border: none;\r\n");
      out.write("    background: #f1f1f1;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input[type=text]:focus, input[type=password]:focus {\r\n");
      out.write("    background-color: #ddd;\r\n");
      out.write("    outline: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("hr {\r\n");
      out.write("    border: 1px solid #f1f1f1;\r\n");
      out.write("    margin-bottom: 25px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Set a style for all buttons */\r\n");
      out.write("button {\r\n");
      out.write("    background-color: #4CAF50;\r\n");
      out.write("    color: white;\r\n");
      out.write("    padding: 14px 20px;\r\n");
      out.write("    margin: 8px 0;\r\n");
      out.write("    border: none;\r\n");
      out.write("    cursor: pointer;\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    opacity: 0.9;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("button:hover {\r\n");
      out.write("    opacity:1;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Extra styles for the cancel button */\r\n");
      out.write(".cancelbtn {\r\n");
      out.write("    padding: 14px 20px;\r\n");
      out.write("    background-color: #f44336;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Float cancel and signup buttons and add an equal width */\r\n");
      out.write(".cancelbtn, .signupbtn {\r\n");
      out.write("    float: left;\r\n");
      out.write("    width: 50%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Add padding to container elements */\r\n");
      out.write(".container {\r\n");
      out.write("    padding: 16px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Clear floats */\r\n");
      out.write(".clearfix::after {\r\n");
      out.write("    content: \"\";\r\n");
      out.write("    clear: both;\r\n");
      out.write("    display: table;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Change styles for cancel button and signup button on extra small screens */\r\n");
      out.write("@media screen and (max-width: 300px) {\r\n");
      out.write("    .cancelbtn, .signupbtn {\r\n");
      out.write("        width: 100%;\r\n");
      out.write("    }\r\n");
      out.write("}");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("<body>\r\n");
      out.write("<form action=\"newUser\" style=\"border:1px solid #ccc\" method=\"post\" modelAttribute=\"user\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <h2>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${exist}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</h2>\r\n");
      out.write("        <h1>Sign Up</h1>\r\n");
      out.write("        <p>Please fill in this form to create an account.</p>\r\n");
      out.write("        <hr>\r\n");
      out.write("        <label for=\"username\"><b>Username</b></label>\r\n");
      out.write("        <input type=\"text\" placeholder=\"Enter Email\" id=\"username\" name=\"username\" required>\r\n");
      out.write("\r\n");
      out.write("        <label for=\"email\"><b>Email</b></label>\r\n");
      out.write("        <input type=\"text\" placeholder=\"Enter Email\" id=\"email\" name=\"email\" required>\r\n");
      out.write("\r\n");
      out.write("        <label for=\"password\"><b>Password</b></label>\r\n");
      out.write("        <input type=\"password\" placeholder=\"Enter Password\" name=\"password\" id=\"password\" required>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"clearfix\">\r\n");
      out.write("            <button type=\"submit\" class=\"signupbtn\">Sign Up</button>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</form>\r\n");
      if (_jspx_meth_sec_005fcsrfInput_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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

  private boolean _jspx_meth_sec_005fcsrfInput_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  sec:csrfInput
    org.springframework.security.taglibs.csrf.CsrfInputTag _jspx_th_sec_005fcsrfInput_005f0 = (org.springframework.security.taglibs.csrf.CsrfInputTag) _005fjspx_005ftagPool_005fsec_005fcsrfInput_005fnobody.get(org.springframework.security.taglibs.csrf.CsrfInputTag.class);
    boolean _jspx_th_sec_005fcsrfInput_005f0_reused = false;
    try {
      _jspx_th_sec_005fcsrfInput_005f0.setPageContext(_jspx_page_context);
      _jspx_th_sec_005fcsrfInput_005f0.setParent(null);
      int _jspx_eval_sec_005fcsrfInput_005f0 = _jspx_th_sec_005fcsrfInput_005f0.doStartTag();
      if (_jspx_th_sec_005fcsrfInput_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fsec_005fcsrfInput_005fnobody.reuse(_jspx_th_sec_005fcsrfInput_005f0);
      _jspx_th_sec_005fcsrfInput_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_sec_005fcsrfInput_005f0, _jsp_getInstanceManager(), _jspx_th_sec_005fcsrfInput_005f0_reused);
    }
    return false;
  }
}