/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.common.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
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

/**
 *
 * @author zaw
 */
@Entity
@Table(name = "project_member")
@NamedQueries({
    @NamedQuery(name = "ProjectMember.findAll", query = "SELECT p FROM ProjectMember p")})
public class ProjectMember implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProjectMemberId")
    private Long projectMemberId;
    @Basic(optional = false)
    @Column(name = "VolunteerId")
    private long volunteerId;
    @Column(name = "JoinDate")
    @Temporal(TemporalType.DATE)
    private Date joinDate;
    @Column(name = "ProjectId")
    private BigInteger projectId;
    @Column(name = "IsDeleted")
    private Short isDeleted;
    @JoinColumn(name = "RoleId", referencedColumnName = "RoleId")
    @ManyToOne
    private ProjectRole projectRole;
    @JoinColumn(name = "BaseId", referencedColumnName = "BaseId")
    @ManyToOne
    private BaseTable baseTable;
    @JoinColumn(name = "MemberStatus", referencedColumnName = "CodeId")
    @ManyToOne
    private Codes codes;

    public ProjectMember() {
    }

    public ProjectMember(Long projectMemberId) {
        this.projectMemberId = projectMemberId;
    }

    public ProjectMember(Long projectMemberId, long volunteerId) {
        this.projectMemberId = projectMemberId;
        this.volunteerId = volunteerId;
    }

    public Long getProjectMemberId() {
        return projectMemberId;
    }

    public void setProjectMemberId(Long projectMemberId) {
        this.projectMemberId = projectMemberId;
    }

    public long getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(long volunteerId) {
        this.volunteerId = volunteerId;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public Short getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Short isDeleted) {
        this.isDeleted = isDeleted;
    }

    public ProjectRole getProjectRole() {
        return projectRole;
    }

    public void setProjectRole(ProjectRole projectRole) {
        this.projectRole = projectRole;
    }

    public BaseTable getBaseTable() {
        return baseTable;
    }

    public void setBaseTable(BaseTable baseTable) {
        this.baseTable = baseTable;
    }

    public Codes getCodes() {
        return codes;
    }

    public void setCodes(Codes codes) {
        this.codes = codes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectMemberId != null ? projectMemberId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectMember)) {
            return false;
        }
        ProjectMember other = (ProjectMember) object;
        if ((this.projectMemberId == null && other.projectMemberId != null) || (this.projectMemberId != null && !this.projectMemberId.equals(other.projectMemberId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sg.edu.nus.iss.vms.common.dto.ProjectMember[ projectMemberId=" + projectMemberId + " ]";
    }
    
}
