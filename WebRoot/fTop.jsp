<%@ page pageEncoding="utf-8"  contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="css/style.css">
<script src="js/validate.JS"></script>
<body onLoad="clockon(bgclock);">
<c:choose>
<c:when test="${manager == null}">

<table width="800" height="23" border="0"  cellpadding="0" cellspacing="0" background="fImage/landWhite.jpg"> 
 <form name="form1" action="servlet/managerServlet?action=login" method="post" onSubmit="return check()"> 
  <tr>
    <td width="208"> &nbsp;&nbsp;&nbsp;&nbsp;账号:<input type="text" name="account"></td>
    <td width="184">密码:<input type="password" name="password"></td>
    <td width="87"><input type="submit" name="submit" value="登录"></td>
    <td width="62"><input type="reset" name="clean" value="清除信息"></td>
	<td width="259" align="center"><div id="bgclock"></div></td>
  </tr>
  </form>
</table>
</c:when>
<c:otherwise>
<table width="800" height="23" border="0"  cellpadding="0" cellspacing="0" background="fImage/landWhite.jpg"> 
  <tr>
  <td align="center"><span style="font-size: 14px">${manager.name},欢迎您使用本系统！</span>
  </td>
    <td align="center"> <span><a href="servlet/newsServlet?action=getAllNews" style="font-size: 14px "target="_parent"><font  color="red">进入后台</a></span>  
    <a href="servlet/managerServlet?action=loginOut" style="font-size: 14px " target="_parent">[退出]</a></td>
    <td align="center">
		<span style="font-size: 14px" id="bgclock"></span>
	</td>
  </tr>
</table>
</c:otherwise>
</c:choose>

<table width="800" height="7" border="0" cellpadding="0" cellspacing="0" background="fImage/landGrey.jpg">
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>
<table width="800" height="153" border="0" cellpadding="0" cellspacing="0" background="fImage/two.jpg">
  <tr>
    <td width="627">&nbsp;</td>
    <td width="173" valign="top">
	  <table width="157" height="137" border="0" cellpadding="0" cellspacing="0">
    </table>
	</td>
  </tr>
</table>
<table width="800" height="34" border="0" cellpadding="0" cellspacing="0" background="fImage/three.jpg">
  <tr>
    <td width="216">&nbsp;</td>
    <td width="584" align="center"><strong><a href="index.jsp" target="_parent">首页</a>&nbsp;|</font>&nbsp;
	                                        <a href="servlet/fNewsServlet?action=getNewsBySort&sortId=1" target="_parent">时政 </a>&nbsp;|</font>&nbsp;
											 <a href="servlet/fNewsServlet?action=getNewsBySort&sortId=2" target="_parent">经济 </a>&nbsp;|</font>&nbsp;
											  <a href="servlet/fNewsServlet?action=getNewsBySort&sortId=3" target="_parent">法制 </a>&nbsp;|</font>&nbsp;
											   <a href="servlet/fNewsServlet?action=getNewsBySort&sortId=4"" target="_parent">科学 </a>&nbsp;|</font>&nbsp;
											     <a href="servlet/fNewsServlet?action=getNewsBySort&sortId=5" target="_parent">社会 </a>&nbsp;|</font>&nbsp;
												   <a href="servlet/fNewsServlet?action=getNewsBySort&sortId=6" target="_parent">娱乐</a>&nbsp;</font>&nbsp;
												  <a href="servlet/fNewsServlet?action=getNewsBySort&sortId=6" target="_parent">   </a>&nbsp;</font>&nbsp;
												   <a href="servlet/fNewsServlet?action=getTodayNews"  target="_parent">今 日 新 闻 </a></font>&nbsp;</strong>
	</td>
  </tr>
</table>
</body>
