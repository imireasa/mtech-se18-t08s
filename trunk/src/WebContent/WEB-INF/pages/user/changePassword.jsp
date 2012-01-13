<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<head>
  <script>
    $(document).ready(function(){
        $("#command").validationEngine();
       });
    </script>
</head>
<body>
	<h2><fmt:message key="message.userManagement.changePassword.title" /></h2>
	<div id="breadcrumb">
		<a href="<%=request.getContextPath()%>/common/welcome.html"><fmt:message key="message.common.home.label" /></a> / <fmt:message key="message.userManagement.changePassword.title" />
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
				<c:forEach var="errorblock" items="${errors}">
					<c:out value="${error}" escapeXml="false" />
					<br />
				</c:forEach>
			</div>
		</c:if>
		
   	  <form:form name="changePassword" method="post" action="changePassword.html" commandName="command">
   	  	<form:errors path="*" cssClass="errorblock" element="div" />
	  <table class="query-table">
	  
	    <tr>
	      
             <td><fmt:message key="message.common.email.label" /></td>
			<td><fmt:message key="message.common.symbol.afterLabel.label" /> </td>
			<td> ${command.email}</td><form:hidden path="email"/>
        </tr>
        <tr>
              <td><fmt:message key="message.userManagement.oldPassword.label" /></td>
              <td><fmt:message key="message.common.symbol.afterLabel.label" /> </td>
	      <td><form:password path="currentPassword" cssClass="validate[required]"/><font color="red"><form:errors path="currentPassword" /></font></td>
	     
	     
        </tr>
        <tr>
	      <td><fmt:message key="message.userManagement.newPassword.label" /></td>
              <td><fmt:message key="message.common.symbol.afterLabel.label" /> </td>
	      <td><form:password path="password" cssClass="validate[required,equals[confirmedPassword]]"/><font color="red"><form:errors path="password" /></font></td>
	     
	     
        </tr>
        <tr>
	      <td><fmt:message key="message.userManagement.confirmNewPassword.label" /></td>
              <td><fmt:message key="message.common.symbol.afterLabel.label" /> </td>
	      <td><form:password path="confirmedPassword" cssClass="validate[required,equals[password]]"/><font color="red"><form:errors path="confirmedPassword" /></font></td>
	     
	     
        </tr>
            <tr>
				<td colspan="2">
					
				</td>
				<td align="left">
					<input type="submit" name="changeButton" id="changeButton" value="Update"> <input type="submit" name="clearButton" id="clearButton" value="Clear">
				</td>
           </tr>
	   
      </table>

	
   	  </form:form>
    </div>
	
	
</body>