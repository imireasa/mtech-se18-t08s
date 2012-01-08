<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<body>
    <h2><fmt:message key="message.projectManagement.projectFeedbackDetails.title" /></h2>
    <div id="breadcrumb">
        <a href="#"><fmt:message key="message.common.home.label" /></a> / <a href="#"><fmt:message key="message.projectManagement.reviewProjectFeeback.title" /></a> / <fmt:message key="message.projectManagement.projectFeedbackDetails.title" />
    </div>

    <div class="query">
        <c:if test="${not empty fbMsg}"> 
            <div class="infoblock">
                <c:out value="${fbMsg}" escapeXml="false"/><br/>
            </div>
        </c:if>
        <table class="query-table">
            <tr>
                <td width="100"><fmt:message key="message.projectManagement.projectName.label"/></td>
                <td>
                    <fmt:message key="message.common.symbol.afterLabel.label" />
                </td>
                <td>${projectFbVo.prjNme}</td>
            </tr>
            <tr>
                <td><fmt:message key="message.common.title.label"/></td>
                <td>
                    <fmt:message key="message.common.symbol.afterLabel.label" />
                </td>
                <td>${projectFbVo.title}</td>
            </tr>
            <tr>
                <td><fmt:message key="message.common.content.label"/></td>
                <td>
                    <fmt:message key="message.common.symbol.afterLabel.label" />
                </td>
                <td>${projectFbVo.cont}</td>
            </tr>
            <tr>
                <td><fmt:message key="message.common.status.label"/></td>
                <td>
                    <fmt:message key="message.common.symbol.afterLabel.label" />
                </td>
                <td>${projectFbVo.stsVal}</td>
            </tr>
            <tr>
                <td><fmt:message key="message.common.creator.label"/></td>
                <td>
                    <fmt:message key="message.common.symbol.afterLabel.label" />
                </td>
                <td>${projectFbVo.createdBy}</td>
            </tr>
            <tr>
                <td><fmt:message key="message.common.creatdate.label"/></td>
                <td>
                    <fmt:message key="message.common.symbol.afterLabel.label" />
                </td>
                <td>${projectVo.createdDte}</td>

            </tr>
            <tr>
                <td>&nbsp;</td>
                <td align="left">
                    <form:form name="viewFbDetails" method="post"
                               action="approveFb.html">
                        <input type="submit" name="publishButton"
                               id="publishButton" value="Publish">
                    </form:form>
                </td>
                <td align="left">
                    <form:form name="viewFbDetails" method="post"
                               action="rejectFb.html">
                        <input type="submit" name="rejectButton"
                               id="rejectButton" value="Reject">
                    </form:form>
                </td>
           
            </tr>
        </table>
    </div>
</body>