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
        <script type="text/javascript" src="<%=request.getContextPath()%>/sys/scripts/v02/supersleight.js"></script>
        <![endif]-->
<!--        <script type="text/javascript">
            $(document).ready(function() {
                $(this).find('ul').each(function(){
                    // cache jquery object
                    var current = $(this);
                    // check for sub levels and value
                    if(current.children().size() == 0 && current.text().trim()== "") {
                        //no child in this UL.
                        current.hide();
                    }
     
                });

            });
        </script>-->
        <decorator:head />
    </head>

    <body>
       	<div id="wrapper">
            <div id="wrap-top">
                <div id="loginInfo">
                    <ul>
                        <li class="last">
                            <img src="/VMS/sys/images/icons/door_out.png"/>
                            <a href="<%=request.getContextPath()%>/logout.html">Logout</a>
                        </li>
                    </ul>
                </div>
            </div>
            <!-- end of wrap-top -->
            <div id="header">
                
				<h1>
					<a href="<%=request.getContextPath()%>/common/welcome.html" >
						<img src="/VMS/sys/images/v02/logo-hand-mini.png" width="50" height="68" border="0" />

					</a><span id="logoText">Volunteer Management System<span>
				</h1>
				
                            </div>
                            <!-- end of header -->
                            <div id="container">
                                <div id="leftCol">
                                    <ul id="info">

                                        <li><h3>Welcome</h3></li>
                                    </ul>
                                    <menu:useMenuDisplayer name="CSSListMenu" id="Project"
                                                           permissions="menuPermissionAdapter">
                                        <menu:displayMenu name="projects" />
                                    </menu:useMenuDisplayer>
                                    <menu:useMenuDisplayer name="CSSListMenu" id="Account"
                                                           permissions="menuPermissionAdapter">
                                        <menu:displayMenu name="account" />
                                    </menu:useMenuDisplayer>
                                    <menu:useMenuDisplayer name="CSSListMenu" id="cert"
                                                           permissions="menuPermissionAdapter">
                                        <menu:displayMenu name="certificate" />
                                    </menu:useMenuDisplayer>
                                </div>
                                <!-- end of leftCol -->
                                <div id="main">
                                    <decorator:body />
                                </div>
                                <div id="footer">Copyright &copy; 2012 Volunteer Management System (VMS). All rights reserved.</div>
                                <!-- end of main -->
                            </div>
                            <!-- end of container -->
                            </div>

                            </body>
                            </html>
