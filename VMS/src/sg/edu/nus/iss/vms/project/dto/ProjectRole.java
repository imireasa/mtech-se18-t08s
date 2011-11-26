/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.project.dto;

import java.io.Serializable;
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
import javax.persistence.Table;

import sg.edu.nus.iss.vms.common.dto.BaseTable;

/**
 *
 * @author zaw
 */
@Entity
@Table(name = "project_role")
@NamedQueries({
    @NamedQuery(name = "ProjectRole.findAll", query = "SELECT p FROM ProjectRole p")})
public class ProjectRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RoleId")
    private Integer roleId;
    @Basic(optional = false)
    @Column(name = "RoleName")
    private String roleName;
    @Column(name = "IsDeleted")
    private Short isDeleted;
    @JoinColumn(name = "BaseId", referencedColumnName = "BaseId")
    @ManyToOne(fetch = FetchType.EAGER)
    private BaseTable baseId;


    public ProjectRole() {
    }

    public ProjectRole(Integer roleId) {
        this.roleId = roleId;
    }

    public ProjectRole(Integer roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Short getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Short isDeleted) {
        this.isDeleted = isDeleted;
    }

    public BaseTable getBaseId() {
        return baseId;
    }

    public void setBaseId(BaseTable baseId) {
        this.baseId = baseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectRole)) {
            return false;
        }
        ProjectRole other = (ProjectRole) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sg.edu.nus.iss.vms.common.dto.ProjectRole[ roleId=" + roleId + " ]";
    }
    
}
