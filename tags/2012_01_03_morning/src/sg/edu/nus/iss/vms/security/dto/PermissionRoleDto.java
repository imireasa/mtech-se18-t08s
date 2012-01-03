/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.security.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import sg.edu.nus.iss.vms.common.dto.BaseVersionDto;

/**
 *
 * @author zaw
 */
@Entity
@Table(name = "tb_permission_role")
@NamedQueries({
        @NamedQuery(name = "PermissionRoleDto.findAll", query = "SELECT t FROM PermissionRoleDto t")})
public class PermissionRoleDto extends BaseVersionDto implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "PERMI_ROLE_ID")
        private Long permiRoleId;
        @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")
        @ManyToOne(optional = false, fetch = FetchType.EAGER)
        private RoleDto roleId;
        @JoinColumn(name = "PERMI_ID", referencedColumnName = "PERMI_ID")
        @ManyToOne(optional = false, fetch = FetchType.EAGER)
        private PermissionDto permiId;

        public PermissionRoleDto() {
        }

        public PermissionRoleDto(Long permiRoleId) {
                this.permiRoleId = permiRoleId;
        }

        public PermissionRoleDto(Long permiRoleId, String createdBy, Date createdDte, String updBy, Date updDte, int version) {
                this.permiRoleId = permiRoleId;
                setCreatedBy(createdBy);
                setCreatedDte(createdDte);
                setUpdBy(updBy);
                setUpdDte(updDte);
                setVersion(version);
        }

        public Long getPermiRoleId() {
                return permiRoleId;
        }

        public void setPermiRoleId(Long permiRoleId) {
                this.permiRoleId = permiRoleId;
        }

        public RoleDto getRoleId() {
                return roleId;
        }

        public void setRoleId(RoleDto roleId) {
                this.roleId = roleId;
        }

        public PermissionDto getPermiId() {
                return permiId;
        }

        public void setPermiId(PermissionDto permiId) {
                this.permiId = permiId;
        }

        @Override
        public int hashCode() {
                int hash = 0;
                hash += (permiRoleId != null ? permiRoleId.hashCode() : 0);
                return hash;
        }

        @Override
        public boolean equals(Object object) {
                // TODO: Warning - this method won't work in the case the id fields are not set
                if (!(object instanceof PermissionRoleDto)) {
                        return false;
                }
                PermissionRoleDto other = (PermissionRoleDto) object;
                if ((this.permiRoleId == null && other.permiRoleId != null) || (this.permiRoleId != null && !this.permiRoleId.equals(other.permiRoleId))) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "sg.edu.nus.iss.vms.common.dto.PermissionRoleDto[ permiRoleId=" + permiRoleId + " ]";
        }
}
