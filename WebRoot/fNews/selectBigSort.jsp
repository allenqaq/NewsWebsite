<%@ page pageEncoding="utf-8"  contentType="text/html; charset=utf-8" language="java" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新闻中心前台--新闻类别查询</title>
</head>
<link rel="stylesheet" href="../css/style.css">
<body><div align="center">
<iframe src="../fTop.jsp" marginheight="0" marginwidth="0" scrolling="no" width="800" height="222" frameborder="0"></iframe>
 <table width="800" height="660" border="0" cellpadding="0" cellspacing="0">
   <tr>
     <td width="216" rowspan="3" valign="top"><iframe src="../fleft.jsp" marginwidth="230" scrolling="no" width="100%" height="100%" frameborder="0" marginheight="0"></iframe></td>
     <td height="31" colspan="2" align="left" valign="middle" background="../fImage/place.jpg" >&nbsp;&nbsp;&nbsp;当前位置&nbsp;&nbsp;&gt;&gt;&nbsp;&nbsp;新闻类别查询</td>
    </tr>
   <tr>
     <td height="31" colspan="2" align="center" valign="middle"  background="../fImage/newsSort.jpg"><font color="#FFFFFF"></font></td>
   </tr>
   <tr>
     <td width="160" height="598" align="center" valign="top" ><br>	 <table width="102" height="107" cellpadding="0" cellspacing="0">
       <tr>
         <td background="">&nbsp;</td>
       </tr>
     </table></td>
     <td width="424" align="left" valign="top"  background="../fImage/fbottem.jpg">
   
	 <table width="404" cellpadding="0" cellspacing="0">
	<c:if test="${empty newsList}">
	 <tr>
	 <td colspan="3">暂无任何新闻</td>
	 </tr>
 </c:if>
	  
	 <c:forEach items="${newsList}" var="news">
       <tr>
         <td width="20" height="20" ><img src="../fImage/triangle.jpg" width="6" height="9"></td>
         <td width="200"><a href="fNewsServlet?action=detail&newsId=${news.newsID}" target="_parent">${news.newsTitle}</a></td>
         <td width="54"> 
        <c:if test="${news.createTime == time}">
              <img src="../fImage/new.gif">
              </c:if>
               </td>
       </tr>
       <tr>
         <td height="15" colspan="3"><hr></td>
       </tr>
       	 </c:forEach>
       	 <c:if test="${totalPage > 1}">
      <tr><td colspan="3"  height="20" align="center"> &nbsp;&nbsp;<a href="fNewsServlet?action=getNewsBySort&page=1&sortId=${sortId}">首页</a>    
	  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  <a href="fNewsServlet?action=getNewsBySort&page=${page-1}&sortId=${sortId}">上一页</a>   
	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
  <a href="fNewsServlet?action=getNewsBySort&page=${page+1}&sortId=${sortId}">下一页</a>    
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;
	 <a href="fNewsServlet?action=getNewsBySort&page=${totalPage}&sortId=${sortId}">尾页 </a> </td></tr>
     </c:if>
     </table>

	 </td>
   </tr>
 </table>
<iframe src="../fBottom.jsp" marginheight="0" marginwidth="0" scrolling="no" width="799" height="30"></iframe>
<table width="800" height="30" border="0" cellpadding="0" cellspacing="0" bgcolor="#D3D3D3">
  <tr>
   <td><div align="center">友情链接</div></td>
    <td><div align="center"><a href="http://www.baidu.com/">百度新闻</a></div></td>
    <td><div align="center"><a href="http://news.sina.com.cn/">新浪新闻</a></div></td>
    <td><div align="center"><a href="http://news.qq.com/">腾讯新闻</a></div></td>
    <td><div align="center"><a href="http://news.sohu.com/">搜狐新闻</a></div></td>
  </tr>
</table>
</div>
</body>
</html>
