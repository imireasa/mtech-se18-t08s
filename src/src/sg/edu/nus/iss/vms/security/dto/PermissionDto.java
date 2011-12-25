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
@Table(name = "tb_permission")
@PrimaryKeyJoinColumn(name = "permi_id")
@NamedQueries( { 
	@NamedQuery(name = "PermissionDto.findAll", query = "SELECT u FROM PermissionDto u")
	
})

public class PermissionDto extends BaseVersionDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "permi_id")
	private Integer permissionID;
	@Column(name = "permi_desc")
	private String permissionDescription;
	@Column(name = "uri")
	private String uri;

	public Integer getPermissionID() {
		return permissionID;
	}

	public void setPermissionID(Integer permissionID) {
		this.permissionID = permissionID;
	}

	public String getPermissionDescription() {
		return permissionDescription;
	}

	public void setPermissionDescription(String permissionDescription) {
		this.permissionDescription = permissionDescription;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
}
