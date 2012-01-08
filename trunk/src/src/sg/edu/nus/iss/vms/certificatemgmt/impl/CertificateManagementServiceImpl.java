package sg.edu.nus.iss.vms.certificatemgmt.service.impl;

import java.util.List;
import org.apache.log4j.Logger;

import sg.edu.nus.iss.vms.certificatemgmt.service.CertificateManagementService;
import sg.edu.nus.iss.vms.common.Messages;
import sg.edu.nus.iss.vms.common.SessionBean;
import sg.edu.nus.iss.vms.common.dto.CertificateRequestDto;
import sg.edu.nus.iss.vms.common.exception.ApplicationException;
import sg.edu.nus.iss.vms.common.orm.Manager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class CertificateManagementServiceImpl implements CertificateManagementService {

    private Logger logger = Logger.getLogger(CertificateManagementServiceImpl.class);
    private Manager manager;
    private SessionBean sessionBean;

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
			logger.error("Save update Cert Request Status", ex);
			throw new ApplicationException(
					Messages.getString("message.common.error.save"));
		}

    }
    //engine
	/* (non-Javadoc)
     * @see sg.edu.nus.iss.vms.reportmgmt.impl.CertificateManagement#volunteerCertificate(int, int)
     */
    @Override
    public JRBeanCollectionDataSource volunteerCertificate(int projectId, int volunteerId) {
        String hQL = "from ProjectMember where projectId.projectId=" + projectId;
//		List<ProjectMember> collection = manager.find(hQL);		
//		JRBeanCollectionDataSource jRBeanCDS = new JRBeanCollectionDataSource(collection);
//		return jRBeanCDS;
        return null;
    }


    @Override
    public List<CertificateRequestDto> getReqCertList(Long requestedStatus){
        String hQL = "FROM CertificateRequestDto WHERE reqSts ="+requestedStatus;
        List<CertificateRequestDto> collection = manager.find(hQL);
        return collection;
    }
}
