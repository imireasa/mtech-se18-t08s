<%--
    Document   : decorator
    Created on : Dec 13, 2009, 10:54:53 AM
    Author     : Zaw
--%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<title><decorator:title default="VMCS Administrator" /></title>

<!-- Standard reset, fonts and grids -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/sys/vms/yui/build/reset-fonts-grids/reset-fonts-grids.css">

<!-- CSS for Menu -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/sys/vms/yui/build/menu/assets/skins/sam/menu.css">

<!-- Page-specific styles -->
<style type="text/css">
div.yui-b p {
	margin: 0 0 .5em 0;
	color: #999;
}

div.yui-b p strong {
	font-weight: bold;
	color: #000;
}

div.yui-b p em {
	color: #000;
}

h1 {
	font-weight: bold;
	margin: 0 0 1em 0;
	padding: .25em .5em;
	background-color: #ccc;
}

#productsandservices {
	position: static;
}

#productsandservices .yuimenuitemlabel {
	_zoom: 1;
}

#productsandservices .yuimenu .yuimenuitemlabel {
	_zoom: normal;
}
</style>


<!-- Dependency source files -->

<script type="text/javascript"
	src="<%=request.getContextPath()%>/sys/vms/yui/build/yahoo-dom-event/yahoo-dom-event.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/sys/vms/yui/build/animation/animation.js"></script>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/sys/vms/yui/build/container/container_core.js"></script>


<!-- Menu source file -->

<script type="text/javascript"
	src="<%=request.getContextPath()%>/sys/vms/yui/build/menu/menu.js"></script>


<!-- Page-specific script -->

<script type="text/javascript">
	YAHOO.util.Event.onContentReady("productsandservices", function() {
		var oMenu = new YAHOO.widget.Menu("productsandservices", {
			position : "static",
			hidedelay : 750,
			lazyload : true,
			effect : {
				effect : YAHOO.widget.ContainerEffect.FADE,
				duration : 0.25
			}
		});
		oMenu.render();

	});
</script>

<decorator:head />
</head>
<body class="yui-skin-sam" id="yahoo-com">

	<div id="doc" class="yui-t1">
		<div id="hd">
			<h1>Volunteer Management System</h1>
		</div>
		<div id="bd">
			<!-- start: primary column from outer template -->
			<div id="yui-main">
				<div class="yui-b">
					<decorator:body />
				</div>
			</div>
			<!-- start: secondary column from outer template -->

			<div class="yui-b">

				<div id="productsandservices" class="yuimenu">
					<div class="bd">
						<ul class="first-of-type">
							<li class="yuimenuitem first-of-type"><a
								class="yuimenuitemlabel" href="#communication">Staff
									Management</a>
								<div id="staff" class="yuimenu">
									<div class="bd">
										<ul>
											<li class="yuimenuitem"><a class="yuimenuitemlabel"
												href="http://360.yahoo.com">Search Staff</a>
											</li>
											<li class="yuimenuitem"><a class="yuimenuitemlabel"
												href="http://alerts.yahoo.com">Create Staff&#176;</a>
											</li>
											<li class="yuimenuitem"><a class="yuimenuitemlabel"
												href="http://avatars.yahoo.com">Update Staff</a>
											</li>
											<li class="yuimenuitem"><a class="yuimenuitemlabel"
												href="http://groups.yahoo.com">Delete</a>
											</li>
										</ul>
									</div>
								</div></li>
							<li class="yuimenuitem first-of-type"><a
								class="yuimenuitemlabel" href="#communication">Project
									Management</a>
								<div id="project" class="yuimenu">
									<div class="bd">
										<ul>
											<li class="yuimenuitem"><a class="yuimenuitemlabel"
												href="http://360.yahoo.com">Search Project</a></li>
											<li class="yuimenuitem"><a class="yuimenuitemlabel"
												href="http://alerts.yahoo.com">Create Project</a></li>
											<li class="yuimenuitem"><a class="yuimenuitemlabel"
												href="http://avatars.yahoo.com">Update Project</a></li>
											<li class="yuimenuitem"><a class="yuimenuitemlabel"
												href="http://groups.yahoo.com">Delete Project</a></li>
											<li class="yuimenuitem"><a class="yuimenuitemlabel"
												href="http://groups.yahoo.com">Search Volunteer</a></li>
											<li class="yuimenuitem"><a class="yuimenuitemlabel"
												href="http://groups.yahoo.com">Register Project</a></li>
										</ul>
									</div>
								</div>
							</li>
							<li class="yuimenuitem first-of-type"><a
								class="yuimenuitemlabel" href="#communication">Volunteer
									Management</a>
								<div id="volunteer" class="yuimenu">
									<div class="bd">
										<ul>
											<li class="yuimenuitem"><a class="yuimenuitemlabel"
												href="http://360.yahoo.com">Search Volunteer</a></li>
											<li class="yuimenuitem"><a class="yuimenuitemlabel"
												href="http://alerts.yahoo.com">Create Volunteer</a></li>
											<li class="yuimenuitem"><a class="yuimenuitemlabel"
												href="http://avatars.yahoo.com">Update Volunteer</a></li>
											<li class="yuimenuitem"><a class="yuimenuitemlabel"
												href="http://groups.yahoo.com">Delete Volunteer</a></li>
										</ul>
									</div>
								</div>
							</li>
							<li class="yuimenuitem first-of-type"><a
								class="yuimenuitemlabel" href="#communication">System
									Management</a>
							</li>
							<li class="yuimenuitem first-of-type"><a
								class="yuimenuitemlabel" href="#communication">Log Out</a>
							</li>
						</ul>
					</div>
				</div>

			</div>
			<!-- end: secondary column from outer template -->

		</div>
		<div id="ft">

			<p>FOOTER: Lorem ipsum dolor sit amet, consectetuer adipiscing
				elit. Maecenas sit amet metus. Nunc quam elit, posuere nec, auctor
				in, rhoncus quis, dui. Aliquam erat volutpat. Ut dignissim, massa
				sit amet dignissim cursus, quam lacus feugiat.</p>

		</div>
	</div>

</body>
</html>