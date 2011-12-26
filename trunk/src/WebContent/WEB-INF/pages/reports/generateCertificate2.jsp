

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
	function getMemberData() {
		return;
		document.forms["form"].action = "<%=request.getContextPath()%>/report/volunteer/generateCertificate.html"
		document.forms["form"].submit();
	}
</script>
</head>
<body>
	<h2>Generate Certificate</h2>
	<div id="breadcrumb">

		<a href="#">Home</a> > <a href="#">Project</a> > <a href="#">Generate Certificate</a> 
	</div>
	<br />

	<br />
	<div class="query">
		<form id="form" name="form" method="post"
			action="<%=request.getContextPath()%>/report/volunteer/generateCertificatePdf.html">
			<table width="545" >
				<tr>
					<td width="43"><label>Point</label></td>
					<td width="116"><label>Project Name</label></td>
                    <td width="105"><label>Request Type</label></td>
                     <td width="97"><label>Requested by</label></td>
                      <td width="160"><label>Request Date</label></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="check_gntCertificate" id="check_gntCertificate">
				    <label for="check_gntCertificate"></label></td>
					<td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="5" align="center"><input type="submit" name="Search" id="Search"
						value="Generate" class="button" />
					</td>
                    </tr>
			</table>
		</form>
	</div>
</body>