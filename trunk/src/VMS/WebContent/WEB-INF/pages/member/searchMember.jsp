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
	href="<%=request.getContextPath()%>/sys/css/style.css" rel="stylesheet" />

<script type="text/javascript">
	function getProjectMember(val, name) {
		document.getElementById("projectId").value = val;
		document.getElementById("projectName").value = name;
		document.getElementById("searchMemberForm").submit();
	}
</script>
</head>
<body>
	<h2>Search Member</h2>
	<div id="breadcrumb">
		<a href="#">Home</a> / <a href="#">Project</a> / Search Member
	</div>
	<div class="query">
		<form id="searchMemberForm" name="searchMemberForm" method="post"
			action="<%=request.getContextPath()%>/admin/member/list.html">
			<input type="hidden" id="projectId" name="projectId">

			<p>
				<b>Project name</b> <input id="projectName" name="projectName"
					type="text" value="Please select..." /> <input type="submit"
					name="Search" id="Search" value="Search" class="button" />
		</form>
	</div>
	<!-- end of query -->
	<table width="300" class="proj-table">
		<tr>
			<th>#</th>
			<th>Project</th>
		</tr>
		<c:forEach items="${projectList}" var="item" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td><a href="#"
					onclick="getProjectMember('${item.projectId}', '${item.projectName}')">${item.projectName}</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<table width="700" class="proj-table">
		<tr>
			<td colspan="5"><b>iHOPE 2011 Project<br /> Member list</b>
			</td>
		</tr>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Role</th>
			<th>Contact Number</th>
			<th>Email</th>
		</tr>
		<c:forEach items="${pagedListHolder.pageList}" var="item">
			<tr>
				<td>${item.personId}</td>
				<td>${item.volunteerId.firstName}&nbsp;${item.volunteerId.lastName}</td>
				<td>${item.roleId.roleName}</td>
				<td>${item.volunteerId.mobile}</td>
				<td>${item.volunteerId.email}</td>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">
		<jsp:useBean id="pagedListHolder" scope="request"
			type="org.springframework.beans.support.PagedListHolder" />

		<%-- // create link for pages, "~" will be replaced later on with the proper page number --%>
		<c:url value="/admin/member/list.html" var="pagedLink">
			<c:param name="p" value="~" />
		</c:url>

		<%-- // load our paging tag, pass pagedListHolder and the link --%>
		<tg:paging pagedListHolder="${pagedListHolder}"
			pagedLink="${pagedLink}" />
	</div>
</body>