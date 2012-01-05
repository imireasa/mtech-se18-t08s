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
                <fmt:message key="message.projectManagement.manageMember.label"/>
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
                
                <table name="projectMemberList" border="1" class="proj-table">

                        <tr>
                                <td colspan="4"><fmt:message key="message.projectManagement.projectMember.label"/></td>
                        </tr>
                        <tr>
                                <td width="20"><label>#</label></td>
                                <td width="170" ><label>Name</label></td>
                                <td width="75" ><label>Country</label></td>
                                <td width="100" ><label>Role</label></td>
                        </tr>
                        <c:forEach  items="${memberPagedListHolder.pageList}" var="item">
                                <tr>
                                        <td><input type="checkbox" name="prjMbrId" id="prjMbrId" value="${item.prjMbrId},${item.version}"/></td>
                                        <td>${item.title}.${item.nme}</td>
                                        <td>${item.ctry}</td>
                                        <td>
                                                <select name="roleCd_${item.prjMbrId}" id="roleCd_${item.prjMbrId}">
                                                        <c:forEach items="${roleList}" var="roleitem" varStatus="status">
                                                                <c:choose>
                                                                        <c:when test="${roleitem.cdId==item.roleCd}">
                                                                                <option value="${roleitem.cdId}" selected="true">${roleitem.val}</option>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                                <option value="${roleitem.cdId}">${roleitem.val}</option>
                                                                        </c:otherwise>
                                                                </c:choose>
                                                        </c:forEach>
                                                </select>
                                        </td>
                                </tr>
                        </c:forEach>
                        <tr>
                                <td colspan="4" align="right">
                                        <input type="submit" name="removeMember" id="removeMember" value="<fmt:message key="message.common.remove.button"/>"/>
                                        <input type="submit" name="updateMember" id="updateMember" value="<fmt:message key="message.common.update.button"/>"/>                                </td>
                        </tr>

                </table>


                <table border="1" class="proj-table">
                        <tr>
                                <td colspan="3">Review Project Interest</td>
                        </tr>
                        <tr>
                                <td width="20"><label>#</label></td>
                                <td width="170"><label>Name</label></td>
                                <td width="75"><label>Country</label></td>

                        </tr>
                        <c:forEach  items="${projectInterestPagedListHolder.pageList}" var="item">
                                <tr>
                                        <td><input type="checkbox" name="chk_delete" id="chk_delete"/></td>
                                        <td>${item.reqByTitle}.${item.reqByNme}</td>
                                        <td>${item.reqByCtry}</td>                                                        
                                </tr>
                        </c:forEach>
                        <tr>
                                <td colspan="3" align="right">
                                        <input type="submit" name="button3" id="button3" value="Accept"/>
                                        <input type="submit" name="button4" id="button4" value="Reject"/>                        </td>
                        </tr>
                </table>
        </form:form>




</body>