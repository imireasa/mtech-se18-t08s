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
@Table(name = "tb_project_member")
@NamedQueries({
        @NamedQuery(name = "ProjectMemberDto.findAll", query = "SELECT t FROM ProjectMemberDto t")})
public class ProjectMemberDto extends BaseVersionDto implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue
        @Basic(optional = false)
        @Column(name = "PRJ_MBR_ID")
        private Long prjMbrId;
        @Basic(optional = false)
        @Column(name = "USR_LOGIN_ID")
        private String usrLoginId;
        @Basic(optional = false)
        @Column(name = "ROLE_CD")
        private Long roleCd;
        @Basic(optional = false)
        @Column(name = "ACT_IND")
        private boolean actInd;
        @JoinColumn(name = "PRJ_ID", referencedColumnName = "PRJ_ID")
        @ManyToOne(optional = false, fetch = FetchType.EAGER)
        private ProjectDto prjId;

        public ProjectMemberDto() {
        }

        public ProjectMemberDto(Long prjMbrId) {
                this.prjMbrId = prjMbrId;
        }

        public ProjectMemberDto(Long prjMbrId, String usrLoginId, Long roleCd, boolean actInd, String createdBy, Date createdDte, String updBy, Date updDte, int version) {
                this.prjMbrId = prjMbrId;
                this.usrLoginId = usrLoginId;
                this.roleCd = roleCd;
                this.actInd = actInd;
                setCreatedBy(createdBy);
                setCreatedDte(createdDte);
                setUpdBy(updBy);
                setUpdDte(updDte);
                setVersion(version);
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

        public Long getRoleCd() {
                return roleCd;
        }

        public void setRoleCd(Long roleCd) {
                this.roleCd = roleCd;
        }

        public boolean getActInd() {
                return actInd;
        }

        public void setActInd(boolean actInd) {
                this.actInd = actInd;
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
