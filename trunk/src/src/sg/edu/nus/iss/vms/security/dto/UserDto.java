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
@Table(name = "tb_user")
@PrimaryKeyJoinColumn(name = "usr_seq_id")
@NamedQueries( { @NamedQuery(name = "UserDto.findAll", query = "SELECT u FROM UserDto u") })
public class UserDto extends BaseVersionDto implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "usr_seq_id")
	private Integer userSequenceId;
	@Column(name = "pwd")
	private String password;
	@Id
	@GeneratedValue
	@Column(name = "usr_id")
	private String userId;
	@Column(name = "usr_nme")
	private String userName;

	public Integer getUserSequenceId() {
		return userSequenceId;
	}

	public void setUserSequenceId(Integer userSequenceId) {
		this.userSequenceId = userSequenceId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
