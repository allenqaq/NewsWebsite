<%@ page pageEncoding="utf-8"  contentType="text/html; charset=utf-8" language="java" %>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.News"%>
<%@page import="beans.Sort"%>
<%@page import="dao.SortDAO"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"   %>
<html>

<head>
<link rel="stylesheet" href="../css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新闻中心后台首页</title>
  <script type="text/javascript">
      function check(id){
      	var i = confirm("确定删除 ？");
      	var formName = document.getElementById("sort");
      	if(i){
      	formName.action = "newsServlet?action=delete&sortId=0&id="+id;
      		formName.submit();
      	}
      }
    </script>
</head>
<body><div align="center">
<iframe src="../bTop.jsp" marginheight="0" marginwidth="0" scrolling="no" width="799" height="122"></iframe>
<table width="800" height="600" border="1" cellpadding="0" cellspacing="0">
  <tr>
    <td width="196" rowspan="2" valign="top">  <iframe src="../bleft.jsp" marginheight="0" marginwidth="0" frameborder="0"   scrolling="auto" width="200" height="600"></iframe></td>
  
    <td width="604" height="57" >
    <table width="600" height="36" border="0" cellpadding="0" cellspacing="0" >
        <tr>
          <td>&nbsp;&nbsp;当前位置提示&nbsp;&gt;&gt;&nbsp;后台首页</td>
        </tr>
        <tr>
          <td>&nbsp;</td>
        </tr>
      </table></td>
  </tr>
  <tr align="center">
    <td valign="top" >	  <table width="601" border="0" cellpadding="0" cellspacing="0" background="bImage/placeNext.jpg">
        <tr>
          <td height="21" >&nbsp;</td>
          <td>全部新闻查询</td>
        </tr>
      </table>
          <br/><br>
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

	  <table width="500" border="1" cellpadding="0" cellspacing="0">
	  
      <tr>
        <td width="54" height="27"><div align="center">编号</div></td>
        <td width="145"><div align="center">标题</div></td>
        <td width="78"><div align="center">类别</div></td>
        <td width="78"><div align="center">创建时间</div></td>
        <td width="126"><div align="center">操作</div></td>
      </tr>
      <%
      	List<News> newsList = (List<News>)request.getAttribute("nList");
      	if(null != newsList){
      	for(int i=0;i<newsList.size();i++){
      	  News news = newsList.get(i);
      	 Sort sort = SortDAO.getSortByID(news.getSortId());
      	// if(null != sort){
      %>
       <tr>
        <td width="54" height="27"><div align="center"><%=i+1 %></div></td>
        <td width="145"><div align="center"><a href="newsServlet?action=getDetail&id=<%=news.getNewsID() %>&sortId=0"><%=news.getNewsTitle() %></a></div></td>
        <td width="78"><div align="center"><%=sort.getSortName() %></div></td>
        <td width="78"><div align="center"><%=news.getCreateTime() %></div></td>
   
        <td width="126"><div align="center"><a href="newsServlet?action=getNews&id=<%=news.getNewsID() %>&sortId=0">修改</a> 
        <a href="#" onclick="javaScript:check('<%=news.getNewsID()%>')">删除</a> </div></td>
      </tr>
      	<% }
      	//}
      	}else{
      	%>
      	<tr>
      	<td colspan="5" height="30" align="center"><font color="green">暂无任何新闻</font></td>
      	</tr>
      	<%
      	}
       %>
       <c:if test="${totalPage > 1}">
       	<tr><td colspan="5" align="center" height="25"> <a href="newsServlet?action=getAllNews&page=1">首页</a>    
	  <a href="newsServlet?action=getAllNews&page=${page -1}">上一页</a>   
	     <a href="newsServlet?action=getAllNews&page=${page + 1 } ">下一页</a>    
	  <a href="newsServlet?action=getAllNews&page=${totalPage}">尾页 </a> </td></tr>
   </c:if>
  </table>
  </form>
  <br><br/>
    <a href="newsServlet?action=getAllSort&sortId=0" target="_parent">添加新闻</a>&nbsp;&nbsp;&nbsp;
    或者&nbsp;&nbsp;&nbsp;<a href="SortServlet?action=getAllSort">详细类别管理</a>
 </td>
  </tr>
</table>
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
