<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://struts-menu.sf.net/tag" prefix="menu"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="sg.edu.nus.iss.vms.common.vo.UserSessionInfoVo" %> 

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title><decorator:title default="Volunteer Management System" /></title>

	<meta name="description" content="" />
	<meta name="keywords" content="" />

	<!-- ICO -->
	<link rel="icon" href="<%=request.getContextPath()%>/sys/favicon.ico" type="image/x-icon" />
	<link rel="shortcut icon" href="<%=request.getContextPath()%>/sys/favicon.ico" type="image/x-icon" />
	
	<!-- CSS -->
	<link href="<%=request.getContextPath()%>/sys/css/v02/global_v2.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath()%>/sys/css/reset.css" rel="stylesheet" type="text/css" />
	<link type="text/css" href="<%=request.getContextPath()%>/sys/css/paging.css" rel="stylesheet" />
	<link type="text/css" href="<%=request.getContextPath()%>/sys/css/jquery-ui-min.css" rel="stylesheet" />
	<link type="text/css" href="<%=request.getContextPath()%>/sys/css/validationEngine.template.css" rel="stylesheet" />
	<link type="text/css" href="<%=request.getContextPath()%>/sys/css/validationEngine.jquery.css" rel="stylesheet" />
	
	<!-- JS -->
	<script type='text/javascript' src='<%=request.getContextPath()%>/sys/scripts/datetimepicker_css.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/VmsDwr.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>

	<!-- jQuery -->
	<script type='text/javascript' src='<%=request.getContextPath()%>/sys/scripts/jquery-1.6.min.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/sys/scripts/jquery-ui-1.8.16.custom.min.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/sys/scripts/jquery.validationEngine.js'></script>	
	<script type='text/javascript' src='<%=request.getContextPath()%>/sys/scripts/languages/jquery.validationEngine-en.js'></script>
	
	<!--[if lte IE 6]>
	<script type="text/javascript" src="<%=request.getContextPath()%>/sys/scripts/supersleight.js"></script>
	<![endif]-->
<decorator:head />
</head>

<body>
    
	<div id="wrapper">
		<div id="wrap-top">
<!--			<div id="loginInfo">
				<ul>
					<li class="last"><a href="<%=request.getContextPath()%>/logout.html">Logout</a></li>
				</ul>
			</div>-->
		</div>
		<!-- end of wrap-top -->
		<div id="header">
			<h1><a href="<%=request.getContextPath()%>/common/welcome.html">Volunteer Management System</a></h1>
		</div>
		<!-- end of header -->
		<div id="container">
			<!-- end of leftCol -->
			<div id="main">
				<decorator:body />
			</div>
			<!-- end of main -->
		</div>
		<!-- end of container -->
	</div>

</body>
</html>
