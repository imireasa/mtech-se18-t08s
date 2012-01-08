<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>

<body>
<head>

    <link type="text/css"
          href="<%=request.getContextPath()%>/sys/css/paging.css"
          rel="stylesheet" />

</head>
<body>
    <h2>Browse Project Proposal</h2>
    <div id="breadcrumb">
        <a href="#">Home</a> / Browse Project Proposal</div>

    <div class="query">  
        <form:form name="browseProjectProposal" method="post"  commandName="proposalVo" 
                   action="searchProjectProposal.html" >
            <table width="707" height="105" class="query-table">
                <tr>

                    <td width="157">Proposal Name:</td>
                    <td width="203">
                        <spring:bind path="proposalVo.name">
                            <form:input path="name"/>
                        </spring:bind>
                        <form:errors path="name" cssClass="error"/>  
                    </td>
                </tr>
                <tr>

                    <td>Status:</td>
                    <td>
                        <form:select path="status">
                            <form:option value="" label="ALL"/>
                            <c:forEach items="${stsCdList}" var="item" varStatus="status">
                                <form:option value="${item.val}">${item.val}</form:option>
                            </c:forEach>
                        </form:select>       
                    </td>
                </tr>

                <tr>
				<td></td>
                    <td  align="left">    
                        <input type="submit" name="btn_Search" id="btn_Search" value="Search">
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
                    <c:forEach items="${stsCdList}" var="item2" varStatus="status">
                        <c:set var="fbStsId">${item.stsCd}</c:set>
                        <c:set var="codeId">${item2.cdId}</c:set>

                        <c:if test="${fbStsId == codeId}">
                            <c:out value="${item2.val}"/>
                        </c:if>
                    </c:forEach>
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