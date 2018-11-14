<%@ page pageEncoding="utf-8"  contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
<link rel="stylesheet" href="css/style.css">
<table width="216" height="660" border="0" cellpadding="0" cellspacing="0">
       <tr>
         <td height="121" >

		 <table width="216" height="98" border="0" cellpadding="0" cellspacing="0" background="fImage/leftOne.jpg">
           <tr>
             <td height="37">&nbsp;</td>
           </tr>
           <tr align="center">
          <form name="form" method="post" action="/J2EE_20122268/servlet/fNewsServlet?action=search">   <td height="84">关键字:
            <input name="key" type="text" size="20">            <br> <br>

			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     <select name="sortId">
	    <option value="0"></option>
	    <c:forEach items="${sortList}" var="sort">
        <option value="${sort.sortId}"  style="background:#00FFFF">${sort.sortName}</option>
		</c:forEach>
        </select>&nbsp; &nbsp;
                 <input type="submit" name="Submit" value="搜索">
              </td> </form>
           </tr>
         </table>


		 </td>
       </tr>
       <tr>
         <td height="210">		 <table width="216" height="141" border="0" cellpadding="0" cellspacing="0" background="fImage/leftTwo.jpg">
           <tr>
             <td height="36">&nbsp;</td>
           </tr>
           <tr>
             <td height="174" >
			 	<marquee direction="up" height="170" onmouseout="this.start()"
             onmouseover="this.stop()" scrollAmount="1" scrollDelay="1" class="linkBlack">
				<c:forEach items="${noticeList}" var="notice" begin="0" end="9" step="1">
               <div align="left">&nbsp;&nbsp;&nbsp;<a href="servlet/fNewsServlet?action=NoticeDetail&noticeId=${notice.noticeID}" target="_parent">${notice.noticeTitle }</a></div><br>
                 </c:forEach>
	
	</marquee>


			 </td>
           </tr>
         </table></td>
       </tr>
       <tr>
         <td height="336">

		 <table width="216" height="347" border="0" cellpadding="0" cellspacing="0" background="fImage/leftThree.jpg">
           <tr>
             <td height="38">&nbsp;</td>
           </tr>
           <tr>
             <td height="288" valign="top" ><br>
			  <table width="156" border="0" align="center" cellpadding="0" cellspacing="0">
			  <c:forEach items="${focusList}" var="focus" begin="0" end="9" step="1">
               <tr>
                 <td width="154" height="38"> <a href="servlet/fNewsServlet?action=FocusDetail&focusId=${focus.focusID}"" target="_parent">${focus.focusTitle }</a></td>
               </tr>
                 </c:forEach>
             </table> 
		     </td>
           </tr>
         
         </table>


		 </td>
       </tr>
</table>
