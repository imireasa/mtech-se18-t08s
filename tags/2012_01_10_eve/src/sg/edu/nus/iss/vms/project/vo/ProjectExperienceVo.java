package sg.edu.nus.iss.vms.project.vo;

import sg.edu.nus.iss.vms.project.dto.ProjectExperienceDto;

public class ProjectExperienceVo {

	private Long prjExpId;

	private String cont;
	private String createdBy;

	private String createdDte;
	private Long prjId;

	public ProjectExperienceVo() {
		super();
	}

	public ProjectExperienceVo(ProjectExperienceDto dto) {
		super();
		this.prjExpId = dto.getPrjExpId();
		this.cont = dto.getCont();
		this.createdBy = dto.getCreatedBy();
		this.createdDte = dto.getCreatedDte();
		this.prjId = dto.getPrjId().getPrjId();
	}

	public Long getPrjExpId() {
		return prjExpId;
	}

	public void setPrjExpId(Long prjExpId) {
		this.prjExpId = prjExpId;
	}

	public String getCont() {
		return cont;
	}

	public void setCont(String cont) {
		this.cont = cont;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDte() {
		return createdDte;
	}

	public void setCreatedDte(String createdDte) {
		this.createdDte = createdDte;
	}

	public Long getPrjId() {
		return prjId;
	}

	public void setPrjId(Long prjId) {
		this.prjId = prjId;
	}

}
