<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>

<body>
<head>
    <script type='text/javascript'
    src='<%=request.getContextPath()%>/dwr/interface/VmsDwr.js'></script>
    <script type='text/javascript'
    src='<%=request.getContextPath()%>/dwr/engine.js'></script>
    <script type='text/javascript' 
    src='<%=request.getContextPath()%>/sys/scripts/datetimepicker.js'></script>

    <link type="text/css"
          href="<%=request.getContextPath()%>/sys/css/paging.css"
          rel="stylesheet" />

    <style> 
        .error{ color:red;}  
        .info{ color:blue;}  
    </style>

    <script type="text/javascript">
        var defProjName = 'Please select...';

        window.onload = init;

        function init() {
		
        }


        function submit(val, name) {
            var projectId = document.getElementById("projectId");
            var projectName = document.getElementById("projectName");
            var searchMemberForm = document.getElementById("searchMemberForm");

            projectId.value = val;
            projectName.value = name;
            searchMemberForm.submit();
        }
    </script>
</head>
<body>
    <h2>Register Volunteer</h2>
    <div id="breadcrumb">
        <a href="#">Home</a> / <a href="#">Volunteer</a> / Register Volunteer
    </div>
    <div class="query">
        <c:if test="${not empty errors}"> 
            <div class="error">
                <c:forEach var="error"items="${errors}">  
                    <c:out value="${error}" escapeXml="false"/><br/>
                </c:forEach>
            </div>
        </c:if>

        <form:form name="registerVolunteer" method="post"
                   commandName="command" 
                   action="saveVolunteer.html">
            <table width="400" class="proj-table">
                <tr>
                    <th align="left">
                        <fmt:message key="message.common.loginid.label"/>
                    </th>
                    <th>:</th>
                    <th align="left">       
                        <spring:bind path="command.loginId">  
                            <form:input path="loginId"/>
                        </spring:bind>
                        <form:errors path="loginId" cssClass="error"/>                        
                    </th>
                </tr>	
                <tr>
                    <th width="133" align="left">Title</th>
                    <th width="10">:</th>
                    <th width="246" align="left">
                        <form:select path="title">
                            <c:forEach items="${titalList}" var="item" varStatus="status">
                        <option value="'${item.cdId}'">${item.val}</option>
                    </c:forEach>
                </form:select>                        
                <form:errors path="title" cssClass="error"/>
                </th>
                </tr>		
                <tr>
                    <th align="left">Name</th>
                    <th>:</th>
                    <th align="left">       
                        <spring:bind path="command.nme">  
                            <form:input path="nme"/>
                        </spring:bind>
                        <form:errors path="nme" cssClass="error"/>                        
                    </th>
                </tr>		
                <tr>
                    <th align="left">Email</th>
                    <th>:</th>
                    <th align="left">
                        <form:input path="email"/>
                        <form:errors path="email" cssClass="error"/>
                    </th>
                </tr>		
                <tr>
                    <th align="left">Password</th>
                    <th>:</th>
                    <th align="left">
                        <form:password path="pwd"/>
                        <form:errors path="pwd" cssClass="error"/>
                    </th>
                </tr>		
                <tr>
                    <th align="left">Confirm Password</th>
                    <th>:</th>
                    <th align="left">
                        <form:password path="cfpwd"/>
                        <form:errors path="cfpwd" cssClass="error"/>
                    </th>
                </tr>		
                <tr>
                    <th align="left">Address</th>
                    <th>:</th>
                    <th align="left"><label for="textarea"></label>
                        <form:textarea path="addr" cols="45" rows="5"></form:textarea>
                        <form:errors path="addr" cssClass="error"/>
                    </th>
                </tr>		
                <tr>
                    <th align="left">Postal Code</th>
                    <th>:</th>
                    <th align="left">
                        <form:input path="postCd"/>
                        <form:errors path="postCd" cssClass="error"/>
                    </th>
                </tr>		
                <tr>
                    <th align="left">Country</th>
                    <th>:</th>
                    <th align="left">
                        <form:select path="ctryCd">
                            <c:forEach items="${countryList}" var="item" varStatus="status">
                        <option value="${item.cdId}">${item.val}</option>
                    </c:forEach>
                </form:select>
                <form:errors path="ctryCd" cssClass="error"/>
                </th>
                </tr>		
                <tr>
                    <th align="left">Mobile</th>
                    <th>:</th>
                    <th align="left">
                        <form:input path="mobile"/>
                        <form:errors path="mobile" cssClass="error"/>
                    </th>
                </tr>		
                <tr>
                    <th align="left">Date Of Birth</th>
                    <th>:</th>
                    <th align="left">
                        <form:input path="dob" cssClass="Date" maxlength="25" size="25"/>
                        <form:errors path="dob" cssClass="error"/>
                        <img src="<%=request.getContextPath()%>/sys/images/cal.gif" onClick="javascript:NewCal('dob')" style="cursor:pointer"/>
                    </th>
                </tr>		
                <tr>
                    <th align="left">Intrest</th>
                    <th>:</th>
                    <th align="left">
                        <form:textarea path="intrst" cols="45" rows="5"></form:textarea>
                        <form:errors path="intrst" cssClass="error"/>
                    </th>
                </tr>		
                <tr>
                    <th align="left">Skill Set</th>
                    <th>:</th>
                    <th align="left">
                        <form:textarea path="skillSet" cols="45" rows="5"></form:textarea>
                        <form:errors path="skillSet" cssClass="error"/>
                    </th>
                </tr>	
                <tr>
                    <th align="left">Qualification Atten:</th>
                    <th>:</th>
                    <th align="left">
                        <form:textarea path="qualAtt" cols="45" rows="5"></form:textarea>
                        <form:errors path="qualAtt" cssClass="error"/>
                    </th>
                </tr>
                <tr>
                    <th colspan="3" ><input type="submit" name="button" id="button" value="Submit"></th>
                </tr>
            </table>
        </form:form>
    </div>
</body>