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
	<a href="#">Home</a> / <a href="#">My Profile</a></div>
    <h2> My Profile</h2>
	<div class="query">
   	 <form action="" method="post" enctype="multipart/form-data" name="form1">
	  	  <table width="548" height="105" border="1">
          
           <tr>
	      <td><label>userID:</label></td>
	      <td></td>
        </tr>
	    <tr>
	      <td width="103"><label>Salutation:</label></td>
	      <td width="167"><select name="select_Title" id="select_Title">
	        <option>Mr</option>
	        <option>Ms</option>
	        <option>Miss</option>
	        <option>Mrs</option>
          </select></td>
        </tr>
	    <tr>
	      <td><label>Name:</label></td>
	      <td><label for="txtField_ProjectName"></label>
          <input type="text" name="txtField_ProjectName" id="txtField_ProjectName"></td>
        </tr>
        <tr>
	      <td><label>Email:</label></td>
	      <td>
	        <label for="txtArea_projectDesc">
	          <input type="text" name="txtField_email" id="txtField_email">
	        </label></td>
        </tr>
       
         <tr>
	      <td><label>Postal Code:</label></td>
	      <td><label for="txtField_country"></label>
           <input type="text" name="txtField_postalcode" id="txtField_postalcode"></td>
        </tr>
        <tr>
	      <td><label>Address:</label></td>
	      <td><label for="txtArea_location"></label>
          <textarea name="txtArea_location" id="txtArea_location" cols="45" rows="5"></textarea></td>
        </tr>
     
	    <tr>
	      <td><label>Country:</label></td>
	      <td><input type="text" name="txtField_country" id="txtField_country"></td>
        </tr>
        <tr>
	      <td><label>Mobile:</label></td>
	      <td><input type="text" name="txtField_mobile" id="txtField_mobile"></td>
        </tr>
        <tr>
	      <td><label>Date of Birth:</label></td>
	      <td></td>
        </tr>
        <tr>
	      <td><label>Interest:</label></td>
	      <td><textarea name="txtArea_interests" id="txtArea_interests" cols="45" rows="5"></textarea></td>
        </tr>
        
        <tr>
	      <td><label>Skillset:</label></td>
	      <td><textarea name="txtArea_skillset" id="txtArea_skillset" cols="45" rows="5"></textarea></td>
        </tr>
         <tr>
	      <td><label>Qualification:</label></td>
	      <td><input type="file" name="filefield_qualification" id="filefield_qualification"></td>
        </tr>
        <tr>
	      <td><input name="btn_Update" type="submit" value="Update"></td>
          <td><input name="btn_clear" type="submit" value="Reset"></td>
	      <td>&nbsp;</td>
        </tr>
      </table>
   	 </form>
   	 
    </div>
>
</body>