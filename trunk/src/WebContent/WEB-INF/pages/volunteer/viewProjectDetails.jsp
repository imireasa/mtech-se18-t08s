<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>

<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet"
	type="text/css">
<body>
<head>

<link type="text/css"
	href="<%=request.getContextPath()%>/sys/css/paging.css"
	rel="stylesheet" />


</head>
<body>
	<h2>Project Details</h2>
	<div id="breadcrumb">
		<a href="#">Home</a> / <a href="#">Volunteer</a> / <a href="#">Project
			Details</a>
	</div>

	<div class="query">
		<form:form name="viewProjectDetails" method="post"
			commandName="command" action="raiseInterest.html">
			<table>
				<tr>
					<td width="103"><label>Project Name:</label>
					</td>
					                        
					<td width="186"><label>${project.nme}</label>
				
					</td>
				</tr>
				<tr>
					<td width="103"><label>Description:</label>
					</td>
					<td width="167">${project.desc}</td>
				</tr>
				<tr>
					<td><label>Start Date:</label>
					</td>
					<td>${project.strDte}</td>
				</tr>
				<tr>
					<td><label>Project Status:</label>
					</td>
					<td>${project.stsCd}</td>
				</tr>
				<tr>
					<td><label>Location:</label>
					</td>
					<td>${project.loc}</td>
				</tr>
				<tr>
					<td><label>Country:</label>
					</td>
					<td>${project.ctryCd}</td>
				</tr>

			</table>
			<input type="submit" name="btn_RaiseProjectInterest"
				id="btn_RaiseProjectInterest" value="Raise Project Interest">
		</form:form>
	</div>


</body>