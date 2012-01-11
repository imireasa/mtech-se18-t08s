<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>

<body>
	<h2><fmt:message key="message.projectManagement.myProjectInterest.title" /></h2>
        <div id="breadcrumb">
                <a href="<%=request.getContextPath()%>/common/welcome.html"><fmt:message key="message.common.home.label" /></a> / 
				<fmt:message key="message.projectManagement.myProjectInterest.title" />
        </div>
        <div class="query">
                <form:form name="viewProjectInterest" method="get"
                           commandName="command" action="viewProjectInterest.html">

                        <table class="query-table">
                        		 <tr>
									<td><fmt:message key="message.projectManagement.projectId.label" /></td>
									<td><fmt:message key="message.common.symbol.afterLabel.label" /> </td>
									<td><form:input path="prjId"/></td>
                                </tr>
								<tr>
									<td><fmt:message key="message.projectManagement.projectName.label" /></td>
									<td><fmt:message key="message.common.symbol.afterLabel.label" /> </td>
									<td><form:input path="prjName"/></td>
								</tr>
								<tr>
									<td><fmt:message key="message.common.status.label" /></td>
									<td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
									<td>
										<form:select path="stsVal">
										<form:option value="">All</form:option>
										<c:forEach items="${projInterestStatusList}" var="item" varStatus="status">
											<form:option value="${item.val}">${item.val}</form:option>
										</c:forEach>
										</form:select>
									</td>
								</tr>
                                <tr>
									<td colspan="2"></td>
                                    <td><input type="submit" name="searchButton" id="searchButton" value="<fmt:message key="message.common.search.button" />"></td>
                                </tr>
                        </table>
                </form:form>
        </div>
        <!-- end of query -->
        <table class="proj-table">
                <tr>
                        <td colspan="6"><b><fmt:message key="message.projectManagement.projectInterestList.label" /></b></td>
                </tr>
                <tr>
					<th><fmt:message key="message.projectManagement.projectId.label" /></th>
                    <th><fmt:message key="message.projectManagement.projectName.label" /></th>
                    <th><fmt:message key="message.common.startDate.label" /></th>
                    <th><fmt:message key="message.administration.requestDate.label" /></th>
                    <th><fmt:message key="message.projectManagement.approvedDate.label" /></th>
                    <th><fmt:message key="message.common.status.label" /></th>
                </tr>
					<c:forEach items="${pagedListHolder.pageList}" var="item">
                        <tr>
                            <td>${item.prjId}</td>
                            <td>${item.prjName}</td>
                            <td><fmt:formatDate pattern="dd-MM-yyyy" value="${item.prjStartDate}" /></td>
                            <td><fmt:formatDate pattern="dd-MM-yyyy" value="${item.createdDate}" /></td>
                            <td><fmt:formatDate pattern="dd-MM-yyyy" value="${item.apprDte}" /></td>
                            <td>${item.stsVal}</td>
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