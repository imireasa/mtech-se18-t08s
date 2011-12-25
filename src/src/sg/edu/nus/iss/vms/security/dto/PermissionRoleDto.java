package sg.edu.nus.iss.vms.security.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import sg.edu.nus.iss.vms.common.dto.BaseVersionDto;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tb_permission_role")
@PrimaryKeyJoinColumn(name = "permi_role_id")
@NamedQueries( { @NamedQuery(name = "PermissionRoleDto.findAll", query = "SELECT u FROM PermissionRoleDto u") })
public class PermissionRoleDto extends BaseVersionDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long permiRoleId;
	private long permiId;
	private long roleId;

	
	@Id
	@GeneratedValue
	@Column(name = "PERMI_ROLE_ID", unique = true, nullable = false)
	public Long getPermiRoleId() {
		return this.permiRoleId;
	}

	public void setPermiRoleId(Long permiRoleId) {
		this.permiRoleId = permiRoleId;
	}

	@Column(name = "PERMI_ID", nullable = false)
	public long getPermiId() {
		return this.permiId;
	}

	public void setPermiId(long permiId) {
		this.permiId = permiId;
	}

	@Column(name = "ROLE_ID", nullable = false)
	public long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
}
