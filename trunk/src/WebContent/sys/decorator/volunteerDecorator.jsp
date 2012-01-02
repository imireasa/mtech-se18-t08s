<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><decorator:title default="Volunteer Management System" />
</title>

<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="icon" href="<%=request.getContextPath()%>/sys/favicon.ico"
	type="image/x-icon" />
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/sys/images/favicon.ico"
	type="image/x-icon" />

<link href="<%=request.getContextPath()%>/sys/css/global.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/sys/css/reset.css"
	rel="stylesheet" type="text/css" />
<script type='text/javascript' 
        src='<%=request.getContextPath()%>/sys/scripts/datetimepicker_css.js'></script>
        
<!--[if lte IE 6]>
<script type="text/javascript" src="<%=request.getContextPath()%>/sys/scripts/supersleight.js"></script>
<![endif]-->
<decorator:head />
</head>

<body>
	<div id="wrapper">
		<div id="wrap-top">
			<div id="loginInfo">
				<ul>
					<li class="last"><a href="#">Logout</a></li>
				</ul>
			</div>
		</div>
		<!-- end of wrap-top -->
		<div id="header">
			<h1><a href="<%=request.getContextPath()%>/common/welcome.html">Volunteer Management System</a></h1>
		</div>
		<!-- end of header -->
		<div id="container">
			<div id="leftCol">
				<ul id="info">
					<li><h3>
							Chris Goh<br />Volunteer
						</h3></li>
				</ul>
				<menu:useMenuDisplayer name="CSSListMenu" id="menuProject"
					permissions="menuPermissionAdapter">
					<menu:displayMenu name="projects" />
				</menu:useMenuDisplayer>
				<menu:useMenuDisplayer name="CSSListMenu" id="menuAccount"
					permissions="menuPermissionAdapter">
					<menu:displayMenu name="account" />
				</menu:useMenuDisplayer>
			</div>
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
