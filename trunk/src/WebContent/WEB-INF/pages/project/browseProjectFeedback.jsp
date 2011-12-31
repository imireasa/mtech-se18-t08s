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
	
	<div id="breadcrumb">
		<a href="#">Home</a> / <a href="#">Manage Project</a> / <a href="#">Search Project Feedback</a></div>
        <h2>Search Project Feedback</h2>
	<div class="query">  
    <form:form name="browseProjectFeedback" method="post"  commandName="feedbackVo" 
                   action="searchProjectFeedback.html" >
	  <table width="707" height="105" >
	    <tr>
	      <td width="122"><label>Project Id:</label></td>
	      <td width="197">
	      <spring:bind path="feedbackVo.prjId">  
                            <form:input path="prjId"/>
                        </spring:bind>
            <form:errors path="prjId" cssClass="error"/>  
            </td>
	      <td width="157"><label>Feedback Title:</label></td>
	      <td width="203">
	      <spring:bind path="feedbackVo.fbTitle">
               <form:input path="fbTitle"/>
           </spring:bind>
            <form:errors path="fbTitle" cssClass="error"/>  
	      </td>
        </tr>
	    <tr>
	      <td><label>Project Name:</label></td>
	      <td>
	      <spring:bind path="feedbackVo.prjName">  
                            <form:input path="prjName"/>
                        </spring:bind>
            <form:errors path="prjName" cssClass="error"/>  
	      </td>
	      <td><label>Status:</label></td>
	      <td>
	        <form:select path="fbStatus">
              <c:forEach items="${fbCodeList}" var="item" varStatus="status">
                 <option value="${item.cdId}">${item.val}</option>
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
			<th colspan="5" align="left">
			<label>Search Results</label></th>
		</tr>
		<tr>
        <th><label>Project Code</label></th>
			<th><label>Project Name</label></th>
			
			<th><label>Feedback Title</label></th>
			<th><label>Created by</label></th>
            <th><label>Status</label></th>
            
			
		</tr>
		<c:forEach items="${feedbackList}" var="item">
			<tr>
				<td>${item.prjId.prjId}</td>
				<td>${item.prjId.nme}</td>
				<td>${item.title}</td>
				<td>${item.createdBy}</td>
                <td>${item.stsCd};</td>
                <td><a href="
	<c:url value="viewProjectFeedbackDetails.html">
	     <c:param name="prjFbId" value="${item.prjFbId}"/> 
	</c:url>
	">Details</a></td>
				<!-- <td><input type="submit" name="btn_publish" id="btn_publish" value="Publish"></td>-->
      			
			</tr>
		</c:forEach>
	</table>
	
</body>