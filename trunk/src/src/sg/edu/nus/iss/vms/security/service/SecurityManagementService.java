package sg.edu.nus.iss.vms.security.service;

import sg.edu.nus.iss.vms.common.exception.ApplicationException;
import sg.edu.nus.iss.vms.security.dto.UserDto;

public interface SecurityManagementService {
	public UserDto login(String username, String password) throws ApplicationException;
}
