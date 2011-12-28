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
@Table(name = "tb_project_task_member")
@NamedQueries({
        @NamedQuery(name = "ProjectTaskMemberDto.findAll", query = "SELECT t FROM ProjectTaskMemberDto t")})
public class ProjectTaskMemberDto extends BaseVersionDto implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "PRJ_TASK_MBR_ID")
        private Long prjTaskMbrId;
        @Basic(optional = false)
        @Column(name = "USR_LOGIN_ID")
        private String usrLoginId;
        @Basic(optional = false)
        @Column(name = "DEL_IND")
        private boolean delInd;
        @JoinColumn(name = "PRJ_TASK_ID", referencedColumnName = "PRJ_TASK_ID")
        @ManyToOne(optional = false, fetch = FetchType.EAGER)
        private ProjectTaskDto prjTaskId;

        public ProjectTaskMemberDto() {
        }

        public ProjectTaskMemberDto(Long prjTaskMbrId) {
                this.prjTaskMbrId = prjTaskMbrId;
        }

        public ProjectTaskMemberDto(Long prjTaskMbrId, String usrLoginId, boolean delInd, String createdBy, Date createdDte, String updBy, Date updDte, int version) {
                this.prjTaskMbrId = prjTaskMbrId;
                this.usrLoginId = usrLoginId;
                this.delInd = delInd;
                setCreatedBy(createdBy);
                setCreatedDte(createdDte);
                setUpdBy(updBy);
                setUpdDte(updDte);
                setVersion(version);
        }

        public Long getPrjTaskMbrId() {
                return prjTaskMbrId;
        }

        public void setPrjTaskMbrId(Long prjTaskMbrId) {
                this.prjTaskMbrId = prjTaskMbrId;
        }

        public String getUsrLoginId() {
                return usrLoginId;
        }

        public void setUsrLoginId(String usrLoginId) {
                this.usrLoginId = usrLoginId;
        }

        public boolean getDelInd() {
                return delInd;
        }

        public void setDelInd(boolean delInd) {
                this.delInd = delInd;
        }

        public ProjectTaskDto getPrjTaskId() {
                return prjTaskId;
        }

        public void setPrjTaskId(ProjectTaskDto prjTaskId) {
                this.prjTaskId = prjTaskId;
        }

        @Override
        public int hashCode() {
                int hash = 0;
                hash += (prjTaskMbrId != null ? prjTaskMbrId.hashCode() : 0);
                return hash;
        }

        @Override
        public boolean equals(Object object) {
                // TODO: Warning - this method won't work in the case the id fields are not set
                if (!(object instanceof ProjectTaskMemberDto)) {
                        return false;
                }
                ProjectTaskMemberDto other = (ProjectTaskMemberDto) object;
                if ((this.prjTaskMbrId == null && other.prjTaskMbrId != null) || (this.prjTaskMbrId != null && !this.prjTaskMbrId.equals(other.prjTaskMbrId))) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "sg.edu.nus.iss.vms.common.dto.ProjectTaskMemberDto[ prjTaskMbrId=" + prjTaskMbrId + " ]";
        }
}
