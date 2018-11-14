<%@ page pageEncoding="utf-8"  contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新闻中心后台</title>
  <script type="text/javascript">
      function check(id){
      	var i = confirm("确定删除 ？");
      	var formName = document.getElementById("sort");
      	if(i){
      	formName.action="FocusServlet?&action=delete&focusId="+id;
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
    <td width="196" rowspan="2" valign="top">  <iframe src="../bleft.jsp" marginheight="0" marginwidth="0" frameborder="0"   scrolling="auto" width="200" height="600"></iframe></td>
    <td width="604" height="37" >
    
      <table width="601" height="36" border="0" cellpadding="0" cellspacing="0">
      <tr>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td>&nbsp;&nbsp;&nbsp;当前位置提示&nbsp;&gt;&gt;&nbsp;焦点新闻管理</td>
        </tr>
        
      </table></td>
  </tr>
  <tr>
    <td height="400" align="center" valign="top" >  
    <table width="601" border="0" cellpadding="0" cellspacing="0" background="../bImage/placeNext.jpg">
      <tr>
        <td height="21" >&nbsp;</td>
        <td>焦点新闻管理</td>
      </tr>
    </table>    <br/><br/>
    

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
	 <table width="500" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td colspan="3"><div align="right"><a href="../bForce/insertForce.jsp">焦点新闻添加</a>&nbsp;</div></td>
      </tr>
    </table>
	<table width="500" border="1" cellpadding="0" cellspacing="0">
      <tr>
        <td width="77" height="27"><div align="center">编号</div></td>
        <td width="218"><div align="center">焦点新闻标题</div></td>
        <td width="94"><div align="center">操作</div></td>
      </tr>
    <c:choose>
    <c:when test="${requestScope.focusList == null}">
    <tr><td colspan="3" align="center" style="color: green;font-size: 16px;">没有新闻！！！</td></tr>
    </c:when>
    <c:otherwise>
 
      	<c:set value="1" var="index"/>
    <c:forEach items="${requestScope.focusList}" var="focus">
    	<tr>
    	<td>${index}</td>
    	<c:set value="${index + 1}" var="index"/>
  
    	<td><a href="FocusServlet?action=getDetail&focusId=${focus.focusID}">${focus.focusTitle} </a></td>

       
    	<td><a href="FocusServlet?action=getFocus&focusId=${focus.focusID}">修改</a>    <a href="#" onclick="javaScript:check('${focus.focusID}')">删除</a>   	</td>
      	</tr>
    </c:forEach>
    </c:otherwise>
    </c:choose>
     <c:if test="${totalPage > 1}">
    <tr><td colspan="3"  height="20" align="center"> &nbsp;&nbsp;<a href="FocusServlet?action=getAllFocus&page=1">首页</a>    
	  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="FocusServlet?action=getAllFocus&page=${page-1}">上一页</a>   
	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    <a href="FocusServlet?action=getAllFocus&page=${page+1}">下一页</a>    
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; <a href="FocusServlet?action=getAllFocus&page=${totalPage}">尾页 </a> </td></tr>
   </c:if>
    </table>
     </form>
	</td>
  </tr>
</table>
</div>
</body>
</html>
