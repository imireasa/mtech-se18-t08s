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
	@Id
	@GeneratedValue
	@Column(name = "role_id")
	Integer roleID;
	@Column(name = "role_cd")
	String roleCD;

	public Integer getRoleID() {
		return roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}

	public String getRoleCD() {
		return roleCD;
	}

	public void setRoleCD(String roleCD) {
		this.roleCD = roleCD;
	}

}
