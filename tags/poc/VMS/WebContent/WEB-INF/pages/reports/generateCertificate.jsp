

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
		return;
		document.forms["form"].action = "<%=request.getContextPath()%>/report/volunteer/generateCertificate.html"
		document.forms["form"].submit();
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
		<form id="form" name="form" method="post"
			action="<%=request.getContextPath()%>/report/volunteer/generateCertificatePdf.html">
			<table width="326" border="0">
				<tr>
					<td width="157"><label>Project Name</label></td>
					<td width="159"><select name="projectId" id="projectId"
						onchange="getMemberData()">
							<option value="-1">Please select</option>
							<c:forEach items="${projectList}" var="item" varStatus="status">
								<option value="${item.projectId}">${item.projectName}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>Member Name</td>
					<td><select name="volunteerId" id="volunteerId"
						onchange="getMemberData()">
							<option value="-1">Please select</option>
							<c:forEach items="${volunteerList}" var="item" varStatus="status">
								<option value="${item.volunteerId.personId}">${item.volunteerId.firstName}
									${item.volunteerId.lastName}</option>
							</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" name="Search" id="Search"
						value="Generate" class="button" />
					</td>
			</table>
		</form>
	</div>
</body>