/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.security.dto;

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
@Table(name = "tb_role")
@NamedQueries({
        @NamedQuery(name = "RoleDto.findAll", query = "SELECT t FROM RoleDto t")})
public class RoleDto extends BaseVersionDto implements Serializable {

        private static final Long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "ROLE_ID")
        private Long roleId;
        @Basic(optional = false)
        @Column(name = "ROLE_CD")
        private Long roleCd;
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleId", fetch = FetchType.LAZY)
        private List<UserRoleDto> userRoleList;
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleId", fetch = FetchType.LAZY)
        private List<PermissionRoleDto> permissionRoleList;

        public RoleDto() {
        }

        public RoleDto(Long roleId) {
                this.roleId = roleId;
        }

        public RoleDto(Long roleId, Long roleCd, String createdBy, Date createdDte, String updBy, Date updDte, int version) {
                this.roleId = roleId;
                this.roleCd = roleCd;
                setCreatedBy(createdBy);
                setCreatedDte(createdDte);
                setUpdBy(updBy);
                setUpdDte(updDte);
                setVersion(version);
        }

        public Long getRoleId() {
                return roleId;
        }

        public void setRoleId(Long roleId) {
                this.roleId = roleId;
        }

        public Long getRoleCd() {
                return roleCd;
        }

        public void setRoleCd(Long roleCd) {
                this.roleCd = roleCd;
        }

        public List<UserRoleDto> getUserRoleList() {
                return userRoleList;
        }

        public void setUserRoleList(List<UserRoleDto> userRoleList) {
                this.userRoleList = userRoleList;
        }

        public List<PermissionRoleDto> getPermissionRoleList() {
                return permissionRoleList;
        }

        public void setPermissionRoleList(List<PermissionRoleDto> permissionRoleList) {
                this.permissionRoleList = permissionRoleList;
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
                if (!(object instanceof RoleDto)) {
                        return false;
                }
                RoleDto other = (RoleDto) object;
                if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "sg.edu.nus.iss.vms.common.dto.RoleDto[ roleId=" + roleId + " ]";
        }
}
