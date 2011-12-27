package sg.edu.nus.iss.vms.security.service;

import java.util.List;

import sg.edu.nus.iss.vms.common.exception.ApplicationException;
import sg.edu.nus.iss.vms.security.dto.UserDto;

public interface SecurityManagementService {
	public UserDto login(String username, String password) throws ApplicationException;
	/**
	 *Returns boolean indicating whether user has the appropriate role
	 *for the specified URI.
	 */
	public boolean isUserAuthorised(UserDto user, String uri) ;
	
	/*
	 * Returns the list of allowed menu items (names configured in struts menu config) for the logged in user
	 */
	public List<String> getAllowedMenu(UserDto user);
}
