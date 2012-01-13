<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<body>
     <h2><fmt:message key="message.security.forgetPassword.label"/></h2>
	 <div id="breadcrumb">
         <a href="<%=request.getContextPath()%>/"><fmt:message key="message.security.pageHeader.label"/></a> / 
		 <fmt:message key="message.security.forgetPassword.label"/>
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
       
        <form:form name="forgetPassword" method="post" commandName="command" action="forgetPassword.html">

            <table class="query-table">
                <tr>
                    <td colspan="3"> <form:errors path="*" cssClass="errorblock" element="div" /></td>
                </tr>
                <tr>
                    <td><fmt:message key="message.security.userId.label"/> <span class="mandatory"><fmt:message key="message.common.symbol.mandatory.label"/></span></td>
                    <td> <fmt:message key="message.common.symbol.afterLabel.label"/></td>
                    <td>
                        <form:input path="userLoginId" maxlength="20" /><br />
                        <form:errors path="userLoginId" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2"></td>
                    <td><input type="submit" name="sendPwdButton" id="sendPwdButton" value="<fmt:message key="message.security.forgetPassword.button"/>"></td>
                </tr>
            </table>

            <input id="requestedUrl" name="requestedUrl" type="hidden" value="${requestedUrl}"/>
        </form:form>
	</div>

</body>
