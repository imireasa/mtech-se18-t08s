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
@Table(name = "tb_user_role")
@PrimaryKeyJoinColumn(name = "usr_role_id")
@NamedQueries( { @NamedQuery(name = "UserRoleDto.findAll", query = "SELECT u FROM UserRoleDto u") })
public class UserRoleDto extends BaseVersionDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long usrRoleId;
	private long roleId;
	private long usrId;



	@Id
	@GeneratedValue
	@Column(name = "USR_ROLE_ID", unique = true, nullable = false)
	public Long getUsrRoleId() {
		return this.usrRoleId;
	}

	public void setUsrRoleId(Long usrRoleId) {
		this.usrRoleId = usrRoleId;
	}

	@Column(name = "ROLE_ID", nullable = false)
	public long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	@Column(name = "USR_ID", nullable = false)
	public long getUsrId() {
		return this.usrId;
	}

	public void setUsrId(long usrId) {
		this.usrId = usrId;
	}
}
