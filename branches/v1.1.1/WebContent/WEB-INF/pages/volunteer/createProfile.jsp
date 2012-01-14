<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>

<head>
    <script type="text/javascript">
        var defProjName = 'Please select...';

        
        
        $(document).ready(function(){            
            $("#command").validationEngine();
        });
    
        function init() {                
        }
        
        function checkUserLoginId(){
            var loginId = document.getElementById("loginId").value;
            VmsDwr.isUserLoginIdExist(loginId,function(result){
                if(result){
                    alert(loginId + " exist");
                }else{
                    alert(loginId + " doesn't exist");
                }                            
            });
        }
    </script>
</head>
<body>
    <h2><fmt:message key="message.volunteerManagement.registerVolunteer.label"/></h2>
    <div id="breadcrumb">
        <a href="<%=request.getContextPath()%>/"><fmt:message key="message.security.pageHeader.label"/></a> /
        <fmt:message key="message.volunteerManagement.registerVolunteer.label"/>
    </div>

    <div class="query">
        <c:if test="${not empty msg}">
            <div class="infoblock">
                <c:out value="${msg}" escapeXml="false" />
                <br />
            </div>
        </c:if>
        <c:if test="${not empty errors}">
            <div class="errorblock">
                <c:out value="Error:" />
                <c:forEach var="error" items="${errors}">
                    <c:out value="${error}" escapeXml="false" />
                    <br />
                </c:forEach>
            </div>
        </c:if>

        <form:form name="registerVolunteer" method="post"
                   commandName="command" 
                   action="registerVolunteer.html">
            <form:hidden path="cmdType"/>
            <table class="query-table">
                <tr>
                    <td colspan="3">
                        <form:errors path="*" cssClass="error" element="div" />
                    </td>
                </tr>
                <tr>
                    <td><fmt:message key="message.common.loginid.label"/> <span class="mandatory"><fmt:message key="message.common.symbol.mandatory.label" /> </span></td>
                    <td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                    <td>
                        <form:input path="loginId" cssClass="validate[required]"/>
                        <form:errors path="loginId" cssClass="error"/> 
                        <input type="button" name="checkButton" value="<fmt:message key="message.common.check.label" />" onclick="checkUserLoginId()"/>
                    </td>
                </tr>	
                <tr>
                    <td><fmt:message key="message.common.title.label"/> <span class="mandatory"><fmt:message key="message.common.symbol.mandatory.label" /> </span></td>
                    <td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                    <td>
                        <form:select path="title">
                            <form:options items="${titleList}" itemValue="cdId" itemLabel="val"/>
                        </form:select>
                        <form:errors path="title" cssClass="error"/>
                    </td>
                </tr>		
                <tr>
                    <td> <fmt:message key="message.common.name.label"/> <span class="mandatory"><fmt:message key="message.common.symbol.mandatory.label" /> </span></td>
                    <td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                    <td>       
                        <form:input path="nme" cssClass="validate[required] "/>
                        <form:errors path="nme" cssClass="error"/>                        
                    </td>
                </tr>		
                <tr>
                    <td><fmt:message key="message.common.email.label"/> <span class="mandatory"><fmt:message key="message.common.symbol.mandatory.label" /> </span></td>
                    <td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                    <td>
                        <form:input path="email" cssClass="validate[required]"/>
                        <form:errors path="email" cssClass="error"/>
                    </td>
                </tr>		
                <tr>
                    <td><fmt:message key="message.volunteerManagement.password.label"/> <span class="mandatory"><fmt:message key="message.common.symbol.mandatory.label" /> </span></td>
                    <td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                    <td>
                        <form:password path="pwd" cssClass="validate[required] "/>
                        <form:errors path="pwd" cssClass="error"/>
                    </td>
                </tr>		
                <tr>
                    <td><fmt:message key="message.volunteerManagement.cfgpassword.label"/> <span class="mandatory"><fmt:message key="message.common.symbol.mandatory.label" /> </span></td>
                    <td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                    <td>
                        <form:password path="cfpwd" cssClass="validate[required,equals[pwd]] "/>
                        <form:errors path="cfpwd" cssClass="error"/>
                    </td>
                </tr>		
                <tr>
                    <td><fmt:message key="message.common.address.label"/></td>
                    <td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                    <td><label for="textarea"></label>
                        <form:textarea path="addr" cssClass="validate[optional,maxSize[255]] " cols="45" rows="5"></form:textarea>
                        <form:errors path="addr" cssClass="error"/>
                    </td>
                </tr>		
                <tr>
                    <td><fmt:message key="message.common.postCode.label"/></td>
                    <td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                    <td>
                        <form:input path="postCd"  cssClass="validate[optional,custom[integer],maxSize[6]] "/>
                        <form:errors path="postCd" cssClass="error"/>
                    </td>
                </tr>		
                <tr>
                    <td><fmt:message key="message.common.country.label"/></td>
                    <td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                    <td>
                        <form:select path="ctryCd">
                            <form:options items="${countryList}" itemValue="cdId" itemLabel="val"/>
                        </form:select>
                        <form:errors path="ctryCd" cssClass="error"/>
                    </td>
                </tr>		
                <tr>
                    <td><fmt:message key="message.common.mobile.label"/></td>
                    <td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                    <td>
                        <form:input path="mobile" cssClass="validate[optional,maxSize[10]] "/>
                        <form:errors path="mobile" cssClass="error"/>
                    </td>
                </tr>		
                <tr>
                    <td><fmt:message key="message.common.dateOfBirth.label"/></td>
                    <td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                    <td>
                        <form:input path="dob" cssClass="validate[optional] " maxlength="25" size="25"/>
                        <form:errors path="dob" cssClass="error"/>
                        <img src="<%=request.getContextPath()%>/sys/images/cal.gif" onClick="javascript:NewCssCal('dob','ddMMyyyy')" style="cursor:pointer"/>
                    </td>
                </tr>		
                <tr>
                    <td><fmt:message key="message.volunteerManagement.intrest.label"/></td>
                    <td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                    <td>
                        <form:textarea path="intrst" cssClass="validate[optional,maxSize[255]]" cols="45" rows="5"></form:textarea>
                        <form:errors path="intrst" cssClass="error"/>
                    </td>
                </tr>		
                <tr>
                    <td><fmt:message key="message.volunteerManagement.skillSet.label"/></td>
                    <td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                    <td>
                        <form:textarea path="skillSet" cssClass="validate[optional,maxSize[255]]" cols="45" rows="5"></form:textarea>
                        <form:errors path="skillSet" cssClass="error"/>
                    </td>
                </tr>	
                <tr>
                    <td><fmt:message key="message.volunteerManagement.qualifation.label"/></td>
                    <td><fmt:message key="message.common.symbol.afterLabel.label" /></td>
                    <td>
                        <form:textarea path="qualAtt" cssClass="validate[optional,maxSize[255]]" cols="45" rows="5"></form:textarea>
                        <form:errors path="qualAtt" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"></td>
                    <td ><input type="submit" name="saveButton" id="saveButton" value="<fmt:message key="message.common.save.button"/>"></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>