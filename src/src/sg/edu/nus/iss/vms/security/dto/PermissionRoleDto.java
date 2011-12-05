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
	
	@Id
	@GeneratedValue
	@Column(name = "permi_role_id")
	private Integer permissionRoleId;


	@Column(name = "role_id")
	private Integer roleId;

	public Integer getPermissionRoleID() {
		return permissionRoleId;
	}

	public void setPermissionRoleID(Integer permissionRoleID) {
		this.permissionRoleId = permissionRoleID;
	}

	public Integer getRoleID() {
		return roleId;
	}

	public void setRoleID(Integer roleID) {
		this.roleId = roleID;
	}
}
