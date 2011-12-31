<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tab" uri="http://ditchnet.org/jsp-tabs-taglib"%>


<head>

<link type="text/css"
	href="<%=request.getContextPath()%>/sys/css/paging.css"
	rel="stylesheet" />
<tab:tabConfig/>

</head>
<body>
	<h2>Project Details</h2>
	<div id="breadcrumb">
		<a href="#">Home</a> / <a href="#">Volunteer</a> / <a href="#">Project
			Details</a>
	</div>

	<div class="query">
		<form:form name="viewProjectDetails" method="post"
			commandName="projectInfo" action="raiseInterest.html">
			<table>
				<tr>
					<td width="103"><label>Project Name:</label></td>

					<td width="186"><label>${project.nme}</label></td>
				</tr>
				<tr>
					<td width="103"><label>Description:</label></td>
					<td width="300">${project.desc}</td>
				</tr>
				<tr>
					<td><label>Start Date:</label></td>
					<td>${project.strDte}</td>
				</tr>
				<tr>
					<td><label>Project Status:</label></td>
					<td>${project.stsCd}</td>
				</tr>
				<tr>
					<td><label>Location:</label></td>
					<td>${project.loc}</td>
				</tr>
				<tr>
					<td><label>Country:</label></td>
					<td>${project.ctryCd}</td>
				</tr>
				<tr>
					<td><input type="submit" name="btn_RaiseProjectInterest"
				id="btn_RaiseProjectInterest" value="Raise Project Interest"></td>
					
				</tr>
			</table>
			
		</form:form>
	</div>

<div>
	<tab:tabContainer id="tab-container">

		<tab:tabPane id="member" tabTitle="Project Members">
		<form:form name="memberDetails" method="post"
			commandName="projectInfo" action="requestCertificate.html">
			<table width="200" border="1">
				<tr>
					<th>ID</th>
					<th>Role</th>
					<th>isActive</th>
				</tr>
				<c:forEach items="${memberList}" var="item" varStatus="status">
					<tr>
						<td>${item.usrLoginId}</td>
						<td>${item.roleCd}</td>
						<td>${item.actInd}</td>
						<td><input type="submit" name="btn_RequestCertificate"
				id="btn_RequestCertificate" value="Request for Certificate"></td>

					</tr>
					</c:forEach>
			</table>
			
		</form:form>
			

		</tab:tabPane>

		<tab:tabPane id="experience" tabTitle="Experience">

			<table border="1">
				<tr>
					<td>Id</td>
					<td width="114">Createdby</td>
					<td width="300">Content</td>
				</tr>
				<c:forEach items="${experienceList}" var="item" varStatus="status">
					<tr>
						<td>${item.prjExpId}</td>
						<td>${item.createdBy}</td>
						<td>${item.cont}</td>

					</tr>
				</c:forEach>
			</table>

			<form:form name="postExperience" method="post" commandName="projectInfo"
				action="postExperienceAndFb.html">
				<table width="707" height="105">
 					<tr> 
						<td width="122"><label>Content</label> 
						</td> 
						<td width="197"><spring:bind path="projectInfo.experience">
								<form:textarea path="experience" rows="5" cols="30" />
							</spring:bind> <form:errors path="experience" cssClass="error" />
						</td> 
					</tr> 
					<tr>
 						<td colspan="2" align="center"><input type="submit" 
							name="btn_Post" id="btn_Post" value="Publish"></td> 
					</tr>

				</table>


			</form:form>

		</tab:tabPane>

		<tab:tabPane id="feedback" tabTitle="Feedback">

			<table>
				<tr>
					<th>Id</th>
					<th>Createdby</th>
					<th>Title</th>
				</tr>
				<c:forEach items="${feedbackList}" var="item" varStatus="status">
					<tr>
						<td>${item.prjFbId}</td>
						<td>${item.createdBy}</td>
						<td>${item.title}</td>

					</tr>
				</c:forEach>
			</table>

		<form:form name="posetFeedback" method="post" commandName="projectInfo"
				action="postExperienceAndFb.html">
				<table width="707" height="105">
 					<tr> 
						<td width="122"><label>Title</label> 
						</td> 
						<td width="197"><spring:bind path="projectInfo.fbTitle">
								<form:input path="fbTitle" />
							</spring:bind> <form:errors path="fbTitle" cssClass="error" />
						</td> 
					</tr> 
					<tr> 
						<td width="122"><label>Feedback</label> 
						</td> 
						<td width="197"><spring:bind path="projectInfo.fbContent">
								<form:textarea path="fbContent" rows="5" cols="30" />
							</spring:bind> <form:errors path="fbContent" cssClass="error" />
						</td> 
					</tr> 
					<tr>
 						<td colspan="2" align="center"><input type="submit" 
							name="btn_Post" id="btn_Post" value="Publish"></td> 
					</tr>

				</table>


			</form:form>

		</tab:tabPane>

	</tab:tabContainer>
	</div>
</body>