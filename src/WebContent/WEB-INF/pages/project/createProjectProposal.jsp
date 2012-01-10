<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%><body>
<head>
<script type="text/javascript">

$(document).ready(function(){            
    $("#proposalVo").validationEngine();
});

	var slots = 10; // Upped automatically

	var nextUploadNum;

	function addFileInput() {

		slots++;

		var filenum = 0;

		var lastBlank = 0;

		var nextUploadNum = 0;

		var maxFileNum = 0;

		var listFiles = '';

		for ( var i = 1; i < slots; i++) {

			if (document.getElementById('attachment' + i)) {

				var filename = document.getElementById("attachment" + i).value;

				if (filename > ' ') {

					// Depending upon how you are outputting the javascript
					// make sure when viewing source that you see two 
					// backslashes "\\" following "fakepath". If not try fixing
					// by using 4 backslashes instead "\\\\"

					filename = filename.replace(/^.*fakepath\\/i, '');
					var removeLink = '<a href="javascript:removeFileInput(' + i
							+ ');">remove</a>';
					listFiles += 'File#' + ++filenum + ': ' + filename
							+ ' &nbsp;' + removeLink + '<br>';
					document.getElementById('attachment' + i).style.display = 'none';

					nextUploadNum = 0;

					maxFileNum = i;

				} else {

					if (lastBlank > 0) {
						document.getElementById('attachment' + lastBlank).style.display = 'none';
						removeFileInputNode(lastBlank);
						lastBlank = i;
					}

					nextUploadNum = i;

				}

			} else {

				if (nextUploadNum == 0) {
					nextUploadNum = i;
				}

			}

		}

		document.getElementById('maxfilenum').value = maxFileNum;

		document.getElementById('listFiles').innerHTML = listFiles;

		if (!(document.getElementById('attachment' + nextUploadNum))) {
			var div = document.createElement('div');
			var file = document.createElement('input');
			file.setAttribute('type', 'file');
			file.setAttribute('name', 'attachment' + nextUploadNum);
			file.setAttribute('id', 'attachment' + nextUploadNum);
			file.onchange = addFileInput;
			div.appendChild(file);
			document.getElementById('inputBoxes').appendChild(div);
		}

	}

	function removeFileInput(i) {

		if (document.getElementById('attachment' + i)) {
			removeFileInputNode(i);
		}

		addFileInput();

	}

	function removeFileInputNode(i) {

		if (i != 1) {

			document.getElementById('attachment' + i).parentNode.parentNode
					.removeChild(document.getElementById('attachment' + i).parentNode);
		} else {

			document.getElementById('attachment' + i).parentNode
					.removeChild(document.getElementById('attachment' + i));

		}

	}
</script>
</head>
<body>
	<h2><fmt:message key="message.projectManagement.proposeProject.title" /></h2>
	<div id="breadcrumb">
		<a href="<%=request.getContextPath()%>/common/welcome.html"> <fmt:message key="message.common.home.label"/></a> / <fmt:message key="message.projectManagement.proposeProject.title" />

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

		<form:form name="proposeProject" method="post"
			commandName="proposalVo" action="submitProjectProposal.html" enctype="multipart/form-data">
			<table class="query-table">

				<tr>
					<td align="left"><fmt:message
							key="message.projectManagement.projectName.label" /> <span
						class="mandatory"><fmt:message
								key="message.common.symbol.mandatory.label" /> </span></td>
					<td><fmt:message key="message.common.symbol.afterLabel.label" />
					</td>
					<td><spring:bind path="proposalVo.nme">
							<form:input path="nme" />
						</spring:bind> <form:errors path="nme" cssClass="validate[required] "/></td>
				</tr>
				<tr>
					<td align="left"><fmt:message
							key="message.common.description.label" /></td>
					<td><fmt:message key="message.common.symbol.afterLabel.label" />
					</td>
					<td><spring:bind path="proposalVo.desc">
							<form:textarea path="desc" rows="5" cols="30" />
						</spring:bind> <form:errors path="desc" cssClass="error" />
					</td>
				</tr>

				<tr>
					<td align="left"><fmt:message
							key="message.common.country.label" /> <span class="mandatory"><fmt:message
								key="message.common.symbol.mandatory.label" /> </span></td>
					<td><fmt:message key="message.common.symbol.afterLabel.label" />
					</td>
					<td><form:select path="ctryVal">
							<form:option value="" label="--Select--" />
							<c:forEach items="${countryList}" var="item" varStatus="status">
								<form:option value="${item.val}">${item.val}</form:option>
							</c:forEach>
						</form:select> <form:errors path="ctryVal" cssClass="error" />
					</td>

				</tr>
				<tr>
					<td align="left"><fmt:message
							key="message.common.location.label" /> <span class="mandatory"><fmt:message
								key="message.common.symbol.mandatory.label" /> </span></td>
					<td><fmt:message key="message.common.symbol.afterLabel.label" />
					</td>
					<td><spring:bind path="proposalVo.loc">
							<form:textarea path="loc" rows="5" cols="30" />
						</spring:bind> <form:errors path="loc" cssClass="error" />
					</td>
				</tr>

				<tr>
					<td align="left"><fmt:message
							key="message.common.duration.label" /> <span class="mandatory"><fmt:message
								key="message.common.symbol.mandatory.label" /> </span></td>
					<td><fmt:message key="message.common.symbol.afterLabel.label" />
					</td>
					<td><spring:bind path="proposalVo.estDur">
							<form:input path="estDur" /> days
					</spring:bind> <form:errors path="estDur" cssClass="error" />
					</td>
				</tr>
				<tr>
					<td align="left"><fmt:message
							key="message.common.supportingDoc.label" /></td>
					<td><fmt:message key="message.common.symbol.afterLabel.label" />
					</td>
					<td>
						<div id="listFiles">Attach Files:</div> <input type=file
						name=attachment1 id=attachment1 onChange="addFileInput();document.getElementById('file-path').value = this.value.split('\\')[this.value.split('\\').length-1];">
						<div id="inputBoxes">
						</div> 
						<br>
					<input type=hidden name=maxfilenum id=maxfilenum></td>
				</tr>

				<tr>
					<td colspan="2"></td>
					<td align="left"><input type="submit" name="buttonSubmit"
						id="buttonSubmit" value="<fmt:message key="message.common.submit.button" />">
					</td>
				</tr>
			</table>
		</form:form>
	</div>





</body>