<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'adminyanzheng.jsp' starting page</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
  
  <body>
  <%
 
 String uid=request.getParameter("username");
 String pwd=request.getParameter("pwd");
 String cx=request.getParameter("cx");
 String sql="";
 if(cx.equals("管理员")){sql="select * from allusers where username='"+uid+"' and pwd='"+pwd+"'";}
 if(cx.equals("护士")){sql="select * from hushixinxi where hushigonghao='"+uid+"' and mima='"+pwd+"'";}
if(cx.equals("医生")){sql="select * from yishengxinxi where yishenggonghao='"+uid+"' and mima='"+pwd+"'";}
      System.out.println(sql);
 ResultSet RS_result=connDbBean.executeQuery(sql);
 if(RS_result==null || !RS_result.next())
{
	out.print("<script>alert('你输入的用户不存在或密码错误,请重新登录!');window.history.go(-1);</script>");
}
else{
  	  session.setAttribute("username",uid);
	  session.setAttribute("uid",RS_result.getString("id"));
	 if(cx.equals("管理员"))
	 {
  	  	session.setAttribute("cx",RS_result.getString("cx"));
  	  }
	  else
	  {
	  	session.setAttribute("cx",cx);
	  }
	 response.sendRedirect("main.jsp");	 
	}
      if(RS_result!=null){
          RS_result.close();
      }


 %>
  </body>
</html>

