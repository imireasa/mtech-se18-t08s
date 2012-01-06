<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%><body>
<head>
</head>
<body>
   <h2><fmt:message key="message.projectManagement.proposeNewProject.title" /></h2>
	<div id="breadcrumb">
		<a href="#">Home</a> / <a href="#">Project </a> / <a href="#">Propose
			New Project</a>

	</div>
	
	<div class="query">
		<c:if test="${not empty msg}"> 
                     <div class="infoblock">
                             <c:out value="${msg}" escapeXml="false"/><br/>
                     </div>
         </c:if>
	     <c:if test="${not empty errors}"> 
                        <div class="errorblock">
                        	<c:out value="Error:"/>
                                <c:forEach var="error" items="${errors}">
                                        <c:out value="${error}" escapeXml="false"/><br/>
                                </c:forEach>
                        </div>
           </c:if>
	     
		<form:form name="proposeProject" method="post" commandName="proposalVo"
			action="submitProjectProposal.html">
			<table class="query-table">

				<tr>
					<td align="left"><fmt:message key="message.projectManagement.projectName.label"/> <span class="mandatory"><fmt:message key="message.common.symbol.mandatory.label"/></span> 
					</td>
					<td>
					<fmt:message key="message.common.symbol.afterLabel.label" />
					</td>
					<td>
					 <spring:bind path="proposalVo.name">  
					<form:input path="name" />
					 </spring:bind>
					 <form:errors path="name"
							cssClass="error" />
							
							</td>
				</tr>
				<tr>
					<td align="left"><fmt:message key="message.common.description.label"/> 
					</td>
					<td>
					<fmt:message key="message.common.symbol.afterLabel.label" />
					</td>
					<td>
					
					 <spring:bind path="proposalVo.desc">  
					<form:textarea path="desc" rows="5" cols="30" /> 
					 </spring:bind>
					<form:errors
							path="desc" cssClass="error" /></td>
				</tr>

				<tr>
					<td align="left"><fmt:message key="message.common.country.label"/> <span class="mandatory"><fmt:message key="message.common.symbol.mandatory.label"/></span> 
					</td>
					<td>
					<fmt:message key="message.common.symbol.afterLabel.label" />
					</td>
					<td>
				
					<form:select path="ctryCd">
					<form:option value="" label="--Select--"/>
							<c:forEach items="${countryList}" var="item" varStatus="status">
								<form:option value="${item.val}">${item.val}</form:option>
							</c:forEach>
						</form:select>
						
						<form:errors
							path="ctryCd" cssClass="error" /></td>
						
				</tr>
				<tr>
					<td align="left"><fmt:message key="message.common.location.label"/> <span class="mandatory"><fmt:message key="message.common.symbol.mandatory.label"/></span> 
					</td>
					<td>
					<fmt:message key="message.common.symbol.afterLabel.label" />
					</td>
					<td>
					 <spring:bind path="proposalVo.loc">  
					<form:textarea path="loc" rows="5" cols="30" /> 
					 </spring:bind>
					<form:errors
							path="loc" cssClass="error" /></td>
				</tr>

				<tr>
					<td align="left"><fmt:message key="message.common.duration.label"/> <span class="mandatory"><fmt:message key="message.common.symbol.mandatory.label"/></span> 
					</td>
					<td>
					<fmt:message key="message.common.symbol.afterLabel.label" />
					</td>
					<td>
					 <spring:bind path="proposalVo.estDuration">  
					<form:input path="estDuration" /> (days) 
					</spring:bind>
					<form:errors
							path="estDuration" cssClass="error" /></td>
				</tr>
				<tr>
					<td align="left"><fmt:message key="message.common.supportingDoc.label"/> 
					</td>
					<td>
					<fmt:message key="message.common.symbol.afterLabel.label" />
					</td>
					<td><input type="file"
							name="fileField_supportDocs" id="fileField_supportDocs">
					
					</td>
				</tr>
				
				<tr>
					<td colspan="3" align="center"><input type="submit" name="btn_Post" id="btn_Post"
						class="button" value="Submit"></td>
				</tr>
			</table>
			</form:form>
	</div>





</body>