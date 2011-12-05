package sg.edu.nus.iss.vms.security.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import sg.edu.nus.iss.vms.common.dto.BaseVersionDto;

public class MenuFunctionDto extends BaseVersionDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "menu_func_id")
	Integer menuFunctionId;
	@Column(name = "prnt_menu_func_id")
	Integer ParentMenuFunctionId;
	@Column(name = "menu_func_nme")
	String menuFunctionName;
	@Column(name = "permi_id")
	String permissionId;
	public Integer getMenuFunctionId() {
		return menuFunctionId;
	}
	public void setMenuFunctionId(Integer menuFunctionId) {
		this.menuFunctionId = menuFunctionId;
	}
	public Integer getParentMenuFunctionId() {
		return ParentMenuFunctionId;
	}
	public void setParentMenuFunctionId(Integer parentMenuFunctionId) {
		ParentMenuFunctionId = parentMenuFunctionId;
	}
	public String getMenuFunctionName() {
		return menuFunctionName;
	}
	public void setMenuFunctionName(String menuFunctionName) {
		this.menuFunctionName = menuFunctionName;
	}
	public String getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}

}
