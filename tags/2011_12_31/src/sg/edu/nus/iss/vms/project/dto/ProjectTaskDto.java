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
@Table(name = "tb_project_task")
@NamedQueries({
        @NamedQuery(name = "ProjectTaskDto.findAll", query = "SELECT t FROM ProjectTaskDto t")})
public class ProjectTaskDto extends BaseVersionDto implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "PRJ_TASK_ID")
        private Long prjTaskId;
        @Basic(optional = false)
        @Column(name = "NME")
        private String nme;
        @Column(name = "DESC")
        private String desc;
        @Basic(optional = false)
        @Column(name = "ODR_NO")
        private int odrNo;
        @Basic(optional = false)
        @Column(name = "STR_DTE")
        @Temporal(TemporalType.TIMESTAMP)
        private Date strDte;
        @Basic(optional = false)
        @Column(name = "END_DTE")
        @Temporal(TemporalType.TIMESTAMP)
        private Date endDte;
        @Basic(optional = false)
        @Column(name = "STS_CD")
        private long stsCd;
        @Column(name = "DEL_IND")
        private Boolean delInd;
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "prjTaskId", fetch = FetchType.LAZY)
        private List<ProjectTaskMemberDto> projectTaskMemberList;
        @JoinColumn(name = "PRJ_ID", referencedColumnName = "PRJ_ID")
        @ManyToOne(optional = false, fetch = FetchType.EAGER)
        private ProjectDto prjId;

        public ProjectTaskDto() {
        }

        public ProjectTaskDto(Long prjTaskId) {
                this.prjTaskId = prjTaskId;
        }

        public ProjectTaskDto(Long prjTaskId, String nme, int odrNo, Date strDte, Date endDte, long stsCd, String createdBy, Date createdDte, String updBy, Date updDte, int version) {
                this.prjTaskId = prjTaskId;
                this.nme = nme;
                this.odrNo = odrNo;
                this.strDte = strDte;
                this.endDte = endDte;
                this.stsCd = stsCd;
                setCreatedBy(createdBy);
                setCreatedDte(createdDte);
                setUpdBy(updBy);
                setUpdDte(updDte);
                setVersion(version);
        }

        public Long getPrjTaskId() {
                return prjTaskId;
        }

        public void setPrjTaskId(Long prjTaskId) {
                this.prjTaskId = prjTaskId;
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

        public int getOdrNo() {
                return odrNo;
        }

        public void setOdrNo(int odrNo) {
                this.odrNo = odrNo;
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

        public long getStsCd() {
                return stsCd;
        }

        public void setStsCd(long stsCd) {
                this.stsCd = stsCd;
        }

        public Boolean getDelInd() {
                return delInd;
        }

        public void setDelInd(Boolean delInd) {
                this.delInd = delInd;
        }

        public List<ProjectTaskMemberDto> getProjectTaskMemberList() {
                return projectTaskMemberList;
        }

        public void setProjectTaskMemberList(List<ProjectTaskMemberDto> tbProjectTaskMemberList) {
                this.projectTaskMemberList = tbProjectTaskMemberList;
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
                hash += (prjTaskId != null ? prjTaskId.hashCode() : 0);
                return hash;
        }

        @Override
        public boolean equals(Object object) {
                // TODO: Warning - this method won't work in the case the id fields are not set
                if (!(object instanceof ProjectTaskDto)) {
                        return false;
                }
                ProjectTaskDto other = (ProjectTaskDto) object;
                if ((this.prjTaskId == null && other.prjTaskId != null) || (this.prjTaskId != null && !this.prjTaskId.equals(other.prjTaskId))) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "sg.edu.nus.iss.vms.common.dto.ProjectTaskDto[ prjTaskId=" + prjTaskId + " ]";
        }
}
