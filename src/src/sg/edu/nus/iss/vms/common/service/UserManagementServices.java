package sg.edu.nus.iss.vms.common.service;

import java.util.List;

import sg.edu.nus.iss.vms.common.dto.CodeDto;
import sg.edu.nus.iss.vms.security.dto.RoleDto;

public interface UserManagementServices {

	public List<RoleDto> getRoleListByUserLoginId(String userLoginId);
}