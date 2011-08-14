

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%-- 
    Document   : noSession
    Created on : Jun 13, 2011, 10:54:53 AM
    Author     : Zaw.Htet
--%>
<body>
<head>
<script type='text/javascript' src='/VMS/dwr/interface/VmsDwr.js'></script>
<script type='text/javascript' src='/VMS/dwr/engine.js'></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/sys/vms/yui/build/fonts/fonts-min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/sys/vms/yui/build/datatable/assets/skins/sam/datatable.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/sys/vms/yui/build/dragdrop/dragdrop-min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/sys/vms/yui/build/element/element-min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/sys/vms/yui/build/datasource/datasource-min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/sys/vms/yui/build/event-delegate/event-delegate-min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/sys/vms/yui/build/datatable/datatable-min.js"></script>
<style type="text/css">

/* Pagination
---------------------------------------- */
.pagingItem {
	font-weight: normal;
	text-decoration: none;
	color: #747474;
	margin: 0 2px;
	padding: 0 2px;
	background-color: #eeeeee;
	border: 1px solid #bababa;
	font-size: 0.9em;
	line-height: 1.5em;
}

.pagingItemCurrent {
	padding: 0 2px;
	margin: 0 2px;
	font-weight: normal;
	color: #FFFFFF;
	background-color: #bfbfbf;
	border: 1px solid #bfbfbf;
	font-size: 0.9em;
}

.pagingDots {
	font-weight: normal;
}

.pagination span a:hover {
	border-color: #d2d2d2;
	background-color: #d2d2d2;
	color: #FFF;
	text-decoration: none;
}

.pagination img {
	vertical-align: middle;
}

.yui-skin-sam .yui-dt-liner {
	white-space: nowrap;
}

#myAutoComplete {
	width: 25em;
	padding-bottom: 2em;
}
</style>
<script type="text/javascript">
	
</script>
</head>
<body class="yui-skin-sam">
	<h2>Assign Member Role</h2>
	<a href="#">Home</a> >
	<a href="#">Project Mangement</a> > Assign Member Role

	<br />

	<br />

	<form id="searchMemberForm" name="searchMemberForm" method="post"
		action="<%=request.getContextPath()%>/admin/member/list.html">
		<table width="326" border="0">
			<tr>
				<td width="157"><label>Project Name</label> <label></label></td>
				<td width="159"><select name="project" id="project">
						<c:forEach items="${projectList}" var="item" varStatus="status">
							<option value="${item.projectId}">${item.projectName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Member Name</td>
				<td><input type="text" name="member" id="member"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" name="search" id="search"
					value="Submit"></td>
			</tr>
		</table>
		<input type="hidden" id="projectId" name="projectId">
		<div id="myAutoComplete">
			<label><br> </label>
			<div id="myContainer"></div>
		</div>
	</form>

	Search Result
	<%-- // show only current page worth of data --%>
	<table width="720px" border="1">
		<tr>
			<th width="20px">No.</th>
			<th width="250px">Name</th>
			<th width="250px">Team Leader</th>
			<th width="200px">Member</th>
			<th width="200px">Contact No.</th>
			<th width="200px">Email</th>
		</tr>
		<c:forEach items="${pagedListHolder.pageList}" var="item">
			<tr>
				<td>${item.personId}</td>
				<td>${item.firstName}</td>
				<td>${item.lastName}</td>
				<td>${item.memberType}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<p>
		<jsp:useBean id="pagedListHolder" scope="request"
			type="org.springframework.beans.support.PagedListHolder" />
		<%-- // create link for pages, "~" will be replaced later on with the proper page number --%>
		<c:url value="/admin/member/list.html" var="pagedLink">
			<c:param name="p" value="~" />
		</c:url>

		<%-- // load our paging tag, pass pagedListHolder and the link --%>
		<tg:paging pagedListHolder="${pagedListHolder}"
			pagedLink="${pagedLink}" />
	</p>
</body>