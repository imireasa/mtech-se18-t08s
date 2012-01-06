<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>

<head>
    <script type='text/javascript'
    src='<%=request.getContextPath()%>/dwr/interface/VmsDwr.js'></script>
    <script type='text/javascript'
    src='<%=request.getContextPath()%>/dwr/engine.js'></script>

    <link type="text/css"
          href="<%=request.getContextPath()%>/sys/css/paging.css"
          rel="stylesheet" />



</head>
<body>
    <h2><fmt:message key="message.projectManagement.projectInterest.label"/></h2>
    <div id="breadcrumb">
        <a href="#"><fmt:message key="message.common.home.label" /></a> / 
        <a href="listProjects.html"><fmt:message
                key="message.projectManagement.projectManagement.label" /></a> /
            <fmt:message key="message.projectManagement.projectInterest.label" /> 
    </div>
    <div class="query">
        <c:if test="${not empty msg}">
            <div class="infoblock">
                <c:out value="${msg}" escapeXml="false" />
                <br />
            </div>
        </c:if>
        <c:if test="${not empty errors}">
            <div class="errorblock">
                <c:out value="Error:" />
                <c:forEach var="error" items="${errors}">
                    <c:out value="${error}" escapeXml="false" />
                    <br />
                </c:forEach>
            </div>
        </c:if>
        <table width="550" class="query-table">
            <tr>
                <td width="153"><fmt:message key="message.projectManagement.projectName.label"/></td>
                <td width="385">${projectVo.name}</td>
            </tr>
            <tr>
                <td width="153"><fmt:message key="message.projectManagement.projectLocation.label"/></td>
                <td width="385">${projectVo.loc}(${projectVo.ctry})</td>
            </tr>
        </table>
    </div>
    <form:form method="GET">    
        <input type="hidden" id="prjId" name="prjId" value="${prjId}"/>
        <table border="1" class="proj-table">
            <tr>
                <th width="20">#</th>
                <th width="170"><label>Name</label></th>
                <th width="75"><label>Country</label></th>
                <th width="75"><label>Status</label></th>

            </tr>
            <c:forEach  items="${projectInterestPagedListHolder.pageList}" var="item">
                <tr>
                    <td><input type="checkbox" name="prjIntrstId" id="prjIntrstId" value="${item.prjIntrstId}"/></td>
                    <td>${item.reqByTitle}.${item.reqByNme}</td>
                    <td>${item.reqByCtry}</td>   
                    <td>${item.sts}</td>                                                         
                </tr>
            </c:forEach>
            <tr>
                <td colspan="4" align="right">
                    <input type="submit" name="acceptInterest" id="acceptInterest" value="<fmt:message key="message.common.accept.button"/>"/>
                    <input type="submit" name="rejectInterest" id="rejectInterest" value="<fmt:message key="message.common.reject.button"/>"/> 
                </td>
            </tr>
        </table>
    </form:form>




</body>