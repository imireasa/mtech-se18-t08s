<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>

<body>
<head>
        <script type='text/javascript'
        src='<%=request.getContextPath()%>/dwr/interface/VmsDwr.js'></script>
        <script type='text/javascript'
        src='<%=request.getContextPath()%>/dwr/engine.js'></script>

        <link type="text/css"
              href="<%=request.getContextPath()%>/sys/css/paging.css"
              rel="stylesheet" />

        <style> 
                .error{ color:red;}  
                .info{ color:blue;}  
        </style>

</head>
<body>
        <h2><fmt:message key="message.projectManagement.createProject.label"/></h2>
        <div id="breadcrumb">
                <a href="#"><fmt:message key="message.common.home.label"/></a>/
                <a href="listProjects.html"><fmt:message key="message.projectManagement.projectManagement.label"/></a> / 
                <fmt:message key="message.projectManagement.createProject.label"/>
        </div>
        <div class="query">
                <c:if test="${not empty errors}"> 
                        <div class="error">
                                <c:forEach var="error" items="${errors}">  
                                        <c:out value="${error}" escapeXml="false"/><br/>
                                </c:forEach>
                        </div>
                </c:if>

                <form:form name="createProject" method="post"
                           commandName="command" 
                           action="createProject.html">
                        <form:hidden path="cmdType"/>
                        <table width="400" class="query-table">
                          
								 <!-- Project Name -->
								  <tr>
                                        <td align="left"><fmt:message key="message.projectManagement.projectName.label"/></td>
                                        <td>:</td>
                                        <td align="left"><label for="textarea"></label>
                                                <form:textarea path="name" cols="45" rows="2"></form:textarea>
                                                <form:errors path="name" cssClass="error"/>
                                        </td>
                                </tr>		
								 <!-- Description -->
								<tr>
                                        <td align="left"><fmt:message key="message.projectManagement.projectDescription.label"/></td>
                                        <td>:</td>
                                        <td align="left"><label for="textarea"></label>
                                                <form:textarea path="desc" cols="45" rows="4"></form:textarea>
                                                <form:errors path="desc" cssClass="error"/>
                                        </td>
                                </tr>	
								 <!-- Start Date -->
								<tr>
                                        <td align="left"><fmt:message key="message.common.startDate.label"/></td>
                                        <td>:</td>
                                        <td align="left">
                                                <form:input path="strDte" cssClass="Date" maxlength="25" size="25"/>
                                                <form:errors path="strDte" cssClass="error"/>
                                                <img src="<%=request.getContextPath()%>/sys/images/cal.gif" onClick="javascript:NewCssCal('strDte','ddMMyyyy')" style="cursor:pointer"/>
                  
                                        </td>
                                </tr>	 
								<!-- End Date -->
								 <tr>
                                        <td align="left"><fmt:message key="message.common.endDate.label"/></td>
                                        <td>:</td>
                                        <td align="left">
                                                <form:input path="endDte" cssClass="Date" maxlength="25" size="25"/>
                                                <form:errors path="endDte" cssClass="error"/>
                                                <img src="<%=request.getContextPath()%>/sys/images/cal.gif" onClick="javascript:NewCssCal('endDte','ddMMyyyy')" style="cursor:pointer"/>
                                        </td>
                                </tr>
							 <!-- Conuntry -->
								 <tr>
								 	<td align="left"><fmt:message key="message.common.country.label"/></td>
									<td>:</td>
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
                                        <td align="left"><fmt:message key="message.common.location.label"/></td>
                                        <td>:</td>
                                        <td align="left"><label for="textarea"></label>
                                                <form:textarea path="loc" cols="45" rows="4"></form:textarea>
                                                <form:errors path="loc" cssClass="error"/>
                                        </td>
                                </tr>	
								<!-- Remark -->
								<tr>
                                        <td align="left"><fmt:message key="message.common.remark.label"/></td>
                                        <td>:</td>
                                        <td align="left"><label for="textarea"></label>
                                                <form:textarea path="rmk" cols="45" rows="4"></form:textarea>
                                                <form:errors path="rmk" cssClass="error"/>
                                        </td>
                                </tr>
								
                                <tr>
                                        <td colspan="3" ><input type="submit" name="button" id="button" value="<fmt:message key="message.common.create.button"/>"></td>
                                </tr>
                        </table>
                </form:form>
        </div>
</body>