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
   	 <form:form name="reviewproposal" method="post" commandName="proposalVo" action="reviewProposal.html">
	  <table width="475" height="105" >
	    <tr>
	      <th><label> Name</label></th>
	      <td width>${proposalVo.name}</td>
        </tr>
	    
        <tr>
	      <th><label>Description</label></th>
	      <td>
	      ${proposalVo.desc}
          </td>
        </tr>
        
        
         <tr>
	      <th><label>Country</label></th>
	      <td> ${proposalVo.ctryCd}</td>
        </tr>
        <tr>
	      <th><label>Location</label></th>
	      <td>${proposalVo.loc}</td>
        </tr>
        <tr>
	      <th><label>Estimated Duration</label></th>
	      <td>${proposalVo.estDuration}</td>
        </tr>
	    <tr>
	      <th><label>Proposed by</label></th>
	      <td>${proposalVo.proposerId}</td>
        </tr>
        <tr>
	      <th><label>Status</label></th>
	      <td>
	      <form:select path="status">
	      <c:forEach items="${stsCdList}" var="item" varStatus="status">
				<option value="${item.val}">${item.val}</option>
		      </c:forEach>
		  </form:select>
		 </td>
        </tr>
        <tr>
	      <th><label>Supporting Documents</label></th>
	      <td></td>
        </tr>
         <tr>
	      <th><label>Remark</label></th>
	      <td> <spring:bind path="proposalVo.rmk">  
					<form:textarea path="rmk" rows="5" cols="30" /> 
					 </spring:bind>
					<form:errors
							path="rmk" cssClass="error" />
		</td>
        </tr>
        <tr>
    	      <td><input name="btn_submit" id="btn_submit" type="submit" value="Submit"></td>
	     
        </tr>
        
      </table>
   	 </form:form>
   	 
    </div>
    




	

</body>