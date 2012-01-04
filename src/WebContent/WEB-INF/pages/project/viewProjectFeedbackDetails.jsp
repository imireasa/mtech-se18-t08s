<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<head>

<link type="text/css"
	href="<%=request.getContextPath()%>/sys/css/paging.css"
	rel="stylesheet" />
	
<style> 
                .error{ color:red;}  
                .info{ color:blue;}  
</style>

</head>
<body>
	<h2>Project Feedback Details</h2>
	<div id="breadcrumb">
		<a href="#">Home</a> / <a href="#">Project</a> / <a href="#">Project Feedback Details</a>
	</div>

	<div class="query">
	<c:if test="${not empty fbMsg}"> 
                        <div class="infoblock">
                                <c:out value="${fbMsg}" escapeXml="false"/><br/>
                        </div>
            </c:if>
	<table class="proj-table">
				<tr>
					<th><fmt:message key="message.projectManagement.projectName.label"/></th>
<th>
					<fmt:message key="message.common.symbol.afterLabel.label" />
					</th>
					<td><label>${projectFbVo.prjName}</label></td>
				</tr>
				<tr>
					<th><fmt:message key="message.common.title.label"/></th>
					<th>
					<fmt:message key="message.common.symbol.afterLabel.label" />
					</th>
					<td>${projectFbVo.fbTitle}</td>
				</tr>
				<tr>
					<th><fmt:message key="message.common.content.label"/></th>
					<th>
					<fmt:message key="message.common.symbol.afterLabel.label" />
					</th>
					<td>${projectFbVo.fbContent}</td>
				</tr>
				<tr>
					<th><fmt:message key="message.common.status.label"/></th>
					<th>
					<fmt:message key="message.common.symbol.afterLabel.label" />
					</th>
					<td>${projectFbVo.fbStatus}</td>
				</tr>
				<tr>
					<th><fmt:message key="message.common.creator.label"/></th>
					<th>
					<fmt:message key="message.common.symbol.afterLabel.label" />
					</th>
					<td>${projectFbVo.createdBy}</td>
				</tr>
				<tr>
					<th><fmt:message key="message.common.creatdate.label"/></th>
					<th>
					<fmt:message key="message.common.symbol.afterLabel.label" />
					</th>
					<td>${projectVo.createdDte}</td>
					
				</tr>
				<tr>
					<td>
					<form:form name="viewFbDetails" method="post"
			 action="approveFb.html">
					<input type="submit" name="btn_Publish"
				id="btn_Publish" value="Publish" class="button">
				</form:form>
				</td>
                <td>
                <form:form name="viewFbDetails" method="post"
			      action="rejectFb.html">
                <input type="submit" name="btn_Reject"
				id="btn_Reject" value="Reject" class="button">
				</form:form>
				</td>
					
					
				</tr>
				
				
				
			
           
			</table>
			
		
	</div>


</body>