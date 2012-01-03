<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<body>
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
	
	<div id="breadcrumb">
		<a href="#">Home</a> / <a href="#">Manage Project</a> /  <a href="#">Project
	List</a> / <a href="#">View Project</a> 
	  
	</div>
    
<h2> View Project</h2>
    <form action="" method="post">
    </form>

	<div class="query">
   	 <form name="form1" method="post" action="">
	  <table width="475" height="105">
	    <tr>
	      <td width="134"><label><fmt:message key="message.projectManagement.projectId.label"/></label></td>
	      <td width="325"><label id="label_projectCode"></label></td>
        </tr>
	    <tr>
	      <td><label><fmt:message key="message.projectManagement.projectName.label"/></label></td>
	      <td><label id="label_projectName"></label></td>
        </tr>
        <tr>
	      <td><label><fmt:message key="message.projectManagement.projectDescription.label"/></label></td>
	      <td>
	        <label for="txtArea_projectDesc"></label>
	        <textarea name="txtArea_projectDesc" id="txtArea_projectDesc" cols="45" rows="5"></textarea>
          </td>
        </tr>
        <tr>
	      <td><label><fmt:message key="message.common.startDate.label"/></label></td>
	      <td> 12/26/2011</td>
        </tr>
         <tr>
	      <td><label><fmt:message key="message.common.endDate.label"/></label></td>
	      <td>12/26/2011</td>
        </tr>
         <tr>
	      <td><label><fmt:message key="message.common.country.label"/></label></td>
	      <td></td>
        </tr>
        <tr>
	      <td><label><fmt:message key="message.common.location.label"/></label></td>
	      <td></td>
        </tr>
        <tr>
	      <td><label><fmt:message key="message.common.createdBy.label"/></label></td>
	      <td></td>
        </tr>
	    <tr>
	      <td><label><fmt:message key="message.projectManagement.proposalId.label"/></label></td>
	      <td></td>
        </tr>
        <tr>
	      <td><label><fmt:message key="message.common.remark.label"/></label></td>
	      <td><label for="txtArea_remark"></label>
          <textarea name="txtArea_remark" id="txtArea_remark" cols="45" rows="5"></textarea></td>
        </tr>
      </table>
   	 </form>
   	 
    </div>
    
<div class= "members"> 
<table width="476">
  <tr>
    <td width="216"><fmt:message key="message.projectManagement.projectMember.label"/></td>
   
  </tr>
  <tr>
    <th><fmt:message key="message.common.name.label"/></th>
    <th width="244"><fmt:message key="message.common.role.label"/></th>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>

</div>



	

</body>