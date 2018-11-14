<%@ page pageEncoding="utf-8"  contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新闻中心后台</title>
     <script type="text/javascript">
      function check(id){
      	var i = confirm("确定删除 ？");
      	//SortServlet?action=getSort&sortId=${sort.sortId}
      	var formName = document.getElementById("sort");
      	if(i){
      		formName.action = "SortServlet?action=delete&sortId=" + id;
      		formName.submit();
      	}
      }
    </script>
    
</head>
<link rel="stylesheet" href="../css/style.css">
<body><div align="center">
<iframe src="../bTop.jsp" marginheight="0" marginwidth="0" scrolling="no" width="799" height="122"></iframe>
<table width="800" height="600" border="1" cellpadding="0" cellspacing="0">
  <tr>
    <td width="200" rowspan="2" valign="top"><iframe src="../bleft.jsp" marginheight="0"  marginwidth="0" scrolling="auto" width="200" height="600" frameborder="1"></iframe></td>
    <td width="597" height="37" >
      <table width="601" height="36" border="0" cellpadding="0" cellspacing="0">
      <tr>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td>&nbsp;&nbsp;&nbsp;当前位置提示&nbsp;&gt;&gt;&nbsp;详细类别管理</td>
        </tr>
        
      </table></td>
  </tr>
  <tr>
    <td height="400" align="center" valign="top"><table width="601" border="0" cellpadding="0" cellspacing="0" background="../bImage/placeNext.jpg">
      <tr>
        <td height="21" >&nbsp;</td>
        <td>新闻类别查询</td>
      </tr>
    </table>
     <script type="text/javascript">
      function hidden(id){
       var message = document.getElementById(id);
       message.style.display = "none";
      
      }
 		window.setTimeout("hidden('message')", 5000);
    </script>
    <br/><br/>
    <c:if test="${message != null}">
    <div id="message" style="color: red;font-size: 16px;"> ${message }</div>
    </c:if>
  	<form action="" id="sort" name="sort" method="post">
	<table width="500" border="1" cellpadding="0" cellspacing="0">
      <tr>
        <td width="77" height="27"><div align="center">编号</div></td>
        <td width="218"><div align="center">分类名称</div></td>
        <td width="94"><div align="center">操作</div></td>
      </tr>
   		<c:choose>
   		<c:when test="${requestScope.sortList != null}">
   		 	<c:set value="1" var="index"/>
    <c:forEach items="${requestScope.sortList}" var="sort">
    	<tr>
    	<td height="27">${index}</td>
    	<c:set value="${index + 1}" var="index"/>
    	<td>${sort.sortName}</td>
		<td><a href="SortServlet?action=getSort&sortId=${sort.sortId}">修改</a>   
    	 <a href="#" onclick="javaScript:check('${sort.sortId}')">删除</a></td>
      	</tr>
    </c:forEach>
   		</c:when>
   		<c:otherwise>
   		<tr>
        <td  height="37" colspan="3"><div align="center" style="color: green;font-size: 16px;">暂无任何信息</div></td>
       
      </tr>
   		</c:otherwise>
   		</c:choose>
   		 <c:if test="${totalPage > 1}">
     	     <tr><td colspan="3"  height="27" align="center"> &nbsp;&nbsp;<a href="SortServlet?action=getAllSort&page=1">首页</a>    
	  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  <a href="SortServlet?action=getAllSor&page=${page-1}">上一页</a>   
	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
  <a href="SortServlet?action=getAllSort&page=${page+1}">下一页</a>    
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;
	 <a href="SortServlet?action=getAllSort&page=${totalPage}">尾页 </a> </td></tr>
   
    </c:if>
  
    </table>
    </form>
    <br/>
       <a href="../bSort/insertSort.jsp" target="_parent">添加</a>&nbsp;&nbsp;&nbsp;或者&nbsp;&nbsp;&nbsp;<a href="javascript:history.go(-1);">返回</a>
    
	</td>
  </tr>
</table>

  
</div>
</body>
</html>
