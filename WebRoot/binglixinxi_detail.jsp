<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>病历信息详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  病历信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>账号：</td><td width='39%'>${binglixinxi.zhanghao}</td>     <td width='11%'>姓名：</td><td width='39%'>${binglixinxi.xingming}</td></tr><tr>     <td width='11%'>身份证：</td><td width='39%'>${binglixinxi.shenfenzheng}</td>     <td width='11%'>出生年月：</td><td width='39%'>${binglixinxi.chushengnianyue}</td></tr><tr>     <td width='11%'>电话：</td><td width='39%'>${binglixinxi.dianhua}</td>     <td width='11%'>病史：</td><td width='39%'>${binglixinxi.bingshi}</td></tr><tr>     <td width='11%'>病症：</td><td width='39%'>${binglixinxi.bingzheng}</td>     <td width='11%'>诊断：</td><td width='39%'>${binglixinxi.zhenduan}</td></tr><tr>     <td width='11%'>治疗方案：</td><td width='39%'>${binglixinxi.zhiliaofangan}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

