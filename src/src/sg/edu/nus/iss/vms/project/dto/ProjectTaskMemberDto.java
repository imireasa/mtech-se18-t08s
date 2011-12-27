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
@Table(name = "tb_project_task_member")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectTaskMemberDto.findAll", query = "SELECT t FROM ProjectTaskMemberDto t"),
    @NamedQuery(name = "ProjectTaskMemberDto.findByPrjTaskMbrId", query = "SELECT t FROM ProjectTaskMemberDto t WHERE t.prjTaskMbrId = :prjTaskMbrId"),
    @NamedQuery(name = "ProjectTaskMemberDto.findByUsrLoginId", query = "SELECT t FROM ProjectTaskMemberDto t WHERE t.usrLoginId = :usrLoginId"),
    @NamedQuery(name = "ProjectTaskMemberDto.findByActInd", query = "SELECT t FROM ProjectTaskMemberDto t WHERE t.actInd = :actInd"),
    @NamedQuery(name = "ProjectTaskMemberDto.findByCreatedBy", query = "SELECT t FROM ProjectTaskMemberDto t WHERE t.createdBy = :createdBy"),
    @NamedQuery(name = "ProjectTaskMemberDto.findByCreatedDte", query = "SELECT t FROM ProjectTaskMemberDto t WHERE t.createdDte = :createdDte"),
    @NamedQuery(name = "ProjectTaskMemberDto.findByUpdBy", query = "SELECT t FROM ProjectTaskMemberDto t WHERE t.updBy = :updBy"),
    @NamedQuery(name = "ProjectTaskMemberDto.findByUpdDte", query = "SELECT t FROM ProjectTaskMemberDto t WHERE t.updDte = :updDte"),
    @NamedQuery(name = "ProjectTaskMemberDto.findByVersion", query = "SELECT t FROM ProjectTaskMemberDto t WHERE t.version = :version")})
public class ProjectTaskMemberDto implements Serializable {
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
    @JoinColumn(name = "PRJ_TASK_ID", referencedColumnName = "PRJ_TASK_ID")
    @ManyToOne(optional = false)
    private ProjectTaskDto prjTaskId;

    public ProjectTaskMemberDto() {
    }

    public ProjectTaskMemberDto(Long prjTaskMbrId) {
        this.prjTaskMbrId = prjTaskMbrId;
    }

    public ProjectTaskMemberDto(Long prjTaskMbrId, String usrLoginId, boolean actInd, String createdBy, Date createdDte, String updBy, Date updDte, int version) {
        this.prjTaskMbrId = prjTaskMbrId;
        this.usrLoginId = usrLoginId;
        this.actInd = actInd;
        this.createdBy = createdBy;
        this.createdDte = createdDte;
        this.updBy = updBy;
        this.updDte = updDte;
        this.version = version;
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
