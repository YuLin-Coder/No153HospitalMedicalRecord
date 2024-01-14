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
		<TITLE>添加药品信息</TITLE>
	    
 	<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">    
	</head>
<%
  String id="";
   %>

<script language="javascript">

function gows()
{
	document.location.href="yaopinxinxi_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="addYaopinxinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">添加药品信息</td>
						</tr>
						<tr ><td width="200">药品编号：</td><td><input name='yaopinbianhao' type='text' id='yaopinbianhao' value='<%=connDbBean.getID()%>' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">药品名称：</td><td><input name='yaopinmingcheng' type='text' id='yaopinmingcheng' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelyaopinmingcheng' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">成分：</td><td><input name='chengfen' type='text' id='chengfen' value='' onblur='checkform()' size='50' class="form-control" style="width:600px;" />&nbsp;*<label id='clabelchengfen' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">主治症状：</td><td><input name='zhuzhizhengzhuang' type='text' id='zhuzhizhengzhuang' value='' onblur='checkform()' size='50' class="form-control" style="width:600px;" />&nbsp;*<label id='clabelzhuzhizhengzhuang' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">图片：</td><td><input name='tupian' type='text' id='tupian' size='50' value='' onblur='checkform()'  class="form-control" /><div style="margin-top:16px;">&nbsp;<input type='button' value='上传' onClick="up('tupian')"/></div>&nbsp;*<label id='clabeltupian' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">生产药厂：</td><td><input name='shengchanyaochang' type='text' id='shengchanyaochang' value='' onblur='checkform()' size='50' class="form-control" style="width:600px;" />&nbsp;*<label id='clabelshengchanyaochang' style='margin-top:16px;' /></td></tr>		
		
						<tr align='center'   height="22">
						    <td height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small"/>
						       <input type="reset" value="重置" name="Submit2" class="btn btn-info btn-small"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var yaopinmingchengobj = document.getElementById("yaopinmingcheng"); if(yaopinmingchengobj.value==""){document.getElementById("clabelyaopinmingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入药品名称</font>";return false;}else{document.getElementById("clabelyaopinmingcheng").innerHTML="  "; } 	var chengfenobj = document.getElementById("chengfen"); if(chengfenobj.value==""){document.getElementById("clabelchengfen").innerHTML="&nbsp;&nbsp;<font color=red>请输入成分</font>";return false;}else{document.getElementById("clabelchengfen").innerHTML="  "; } 	var zhuzhizhengzhuangobj = document.getElementById("zhuzhizhengzhuang"); if(zhuzhizhengzhuangobj.value==""){document.getElementById("clabelzhuzhizhengzhuang").innerHTML="&nbsp;&nbsp;<font color=red>请输入主治症状</font>";return false;}else{document.getElementById("clabelzhuzhizhengzhuang").innerHTML="  "; } 	var tupianobj = document.getElementById("tupian"); if(tupianobj.value==""){document.getElementById("clabeltupian").innerHTML="&nbsp;&nbsp;<font color=red>请输入图片</font>";return false;}else{document.getElementById("clabeltupian").innerHTML="  "; } 	var shengchanyaochangobj = document.getElementById("shengchanyaochang"); if(shengchanyaochangobj.value==""){document.getElementById("clabelshengchanyaochang").innerHTML="&nbsp;&nbsp;<font color=red>请输入生产药厂</font>";return false;}else{document.getElementById("clabelshengchanyaochang").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
<script src="images/hsgcommon/jq.js"></script>
<script src="images/hsgcommon/common.js"></script>
<script src="images/hsgcommon/bootbox.js"></script>