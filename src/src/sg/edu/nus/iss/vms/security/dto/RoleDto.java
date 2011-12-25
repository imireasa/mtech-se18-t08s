package sg.edu.nus.iss.vms.security.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import sg.edu.nus.iss.vms.common.dto.BaseVersionDto;

@Entity
@Table(name = "tb_role")
@PrimaryKeyJoinColumn(name = "role_id")
@NamedQueries( { @NamedQuery(name = "RoleDto.findAll", query = "SELECT u FROM RoleDto u") })
public class RoleDto extends BaseVersionDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long roleId;
	private long roleCd;

	@Id
	@GeneratedValue
	@Column(name = "ROLE_ID", unique = true, nullable = false)
	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Column(name = "ROLE_CD", nullable = false)
	public long getRoleCd() {
		return this.roleCd;
	}

	public void setRoleCd(long roleCd) {
		this.roleCd = roleCd;
	}

}
