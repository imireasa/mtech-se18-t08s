package sg.edu.nus.iss.vms.reportmgmt.impl;

import org.apache.log4j.Logger;

import sg.edu.nus.iss.vms.common.SessionBean;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.reportmgmt.service.CertificateManagement;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class CertificateManagementImpl implements CertificateManagement {

    private Logger logger = Logger.getLogger(ReportManagementServicesImpl.class);
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
}
