<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<TITLE>医生信息查询</TITLE>
	<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">
	</head>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="17" background="images/table_header.gif">医生信息列表</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="yishengxinxiList.do" name="myform" method="post">
									查询   医生工号：<input name="yishenggonghao" type="text" id="yishenggonghao" class="form-control2" />  医生姓名：<input name="yishengxingming" type="text" id="yishengxingming" class="form-control2" /> 性别：<select name='xingbie' id='xingbie' class="form-control2"><option value="">所有</option><option value="男">男</option><option value="女">女</option></select>  职称：<input name="zhicheng" type="text" id="zhicheng" class="form-control2" /> 所在科室：<select name='suozaikeshi' id='suozaikeshi' class="form-control2"><option value="">所有</option><option value="急诊科">急诊科</option><option value="内科">内科</option><option value="外科">外科</option><option value="儿科">儿科</option><option value="妇科">妇科</option><option value="耳鼻喉科">耳鼻喉科</option><option value="口腔科">口腔科</option><option value="皮肤科">皮肤科</option><option value="中医科">中医科</option><option value="眼科">眼科</option></select>  主治症状：<input name="zhuzhizhengzhuang" type="text" id="zhuzhizhengzhuang" class="form-control2" />  联系电话：<input name="lianxidianhua" type="text" id="lianxidianhua" class="form-control2" />
									<input type="submit" value="查询" class="btn btn-info btn-small" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
                            <td align='center' bgcolor='#ebf0f7'>医生工号</td>    <td align='center' bgcolor='#ebf0f7'>医生姓名</td>    <td align='center' bgcolor='#ebf0f7'>密码</td>    <td  width='40' align='center' bgcolor='#ebf0f7'>性别</td>    <td align='center' bgcolor='#ebf0f7'>职称</td>    <td align='center' bgcolor='#ebf0f7'>所在科室</td>    <td align='center' bgcolor='#ebf0f7'>主治症状</td>    <td align='center' bgcolor='#ebf0f7'>联系电话</td>    <td align='center' bgcolor='#ebf0f7'>身份证</td>        
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 添加时间 </td>
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td align="center"><%=i%></td>
                             <td>${u.yishenggonghao}</td>    <td>${u.yishengxingming}</td>    <td>${u.mima}</td>    <td align='center' bgcolor='#ebf0f7'>${u.xingbie}</td>    <td>${u.zhicheng}</td>    <td>${u.suozaikeshi}</td>    <td>${u.zhuzhizhengzhuang}</td>    <td>${u.lianxidianhua}</td>    <td>${u.shenfenzheng}</td>        
                              <td align="center"> ${u.addtime } </td>
                              <td align="center"> <!--lianjie1--> <a class="btn btn-info btn-small" href="yishengxinxiDetail.do?id=${u.id}">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		
		
			<p align="center" class="fy"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="yishengxinxiList.do?page=1" >首页</a>
             <a href="yishengxinxiList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="yishengxinxiList.do?page=${page.page+1 }">下一页</a>
			<a href="yishengxinxiList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>

