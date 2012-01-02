<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%><body>
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
   <h2>Propose New Project</h2>
	<div id="breadcrumb">
		<a href="#">Home</a> / <a href="#">Project </a> / <a href="#">Propose
			New Project</a>

	</div>
	
	<div class="query">
	     <c:if test="${not empty errors}"> 
                        <div class="error">
                                <c:forEach var="error" items="${errors}">
                                 <c:out value="Error:"/>  
                                        <c:out value="${error}" escapeXml="false"/><br/>
                                </c:forEach>
                        </div>
           </c:if>
	     
		<form:form name="proposeProject" method="post" commandName="proposalVo"
			action="submitProjectProposal.html">
			<table class="proj-table">

				<tr>
					<th align="left"><fmt:message key="message.projectManagement.projectName.label"/>(*):
					</th>
					<td>
					 <spring:bind path="proposalVo.name">  
					<form:input path="name" />
					 </spring:bind>
					 <form:errors path="name"
							cssClass="error" />
							
							</td>
				</tr>
				<tr>
					<th align="left"><fmt:message key="message.common.description.label"/>:
					</th>
					<td>
					
					 <spring:bind path="proposalVo.desc">  
					<form:textarea path="desc" rows="5" cols="30" /> 
					 </spring:bind>
					<form:errors
							path="desc" cssClass="error" /></td>
				</tr>

				<tr>
					<th align="left"><fmt:message key="message.common.country.label"/>(*):
					</th>
					<td>
				
					<form:select path="ctryCd">
					<form:option value="" label="--Select--"/>
							<c:forEach items="${countryList}" var="item" varStatus="status">
								<option value="${item.val}">${item.val}</option>
							</c:forEach>
						</form:select>
						
						<form:errors
							path="ctryCd" cssClass="error" /></td>
						</td>
				</tr>
				<tr>
					<th align="left"><fmt:message key="message.common.location.label"/>(*):
					</th>
					<td>
					 <spring:bind path="proposalVo.loc">  
					<form:textarea path="loc" rows="5" cols="30" /> 
					 </spring:bind>
					<form:errors
							path="loc" cssClass="error" /></td>
				</tr>

				<tr>
					<th align="left"><fmt:message key="message.common.duration.label"/>(*):
					</th>
					<td>
					 <spring:bind path="proposalVo.estDuration">  
					<form:input path="estDuration" /> (days) 
					</spring:bind>
					<form:errors
							path="estDuration" cssClass="error" /></td>
				</tr>
				<tr>
					<th align="left"><fmt:message key="message.common.supportingDoc.label"/>:
					</th>
					<td><input type="file"
							name="fileField_supportDocs" id="fileField_supportDocs">
					</label>
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center"><input type="button" name="btn_Post" id="btn_Post"
						value="Submit"></td>
				</tr>
			</table>
			</form:form>
			
			<c:if test="${not empty msg}"> 
                        <div class="info">
                                <c:out value="${msg}" escapeXml="false"/><br/>
                        </div>
            </c:if>
	</div>





</body>