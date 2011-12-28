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
@Table(name = "tb_user_role")
@NamedQueries({
        @NamedQuery(name = "UserRoleDto.findAll", query = "SELECT t FROM UserRoleDto t")})
public class UserRoleDto extends BaseVersionDto implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "USR_ROLE_ID")
        private Long usrRoleId;
        @Basic(optional = false)
        @Column(name = "USR_ID")
        private long usrId;
        @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")
        @ManyToOne(optional = false, fetch = FetchType.EAGER)
        private RoleDto roleId;

        public UserRoleDto() {
        }

        public UserRoleDto(Long usrRoleId) {
                this.usrRoleId = usrRoleId;
        }

        public UserRoleDto(Long usrRoleId, long usrId, String createdBy, Date createdDte, String updBy, Date updDte, int version) {
                this.usrRoleId = usrRoleId;
                this.usrId = usrId;
                setCreatedBy(createdBy);
                setCreatedDte(createdDte);
                setUpdBy(updBy);
                setUpdDte(updDte);
                setVersion(version);
        }

        public Long getUsrRoleId() {
                return usrRoleId;
        }

        public void setUsrRoleId(Long usrRoleId) {
                this.usrRoleId = usrRoleId;
        }

        public long getUsrId() {
                return usrId;
        }

        public void setUsrId(long usrId) {
                this.usrId = usrId;
        }

        public RoleDto getRoleId() {
                return roleId;
        }

        public void setRoleId(RoleDto roleId) {
                this.roleId = roleId;
        }

        @Override
        public int hashCode() {
                int hash = 0;
                hash += (usrRoleId != null ? usrRoleId.hashCode() : 0);
                return hash;
        }

        @Override
        public boolean equals(Object object) {
                // TODO: Warning - this method won't work in the case the id fields are not set
                if (!(object instanceof UserRoleDto)) {
                        return false;
                }
                UserRoleDto other = (UserRoleDto) object;
                if ((this.usrRoleId == null && other.usrRoleId != null) || (this.usrRoleId != null && !this.usrRoleId.equals(other.usrRoleId))) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "sg.edu.nus.iss.vms.common.dto.UserRoleDto[ usrRoleId=" + usrRoleId + " ]";
        }
}
