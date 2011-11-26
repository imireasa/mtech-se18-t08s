/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.project.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

import sg.edu.nus.iss.vms.common.dto.Codes;

/**
 *
 * @author zaw
 */
@Entity
@Table(name = "project")
@NamedQueries({
    @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p")})
public class Project implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProjectId")
    private Long projectId;
    @Basic(optional = false)
    @Column(name = "ProjectName")
    private String projectName;
    @Column(name = "ProjectStartDate")
    @Temporal(TemporalType.DATE)
    private Date projectStartDate;
    @Column(name = "ProjectInitiator")
    private BigInteger projectInitiator;
    @Column(name = "ProjectEndDate")
    @Temporal(TemporalType.DATE)
    private Date projectEndDate;
    @Column(name = "BaseId")
    private BigInteger baseId;
    @Column(name = "IsDeleted")
    private Short isDeleted;
    @JoinColumn(name = "ProjectStatus", referencedColumnName = "CodeId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Codes projectStatus;
    @OneToMany(mappedBy = "projectId", fetch = FetchType.LAZY)
    private List<ProjectMember> projectMemberList;

    public Project() {
    }

    public Project(Long projectId) {
        this.projectId = projectId;
    }

    public Project(Long projectId, String projectName) {
        this.projectId = projectId;
        this.projectName = projectName;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getProjectStartDate() {
        return projectStartDate;
    }

    public void setProjectStartDate(Date projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    public BigInteger getProjectInitiator() {
        return projectInitiator;
    }

    public void setProjectInitiator(BigInteger projectInitiator) {
        this.projectInitiator = projectInitiator;
    }

    public Date getProjectEndDate() {
        return projectEndDate;
    }

    public void setProjectEndDate(Date projectEndDate) {
        this.projectEndDate = projectEndDate;
    }

    public BigInteger getBaseId() {
        return baseId;
    }

    public void setBaseId(BigInteger baseId) {
        this.baseId = baseId;
    }

    public Short getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Short isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Codes getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(Codes projectStatus) {
        this.projectStatus = projectStatus;
    }

    public List<ProjectMember> getProjectMemberList() {
        return projectMemberList;
    }

    public void setProjectMemberList(List<ProjectMember> projectMemberList) {
        this.projectMemberList = projectMemberList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectId != null ? projectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.projectId == null && other.projectId != null) || (this.projectId != null && !this.projectId.equals(other.projectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sg.edu.nus.iss.vms.common.dto.Project[ projectId=" + projectId + " ]";
    }
    
}
