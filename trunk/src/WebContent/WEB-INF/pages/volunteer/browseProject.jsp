<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>


<head>


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
	      <td width="122"><label>Project Id:</label></td>
	      <td width="197">
	      <spring:bind path="command.prjPropId">  
                            <form:input path="prjPropId"/>
                        </spring:bind>
            <form:errors path="prjPropId" cssClass="error"/>  
            </td>
	      <td width="157"><label>Start Month:</label></td>
	      <td width="203">
	      <spring:bind path="command.strDte">
                            <form:input path="strDte"/><img src="<%=request.getContextPath()%>/sys/images/cal.gif" onClick="javascript:NewCssCal('strDte')" style="cursor:pointer"/>
           </spring:bind>
            <form:errors path="strDte" cssClass="error"/>  
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
	      <td>
	        <form:select path="stsCd">
              <c:forEach items="${projectCodeList}" var="item" varStatus="status">
                 <option value="'${item.cdId}'">${item.val}</option>
              </c:forEach>
           </form:select>       
         </td>
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