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

        <link type="text/css"
              href="<%=request.getContextPath()%>/sys/css/paging.css"
              rel="stylesheet" />

</head>
<body>
        <div id="breadcrumb">
                <a href="#">Home</a> / 
                <a href="#">View Project Interest</a> 
        <h2>List Project</h2>
        <div class="query">
                <form:form name="viewProjectInterest" method="get"
                           commandName="command" action="viewProjectInterest.html">

                        <table width="660" height="105">
                        		 <tr>
                                        <td width="123">Project Id</td>
                                        <td width="199"><form:input path="prjId"/></td>
                                        <td width="359">&nbsp;</td>
                                </tr>
                                <tr>
                                        <td width="123">Project Name</td>
                                        <td width="199"><form:input path="projNme"/></td>
                                        <td width="359">&nbsp;</td>
                                </tr>
                                <tr>
                                        <td>Status</td>
                                        <td>
                                                <form:select path="stsVal">
                                                        <form:option value="" ></form:option>
                                                        <c:forEach items="${projInterestStatusList}" var="item" varStatus="status">
                                                                <form:option value="${item.val}">${item.val}</form:option>
                                                        </c:forEach>

                                                </form:select>

                                        </td>
                                        <td>&nbsp;</td>
                                </tr>
                                <tr>
                                        <td><input type="submit" name="btn_Search" id="btn_Search" value="Search"></td>
                                </tr>
                        </table>
                </form:form>
        </div>
        <!-- end of query -->
        <table width="700" class="proj-table">
                <tr>
                        <td colspan="7"><b><label>Project Interest List</label></b></td>
                </tr>
                <tr>
					<td><label>Project Id</label></td>
                    <td><label>Project Name</label></td>
                    <td><label>Project Start Date</label></td>
                    <td><label>Requested Date</label></td>
                    <td><label>Approved Date</label></td>
                    <td><label>Status</label></td>
                    

                </tr>
                <c:forEach items="${pagedListHolder.pageList}" var="item">
                        <tr>
                                <td>${item.prjId}</td>
                                <td>${item.prjName}</td>
                                <td><fmt:formatDate pattern="dd-MM-yyyy" value="${item.prjStartDate}" /></td>
                                <td><fmt:formatDate pattern="dd-MM-yyyy" value="${item.createdDate}" /></td>
                                <td><fmt:formatDate pattern="dd-MM-yyyy" value="${item.apprDte}" /></td>
                                <td>${item.stsVal}</td>
                           
                        </tr>
                </c:forEach>
        </table>
        <div class="pagination">
                <jsp:useBean id="pagedListHolder" scope="request"
                             type="org.springframework.beans.support.PagedListHolder" />

                <%-- // load our paging tag, pass pagedListHolder and the link --%>
                <tg:paging pagedListHolder="${pagedListHolder}"
                           pagedLink="${pagedLink}" />
        </div>
</body>