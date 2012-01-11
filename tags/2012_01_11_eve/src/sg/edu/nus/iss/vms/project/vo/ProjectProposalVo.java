package sg.edu.nus.iss.vms.project.vo;

import java.util.Date;

import sg.edu.nus.iss.vms.common.util.CodeLookupUtil;
import sg.edu.nus.iss.vms.common.vo.CodeLookupVo;
import sg.edu.nus.iss.vms.project.dto.ProjectProposalDto;

public class ProjectProposalVo {

	private Long prjPropId;
	private String nme;
	private String desc;
	private Long ctryCd;
	private String ctryVal;
	private String loc;
	private int estDur;
	private String proposerId;
	private String apprBy;
	private Date apprDte;
	private Long stsCd;
	private String stsVal;
	private String rmk;

	private String createdBy;

	public ProjectProposalVo() {
		super();
	}

	public ProjectProposalVo(ProjectProposalDto dto) {
		super();
		this.prjPropId = dto.getPrjPropId();
		this.nme = dto.getNme();
		this.desc = dto.getDesc();
		CodeLookupVo countryCodeVo = CodeLookupUtil
				.getCodeById(dto.getCtryCd());
		this.ctryCd = dto.getCtryCd();
		if (countryCodeVo != null)
			this.ctryVal = countryCodeVo.getVal();
		this.loc = dto.getLoc();
		this.estDur = dto.getEstDur();
		this.proposerId = dto.getProposerId();
		this.apprBy = dto.getApprBy();
		this.apprDte = dto.getApprDte();
		CodeLookupVo codeVo = CodeLookupUtil.getCodeById(dto.getStsCd());
		this.stsCd = codeVo.getCdId();
		this.stsVal = codeVo.getVal();
		this.rmk = dto.getRmk();
		this.createdBy = dto.getCreatedBy();
	}

	public Long getPrjPropId() {
		return prjPropId;
	}

	public void setPrjPropId(Long prjPropId) {
		this.prjPropId = prjPropId;
	}

	public String getNme() {
		return nme;
	}

	public void setNme(String nme) {
		this.nme = nme;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Long getCtryCd() {
		return ctryCd;
	}

	public void setCtryCd(Long ctryCd) {
		this.ctryCd = ctryCd;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public int getEstDur() {
		return estDur;
	}

	public void setEstDur(int estDur) {
		this.estDur = estDur;
	}

	public String getProposerId() {
		return proposerId;
	}

	public void setProposerId(String proposerId) {
		this.proposerId = proposerId;
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

	public Long getStsCd() {
		return stsCd;
	}

	public void setStsCd(Long stsCd) {
		this.stsCd = stsCd;
	}

	public String getRmk() {
		return rmk;
	}

	public void setRmk(String rmk) {
		this.rmk = rmk;
	}

	public String getStsVal() {
		return stsVal;
	}

	public void setStsVal(String stsVal) {
		this.stsVal = stsVal;
	}

	public String getCtryVal() {
		return ctryVal;
	}

	public void setCtryVal(String ctryVal) {
		this.ctryVal = ctryVal;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
