<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>

<link href="<%=request.getContextPath()%>/sys/css/global.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/sys/css/reset.css"
	rel="stylesheet" type="text/css" />
<title>Welcome to Volunteer Management System, Please Login</title>
</head>

<body>

<center>

<h3>Login Page</h3>

<br />

<form:form commandName="loginCommand" method="POST" name="login">

Username:<form:input path="username" />
	<font color="red"><form:errors path="username" /></font>
	<br />

Password:<form:password path="password" />
	<font color="red"><form:errors path="password" /></font>
	<br />

	<input type="submit" value="Login" />

</form:form></center>

</body>

</html>