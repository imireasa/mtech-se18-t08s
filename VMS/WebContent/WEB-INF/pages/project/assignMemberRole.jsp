

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
<script type='text/javascript'
	src='<%=request.getContextPath()%>/dwr/interface/VmsDwr.js'></script>
<script type='text/javascript'
	src='<%=request.getContextPath()%>/dwr/engine.js'></script>

<link type="text/css"
	href="<%=request.getContextPath()%>/sys/css/paging.css"
	rel="stylesheet" />
<script type="text/javascript">
	function getMemberData() {

	}
</script>
</head>
<body>
	<h2>Assign Member Role</h2>
	<div id="breadcrumb">

		<a href="#">Home</a> > <a href="#">Project</a> > Assign Member Role
	</div>
	<br />

	<br />
	<div class="query">
		<form id="searchMemberForm" name="searchMemberForm" method="post"
			action="<%=request.getContextPath()%>/admin/project/assignPrjMemberRole.html">
			<table width="326" border="0">
				<tr>
					<td width="157"><label>Project Name</label>
					</td>
					<td width="159"><select name="project" id="project"
						onchange="">
							<option value="-1">Please select</option>
							<c:forEach items="${projectList}" var="item" varStatus="status">
								<option value="${item.projectId}">${item.projectName}</option>
							</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td>Member Name</td>
					<td><input type="text" name="member" id="member"><input
						type="submit" name="Search" id="Search" value="Search"
						class="button" />
					</td>
				</tr>
			</table>
		</form>
	</div>

	<table width="800" class="proj-table">
		<tr>
			<td colspan="6"><b> Project<br /> Member list</b></td>
		</tr>
		<tr>
			<th width="20px">No.</th>
			<th width="250px">Name</th>
			<c:forEach items="${projectRoleList}" var="item" varStatus="status">
				<th width="250px">${item.roleName}</th>
			</c:forEach>
			<th width="200px">Contact No.</th>
			<th width="200px">Email</th>
		</tr>
		<c:forEach items="${pagedListHolder.pageList}" var="item">
			<tr>
				<td>${item.volunteerId.personId}</td>
				<td>${item.volunteerId.firstName} ${item.volunteerId.lastName}</td>
				<c:forEach items="${projectRoleList}" var="roleItem"
					varStatus="status">
					<c:if test="${item.roleId.roleId==roleItem.roleId}">
						<td><input type="radio" name="roleItem${item.volunteerId.personId}" id="roleItem${item.volunteerId.personId}"
							value="item.roleId.roleId" checked="checked"></td>
					</c:if>
					<c:if test="${item.roleId.roleId!=roleItem.roleId}">
						<td><input type="radio" name="roleItem${item.volunteerId.personId}" id="roleItem${item.volunteerId.personId}"
							value="item.roleId.roleId"></td>
					</c:if>
				</c:forEach>
				<td>${item.volunteerId.mobile}</td>
				<td>${item.volunteerId.email}</td>
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