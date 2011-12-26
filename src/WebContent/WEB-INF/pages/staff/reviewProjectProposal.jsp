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
	<a href="#">Home</a> / <a href="#">Review Project proposal</a></div>
    
<h2> Review Project Proposal</h2>
    <form action="" method="post">
    </form>

	<div class="query">
   	 <form name="form1" method="post" action="">
	  <table width="475" height="105" border="1">
	    <tr>
	      <td width="160"><label>Project Proposal Name</label></td>
	      <td width="299"><label id="label_projectCode"></label></td>
        </tr>
	    
        <tr>
	      <td><label>Description</label></td>
	      <td>
	        <label for="txtArea_projectDesc"></label>
	        <textarea name="txtArea_projectDesc" id="txtArea_projectDesc" cols="45" rows="5"></textarea>
          </td>
        </tr>
        
        
         <tr>
	      <td><label>Country</label></td>
	      <td></td>
        </tr>
        <tr>
	      <td><label>Location</label></td>
	      <td></td>
        </tr>
        <tr>
	      <td><label>Estimated Duration</label></td>
	      <td></td>
        </tr>
	    <tr>
	      <td><label>Proposed by</label></td>
	      <td></td>
        </tr>
        <tr>
	      <td><label>Status</label></td>
	      <td></td>
        </tr>
        <tr>
	      <td><label>Supporting Documents</label></td>
	      <td></td>
        </tr>
         <tr>
	      <td><label>Remark</label></td>
	      <td><textarea name="txtArea_Remark" cols="45" rows="5"></textarea></td>
        </tr>
        <tr>
	      <td><input name="btn_update" type="button" value="Update"></td>
	      <td><input name="btn_cancel" type="button" value="Cancel"></td>
        </tr>
        
      </table>
   	 </form>
   	 
    </div>
    




	

</body>