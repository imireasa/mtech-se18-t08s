<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tab" uri="http://ditchnet.org/jsp-tabs-taglib" %>


<head>

<link type="text/css"
	href="<%=request.getContextPath()%>/sys/css/paging.css"
	rel="stylesheet" />
<tab:tabConfig />

</head>
<body>
	<h2>Project Details</h2>
	<div id="breadcrumb">
		<a href="#">Home</a> / <a href="#">Volunteer</a> / <a href="#">Project
			Details</a>
	</div>

	<div class="query">
		<form:form name="viewProjectDetails" method="post"
			commandName="command" action="raiseInterest.html">
			<table>
				<tr>
					<td width="103"><label>Project Name:</label>
					</td>
					                        
					<td width="186"><label>${project.nme}</label>
				
					</td>
				</tr>
				<tr>
					<td width="103"><label>Description:</label>
					</td>
					<td width="167">${project.desc}</td>
				</tr>
				<tr>
					<td><label>Start Date:</label>
					</td>
					<td>${project.strDte}</td>
				</tr>
				<tr>
					<td><label>Project Status:</label>
					</td>
					<td>${project.stsCd}</td>
				</tr>
				<tr>
					<td><label>Location:</label>
					</td>
					<td>${project.loc}</td>
				</tr>
				<tr>
					<td><label>Country:</label>
					</td>
					<td>${project.ctryCd}</td>
				</tr>

			</table>
			<input type="submit" name="btn_RaiseProjectInterest"
				id="btn_RaiseProjectInterest" value="Raise Project Interest">
		</form:form>
	</div>
    
    
<tab:tabContainer id="foo-bar-container">
	
	<tab:tabPane id="member" tabTitle="Project Members">
<table width="200" border="1">
  <tr>
    <td>ID</td>
    <td>Role</td>
    <td>isActive</td>
  </tr>
  <c:forEach items="${projectList}" var="item" varStatus="status">
			<tr>
				<td>${item.usrLoginId}</td>
				<td>${item.roleCd}</td>
                <td>${item.actInd}</td>
                
			</tr>
</table>
     </c:forEach>

	</tab:tabPane>

	<tab:tabPane id="experience" tabTitle="Experience">
		
	</tab:tabPane>
    
    <tab:tabPane id="feedback" tabTitle="Feedback">
		
	</tab:tabPane>

</tab:tabContainer>
			

</body>