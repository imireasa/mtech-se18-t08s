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
	<h2>Manage Project</h2>
	<div id="breadcrumb">
		<a href="#"><fmt:message key="message.common.home.label" /></a> /
				<fmt:message key="message.projectManagement.projectManagement.label" />
	</div>

	<div class="query">
		<form:form name="listProjects" method="get" commandName="command"
			action="listProjects.html">

			<table width="660" height="105">
				<tr>
					<td width="123">Project Name</td>
					<td width="199"><form:input path="name" /></td>
					<td width="359">&nbsp;</td>
				</tr>
				<tr>
					<td>Status</td>
					<td><form:select path="stsCd">
							<form:option value="">All</form:option>
							<c:forEach items="${projectStatusList}" var="item"
								varStatus="status">
								<form:option value="${item.cdId}">${item.val}</form:option>
							</c:forEach>

						</form:select></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td width="123">Start Month</td>
					<td width="199"><form:input path="strDte" /> <img
						src="<%=request.getContextPath()%>/sys/images/cal.gif"
						onClick="javascript:NewCssCal('strDte')"
						style="cursor: pointer" /></td>
					<td><input type="submit" name="btn_Search" id="btn_Search"
						value="Search"></td>
				</tr>

			</table>
		</form:form>
	</div>
	<!-- end of query -->
	<table width="700" class="proj-table">
		<tr>
			<td colspan="8"><b><label>Project List</label></b></td>
		</tr>
		<tr>
			<td colspan="8"><b><a href="createProject.html"><fmt:message key="message.projectManagement.createProject.label"/></a></b></td>
		</tr>
		<tr>
			<td><label>Project Name</label></td>
			<td><label>Description</label></td>
			<td><label>StartDate</label></td>
			<td><label>Status</label></td>
			<td colspan="4"><label>Actions</label></td>


		</tr>
		<c:forEach items="${pagedListHolder.pageList}" var="item">
			<tr>
				<td>${item.name}</td>
				<td>${item.strDte}</td>
				<td>${item.endDte}</td>
				<td>${item.stsCd}</td>
				<td><a href="manageProjectMember.html?prjId=${item.prjId}">Member</a></td>
				<td><a href="manageProjectInterest.html?prjId=${item.prjId}">Interest</a></td>
				<td><a href="viewProject.html?prjId=${item.prjId}">View</a></td>
				<td><a href="updateProject.html?prjId=${item.prjId}">Update</a></td>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">
		<jsp:useBean id="pagedListHolder" scope="request"
			type="org.springframework.beans.support.PagedListHolder" />

		<%-- // create link for pages, "~" will be replaced later on with the proper page number --%>
		<c:url value="/admin/project/listProjects.html" var="pagedLink">
			<c:param name="p" value="~" />
			<c:param name="projectName" value="${projectName}" />
		</c:url>

		<%-- // load our paging tag, pass pagedListHolder and the link --%>
		<tg:paging pagedListHolder="${pagedListHolder}"
			pagedLink="${pagedLink}" />
	</div>
</body>