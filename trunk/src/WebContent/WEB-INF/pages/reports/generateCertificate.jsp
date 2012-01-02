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
        function generateCert(control,reqId)
        {
            //alert("control "+control);
            //alert("reqid " + reqId);
            if(document.getElementById(control).checked == true)
            {
                    if(genList == ""){
                           genList = reqId;
                    }
                    else{
                           genList = genList + ',' + reqId;
                    }
                    //alert("+genList " + genList);
            }
            //need to check for replace string function
            else if(document.getElementById(control).checked == false)
            {
                   genList.replace(reqId, "");
                   genList.replace(",,", ",");
                   //alert("-genList " + genList);
            }
            document.getElementById("generateList").value=genList;
            //alert("fgenList " + genList);

        }
</script>
</head>
<body>
	<h2><fmt:message key="message.administration.generateCertificate.label"/></h2>
	
	<div id="breadcrumb">
		 <a href="#"><fmt:message key="message.common.home.label"/></a>/ 
                <fmt:message key="message.administration.generateCertificate.label"/>
	</div>
	<br />

	<br />
	<div class="query">
		<form id="form" name="form" method="post" action="generateCertificate.html">
			<table width="545" >
				<tr>

					<td width="200"><label>Certificate Request Id</label></td>
					<td width="200"><label> <fmt:message key="message.projectManagement.projectName.label"/></label></td>
                    <td width="150"><label><fmt:message key="message.administration.requestType.label"/></label></td>
                    <td width="200"><label><fmt:message key="message.administration.requestBy.label"/></label></td>
                    <td width="150"><label><fmt:message key="message.administration.requestDate.label"/></label></td>
                    <td width="100"><label><fmt:message key="message.common.generate.button"/></label></td>
				</tr>
					<c:forEach items="${certReqVoList}" var="item" varStatus="status">
						<tr>
      <!-- 			<td><input type="checkbox" name="check_gntCertificate" id="check_gntCertificate${item.certReqId}" onclick="generateCert('check_gntCertificate'+${item.certReqId}, ${item.certReqId})" >
                                        <label for="check_gntCertificate"></label></td>  -->              
								<td>${item.certReqId}</td>
                    			<td>${item.prjName}</td>
                    			<td>${item.reqTpName}</td>
                    			<td>${item.reqByName}</td>
                                <td><fmt:formatDate pattern="dd-MM-yyyy" value="${item.reqDte}" /></td>
                                <td><input type="hidden" name="certRequestId" value="${item.certReqId}"/></td>
                                <td><input type="submit" name="generate" id="generate" value=<fmt:message key="message.common.generate.button"/> class="button"/></td>
						</tr>
                   </c:forEach>
			
			</table>
		</form>
	</div>
</body>