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
		<a href="#">Home</a> /<a href="#">Forgot Password</a></div>
	<div class="query">
   	  <form name="form1" method="post" action="">
	  <table width="1013" height="105" >
	    <tr>
	      <td width="209"><label>Your Email:</label></td>
	      <td width="788"><input type="text" name="textfield3" id="textfield3"></td>
	     
	     
        </tr>
            <tr>
					<td>    
        	<input type="submit" name="btn_Search" id="btn_Search" value="Send My Password to Email">
            </td>
            </tr>
	   
      </table>

	
   	  </form>
    </div>
	<!-- end of query -->
</body>