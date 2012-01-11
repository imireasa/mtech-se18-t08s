<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tab" uri="http://ditchnet.org/jsp-tabs-taglib"%>


<head>
	<tab:tabConfig />
</head>
<body>
	<h2><fmt:message key="message.projectManagement.projectDetails.title" /></h2>
	<div id="breadcrumb">
		<a href="<%=request.getContextPath()%>/common/welcome.html"><fmt:message key="message.common.home.label"/></a> / 
		<a href="browseProject.html"><fmt:message key="message.projectManagement.browseProjects.title" /></a> / 
		<fmt:message key="message.projectManagement.projectDetails.title" />
	</div>

	<div class="query">
		<c:if test="${not empty riMsg}">
			<div class="infoblock">
				<c:out value="${riMsg}" escapeXml="false" />
				<br />
			</div>
		</c:if>

		<form:form name="viewProjectDetails" method="post"
			commandName="projectInfo" action="raiseInterest.html">
			<table class="query-table">
				<tr>
					<td width ="100"><fmt:message key="message.projectManagement.projectName.label" /></td>
					<td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
					<td>${projectVo.name}</td>
				</tr>
				<tr>
					<td><fmt:message key="message.common.description.label" /></td>
					<td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
					<td>${projectVo.desc}</td>
				</tr>
				<tr>
					<td><fmt:message key="message.common.startDate.label" /></td>
					<td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
					<td>${projectVo.strDte}</td>
				</tr>
				<tr>
					<td><fmt:message key="message.common.status.label" /></td>
					<td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
					<td>${projectVo.stsCd}</td>
				</tr>
				<tr>
					<td><fmt:message key="message.common.location.label" /></td>
					<td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
					<td>${projectVo.loc}</td>
				</tr>
				<tr>
					<td><fmt:message key="message.common.country.label" /></td>
					<td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
					<td>${projectVo.ctryCd}</td>
				</tr>

				<c:if test="${projectVo.stsCd != 'Close'}">
					<tr>
						<td colspan="2"></td>
						<td><input type="submit" name="raiseProjectInterestButton"
							id="raiseProjectInterestButton" value="<fmt:message key="message.common.raiseProjectInterest.button" />">
						</td>
					</tr>
				</c:if>
			</table>
		</form:form>
	</div>
	<tab:tabContainer id="tab-container">

		<tab:tabPane id="member" tabTitle="Project Members">
			<form:form name="memberDetails" method="post"
				commandName="projectInfo" action="requestCertificate.html">
				<table class="proj-table">
					<tr>
						<th><fmt:message key="message.common.loginid.label" /></th>
						<th><fmt:message key="message.common.role.label" /></th>

					</tr>
					<c:forEach items="${memberList}" var="item" varStatus="status">
						<tr>
							<td>${item.nme}</td>
							<td>${item.roleCd}</td>
							<c:if test="${item.usrLoginId ==projectVo.loginId}">
								<td><input type="submit" name="requestCertificateButton"
									id="requestCertificateButton" value="<fmt:message key="message.common.requestForCertificate.button" />">
								</td>
							</c:if>

						</tr>
					</c:forEach>
				</table>

			</form:form>


		</tab:tabPane>

		<tab:tabPane id="experience" tabTitle="Experience">
			<div>
				<table class="proj-table">
					<tr>
						<th><fmt:message key="message.common.id.label" /></th>
						<th><fmt:message key="message.common.creator.label" /></th>
						<th><fmt:message key="message.common.content.label" /></th>
					</tr>
					<c:forEach items="${exPagedListHolder.pageList}" var="item"
						varStatus="status">
						<tr>
							<td>${item.prjExpId}</td>
							<td>${item.createdBy}</td>
							<td>${item.cont}</td>

						</tr>
					</c:forEach>
				</table>
			</div>

			<div class="pagination2">
				<jsp:useBean id="exPagedListHolder" scope="request"
					type="org.springframework.beans.support.PagedListHolder" />
				<c:url value="viewProjectDetails.html" var="pagedLink2">
					<c:param name="p2" value="~" />
				</c:url>
				<tg:paging pagedListHolder="${exPagedListHolder}"
					pagedLink="${pagedLink2}" />
			</div>

			 <div class="query">
				<form:form name="postExperience" method="post"
					commandName="experienceVo" action="postExperience.html">
					<table class="query-table">
						<tr>

							<td><fmt:message key="message.common.content.label" /></td>
							<td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
							<td><spring:bind path="experienceVo.cont">
									<form:textarea path="cont" rows="5" cols="30" />
								</spring:bind> <form:errors path="cont" cssClass="error" />

							</td>
							
						</tr>
						<tr>
							<td colspan="2"></td>
							<td align="left"><input type="submit"
								name="postButton" id="postButton" value="<fmt:message key="message.common.publish.button" />">
							</td>
						</tr>

					</table>
				</form:form>
			</div>

		</tab:tabPane>
		<tab:tabPane id="feedback" tabTitle="Feedback">
			<table class="proj-table">
				<tr>
					<th><fmt:message key="message.common.id.label" /></th>
					<th><fmt:message key="message.common.creator.label" /></th>
					<th><fmt:message key="message.common.title.label" /></th>
					<th><fmt:message key="message.common.content.label" /></th>
				</tr>
				<c:forEach items="${fbPagedListHolder.pageList}" var="item"
					varStatus="status">
					<tr>
						<td>${item.prjFbId}</td>
						<td>${item.createdBy}</td>
						<td>${item.title}</td>
						<td>${item.cont}</td>

					</tr>
				</c:forEach>
			</table>
			<table>
				<tr>
					<td>
						<div class="pagination">
						<jsp:useBean id="fbPagedListHolder" scope="request"
						type="org.springframework.beans.support.PagedListHolder" />

							<c:url value="viewProjectDetails.html" var="pagedLink1">
								<c:param name="p1" value="~" />
							</c:url>

						<%-- // load our paging tag, pass pagedListHolder and the link --%>
						<tg:paging pagedListHolder="${fbPagedListHolder}"
						pagedLink="${pagedLink1}" />
						</div>
					</td>
				</tr>
			</table>
			<br />
			<div class="query">
				<form:form name="posetFeedback" method="post"
				commandName="feedbackVo" action="postFeedback.html">
				<table class="query-table">
					<tr>

						<td><fmt:message key="message.common.title.label" /></td>
						<td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
						<td width="197"><spring:bind path="feedbackVo.title">
								<form:input path="title" />
							</spring:bind> <form:errors path="title" cssClass="error" /></td>

					<tr>
						<td><fmt:message key="message.common.content.label" /></td>
						<td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
						<td><spring:bind path="feedbackVo.cont">
								<form:textarea path="cont" rows="5" cols="30" />
							</spring:bind> <form:errors path="cont" cssClass="error" /></td>

					</tr>
					<tr>
						<td colspan="2"></td>
						<td align="left"><input type="submit"
							name="postFeedbackButton" id="postFeedbackButton" value="<fmt:message key="message.common.publish.button" />">
						</td>
					</tr>

				</table>
				</form:form>
			</div>
		</tab:tabPane>

	</tab:tabContainer>
</body>