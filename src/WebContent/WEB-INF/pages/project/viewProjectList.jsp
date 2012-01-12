<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<head>
        <script type="text/javascript">
                function projectInvitation(prjId,commandType){
                        
                        document.getElementById("prjId").value = prjId;
                        document.getElementById("cmdType").value = commandType;
                        alert('inviting' + prjId + ' ' + commandType );
                        document.listProjects.submit();
                }

                function projectSearch(){
                        document.getElementById("prjId").value = "";
                        document.getElementById("cmdType").value = "";
                        alert('searching');
                        document.listProjects.submit();
                }

                $(document).ready(function(){
                        $("#command").validationEngine();
                });


        </script>

</head>
<body>
        <h2><fmt:message key="message.projectManagement.projectManagement.label" /></h2>
        <div id="breadcrumb">
                <a href="<%=request.getContextPath()%>/common/welcome.html"><fmt:message key="message.common.home.label" /></a> / <fmt:message key="message.projectManagement.projectManagement.label" />
        </div>

        <div class="query">
                <form:form name="listProjects" method="get" commandName="command"
                           action="listProjects.html">
                        <form:hidden path="prjId"/><form:hidden path="cmdType"/>
                        <table  class="query-table">
                                <tr>
                                        <td><fmt:message key="message.projectManagement.projectName.label" /></td>
                                        <td><fmt:message key="message.common.symbol.afterLabel.label" /> </td>
                                        <td><form:input path="name"/></td>
                                </tr>
                                <tr>
                                        <td><fmt:message key="message.projectManagement.projectStartMonth.label" /></td>
                                        <td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                                        <td><form:input path="strDte" /> <img
                                                        src="<%=request.getContextPath()%>/sys/images/cal.gif"
                                                        onClick="javascript:NewCssCal('strDte','ddMMyyyy')"
                                                        style="cursor: pointer" /></td>
                                </tr>
                                <tr>
                                        <td><fmt:message key="message.projectManagement.projectStatus.label" /></td>
                                        <td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                                        <td><form:select path="stsCd">
                                                        <form:option value="">All</form:option>
                                                        <c:forEach items="${projectStatusList}" var="item"
                                                                   varStatus="status">
                                                                <form:option value="${item.cdId}">${item.val}</form:option>
                                                        </c:forEach>

                                                </form:select>
                                        </td>
                                </tr>
                                <tr>
                                        <td colspan="2"></td>
                                        <td><input type="button" name="searchButton" id="searchButton" onclick="projectSearch()"
                                                   value=<fmt:message key="message.common.search.button"/> >
                                        </td>
                                </tr>


                        </table>
                </form:form>
        </div>
        <!-- end of query -->
        <table class="proj-table">
                <tr>
                        <td colspan="8"><b><a href="createProject.html"><fmt:message key="message.projectManagement.createProject.label"/></a></b></td>
                </tr>
                <tr>
                        <th><fmt:message key="message.projectManagement.projectName.label" /></th>
                        <th><fmt:message key="message.common.description.label" /></th>
                        <th><fmt:message key="message.common.startDate.label" /></th>
                        <th><fmt:message key="message.common.status.label" /></th>
                        <th colspan="2"><fmt:message key="message.common.actions.label" /></th>
                </tr>
                <c:forEach items="${pagedListHolder.pageList}" var="item">
                        <tr>
                                <td>${item.name}</td>
                                <td>${item.desc}</td>
                                <td>${item.strDte}</td>
                                <td>${item.stsCd}</td>
                                <td>
                <!--                        manageProjectMember.html?prjId=${item.prjId}&nviteMemberButton=true-->
                                        <a href="manageProjectMember.html?prjId=${item.prjId}"><fmt:message key="message.projectManagement.manageMember.button" /></a><br/>
                                        <a href="#" onclick="projectInvitation(${item.prjId},'INVITE')"><fmt:message key="message.projectManagement.inviteMember.button"/></a><br/>
                                        <a href="manageProjectInterest.html?prjId=${item.prjId}"><fmt:message key="message.common.Interest.button" /></a>
                                </td>
                                <td>
                                        <a href="viewProject.html?prjId=${item.prjId}"><fmt:message key="message.common.view.button" /></a><br/>
                                        <a href="updateProject.html?prjId=${item.prjId}"><fmt:message key="message.common.update.button" /></a>
                                </td>
                        </tr>
                </c:forEach>
        </table>
        <div class="pagination">
                <jsp:useBean id="pagedListHolder" scope="request"
                             type="org.springframework.beans.support.PagedListHolder" />

                <%-- // create link for pages, "~" will be replaced later on with the proper page number --%>
                <c:url value="listProjects.html" var="pagedLink">
                        <c:param name="p" value="~" />
                        <c:param name="projectName" value="${projectName}" />
                </c:url>

                <%-- // load our paging tag, pass pagedListHolder and the link --%>
                <tg:paging pagedListHolder="${pagedListHolder}"
                           pagedLink="${pagedLink}" />
        </div>
</body>