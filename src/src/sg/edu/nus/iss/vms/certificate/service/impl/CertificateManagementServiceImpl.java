package sg.edu.nus.iss.vms.certificate.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JasperPrint;

import org.apache.log4j.Logger;

import sg.edu.nus.iss.vms.certificate.service.CertificateManagementService;
import sg.edu.nus.iss.vms.certificate.vo.CertificateRequestVo;
import sg.edu.nus.iss.vms.common.Messages;
import sg.edu.nus.iss.vms.common.SessionBean;
import sg.edu.nus.iss.vms.common.constants.VMSConstants;
import sg.edu.nus.iss.vms.common.dto.CertificateRequestDto;
import sg.edu.nus.iss.vms.common.exception.ApplicationException;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.common.util.CodeLookupUtil;
import sg.edu.nus.iss.vms.reportmgmt.impl.ReportManagementServiceImpl;
import sg.edu.nus.iss.vms.volunteer.service.impl.VolunteerManagementServiceImpl;
import sg.edu.nus.iss.vms.volunteer.vo.VolunteerVo;

public class CertificateManagementServiceImpl implements CertificateManagementService {

    private Logger logger = Logger.getLogger(CertificateManagementServiceImpl.class);
    private Manager manager;
    private SessionBean sessionBean;
    private ReportManagementServiceImpl reportManagementService;
    private VolunteerManagementServiceImpl volunteerManagementService;

	public Manager getManager() {
        return this.manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public SessionBean getSessionBean() {
        return this.sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
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
		 String hQL = "from CertificateRequestDto where certReqId = " + certReqId;
         List<CertificateRequestDto> certRequestList = manager.find(hQL);
         CertificateRequestDto certRequest = null;
 
         if (certRequestList != null && !certRequestList.isEmpty())
        	 certRequest = certRequestList.get(0);

         return certRequest;
	}
    
    public void updateCertRequestStatus(long certReqId,long certReqStatus) throws Exception{
    	try {
    		CertificateRequestDto certRequest=this.getCertRequest(certReqId);
    		if(certRequest!=null){
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
    public List<CertificateRequestVo> getReqCertList(Long requestedStatus){
        String hQL = "FROM CertificateRequestDto WHERE reqSts ="+requestedStatus;
        List<CertificateRequestDto> certReqDtoList = manager.find(hQL);
        return changeCertReqVoList(certReqDtoList);
    }
    
    private List<CertificateRequestVo> changeCertReqVoList(
			List<CertificateRequestDto> list) {

		List<CertificateRequestVo> certReqVoList = new ArrayList<CertificateRequestVo>();
		if (list != null && list.size() != 0) {
			for (int i = 0; i < list.size(); i++) {
				CertificateRequestDto certRequestDto = list.get(i);

				CertificateRequestVo voObj=new CertificateRequestVo(certRequestDto);
				VolunteerVo volunteer = volunteerManagementService.getVolunteer((certRequestDto.getReqBy()));
				if (volunteer != null)
					voObj.setReqByName(volunteer.getNme());
				
				certReqVoList.add(voObj);
			}
		}
		return certReqVoList;
	}

	@Override
	public byte[] generateCertificate(Long certReqId,String imagePath,String filePath) throws Exception {
		
		CertificateRequestDto certReqDto = this.getCertRequest(certReqId);

		// report parameters
		String orgName = VMSConstants.ORGANIZATION_NAME;
		Map<String, String> params = new HashMap<String, String>();
		params.put("org_name", orgName.toUpperCase());
		params.put("goodJobImagePath",imagePath);

		// Query String for report
		String requestType = CodeLookupUtil
			.getCodeDescriptionByCodeId(certReqDto.getReqTp());
		String queryString = "SELECT prj.nme AS ProjectName, prj.str_dte as ProjectStartDate, prj.end_dte As ProjectEndDate,usr.nme As VolunteerName";
		queryString = queryString+ " FROM tb_project prj, tb_project_member prjMem, tb_certificate_request req,tb_user usr";
		queryString = queryString + " WHERE req.prj_id=prj.prj_id";
		queryString = queryString + " AND prjMem.prj_id=prj.prj_id";
		queryString = queryString + " AND prjMem.usr_login_id=usr.usr_login_id";
		queryString = queryString + " AND req.cert_req_id=" + certReqId;

		if (requestType.equalsIgnoreCase(VMSConstants.CERTIFIATE_REQUEST_TYPE_INDIVIDUAL))
			queryString = queryString + " AND req.req_by='"+ certReqDto.getReqBy() + "'";

		File reportFile = new File(filePath);			
		return reportManagementService.generatePDFReport(reportFile, params, queryString);
	}

  

}
