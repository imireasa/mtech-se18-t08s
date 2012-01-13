package sg.edu.nus.iss.vms.certificate.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import sg.edu.nus.iss.vms.certificate.service.CertificateManagementService;
import sg.edu.nus.iss.vms.certificate.vo.CertificateRequestVo;
import sg.edu.nus.iss.vms.common.Messages;
import sg.edu.nus.iss.vms.common.constants.VMSConstants;
import sg.edu.nus.iss.vms.common.dto.CertificateRequestDto;
import sg.edu.nus.iss.vms.common.exception.ApplicationException;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.common.util.CodeLookupUtil;
import sg.edu.nus.iss.vms.common.util.DateUtil;
import sg.edu.nus.iss.vms.common.vo.CodeLookupVo;
import sg.edu.nus.iss.vms.common.web.util.UserUtil;
import sg.edu.nus.iss.vms.project.dto.ProjectDto;
import sg.edu.nus.iss.vms.reportmgmt.impl.ReportManagementServiceImpl;
import sg.edu.nus.iss.vms.volunteer.service.impl.VolunteerManagementServiceImpl;
import sg.edu.nus.iss.vms.volunteer.vo.VolunteerVo;

public class CertificateManagementServiceImpl implements
		CertificateManagementService {

	private final Logger logger = Logger
			.getLogger(CertificateManagementServiceImpl.class);
	private Manager manager;
	private ReportManagementServiceImpl reportManagementService;
	private VolunteerManagementServiceImpl volunteerManagementService;

	public Manager getManager() {
		return this.manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public ReportManagementServiceImpl getReportManagementService() {
		return reportManagementService;
	}

	public void setReportManagementService(
			ReportManagementServiceImpl reportManagementService) {
		this.reportManagementService = reportManagementService;
	}

	public VolunteerManagementServiceImpl getVolunteerManagementService() {
		return volunteerManagementService;
	}

	public void setVolunteerManagementService(
			VolunteerManagementServiceImpl volunteerManagementService) {
		this.volunteerManagementService = volunteerManagementService;
	}

	@Override
	public CertificateRequestDto getCertRequest(long certReqId) {
		String hQL = "from CertificateRequestDto where certReqId = "
				+ certReqId;
		List<CertificateRequestDto> certRequestList = manager.find(hQL);
		CertificateRequestDto certRequest = null;

		if (certRequestList != null && !certRequestList.isEmpty())
			certRequest = certRequestList.get(0);

		return certRequest;
	}

	@Override
	public void updateCertRequestStatus(long certReqId, long certReqStatus)
			throws Exception {
		try {
			CertificateRequestDto certRequest = this.getCertRequest(certReqId);
			if (certRequest != null) {
				certRequest.setReqSts(certReqStatus);
				manager.save(certRequest);
			}
		} catch (Exception ex) {
			logger.error("Update Cert Request Status", ex);
			throw new ApplicationException(
					Messages.getString("message.common.error.save"));
		}

	}

	@Override
	public List<CertificateRequestVo> getReqCertList(Long requestedStatus) {
		String hQL = "FROM CertificateRequestDto WHERE reqSts ="
				+ requestedStatus;
		List<CertificateRequestDto> certReqDtoList = manager.find(hQL);
		return changeCertReqVoList(certReqDtoList);
	}

	private List<CertificateRequestVo> changeCertReqVoList(
			List<CertificateRequestDto> list) {

		List<CertificateRequestVo> certReqVoList = new ArrayList<CertificateRequestVo>();
		if (list != null && list.size() != 0) {
			for (int i = 0; i < list.size(); i++) {
				CertificateRequestDto certRequestDto = list.get(i);

				CertificateRequestVo voObj = new CertificateRequestVo(
						certRequestDto);
				VolunteerVo volunteer = volunteerManagementService
						.getVolunteer((certRequestDto.getReqBy()));
				if (volunteer != null)
					voObj.setReqByName(volunteer.getNme());

				certReqVoList.add(voObj);
			}
		}
		return certReqVoList;
	}

	@Override
	public byte[] generateCertificate(Long certReqId, String imagePath,
			String filePath) throws Exception {

		CertificateRequestDto certReqDto = this.getCertRequest(certReqId);

		// report parameters
		String orgName = VMSConstants.ORGANIZATION_NAME;
		Map<String, String> params = new HashMap<String, String>();
		params.put("org_name", orgName.toUpperCase());
		params.put("goodJobImagePath", imagePath);

		// Query String for report
		String requestType = CodeLookupUtil
				.getCodeDescriptionByCodeId(certReqDto.getReqTp());
		String queryString = "SELECT prj.nme AS ProjectName, prj.str_dte as ProjectStartDate, prj.end_dte As ProjectEndDate,usr.nme As VolunteerName";
		queryString = queryString
				+ " FROM tb_project prj, tb_project_member prjMem, tb_certificate_request req,tb_user usr";
		queryString = queryString + " WHERE req.prj_id=prj.prj_id";
		queryString = queryString + " AND prjMem.prj_id=prj.prj_id";
		queryString = queryString + " AND prjMem.usr_login_id=usr.usr_login_id";
		queryString = queryString + " AND req.cert_req_id=" + certReqId;

		if (requestType
				.equalsIgnoreCase(VMSConstants.CERTIFIATE_REQUEST_TYPE_INDIVIDUAL))
			queryString = queryString + " AND req.req_by='"
					+ certReqDto.getReqBy() + "'";

		File reportFile = new File(filePath);
		return reportManagementService.generatePDFReport(reportFile, params,
				queryString);
	}

	@Override
	public List<CertificateRequestVo> getCertificateRequestsbyProject(
			Long prjId, String userId) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(CertificateRequestDto.class);
		criteria.setFetchMode("prjId", FetchMode.JOIN)
				.createAlias("prjId", "prjId")
				.add(Restrictions.eq("prjId.prjId", prjId))
				.add(Restrictions.eq("reqBy", userId));
		List<CertificateRequestDto> certificateRequestDtos = manager
				.findByDetachedCriteria(criteria);

		List<CertificateRequestVo> certReqVoList = new ArrayList<CertificateRequestVo>();

		for (CertificateRequestDto certificateRequestDto : certificateRequestDtos) {

			CertificateRequestVo voObj = new CertificateRequestVo(
					certificateRequestDto);

			certReqVoList.add(voObj);
		}

		return certReqVoList;

	}

	@Override
	public void createIndividualCertificateRequest(Long prjId) {

		CodeLookupVo codeStatusVo = CodeLookupUtil
				.getCodeByCategoryAndCodeValue(
						VMSConstants.CERTIFICATE_REQUEST_STATUS,
						VMSConstants.CERTIFICATE_REQUEST_STATUS_REQUESTED);
		CodeLookupVo codeVo = CodeLookupUtil.getCodeByCategoryAndCodeValue(
				VMSConstants.CERTIFIATE_REQUEST_TYPE,
				VMSConstants.CERTIFIATE_REQUEST_TYPE_INDIVIDUAL);

		String loginId = UserUtil.getUserSessionInfoVo().getUserID();

		CertificateRequestDto certificateRequestDto = new CertificateRequestDto();
		certificateRequestDto.setPrjId(new ProjectDto(prjId));
		certificateRequestDto.setReqBy(loginId);
		certificateRequestDto.setReqDte(DateUtil.getDate());
		certificateRequestDto.setReqSts(codeStatusVo.getCdId());
		certificateRequestDto.setReqTp(codeVo.getCdId());

		manager.save(certificateRequestDto);
	}

	@Override
	public void createProjectCertificateRequest(Long projectId)
			throws Exception {
		ProjectDto projectDto = (ProjectDto) manager.get(ProjectDto.class,projectId);
		CodeLookupVo reqStatusVo= CodeLookupUtil.getCodeByCategoryAndCodeValue(
				VMSConstants.CERTIFICATE_REQUEST_STATUS,
				VMSConstants.CERTIFICATE_REQUEST_STATUS_REQUESTED);
		CodeLookupVo reqTypeVo = CodeLookupUtil.getCodeByCategoryAndCodeValue(
				VMSConstants.CERTIFIATE_REQUEST_TYPE,
				VMSConstants.CERTIFICATE_REQUEST_TYPE_PROJECT);

		String loginId = UserUtil.getUserSessionInfoVo().getUserID();

		Long closeProject = CodeLookupUtil.getCodeByCategoryAndCodeValue(
				VMSConstants.PROJECT_STATUS_CATEGORY,
				VMSConstants.PROJECT_STATUS_CATEGORY_CLOSE).getCdId();

		if (projectDto.getStsCd().intValue() != closeProject) {
			throw new ApplicationException(
					Messages.getString("message.projectManagement.error.projStatus.notYetClose"));
		}

		String hQL = "from CertificateRequestDto where prjId=" + projectId
				+ " and reqTp=" + reqTypeVo.getCdId() + " and reqSts=" + reqStatusVo.getCdId();

		List<CertificateRequestDto> certificateRequestDtos = manager.find(hQL);
		if (certificateRequestDtos != null && !certificateRequestDtos.isEmpty()) {
			throw new ApplicationException(
					Messages.getString("message.projectManagement.error.certificate.requested"));
		} else {
			CertificateRequestDto certificateRequestDto = new CertificateRequestDto();
			certificateRequestDto.setPrjId(new ProjectDto(projectId));
			certificateRequestDto.setReqBy(loginId);
			certificateRequestDto.setReqDte(DateUtil.getDate());
			certificateRequestDto.setReqSts(reqStatusVo.getCdId());
			certificateRequestDto.setReqTp(reqTypeVo.getCdId());

			manager.save(certificateRequestDto);
		}
		
	}

}
