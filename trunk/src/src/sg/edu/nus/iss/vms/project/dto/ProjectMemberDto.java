/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.project.dto;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zaw
 */
@Entity
@Table(name = "tb_project_member")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "ProjectMemberDto.findAll", query = "SELECT t FROM ProjectMemberDto t"),
        @NamedQuery(name = "ProjectMemberDto.findByPrjMbrId", query = "SELECT t FROM ProjectMemberDto t WHERE t.prjMbrId = :prjMbrId"),
        @NamedQuery(name = "ProjectMemberDto.findByUsrLoginId", query = "SELECT t FROM ProjectMemberDto t WHERE t.usrLoginId = :usrLoginId"),
        @NamedQuery(name = "ProjectMemberDto.findByRoleCd", query = "SELECT t FROM ProjectMemberDto t WHERE t.roleCd = :roleCd"),
        @NamedQuery(name = "ProjectMemberDto.findByActInd", query = "SELECT t FROM ProjectMemberDto t WHERE t.actInd = :actInd"),
        @NamedQuery(name = "ProjectMemberDto.findByCreatedBy", query = "SELECT t FROM ProjectMemberDto t WHERE t.createdBy = :createdBy"),
        @NamedQuery(name = "ProjectMemberDto.findByCreatedDte", query = "SELECT t FROM ProjectMemberDto t WHERE t.createdDte = :createdDte"),
        @NamedQuery(name = "ProjectMemberDto.findByUpdBy", query = "SELECT t FROM ProjectMemberDto t WHERE t.updBy = :updBy"),
        @NamedQuery(name = "ProjectMemberDto.findByUpdDte", query = "SELECT t FROM ProjectMemberDto t WHERE t.updDte = :updDte"),
        @NamedQuery(name = "ProjectMemberDto.findByVersion", query = "SELECT t FROM ProjectMemberDto t WHERE t.version = :version")})
public class ProjectMemberDto implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "PRJ_MBR_ID")
        private Long prjMbrId;
        @Basic(optional = false)
        @Column(name = "USR_LOGIN_ID")
        private String usrLoginId;
        @Basic(optional = false)
        @Column(name = "ROLE_CD")
        private long roleCd;
        @Basic(optional = false)
        @Column(name = "ACT_IND")
        private boolean actInd;
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
        @Column(name = "UPD_DTE")
        private Date updDte;
        @Basic(optional = false)
        @Column(name = "VERSION")
        private int version;
        @JoinColumn(name = "PRJ_ID", referencedColumnName = "PRJ_ID")
        @ManyToOne(optional = false)
        private ProjectDto prjId;

        public ProjectMemberDto() {
        }

        public ProjectMemberDto(Long prjMbrId) {
                this.prjMbrId = prjMbrId;
        }

        public ProjectMemberDto(Long prjMbrId, String usrLoginId, long roleCd, boolean actInd, String createdBy, Date createdDte, String updBy, Date updDte, int version) {
                this.prjMbrId = prjMbrId;
                this.usrLoginId = usrLoginId;
                this.roleCd = roleCd;
                this.actInd = actInd;
                this.createdBy = createdBy;
                this.createdDte = createdDte;
                this.updBy = updBy;
                this.updDte = updDte;
                this.version = version;
        }

        public Long getPrjMbrId() {
                return prjMbrId;
        }

        public void setPrjMbrId(Long prjMbrId) {
                this.prjMbrId = prjMbrId;
        }

        public String getUsrLoginId() {
                return usrLoginId;
        }

        public void setUsrLoginId(String usrLoginId) {
                this.usrLoginId = usrLoginId;
        }

        public long getRoleCd() {
                return roleCd;
        }

        public void setRoleCd(long roleCd) {
                this.roleCd = roleCd;
        }

        public boolean getActInd() {
                return actInd;
        }

        public void setActInd(boolean actInd) {
                this.actInd = actInd;
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

        public Date getUpdDte() {
                return updDte;
        }

        public void setUpdDte(Date updDte) {
                this.updDte = updDte;
        }

        public int getVersion() {
                return version;
        }

        public void setVersion(int version) {
                this.version = version;
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
                hash += (prjMbrId != null ? prjMbrId.hashCode() : 0);
                return hash;
        }

        @Override
        public boolean equals(Object object) {
                // TODO: Warning - this method won't work in the case the id fields are not set
                if (!(object instanceof ProjectMemberDto)) {
                        return false;
                }
                ProjectMemberDto other = (ProjectMemberDto) object;
                if ((this.prjMbrId == null && other.prjMbrId != null) || (this.prjMbrId != null && !this.prjMbrId.equals(other.prjMbrId))) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "sg.edu.nus.iss.vms.common.dto.ProjectMemberDto[ prjMbrId=" + prjMbrId + " ]";
        }
}
