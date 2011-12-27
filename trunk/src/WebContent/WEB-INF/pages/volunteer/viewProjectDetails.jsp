<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>

<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet" type="text/css">
<body>
<head>
<script type='text/javascript'
	src='<%=request.getContextPath()%>/dwr/interface/VmsDwr.js'></script>
<script type='text/javascript'
	src='<%=request.getContextPath()%>/dwr/engine.js'></script>

<link type="text/css"
	href="<%=request.getContextPath()%>/sys/css/paging.css"
	rel="stylesheet" />

<script type="text/javascript">
	var defProjName = 'Please select...';

	window.onload = init;

	function init() {
		document.getElementById("projectName").value = defProjName;
	}

	function projectNameOnfocus() {
		document.getElementById("projectName").select();

	}

	function submit(val, name) {
		var projectId = document.getElementById("projectId");
		var projectName = document.getElementById("projectName");
		var searchMemberForm = document.getElementById("searchMemberForm");

		projectId.value = val;
		projectName.value = name;
		searchMemberForm.submit();
	}
</script>
</head>
<body>
	<h2>  Project Details</h2>
	<div id="breadcrumb">
		<a href="#">Home</a> / <a href="#">Volunteer</a> /  <a href="#">Project
	Details</a> 
	    <table width="302">
	  <tr>
	    <td width="100"><label>Project Name:</label></td>
	    <td width="186"><label></label></td>
      </tr>
	  </table>
	</div>
    <form action="" method="post">
    <input type="submit" name="btn_RaiseProjectInterest" id="btn_RaiseProjectInterest" value="Raise Project Interest">
    </form>
<div class="actions">
    
</div>
	<div class="query">
   	 
	  <table width="286" height="105" >
	    <tr>
	      <td width="103"><label>Description:</label></td>
	      <td width="167">&nbsp;</td>
        </tr>
	    <tr>
	      <td><label>Start Date:</label></td>
	      <td></td>
        </tr>
        <tr>
	      <td><label>Project Status:</label></td>
	      <td></td>
        </tr>
        <tr>
	      <td><label>Location:</label></td>
	      <td></td>
        </tr>
         <tr>
	      <td><label>Country:</label></td>
	      <td></td>
        </tr>
	   
      </table>
	</div>
    
<div class= "members">
  <div id="TabbedPanels1" class="TabbedPanels">
         <ul class="TabbedPanelsTabGroup">
           <li class="TabbedPanelsTab" tabindex="0">Project Member</li>
           <li class="TabbedPanelsTab" tabindex="1">Member Experience</li>
             <li class="TabbedPanelsTab" tabindex="2">Feedback
              
             </li>
         </ul>
         <div class="TabbedPanelsContentGroup">
           <div class="TabbedPanelsContent">
           <form action="" method="post">
            	<table width="535" border="1">
                 <tr>
                  
                   <td width="40">Name</td>
                   <td width="116">Join Date</td>
                  
                 </tr>
                 
                  <tr>
                  
                   <td width="40"></td>
                   <td width="116"></td>
                   <td width="357">
    <input type="submit" name="btn_reqCertificate" id="btn_reqCertificate" value="Request Certificate">
</td>
                 </tr>
               </table>
               </form>
               </div>
           <div class="TabbedPanelsContent">
           
            	<table width="314" border="1">
                 <tr>
                  
                   <td width="40">Name:</td>
                   <td width="116">Experience</td>
                  
                 </tr>
               </table>
               
               <form>
                 <table width="200" border="1">
  <tr>
    <td>Name:</td>
    <td>
      <input type="text" name="txtField_memberName" id="txtField_memberName"></td>
  </tr>
  <tr>
    <td>Experience:</td>
    <td><textarea name="txtArea_Experience" id="txtArea_Experience" cols="45" rows="5"></textarea></td>
  </tr>
  <tr>
    <td colspan="2" align="right"><input type="submit" name="btn_PostExperience" id="btn_PostExperience" value="Post"></td>
  
  </tr>
</table>

    </form>
              
               </div>
            <div class="TabbedPanelsContent">
            <table width="314" border="1">
                 <tr>
                  
                   <th>Index</th>
                   <th>Feedback Title</th>
                    <th>Description</th>
                  
                 </tr>
                  <tr>
                  
                   <td>1</td>
                   <td>Complaint </td>
                    <td>dd </td>
                  
                 </tr>
               </table>
               
               <form>
                 <table width="200" border="1">
  <tr>
    <td>Title:</td>
    <td>
      <input type="text" name="txtField_feedbackTitle" id="txtField_feedbackTitle"></td>
  </tr>
  <tr>
    <td>Feedback:</td>
    <td><textarea name="txtArea_Feedback" id="txtArea_Feedback" cols="45" rows="5"></textarea></td>
  </tr>
  <tr>
    <td colspan="2" align="right"><input type="submit" name="btn_PostFeedback" id="btn_PostFeedback" value="Post"></td>
  
  </tr>
</table>

               </form>
               
               </div>
         </div>
  </div>
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
<script type="text/javascript">
var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
</script>
</body>