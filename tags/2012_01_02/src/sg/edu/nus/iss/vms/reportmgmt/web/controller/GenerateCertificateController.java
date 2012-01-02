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
import sg.edu.nus.iss.vms.member.service.MemberManagementService;
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
		return codeManagementServices;
	}

	public void setCodeManagementServices(
			CodeManagementServices codeManagementServices) {
		this.codeManagementServices = codeManagementServices;
	}
	public VolunteerManagementService getVolunteerManagementService() {
		return volunteerManagementService;
	}

	public void setVolunteerManagementService(
			VolunteerManagementService volunteerManagementService) {
		this.volunteerManagementService = volunteerManagementService;
	}

	public ProjectManagementService getProjectManagementService() {
		return projectManagementService;
	}

	public void setProjectManagementService(
			ProjectManagementService projectManagementService) {
		this.projectManagementService = projectManagementService;
	}

	public CertificateManagement getCertificateManagement() {
		return certificateManagement;
	}

	public void setCertificateManagement(
			CertificateManagement certificateManagement) {
		this.certificateManagement = certificateManagement;
	}

	public ReportManagementServices getReportManagementServices() {
		return this.reportManagementServices;
	}

	public void setReportManagementServices(
			ReportManagementServices reportManagementServicesImpl) {
		this.reportManagementServices = reportManagementServicesImpl;
	}

	public ModelAndView generateCertificate(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		modelAndView = new ModelAndView("reports/generateCertificate");

		CodeDto stsRequested = codeManagementServices.getCodeDtoByCatVal(
				VMSConstants.CERTIFICATE_REQUEST_STATUS,
				VMSConstants.CERTIFICATE_REQUEST_STATUS_REQUESTED);
		
			if(request.getParameter("certRequestId")==null){
				
				List list = certificateManagement.getReqCertList(stsRequested.getCdId());
				List certReqVoList=new ArrayList() ;
				if(list!=null){
					for(int i=0;i<list.size();i++){
            		  CertificateRequestDto obj=(CertificateRequestDto) list.get(i);
            		  CertificateRequestVo voObj=new CertificateRequestVo();
            		  voObj.setCertReqId(obj.getCertReqId());
            		  voObj.setPrjId(obj.getPrjId());
            		  ProjectDto project=projectManagementService.getProject(obj.getPrjId());
            		  if(project!=null)
            			  voObj.setPrjName(project.getNme());
            		  voObj.setReqTp(obj.getReqTp());
            		  voObj.setReqTpName(CodeLookupUtil.getCodeValueByCodeId(obj.getReqTp()));
            		  voObj.setReqBy(obj.getReqBy());
            		  voObj.setReqDte(obj.getReqDte());
            		  VolunteerVo volunteer=volunteerManagementService.getVolunteer((obj.getReqBy()));
            		  if(volunteer!=null)
            			  voObj.setReqByName(volunteer.getNme());
            		  certReqVoList.add(voObj);
					}
				}
				System.out.println(" certReqVoList:"+certReqVoList.size());
				modelAndView.addObject("certReqVoList", certReqVoList);
			}
			else{
				//1. change the status
				Long certReqId=Long.parseLong(request.getParameter("certRequestId"));
				CodeDto processedSts = codeManagementServices.getCodeDtoByCatVal(
						VMSConstants.CERTIFICATE_REQUEST_STATUS,
						VMSConstants.CERTIFICATE_REQUEST_STATUS_PROCESSED);
				certificateManagement.updateCertRequestStatus( certReqId, processedSts.getCdId());
				
				
				
				//2. generate certificate
				CertificateRequestDto certReqDto=certificateManagement.getCertRequest(certReqId);
				byte[] bytes = this.reportManagementServices
				.generateVolunteerCertificate(certReqId, certReqDto.getReqBy(),CodeLookupUtil.getCodeDescriptionByCodeId(certReqDto.getReqTp()));

				if (bytes != null && bytes.length != 0) {
				response.setContentType("application/pdf");
				response.addHeader("Content-Disposition",
					"attachment;filename= volunteer_certificate.pdf");
				response.setContentLength(bytes.length);
				ServletOutputStream outStream = response.getOutputStream();
				outStream.write(bytes, 0, bytes.length);
				outStream.flush();
				outStream.close();	
				
				//3. get the remaining request list...
				List list = certificateManagement.getReqCertList(stsRequested.getCdId());
				List certReqVoList=new ArrayList();
				
				if(list!=null){
					for(int i=0;i<list.size();i++){
            		  CertificateRequestDto obj=(CertificateRequestDto) list.get(i);
            		  CertificateRequestVo voObj=new CertificateRequestVo();
            		  voObj.setCertReqId(obj.getCertReqId());
            		  voObj.setPrjId(obj.getPrjId());
            		  ProjectDto project=projectManagementService.getProject(obj.getPrjId());
            		  if(project!=null)
            			  voObj.setPrjName(project.getNme());
            		  voObj.setReqTp(obj.getReqTp());
            		  voObj.setReqTpName(CodeLookupUtil.getCodeValueByCodeId(obj.getReqTp()));
            		  voObj.setReqBy(obj.getReqBy());
            		  voObj.setReqDte(obj.getReqDte());
            		  VolunteerVo volunteer=volunteerManagementService.getVolunteer((obj.getReqBy()));
            		  if(volunteer!=null)
            			  voObj.setReqByName(volunteer.getNme());
            		  certReqVoList.add(voObj);
					}
				}
				modelAndView.addObject("certReqVoList", certReqVoList);
				return modelAndView;
				}
			}
			return modelAndView;	
	}

}