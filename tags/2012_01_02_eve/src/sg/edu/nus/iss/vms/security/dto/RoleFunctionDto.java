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
@Table(name = "tb_role_function")
@NamedQueries({
        @NamedQuery(name = "RoleFunctionDto.findAll", query = "SELECT t FROM RoleFunctionDto t")})
public class RoleFunctionDto extends BaseVersionDto implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "ROLE_FUNC_ID")
        private Long roleFuncId;
        @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")
        @ManyToOne(optional = false, fetch = FetchType.EAGER)
        private RoleDto roleId;
        @JoinColumn(name = "MENU_FUNC_ID", referencedColumnName = "MENU_FUNC_ID")
        @ManyToOne(optional = false, fetch = FetchType.EAGER)
        private MenuFunctionDto menuFuncId;

        public RoleFunctionDto() {
        }

        public RoleFunctionDto(Long roleFuncId) {
                this.roleFuncId = roleFuncId;
        }

        public RoleFunctionDto(Long roleFuncId, String createdBy, Date createdDte, String updBy, Date updDte, Integer version) {
                this.roleFuncId = roleFuncId;
                setCreatedBy(createdBy);
                setCreatedDte(createdDte);
                setUpdBy(updBy);
                setUpdDte(updDte);
                setVersion(version);
        }

        public Long getRoleFuncId() {
                return roleFuncId;
        }

        public void setRoleFuncId(Long roleFuncId) {
                this.roleFuncId = roleFuncId;
        }

        public RoleDto getRoleId() {
                return roleId;
        }

        public void setRoleId(RoleDto roleId) {
                this.roleId = roleId;
        }

        public MenuFunctionDto getMenuFuncId() {
                return menuFuncId;
        }

        public void setMenuFuncId(MenuFunctionDto menuFuncId) {
                this.menuFuncId = menuFuncId;
        }

        @Override
        public int hashCode() {
                int hash = 0;
                hash += (roleFuncId != null ? roleFuncId.hashCode() : 0);
                return hash;
        }

        @Override
        public boolean equals(Object object) {
                // TODO: Warning - this method won't work in the case the id fields are not set
                if (!(object instanceof RoleFunctionDto)) {
                        return false;
                }
                RoleFunctionDto other = (RoleFunctionDto) object;
                if ((this.roleFuncId == null && other.roleFuncId != null) || (this.roleFuncId != null && !this.roleFuncId.equals(other.roleFuncId))) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "sg.edu.nus.iss.vms.common.dto.RoleFunctionDto[ roleFuncId=" + roleFuncId + " ]";
        }
}
