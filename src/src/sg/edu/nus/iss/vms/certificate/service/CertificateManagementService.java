package sg.edu.nus.iss.vms.certificate.service;

import java.util.List;

import sg.edu.nus.iss.vms.certificate.vo.CertificateRequestVo;
import sg.edu.nus.iss.vms.common.dto.CertificateRequestDto;

public interface CertificateManagementService {

	public List<CertificateRequestVo> getReqCertList(Long requestedStatus);
	public CertificateRequestDto getCertRequest(long certReqId);
	public void updateCertRequestStatus(long certReqId,long certReqStatus)throws Exception;
	public byte[] generateCertificate(Long certReqId,String imagePath,String filePath) throws Exception;
}