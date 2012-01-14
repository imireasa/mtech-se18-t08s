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
		<a href="#">Home</a> / <a href="#"> Project Proposal List</a></div>
        <h2> Project Proposal List</h2>
    <!-- end of query -->
	<table width="700" class="proj-table">
		
        <th><label>Proposal Name</label></th>
			<th><label>Description</label></th>
			
			<th><label>Country</label></th>
			<th><label>Location</label></th>
            <th><label>Estimated Duration</label></th>
			<th><label>Status</label></th>
            
			
		</tr>
		<c:forEach items="${pagedListHolder.pageList}" var="item">
			<tr>
				<td><a href="reviewProjectProposal.jsp">XX</a></td>
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