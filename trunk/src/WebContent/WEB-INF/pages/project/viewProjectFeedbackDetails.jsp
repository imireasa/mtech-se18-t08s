<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<head>

<link type="text/css"
	href="<%=request.getContextPath()%>/sys/css/paging.css"
	rel="stylesheet" />

</head>
<body>
	<h2>Project Feedback Details</h2>
	<div id="breadcrumb">
		<a href="#">Home</a> / <a href="#">Project</a> / <a href="#">Project Feedback Details</a>
	</div>

	<div class="query">
	<table class="proj-table">
				<tr>
					<td width="103"><label>Project Name:</label></td>

					<td width="186"><label>${projectFbVo.prjName}</label></td>
				</tr>
				<tr>
					<td width="103"><label>FeedBack Title:</label></td>
					<td width="300">${projectFbVo.fbTitle}</td>
				</tr>
				<tr>
					<td><label>Feedback Content:</label></td>
					<td>${projectFbVo.fbContent}</td>
				</tr>
				<tr>
					<td><label>Feedback Status:</label></td>
					<td>${projectFbVo.fbStatus}</td>
				</tr>
				<tr>
					<td><label>Created by:</label></td>
					<td>${projectFbVo.createdBy}</td>
				</tr>
				<tr>
					<td><label>Creation Date:</label></td>
					<td>${projectVo.createdDte}</td>
				</tr>
				<tr>
					<td>
					<form:form name="viewFbDetails" method="post"
			 action="approveFb.html">
					<input type="submit" name="btn_Publish"
				id="btn_Publish" value="Publish">
				</form:form>
				</td>
                <td>
                <form:form name="viewFbDetails" method="post"
			      action="rejectFb.html">
                <input type="submit" name="btn_Reject"
				id="btn_Reject" value="Reject">
				</form:form>
				</td>
					
					
				</tr>
			</table>
			
		
	</div>


</body>