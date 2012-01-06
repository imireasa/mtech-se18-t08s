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
        <h2><fmt:message key="message.projectManagement.manageMember.label"/></h2>
        <div id="breadcrumb">
                <a href="#"><fmt:message key="message.common.home.label"/></a> / 

                <a href="#"><fmt:message key="message.projectManagement.projectManagement.label"/></a> /   
                <fmt:message key="message.projectManagement.listProject.label"/>/ 
                <a href="#"><fmt:message key="message.projectManagement.manageMember.label"/></a>
        </div>
        <div class="query">
                <table width="550" >
                        <tr>
                                <td width="153"><label><fmt:message key="message.projectManagement.projectName.label"/>:</label></td>
                                <td width="385"><label>${projectVo.name}</label></td>
                        </tr>
                        <tr>
                                <td width="153"><label><fmt:message key="message.projectManagement.projectLocation.label"/>:</label></td>
                                <td width="385"><label>${projectVo.loc}(${projectVo.ctry})</label></td>
                        </tr>
                </table>
        </div>
        <form:form method="GET">    
                <input type="text" id="prjId" name="prjId" value="${prjId}"/>
                <table border="1" class="proj-table">
                        <tr>
                                <td colspan="3">Review Project Interest</td>
                        </tr>
                        <tr>
                                <td width="20"><label>#</label></td>
                                <td width="170"><label>Name</label></td>
                                <td width="75"><label>Country</label></td>
                                <td width="75"><label>Status</label></td>

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
                                <td colspan="3" align="right">
                                        <input type="submit" name="acceptInterest" id="acceptInterest" value="<fmt:message key="message.common.accept.button"/>"/>
                                        <input type="submit" name="rejectInterest" id="rejectInterest" value="<fmt:message key="message.common.reject.button"/>"/> 
                                </td>
                        </tr>
                </table>
        </form:form>




</body>