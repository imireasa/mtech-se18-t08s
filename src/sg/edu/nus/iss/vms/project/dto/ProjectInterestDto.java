/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.project.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import sg.edu.nus.iss.vms.common.dto.BaseVersionDto;

/**
 * @author zaw
 */
@Entity
@Table(name = "tb_project_interest")
@NamedQueries({
        @NamedQuery(name = "ProjectInterestDto.findAll", query = "SELECT t FROM ProjectInterestDto t")})
public class ProjectInterestDto extends BaseVersionDto implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "PRJ_INTRST_ID")
        private Long prjIntrstId;
        @Basic(optional = false)
        @Column(name = "REQ_BY")
        private String reqBy;
        @Column(name = "APPR_BY")
        private String apprBy;
        @Column(name = "APPR_DTE")
        @Temporal(TemporalType.TIMESTAMP)
        private Date apprDte;
        @Column(name = "APPR_RMK")
        private String apprRmk;
        @Basic(optional = false)
        @Column(name = "STS_CD")
        private Long stsCd;
        @JoinColumn(name = "PRJ_ID", referencedColumnName = "PRJ_ID")
        @ManyToOne(optional = false, fetch = FetchType.EAGER)
        private ProjectDto prjId;

        public ProjectInterestDto() {
        }

        public ProjectInterestDto(Long prjIntrstId) {
                this.prjIntrstId = prjIntrstId;
        }

        public ProjectInterestDto(Long prjIntrstId, String reqBy, Long stsCd, String createdBy, Date createdDte, String updBy, Date updDte, int version) {
                this.prjIntrstId = prjIntrstId;
                this.reqBy = reqBy;
                this.stsCd = stsCd;
                setCreatedBy(createdBy);
                setCreatedDte(createdDte);
                setUpdBy(updBy);
                setUpdDte(updDte);
                setVersion(version);
        }

        public Long getPrjIntrstId() {
                return prjIntrstId;
        }

        public void setPrjIntrstId(Long prjIntrstId) {
                this.prjIntrstId = prjIntrstId;
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

        public void setApprDte(Date apprDte) {
                this.apprDte = apprDte;
        }

        public String getApprRmk() {
                return apprRmk;
        }

        public void setApprRmk(String apprRmk) {
                this.apprRmk = apprRmk;
        }

        public Long getStsCd() {
                return stsCd;
        }

        public void setStsCd(Long stsCd) {
                this.stsCd = stsCd;
        }

        public ProjectDto getPrjId() {
                return prjId;
        }

        public void setPrjId(ProjectDto prjId) {
                this.prjId = prjId;
        }

        @Override
        public int hashCode() {
                int hash = 0;
                hash += (prjIntrstId != null ? prjIntrstId.hashCode() : 0);
                return hash;
        }

        @Override
        public boolean equals(Object object) {
                // TODO: Warning - this method won't work in the case the id fields are not set
                if (!(object instanceof ProjectInterestDto)) {
                        return false;
                }
                ProjectInterestDto other = (ProjectInterestDto) object;
                if ((this.prjIntrstId == null && other.prjIntrstId != null) || (this.prjIntrstId != null && !this.prjIntrstId.equals(other.prjIntrstId))) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "sg.edu.nus.iss.vms.common.dto.ProjectInterestDto[ prjIntrstId=" + prjIntrstId + " ]";
        }
}
