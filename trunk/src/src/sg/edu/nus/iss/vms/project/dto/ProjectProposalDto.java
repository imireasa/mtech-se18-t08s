/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.project.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 
 * @author zaw
 */
@Entity
@Table(name = "tb_project_proposal")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "ProjectProposalDto.findAll", query = "SELECT t FROM ProjectProposalDto t"),
		@NamedQuery(name = "ProjectProposalDto.findByPrjPropId", query = "SELECT t FROM ProjectProposalDto t WHERE t.prjPropId = :prjPropId"),
		@NamedQuery(name = "ProjectProposalDto.findByNme", query = "SELECT t FROM ProjectProposalDto t WHERE t.nme = :nme"),
		@NamedQuery(name = "ProjectProposalDto.findByDesc", query = "SELECT t FROM ProjectProposalDto t WHERE t.desc = :desc"),
		@NamedQuery(name = "ProjectProposalDto.findByCtryCd", query = "SELECT t FROM ProjectProposalDto t WHERE t.ctryCd = :ctryCd"),
		@NamedQuery(name = "ProjectProposalDto.findByLoc", query = "SELECT t FROM ProjectProposalDto t WHERE t.loc = :loc"),
		@NamedQuery(name = "ProjectProposalDto.findByEstDur", query = "SELECT t FROM ProjectProposalDto t WHERE t.estDur = :estDur"),
		@NamedQuery(name = "ProjectProposalDto.findByProposerId", query = "SELECT t FROM ProjectProposalDto t WHERE t.proposerId = :proposerId"),
		@NamedQuery(name = "ProjectProposalDto.findByApprBy", query = "SELECT t FROM ProjectProposalDto t WHERE t.apprBy = :apprBy"),
		@NamedQuery(name = "ProjectProposalDto.findByApprDte", query = "SELECT t FROM ProjectProposalDto t WHERE t.apprDte = :apprDte"),
		@NamedQuery(name = "ProjectProposalDto.findByStsCd", query = "SELECT t FROM ProjectProposalDto t WHERE t.stsCd = :stsCd"),
		@NamedQuery(name = "ProjectProposalDto.findByRmk", query = "SELECT t FROM ProjectProposalDto t WHERE t.rmk = :rmk"),
		@NamedQuery(name = "ProjectProposalDto.findByCreatedBy", query = "SELECT t FROM ProjectProposalDto t WHERE t.createdBy = :createdBy"),
		@NamedQuery(name = "ProjectProposalDto.findByCreatedDte", query = "SELECT t FROM ProjectProposalDto t WHERE t.createdDte = :createdDte"),
		@NamedQuery(name = "ProjectProposalDto.findByUpdBy", query = "SELECT t FROM ProjectProposalDto t WHERE t.updBy = :updBy"),
		@NamedQuery(name = "ProjectProposalDto.findByUpsDte", query = "SELECT t FROM ProjectProposalDto t WHERE t.upsDte = :upsDte"),
		@NamedQuery(name = "ProjectProposalDto.findByVersion", query = "SELECT t FROM ProjectProposalDto t WHERE t.version = :version") })
public class ProjectProposalDto implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "PRJ_PROP_ID")
	private Long prjPropId;
	@Basic(optional = false)
	@Column(name = "NME")
	private String nme;
	@Column(name = "DESC")
	private String desc;
	@Basic(optional = false)
	@Column(name = "CTRY_CD")
	private long ctryCd;
	@Basic(optional = false)
	@Column(name = "LOC")
	private String loc;
	@Basic(optional = false)
	@Column(name = "EST_DUR")
	private int estDur;
	@Basic(optional = false)
	@Column(name = "PROPOSER_ID")
	private String proposerId;
	@Column(name = "APPR_BY")
	private String apprBy;
	@Column(name = "APPR_DTE")
	private Date apprDte;
	@Basic(optional = false)
	@Column(name = "STS_CD")
	private long stsCd;
	@Column(name = "RMK")
	private String rmk;
	@Basic(optional = false)
	@Column(name = "CREATED_BY")
	private String createdBy;
	@Basic(optional = false)
	@Column(name = "CREATED_DTE")
	private Date createdDte;
	@Basic(optional = false)
	@Column(name = "UPD_BY")
	private String updBy;
	@Basic(optional = false)
	@Column(name = "UPS_DTE")
	private Date upsDte;
	@Basic(optional = false)
	@Column(name = "VERSION")
	private int version;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "prjPropId")
	private List<ProjectDto> tbProjectList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "prjPropId")
	private List<ProjectProposalDocumentDto> tbProjectProposalDocumentList;

	public ProjectProposalDto() {
	}

	public ProjectProposalDto(Long prjPropId) {
		this.prjPropId = prjPropId;
	}

	public ProjectProposalDto(Long prjPropId, String nme, long ctryCd,
			String loc, int estDur, String proposerId, long stsCd,
			String createdBy, Date createdDte, String updBy, Date upsDte,
			int version) {
		this.prjPropId = prjPropId;
		this.nme = nme;
		this.ctryCd = ctryCd;
		this.loc = loc;
		this.estDur = estDur;
		this.proposerId = proposerId;
		this.stsCd = stsCd;
		this.createdBy = createdBy;
		this.createdDte = createdDte;
		this.updBy = updBy;
		this.upsDte = upsDte;
		this.version = version;
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

	public long getStsCd() {
		return stsCd;
	}

	public void setStsCd(long stsCd) {
		this.stsCd = stsCd;
	}

	public String getRmk() {
		return rmk;
	}

	public void setRmk(String rmk) {
		this.rmk = rmk;
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

	public String getUpdBy() {
		return updBy;
	}

	public void setUpdBy(String updBy) {
		this.updBy = updBy;
	}

	public Date getUpsDte() {
		return upsDte;
	}

	public void setUpsDte(Date upsDte) {
		this.upsDte = upsDte;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@XmlTransient
	public List<ProjectDto> getTbProjectList() {
		return tbProjectList;
	}

	public void setTbProjectList(List<ProjectDto> tbProjectList) {
		this.tbProjectList = tbProjectList;
	}

	@XmlTransient
	public List<ProjectProposalDocumentDto> getTbProjectProposalDocumentList() {
		return tbProjectProposalDocumentList;
	}

	public void setTbProjectProposalDocumentList(
			List<ProjectProposalDocumentDto> tbProjectProposalDocumentList) {
		this.tbProjectProposalDocumentList = tbProjectProposalDocumentList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (prjPropId != null ? prjPropId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ProjectProposalDto)) {
			return false;
		}
		ProjectProposalDto other = (ProjectProposalDto) object;
		if ((this.prjPropId == null && other.prjPropId != null)
				|| (this.prjPropId != null && !this.prjPropId
						.equals(other.prjPropId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "sg.edu.nus.iss.vms.common.dto.ProjectProposalDto[ prjPropId="
				+ prjPropId + " ]";
	}
}
