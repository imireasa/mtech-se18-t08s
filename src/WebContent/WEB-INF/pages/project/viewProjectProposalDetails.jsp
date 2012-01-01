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
	
	<div id="breadcrumb">
	<a href="#">Home</a> / <a href="#">Review Project proposal</a></div>
    
<h2> Review Project Proposal</h2>
    

	<div class="reviewproposal">
   	 <form:form name="reviewproposal" method="post" commandName="proposal" action="reviewProposal.html">
	  <table width="475" height="105" >
	    <tr>
	      <td width><label> Name</label></td>
	      <td width>${proposal.nme}</td>
        </tr>
	    
        <tr>
	      <td><label>Description</label></td>
	      <td>
	      ${proposal.desc}
          </td>
        </tr>
        
        
         <tr>
	      <td><label>Country</label></td>
	      <td> ${proposal.ctryCd}</td>
        </tr>
        <tr>
	      <td><label>Location</label></td>
	      <td>${proposal.loc}</td>
        </tr>
        <tr>
	      <td><label>Estimated Duration</label></td>
	      <td>${proposal.estDur}</td>
        </tr>
	    <tr>
	      <td><label>Proposed by</label></td>
	      <td>${proposal.proposerId}</td>
        </tr>
        <tr>
	      <td><label>Status</label></td>
	      <td>
	      <form:select path="stsCd">
	      <c:forEach items="${stsCdList}" var="item" varStatus="status">
				<option value="${item.cdId}">${item.val}</option>
		      </c:forEach>
		  </form:select>
		 </td>
        </tr>
        <tr>
	      <td><label>Supporting Documents</label></td>
	      <td></td>
        </tr>
         <tr>
	      <td><label>Remark</label></td>
	      <td> <spring:bind path="proposal.rmk">  
					<form:textarea path="rmk" rows="5" cols="30" /> 
					 </spring:bind>
					<form:errors
							path="rmk" cssClass="error" />
		</td>
        </tr>
        <tr>
        
        </tr>
        
      </table>
   	 </form:form>
   	  <form:form name="reviewproposal" method="post" commandName="proposal" action="reviewProposal.html">
        
    	      <td><input name="btn_submit" type="button" value="Submit"></td>
	      </form:form>
    </div>
    




	

</body>