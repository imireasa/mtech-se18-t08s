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
		<a href="#">Home</a> /  <a href="#">Project
	List</a> / <a href="#">Propose New  Project</a> 
	  
	</div>
    <h2> Propose NewProject</h2>
	<div class="query">
   	 <form name="form1" method="post" action="">
	  <table width="548" height="105" border="1">
	    
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
	      <td><label>Estimated Duration:</label></td>
	      <td><label for="select_ProposalCode">
	        <input type="text" name="txtLabel_estimatedDuration" id="txtLabel_estimatedDuration">
	      </label></td>
        </tr>
        <tr>
	      <td><label>Supporting Documents:</label></td>
	      <td><label for="txtArea_remark"></label></td>
        </tr>
        <tr>
	      <td><input name="btn_submit" type="submit" value="Submit"></td>
	      <td><input name="btn_back" type="submit" value="Cancel"></td>
        </tr>
      </table>
   	 </form>
   	 
    </div>
    


	

</body>