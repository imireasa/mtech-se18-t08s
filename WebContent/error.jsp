<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Huston, we have a Problem</title>
</head>
<body>
	<h2>Something is not right...
</h2>
<p>
check the following.. 
</p>

	<c:forEach var="attr" items="${pageContext.request.attributeNames}">                         
<table bgcolor="lightgreen">
    <tbody>
        <tr>
            <td>
                <c:out value="${attr}"> </c:out>
            </td>
        </tr>
    </tbody>
</table>
</c:forEach>
</body>
</html>