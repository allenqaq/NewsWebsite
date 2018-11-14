<%@ page pageEncoding="utf-8"  contentType="text/html; charset=utf-8" language="java" %>
<%@page import="beans.News"%>
<%@page import="dao.SortDAO"%>
<%@page import="beans.Sort"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新闻中心前台--新闻详细查询</title>
</head>
<link rel="stylesheet" href="../css/style.css">
<body><div align="center">
<iframe src="../fTop.jsp" marginheight="0" marginwidth="0" scrolling="no" width="800" height="222" frameborder="0"></iframe>
 <table width="800" height="660" border="0" cellpadding="0" cellspacing="0">
   <tr>
     <td width="216" rowspan="2" valign="top"><iframe src="../fleft.jsp" marginwidth="230" scrolling="no" width="100%" height="100%" frameborder="0" marginheight="0"></iframe></td>
     <td height="31" align="left" valign="middle" background="../fImage/place.jpg" >&nbsp;&nbsp;&nbsp;当前位置&nbsp;&nbsp;&gt;&gt;&nbsp;&nbsp;新闻关键字查询</td>
    </tr>
   <tr>
     <td height="630" align="center" valign="top" background="../fImage/botten.jpg"><table width="100%" height="31"background="../fImage/newsSort.jpg">
         <tr>
           <td width="8%" height="25" >&nbsp;</td>
           <td width="92%"><font color="#FFFFFF">
		  全部新闻查询
				   </font></td>
         </tr>
       </table>       <br>
       <table width="480" border="1" cellpadding="0" cellspacing="0">
         <tr bgcolor="#CCCCCC">
           <td width="111" height="19"><div align="center">新闻类型</div></td>
           <td width="353"><div align="center">新闻标题</div></td>
         </tr>
        <% List<News> newsList = (List<News>) session.getAttribute("keyNews");
        if(null != newsList){
         for(News news : newsList){
         Sort sort = SortDAO.getSortByID(news.getSortId());
         if(null != sort){
         %>
         <tr>
           <td height="31" align="center"><%=sort.getSortName() %></td>
           <td>&nbsp;<a href="../servlet/fNewsServlet?action=detail&newsId=<%=news.getNewsID() %>" target="_parent"><%=news.getNewsTitle() %></a></td>
         </tr>
         <%}
         }
         }else{
                 %>
               <tr>
           <td height="30" colspan="2"><div align="center" style="font-size: 12px;">暂无任何新闻</div></td>
           
         </tr>  
         <%} %>
         	 <c:if test="${tPage > 1}">
      <tr><td colspan="3"  height="20" align="center"> &nbsp;&nbsp;<a href="../servlet/fNewsServlet?action=search&page=1&key=${key}&sortId=${sortId}">首页</a>    
	  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  <a href="../servlet/fNewsServlet?action=search&page=${currentPage-1}&key=${key}&sortId=${sortId}">上一页</a>   
	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
  <a href="../servlet/fNewsServlet?action=search&page=${currentPage+1}&key=${key}&sortId=${sortId}">下一页</a>    
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;
	 <a href="../serlvet/fNewsServlet?action=search&page=${tPage}&key=${key}&sortId=${sortId}">尾页 </a> </td></tr>
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
