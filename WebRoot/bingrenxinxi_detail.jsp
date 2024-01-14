<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>病人信息详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  病人信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>账号：</td><td width='39%'>${bingrenxinxi.zhanghao}</td>     <td width='11%'>姓名：</td><td width='39%'>${bingrenxinxi.xingming}</td></tr><tr>     <td width='11%'>性别：</td><td width='39%'>${bingrenxinxi.xingbie}</td>     <td width='11%'>身份证：</td><td width='39%'>${bingrenxinxi.shenfenzheng}</td></tr><tr>     <td width='11%'>出生年月：</td><td width='39%'>${bingrenxinxi.chushengnianyue}</td>     <td width='11%'>电话：</td><td width='39%'>${bingrenxinxi.dianhua}</td></tr><tr>     <td width='11%'>地址：</td><td width='39%'>${bingrenxinxi.dizhi}</td>     <td width='11%'>病史：</td><td width='39%'>${bingrenxinxi.bingshi}</td></tr><tr>     <td width='11%'>备注：</td><td width='39%'>${bingrenxinxi.beizhu}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

