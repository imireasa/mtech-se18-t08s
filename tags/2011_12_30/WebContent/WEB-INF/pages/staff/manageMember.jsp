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
		<a href="#">Home</a> / <a href="#">Manage Project</a> /   <a href="#">List
	Project</a>/ <a href="#">Manage Member</a>
    <h2> Manage Member</h2>
      <table width="302" >
	  <tr>
	    <td width="100"><label>Project Code:</label></td>
	    <td width="186"><label></label></td>
      </tr>
       <tr>
	    <td width="100"><label>Project Name:</label></td>
	    <td width="186"><label></label></td>
      </tr>
	  </table>
	</div>
<div class="actions">
	  
</div>
<div class= "members"> 
  <table width="200" border="1">
  <tr>
    <td>
    <div class = "projectMembers">
    <table width="200" >
  <tr>
    <td><label>Project Members</label></td>
  </tr>
</table>

    <table width="200" border="1">
  
  <tr>
    <td><label>Delete</label></td>
    <td><label>Name</label></td>
    <td><label>Role</label></td>
  </tr>
  <tr>
    <td><form name="form1" method="post" action="">
      <input type="checkbox" name="chk_delete" id="chk_delete">
      <label for="chk_delete"></label>
    </form></td>
    <td>&nbsp;</td>
    <td><select name="select_Role" id="select_Role">
    </select></td>
  </tr>
</table>
    </div>
    
    </td>
    <td>
    
    <table width="237" border="1">
  <tr>
    <td width="227">
       <div class = "projectMembers">
    <table width="200" >
  <tr>
    <td><label>Review Project Interest</label></td>
  </tr>
</table>

    <table width="200" border="1">
  
  <tr>
    <td><label>Name</label></td>
    <td><label>Status</label></td>
    <td><label>Actions</label></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td><a href="#">Accept</a></td>
    <td><a href="#">Ignore</a></td>
  </tr>
</table>
    </div>
    </td>
  </tr>
  <tr>
    <td>
       <div class = "InviteMember">
    <table width="200" >
  <tr>
    <td><label>Invite Members</label></td>
  </tr>
  <tr>
    <td><label>Volunteer:</label><select name="select_Volunteers"></select><input name="btn_Invite" type="button" value="Invite"></td>
  </tr>
</table>

    <table width="200" border="1">
  
  <tr>
   
    <td><label>Name</label></td>
    <td><label>Status</label></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    
  </tr>
</table>
    </div>
    
    </td>
  </tr>
</table>

    
    </td>
  </tr>
</table>

</div>

	
<div class="pagination">
	  <jsp:useBean id="pagedListHolder" scope="request"
			type="org.springframework.beans.support.PagedListHolder" />

		<%-- // create link for pages, "~" will be replaced later on with the proper page number --%>
		<c:url value="/admin/member/searchProjectMember.html" var="pagedLink">
			<c:param name="p" value="~" />
		</c:url>

		<%-- // load our paging tag, pass pagedListHolder and the link --%>
		<tg:paging pagedListHolder="${pagedListHolder}"
			pagedLink="${pagedLink}" />
	</div>
</body>