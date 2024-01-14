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
		<TITLE>修改医生信息</TITLE>
	    
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   
       
	</head>


	<body>
			<form action="updateYishengxinxi2.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改医生信息<input type="hidden" name="id" value="${yishengxinxi.id}" /></td>
						</tr>
						<tr ><td width="200">医生工号：</td><td><input name='yishenggonghao' type='text' id='yishenggonghao' value='' onblur='hsgcheck()' class="form-control" />&nbsp;*<label id='clabelyishenggonghao' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">医生姓名：</td><td><input name='yishengxingming' type='text' id='yishengxingming' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelyishengxingming' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">密码：</td><td><input name='mima' type='text' id='mima' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelmima' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">性别：</td><td><select name='xingbie' id='xingbie' class="form-control"><option value="男">男</option><option value="女">女</option></select></td></tr>		<tr ><td width="200">职称：</td><td><input name='zhicheng' type='text' id='zhicheng' value='' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">所在科室：</td><td><select name='suozaikeshi' id='suozaikeshi' class="form-control"><option value="急诊科">急诊科</option><option value="内科">内科</option><option value="外科">外科</option><option value="儿科">儿科</option><option value="妇科">妇科</option><option value="耳鼻喉科">耳鼻喉科</option><option value="口腔科">口腔科</option><option value="皮肤科">皮肤科</option><option value="中医科">中医科</option><option value="眼科">眼科</option></select></td></tr>		<tr ><td width="200">主治症状：</td><td><input name='zhuzhizhengzhuang' type='text' id='zhuzhizhengzhuang' value='' onblur='checkform()' size='50' class="form-control" style="width:600px;" />&nbsp;*<label id='clabelzhuzhizhengzhuang' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">联系电话：</td><td><input name='lianxidianhua' type='text' id='lianxidianhua' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabellianxidianhua' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">身份证：</td><td><input name='shenfenzheng' type='text' id='shenfenzheng' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelshenfenzheng' style='margin-top:16px;' /></td></tr>		<tr 0><td width="200">备注：</td><td><textarea name='beizhu' cols='50' rows='5' id='beizhu' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.yishenggonghao.value='${yishengxinxi.yishenggonghao}';</script>	<script language="javascript">document.form1.yishengxingming.value='${yishengxinxi.yishengxingming}';</script>	<script language="javascript">document.form1.mima.value='${yishengxinxi.mima}';</script>	<script language="javascript">document.form1.xingbie.value='${yishengxinxi.xingbie}';</script>	<script language="javascript">document.form1.zhicheng.value='${yishengxinxi.zhicheng}';</script>	<script language="javascript">document.form1.suozaikeshi.value='${yishengxinxi.suozaikeshi}';</script>	<script language="javascript">document.form1.zhuzhizhengzhuang.value='${yishengxinxi.zhuzhizhengzhuang}';</script>	<script language="javascript">document.form1.lianxidianhua.value='${yishengxinxi.lianxidianhua}';</script>	<script language="javascript">document.form1.shenfenzheng.value='${yishengxinxi.shenfenzheng}';</script>	<script language="javascript">document.form1.beizhu.value='${yishengxinxi.beizhu}';</script>	
					 </table>
			</form>
   </body>
</html>



<!--hssgchesck-->


<script language=javascript >  
 
 function checkform(){  
 
	var yishenggonghaoobj = document.getElementById("yishenggonghao"); if(yishenggonghaoobj.value==""){document.getElementById("clabelyishenggonghao").innerHTML="&nbsp;&nbsp;<font color=red>请输入医生工号</font>";return false;}else{document.getElementById("clabelyishenggonghao").innerHTML="  "; } 	var yishengxingmingobj = document.getElementById("yishengxingming"); if(yishengxingmingobj.value==""){document.getElementById("clabelyishengxingming").innerHTML="&nbsp;&nbsp;<font color=red>请输入医生姓名</font>";return false;}else{document.getElementById("clabelyishengxingming").innerHTML="  "; } 	var mimaobj = document.getElementById("mima"); if(mimaobj.value==""){document.getElementById("clabelmima").innerHTML="&nbsp;&nbsp;<font color=red>请输入密码</font>";return false;}else{document.getElementById("clabelmima").innerHTML="  "; } 	var zhuzhizhengzhuangobj = document.getElementById("zhuzhizhengzhuang"); if(zhuzhizhengzhuangobj.value==""){document.getElementById("clabelzhuzhizhengzhuang").innerHTML="&nbsp;&nbsp;<font color=red>请输入主治症状</font>";return false;}else{document.getElementById("clabelzhuzhizhengzhuang").innerHTML="  "; } 	var lianxidianhuaobj = document.getElementById("lianxidianhua"); if(lianxidianhuaobj.value==""){document.getElementById("clabellianxidianhua").innerHTML="&nbsp;&nbsp;<font color=red>请输入联系电话</font>";return false;}else{document.getElementById("clabellianxidianhua").innerHTML="  "; } 	var lianxidianhuaobj = document.getElementById("lianxidianhua"); if(lianxidianhuaobj.value!=""){ if(/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/.test(lianxidianhuaobj.value) || /^1[3|4|5|6|7|8|9][0-9]\d{8,8}$/.test(lianxidianhuaobj.value)){document.getElementById("clabellianxidianhua").innerHTML=""; }else{document.getElementById("clabellianxidianhua").innerHTML="&nbsp;&nbsp;<font color=red>必需电话格式[7或8位电话，或11位手机]</font>"; return false;}}      var shenfenzhengobj = document.getElementById("shenfenzheng"); if(shenfenzhengobj.value==""){document.getElementById("clabelshenfenzheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入身份证</font>";return false;}else{document.getElementById("clabelshenfenzheng").innerHTML="  "; } 	var shenfenzhengobj = document.getElementById("shenfenzheng"); if(shenfenzhengobj.value!=""){ if(/^\d{15}$|^\d{18}$|^\d{17}[xX]$/.test(shenfenzhengobj.value)){document.getElementById("clabelshenfenzheng").innerHTML=""; }else{document.getElementById("clabelshenfenzheng").innerHTML="&nbsp;&nbsp;<font color=red>必需身份证格式</font>"; return false;}}      


return true;   
}   
popheight=450;
</script>  
