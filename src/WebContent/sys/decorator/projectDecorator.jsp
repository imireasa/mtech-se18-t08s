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

<link rel="icon" href="<%=request.getContextPath()%>/sys/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="<%=request.getContextPath()%>/sys/images/favicon.ico" type="image/x-icon" />
<link href="<%=request.getContextPath()%>/sys/css/global.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/sys/css/reset.css" rel="stylesheet" type="text/css" />
<link type="text/css" href="<%=request.getContextPath()%>/sys/css/paging.css" rel="stylesheet" />

<script type='text/javascript' src='<%=request.getContextPath()%>/sys/scripts/datetimepicker_css.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/VmsDwr.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/sys/scripts/jquery-1.7.1.min.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/sys/scripts/jquery-ui-1.8.16.custom.min.js'></script>
        
<!--[if lte IE 6]>
<script type="text/javascript" src="<%=request.getContextPath()%>/sys/scripts/supersleight.js"></script>
<![endif]-->
<script type="text/javascript">
$(document).ready(function() {
	$(this).find('ul').each(function(){
        // cache jquery object
        var current = $(this);
        // check for sub levels and value
        if(current.children().size() == 0 && current.text().trim()== "") {
           //no child in this UL.
               alert("up down left right A B A B start.");
            current.hide();
            alert("OMG! it works! the empty section is gone!");
        }
     
    });

 });
</script>
<decorator:head />
</head>

<body>
	<div id="wrapper">
		<div id="wrap-top">
			<div id="loginInfo">
				<ul>
					<li class="last"><a href="<%=request.getContextPath()%>/logout.html">Logout</a></li>
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
				
					<li><h3><%=((UserSessionInfoVo)(request.getSession().getAttribute("user_session_info"))).getName()%><br /></h3></li>
				</ul>
				<menu:useMenuDisplayer name="CSSListMenu" id="menuProject"
					permissions="menuPermissionAdapter">
					<menu:displayMenu name="projects" />
				</menu:useMenuDisplayer>
				<menu:useMenuDisplayer name="CSSListMenu" id="menuAccount"
					permissions="menuPermissionAdapter">
					<menu:displayMenu name="account" />
				</menu:useMenuDisplayer>
				<menu:useMenuDisplayer name="CSSListMenu" id="menuCertificate"
                   permissions="menuPermissionAdapter">
                   <menu:displayMenu name="certificate" />
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
