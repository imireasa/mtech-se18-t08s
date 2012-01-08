<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>
<html xmlns="http://www.w3.org/1999/xhtml">
        <head>
                <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
                <title><decorator:title default="Volunteer Management System" />
                </title>

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
                                <div id="loginInfo">
                                        <ul>
                                                <li><a href="<%=request.getContextPath()%>/admin/volunteer/registerVolunteer.html">My Account</a></li>
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
                                                <li><h3><c:out value="${userName}"/><br /></h3></li>
                                        </ul>
                                        <ul id="membership">
                                                <li class="header">Membership</li>
                                                <li>
                                                        <a href="<%=request.getContextPath()%>/admin/volunteer/registerVolunteer.html">
                                                                Register Member
                                                        </a>
                                                </li>
                                                <li>
                                                        <a href="<%=request.getContextPath()%>/admin/volunteer/updateVolunteer.html">
                                                                Update Member
                                                        </a>
                                                </li>
                                                <li>
                                                        <a href="<%=request.getContextPath()%>/admin/member/searchProjectMember.html">
                                                                Search Member
                                                        </a>
                                                </li>
                                                <li><a href="#">Manage Profile</a></li>
                                                <li><a href="#">Review Request</a></li>
                                        </ul>
                                        <ul id="project">
                                                <li class="header">Project</li>
                                                <li><a href="#">New</a></li>
                                                <li><a href="#">Manage</a></li>
                                                <li><a
                                                                href="<%=request.getContextPath()%>/admin/project/assignPrjMemberRole.html">Assign
                                                                Member Role</a></li>
                                                                  <li><a
                                                                href="<%=request.getContextPath()%>/project/browseProjectFeedback.html">
                                                                Search Feedback</a></li>
                                                                 <li><a
                                                                href="<%=request.getContextPath()%>/project/proposeNewProject.html">
                                                                Propose New Project</a></li>
                                                                <li><a
                                                                href="<%=request.getContextPath()%>/project/browseProjectProposal.html">
                                                                Browse Project Proposal</a></li>
                                                <li><a href="<%=request.getContextPath()%>/admin/project/createProject.html">Create Project</a></li>
                                                <li><a href="<%=request.getContextPath()%>/admin/project/updateProject.html">Update Project</a></li>
                                                <li><a href="<%=request.getContextPath()%>/admin/project/viewProject.html">View Project</a></li>
                                                <li><a href="<%=request.getContextPath()%>/admin/project/viewProjectInterest.html">View Project Interest</a></li>
                                        </ul>
                                        <ul id="cert">
                                                <li class="header">Certificate</li>
                                                <li><a href="#">Request Cert</a></li>
                                                <li><a
                                                                href="<%=request.getContextPath()%>/admin/reports/generateCertificate.html">Generate
                                                                Cert (PDF)</a></li>
                                               
                                        </ul>
                                        <ul id="itinerary">
                                                <li class="header">Itinerary</</li>
                                                <li><a href="#">Prepare Plan</a></li>
                                                <li><a href="#">Review Plan</a></li>
                                        </ul>
                                         <menu:useMenuDisplayer name="CSSListMenu" id="menuCert"
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
