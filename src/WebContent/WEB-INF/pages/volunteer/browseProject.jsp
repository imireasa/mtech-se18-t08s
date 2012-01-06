<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>


<head>


<link type="text/css"
	href="<%=request.getContextPath()%>/sys/css/paging.css"
	rel="stylesheet" />
</head>
<body>
	<h2>Browse Project</h2>
	<div id="breadcrumb">
		<a href="#">Home</a> / <a href="#">Volunteer</a> / <a href="#">Browse Project</a>
	</div>
    
	<div class="query">
   	  <form:form name="browseProject" method="post"  commandName="command" 
                   action="searchProjects.html" >
	  <table width="707" height="105" >
	    <tr>
	      <td><fmt:message key="message.projectManagement.projectName.label"/></td>
	      <td>
	      <spring:bind path="command.name">  
                            <form:input path="name"/>
                        </spring:bind>
            <form:errors path="name" cssClass="error"/>  
	      </td>
	      <td><fmt:message key="message.common.startDate.label"/></td>
	      <td>
	      <spring:bind path="command.strDte">
                            <form:input path="strDte"/><img src="<%=request.getContextPath()%>/sys/images/cal.gif" onClick="javascript:NewCssCal('strDte','ddMMyyyy')" style="cursor:pointer"/>
           </spring:bind>
            <form:errors path="strDte" cssClass="error"/>  
	      </td>
        </tr>
	    <tr>
	      
	      <td><fmt:message key="message.common.status.label"/></td>
	      <td>
	        <form:select path="stsCd">
	        <form:option value="" label="ALL"/>
              <c:forEach items="${projectCodeList}" var="item" varStatus="status">
                 <form:option value="${item.cdId}">${item.val}</form:option>
              </c:forEach>
           </form:select>       
         </td>
         <td colspan="2" align="center">    
        	<input type="submit" name="btn_Search" id="btn_Search" value="Search">
            </td>
        </tr>
        
       
	   
      </table>

	   
   	  </form:form>
    </div>
	<!-- end of query -->
	<table width="700" class="proj-table">
		
		<tr>
			<th><fmt:message key="message.projectManagement.projectName.label"/></th>
			<th><fmt:message key="message.common.description.label"/></th>
			<th><fmt:message key="message.common.startDate.label"/></th>
				
		</tr>
		<c:forEach items="${pagedListHolder.pageList}" var="item" varStatus="status">
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
		<div class="pagination">
		<jsp:useBean id="pagedListHolder" scope="request"
			type="org.springframework.beans.support.PagedListHolder" />

		<%-- // create link for pages, "~" will be replaced later on with the proper page number --%>
		<c:url value="/volunteer/browseProject.html" var="pagedLink">
			<c:param name="p" value="~" />
		</c:url>

		<%-- // load our paging tag, pass pagedListHolder and the link --%>
		<tg:paging pagedListHolder="${pagedListHolder}"
			pagedLink="${pagedLink}" />
	</div>
</body>