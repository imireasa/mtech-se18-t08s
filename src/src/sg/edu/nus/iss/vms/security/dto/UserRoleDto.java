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

	@Id
	@GeneratedValue
	@Column(name = "usr_role_id")
	Integer userRoleId;
	
	@Column(name = "usr_seq_id")
	Integer userSeqId;
	
	@Column(name = "role_id")
	Integer roleID;

	public Integer getUserRoleID() {
		return userRoleId;
	}

	public void setUserRoleID(Integer userRoleID) {
		this.userRoleId = userRoleID;
	}

	public Integer getRoleID() {
		return roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}

	public Integer getUserSeqId() {
		return userSeqId;
	}

	public void setUserSeqId(Integer userSeqId) {
		this.userSeqId = userSeqId;
	}
}
