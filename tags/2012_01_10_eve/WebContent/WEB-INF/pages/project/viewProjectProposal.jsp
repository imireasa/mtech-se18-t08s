<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>

<body>
	<h2> <fmt:message key="message.projectManagement.reviewProjectProposals.label" /></h2>
	<div id="breadcrumb">
		<a href="<%=request.getContextPath()%>/common/welcome.html"><fmt:message key="message.common.home.label"/></a> / 
		<a href="browseProjectProposal.html"><fmt:message key="message.projectManagement.browseProjectProposal.label" /></a> / 
		<fmt:message key="message.projectManagement.reviewProjectProposals.label" />
    </div>
	<div class="query">
	
			 <c:if test="${not empty msg}"> 
                        <div class="infoblock">
                                <c:out value="${msg}" escapeXml="false"/><br/>
                        </div>
                </c:if>

                <c:if test="${not empty errors}"> 
                        <div class="error">
                                <c:forEach var="error" items="${errors}">  
                                        <c:out value="${error}" escapeXml="false"/><br/>
                                </c:forEach>
                        </div>
                </c:if>
   	 <form:form name="reviewproposal" method="post" commandName="proposalVo" action="reviewProposal.html">
	  <table class="query-table">
	    <tr>
			<td><fmt:message key="message.common.name.label"/></td>
			<td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
			<td>${proposalVo.nme}</td>
        </tr>
	    
        <tr>
			<td><fmt:message key="message.common.description.label"/></td>
			<td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
			<td>${proposalVo.desc}</td>
        </tr>

        <tr>
			<td><fmt:message key="message.common.country.label"/></td>
			<td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
			<td> ${proposalVo.ctryVal}</td>
        </tr>
        <tr>
	       <td><fmt:message key="message.common.location.label"/></td>
	       <td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
			<td>${proposalVo.loc}</td>
        </tr>
        <tr>
	      	<td><fmt:message key="message.common.duration.label"/></td>
			<td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
	        <td>${proposalVo.estDur}</td>
        </tr>
	    <tr>
			<td><fmt:message key="message.common.creator.label"/></td>
			<td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
			<td>${proposalVo.proposerId}</td>
        </tr>
        <tr>
			<td><fmt:message key="message.common.status.label"/></td>
			<td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
			<td>
				<c:forEach items="${stsCdList}" var="item" varStatus="stsVal">
					<c:if test="${item.val!='Submitted'}">
					<form:radiobutton path="stsVal" value="${item.val}"/>${item.val}
					</c:if>
				</c:forEach>
			 </td>
        </tr>
        <tr>
			<td>Supporting Documents</td>
			<td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
			<td></td>
        </tr>
         <tr>
			<td><fmt:message key="message.common.remark.label"/></td>
			<td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
			<td> <spring:bind path="proposalVo.rmk">  
					<form:textarea path="rmk" rows="5" cols="30" /> 
					 </spring:bind>
					<form:errors
							path="rmk" cssClass="error" />
			</td>
        </tr>
        <tr>
			<td colspan="2"></td>
    	    <td><input name="submitButton" id="submitButton" type="submit" value="<fmt:message key="message.common.submit.button" />"></td>
	     
        </tr>
        
       
			
           
      </table>
                </form:form>
        </div>
</body>