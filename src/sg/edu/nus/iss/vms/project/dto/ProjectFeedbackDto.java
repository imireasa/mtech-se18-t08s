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
 *
 * @author zaw
 */
@Entity
@Table(name = "tb_project_feedback")
@NamedQueries({
        @NamedQuery(name = "ProjectFeedbackDto.findAll", query = "SELECT t FROM ProjectFeedbackDto t")})
public class ProjectFeedbackDto extends BaseVersionDto implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "PRJ_FB_ID")
        private Long prjFbId;
        @Basic(optional = false)
        @Column(name = "TITLE")
        private String title;
        @Basic(optional = false)
        @Lob
        @Column(name = "CONT")
        private String cont;
        @Column(name = "APPR_BY")
        private String apprBy;
        @Column(name = "APPR_DTE")
        @Temporal(TemporalType.TIMESTAMP)
        private Date apprDte;
        @Basic(optional = false)
        @Column(name = "STS_CD")
        private Long stsCd;
        @JoinColumn(name = "PRJ_ID", referencedColumnName = "PRJ_ID")
        @ManyToOne(optional = false, fetch = FetchType.EAGER)
        private ProjectDto prjId;

        public ProjectFeedbackDto() {
        }

        public ProjectFeedbackDto(Long prjFbId) {
                this.prjFbId = prjFbId;
        }

        public ProjectFeedbackDto(Long prjFbId, String title, String cont, Long stsCd, String createdBy, Date createdDte, String updBy, Date updDte, int version) {
                this.prjFbId = prjFbId;
                this.title = title;
                this.cont = cont;
                this.stsCd = stsCd;
                setCreatedBy(createdBy);
                setCreatedDte(createdDte);
                setUpdBy(updBy);
                setUpdDte(updDte);
                setVersion(version);
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
                hash += (prjFbId != null ? prjFbId.hashCode() : 0);
                return hash;
        }

        @Override
        public boolean equals(Object object) {
                // TODO: Warning - this method won't work in the case the id fields are not set
                if (!(object instanceof ProjectFeedbackDto)) {
                        return false;
                }
                ProjectFeedbackDto other = (ProjectFeedbackDto) object;
                if ((this.prjFbId == null && other.prjFbId != null) || (this.prjFbId != null && !this.prjFbId.equals(other.prjFbId))) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "sg.edu.nus.iss.vms.common.dto.ProjectFeedbackDto[ prjFbId=" + prjFbId + " ]";
        }
}
