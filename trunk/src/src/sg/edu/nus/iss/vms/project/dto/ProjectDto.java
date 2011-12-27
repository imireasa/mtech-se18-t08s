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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import sg.edu.nus.iss.vms.common.dto.BaseVersionDto;

/**
 *
 * @author zaw
 */
@Entity
@Table(name = "tb_project")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "ProjectDto.findAll", query = "SELECT t FROM ProjectDto t"),
        @NamedQuery(name = "ProjectDto.findByPrjId", query = "SELECT t FROM ProjectDto t WHERE t.prjId = :prjId"),
        @NamedQuery(name = "ProjectDto.findByNme", query = "SELECT t FROM ProjectDto t WHERE t.nme = :nme"),
        @NamedQuery(name = "ProjectDto.findByDesc", query = "SELECT t FROM ProjectDto t WHERE t.desc = :desc"),
        @NamedQuery(name = "ProjectDto.findByPrjMgr", query = "SELECT t FROM ProjectDto t WHERE t.prjMgr = :prjMgr"),
        @NamedQuery(name = "ProjectDto.findByStrDte", query = "SELECT t FROM ProjectDto t WHERE t.strDte = :strDte"),
        @NamedQuery(name = "ProjectDto.findByEndDte", query = "SELECT t FROM ProjectDto t WHERE t.endDte = :endDte"),
        @NamedQuery(name = "ProjectDto.findByCtryCd", query = "SELECT t FROM ProjectDto t WHERE t.ctryCd = :ctryCd"),
        @NamedQuery(name = "ProjectDto.findByLoc", query = "SELECT t FROM ProjectDto t WHERE t.loc = :loc"),
        @NamedQuery(name = "ProjectDto.findByRmk", query = "SELECT t FROM ProjectDto t WHERE t.rmk = :rmk"),
        @NamedQuery(name = "ProjectDto.findByStsCd", query = "SELECT t FROM ProjectDto t WHERE t.stsCd = :stsCd")})
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
        private Date strDte;
        @Basic(optional = false)
        @Column(name = "END_DTE")
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
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "prjId")
        private List<ProjectExperenceDto> tbProjectExperenceList;
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "prjId")
        private List<ProjectIntrestDto> tbProjectIntrestList;
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "prjId")
        private List<ProjectMemberDto> tbProjectMemberList;
        @JoinColumn(name = "PRJ_PROP_ID", referencedColumnName = "PRJ_PROP_ID")
        @ManyToOne(optional = false)
        private ProjectProposalDto prjPropId;
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "prjId")
        private List<ProjectTaskDto> tbProjectTaskList;
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "prjId")
        private List<ProjectFeedbackDto> tbProjectFeedbackList;

        public ProjectDto() {
        }

        public ProjectDto(Long prjId) {
                this.prjId = prjId;
        }

        public ProjectDto(Long prjId, String nme, String desc, Date strDte, Date endDte, long ctryCd, String loc, long stsCd, String createdBy, Date createDte, String updBy, Date updDte, int version) {
                this.prjId = prjId;
                this.nme = nme;
                this.desc = desc;
                this.strDte = strDte;
                this.endDte = endDte;
                this.ctryCd = ctryCd;
                this.loc = loc;
                this.stsCd = stsCd;
                setCreatedBy(createdBy);
                setCreatedDte(createDte);
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

        @XmlTransient
        public List<ProjectExperenceDto> getTbProjectExperenceList() {
                return tbProjectExperenceList;
        }

        public void setTbProjectExperenceList(List<ProjectExperenceDto> tbProjectExperenceList) {
                this.tbProjectExperenceList = tbProjectExperenceList;
        }

        @XmlTransient
        public List<ProjectIntrestDto> getTbProjectIntrestList() {
                return tbProjectIntrestList;
        }

        public void setTbProjectIntrestList(List<ProjectIntrestDto> tbProjectIntrestList) {
                this.tbProjectIntrestList = tbProjectIntrestList;
        }

        @XmlTransient
        public List<ProjectMemberDto> getTbProjectMemberList() {
                return tbProjectMemberList;
        }

        public void setTbProjectMemberList(List<ProjectMemberDto> tbProjectMemberList) {
                this.tbProjectMemberList = tbProjectMemberList;
        }

        public ProjectProposalDto getPrjPropId() {
                return prjPropId;
        }

        public void setPrjPropId(ProjectProposalDto prjPropId) {
                this.prjPropId = prjPropId;
        }

        @XmlTransient
        public List<ProjectTaskDto> getTbProjectTaskList() {
                return tbProjectTaskList;
        }

        public void setTbProjectTaskList(List<ProjectTaskDto> tbProjectTaskList) {
                this.tbProjectTaskList = tbProjectTaskList;
        }

        @XmlTransient
        public List<ProjectFeedbackDto> getTbProjectFeedbackList() {
                return tbProjectFeedbackList;
        }

        public void setTbProjectFeedbackList(List<ProjectFeedbackDto> tbProjectFeedbackList) {
                this.tbProjectFeedbackList = tbProjectFeedbackList;
        }

        @Override
        public int hashCode() {
                int hash = 0;
                hash += (prjId != null ? prjId.hashCode() : 0);
                return hash;
        }

        @Override
        public boolean equals(Object object) {
                // TODO: Warning - this method won't work in the case the id fields are not set
                if (!(object instanceof ProjectDto)) {
                        return false;
                }
                ProjectDto other = (ProjectDto) object;
                if ((this.prjId == null && other.prjId != null) || (this.prjId != null && !this.prjId.equals(other.prjId))) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "sg.edu.nus.iss.vms.common.dto.ProjectDto[ prjId=" + prjId + " ]";
        }
}
