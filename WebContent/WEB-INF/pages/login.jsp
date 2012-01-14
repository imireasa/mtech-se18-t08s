<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

    <head>
  		 <link href="<%=request.getContextPath()%>/sys/css/login.css" rel="stylesheet" type="text/css" />
		      <!-- ICO -->
	<link rel="icon" href="<%=request.getContextPath()%>/sys/favicon.ico" type="image/x-icon" />
	<link rel="shortcut icon" href="<%=request.getContextPath()%>/sys/favicon.ico" type="image/x-icon" />
	
	<!-- CSS -->
	<link href="<%=request.getContextPath()%>/sys/css/reset.css" rel="stylesheet" type="text/css" />
	<link type="text/css" href="<%=request.getContextPath()%>/sys/css/paging.css" rel="stylesheet" />
	<link type="text/css" href="<%=request.getContextPath()%>/sys/css/jquery-ui-min.css" rel="stylesheet" />
	<link type="text/css" href="<%=request.getContextPath()%>/sys/css/validationEngine.jquery.css" rel="stylesheet" />
	
	<!-- JS -->
	<script type='text/javascript' src='<%=request.getContextPath()%>/sys/scripts/datetimepicker_css.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/VmsDwr.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>

	<!-- jQuery -->
    <script type='text/javascript' src='<%=request.getContextPath()%>/sys/scripts/jquery-1.6.min.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/sys/scripts/jquery-ui-1.8.16.custom.min.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/sys/scripts/jquery.validationEngine.js'></script>	
	<script type='text/javascript' src='<%=request.getContextPath()%>/sys/scripts/languages/jquery.validationEngine-en.js'></script>

		
		<!--[if lte IE 6]>
		<script type="text/javascript" src="js/supersleight.js"></script>
		  
    
		<![endif]-->
		   <script>
    $(document).ready(function(){
        $("#loginCommand").validationEngine();
       });
    </script>

        <title><fmt:message key="message.security.login.title" /></title>
    </head>

    <body>
        <div id="wrapper" align="center">
            <div id="loginheader">
                <img src="<%=request.getContextPath()%>/sys/images/v02/logo-hand.png" width="153" height="207" />
                <h1>Welcome to VMS</h1>
            </div><!-- end of loginheader-->
            <div id="login-wrapper">
                <form:form commandName="loginCommand" method="POST" name="login">
                    <p>
                        <form:errors path="*" cssClass="errorblock" element="div" />
                    </p>
                    <p>
                        <label><fmt:message key="message.security.userId.label"/> <span class="mandatory"><fmt:message key="message.common.symbol.mandatory.label"/></span> <fmt:message key="message.common.symbol.afterLabel.label"/></label>
                        <form:input path="username" maxlength="20"  cssClass="validate[required]"/><br />
                        <form:errors path="username" cssClass="error" />
                    </p>
                    <br class="clear" />
                    <p>
                        <label><fmt:message key="message.security.password.label"/> <span class="mandatory"><fmt:message key="message.common.symbol.mandatory.label"/></span> <fmt:message key="message.common.symbol.afterLabel.label"/></label>
                        <form:password path="password" maxlength="50" cssClass="validate[required]" /><br />
                        <form:errors path="password" cssClass="error" />
                        <br />
                    </p>
                    <br class="clear" />
                    <p>
                        <input id="requestedUrl" name="requestedUrl" type="hidden" value="${requestedUrl}"/>
                        <input type="submit" name="btn_login" id="btn_login" class="button2" value="<fmt:message key="message.security.login.button"/>"/>                        
                    </p>
                </form:form>
                <br class="clear" />
                <p>&nbsp;</p>
                <hr />
                <p><a href="<%=request.getContextPath()%>/public/registerVolunteer.html"><fmt:message key="message.security.newUserRegister.label"/></a></p>
                <p><a href="<%=request.getContextPath()%>/public/forgetPassword.html"><fmt:message key="message.security.forgetPassword.label"/></a></p>
            </div><!-- end of login-content -->
            <div id="footer">Copyright &copy; 2012 Volunteer Management System (VMS). All rights reserved.</div><!-- end of footer -->
        </div>
                <!-- end of wrapper -->
</body>

</html>