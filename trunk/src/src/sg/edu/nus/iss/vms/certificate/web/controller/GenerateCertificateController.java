package sg.edu.nus.iss.vms.certificate.web.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperPrint;

import org.apache.log4j.Logger;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;

import sg.edu.nus.iss.vms.certificate.service.CertificateManagementService;
import sg.edu.nus.iss.vms.certificate.vo.CertificateRequestVo;
import sg.edu.nus.iss.vms.common.constants.VMSConstants;
import sg.edu.nus.iss.vms.common.dto.CertificateRequestDto;
import sg.edu.nus.iss.vms.common.dto.CodeDto;
import sg.edu.nus.iss.vms.common.service.CodeManagementServices;
import sg.edu.nus.iss.vms.common.util.CodeLookupUtil;
import sg.edu.nus.iss.vms.common.web.controller.BaseMultiActionFormController;
import sg.edu.nus.iss.vms.project.dto.ProjectDto;
import sg.edu.nus.iss.vms.project.service.ProjectManagementService;
import sg.edu.nus.iss.vms.reportmgmt.service.ReportManagementService;
import sg.edu.nus.iss.vms.volunteer.service.VolunteerManagementService;
import sg.edu.nus.iss.vms.volunteer.vo.VolunteerVo;

public class GenerateCertificateController extends
		BaseMultiActionFormController {
	private final Logger logger = Logger
			.getLogger(GenerateCertificateController.class);

	private CodeManagementServices codeManagementServices;
	private VolunteerManagementService volunteerManagementService;
	private ReportManagementService reportManagementService;
	private CertificateManagementService certificateManagementService;
	private ProjectManagementService projectManagementService;

	public CodeManagementServices getCodeManagementServices() {
		if (logger.isDebugEnabled()) {
			logger.debug("getCodeManagementServices() - start");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getCodeManagementServices() - end");
		}
		return codeManagementServices;
	}

	public void setCodeManagementServices(
			CodeManagementServices codeManagementServices) {
		if (logger.isDebugEnabled()) {
			logger.debug("setCodeManagementServices(CodeManagementServices) - start");
		}

		this.codeManagementServices = codeManagementServices;

		if (logger.isDebugEnabled()) {
			logger.debug("setCodeManagementServices(CodeManagementServices) - end");
		}
	}

	public VolunteerManagementService getVolunteerManagementService() {
		if (logger.isDebugEnabled()) {
			logger.debug("getVolunteerManagementService() - start");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getVolunteerManagementService() - end");
		}
		return volunteerManagementService;
	}

	public void setVolunteerManagementService(
			VolunteerManagementService volunteerManagementService) {
		if (logger.isDebugEnabled()) {
			logger.debug("setVolunteerManagementService(VolunteerManagementService) - start");
		}

		this.volunteerManagementService = volunteerManagementService;

		if (logger.isDebugEnabled()) {
			logger.debug("setVolunteerManagementService(VolunteerManagementService) - end");
		}
	}

	public ProjectManagementService getProjectManagementService() {
		if (logger.isDebugEnabled()) {
			logger.debug("getProjectManagementService() - start");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getProjectManagementService() - end");
		}
		return projectManagementService;
	}

	public void setProjectManagementService(
			ProjectManagementService projectManagementService) {
		if (logger.isDebugEnabled()) {
			logger.debug("setProjectManagementService(ProjectManagementService) - start");
		}

		this.projectManagementService = projectManagementService;

		if (logger.isDebugEnabled()) {
			logger.debug("setProjectManagementService(ProjectManagementService) - end");
		}
	}

	public CertificateManagementService getCertificateManagementService() {
		if (logger.isDebugEnabled()) {
			logger.debug("getCertificateManagementService() - start");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getCertificateManagementService() - end");
		}
		return certificateManagementService;
	}

	public void setCertificateManagementService(
			CertificateManagementService certificateManagementService) {
		if (logger.isDebugEnabled()) {
			logger.debug("setCertificateManagementService(CertificateManagementService) - start");
		}

		this.certificateManagementService = certificateManagementService;

		if (logger.isDebugEnabled()) {
			logger.debug("setCertificateManagementService(CertificateManagementService) - end");
		}
	}

	public ReportManagementService getReportManagementService() {
		if (logger.isDebugEnabled()) {
			logger.debug("getReportManagementService() - start");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getReportManagementService() - end");
		}
		return this.reportManagementService;
	}

	public void setReportManagementService(
			ReportManagementService reportManagementServiceImpl) {
		if (logger.isDebugEnabled()) {
			logger.debug("setReportManagementService(ReportManagementService) - start");
		}

		this.reportManagementService = reportManagementServiceImpl;

		if (logger.isDebugEnabled()) {
			logger.debug("setReportManagementService(ReportManagementService) - end");
		}
	}

	@SuppressWarnings("deprecation")
	public ModelAndView generateCertificate(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("generateCertificate(HttpServletRequest, HttpServletResponse) - start");
		}

		modelAndView = new ModelAndView("reports/generateCertificate");
		CodeDto stsRequested = CodeLookupUtil.getCodeDtoByCatVal(
				VMSConstants.CERTIFICATE_REQUEST_STATUS,
				VMSConstants.CERTIFICATE_REQUEST_STATUS_REQUESTED);

		if (request.getParameter("certRequestId") == null) {

			List<CertificateRequestDto> list = certificateManagementService
					.getReqCertList(stsRequested.getCdId());
			List<?> certReqVoList = new ArrayList<Object>();
			if (logger.isDebugEnabled()) {
				logger.debug("generateCertificate(HttpServletRequest, HttpServletResponse) - certReqVoList:"
						+ certReqVoList.size());
			}

			PagedListHolder projectPagedListHolder = new PagedListHolder(
					this.getCertReqVoList(list));
			if (!list.isEmpty()) {
				int page = ServletRequestUtils.getIntParameter(request, "p", 0);
				projectPagedListHolder.setPage(page);
				projectPagedListHolder.setPageSize(VMSConstants.MAX_PAGE_SIZE);
			}
			modelAndView.addObject("pagedListHolder", projectPagedListHolder);

			modelAndView
					.addObject("certReqVoList", this.getCertReqVoList(list));
		} else {
			// 1. change the status
			Long certReqId = Long.parseLong(request
					.getParameter("certRequestId"));
			CodeDto processedSts = CodeLookupUtil.getCodeDtoByCatVal(
					VMSConstants.CERTIFICATE_REQUEST_STATUS,
					VMSConstants.CERTIFICATE_REQUEST_STATUS_PROCESSED);
			certificateManagementService.updateCertRequestStatus(certReqId,
					processedSts.getCdId());

			// 2. generate certificate
			CertificateRequestDto certReqDto = certificateManagementService
					.getCertRequest(certReqId);
			// String
			// jrxmlPath="C:/Mtech 7/WebContent/reports/volunteer_certificate_multipages.jrxml";//VMSConstants.REPORT_TEMPLATE_PATH_JRXML
			String jasperPath = "/reports/volunteer_certificate_multipages.jasper";// VMSConstants.REPORT_TEMPLATE_PATH_JASPER

			// report parameters
			String orgName = VMSConstants.ORGANIZATION_NAME;
			Map<String, String> params = new HashMap<String, String>();
			params.put("org_name", orgName.toUpperCase());
			params.put("goodJobImagePath",
					request.getRealPath("/sys/images/good_job.jpg"));

			// Query String for report
			String requestType = CodeLookupUtil
					.getCodeDescriptionByCodeId(certReqDto.getReqTp());
			String queryString = "SELECT prj.nme AS ProjectName, prj.str_dte as ProjectStartDate, prj.end_dte As ProjectEndDate,usr.nme As VolunteerName";
			queryString = queryString
					+ " FROM tb_project prj, tb_project_member prjMem, tb_certificate_request req,tb_user usr";
			queryString = queryString + " WHERE req.prj_id=prj.prj_id";
			queryString = queryString + " AND prjMem.prj_id=prj.prj_id";
			queryString = queryString
					+ " AND prjMem.usr_login_id=usr.usr_login_id";
			queryString = queryString + " AND req.cert_req_id=" + certReqId;

			if (requestType
					.equalsIgnoreCase(VMSConstants.CERTIFIATE_REQUEST_TYPE_INDIVIDUAL))
				queryString = queryString + " AND req.req_by='"
						+ certReqDto.getReqBy() + "'";
			JasperPrint jasperPrint = null;

			File reportFile = new File(request.getRealPath(jasperPath));

			byte[] bytes = this.reportManagementService.generatePDFReport(
					reportFile, params, queryString);

			if (bytes != null && bytes.length != 0) {
				response.setContentType("application/pdf");
				response.addHeader("Content-Disposition",
						"attachment;filename= volunteer_certificate.pdf");
				response.setContentLength(bytes.length);
				ServletOutputStream outStream = response.getOutputStream();
				outStream.write(bytes, 0, bytes.length);
				outStream.flush();
				outStream.close();

				// 3. get the remaining request list...
				List<CertificateRequestDto> list = certificateManagementService
						.getReqCertList(stsRequested.getCdId());
				modelAndView.addObject("certReqVoList",
						this.getCertReqVoList(list));

				if (logger.isDebugEnabled()) {
					logger.debug("generateCertificate(HttpServletRequest, HttpServletResponse) - end");
				}
				return modelAndView;
			}
		}

		if (logger.isDebugEnabled()) {
			logger.debug("generateCertificate(HttpServletRequest, HttpServletResponse) - end");
		}
		return modelAndView;
	}

	private List<CertificateRequestVo> getCertReqVoList(
			List<CertificateRequestDto> list) {

		List<CertificateRequestVo> certReqVoList = new ArrayList<CertificateRequestVo>();
		if (list != null && list.size() != 0) {
			for (int i = 0; i < list.size(); i++) {
				CertificateRequestDto obj = list.get(i);
				CertificateRequestVo voObj = new CertificateRequestVo();
				voObj.setCertReqId(obj.getCertReqId());
				voObj.setPrjId(obj.getPrjId());
				ProjectDto project = (ProjectDto) projectManagementService
						.getProjectObjbyId(obj.getPrjId(), ProjectDto.class);

				if (project != null)
					voObj.setPrjName(project.getNme());

				voObj.setReqTp(obj.getReqTp());
				voObj.setReqTpName(CodeLookupUtil.getCodeValueByCodeId(obj
						.getReqTp()));
				voObj.setReqBy(obj.getReqBy());
				voObj.setReqDte(obj.getReqDte());
				VolunteerVo volunteer = volunteerManagementService
						.getVolunteer((obj.getReqBy()));

				if (volunteer != null)
					voObj.setReqByName(volunteer.getNme());

				certReqVoList.add(voObj);
			}
		}
		return certReqVoList;
	}

}