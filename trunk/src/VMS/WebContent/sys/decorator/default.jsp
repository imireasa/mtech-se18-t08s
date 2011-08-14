<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Volunteer Management System</title>

<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="icon" href="<%=request.getContextPath()%>/sys/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="favicon.ico" type="<%=request.getContextPath()%>/sys/image/x-icon" /> 

<link href="<%=request.getContextPath()%>/sys/css/global.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/sys/css/reset.css" rel="stylesheet" type="text/css" />

<!--[if lte IE 6]>
<script type="text/javascript" src="<%=request.getContextPath()%>/sys/js/supersleight.js"></script>
<![endif]-->

</head>

<body>
<div id="wrapper">
	<div id="wrap-top">
    	<div id="loginInfo">
        	<ul>
            <li><a href="#">My Account</a></li>
            <li class="last"><a href="#">Logout</a></li>
            </ul>
        </div>
    </div><!-- end of wrap-top -->
    <div id="header">
    	<h1>Volunteer Management System</h1>
    </div><!-- end of header -->
    <div id="container">
    	<div id="leftCol">
        	<ul id="info">
            	<li><h3>Chris Goh<br />Project Manager</h3></li>
                <li>Last login : 20/07/2011 15:40</li>
            </ul>
        	<ul id="membership">
            	<li class="header">Membership</li>
                <li><a href="#">Search Member</a></li>
                <li><a href="#">Manage Profile</a></li>
                <li><a href="#">Review Request</a></li>
            </ul>
        	<ul id="project">
            	<li class="header">Project</li>
                <li><a href="#">New</a></li>
                <li><a href="#">Manage</a></li>
            </ul>
        	<ul id="cert">
            	<li class="header">Certificate</li>
                <li><a href="#">Request Cert</a></li>
                <li><a href="#">Generate Cert</a></li>
            </ul>
        	<ul id="itinerary">
            	<li class="header">Itinerary</</li>
                <li><a href="#">Prepare Plan</a></li>
                <li><a href="#">Review Plan</a></li>
            </ul>
        </div><!-- end of leftCol -->
        <div id="main">
        	<h2>Search Member</h2>
            <div id="breadcrumb">Home / Project / Search Member</div>
            <div class="query">
            	<p><b>Project name</b> <input name="" type="text" value="Please select..." />
                  <input type="submit" name="Search" id="Search" value="Search" class="button" />
       	    </div><!-- end of query -->
            <table width="300" class="proj-table">
            	<tr><th>#</th><th>Project</th></tr>
            	<tr><td>1</td><td><a href="#">iHope 2011</a></td></tr>
            	<tr><td>2</td><td><a href="#">Guardian of Youth</a></td></tr>
            	<tr><td>3</td><td><a href="#">iHope 2012</a></td></tr>
            </table>
            <table width="700" class="proj-table">
            	<tr>
            	  <td colspan="5"><b>iHOPE 2011 Project<br />
           	      Member list</b></td>
           	  </tr>
            	<tr>
            	  <th>ID</th>
            	  <th>Name</th>
            	  <th>Role</th>
            	  <th>Contact Number</th>
            	  <th>Email</th>
            	</tr>
            	<tr><td>1</td>
            	  <td><a href="#">Johnathan Mirks</a></td>
            	  <td>Volunteer</td>
            	  <td>N/A</td>
            	  <td>j.tan@gmail.com</td>
            	</tr>
            	<tr><td>2</td>
            	  <td><a href="#">John Ng</a></td>
            	  <td>Project Manager</td>
            	  <td>9888 1586</td>
            	  <td>N/A</td>
            	</tr>
            	<tr><td>3</td>
            	  <td><a href="#">John Kearns</a></td>
            	  <td>Staff</td>
            	  <td>N/A</td>
            	  <td>N/A</td>
            	</tr>
            </table>
            <div class="pagination">[1] [2] [3] ... [5] [6]</div>
        </div><!-- end of main -->
    </div><!-- end of container -->
</div>

</body>
</html>
