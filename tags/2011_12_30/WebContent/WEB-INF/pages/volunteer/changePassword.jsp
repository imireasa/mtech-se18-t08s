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
		<a href="#">Home</a> /<a href="#">Change Password</a></div>
	<div class="query">
   	  <form name="form1" method="post" action="">
	  <table width="1013" height="105" >
	    <tr>
	      <td width="209"><label> Email:</label></td>
	      <td width="788"><input type="text" name="textfield3" id="textfield3"></td>
	     
	     
        </tr>
        <tr>
	      <td width="209"><label>Old Password:</label></td>
	      <td width="788"><input type="text" name="textfield3" id="textfield3"></td>
	     
	     
        </tr>
        <tr>
	      <td width="209"><label> New Password:</label></td>
	      <td width="788"><input type="text" name="textfield3" id="textfield3"></td>
	     
	     
        </tr>
        <tr>
	      <td width="209"><label> Confirm New Password:</label></td>
	      <td width="788"><input type="text" name="textfield3" id="textfield3"></td>
	     
	     
        </tr>
            <tr>
					<td>    
        	<input type="submit" name="btn_change" id="btn_change" value="Update">
            </td>
            <td>    
        	<input type="submit" name="btn_clear" id="btn_clear" value="Clear">
            </td>
            </tr>
	   
      </table>

	
   	  </form>
    </div>
	<!-- end of query -->
</body>