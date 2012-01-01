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
		<a href="#">Home</a> / <a href="#">Project </a> / <a href="#">Propose
			New Project</a>

	</div>
	<h2>Propose NewProject</h2>
	<div class="query">
		<form:form name="proposeProject" method="post" commandName="projectVo"
			action="submitProjectProposal.html">
			<table width="548" height="105">

				<tr>
					<th><label>Project Name:</label>
					</td>
					<td>
					 <spring:bind path="projectVo.name">  
					<form:input path="name" />
					 </spring:bind>
					 <form:errors path="name"
							cssClass="error" />
							
							</td>
				</tr>
				<tr>
					<th><label>Description:</label>
					</th>
					<td>
					
					 <spring:bind path="projectVo.desc">  
					<form:textarea path="desc" rows="5" cols="30" /> 
					 </spring:bind>
					<form:errors
							path="desc" cssClass="error" /></td>
				</tr>

				<tr>
					<th><label>Country:</label>
					</th>
					<td>
				
					<form:select path="ctryCd">
							<c:forEach items="${countryList}" var="item" varStatus="status">
								<option value="${item.cdId}">${item.val}</option>
							</c:forEach>
						</form:select>
						
						
						</td>
				</tr>
				<tr>
					<th><label>Location:</label>
					</th>
					<td>
					 <spring:bind path="projectVo.loc">  
					<form:textarea path="loc" rows="5" cols="30" /> 
					 </spring:bind>
					<form:errors
							path="loc" cssClass="error" /></td>
				</tr>

				<tr>
					<th><label>Estimated Duration:</label>
					</th>
					<td>
					 <spring:bind path="projectVo.estDuration">  
					<form:input path="estDuration" /> (days) 
					</spring:bind>
					<form:errors
							path="estDuration" cssClass="error" /></td>
				</tr>
				<tr>
					<th><label>Supporting Documents:</label>
					</th>
					<td><label for="txtArea_remark"> <input type="file"
							name="fileField_supportDocs" id="fileField_supportDocs">
					</label>
					</td>
				</tr>
				<tr>
					<td><input type="submit" name="btn_Post" id="btn_Post"
						value="Submit"></td>
				</tr>
			</table>
			</form:form>
	</div>





</body>