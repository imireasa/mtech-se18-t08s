/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nus.iss.vms.certificate.vo;

import java.util.Date;

import sg.edu.nus.iss.vms.common.dto.CertificateRequestDto;
import sg.edu.nus.iss.vms.common.util.CodeLookupUtil;

public class CertificateRequestVo {
	
	private Long certReqId;
	private Long prjId;
	private String prjName;
	private Long reqTp;
	private String reqTpName;
	private Long reqSts;
	private Date reqDte;
	private String reqBy;
	private String reqByName;
	
	public CertificateRequestVo() {
		super();
	}

	public CertificateRequestVo(CertificateRequestDto certificateRequestDto) {
        setCertificateRequestDto(certificateRequestDto);
    }

    public void setCertificateRequestDto(CertificateRequestDto certRequestDto) {
    	
    	if (certRequestDto != null) {
    		setCertReqId(certRequestDto.getCertReqId());
			setPrjId(certRequestDto.getPrjId().getPrjId());
			if(certRequestDto.getPrjId()!=null)
				setPrjName(certRequestDto.getPrjId().getNme());
			setReqTp(certRequestDto.getReqTp());
			if(certRequestDto.getReqTp()!=0)
				setReqTpName(CodeLookupUtil.getCodeValueByCodeId(certRequestDto.getReqTp()));
			setReqSts(certRequestDto.getReqSts());
			setReqDte(certRequestDto.getReqDte());
			setReqBy(certRequestDto.getReqBy());
    	}
    }

	public Long getCertReqId() {
		return certReqId;
	}
	public void setCertReqId(Long certReqId) {
		this.certReqId = certReqId;
	}
	public Long getPrjId() {
		return prjId;
	}
	public void setPrjId(Long prjId) {
		this.prjId = prjId;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public Long getReqTp() {
		return reqTp;
	}
	public void setReqTp(Long reqTp) {
		this.reqTp = reqTp;
	}
	public String getReqTpName() {
		return reqTpName;
	}
	public void setReqTpName(String reqTpName) {
		this.reqTpName = reqTpName;
	}
	public Long getReqSts() {
		return reqSts;
	}
	public void setReqSts(Long reqSts) {
		this.reqSts = reqSts;
	}
	public Date getReqDte() {
		return reqDte;
	}
	public void setReqDte(Date reqDte) {
		this.reqDte = reqDte;
	}
	public String getReqBy() {
		return reqBy;
	}
	public void setReqBy(String reqBy) {
		this.reqBy = reqBy;
	}
	public String getReqByName() {
		return reqByName;
	}
	public void setReqByName(String reqByName) {
		this.reqByName = reqByName;
	}
	 
	

}

