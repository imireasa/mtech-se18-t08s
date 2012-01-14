<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>

<body>
	<h2><fmt:message key="message.projectManagement.manageMember.label" /></h2>
	<div id="breadcrumb">
		<a href="<%=request.getContextPath()%>/common/welcome.html"><fmt:message key="message.common.home.label" /></a> / <a
			href="listProjects.html"><fmt:message
				key="message.projectManagement.projectManagement.label" /></a> / 
				<fmt:message key="message.projectManagement.manageMember.label" />
	</div>
	<div class="query">
		<c:if test="${not empty msg}">
			<div class="infoblock">
				<c:out value="${msg}" escapeXml="false" />
				<br />
			</div>
		</c:if>
		<c:if test="${not empty errors}">
			<div class="errorblock">
				<c:out value="Error:" />
				<c:forEach var="error" items="${errors}">
					<c:out value="${error}" escapeXml="false" />
					<br />
				</c:forEach>
			</div>
		</c:if>
        <table class="query-table">
			<tr>
				<td><fmt:message key="message.projectManagement.projectName.label" /></td>
				<td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
				<td>${projectVo.name}</td>
			</tr>
			<tr>
				<td><fmt:message key="message.projectManagement.projectLocation.label" /></td>
				<td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
				<td>${projectVo.loc}(${projectVo.ctry})</td>
			</tr>
		</table>
	</div>
	<form:form method="GET">
		<input type="hidden" id="prjId" name="prjId" value="${prjId}" />

		<table class="proj-table">

			<tr>
				<th width="20"><fmt:message key="message.common.check.label" /></th>
				<th width="170"><fmt:message key="message.common.name.label" /></th>
				<th width="75"><fmt:message key="message.common.country.label" /></th>
				<th width="100"><fmt:message key="message.common.role.label" /></th>
			</tr>
			<c:forEach items="${memberPagedListHolder.pageList}" var="item">
				<tr>
					<td><input type="checkbox" name="prjMbrId" id="prjMbrId"
						value="${item.prjMbrId},${item.version}" /></td>
					<td>${item.title}.${item.nme}</td>
					<td>${item.ctry}</td>
					<td><select name="roleCd_${item.prjMbrId}"
						id="roleCd_${item.prjMbrId}">
							<c:forEach items="${roleList}" var="roleitem" varStatus="status">
								<c:choose>
									<c:when test="${roleitem.cdId==item.roleCd}">
										<option value="${roleitem.cdId}" selected="true">${roleitem.val}</option>
									</c:when>
									<c:otherwise>
										<option value="${roleitem.cdId}">${roleitem.val}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="4" align="right"><input type="submit"
					name="removeMemberButton" id="removeMemberButton"
					value="<fmt:message key="message.common.remove.button"/>" /> <input
					type="submit" name="updateMemberButton" id="updateMemberButton"
					value="<fmt:message key="message.common.update.button"/>" /> 
                    <input					type="submit" name="inviteMemberButton" id=""inviteMemberButton"
					value="<fmt:message key="message.projectManagement.inviteMember.button"/>" />
					<input type="submit" name="requestProjCertButton"
					id="requestProjCertButton"
					value="<fmt:message key="message.projectManagement.requestCertificate.button"/>" />
				</td>
			</tr>

		</table>
	</form:form>




</body>