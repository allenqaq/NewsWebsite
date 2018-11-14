<%@ page pageEncoding="utf-8"  contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新闻中心前台首页</title>
</head>
<link rel="stylesheet" href="css/style.css">
<body><div align="center">
<iframe src="fTop.jsp" marginheight="0" marginwidth="0" scrolling="no" width="800" height="235" frameborder="0"></iframe>
 <table width="800" height="678" border="0" cellpadding="0" cellspacing="0">
   <tr>
     <td width="216" rowspan="3" valign="top"><iframe src="fleft.jsp" marginwidth="230" scrolling="no" width="100%" height="100%" frameborder="0" marginheight="0"></iframe></td>
     <td height="216" valign="middle">
	 <table width="584" height="224" border="0" cellpadding="0" cellspacing="0" background="fImage/rightOne.jpg">
       <tr>
         <td height="44"><table width="262" border="0" align="center" cellpadding="0" cellspacing="0">
           <tr>
             <td width="131" height="18">&nbsp;</td>
             <td width="134"><div align="right" class="word_white"><strong><a href="servlet/fNewsServlet?action=getNewsBySort&sortId=1"><font color="#FFFFFF">more...</font></a></strong></div></td>
           </tr>
         </table></td>
         <td height="44"><table width="262" border="0" align="center" cellpadding="0" cellspacing="0">
           <tr>
             <td width="131" height="18">&nbsp;</td>
             <td width="134"><div align="right"><strong><a href="servlet/fNewsServlet?action=getNewsBySort&sortId=2"><font color="#FFFFFF">more...</font></a></strong></div></td>
           </tr>
         </table></td>
       </tr>
       <tr>
         <td width="291" valign="top">
		            <br>   <table width="234" border="0" align="center" cellpadding="0" cellspacing="0">
		            
		   
          <c:forEach items="${szNews}" begin="0" end="4" step="1" var="news">
          <tr >
                <td  height="25"><a href="servlet/fNewsServlet?action=detail&newsId=${news.newsID}">${news.newsTitle}</a></td>
           </tr>
          </c:forEach>
         </table>
         </td>
         <td width="291" valign="top">
		<table width="234" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
             <td  align="right"><img src="fImage/new.gif"></td>
           </tr>
             <c:forEach items="${jjNews}" begin="0" end="4" step="1" var="news">
          <tr >
                <td  height="25"><a href="servlet/fNewsServlet?action=detail&newsId=${news.newsID}">${news.newsTitle}</a></td>
           </tr>
          </c:forEach>
           
         </table></td>
       </tr>
     </table>



 	  </td>
    </tr>
   <tr>
     <td height="222">

	 <table width="584" height="226" border="0" cellpadding="0" cellspacing="0" background="fImage/rightTwo.jpg">
       <tr>
         <td height="44"><table width="262" border="0" align="center" cellpadding="0" cellspacing="0">
           <tr>
             <td width="131" height="18">&nbsp;</td>
             <td width="134"><div align="right"><strong><a href="servlet/fNewsServlet?action=getNewsBySort&sortId=3"><font color="#FFFFFF">more...</font></a></strong></div></td>
           </tr>
         </table></td>
         <td height="44"><table width="262" border="0" align="center" cellpadding="0" cellspacing="0">
           <tr>
             <td width="131" height="18">&nbsp;</td>
             <td width="134"><div align="right"><strong><a href="servlet/fNewsServlet?action=getNewsBySort&sortId=4"><font color="#FFFFFF">more...</font></a></strong></div></td>
           </tr>
         </table></td>
       </tr>
       <tr>
         <td width="293" valign="top">
		 
		<br>  <table width="234" border="0" align="center" cellpadding="0" cellspacing="0">
           <c:forEach items="${fzNews}" begin="0" end="4" step="1" var="news">
          <tr >
                <td  height="25"><a href="servlet/fNewsServlet?action=detail&newsId=${news.newsID}">${news.newsTitle}</a></td>
           </tr>
          </c:forEach>
           </table>
		 <br></td>
         <td width="296" valign="top">
		<br>    <table width="234" border="0" align="center" cellpadding="0" cellspacing="0">
                <c:forEach items="${kxNews}" begin="0" end="4" step="1" var="news">
          <tr >
                <td  height="25"><a href="servlet/fNewsServlet?action=detail&newsId=${news.newsID}">${news.newsTitle}</a></td>
           </tr>
          </c:forEach>
         </table>
		 <br></td>
       </tr>
     </table></td>
    </tr>
   <tr>
     <td height="225">

	   <table width="584" height="228" border="0" cellpadding="0" cellspacing="0" background="fImage/rightThree.jpg">
       <tr>
         <td height="42"><table width="262" height="30" border="0" align="center" cellpadding="0" cellspacing="0">
           <tr>
             <td width="131" height="23">&nbsp;</td>
             <td width="134"><div align="right"><strong><a href="servlet/fNewsServlet?action=getNewsBySort&sortId=5"><font color="#FFFFFF">more...</font></a></strong></div></td>
           </tr>
         </table></td>
         <td height="42"><table width="262" height="30" border="0" align="center" cellpadding="0" cellspacing="0">
           <tr>
             <td width="131" height="18">&nbsp;</td>
             <td width="134"><div align="right"><strong><a href="servlet/fNewsServlet?action=getNewsBySort&sortId=1"><font color="#FFFFFF">more...</font></a></strong></div></td>
           </tr>
         </table></td>
       </tr>
       <tr>
         <td width="293" valign="top">
		    <br>
		  <table width="234" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr >
            
             <td align="right"><img src="fImage/new.gif">
              
             </td>
              <c:forEach items="${shNews}" begin="0" end="4" step="1" var="news">
          <tr >
                <td  height="25"><a href="servlet/fNewsServlet?action=detail&newsId=${news.newsID}">${news.newsTitle}</a></td>
           </tr>
          </c:forEach>
           </tr>
         
         </table>
		 <br><br><br></td>
         <td valign="top">
        <br>  <table width="234" border="0" align="center" cellpadding="0" cellspacing="0">
           <tr >
       
             <td align="right">
             <img src="fImage/new.gif">
             </td>
           </tr>
               <c:forEach items="${ylNews}" begin="0" end="4" step="1" var="news">
          <tr >
                <td  height="25"><a href="servlet/fNewsServlet?action=detail&newsId=${news.newsID}">${news.newsTitle}</a></td>
           </tr>
          </c:forEach>
         </table>
       <br>  <br><br></td>
       </tr>
     </table>

	 </td>
    </tr>
 </table>
<iframe src="fBottom.jsp" marginheight="0" marginwidth="0" scrolling="no" width="799" height="30"></iframe>
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
