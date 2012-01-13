<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>

<body>
<head>
<script type='text/javascript'
	src='<%=request.getContextPath()%>/dwr/interface/VmsDwr.js'></script>
<script type='text/javascript'
	src='<%=request.getContextPath()%>/dwr/engine.js'></script>

<link type="text/css"
	href="<%=request.getContextPath()%>/sys/css/paging.css"
	rel="stylesheet" />
<script type="text/javascript">
        var genList="";
        function generateCert(reqId) {
            
            document.getElementById("certRequestId").value=reqId;
            document.forms["form"].submit();

        }
</script>
</head>
<body>
	<h2><fmt:message key="message.administration.generateCertificate.label"/></h2>
	
	<div id="breadcrumb">
		 <a href="<%=request.getContextPath()%>/common/welcome.html"><fmt:message key="message.common.home.label"/></a> / 
                <fmt:message key="message.administration.generateCertificate.label"/>
	</div>

		<form id="form" name="form" method="post" action="generateCertificate.html">
			<table width="690" class="proj-table">
				<tr>
					<th width="80"><fmt:message key="message.administration.requestId.label"/></th>
					<th width="150"> <fmt:message key="message.projectManagement.projectName.label"/></th>
                    <th width="150"><fmt:message key="message.administration.requestType.label"/></th>
                    <th width="150"><fmt:message key="message.administration.requestBy.label"/></th>
                    <th width="150"><fmt:message key="message.administration.requestDate.label"/></th>
                    <th width="80" colspan="2"><fmt:message key="message.common.generate.button"/></th>
				</tr>
					<c:forEach items="${pagedListHolder.pageList}" var="item" varStatus="status">
						<tr>            
								<td>${item.certReqId}</td>
                    			<td>${item.prjName}</td>
                    			<td>${item.reqTpName}</td>
                    			<td>${item.reqByName}</td>
                                <td><fmt:formatDate pattern="dd-MM-yyyy" value="${item.reqDte}" /></td>
                                <td colspan="2">
									<input type="button" name="generate" id="generate" value=<fmt:message key="message.common.generate.button"/>  onclick="generateCert('${item.certReqId}')"/>
								<input type="hidden" name="certRequestId" id="certRequestId" /></td>
						</tr>
                   </c:forEach>
				
			</table>
		</form>
<div class="pagination">
        <jsp:useBean id="pagedListHolder" scope="request"
                     type="org.springframework.beans.support.PagedListHolder" />

        <%-- // create link for pages, "~" will be replaced later on with the proper page number --%>
        <c:url value="generateCertificate.html" var="pagedLink">
            <c:param name="p" value="~" />
        </c:url>

        <%-- // load our paging tag, pass pagedListHolder and the link --%>
        <tg:paging pagedListHolder="${pagedListHolder}"
                   pagedLink="${pagedLink}" />
    </div>
</body>