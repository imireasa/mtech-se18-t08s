<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<head>
    <script type="text/javascript">
        var defProjName = 'Please select...';       
        
        $(document).ready(function(){            
            $("#command").validationEngine();            
        });
        
        
    </script>
</head>
<body>
        <h2><fmt:message key="message.projectManagement.updateProject.label"/></h2>
        <div id="breadcrumb">

                <a href="<%=request.getContextPath()%>/common/welcome.html"><fmt:message key="message.common.home.label"/></a> /
                <a href="listProjects.html"><fmt:message key="message.projectManagement.projectManagement.label"/></a> / 
                <fmt:message key="message.projectManagement.updateProject.label"/>
        </div>
        <div class="query">
                <c:if test="${not empty msg}"> 
                        <div class="info">
                                <c:out value="${msg}" escapeXml="false"/><br/>
                        </div>
                </c:if>

                <c:if test="${not empty errors}"> 
                        <div class="error">
                                <c:forEach var="error" items="${errors}">  
                                        <c:out value="${error}" escapeXml="false"/><br/>
                                </c:forEach>
                        </div>
                </c:if>

                <form:form name="updateProject" method="post"
                           commandName="command" 
                           action="updateProject.html">
                        <form:hidden path="cmdType"/>
                        <table class="query-table">
								 <form:hidden path="prjId"/>
								<!-- Project Id (Disabled) -->
								<tr>
                                        <td align="left"><fmt:message key="message.projectManagement.projectId.label"/></td>
                                        <td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                                        <td align="left">
                                                <form:input path="prjIdDisplayed" disabled="true"/>
                                                <form:errors path="prjIdDisplayed" cssClass="error"/>
                                        </td>
                                </tr>	
																	
								<!-- Project Name -->
								  <tr>
                                        <td align="left"><fmt:message key="message.projectManagement.projectName.label"/> <span class="mandatory"><fmt:message key="message.common.symbol.mandatory.label" /> </span></td>
                                        <td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                                        <td align="left"><label for="textarea"></label>
                                                <form:textarea path="name" cols="45" rows="2" cssClass="validate[required,maxSize[100]]"></form:textarea>
                                                <form:errors path="name" cssClass="error"/>
                                        </th>
                                </tr>		
								 <!-- Description -->
								<tr>
                                        <td align="left"><fmt:message key="message.projectManagement.projectDescription.label"/> <span class="mandatory"><fmt:message key="message.common.symbol.mandatory.label" /> </span></td>
                                       <td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                                        <td align="left"><label for="textarea"></label>
                                                <form:textarea path="desc" cols="45" rows="4" cssClass="validate[required,maxSize[255]]"></form:textarea>
                                                <form:errors path="desc" cssClass="error"/>
                                        </td>
                                </tr>	
								 <!-- Start Date -->
								<tr>
                                        <td align="left"><fmt:message key="message.common.startDate.label"/> <span class="mandatory"><fmt:message key="message.common.symbol.mandatory.label" /> </span></td>
                                        <td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                                        <td align="left">
                                                <form:input path="strDte" maxlength="25" size="25" cssClass="validate[required]"/>
                                                <form:errors path="strDte" cssClass="error"/>
                                                <img src="<%=request.getContextPath()%>/sys/images/cal.gif" onClick="javascript:NewCssCal('strDte','ddMMyyyy')" style="cursor:pointer"/>
												<fmt:message key="message.common.date.format.label" />
                                        </td>
                                </tr>	 
								<!-- End Date -->
								 <tr>
                                        <td align="left"><fmt:message key="message.common.endDate.label"/> <span class="mandatory"><fmt:message key="message.common.symbol.mandatory.label" /> </span></td>
                                        <td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                                        <td align="left">
                                                <form:input path="endDte" maxlength="25" size="25" cssClass="validate[required]"/>
                                                <form:errors path="endDte" cssClass="error"/>
                                                <img src="<%=request.getContextPath()%>/sys/images/cal.gif" onClick="javascript:NewCssCal('endDte','ddMMyyyy')" style="cursor:pointer"/>
												<fmt:message key="message.common.date.format.label" />
										</td>
                                </tr>
								 <!-- Conuntry -->
								 <tr>
								 	<td align="left">
                                        <fmt:message key="message.common.country.label"/> 
                                        <span class="mandatory"><fmt:message key="message.common.symbol.mandatory.label" /> </span></td>
									<td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
								 	<td>
                                                <form:select path="ctryCd">
                                                        <c:forEach items="${countryList}" var="item" varStatus="status">
                                                                <c:choose>
                                                                        <c:when test="${item.cdId==command.ctryCd}">
                                                                                <option value="${item.cdId}" selected="true">${item.val}</option>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                                <option value="${item.cdId}">${item.val}</option>
                                                                        </c:otherwise>
                                                                </c:choose>
                                                        </c:forEach>
                                                </form:select>
												<form:errors path="ctryCd" cssClass="error"/>
                                       </td>
                                 </tr>       
								<!-- Location -->
								<tr>
                                        <td align="left"><fmt:message key="message.common.location.label"/> <span class="mandatory"><fmt:message key="message.common.symbol.mandatory.label" /> </span></td>
                                        <td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                                        <td align="left"><label for="textarea"></label>
                                                <form:textarea path="loc" cols="45" rows="4" cssClass="validate[maxSize[255]]"></form:textarea>
                                                <form:errors path="loc" cssClass="error"/>
                                        </td>
                                </tr>	
								 <!-- Project Status -->
								  <tr>
								 	<td align="left"><fmt:message key="message.projectManagement.projectStatus.label"/> <span class="mandatory"><fmt:message key="message.common.symbol.mandatory.label" /> </span></td>
									<td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
								 	<td>
                                                <form:select path="stsCd">
                                                        <c:forEach items="${statusList}" var="item" varStatus="status">
                                                                <c:choose>
                                                                        <c:when test="${item.cdId==command.stsCd}">
                                                                                <option value="${item.cdId}" selected="true">${item.val}</option>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                                <option value="${item.cdId}">${item.val}</option>
                                                                        </c:otherwise>
                                                                </c:choose>
                                                        </c:forEach>
                                                </form:select>
												<form:errors path="stsCd" cssClass="error"/>
                                       </td>
                                 </tr>     
								<!-- Remark -->
								<tr>
                                        <td align="left"><fmt:message key="message.common.remark.label"/></td>
                                       <td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                                        <td align="left"><label for="textarea"></label>
                                                <form:textarea path="rmk" cols="45" rows="4" cssClass="validate[maxSize[500]]"></form:textarea>
                                                <form:errors path="rmk" cssClass="error"/>
                                        </td>
                                </tr>
                                 <form:hidden path="version"/>
								
                                <tr>
										<td colspan="2"></td>
                                        <td><input type="submit" name="updateButton" id="updateButton" value="<fmt:message key="message.common.update.button"/>"></td>
                                </tr>
								
								
                        </table>
                </form:form>
        </div>
</body>