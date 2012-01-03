/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.project.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import sg.edu.nus.iss.vms.common.dto.BaseVersionDto;

/**
 *
 * @author zaw
 */
@Entity
@Table(name = "tb_project_proposal")
@NamedQueries({
        @NamedQuery(name = "ProjectProposalDto.findAll", query = "SELECT t FROM ProjectProposalDto t")})
public class ProjectProposalDto extends BaseVersionDto implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "PRJ_PROP_ID")
        private Long prjPropId;
        @Basic(optional = false)
        @Column(name = "NME")
        private String nme;
        @Column(name = "PRJ_PROP_DESC")
        private String desc;
        @Basic(optional = false)
        @Column(name = "CTRY_CD")
        private Long ctryCd;
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
        @Temporal(TemporalType.TIMESTAMP)
        private Date apprDte;
        @Basic(optional = false)
        @Column(name = "STS_CD")
        private Long stsCd;
        @Column(name = "RMK")
        private String rmk;
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "prjPropId", fetch = FetchType.LAZY)
        private List<ProjectDto> tbProjectList;
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "prjPropId", fetch = FetchType.LAZY)
        private List<ProjectProposalDocumentDto> tbProjectProposalDocumentList;

        public ProjectProposalDto() {
        }

        public ProjectProposalDto(Long prjPropId) {
                this.prjPropId = prjPropId;
        }

        public ProjectProposalDto(Long prjPropId, String nme, Long ctryCd, String loc, int estDur, String proposerId, Long stsCd, String createdBy, Date createdDte, String updBy, Date updDte, int version) {
                this.prjPropId = prjPropId;
                this.nme = nme;
                this.ctryCd = ctryCd;
                this.loc = loc;
                this.estDur = estDur;
                this.proposerId = proposerId;
                this.stsCd = stsCd;
                setCreatedBy(createdBy);
                setCreatedDte(createdDte);
                setUpdBy(updBy);
                setUpdDte(updDte);
                setVersion(version);
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

        public List<ProjectDto> getTbProjectList() {
                return tbProjectList;
        }

        public void setTbProjectList(List<ProjectDto> tbProjectList) {
                this.tbProjectList = tbProjectList;
        }

        public List<ProjectProposalDocumentDto> getTbProjectProposalDocumentList() {
                return tbProjectProposalDocumentList;
        }

        public void setTbProjectProposalDocumentList(List<ProjectProposalDocumentDto> tbProjectProposalDocumentList) {
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
                // TODO: Warning - this method won't work in the case the id fields are not set
                if (!(object instanceof ProjectProposalDto)) {
                        return false;
                }
                ProjectProposalDto other = (ProjectProposalDto) object;
                if ((this.prjPropId == null && other.prjPropId != null) || (this.prjPropId != null && !this.prjPropId.equals(other.prjPropId))) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "sg.edu.nus.iss.vms.common.dto.ProjectProposalDto[ prjPropId=" + prjPropId + " ]";
        }
}
