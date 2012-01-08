package sg.edu.nus.iss.vms.project.vo;

import java.util.Date;

import sg.edu.nus.iss.vms.common.dto.CodeDto;
import sg.edu.nus.iss.vms.common.util.CodeLookupUtil;
import sg.edu.nus.iss.vms.project.dto.ProjectFeedbackDto;

public class ProjectFeedbackVo {

	private Long prjFbId;

	private String title;

	private String cont;
	private String apprBy;
	private Date apprDte;
	private Long stsCd;
	private String stsVal;
	private Long prjId;
	private String prjNme;
	private String createdBy;

	private Date createdDte;

	public ProjectFeedbackVo() {
		super();
	}

	public ProjectFeedbackVo(ProjectFeedbackDto dto) {
		super();
		this.prjFbId = dto.getPrjFbId();
		this.title = dto.getTitle();
		this.cont = dto.getCont();
		this.apprBy = dto.getApprBy();
		this.apprDte = dto.getApprDte();
		CodeDto codeDto = CodeLookupUtil.getCodeById(dto.getStsCd());
		this.stsCd = codeDto.getCdId();
		this.stsVal = codeDto.getVal();
		this.prjId = dto.getPrjId().getPrjId();
		this.prjNme = dto.getPrjId().getNme();
		this.createdBy = dto.getCreatedBy();
		createdDte = dto.getCreatedDte();
	}

	public Long getPrjFbId() {
		return prjFbId;
	}

	public void setPrjFbId(Long prjFbId) {
		this.prjFbId = prjFbId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCont() {
		return cont;
	}

	public void setCont(String cont) {
		this.cont = cont;
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

	public void setApprDte(Date apprDte) {
		this.apprDte = apprDte;
	}

	public Long getPrjId() {
		return prjId;
	}

	public void setPrjId(Long prjId) {
		this.prjId = prjId;
	}

	public String getPrjNme() {
		return prjNme;
	}

	public void setPrjNme(String prjNme) {
		this.prjNme = prjNme;
	}

	public Long getStsCd() {
		return stsCd;
	}

	public void setStsCd(Long stsCd) {
		this.stsCd = stsCd;
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

	public Date getCreatedDte() {
		return createdDte;
	}

	public void setCreatedDte(Date createdDte) {
		this.createdDte = createdDte;
	}

}
