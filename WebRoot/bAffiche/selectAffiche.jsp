<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
      	formName.action="NoticeServlet?action=delete&noticeId="+id;
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
    <td width="196" rowspan="2" valign="top">&nbsp;<iframe src="../bleft.jsp" frameborder="0" marginheight="0" marginwidth="0" scrolling="auto" width="200" height="600"></iframe></td>
    <td width="604" height="37" >
      <table width="601" height="36" border="0" cellpadding="0" cellspacing="0">
      <tr>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td>&nbsp;&nbsp;&nbsp;当前位置提示&nbsp;&gt;&gt;&nbsp;公告信息管理</td>
        </tr>
        
      </table></td>
  </tr>
  <tr>
    <td height="400" align="center" valign="top" ><table width="601" border="0" cellpadding="0" cellspacing="0" background="../bImage/placeNext.jpg">
      <tr>
        <td height="21" >&nbsp;</td>
        <td>公告信息查询</td>
      </tr>
    </table>
    <br/><br/>
	<table width="500" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td><div align="right"><a href="../bAffiche/insertAffiche.jsp">公告信息添加</a>&nbsp;</div></td>
      </tr>
    </table>
    
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
     <form action="" name="notice" id="sort" method="post">
	<table width="500" border="1" cellpadding="0" cellspacing="0">
      <tr>
        <td width="77" height="27"><div align="center">编号</div></td>
        <td width="218"><div align="center">公告题目</div></td>
        <td width="101"><div align="center">创建时间</div></td>
        <td width="94"><div align="center">操作</div></td>
      </tr>
      <c:choose>
      <c:when test="${noticeList == null}">
      <tr><td align="center" colspan="4" style="color: green;font-size: 16px;">暂无任何公告信息！！！</td></tr>
      </c:when>
      <c:otherwise>
         <c:set var="index" value="1"></c:set>
      <c:forEach items="${noticeList}" var="notice">
   
	  <tr align="center">
	  <td align="center" height="27">${index}</td>
	  <c:set value="${index + 1}" var="index"></c:set>
	  <td>
	  <a href="NoticeServlet?action=getDetail&noticeId=${notice.noticeID}" target="_parent">${notice.noticeTitle }</a>
	  </td>
	  <td>${notice.createTime}</td>
	   
        
	  <td>
	  <a  href="NoticeServlet?action=getNotice&noticeId=${notice.noticeID}">修改</a>&nbsp;&nbsp;
	<a href="#" onclick="javaScript:check('${notice.noticeID}')">删除</a>
	  </td>
	  </tr>
	     </c:forEach>
      </c:otherwise>
      </c:choose>
   
   <c:if test="${totalPage > 1}">
	     <tr><td colspan="4"  height="20" align="center"> &nbsp;&nbsp;<a href="NoticeServlet?action=getAllNotice&page=1">首页</a>    
	  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  <a href="NoticeServlet?action=getAllNotice&page=${page-1}}">上一页</a>   
	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
  <a href="NoticeServlet?action=getAllNotice&page=${page+1}">下一页</a>    
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;
	 <a href="NoticeServlet?action=getAllNotice&page=${totalPage}">尾页 </a> </td></tr>
   </c:if>
    </table></form>
</td>
  </tr>
</table>
</div>
</body>
</html>
