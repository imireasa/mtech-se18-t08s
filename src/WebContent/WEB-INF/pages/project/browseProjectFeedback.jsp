<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>


<body>
    <h2><fmt:message key="message.projectManagement.reviewProjectFeedback.title" /></h2>
    <div id="breadcrumb">
        <a href="<%=request.getContextPath()%>/common/welcome.html"><fmt:message key="message.common.home.label" /></a> / <fmt:message key="message.projectManagement.reviewProjectFeeback.title" /></div>

    <div class="query">  
        <form:form name="browseProjectFeedback" method="post"  commandName="feedbackVo" 
                   action="searchProjectFeedback.html" >
            <table class="query-table" >
                <tr>
                    <td><fmt:message key="message.projectManagement.projectId.label" /></td>
		    <td><fmt:message key="message.common.symbol.afterLabel.label" /> </td>
                    <td>
                        <spring:bind path="feedbackVo.prjId">  
                            <form:input path="prjId"/>
                        </spring:bind>
                        <form:errors path="prjId" cssClass="error"/>  
                    </td>
                </tr>
                <tr>
                    <td><fmt:message key="message.projectManagement.feedbackTitle.label" /></td>
		    <td><fmt:message key="message.common.symbol.afterLabel.label" /> </td>
                    <td>
                        <spring:bind path="feedbackVo.title">
                            <form:input path="title"/>
                        </spring:bind>
                        <form:errors path="title" cssClass="error"/>  
                    </td>
                </tr>
                <tr>
                    <td><fmt:message key="message.projectManagement.projectName.label" /></td>
		    <td><fmt:message key="message.common.symbol.afterLabel.label" /> </td>
                    <td>
                        <spring:bind path="feedbackVo.prjNme">  
                            <form:input path="prjNme"/>
                        </spring:bind>
                        <form:errors path="prjNme" cssClass="error"/>  
                    </td>
                </tr>
                <tr>
                    <td><fmt:message key="message.common.status.label" /></td>
		    <td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                    <td>
                        <form:select path="stsVal">
                            <form:option value="" label="ALL"/>
                            <c:forEach items="${fbCodeList}" var="item" varStatus="status">
                                <form:option value="${item.val}">${item.val}</form:option>
                            </c:forEach>
                        </form:select>       
                    </td>
                </tr>

                <tr>
                    <td colspan="2"></td>
                    <td align="left">
                        <input type="submit" name="searchButton" id="searchButton" value="Search">
                    </td>
                </tr>

            </table>
        </form:form>
    </div>
    <!-- end of query -->
    <table class="proj-table">
        <tr>
            <td colspan="6" align="left">
                <fmt:message key="message.common.searchResults.title" /></td>
        </tr>
        <tr>
            <th><fmt:message key="message.projectManagement.feedbackCode.label" /></th>
            <th><fmt:message key="message.projectManagement.projectName.label" /></th>
            <th><fmt:message key="message.projectManagement.feedbackTitle.label" /></th>
            <th><fmt:message key="message.common.creator.label" /></th>
            <th><fmt:message key="message.common.status.label" /></th>
            <th><fmt:message key="message.common.actions.label" /></th>
        </tr>
        <c:forEach items="${pagedListHolder.pageList}" var="item">
            <tr>
                <td>${item.prjFbId}</td>
                <td>${item.prjNme}</td>
                <td>${item.title}</td>
                <td>${item.createdBy}</td>
                <td>
                    <c:forEach items="${fbCodeList}" var="item2" varStatus="status">
                        <c:set var="fbStsId">${item.stsCd}</c:set>
                        <c:set var="codeId">${item2.cdId}</c:set>

                        <c:if test="${fbStsId == codeId}">
                            <c:out value="${item2.val}"/>
                        </c:if>
                    </c:forEach>
                </td>
                <td><a href="
                       <c:url value="viewProjectFeedbackDetails.html">
                           <c:param name="prjFbId" value="${item.prjFbId}"/> 
                       </c:url>
                       "><fmt:message key="message.common.details.button" /></a></td>

            </tr>
        </c:forEach>
    </table>
    <div class="pagination">
        <jsp:useBean id="pagedListHolder" scope="request"
                     type="org.springframework.beans.support.PagedListHolder" />

        <%-- // create link for pages, "~" will be replaced later on with the proper page number --%>
        <c:url value="/project/browseProjectFeedback.html" var="pagedLink">
            <c:param name="p" value="~" />
        </c:url>

        <%-- // load our paging tag, pass pagedListHolder and the link --%>
        <tg:paging pagedListHolder="${pagedListHolder}"
                   pagedLink="${pagedLink}" />
    </div>
</body>