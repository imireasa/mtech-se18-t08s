<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>

<body>
    <h2><fmt:message key="message.projectManagement.browseProjects.title" /></h2>
    <div id="breadcrumb">
        <a href="<%=request.getContextPath()%>/common/welcome.html"><fmt:message key="message.common.home.label"/></a> / <fmt:message key="message.projectManagement.browseProjects.title" />
    </div>

    <div class="query">
        <form:form name="browseProject" method="post"  commandName="command" 
                   action="searchProjects.html" >
            <table class="query-table" >
                <tr>
                    <td><fmt:message key="message.projectManagement.projectName.label"/></td>
					<td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                    <td>
                        <spring:bind path="command.name">  
                            <form:input path="name"/>
                        </spring:bind>
                        <form:errors path="name" cssClass="error"/>  
                    </td>
                </tr>
				<tr>
				   </td>
                    <td><fmt:message key="message.common.startDate.label"/></td>
					<td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                    <td>
                        <spring:bind path="command.strDte">
                            <form:input path="strDte"/><img src="<%=request.getContextPath()%>/sys/images/cal.gif" onClick="javascript:NewCssCal('strDte','ddMMyyyy')" style="cursor:pointer"/>
                        </spring:bind>
                        <form:errors path="strDte" cssClass="error"/>  
                    </td>
				</tr>
                <tr>
                    <td><fmt:message key="message.common.status.label"/></td>
					<td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                    <td>
                        <form:select path="stsCd">
                            <form:option value="" label="ALL"/>
                            <c:forEach items="${projectCodeList}" var="item" varStatus="status">
                                <form:option value="${item.cdId}">${item.val}</form:option>
                            </c:forEach>
                        </form:select>       
                    </td>
                </tr>
				<tr>
					<td colspan="2"></td>
					<td> <input type="submit" name="searchButton" id="searchButton" value="<fmt:message key="message.common.search.button" />"></td>
				</tr>
            </table>
        </form:form>
    </div>
    <!-- end of query -->
    <table class="proj-table">

        <tr>
            <th width="150"><fmt:message key="message.projectManagement.projectName.label"/></th>
            <th width="200"><fmt:message key="message.common.description.label"/></th>
            <th width="100"><fmt:message key="message.common.startDate.label"/></th>
            <th width="80"><fmt:message key="message.common.actions.label" /></th>

        </tr>
        <c:forEach items="${pagedListHolder.pageList}" var="item" varStatus="status">
            <tr>
                <td>${item.nme}</td>
                <td>${item.desc}</td>
                <td>${item.strDte}</td>
                <td>
                    <a href="
                       <c:url value="viewProjectDetails.html">
                           <c:param name="prjId" value="${item.prjId}"/> 
                       </c:url>
                       "><fmt:message key="message.common.details.button" />
                    </a>

                </td>
            </tr>
        </c:forEach>
    </table>
    <div class="pagination">
        <jsp:useBean id="pagedListHolder" scope="request"
                     type="org.springframework.beans.support.PagedListHolder" />

        <%-- // create link for pages, "~" will be replaced later on with the proper page number --%>
        <c:url value="/volunteer/browseProject.html" var="pagedLink">
            <c:param name="p" value="~" />
        </c:url>

        <%-- // load our paging tag, pass pagedListHolder and the link --%>
        <tg:paging pagedListHolder="${pagedListHolder}"
                   pagedLink="${pagedLink}" />
    </div>
</body>