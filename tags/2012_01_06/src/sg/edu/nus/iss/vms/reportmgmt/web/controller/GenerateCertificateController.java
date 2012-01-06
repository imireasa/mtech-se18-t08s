package sg.edu.nus.iss.vms.reportmgmt.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import sg.edu.nus.iss.vms.common.constants.VMSConstants;
import sg.edu.nus.iss.vms.common.dto.CertificateRequestDto;
import sg.edu.nus.iss.vms.common.dto.CodeDto;
import sg.edu.nus.iss.vms.common.service.CodeManagementServices;
import sg.edu.nus.iss.vms.common.util.CodeLookupUtil;
import sg.edu.nus.iss.vms.common.web.controller.BaseMultiActionFormController;
import sg.edu.nus.iss.vms.project.dto.ProjectDto;
import sg.edu.nus.iss.vms.project.service.ProjectManagementService;
import sg.edu.nus.iss.vms.reportmgmt.service.CertificateManagement;
import sg.edu.nus.iss.vms.reportmgmt.service.ReportManagementServices;
import sg.edu.nus.iss.vms.reportmgmt.vo.CertificateRequestVo;
import sg.edu.nus.iss.vms.volunteer.service.VolunteerManagementService;
import sg.edu.nus.iss.vms.volunteer.vo.VolunteerVo;

public class GenerateCertificateController extends
		BaseMultiActionFormController {
	private Logger logger = Logger
			.getLogger(GenerateCertificateController.class);

	private CodeManagementServices codeManagementServices;
	private VolunteerManagementService volunteerManagementService;
	private ReportManagementServices reportManagementServices;
	private CertificateManagement certificateManagement;
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

	public CertificateManagement getCertificateManagement() {
		if (logger.isDebugEnabled()) {
			logger.debug("getCertificateManagement() - start");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getCertificateManagement() - end");
		}
		return certificateManagement;
	}

	public void setCertificateManagement(
			CertificateManagement certificateManagement) {
		if (logger.isDebugEnabled()) {
			logger.debug("setCertificateManagement(CertificateManagement) - start");
		}

		this.certificateManagement = certificateManagement;

		if (logger.isDebugEnabled()) {
			logger.debug("setCertificateManagement(CertificateManagement) - end");
		}
	}

	public ReportManagementServices getReportManagementServices() {
		if (logger.isDebugEnabled()) {
			logger.debug("getReportManagementServices() - start");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getReportManagementServices() - end");
		}
		return this.reportManagementServices;
	}

	public void setReportManagementServices(
			ReportManagementServices reportManagementServicesImpl) {
		if (logger.isDebugEnabled()) {
			logger.debug("setReportManagementServices(ReportManagementServices) - start");
		}

		this.reportManagementServices = reportManagementServicesImpl;

		if (logger.isDebugEnabled()) {
			logger.debug("setReportManagementServices(ReportManagementServices) - end");
		}
	}

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

			List<CertificateRequestDto> list = certificateManagement.getReqCertList(stsRequested.getCdId());
			List certReqVoList = new ArrayList();
			if (logger.isDebugEnabled()) {
				logger.debug("generateCertificate(HttpServletRequest, HttpServletResponse) - certReqVoList:" + certReqVoList.size());
			}
			
			modelAndView.addObject("certReqVoList", this.getCertReqVoList(list));
		} else {
			// 1. change the status
			Long certReqId = Long.parseLong(request.getParameter("certRequestId"));
			CodeDto processedSts = CodeLookupUtil.getCodeDtoByCatVal(
					VMSConstants.CERTIFICATE_REQUEST_STATUS,
					VMSConstants.CERTIFICATE_REQUEST_STATUS_PROCESSED);
			certificateManagement.updateCertRequestStatus(certReqId, processedSts.getCdId());

			// 2. generate certificate
			CertificateRequestDto certReqDto = certificateManagement.getCertRequest(certReqId);
			byte[] bytes = this.reportManagementServices.generateVolunteerCertificate(certReqId, certReqDto
							.getReqBy(), CodeLookupUtil
							.getCodeDescriptionByCodeId(certReqDto.getReqTp()));

			if (bytes != null && bytes.length != 0) {
				response.setContentType("application/pdf");
				response.addHeader("Content-Disposition", "attachment;filename= volunteer_certificate.pdf");
				response.setContentLength(bytes.length);
				ServletOutputStream outStream = response.getOutputStream();
				outStream.write(bytes, 0, bytes.length);
				outStream.flush();
				outStream.close();

				// 3. get the remaining request list...
				List list = certificateManagement.getReqCertList(stsRequested.getCdId());
				modelAndView.addObject("certReqVoList", this.getCertReqVoList(list));

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
	private List getCertReqVoList(List list){
		
		List certReqVoList = new ArrayList();
		if (list != null && list.size() != 0) {
			for (int i = 0; i < list.size(); i++) {
				CertificateRequestDto obj = (CertificateRequestDto) list
						.get(i);
				CertificateRequestVo voObj = new CertificateRequestVo();
				voObj.setCertReqId(obj.getCertReqId());
				voObj.setPrjId(obj.getPrjId());
				ProjectDto project = projectManagementService.getProject(obj.getPrjId());
				
				if (project != null)
					voObj.setPrjName(project.getNme());
				
				voObj.setReqTp(obj.getReqTp());
				voObj.setReqTpName(CodeLookupUtil.getCodeValueByCodeId(obj.getReqTp()));
				voObj.setReqBy(obj.getReqBy());
				voObj.setReqDte(obj.getReqDte());
				VolunteerVo volunteer = volunteerManagementService.getVolunteer((obj.getReqBy()));
				
				if (volunteer != null)
					voObj.setReqByName(volunteer.getNme());
				
				certReqVoList.add(voObj);
			}
		}
		return certReqVoList;
	}

}