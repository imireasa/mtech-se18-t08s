/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.project.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import sg.edu.nus.iss.vms.common.dto.BaseVersionDto;

/**
 * 
 * @author zaw
 */
@Entity
@Table(name = "tb_project")
@NamedQueries({ @NamedQuery(name = "ProjectDto.findAll", query = "SELECT t FROM ProjectDto t") })
public class ProjectDto extends BaseVersionDto implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "PRJ_ID")
	private Long prjId;
	@Basic(optional = false)
	@Column(name = "NME")
	private String nme;
	@Basic(optional = false)
	@Column(name = "DESC")
	private String desc;
	@Column(name = "PRJ_MGR")
	private String prjMgr;
	@Basic(optional = false)
	@Column(name = "STR_DTE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date strDte;
	@Basic(optional = false)
	@Column(name = "END_DTE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDte;
	@Basic(optional = false)
	@Column(name = "CTRY_CD")
	private long ctryCd;
	@Basic(optional = false)
	@Column(name = "LOC")
	private String loc;
	@Column(name = "RMK")
	private String rmk;
	@Basic(optional = false)
	@Column(name = "STS_CD")
	private long stsCd;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "prjId", fetch = FetchType.LAZY)
	private List<ProjectExperienceDto> projectExperienceList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "prjId", fetch = FetchType.LAZY)
	private List<ProjectMemberDto> projectMemberList;
	@JoinColumn(name = "PRJ_PROP_ID", referencedColumnName = "PRJ_PROP_ID")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private ProjectProposalDto prjPropId;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "prjId", fetch = FetchType.LAZY)
	private List<ProjectInterestDto> projectInterestList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "prjId", fetch = FetchType.LAZY)
	private List<ProjectTaskDto> projectTaskList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "prjId", fetch = FetchType.LAZY)
	private List<ProjectFeedbackDto> projectFeedbackList;

	public ProjectDto() {
	}

	public ProjectDto(Long prjId) {
		this.prjId = prjId;
	}

	public ProjectDto(Long prjId, String nme, String desc, Date strDte,
			Date endDte, long ctryCd, String loc, long stsCd, String createdBy,
			Date createdDte, String updBy, Date updDte, int version) {
		this.prjId = prjId;
		this.nme = nme;
		this.desc = desc;
		this.strDte = strDte;
		this.endDte = endDte;
		this.ctryCd = ctryCd;
		this.loc = loc;
		this.stsCd = stsCd;
		setCreatedBy(createdBy);
		setCreatedDte(createdDte);
		setUpdBy(updBy);
		setUpdDte(updDte);
		setVersion(version);
	}

	public Long getPrjId() {
		return prjId;
	}

	public void setPrjId(Long prjId) {
		this.prjId = prjId;
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

	public String getPrjMgr() {
		return prjMgr;
	}

	public void setPrjMgr(String prjMgr) {
		this.prjMgr = prjMgr;
	}

	public Date getStrDte() {
		return strDte;
	}

	public void setStrDte(Date strDte) {
		this.strDte = strDte;
	}

	public Date getEndDte() {
		return endDte;
	}

	public void setEndDte(Date endDte) {
		this.endDte = endDte;
	}

	public long getCtryCd() {
		return ctryCd;
	}

	public void setCtryCd(long ctryCd) {
		this.ctryCd = ctryCd;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getRmk() {
		return rmk;
	}

	public void setRmk(String rmk) {
		this.rmk = rmk;
	}

	public long getStsCd() {
		return stsCd;
	}

	public void setStsCd(long stsCd) {
		this.stsCd = stsCd;
	}

	public List<ProjectExperienceDto> getProjectExperienceList() {
		return projectExperienceList;
	}

	public void setProjectExperienceList(
			List<ProjectExperienceDto> projectExperienceList) {
		this.projectExperienceList = projectExperienceList;
	}

	public List<ProjectMemberDto> getProjectMemberList() {
		return projectMemberList;
	}

	public void setTbProjectMemberList(List<ProjectMemberDto> projectMemberList) {
		this.projectMemberList = projectMemberList;
	}

	public ProjectProposalDto getPrjPropId() {
		return prjPropId;
	}

	public void setPrjPropId(ProjectProposalDto prjPropId) {
		this.prjPropId = prjPropId;
	}

	public List<ProjectInterestDto> getProjectInterestList() {
		return projectInterestList;
	}

	public void setProjectInterestList(
			List<ProjectInterestDto> projectInterestList) {
		this.projectInterestList = projectInterestList;
	}

	public List<ProjectTaskDto> getProjectTaskList() {
		return projectTaskList;
	}

	public void setProjectTaskList(List<ProjectTaskDto> projectTaskList) {
		this.projectTaskList = projectTaskList;
	}

	public List<ProjectFeedbackDto> getProjectFeedbackList() {
		return projectFeedbackList;
	}

	public void setProjectFeedbackList(
			List<ProjectFeedbackDto> projectFeedbackList) {
		this.projectFeedbackList = projectFeedbackList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (prjId != null ? prjId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ProjectDto)) {
			return false;
		}
		ProjectDto other = (ProjectDto) object;
		if ((this.prjId == null && other.prjId != null)
				|| (this.prjId != null && !this.prjId.equals(other.prjId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "sg.edu.nus.iss.vms.common.dto.ProjectDto[ prjId=" + prjId
				+ " ]";
	}
}
