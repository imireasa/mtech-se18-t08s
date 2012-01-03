<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>

<body>
<head>

<link type="text/css"
	href="<%=request.getContextPath()%>/sys/css/paging.css"
	rel="stylesheet" />

</head>
<body>
	<h2>Search Project Proposal</h2>
	<div id="breadcrumb">
		<a href="#">Home</a> / <a href="#">Manage Project</a> / <a href="#">Search Project Proposal</a></div>
        
	<div class="query">  
    <form:form name="browseProjectProposal" method="post"  commandName="proposalVo" 
                   action="searchProjectProposal.html" >
	  <table width="707" height="105" >
	    <tr>
	     
	      <td width="157"><label>Proposal Name:</label></td>
	      <td width="203">
	      <spring:bind path="proposalVo.proposalName">
               <form:input path="proposalName"/>
           </spring:bind>
            <form:errors path="proposalName" cssClass="error"/>  
	      </td>
        </tr>
	    <tr>
	     
	      <td><label>Status:</label></td>
	      <td>
	        <form:select path="stsCd">
	        <form:option value="" label="ALL"/>
              <form:options items="${stsCdList}" itemValue="cdId" itemLabel="val" />
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
			<th colspan="5" align="left">
			<label>Search Results</label></th>
		</tr>
		<tr>
        <th><label> Proposal ID</label></th>
				
			<th><label>Proposal Name</label></th>
			<th><label>Created by</label></th>
            <th><label>Status</label></th>
            
			
		</tr>
		<c:forEach items="${proposalList}" var="item">
			<tr>
				<td>${item.prjPropId}</td>
				
				<td>${item.nme}</td>
				<td>${item.createdBy}</td>
                
                
                <td>
                <c:forEach items="${stsCdList}" var="item2" varStatus="status">
                <c:set var="fbStsId">${item.stsCd}</c:set>
                 <c:set var="codeId">${item2.cdId}</c:set>
                
                   <c:if test="${fbStsId == codeId}">
                   	<c:out value="${item2.val}"/>
                   </c:if>
                 </c:forEach>
 </td>
                <td><a href="<c:url value="viewProjectProposalDetails.html">
	                    <c:param name="prjPropId" value="${item.prjPropId}"/> 
	    </c:url>
	">Details</a></td>
				<!-- <td><input type="submit" name="btn_publish" id="btn_publish" value="Publish"></td>-->
      			
			</tr>
		</c:forEach>
	</table>
	
</body>