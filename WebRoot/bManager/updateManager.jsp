<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新闻中心后台</title>
<script type="text/javascript">
function Mycheck(){
	if(document.form.account.value==""){
       alert("请填写用户登录名");
       return false;
     }
     else if(document.form.password.value=="" ){
     	alert("请填写密码 ");
       return false;
     }
   else if(document.form.name.value==""){
     alert("请填写用户姓名   ");
       return false;
    }else{
     return true;
    }
    }
</script>
</head>
<link rel="stylesheet" href="../css/style.css">
<body><div align="center">
  <iframe src="../bTop.jsp" marginheight="0" marginwidth="0" scrolling="no" width="799" height="122"></iframe>
  <table width="800" height="600" border="1" cellpadding="0" cellspacing="0">
  <tr>
    <td width="196" rowspan="2" valign="top">  <iframe src="../bleft.jsp" marginheight="0" marginwidth="0" frameborder="0"   scrolling="auto" width="200" height="600"></iframe></td>
  
    <td width="604" height="57" >
      <table width="600" height="56" cellpadding="0" cellspacing="0">
        <tr>
          <td>&nbsp;当前位置提示&nbsp;&gt;&gt;&nbsp;用户管理&nbsp;&gt;&gt;&nbsp;用户资料修改</td>
        </tr>
        <tr>
          <td>&nbsp;</td>
        </tr>
      </table></td>
  </tr>
  <tr>
    <td height="400" align="center" valign="top" ><table width="601" border="0" cellpadding="0" cellspacing="0" background="../bImage/placeNext.jpg">
      <tr>
        <td height="21" >&nbsp;</td>
        <td>用户修改</td>
      </tr>
    </table> <br>      
<form action="managerServlet?action=update" method="post" onSubmit="return Mycheck()" name="form">
<input type="hidden" name="Id" value="${manager.managerID}">
	<table width="415" border="1" cellpadding="0" cellspacing="0">
      <tr>
        <td width="75" height="30" align="center">账号</td>
        <td width="334" align="center">&nbsp;&nbsp;<input name="account" size="50" type="text" value="${requestScope.manager.account}"/></td>
      </tr>
         <tr>
        <td width="75" height="30" align="center">密码</td>
        <td width="334" align="center">&nbsp;&nbsp;<input name="password" size="50" type="password" value = "${manager.password}"/></td>
      </tr>
         <tr>
        <td width="75" height="30" align="center">姓名</td>
        <td width="334" align="center">&nbsp;&nbsp;<input name="name" size="50" type="text" value = "${manager.name}"/></td>
      </tr>
      
    </table> 
	<div>&nbsp;&nbsp;</div>
	<input type="submit" value="修改"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="reset" value="清除"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" onClick="javascript:history.go(-1);" name="back" value="返回"/>
	</form>
	<br>
</td>
  </tr>
</table>
</div>
</body>
</html>
</em>
