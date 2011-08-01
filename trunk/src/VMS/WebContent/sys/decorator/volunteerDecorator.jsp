<%--
    Document   : decorator
    Created on : Dec 13, 2009, 10:54:53 AM
    Author     : Zaw
--%>

<%
	String path = pageContext.getSession().getServletContext().getContextPath() + "/";
%>
<html>
<head>
<title><decorator:title default="VMCS Volunteer" />
</title>
<decorator:head />

</head>
<body>
	<decorator:body />
</body>
</html>

