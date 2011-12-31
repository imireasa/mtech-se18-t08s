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
        <h2><fmt:message key="message.projectManagement.viewProject.label"/></h2>
        <div id="breadcrumb">
                <a href="#"><fmt:message key="message.common.home.label"/></a>
                / <a href="#"><fmt:message key="message.projectManagement.projectManagement.label"/></a> / 
                <fmt:message key="message.projectManagement.viewProject.label"/>
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

                <form:form name="viewProject" method="get"
                           commandName="command" 
                           action="viewProject.html">
                        <table width="400" class="proj-table">
							
								<!-- Project Id (Disabled) -->
								<tr>
                                        <th align="left"><fmt:message key="message.projectManagement.projectId.label"/></th>
                                        <th>:</th>
                                        <th align="left">
                                                <form:input path="prjIdDisplayed" disabled="true"/>
                                                <form:errors path="prjIdDisplayed" cssClass="error"/>
                                        </th>
                                </tr>	
																	
								<!-- Project Name -->
								  <tr>
                                        <th align="left"><fmt:message key="message.projectManagement.projectName.label"/></th>
                                        <th>:</th>
                                        <th align="left"><label for="textarea"></label>
                                                <form:textarea path="name" cols="45" rows="2" disabled="true"></form:textarea>
                                                <form:errors path="name" cssClass="error"/>
                                        </th>
                                </tr>		
								 <!-- Description -->
								<tr>
                                        <th align="left"><fmt:message key="message.projectManagement.projectDescription.label"/></th>
                                        <th>:</th>
                                        <th align="left"><label for="textarea"></label>
                                                <form:textarea path="desc" cols="45" rows="4" disabled="true"></form:textarea>
                                                <form:errors path="desc" cssClass="error"/>
                                        </th>
                                </tr>	
								 <!-- Start Date -->
								<tr>
                                        <th align="left"><fmt:message key="message.common.startDate.label"/></th>
                                        <th>:</th>
                                        <th align="left">
                                                <form:input path="strDte" disabled="true"/>
                                                <form:errors path="strDte" cssClass="error"/>
                                        </th>
                                </tr>	 
								<!-- End Date -->
								 <tr>
                                        <th align="left"><fmt:message key="message.common.endDate.label"/></th>
                                        <th>:</th>
                                        <th align="left">
                                                <form:input path="endDte" disabled="true"/>
                                                <form:errors path="endDte" cssClass="error"/>
                                        </th>
                                </tr>
								 <!-- Conuntry -->
								<tr>
										<th align="left"><fmt:message key="message.common.country.label"/></th>
										<th>:</th>
										<th align="left">
                                                <form:input path="ctryCd" disabled="true"/>
                                                <form:errors path="ctryCd" cssClass="error"/>
                                        </th>
                                </tr>		
								<!-- Location -->
								<tr>
                                        <th align="left"><fmt:message key="message.common.location.label"/></th>
                                        <th>:</th>
                                        <th align="left"><label for="textarea"></label>
                                                <form:textarea path="loc" cols="45" rows="4"></form:textarea>
                                                <form:errors path="loc" cssClass="error"/>
                                        </th>
                                </tr>	
								 <!-- Project Status -->
								<tr>
										<th align="left"><fmt:message key="message.projectManagement.projectStatus.label"/></th>
										<th>:</th>
										<th align="left">
                                                <form:input path="stsCd" disabled="true"/>
                                                <form:errors path="stsCd" cssClass="error"/>
                                        </th>
                                </tr>	
								<!-- Remark -->
								<tr>
                                        <th align="left"><fmt:message key="message.common.remark.label"/></th>
                                        <th>:</th>
                                        <th align="left"><label for="textarea"></label>
                                                <form:textarea path="rmk" cols="45" rows="4"></form:textarea>
                                                <form:errors path="rmk" cssClass="error"/>
                                        </th>
                                </tr>
								
                                
								
                        </table>
                </form:form>
        </div>
</body>