<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>

<body>
<head>
<style type="text/css">

/* Pagination
---------------------------------------- */
.pagingItem {
	font-weight: normal;
	text-decoration: none;
	color: #747474;
	margin: 0 2px;
	padding: 0 2px;
	background-color: #eeeeee;
	border: 1px solid #bababa;
	font-size: 0.9em;
	line-height: 1.5em;
}

.pagingItemCurrent {
	padding: 0 2px;
	margin: 0 2px;
	font-weight: normal;
	color: #FFFFFF;
	background-color: #bfbfbf;
	border: 1px solid #bfbfbf;
	font-size: 0.9em;
}

.pagingDots {
	font-weight: normal;
}

.pagination span a:hover {
	border-color: #d2d2d2;
	background-color: #d2d2d2;
	color: #FFF;
	text-decoration: none;
}

.pagination img {
	vertical-align: middle;
}
</style>

</head>
<body>

	<%-- // use our pagedListHolder --%>
	<jsp:useBean id="pagedListHolder" scope="request"
		type="org.springframework.beans.support.PagedListHolder" />
	<%-- // create link for pages, "~" will be replaced later on with the proper page number --%>
	<c:url value="/admin/staff/search.html" var="pagedLink">
		<c:param name="action" value="list" />
		<c:param name="p" value="~" />
	</c:url>

	<%-- // load our paging tag, pass pagedListHolder and the link --%>
	<tg:paging pagedListHolder="${pagedListHolder}"
		pagedLink="${pagedLink}" />

	<%-- // show only current page worth of data --%>
	<table width="320px" border="1">
		<tr>
			<th width="20px">No.</th>
			<th width="150px">First Name</th>
			<th width="150px">Last Name</th>
		</tr>
		<c:forEach items="${pagedListHolder.pageList}" var="item">
			<tr>
				<td>${item.staffId}</td>
				<td style="color: blue; font-weight: bold; text-align: right">${item.personId.firstName}</td>
				<td style="color: blue; font-weight: bold; text-align: right">${item.personId.lastName}</td>
			</tr>
		</c:forEach>
	</table>
</body>