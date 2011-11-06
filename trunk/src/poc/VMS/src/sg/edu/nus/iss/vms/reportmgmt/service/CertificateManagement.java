package sg.edu.nus.iss.vms.reportmgmt.service;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public interface CertificateManagement {

	//engine
	public abstract JRBeanCollectionDataSource volunteerCertificate(int projectId, int volunteerId);

}