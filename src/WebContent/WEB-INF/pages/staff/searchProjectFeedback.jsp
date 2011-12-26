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
		<a href="#">Home</a> / <a href="#">Manage Project</a> / <a href="#">Search Project Feedback</a></div>
        <h2>Search Project Feedback</h2>
	<div class="query">
   	  <form name="form1" method="post" action="">
	  <table width="1013" height="105" border="1">
	    <tr>
	      <td width="103"><label>Project Code:</label></td>
	      <td width="167"><input type="text" name="textfield3" id="textfield3"></td>
	      <td width="133"><label>Feedback Title:</label></td>
	      <td width="429"><input type="text" name="txtField_feedbackTitle" id="txtField_feedbackTitle"></td>
        </tr>
	    <tr>
	      <td><label>Project Name:</label></td>
	      <td><input type="text" name="textfield4" id="textfield4"></td>
	      <td><label>Status:</label></td>
	      <td><label for="select_Status"></label>
	        <select name="select_Status" id="select_Status">
	          <option>All</option>
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
			<th colspan="5" align="left">
			<label>Search Results</label></th>
		</tr>
		<tr>
        <th><label>Project Code</label></th>
			<th><label>Project Name</label></th>
			
			<th><label>Feedback Title</label></th>
			<th><label>Created by</label></th>
            <th><label>Status</label></th>
            
			
		</tr>
		<c:forEach items="${pagedListHolder.pageList}" var="item">
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
                <td>&nbsp;</td>
                <td><a href="#">Details</a></td>
				<td><input type="submit" name="btn_publish" id="btn_publish" value="Publish"></td>
                <td><input type="submit" name="btn_ignore" id="btn_ignore" value="Ignore"></td>
			
			
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