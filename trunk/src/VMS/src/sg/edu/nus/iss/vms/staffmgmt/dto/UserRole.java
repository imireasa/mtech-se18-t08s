/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.staffmgmt.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author zaw
 */
@Entity
@Table(name = "UserRole")
@NamedQueries({
    @NamedQuery(name = "UserRole.findAll", query = "SELECT u FROM UserRole u")})
public class UserRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "UserRoleId")
    private Long userRoleId;
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    @ManyToOne(optional = false)
    private Users userId;
    @JoinColumn(name = "RoleId", referencedColumnName = "RoleId")
    @ManyToOne(optional = false)
    private Role roleId;

    public UserRole() {
    }

    public UserRole(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userRoleId != null ? userRoleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRole)) {
            return false;
        }
        UserRole other = (UserRole) object;
        if ((this.userRoleId == null && other.userRoleId != null) || (this.userRoleId != null && !this.userRoleId.equals(other.userRoleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sg.edu.nus.iss.vms.common.model.dto.UserRole[ userRoleId=" + userRoleId + " ]";
    }
    
}
