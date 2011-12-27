<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>

<body>
<head>

<script type='text/javascript' 
    src='<%=request.getContextPath()%>/sys/scripts/datetimepicker.js'></script>
	

<link type="text/css"
	href="<%=request.getContextPath()%>/sys/css/paging.css"
	rel="stylesheet" />


</head>
<body>
	
	<div id="breadcrumb">
		<a href="#">Home</a> / <a href="#">Volunteer</a> / <a href="#">Browse Project</a>
	</div>
    <h2>Browse Project</h2>
	<div class="query">
   	  <form name="form1" method="post" action="">
	  <table width="707" height="105" >
	    <tr>
	      <td width="122"><label>Project Code:</label></td>
	      <td width="197"><input type="text" name="textfield3" id="textfield3"></td>
	      <td width="157"><label>Start Month:</label></td>
	      <td width="203"><input type="text" name="txtField_startDate" id="txtField_startDate">
	      </td>
        </tr>
	    <tr>
	      <td><label>Project Name:</label></td>
	      <td><input type="text" name="textfield4" id="textfield4"></td>
	      <td><label>Status:</label></td>
	      <td><label for="select_status"></label>
	        <select name="select_status" id="select_status">
	          <option>All</option>
          </select></td>
        </tr>
        
        <tr>
					<td colspan="4" align="center">    
        	<input type="submit" name="btn_Search" id="btn_Search" value="Search">
            </td>
            </tr>
	   
      </table>

	   
   	  </form>
    </div>
	<!-- end of query -->
	<table width="700" class="proj-table">
		<tr>
			<td colspan="5"><b><label>Project List</label></b></td>
		</tr>
		<tr>
			<th><label>Name</label></th>
			<th><label>Description</label></th>
			<th><label>StartDate</label></th>
			
			
		</tr>
		<c:forEach items="${projectList}" var="item" varStatus="status">
			<tr>
				<td>${item.nme}</td>
				<td>${item.desc}</td>
                <td>${item.strDte}</td>
				<td><a href="#">Details</a></td>
				</td>
			</tr>
		</c:forEach>
	</table>
	
</body>