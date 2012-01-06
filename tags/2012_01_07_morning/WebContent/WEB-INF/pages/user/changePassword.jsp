<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>

<head>
<script type='text/javascript'
	src='<%=request.getContextPath()%>/dwr/interface/VmsDwr.js'></script>
<script type='text/javascript'
	src='<%=request.getContextPath()%>/dwr/engine.js'></script>

<link type="text/css"
	href="<%=request.getContextPath()%>/sys/css/paging.css"
	rel="stylesheet" />

</head>
<body>
	<h2>Change Password</h2>
	<div id="breadcrumb">
		<a href="#">Home</a> / Change Password 
	</div>

	<div class="query">

   	  <form:form name="changePassword" method="post" action="changePassword.html" commandName="command">
   	  	<form:errors path="*" cssClass="errorblock" element="div" />
	  <table width="1013" height="105" class="query-table">
	  
	    <tr>
	      <td width="209"> Email:</td>
	      <td width="788"> <form:label path="email">${command.email}</form:label> <form:hidden path="email"/> </td>
        </tr>
        <tr>
	      <td width="209">Old Password:</td>
	      <td width="788"><form:password path="currentPassword"/><font color="red"><form:errors path="currentPassword" /></font></td>
	     
	     
        </tr>
        <tr>
	      <td width="209"> New Password:</td>
	      <td width="788"><form:password path="password"/><font color="red"><form:errors path="password" /></font></td>
	     
	     
        </tr>
        <tr>
	      <td width="209"> Confirm New Password:</td>
	      <td width="788"><form:password path="confirmedPassword"/><font color="red"><form:errors path="confirmedPassword" /></font></td>
	     
	     
        </tr>
            <tr>
				<td>    
					
				</td>
				<td>    
					<input type="submit" name="btn_change" id="btn_change" value="Update"> <input type="submit" name="btn_clear" id="btn_clear" value="Clear">
				</td>
           </tr>
	   
      </table>

	
   	  </form:form>
    </div>
	
	
</body>