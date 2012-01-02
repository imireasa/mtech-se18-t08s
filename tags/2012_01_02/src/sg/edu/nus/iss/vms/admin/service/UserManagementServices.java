package sg.edu.nus.iss.vms.admin.service;

import java.util.List;

import sg.edu.nus.iss.vms.common.dto.CodeDto;
import sg.edu.nus.iss.vms.common.exception.ApplicationException;
import sg.edu.nus.iss.vms.security.dto.RoleDto;

public interface UserManagementServices {

	public List<RoleDto> getRoleListByUserLoginId(String userLoginId);
	public void updatePassword(String email, String currentPassword, String newPassword, String userLoginId) throws ApplicationException;
}