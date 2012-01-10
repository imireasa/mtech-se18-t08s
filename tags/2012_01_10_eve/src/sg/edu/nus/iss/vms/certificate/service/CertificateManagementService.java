package sg.edu.nus.iss.vms.certificate.service;

import java.util.List;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import sg.edu.nus.iss.vms.common.dto.CertificateRequestDto;

public interface CertificateManagementService {

	// engine
	public abstract JRBeanCollectionDataSource volunteerCertificate(
			int projectId, int volunteerId);

	public abstract List<CertificateRequestDto> getReqCertList(Long requestedStatus);
	public CertificateRequestDto getCertRequest(long certReqId);
	public void updateCertRequestStatus(long certReqId,long certReqStatus)throws Exception;
}