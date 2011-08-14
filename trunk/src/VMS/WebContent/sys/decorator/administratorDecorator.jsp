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
<title><decorator:title default="VMCS Administrator" />
</title>

<decorator:head />
</head>
<body>

	<div id="doc">
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
												href="http://360.yahoo.com">Search Staff</a></li>
											<li class="yuimenuitem"><a class="yuimenuitemlabel"
												href="http://alerts.yahoo.com">Create Staff&#176;</a></li>
											<li class="yuimenuitem"><a class="yuimenuitemlabel"
												href="http://avatars.yahoo.com">Update Staff</a></li>
											<li class="yuimenuitem"><a class="yuimenuitemlabel"
												href="http://groups.yahoo.com">Delete</a></li>
										</ul>
									</div>
								</div>
							</li>
							<li class="yuimenuitem first-of-type"><a
								class="yuimenuitemlabel" href="#communication">Project
									Management</a>
								<div id="project" class="yuimenu">
									<div class="bd">
										<ul>
											<li class="yuimenuitem"><a class="yuimenuitemlabel"
												href="http://360.yahoo.com">Search Project</a>
											</li>
											<li class="yuimenuitem"><a class="yuimenuitemlabel"
												href="http://alerts.yahoo.com">Create Project</a>
											</li>
											<li class="yuimenuitem"><a class="yuimenuitemlabel"
												href="http://avatars.yahoo.com">Update Project</a>
											</li>
											<li class="yuimenuitem"><a class="yuimenuitemlabel"
												href="http://groups.yahoo.com">Delete Project</a>
											</li>
											<li class="yuimenuitem"><a class="yuimenuitemlabel"
												href="<%=request.getContextPath()%>/admin/member/list.html">Search
													Member</a>
											</li>
											<li class="yuimenuitem"><a class="yuimenuitemlabel"
												href="<%=request.getContextPath()%>/admin/project/assignPrjMemberRole.html">Assign
													Project Member</a>
											</li>
										</ul>
									</div>
								</div></li>
							<li class="yuimenuitem first-of-type"><a
								class="yuimenuitemlabel" href="#communication">Volunteer
									Management</a>
								<div id="volunteer" class="yuimenu">
									<div class="bd">
										<ul>
											<li class="yuimenuitem"><a class="yuimenuitemlabel"
												href="http://360.yahoo.com">Search Volunteer</a>
											</li>
											<li class="yuimenuitem"><a class="yuimenuitemlabel"
												href="http://alerts.yahoo.com">Create Volunteer</a>
											</li>
											<li class="yuimenuitem"><a class="yuimenuitemlabel"
												href="http://avatars.yahoo.com">Update Volunteer</a>
											</li>
											<li class="yuimenuitem"><a class="yuimenuitemlabel"
												href="http://groups.yahoo.com">Delete Volunteer</a>
											</li>
										</ul>
									</div>
								</div></li>
							<li class="yuimenuitem first-of-type"><a
								class="yuimenuitemlabel" href="#communication">Report</a>
								<div id="report" class="yuimenu">
									<div class="bd">
										<ul>
											<li class="yuimenuitem"><a class="yuimenuitemlabel"
												href="<%=request.getContextPath()%>/report/volunteer/generate.html">View
													Report</a>
											</li>
										</ul>
									</div>
								</div></li>
							<li class="yuimenuitem first-of-type"><a
								class="yuimenuitemlabel" href="#communication">System
									Management</a></li>
							<li class="yuimenuitem first-of-type"><a
								class="yuimenuitemlabel" href="#communication">Log Out</a></li>
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