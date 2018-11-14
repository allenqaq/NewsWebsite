<%@ page pageEncoding="utf-8"  contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新闻中心后台</title>
   <script type="text/javascript">
      function check(sortId,newsId){
      	var i = confirm("确定删除 ？");
      	var formName = document.getElementById("sort");
      	if(i){
      	 	formName.action="newsServlet?&action=delete&sortId="+sortId + "&id="+newsId;
      		formName.submit();
      	}
      }
    </script>
</head>
<link rel="stylesheet" href="../css/style.css">
<body><div align="center">
<iframe src="../bTop.jsp" marginheight="0" marginwidth="0" scrolling="no" width="800" height="122"></iframe>
<table width="800" height="600" border="1" cellpadding="0" cellspacing="0">
  <tr>
    <td width="196" rowspan="2" valign="top">  <iframe src="../bleft.jsp" marginheight="0" marginwidth="0" frameborder="0"   scrolling="auto" width="200" height="600"></iframe></td>
  
    <td width="604" height="36" >
   
      <table width="601" height="36" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td valign="bottom">&nbsp;&nbsp;当前位置提示&nbsp;&gt;&gt;&nbsp;${sortName}</td>
        </tr>
     
      </table></td>
  </tr>
  <tr>
    <td height="400" align="center" valign="top" >
    <br/><br/>
      <script type="text/javascript">
      function hidden(id){
       var message = document.getElementById(id);
       message.style.display = "none";
      
      }
 		window.setTimeout("hidden('message')", 5000);
    </script>
    <c:if test="${message != null}">
    <div id="message" style="color: red;font-size: 16px;"> ${message }</div>
    </c:if>
 	<form action="" name="news" id="sort" method="post">
    <table width="568" border="1" style="border-collapse: collapse;">
    <c:choose>
    <c:when test="${requestScope.newsList == null}">
    <tr><td colspan="4" align="center" style="color: green;font-size: 16px;">没有新闻！！！</td></tr>
    </c:when>
    <c:otherwise>
    <tr>
    	<td width="44">序号</td>
    	<td width="160">分类</td>
    	<td width="248">标题</td>
    	<td width="88">操作</td>
      	</tr>
      	<c:set value="1" var="index"/>
    <c:forEach items="${requestScope.newsList}" var="news">
    	<tr>
    	<td>${index}</td>
    	<c:set value="${index + 1}" var="index"/>
    	<td>${sortName}</td>
    	<td><a href="newsServlet?action=getDetail&id=${news.newsID}&sortId=${sortId}">${news.newsTitle} </a></td>
    	
    	<td><a href="newsServlet?action=getNews&id=${news.newsID}&sortId=${sortId}">修改</a>  
		 <a href="#" onclick="javaScript:check('${sortId}','${news.newsID}')">删除</a></td>
      	</tr>
    </c:forEach>
    </c:otherwise>
    </c:choose>
     <c:if test="${totalPage > 1}">
	<tr><td colspan="4"  height="20" align="center"> &nbsp;&nbsp;<a href="newsServlet?action=getNewsBySortId&page=1&sortId=${sortId}">首页</a>    
	  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="newsServlet?action=getNewsBySortId&page=${page-1}&sortId=${sortId}">上一页</a>   
	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    <a href="newsServlet?action=getNewsBySortId&page=${page+1}&sortId=${sortId}">下一页</a>    
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; <a href="newsServlet?action=getNewsBySortId&page=${totalPage}&sortId=${sortId}">尾页 </a> </td></tr>
</c:if>  
    </table>
    </form>
	 <br>
	 <a href="newsServlet?action=getSort&sortId=${sortId}">添加新闻</a>     或者&nbsp;&nbsp;&nbsp;<a href="SortServlet?action=getAllSort">详细类别管理</a>

<table width="100%" border="0" cellpadding="0" cellspacing="0">
      <tr align="center">
        <td width="578" height="27" >
</td>
      </tr>
    </table>
</td>
  </tr>
</table>
</div>
</body>
</html>
