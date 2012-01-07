<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%><body>
<head>

<link type="text/css"
	href="<%=request.getContextPath()%>/sys/css/paging.css"
	rel="stylesheet" />


</head>
<body>
	<h2> Review Project Proposal</h2>
	<div id="breadcrumb">
	<a href="#">Home</a> / <a href="#">Review Project proposal</a></div>
    

    

	<div class="query">
	
	<c:if test="${not empty propMsg}"> 
                        <div class="infoblock">
                                <c:out value="${propMsg}" escapeXml="false"/><br/>
                        </div>
            </c:if>
   	 <form:form name="reviewproposal" method="post" commandName="proposalVo" action="reviewProposal.html">
	  <table class="proj-table">
	    <tr>
	    
	     <th><fmt:message key="message.common.name.label"/></th>
<th>
					<fmt:message key="message.common.symbol.afterLabel.label" />
					</th>
	      <td width>${proposalVo.name}</td>
        </tr>
	    
        <tr>
	     <th><fmt:message key="message.common.description.label"/></th>
	     <th>
					<fmt:message key="message.common.symbol.afterLabel.label" />
					</th>
	      <td>
	      ${proposalVo.desc}
          </td>
        </tr>
        
        
         <tr>
	     <th><fmt:message key="message.common.country.label"/></th>
	     <th>
					<fmt:message key="message.common.symbol.afterLabel.label" />
					</th>
	      <td> ${proposalVo.ctryCd}</td>
        </tr>
        <tr>
	       <th><fmt:message key="message.common.location.label"/></th>
	       <th>
					<fmt:message key="message.common.symbol.afterLabel.label" />
					</th>
	      <td>${proposalVo.loc}</td>
        </tr>
        <tr>
	      	<th><fmt:message key="message.common.duration.label"/></th>
	      	<th>
					<fmt:message key="message.common.symbol.afterLabel.label" />
					</th>
	        <td>${proposalVo.estDuration}</td>
        </tr>
	    <tr>
	      <th><fmt:message key="message.common.creator.label"/></th>
	      <th>
					<fmt:message key="message.common.symbol.afterLabel.label" />
					</th>
	      <td>${proposalVo.proposerId}</td>
        </tr>
        <tr>
	      
	      <th ><fmt:message key="message.common.status.label"/></th>
	      <th>
					<fmt:message key="message.common.symbol.afterLabel.label" />
					</th>
	      <td>
	     
	      <c:forEach items="${stsCdList}" var="item" varStatus="status">
				<c:if test="${item.val!='Submitted'}">
				${item.val}<form:radiobutton path="status" value="${item.val}"/>
				</c:if>
		   </c:forEach>
		 
		 </td>
        </tr>
        <tr>
	      <th><label>Supporting Documents</label></th>
	      <th>
					<fmt:message key="message.common.symbol.afterLabel.label" />
					</th>
	      <td></td>
        </tr>
         <tr>
	       <th><fmt:message key="message.common.remark.label"/></th>
	       <th>
					<fmt:message key="message.common.symbol.afterLabel.label" />
					</th>
	      <td> <spring:bind path="proposalVo.rmk">  
					<form:textarea path="rmk" rows="5" cols="30" /> 
					 </spring:bind>
					<form:errors
							path="rmk" cssClass="error" />
		</td>
        </tr>
        <tr>
    	      <td colspan="3" align="center"><input name="btn_submit" id="btn_submit" type="submit" value="Submit" class="button"></td>
	     
        </tr>
        
       
			
           
        
      </table>
   	 </form:form>
   	 
    </div>
    




	

</body>