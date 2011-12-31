

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%-- 
    Document   : noSession
    Created on : Jun 13, 2011, 10:54:53 AM
    Author     : Zaw.Htet
--%>
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
	<h2>Generate Certificate</h2>
	<div id="breadcrumb">
		<a href="#">Home</a> > <a href="#">Certificate</a> > <a href="#">Generate Certificate</a>
	</div>
	<br />

	<br />
	<div class="query">
		<form id="form" name="form" method="post"
			action="generateCertificate.html">
			<table width="545" >
				<tr>
					<td width="43"><label></label></td>
					<td width="116"><label>Project Name</label></td>
                    <td width="105"><label>Request Type</label></td>
                     <td width="97"><label>Requested by</label></td>
                      <td width="160"><label>Request Date</label></td>
				</tr>


                                <c:forEach items="${reqCertList}" var="item" varStatus="status">
				<tr>
                                        <td><input type="checkbox" name="check_gntCertificate" id="check_gntCertificate${item.certReqId}" onclick="generateCert('check_gntCertificate'+${item.certReqId}, ${item.certReqId})" >
                                        <label for="check_gntCertificate"></label></td>
					<td>${item.prjId}</td>
                                        <td>${item.reqTp}</td>
                                        <td>${item.reqBy}</td>
                                        <td><fmt:formatDate pattern="dd-MM-yyyy" value="${item.reqDte}" /></td>
				</tr>
                                </c:forEach>
				<tr>
                                        <td>
                                                <input type="hidden" name="generateList" id="generateList"/>
                                        </td>
					<td colspan="5" align="center">
                                                <input type="submit" name="generate" id="generate" value="Generate" class="button" />
					</td>
                    </tr>
			</table>
		</form>
	</div>
</body>