<%@ page pageEncoding="utf-8"  contentType="text/html; charset=utf-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新闻中心后台</title>
<script>

function Mycheck(){
	if(document.form.title.value==""){
       alert("请填写焦点新闻标题  ");
       return false;
     }else if(document.content.text()==""){
     alert("请填写焦点新闻内容   ");
       return false;
    }
	
}
</script>

</head>
<link rel="stylesheet" href="../css/style.css">
<body>
<div align="center">
  <iframe src="../bTop.jsp" marginheight="0" marginwidth="0" scrolling="no" width="799" height="122"></iframe>
  <table width="800" height="600" border="1" cellpadding="0" cellspacing="0">
  <tr>
    <td width="196" rowspan="2" valign="top">  <iframe src="../bleft.jsp" marginheight="0" marginwidth="0" frameborder="0"   scrolling="auto" width="200" height="600"></iframe></td>
  
    <td width="604" height="57" >

      <table width="595" height="56" cellpadding="0" cellspacing="0">
        <tr>
         <td>&nbsp;当前位置提示&nbsp;&gt;&gt;&nbsp;焦点新闻管理&nbsp;&gt;&gt;&nbsp;焦点新闻修改</td>
        </tr>
        <tr>
          <td>&nbsp;</td>
        </tr>
      </table></td>
  </tr>
  <tr>
    <td height="415" align="center" valign="top" >
    <table width="550" border="0" cellpadding="0" cellspacing="0" background="../bImage/placeNext.jpg">
      <tr>
        <td height="21" >&nbsp;</td>
        <td>修改焦点新闻</td>
      </tr>
    </table>     
<form action="../servlet/FocusServlet?action=update" method="post" onSubmit="return Mycheck()">
<input type="hidden" value="${focus.focusID}" name="focusId"/>
	<table width="550" height="373"  border="1" cellpadding="0" cellspacing="0">
      <tr>
        <td width="75" height="30" align="center">新闻标题</td>
        <td width="334" align="center">&nbsp;&nbsp;<input name="title" size="50" type="text" value="${focus.focusTitle}"/></td>
      </tr>
      <tr>
        <td height="302" align="center"><br>
          新闻内容</td>
        <td  valign="middle" align="left"> &nbsp;&nbsp;&nbsp;&nbsp;<textarea id="content" name="content" style="width:450px; height: 290px;" >${focus.focusContent}</textarea>             
          </td>
      </tr>
      <tr><td colspan="2" align="center" height="30"><input type="submit" value="修改"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="reset" value="清除"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" onClick="javascript:history.go(-1);" name="back" value="返回"/>
      </td></tr>
    </table> 	
</form>
</table>
</div>
</body>
</html>