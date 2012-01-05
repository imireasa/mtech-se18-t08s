package sg.edu.nus.iss.vms.admin.service;

import java.util.List;

import sg.edu.nus.iss.vms.common.exception.ApplicationException;
import sg.edu.nus.iss.vms.security.dto.RoleDto;
import sg.edu.nus.iss.vms.security.dto.UserDto;

public interface UserManagementServices {

	public List<RoleDto> getRoleListByUserLoginId(String userLoginId);
	public void updatePassword(String email, String currentPassword, String newPassword, String userLoginId) throws ApplicationException;
	public boolean isLoginIdExists(String loginId);
	public boolean forgetPassword(String userLoginId) throws ApplicationException;
	public UserDto getUserByLoginId(String userLoginId);
}