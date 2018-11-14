<%@ page pageEncoding="utf-8"  contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新闻中心后台</title>
<script>
function Mycheck(){
	if(document.form.title.value==""){
       alert("请填写新闻标题  ");
       return false;
     }
     else if(document.form.sId.value==0){
     	alert("请选择新闻分类  ");
       return false;
     }
   else if(document.form.content.value==0){
     alert("请填写新闻内容   ");
       return false;
    }else{
     return true;
    }
	
}
</script>

</head>
<link rel="stylesheet" href="../css/style.css">
<body>
<div align="center">
<iframe src="../bTop.jsp" marginheight="0" marginwidth="0" scrolling="no" width="800" height="122"></iframe>
  <table width="800" height="600" border="1" cellpadding="0" cellspacing="0">
  <tr>
    <td width="196" rowspan="2" valign="top">  <iframe src="../bleft.jsp" marginheight="0"  marginwidth="0" frameborder="0"   scrolling="auto" width="200" height="600"></iframe></td>
  
    <td width="604" height="37" >
      <table width="595" height="36" cellpadding="0" cellspacing="0">
      <tr>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td>&nbsp;当前位置提示&nbsp;&gt;&gt;&nbsp;${sortName}&nbsp;&gt;&gt;&nbsp;修改${sortName}</td>
        </tr>
        
      </table></td>
  </tr>
  <tr>
    <td height="440" align="center" >    
    
<form action="newsServlet?action=update&sortId=${sortId}" method="post" onSubmit="return Mycheck()" name="form">
<input type="hidden" name="newsId" value="${news.newsID}">
<br/>
	<table width="500" height="400"  border="1" cellpadding="0" cellspacing="0">
	<tr>
        <td colspan="2" align="center" valign="middle" ><h3>修改新闻</h3></td>
      </tr>
      <tr>
        <td width="75" height="30" align="center" valign="middle">新闻标题</td>
        <td width="334" align="center">&nbsp;&nbsp;<input name="title" size="50" type="text" value="${news.newsTitle}"/></td>
      </tr>
	    <tr>
        <td width="75" height="40" align="center">新闻类别</td>
        <td width="334">&nbsp;&nbsp;
		<select name="sId">
		<option selected="selected">请选择</option>
		<c:forEach items="${sortList}" var="sort">
		<c:choose>
		<c:when test="${sort.sortId == news.sortId}">
		<option value="${sort.sortId}" selected>${sort.sortName}</option>
		</c:when>
		<c:otherwise>
	    <option value="${sort.sortId}">${sort.sortName}</option>
		</c:otherwise>
		</c:choose>
		</c:forEach>
		</select></td>
      </tr>
      <tr>
        <td height="275" align="center" valign="top"><br>
          新闻内容</td>
        <td valign="middle">&nbsp;&nbsp;&nbsp;<textarea  id="content" name="content" style="width: 400px; height: 250px;" >${news.newsContent }</textarea>              
          </td>
      </tr>
      <tr><td colspan="2" align="center" height="30"><input type="submit" value="修改"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="reset" value="清除"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" onClick="javascript:history.go(-1);" name="back" value="返回"/>
      </td></tr>
    </table> 	
</form>
</table>
</div>
</body>
</html>