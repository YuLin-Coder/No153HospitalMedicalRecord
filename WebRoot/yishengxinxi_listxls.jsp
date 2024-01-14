<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="yishengxinxihsgb" scope="page" class="com.bean.YishengxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=yishengxinxi.xls");
%>
<html>
  <head>
    <title>医生信息</title>
  </head>

  <body >
 <%
			String sql="select * from yishengxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>医生工号</td>    <td align='center' bgcolor='#ebf0f7'>医生姓名</td>    <td align='center' bgcolor='#ebf0f7'>密码</td>    <td  width='40' align='center' bgcolor='#ebf0f7'>性别</td>    <td align='center' bgcolor='#ebf0f7'>职称</td>    <td align='center' bgcolor='#ebf0f7'>所在科室</td>    <td align='center' bgcolor='#ebf0f7'>主治症状</td>    <td align='center' bgcolor='#ebf0f7'>联系电话</td>    <td align='center' bgcolor='#ebf0f7'>身份证</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=yishengxinxihsgb.getAllYishengxinxi(12);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.yishenggonghao}</td>    <td>${u.yishengxingming}</td>    <td>${u.mima}</td>    <td align='center' bgcolor='#ebf0f7'>${u.xingbie}</td>    <td>${u.zhicheng}</td>    <td>${u.suozaikeshi}</td>    <td>${u.zhuzhizhengzhuang}</td>    <td>${u.lianxidianhua}</td>    <td>${u.shenfenzheng}</td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

