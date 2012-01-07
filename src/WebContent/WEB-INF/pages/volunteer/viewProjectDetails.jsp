<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tab" uri="http://ditchnet.org/jsp-tabs-taglib"%>


<head>

    <link type="text/css"
          href="<%=request.getContextPath()%>/sys/css/paging.css"
          rel="stylesheet" />
    <tab:tabConfig/>



</head>
<body>
    <h2><fmt:message key="message.projectManagement.viewProject.label"/></h2>
    <div id="breadcrumb">
        <a href="#">Home</a> / <a href="#">Volunteer</a> / <a href="#">Project
            Details</a>
    </div>

    <div class="query">
        <c:if test="${not empty riMsg}"> 
            <div class="infoblock">
                <c:out value="${riMsg}" escapeXml="false"/><br/>
            </div>
        </c:if>

        <form:form name="viewProjectDetails" method="post"
                   commandName="projectInfo" action="raiseInterest.html">
            <table class="query-table">
                <tr>
                    <td><fmt:message key="message.projectManagement.projectName.label"/></td>

                    <td>${projectVo.name}</td>
                </tr>
                <tr>
                    <td><fmt:message key="message.common.description.label"/>:
                    </td>
                    <td>${projectVo.desc}</td>
                </tr>
                <tr>
                    <td><fmt:message key="message.common.startDate.label"/></td>
                    <td>${projectVo.strDte}</td>
                </tr>
                <tr>
                    <td><fmt:message key="message.common.status.label"/></td>
                    <td>${projectVo.stsCd}</td>
                </tr>
                <tr>
                    <td><fmt:message key="message.common.location.label"/></td>
                    <td>${projectVo.loc}</td>
                </tr>
                <tr>
                    <td><fmt:message key="message.common.country.label"/></td>
                    <td>${projectVo.ctryCd}</td>
                </tr>

                <c:if test="${projectVo.stsCd != 'Close'}">
                    <tr>
                        <td><input type="submit" name="btn_RaiseProjectInterest"
                                   id="btn_RaiseProjectInterest" value="Raise Project Interest"></td>
                    </tr>



                </c:if>

            </table>


        </form:form>
    </div>
    <tab:tabContainer id="tab-container">

        <tab:tabPane id="member" tabTitle="Project Members">
            <form:form name="memberDetails" method="post"
                       commandName="projectInfo" action="requestCertificate.html">
                <table class="proj-table">
                    <tr>
                        <th><fmt:message key="message.common.loginid.label"/></th>
                        <th><fmt:message key="message.common.role.label"/></th>

                    </tr>
                    <c:forEach items="${memberList}" var="item" varStatus="status">
                        <tr>
                            <td>${item.usrLoginId}</td>
                            <td>${item.roleCd}</td>



                            <c:if test="${item.usrLoginId ==projectVo.loginId}">					
                                <td><input type="submit" name="btn_RequestCertificate" 
                                           id="btn_RequestCertificate" value="Request for Certificate"></td>
                                </c:if>

                        </tr>
                    </c:forEach>
                </table>

            </form:form>


        </tab:tabPane>

        <tab:tabPane id="experience" tabTitle="Experience">
          <span>
            <table class="proj-table">
                <tr>
                    <th><fmt:message key="message.common.id.label"/></th>
                    <th><fmt:message key="message.common.creator.label"/></th>
                    <th><fmt:message key="message.common.content.label"/></th>
                </tr>
                <c:forEach items="${experienceList}" var="item" varStatus="status">
                    <tr>
                        <td>${item.prjExpId}</td>
                        <td>${item.createdBy}</td>
                        <td>${item.cont}</td>

                    </tr>
                </c:forEach>
            </table>

            <form:form name="postExperience" method="post" commandName="projectInfo"
                       action="postExperienceAndFb.html">
                <table class="query-table">
                    <tr> 
                        <th><fmt:message key="message.common.content.label"/></th> 
                        <th><spring:bind path="projectInfo.experience">
                                <form:textarea path="experience" rows="5" cols="30" />
                                </spring:bind> <form:errors path="experience" cssClass="error" />
                        </th> 
                    </tr> 
                    <tr>
                        <td colspan="2" align="center"><input type="submit" 
                                                              name="btn_Post" id="btn_Post" value="Publish" class="button"></td> 
                    </tr>

                </table>


            </form:form>
		</span>
        </tab:tabPane>

        <tab:tabPane id="feedback" tabTitle="Feedback">
            <table class="query-table">
                <tr>
                    <th><fmt:message key="message.common.id.label"/></th>
                    <th><fmt:message key="message.common.creator.label"/></th>
                    <th><fmt:message key="message.common.title.label"/></th>
                    <th><fmt:message key="message.common.content.label"/></th>
                </tr>
                <c:forEach items="${feedbackList}" var="item" varStatus="status">
                    <tr>
                        <td>${item.prjFbId}</td>
                        <td>${item.createdBy}</td>
                        <td>${item.title}</td>
                        <td>${item.cont}</td>

                    </tr>
                </c:forEach>
            </table>
            <br/>
            <form:form name="posetFeedback" method="post" commandName="projectInfo"
                       action="postExperienceAndFb.html">
                <table class="query-table">
                    <tr> 
                        <th width="122"><label><fmt:message key="message.common.title.label"/></label> 
                        </th> 
                        <td width="197"><spring:bind path="projectInfo.fbTitle">
                                <form:input path="fbTitle" />
                            </spring:bind> <form:errors path="fbTitle" cssClass="error" />
                        </td> 
                    </tr> 
                    <tr> 
                        <th><label><fmt:message key="message.common.content.label"/></label> 
                        </th> 
                        <td><spring:bind path="projectInfo.fbContent">
                                <form:textarea path="fbContent" rows="5" cols="30" />
                            </spring:bind> <form:errors path="fbContent" cssClass="error" />
                        </td> 
                    </tr> 
                    <tr>
                        <td colspan="2" align="center"><input type="submit" 
                                                              name="btn_Post" id="btn_Post" value="Publish" class="button"></td> 
                    </tr>

                </table>


            </form:form>

        </tab:tabPane>

    </tab:tabContainer>
</body>