<%@ page pageEncoding="utf-8"  contentType="text/html; charset=utf-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新闻中心后台</title>

</head>
<link rel="stylesheet" href="../css/style.css">
<body><div align="center">
<iframe src="../bTop.jsp" marginheight="0" marginwidth="0" scrolling="no" width="799" height="122"></iframe>
<table width="800" height="600" border="1" cellpadding="0" cellspacing="0">
  <tr>
    <td width="196" rowspan="2" valign="top">  <iframe src="../bleft.jsp" marginheight="0" marginwidth="0" frameborder="0"   scrolling="auto" width="200" height="600"></iframe></td>
  
    <td width="604" height="57"  >
      <table width="600" height="56" cellpadding="0" cellspacing="0">
        <tr>
          <td>&nbsp;当前位置提示&nbsp;&gt;&gt;焦点新闻管理&gt;&gt;&nbsp;详细新闻查看</td>
        </tr>
        <tr>
          <td>&nbsp;</td>
        </tr>
      </table></td>
  </tr>
  <tr>
    <td height="400" align="center" valign="top" >
    <table width="601" border="0" cellpadding="0" cellspacing="0" >
      <tr>
        <td width="571" height="21" align="center">${focus.focusTitle}</td>
      </tr>
      <tr>
        <td width="571" height="21" align="right">${focus.createTime}</td>
      </tr>
        <tr>
          <td width="382" height="362" valign="top" colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${focus.focusContent}</td>
        </tr>
          <tr>
            <td height="30" align="right" >
              <input type="button" name="Submit" value="返回" onClick="javascript:history.go(-1);">
&nbsp;&nbsp;&nbsp;</td>
          </tr>
      </table>	 </td>
  </tr>
</table>
</div>
</body>
</html>
