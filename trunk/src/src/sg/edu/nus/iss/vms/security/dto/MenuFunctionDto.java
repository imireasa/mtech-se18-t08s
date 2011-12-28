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
@Table(name = "tb_menu_function")
@NamedQueries({
        @NamedQuery(name = "MenuFunctionDto.findAll", query = "SELECT t FROM MenuFunctionDto t")})
public class MenuFunctionDto extends BaseVersionDto implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "MENU_FUNC_ID")
        private Long menuFuncId;
        @Column(name = "PRNT_MENU_FUNC_ID")
        private Long prntMenuFuncId;
        @Basic(optional = false)
        @Column(name = "MENU_FUNC_NME")
        private String menuFuncNme;
        @JoinColumn(name = "PERMI_ID", referencedColumnName = "PERMI_ID")
        @ManyToOne(optional = false, fetch = FetchType.EAGER)
        private PermissionDto permiId;

        public MenuFunctionDto() {
        }

        public MenuFunctionDto(Long menuFuncId) {
                this.menuFuncId = menuFuncId;
        }

        public MenuFunctionDto(Long menuFuncId, String menuFuncNme, String createdBy, Date createdDte, String updBy, Date updDte, int version) {
                this.menuFuncId = menuFuncId;
                this.menuFuncNme = menuFuncNme;
                setCreatedBy(createdBy);
                setCreatedDte(createdDte);
                setUpdBy(updBy);
                setUpdDte(updDte);
                setVersion(version);
        }

        public Long getMenuFuncId() {
                return menuFuncId;
        }

        public void setMenuFuncId(Long menuFuncId) {
                this.menuFuncId = menuFuncId;
        }

        public Long getPrntMenuFuncId() {
                return prntMenuFuncId;
        }

        public void setPrntMenuFuncId(Long prntMenuFuncId) {
                this.prntMenuFuncId = prntMenuFuncId;
        }

        public String getMenuFuncNme() {
                return menuFuncNme;
        }

        public void setMenuFuncNme(String menuFuncNme) {
                this.menuFuncNme = menuFuncNme;
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
                hash += (menuFuncId != null ? menuFuncId.hashCode() : 0);
                return hash;
        }

        @Override
        public boolean equals(Object object) {
                // TODO: Warning - this method won't work in the case the id fields are not set
                if (!(object instanceof MenuFunctionDto)) {
                        return false;
                }
                MenuFunctionDto other = (MenuFunctionDto) object;
                if ((this.menuFuncId == null && other.menuFuncId != null) || (this.menuFuncId != null && !this.menuFuncId.equals(other.menuFuncId))) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "sg.edu.nus.iss.vms.common.dto.MenuFunctionDto[ menuFuncId=" + menuFuncId + " ]";
        }
}
