<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="binglixinxihsgb" scope="page" class="com.bean.BinglixinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=binglixinxi.xls");
%>
<html>
  <head>
    <title>病历信息</title>
  </head>

  <body >
 <%
			String sql="select * from binglixinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>账号</td>    <td align='center' bgcolor='#ebf0f7'>姓名</td>    <td align='center' bgcolor='#ebf0f7'>身份证</td>    <td align='center' bgcolor='#ebf0f7'>出生年月</td>    <td align='center' bgcolor='#ebf0f7'>电话</td>    <td align='center' bgcolor='#ebf0f7'>病史</td>        <td align='center' bgcolor='#ebf0f7'>诊断</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=binglixinxihsgb.getAllBinglixinxi(11);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.zhanghao}</td>    <td>${u.xingming}</td>    <td>${u.shenfenzheng}</td>    <td>${u.chushengnianyue}</td>    <td>${u.dianhua}</td>    <td>${u.bingshi}</td>        <td>${u.zhenduan}</td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

