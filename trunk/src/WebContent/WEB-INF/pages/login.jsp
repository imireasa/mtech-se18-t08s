<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
<link href="<%=request.getContextPath()%>/sys/css/global.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/sys/css/reset.css" rel="stylesheet" type="text/css" />

<title><fmt:message key="message.security.login.title" /></title>
</head>

<body>

<center>

<h3><fmt:message key="message.security.pageHeader.label" /></h3>

<br />

<form:form commandName="loginCommand" method="POST" name="login">
<table width="296">
  <tr>
    <td colspan="2">
    <form:errors path="*" cssClass="errorblock" element="div" /></td>
  </tr>
  <tr>
    <td><fmt:message key="message.security.userId.label"/> <span class="mandatory"><fmt:message key="message.common.symbol.mandatory.label"/></span> <fmt:message key="message.common.symbol.afterLabel.label"/></td>
    <td>
    	<form:input path="username" maxlength="20" /><br />
    	<form:errors path="username" cssClass="error" />
	</td>
  </tr>
  <tr>
    <td><fmt:message key="message.security.password.label"/> <span class="mandatory"><fmt:message key="message.common.symbol.mandatory.label"/></span> <fmt:message key="message.common.symbol.afterLabel.label"/></td>
    <td>
    	<form:password path="password" maxlength="50" /><br />
		<form:errors path="password" cssClass="error" />
		<br />
    </td>
  </tr>
  <tr>
    <td colspan="2" align="center"><input type="submit" name="btn_login" id="btn_login" class="button" value="<fmt:message key="message.security.login.button"/>"></td><br/>
  </tr>
  <tr>
    <td colspan="2" align="center"><a href="<%=request.getContextPath()%>/public/registerVolunteer.html"><fmt:message key="message.security.newUserRegister.label"/></a></td>
  </tr>
  <tr>
    <td colspan="2" align="center"><a href="<%=request.getContextPath()%>/public/forgetPassword.html"><fmt:message key="message.security.forgetPassword.label"/></a></td>
   
  </tr>
</table>

<input id="requestedUrl" name="requestedUrl" type="hidden" value="${requestedUrl}"/>

</form:form>
</center>

</body>

</html>