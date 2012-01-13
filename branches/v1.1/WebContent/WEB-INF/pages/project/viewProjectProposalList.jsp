<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>

<body>
    <h2><fmt:message key="message.projectManagement.browseProjectProposal.label" /></h2>
    <div id="breadcrumb">
        <a href="<%=request.getContextPath()%>/common/welcome.html"><fmt:message key="message.common.home.label"/></a> / 
        <fmt:message key="message.projectManagement.browseProjectProposal.label" /></div>

    <div class="query">  
        <form:form name="browseProjectProposal" method="post"  commandName="proposalVo" 
                   action="searchProjectProposal.html" >
            <table class="query-table">
                <tr>

                    <td><fmt:message key="message.projectManagement.proposalName.label" /></td>
					<td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                    <td>
                        <spring:bind path="proposalVo.nme">
                            <form:input path="nme"/>
                        </spring:bind>
                        <form:errors path="nme" cssClass="error"/>  
                    </td>
                </tr>
                <tr>

                    <td><fmt:message key="message.common.status.label" /></td>
					<td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                    <td>
                        <form:select path="stsVal">
                            <form:option value="" label="ALL"/>
                            <c:forEach items="${stsCdList}" var="item" varStatus="status">
                                <form:option value="${item.val}">${item.val}</form:option>
                            </c:forEach>
                        </form:select>       
                    </td>
                </tr>

                <tr>
					<td colspan="2"></td>
                    <td>    
                        <input type="submit" name="searchButton" id="searchButton" value="<fmt:message key="message.common.search.button" />">
                    </td>
                </tr>

            </table>


        </form:form>
    </div>
    <!-- end of query -->
    <table class="proj-table">
        <tr>
            <td colspan="5" align="left">
                Search Results</td>
        </tr>
        <tr>
            <th> Proposal ID</th>
            <th>Proposal Name</th>
            <th>Created by</th>
            <th>Status</th>
            <th>Actions</th>

        </tr>
        <c:forEach items="${pagedListHolder.pageList}" var="item">
            <tr>
                <td>${item.prjPropId}</td>

                <td>${item.nme}</td>
                <td>${item.createdBy}</td>


                <td>
                   ${item.stsVal}
                </td>
                <td><a href="<c:url value="viewProjectProposalDetails.html">
                           <c:param name="prjPropId" value="${item.prjPropId}"/> 
                       </c:url>
                       ">Details</a></td>
                <!-- <td><input type="submit" name="btn_publish" id="btn_publish" value="Publish"></td>-->

            </tr>
        </c:forEach>
    </table>
    <div class="pagination">
        <jsp:useBean id="pagedListHolder" scope="request"
                     type="org.springframework.beans.support.PagedListHolder" />

        <%-- // create link for pages, "~" will be replaced later on with the proper page number --%>
        <c:url value="/project/browseProjectProposal.html" var="pagedLink">
            <c:param name="p" value="~" />
        </c:url>

        <%-- // load our paging tag, pass pagedListHolder and the link --%>
        <tg:paging pagedListHolder="${pagedListHolder}"
                   pagedLink="${pagedLink}" />
    </div>
</body>