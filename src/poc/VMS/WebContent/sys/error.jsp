<%--
    Document   : errorPage
    Created on : Jan 16, 2008, 3:33:36 PM
    Author     : zaw
--%>

<%@ page isErrorPage="true" import="java.io.*"%>
<html>
<head>
<title>Error Even Occurred!</title>
<style>
body,p {
	font-family: Tahoma;
	font-size: 10pt;
	padding-left: 30;
}

pre {
	font-size: 8pt;
}
</style>
</head>
<body>

	<h3>Unknown Error</h3>
	<h4>
		Please contact the vendor.
		<v4> <font color="red"> <%
 	//out.println("<!--");
 	StringWriter sw = new StringWriter();
 	PrintWriter pw = new PrintWriter(sw);
 	exception.printStackTrace(pw);
 	out.print(sw);
 	sw.close();
 	pw.close();
 	//out.println("-->");
 %> </font>
</body>
</html>