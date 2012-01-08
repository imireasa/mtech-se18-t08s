<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>

<body>
        <h2><fmt:message key="message.projectManagement.viewProject.label"/></h2>
        <div id="breadcrumb">
                <a href="#"><fmt:message key="message.common.home.label"/></a>/
               	<a href="listProjects.html"><fmt:message key="message.projectManagement.projectManagement.label"/></a> / 
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
                        <table class="query-table">
							
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
                                        <td align="left"><fmt:message key="message.projectManagement.projectName.label"/></td>
                                        <td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                                        <td align="left"><label for="textarea"></label>
                                                <form:textarea path="name" cols="45" rows="2" disabled="true"></form:textarea>
                                                <form:errors path="name" cssClass="error"/>
                                        </td>
                                </tr>		
								 <!-- Description -->
								<tr>
                                        <td align="left"><fmt:message key="message.projectManagement.projectDescription.label"/></td>
                                        <td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                                        <td align="left"><label for="textarea"></label>
                                                <form:textarea path="desc" cols="45" rows="4" disabled="true"></form:textarea>
                                                <form:errors path="desc" cssClass="error"/>
                                        </td>
                                </tr>	
								 <!-- Start Date -->
								<tr>
                                        <td align="left"><fmt:message key="message.common.startDate.label"/></td>
                                        <td><fmt:message key="message.common.symbol.afterLabel.label" /></td>										
                                        <td align="left">
                                                <form:input path="strDte" disabled="true"/>
                                                <form:errors path="strDte" cssClass="error"/>
                                        </td>	
                                </tr>	 
								<!-- End Date -->
								 <tr>
                                        <td align="left"><fmt:message key="message.common.endDate.label"/></td>
                                        <td><fmt:message key="message.common.symbol.afterLabel.label" /></td>										
                                        <td align="left">
                                                <form:input path="endDte" disabled="true"/>
                                                <form:errors path="endDte" cssClass="error"/>
                                        </td>
                                </tr>
								 <!-- Conuntry -->
								<tr>
										<td align="left"><fmt:message key="message.common.country.label"/></td>
										<td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
										<td align="left">
                                                <form:input path="ctryCd" disabled="true"/>
                                                <form:errors path="ctryCd" cssClass="error"/>
                                        </td>
                                </tr>		
								<!-- Location -->
								<tr>
                                        <td align="left"><fmt:message key="message.common.location.label"/></td>
                                        <td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                                        <td align="left"><label for="textarea"></label>
                                                <form:textarea path="loc" cols="45" rows="4" disabled="true"></form:textarea>
                                                <form:errors path="loc" cssClass="error"/>
                                        </td>
                                </tr>	
								 <!-- Project Status -->
								<tr>
										<td align="left"><fmt:message key="message.projectManagement.projectStatus.label"/></td>
										<td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
										<td align="left">
                                                <form:input path="stsCd" disabled="true"/>
                                                <form:errors path="stsCd" cssClass="error"/>
                                        </td>
                                </tr>	
								<!-- Remark -->
								<tr>
                                        <td align="left"><fmt:message key="message.common.remark.label"/></td>
                                        <td>:</td>
                                        <td align="left"><label for="textarea"></label>
                                                <form:textarea path="rmk" cols="45" rows="4" disabled="true"></form:textarea>
                                                <form:errors path="rmk" cssClass="error"/>
                                        </td>
                                </tr>
				 </table>
				
 
                </form:form>
        </div>
          <table name="projectMemberList" border="1" class="proj-table">

                        <tr>
                                <td colspan="4"><fmt:message key="message.projectManagement.projectMember.label"/></td>
                        </tr>
                        <tr>
                                <th width="200" ><label>Name</label></th>
                                <th width="150" ><label>Country</label></th>
                                <th width="150" ><label>Role</label></th>
                        </tr>
                         <c:forEach items="${pagedListHolder.pageList}" var="item">
                        <tr>
                                <td>${item.nme}</td>
                                <td>${item.ctry}</td>
                                <td>${item.role}</td>
                               
                        </tr>
                </c:forEach>
        </table>
        <div class="pagination">
                <jsp:useBean id="pagedListHolder" scope="request"
                             type="org.springframework.beans.support.PagedListHolder" />

                <%-- // load our paging tag, pass pagedListHolder and the link --%>
                <tg:paging pagedListHolder="${pagedListHolder}"
                           pagedLink="${pagedLink}" />
        </div>
</body>