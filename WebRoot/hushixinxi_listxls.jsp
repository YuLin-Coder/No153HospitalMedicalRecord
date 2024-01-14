<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="hushixinxihsgb" scope="page" class="com.bean.HushixinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=hushixinxi.xls");
%>
<html>
  <head>
    <title>护士信息</title>
  </head>

  <body >
 <%
			String sql="select * from hushixinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>护士工号</td>    <td align='center' bgcolor='#ebf0f7'>密码</td>    <td align='center' bgcolor='#ebf0f7'>护士姓名</td>    <td  width='40' align='center' bgcolor='#ebf0f7'>性别</td>    <td align='center' bgcolor='#ebf0f7'>电话</td>    <td align='center' bgcolor='#ebf0f7'>身份证</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=hushixinxihsgb.getAllHushixinxi(9);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.hushigonghao}</td>    <td>${u.mima}</td>    <td>${u.hushixingming}</td>    <td align='center' bgcolor='#ebf0f7'>${u.xingbie}</td>    <td>${u.dianhua}</td>    <td>${u.shenfenzheng}</td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

