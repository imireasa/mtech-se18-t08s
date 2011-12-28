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
@Table(name = "tb_permission")
@NamedQueries({
        @NamedQuery(name = "PermissionDto.findAll", query = "SELECT t FROM PermissionDto t"),
        @NamedQuery(name = "PermissionDto.findCountOfAccessRightsByUserLoginIDAndURI",
        query = "SELECT count(permission) "
        + "FROM PermissionDto permission, UserRoleDto userRole, UserDto user, PermissionRoleDto permissionRole "
        + "WHERE permission.permiId = permissionRole.permiId "
        + "AND userRole.roleId = permissionRole.roleId "
        + "AND user.usrId = userRole.usrId "
        + "AND user.usrLoginId = :userLoginID "
        + "AND permission.uri = :uri")})
public class PermissionDto extends BaseVersionDto implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue
        @Basic(optional = false)
        @Column(name = "PERMI_ID")
        private Long permiId;
        @Basic(optional = false)
        @Column(name = "URI")
        private String uri;
        @Column(name = "DESC")
        private String desc;
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "permiId", fetch = FetchType.LAZY)
        private List<PermissionRoleDto> tbPermissionRoleList;
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "permiId", fetch = FetchType.LAZY)
        private List<MenuFunctionDto> tbMenuFunctionList;

        public PermissionDto() {
        }

        public PermissionDto(Long permiId) {
                this.permiId = permiId;
        }

        public PermissionDto(Long permiId, String uri, String createdBy, Date createdDte, String updBy, Date updDte, int version) {
                this.permiId = permiId;
                this.uri = uri;
                setCreatedBy(createdBy);
                setCreatedDte(createdDte);
                setUpdBy(updBy);
                setUpdDte(updDte);
                setVersion(version);
        }

        public Long getPermiId() {
                return permiId;
        }

        public void setPermiId(Long permiId) {
                this.permiId = permiId;
        }

        public String getUri() {
                return uri;
        }

        public void setUri(String uri) {
                this.uri = uri;
        }

        public String getDesc() {
                return desc;
        }

        public void setDesc(String desc) {
                this.desc = desc;
        }

        public List<PermissionRoleDto> getTbPermissionRoleList() {
                return tbPermissionRoleList;
        }

        public void setTbPermissionRoleList(List<PermissionRoleDto> tbPermissionRoleList) {
                this.tbPermissionRoleList = tbPermissionRoleList;
        }

        public List<MenuFunctionDto> getTbMenuFunctionList() {
                return tbMenuFunctionList;
        }

        public void setTbMenuFunctionList(List<MenuFunctionDto> tbMenuFunctionList) {
                this.tbMenuFunctionList = tbMenuFunctionList;
        }

        @Override
        public int hashCode() {
                int hash = 0;
                hash += (permiId != null ? permiId.hashCode() : 0);
                return hash;
        }

        @Override
        public boolean equals(Object object) {
                // TODO: Warning - this method won't work in the case the id fields are not set
                if (!(object instanceof PermissionDto)) {
                        return false;
                }
                PermissionDto other = (PermissionDto) object;
                if ((this.permiId == null && other.permiId != null) || (this.permiId != null && !this.permiId.equals(other.permiId))) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "sg.edu.nus.iss.vms.common.dto.PermissionDto[ permiId=" + permiId + " ]";
        }
}
