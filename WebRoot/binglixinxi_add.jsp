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
		<TITLE>添加病历信息</TITLE>
	    
 	<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">    
	</head>
<%
  String id="";
   %>

<script language="javascript">

function gows()
{
	document.location.href="binglixinxi_add.jsp?id=<%=id%>&zhanghao="+document.form1.zhanghao.value;
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
			<form action="addBinglixinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">添加病历信息</td>
						</tr>
						<tr ><td width="200">账号：</td><td><select name='zhanghao' id='zhanghao' class="form-control" onChange='gows();'><%=connDbBean.hsggetoption2("bingrenxinxi","zhanghao")%></select>&nbsp;*<label id='clabelzhanghao' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming'  class="form-control" >&nbsp;*<label id='clabelxingming' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">身份证：</td><td><input name='shenfenzheng' type='text' id='shenfenzheng'  class="form-control" ></td></tr>		<tr ><td width="200">出生年月：</td><td><input name='chushengnianyue' type='text' id='chushengnianyue'  class="form-control" ></td></tr>		<tr ><td width="200">电话：</td><td><input name='dianhua' type='text' id='dianhua'  class="form-control" ></td></tr>		<tr ><td width="200">病史：</td><td><input name='bingshi' type='text' id='bingshi'  class="form-control" ></td></tr>		<tr ><td width="200">病症：</td><td><textarea name='bingzheng' cols='50' rows='5' id='bingzheng' onblur='checkform()' class="form-control" style="width:600px; height:80px;" ></textarea>&nbsp;*<label id='clabelbingzheng' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">诊断：</td><td><input name='zhenduan' type='text' id='zhenduan' value='' onblur='checkform()' size='50' class="form-control" style="width:600px;" />&nbsp;*<label id='clabelzhenduan' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">治疗方案：</td><td><textarea name='zhiliaofangan' cols='50' rows='5' id='zhiliaofangan' onblur='checkform()' class="form-control" style="width:600px; height:80px;" ></textarea>&nbsp;*<label id='clabelzhiliaofangan' style='margin-top:16px;' /></td></tr>		
		
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

<%
if(request.getParameter("zhanghao")==null || request.getParameter("zhanghao").equals("")){}else{
%>
<script language="javascript">
document.form1.zhanghao.value="<%=connDbBean.readzd("bingrenxinxi","zhanghao","zhanghao",request.getParameter("zhanghao"))%>";document.form1.xingming.value="<%=connDbBean.readzd("bingrenxinxi","xingming","zhanghao",request.getParameter("zhanghao"))%>";document.form1.shenfenzheng.value="<%=connDbBean.readzd("bingrenxinxi","shenfenzheng","zhanghao",request.getParameter("zhanghao"))%>";document.form1.chushengnianyue.value="<%=connDbBean.readzd("bingrenxinxi","chushengnianyue","zhanghao",request.getParameter("zhanghao"))%>";document.form1.dianhua.value="<%=connDbBean.readzd("bingrenxinxi","dianhua","zhanghao",request.getParameter("zhanghao"))%>";document.form1.bingshi.value="<%=connDbBean.readzd("bingrenxinxi","bingshi","zhanghao",request.getParameter("zhanghao"))%>";

</script>
<%
}
%>




<script language=javascript >  
 
 function checkform(){  
 
	var zhanghaoobj = document.getElementById("zhanghao"); if(zhanghaoobj.value==""){document.getElementById("clabelzhanghao").innerHTML="&nbsp;&nbsp;<font color=red>请输入账号</font>";return false;}else{document.getElementById("clabelzhanghao").innerHTML="  "; } 	var xingmingobj = document.getElementById("xingming"); if(xingmingobj.value==""){document.getElementById("clabelxingming").innerHTML="&nbsp;&nbsp;<font color=red>请输入姓名</font>";return false;}else{document.getElementById("clabelxingming").innerHTML="  "; } 	var bingzhengobj = document.getElementById("bingzheng"); if(bingzhengobj.value==""){document.getElementById("clabelbingzheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入病症</font>";return false;}else{document.getElementById("clabelbingzheng").innerHTML="  "; } 	var zhenduanobj = document.getElementById("zhenduan"); if(zhenduanobj.value==""){document.getElementById("clabelzhenduan").innerHTML="&nbsp;&nbsp;<font color=red>请输入诊断</font>";return false;}else{document.getElementById("clabelzhenduan").innerHTML="  "; } 	var zhiliaofanganobj = document.getElementById("zhiliaofangan"); if(zhiliaofanganobj.value==""){document.getElementById("clabelzhiliaofangan").innerHTML="&nbsp;&nbsp;<font color=red>请输入治疗方案</font>";return false;}else{document.getElementById("clabelzhiliaofangan").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
<script src="images/hsgcommon/jq.js"></script>
<script src="images/hsgcommon/common.js"></script>
<script src="images/hsgcommon/bootbox.js"></script>