<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"
	language="java"%>
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
     else if(document.form.sId.value == 0){
     	alert("请选择新闻分类  ");
       return false;
     }
   else if(form.content.value==""){
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
			<iframe src="../bTop.jsp" marginheight="0" marginwidth="0"
				scrolling="no" width="800" height="122"></iframe>
			  <table width="800" height="600" border="1" cellpadding="0" cellspacing="0">
  <tr>
    <td width="196" rowspan="2" valign="top">  <iframe src="../bleft.jsp" marginheight="0" marginwidth="0" frameborder="0"   scrolling="auto" width="200" height="600"></iframe></td>
  
    <td width="604" height="37" >

						<table width="595" height="36" cellpadding="0" cellspacing="0">
						<tr>
								<td>
									&nbsp;
								</td>
							</tr>
							<tr>
								<td>
									&nbsp;当前位置提示&nbsp;&gt;&gt;&nbsp;${sortName}&nbsp;&gt;&gt;&nbsp;添加${sortName}
								</td>
							</tr>
							
						</table>
					</td>
				</tr>
				<tr>
					<td height="440" align="center" valign="top"
						>
						<table width="595" border="0" cellpadding="0" cellspacing="0"
							background="../bImage/placeNext.jpg">
							<tr>
								<td height="21" valign="top">
									&nbsp;
								</td>
								<td>
									添加新闻
								</td>
							</tr>
						</table>
						<form action="newsServlet?action=add&sortId=${sortId}"
							method="post" onSubmit="return Mycheck()" name="form">
							<table width="555" height="400" border="1" cellpadding="0"
								cellspacing="0">
								<tr>
									<td width="75" height="30" align="center">
										新闻标题
									</td>
									<td width="334" align="center">
										&nbsp;&nbsp;
										<input name="title" size="50" type="text" />
									</td>
								</tr>
								<tr>
									<td width="75" height="40" align="center">
										新闻类别
									</td>
									<td width="334">
										&nbsp;&nbsp;
										<select name="sId">
											<option selected="selected" value="0">
												请选择
											</option>
											<c:choose>
												<c:when test="${sortId == 0}">
													<c:forEach items="${sortList}" var="sort">
														<option value="${sort.sortId}">
															${sort.sortName}
														</option>
													</c:forEach>
												</c:when>
												<c:otherwise>
													<option value="${sortId}" selected >
														${sortName}
													</option>

												</c:otherwise>
											</c:choose>


										</select>
									</td>
								</tr>
								<tr>
									<td height="275" align="center" valign="top">
										<br>
										新闻内容
									</td>
									<td>
										&nbsp;&nbsp;<textarea  id="content" name="content"
											style="width:450px; height: 270px;"></textarea>
									</td>
								</tr>
								<tr>
									<td colspan="2" align="center">
										<input type="submit" value="添加" />
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="reset" value="清除" />
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="button" onClick="javascript:history.go(-1);"
											name="back" value="返回" />
									</td>
								</tr>
							</table>
						</form>
			</table>
		</div>
	</body>
</html>