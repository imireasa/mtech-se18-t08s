<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%><body>
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
		<a href="#">Home</a> / <a href="#">Mange Project</a> /  <a href="#">Project
	List</a> / <a href="#">View Project</a> 
	  
	</div>
    
<h2> View Project</h2>
    <form action="" method="post">
    </form>

	<div class="query">
   	 <form name="form1" method="post" action="">
	  <table width="475" height="105" >
	    <tr>
	      <td width="134"><label><fmt:message key="Message.ManageProject.ProjectCode.Label"/></label></td>
	      <td width="325"><label id="label_projectCode"></label></td>
        </tr>
	    <tr>
	      <td><label><fmt:message key="Message.ManageProject.ProjectName.Label"/></label></td>
	      <td><label id="label_projectName"></label></td>
        </tr>
        <tr>
	      <td><label><fmt:message key="Message.ManageProject.ProjectDescription.Label"/></label></td>
	      <td>
	        <label for="txtArea_projectDesc"></label>
	        <textarea name="txtArea_projectDesc" id="txtArea_projectDesc" cols="45" rows="5"></textarea>
          </td>
        </tr>
        <tr>
	      <td><label><fmt:message key="Message.ManageProject.ProjectStartDate.Label"/></label></td>
	      <td> 12/26/2011</td>
        </tr>
         <tr>
	      <td><label><fmt:message key="Message.ManageProject.ProjectEndDate.Label"/></label></td>
	      <td>12/26/2011</td>
        </tr>
         <tr>
	      <td><label><fmt:message key="Message.ManageProject.Country.Label"/></label></td>
	      <td></td>
        </tr>
        <tr>
	      <td><label><fmt:message key="Message.ManageProject.Location.Label"/></label></td>
	      <td></td>
        </tr>
        <tr>
	      <td><label><fmt:message key="Message.ManageProject.Createdby.Label"/></label></td>
	      <td></td>
        </tr>
	    <tr>
	      <td><label><fmt:message key="Message.ManageProject.ProposalCode.Label"/></label></td>
	      <td></td>
        </tr>
        <tr>
	      <td><label><fmt:message key="Message.ManageProject.Remark.Label"/></label></td>
	      <td><label for="txtArea_remark"></label>
          <textarea name="txtArea_remark" id="txtArea_remark" cols="45" rows="5"></textarea></td>
        </tr>
      </table>
   	 </form>
   	 
    </div>
    
<div class= "members"> 
<table width="476" border="1">
  <tr>
    <td width="216"><fmt:message key="Message.ManageProject.ProjectMember.Label"/></td>
   
  </tr>
  <tr>
    <th><fmt:message key="Message.ManageProject.MemberName.Label"/></th>
    <th width="244"><fmt:message key="Message.ManageProject.MemberRole.Label"/></th>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>

</div>



	

</body>