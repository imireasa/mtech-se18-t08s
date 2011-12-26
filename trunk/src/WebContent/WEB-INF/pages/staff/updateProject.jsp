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
		<a href="#">Home</a> / <a href="#">Manage Project</a> /  <a href="#">Project
	List</a> / <a href="#">Update Project</a> 
	  
	</div>
    <h2> Update Project</h2>
	<div class="query">
   	 <form name="form1" method="post" action="">
	  <table width="548" height="105" border="1">
	    <tr>
	      <td width="103"><label>Project Code:</label></td>
	      <td width="167"></td>
        </tr>
	    <tr>
	      <td><label>Project Name:</label></td>
	      <td><label for="txtField_ProjectName"></label>
          <input type="text" name="txtField_ProjectName" id="txtField_ProjectName"></td>
        </tr>
        <tr>
	      <td><label>Description:</label></td>
	      <td>
	        <label for="txtArea_projectDesc"></label>
	        <textarea name="txtArea_projectDesc" id="txtArea_projectDesc" cols="45" rows="5"></textarea>
          </td>
        </tr>
        <tr>
	      <td><label>Start Date:</label></td>
	      <td> 12/26/2011</td>
        </tr>
         <tr>
	      <td><label>End Date:</label></td>
	      <td>12/26/2011</td>
        </tr>
         <tr>
	      <td><label>Country:</label></td>
	      <td><label for="txtField_country"></label>
           <input type="text" name="txtField_country" id="txtField_country"></td>
        </tr>
        <tr>
	      <td><label>Location:</label></td>
	      <td><label for="txtArea_location"></label>
          <textarea name="txtArea_location" id="txtArea_location" cols="45" rows="5"></textarea></td>
        </tr>
     
	    <tr>
	      <td><label>Proposal Code:</label></td>
	      <td><label for="select_ProposalCode"></label>
	        <select name="select_ProposalCode" id="select_ProposalCode">
          </select></td>
        </tr>
        <tr>
	      <td><label>Remark:</label></td>
	      <td><label for="txtArea_remark"></label>
          <textarea name="txtArea_remark" id="txtArea_remark" cols="45" rows="5"></textarea></td>
        </tr>
        <tr>
	      <td><input name="btn_Update" type="submit" value="Update"></td>
	      <td><input name="btn_back" type="submit" value="Back to Project List"></td>
        </tr>
      </table>
   	 </form>
   	 
    </div>
    


	

</body>