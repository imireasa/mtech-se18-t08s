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

<form:form commandName="loginCommand" method="POST" name="login"></form:form>
<table width="296">
  <tr>
    <td>UserId/Email:</td>
    <td><input type="text" name="txtField_userName" id="txtField_userName"></td>
  </tr>
  <tr>
    <td>Pasword</td>
    <td><input type="text" name="txtField_password" id="txtField_password"></td>
  </tr>
  <tr>
    <td colspan="2" align="center"><input type="submit" name="btn_login" id="btn_login" value="Login"></td>
   
  </tr>
  <tr>
    <td colspan="2" align="center"><a href="registerVolunteerAccount.jsp">New User/Register</a></td>
   
  </tr>
  <tr>
    <td colspan="2" align="center"><a href="forgetPassword.jsp">Forget Password</a></td>
   
  </tr>
</table>
</center>

</body>

</html>