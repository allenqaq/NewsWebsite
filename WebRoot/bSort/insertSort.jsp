<%@ page pageEncoding="utf-8"  contentType="text/html; charset=utf-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新闻中心后台</title>
<script type="text/javascript">
function check(){
	if(form.sortName.value==""){
		alert("请填写分类名称 ");
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
    <td width="196" rowspan="2" valign="top"><iframe src="../bleft.jsp" marginheight="0" marginwidth="0" scrolling="auto" width="200" height="600"></iframe></td>
    <td width="600" height="36">
      <table width="600" height="36" cellpadding="0" cellspacing="0">
              <tr>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td>&nbsp;当前位置提示&nbsp;&gt;&gt;&nbsp;详细类别管理&nbsp;&gt;&gt;&nbsp;添加类别</td>
        </tr>

      </table></td>
  </tr>
  <tr>
    <td height="400" align="center" valign="top"><table width="601" border="0" cellpadding="0" cellspacing="0" background="../bImage/placeNext.jpg">
      <tr>
        <td height="21" >&nbsp;</td>
        <td>添加类别信息</td>
      </tr>
    </table> 
	<form action="../servlet/SortServlet?action=add" method="post" name="form" onSubmit="return check()">
	  <table width="415" border="0">
        <tr align="right">
          <td>
<a href="javascript:history.go(-1);">返回上一层</a>
  </td>
          </tr>
      </table>
	<table width="415" border="1" cellpadding="0" cellspacing="0">
      <tr>
        <td width="125" height="30"  align="center">类别名称</td>
        <td width="284">&nbsp;&nbsp;&nbsp;
		<input type="text" name="sortName" value=""  size="40"/>
		</td>
      </tr>
    </table><br><br />
	<input type="submit" value="添加" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="reset" value="重置" />
	 </form>
  </tr>
</table>
</div>
</body>
</html>
