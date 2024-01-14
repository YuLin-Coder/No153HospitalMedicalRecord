<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>医生信息详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  医生信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>医生工号：</td><td width='39%'>${yishengxinxi.yishenggonghao}</td>     <td width='11%'>医生姓名：</td><td width='39%'>${yishengxinxi.yishengxingming}</td></tr><tr>     <td width='11%'>密码：</td><td width='39%'>${yishengxinxi.mima}</td>     <td width='11%'>性别：</td><td width='39%'>${yishengxinxi.xingbie}</td></tr><tr>     <td width='11%'>职称：</td><td width='39%'>${yishengxinxi.zhicheng}</td>     <td width='11%'>所在科室：</td><td width='39%'>${yishengxinxi.suozaikeshi}</td></tr><tr>     <td width='11%'>主治症状：</td><td width='39%'>${yishengxinxi.zhuzhizhengzhuang}</td>     <td width='11%'>联系电话：</td><td width='39%'>${yishengxinxi.lianxidianhua}</td></tr><tr>     <td width='11%'>身份证：</td><td width='39%'>${yishengxinxi.shenfenzheng}</td>     <td width='11%'>备注：</td><td width='39%'>${yishengxinxi.beizhu}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

