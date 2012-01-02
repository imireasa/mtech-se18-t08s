package sg.edu.nus.iss.vms.project.vo;

import java.util.Date;



public class ProjectInterestVo {
	
	private Long prjIntrstId;
	private Long prjId;
	private String prjName;
	private Date prjStartDate;
	private String reqBy;
	private String apprBy;
	private Date apprDte;
	private String apprRmk;
	private Long stsCD;
	private String stsVal;
	private String createdBy;
	private Date createdDate;
	private String updBy;
	private Date updDate;
	private int version;
	
	public Long getPrjIntrstId() {
		return prjIntrstId;
	}
	public void setPrjIntrstId(Long prjIntrstId) {
		this.prjIntrstId = prjIntrstId;
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
	public Date getPrjStartDate() {
		return prjStartDate;
	}
	public void setPrjStartDate(Date prjStartDate) {
		this.prjStartDate = prjStartDate;
	}
	public String getReqBy() {
		return reqBy;
	}
	public void setReqBy(String reqBy) {
		this.reqBy = reqBy;
	}
	public String getApprBy() {
		return apprBy;
	}
	public void setApprBy(String apprBy) {
		this.apprBy = apprBy;
	}
	public Date getApprDte() {
		return apprDte;
	}
	public void setApprDte(Date date) {
		this.apprDte = date;
	}
	public String getApprRmk() {
		return apprRmk;
	}
	public void setApprRmk(String apprRmk) {
		this.apprRmk = apprRmk;
	}
	public Long getStsCD() {
		return stsCD;
	}
	public void setStsCD(Long stsCD) {
		this.stsCD = stsCD;
	}
	public String getStsVal() {
		return stsVal;
	}
	public void setStsVal(String stsVal) {
		this.stsVal = stsVal;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdBy() {
		return updBy;
	}
	public void setUpdBy(String updBy) {
		this.updBy = updBy;
	}
	public Date getUpdDate() {
		return updDate;
	}
	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}

}