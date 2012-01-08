package sg.edu.nus.iss.vms.project.vo;

import java.util.Date;

import sg.edu.nus.iss.vms.common.util.CodeLookupUtil;
import sg.edu.nus.iss.vms.project.dto.ProjectInterestDto;

public class ProjectInterestVo {

	private Long prjIntrstId;
	private Long prjId;
	private String prjName;
	private Date prjStartDate;
	private String reqBy;
	private String apprBy;
	private Date apprDte;
	private String apprRmk;

	private String stsVal;
	private String reqByTitle;
	private String reqByNme;
	private String reqByCtry;
	private Long stsCd;

	public ProjectInterestVo() {

	}

	public ProjectInterestVo(ProjectInterestDto obj) {

		setPrjIntrstId(obj.getPrjIntrstId());
		setPrjId(obj.getPrjId().getPrjId());
		setPrjName(obj.getPrjId().getNme());
		setPrjStartDate(obj.getPrjId().getStrDte());
		setReqBy(obj.getReqBy());
		setApprBy(obj.getApprBy());
		setApprDte(obj.getApprDte());
		setApprRmk(obj.getApprRmk());
		stsCd = obj.getStsCd();
		setStsVal(CodeLookupUtil.getCodeValueByCodeId(obj.getStsCd()));

	}

	public String getReqByCtry() {
		return reqByCtry;
	}

	public void setReqByCtry(String reqByCtry) {
		this.reqByCtry = reqByCtry;
	}

	public String getReqByNme() {
		return reqByNme;
	}

	public void setReqByNme(String reqByNme) {
		this.reqByNme = reqByNme;
	}

	public String getReqByTitle() {
		return reqByTitle;
	}

	public void setReqByTitle(String reqByTitle) {
		this.reqByTitle = reqByTitle;
	}

	public Long getStsCd() {
		return stsCd;
	}

	public void setStsCd(Long stsCd) {
		this.stsCd = stsCd;
	}

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

	public String getStsVal() {
		return stsVal;
	}

	public void setStsVal(String stsVal) {
		this.stsVal = stsVal;
	}

}