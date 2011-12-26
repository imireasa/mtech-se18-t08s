<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>

<body>
<head>
<script type='text/javascript'
	src='<%=request.getContextPath()%>/dwr/interface/VmsDwr.js'></script>
<script type='text/javascript'
	src='<%=request.getContextPath()%>/dwr/engine.js'></script>

<link type="text/css"
	href="<%=request.getContextPath()%>/sys/css/paging.css"
	rel="stylesheet" />


</head>
<body>
	
	<div id="breadcrumb">
		<a href="#">Home</a> / <a href="#">Volunteer</a> / <a href="#">Browse Project</a>
	</div>
    <h2>Browse Project</h2>
	<div class="query">
   	  <form name="form1" method="post" action="">
	  <table width="1013" height="105" border="1">
	    <tr>
	      <td width="103"><label>Project Code:</label></td>
	      <td width="167"><input type="text" name="textfield3" id="textfield3"></td>
	      <td width="133"><label>Start Month:</label></td>
	      <td width="429">          12/26/2011</td>
        </tr>
	    <tr>
	      <td><label>Project Name:</label></td>
	      <td><input type="text" name="textfield4" id="textfield4"></td>
	      <td><label>Status:</label></td>
	      <td><label for="select_status"></label>
	        <select name="select_status" id="select_status">
          </select></td>
        </tr>
        
        <tr>
					<td colspan="2" align="right">    
        	<input type="submit" name="btn_Search" id="btn_Search" value="Search">
            </td>
            </tr>
	   
      </table>

	   
   	  </form>
    </div>
	<!-- end of query -->
	<table width="700" class="proj-table">
		<tr>
			<td colspan="5"><b><label>Project List</label></b></td>
		</tr>
		<tr>
			<th><label>Name</label></th>
			<th><label>Description</label></th>
			<th><label>StartDate</label></th>
			<th><label>Details</label></th>
			
		</tr>
		<c:forEach items="${pagedListHolder.pageList}" var="item">
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">
	  <jsp:useBean id="pagedListHolder" scope="request"
			type="org.springframework.beans.support.PagedListHolder" />

		<%-- // create link for pages, "~" will be replaced later on with the proper page number --%>
		<c:url value="/admin/member/searchProjectMember.html" var="pagedLink">
			<c:param name="p" value="~" />
		</c:url>

		<%-- // load our paging tag, pass pagedListHolder and the link --%>
		<tg:paging pagedListHolder="${pagedListHolder}"
			pagedLink="${pagedLink}" />
	</div>
</body>