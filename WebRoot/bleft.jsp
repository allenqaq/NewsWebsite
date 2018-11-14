<%@ page pageEncoding="utf-8"  contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="css/style.css">
<!--script language='javascript'>alert('您已经与服务器断开');window.location.href='index.html';</script-->
<table width="199" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="80" align="center" ><table width="199" height="80" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td background="bImage/manager.jpg"><div align="center">用户${manager.name}已经登录 <br>
              <br>
登录次数为${manager.number}次</div></td>
          </tr>
        </table> </td>
      </tr>
      <tr>
        <td height="282" valign="top">
        <c:forEach items="${sortList}" var="sort">
        <table width="199" align="center" cellpadding="0" cellspacing="0" background="bImage/newsSort.jpg">

          <tr align="center">
            <td height="22">&nbsp;</td>
          </tr>
          <tr align="center">
            <td height="26" valign="top">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="servlet/newsServlet?sortId=${sort.sortId}&action=getNewsBySortId" target="_parent">${sort.sortName }管理</a></td>
          </tr>

        </table>
		
	</c:forEach>
	
		</td>
      </tr>
      <tr>
        <td height="67" align="center" background="bImage/otherSort.jpg"><table width="129" height="47" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="129">&nbsp;</td>
          </tr>
          <tr>
            <td><div align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="servlet/NoticeServlet?action=getAllNotice" target="_parent">公告信息管理</a></div></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="66" align="center" background="bImage/otherSort.jpg">

		<table width="129" height="47" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="129">&nbsp;</td>
          </tr>
          <tr>
            <td><div align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="servlet/FocusServlet?action=getAllFocus" target="_parent">焦点导读管理</a></div></td>
          </tr>
        </table>		</td>
      </tr>
    </table>
