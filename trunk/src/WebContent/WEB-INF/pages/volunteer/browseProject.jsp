<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>


<head>

<script type='text/javascript' 
    src='<%=request.getContextPath()%>/sys/scripts/datetimepicker.js'></script>
	

<link type="text/css"
	href="<%=request.getContextPath()%>/sys/css/paging.css"
	rel="stylesheet" />
	
	<script type="text/javascript">
        var defProjName = 'Please select...';

        window.onload = init;

        function init() {
		
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
	
	<div id="breadcrumb">
		<a href="#">Home</a> / <a href="#">Volunteer</a> / <a href="#">Browse Project</a>
	</div>
    <h2>Browse Project</h2>
	<div class="query">
   	  <form:form name="browseProject" method="post"  commandName="command" 
                   action="searchProjects.html" >
	  <table width="707" height="105" >
	    <tr>
	      <td width="122"><label>Project Code:</label></td>
	      <td width="197">
	      <spring:bind path="command.code">  
                            <form:input path="code"/>
                        </spring:bind>
            <form:errors path="code" cssClass="error"/>  
            </td>
	      <td width="157"><label>Start Month:</label></td>
	      <td width="203">
	      <spring:bind path="command.startDate">  
                            <form:input path="startDate"/>
           </spring:bind>
            <form:errors path="startDate" cssClass="error"/>  
	      </td>
        </tr>
	    <tr>
	      <td><label>Project Name:</label></td>
	      <td>
	      <spring:bind path="command.name">  
                            <form:input path="name"/>
                        </spring:bind>
            <form:errors path="name" cssClass="error"/>  
	      </td>
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

	   
   	  </form:form>
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
                <td>
              
				
				<a href="
	<c:url value="viewProjectDetails.html">
	     <c:param name="prjId" value="${item.prjId}"/> 
	</c:url>
	">
	Details
</a>
				
				</td>
			</tr>
		</c:forEach>
	</table>
	
</body>