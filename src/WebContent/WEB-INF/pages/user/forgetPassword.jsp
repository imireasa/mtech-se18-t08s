<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

    <head>
        <link href="<%=request.getContextPath()%>/sys/css/global.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/sys/css/reset.css" rel="stylesheet" type="text/css" />

        <title><fmt:message key="message.security.forgetPassword.label" /></title>
    </head>

    <body>

    <center>

        <h3><fmt:message key="message.security.forgetPassword.label"/></h3>

        <br />
        <div>
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
        </div>
        <form:form name="forgetPassword" method="post" commandName="command" action="forgetPassword.html">

            <table width="296">
                <tr>
                    <td colspan="2">
                        <form:errors path="*" cssClass="errorblock" element="div" /></td>
                </tr>
                <tr>
                    <td><fmt:message key="message.security.userId.label"/> <span class="mandatory"><fmt:message key="message.common.symbol.mandatory.label"/></span> <fmt:message key="message.common.symbol.afterLabel.label"/></td>
                    <td>
                        <form:input path="userLoginId" maxlength="20" /><br />
                        <form:errors path="userLoginId" cssClass="error" />
                    </td>
                </tr>

                <tr>
                    <td colspan="2" align="center"><input type="submit" name="btn_send_pwd" id="btn_send_pwd" class="button" value="<fmt:message key="message.security.forgetPassword.button"/>"></td><br/>
                </tr>

            </table>

            <input id="requestedUrl" name="requestedUrl" type="hidden" value="${requestedUrl}"/>

        </form:form>
    </center>

</body>

</html>