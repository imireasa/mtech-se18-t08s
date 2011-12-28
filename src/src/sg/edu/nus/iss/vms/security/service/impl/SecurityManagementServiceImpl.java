package sg.edu.nus.iss.vms.security.service.impl;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;

import sg.edu.nus.iss.vms.common.SessionBean;
import sg.edu.nus.iss.vms.common.constants.VMSConstants;
import sg.edu.nus.iss.vms.common.exception.ApplicationException;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.security.dto.UserDto;
import sg.edu.nus.iss.vms.security.service.SecurityManagementService;

public class SecurityManagementServiceImpl implements SecurityManagementService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SecurityManagementServiceImpl.class);

	private Manager manager;
	private SessionBean sessionBean;

	public Manager getManager() {
		return this.manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public SessionBean getSessionBean() {
		return this.sessionBean;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	public UserDto login(String username, String password) throws ApplicationException {
		if (logger.isDebugEnabled()) {
			logger.debug("login(String, String) - start"); //$NON-NLS-1$
		}

		if ((username == null || username.trim().equalsIgnoreCase("")) || (password == null || password.trim().equalsIgnoreCase(""))) {
			// username and password is not valid

			if (logger.isDebugEnabled()) {
				logger.debug("login(String, String) - end"); //$NON-NLS-1$
			}
			return null;
		}
		String query = "select user FROM UserDto user WHERE " +
				"user.usrLoginId = '" + username +
				"' AND user.pwd = '" +password + 
				"' AND user.actInd = 1";
		List<UserDto> result = null;
		result = manager.find(query);		
		if (result == null || result.size() == 0) {
			// username and /or password not valid or user cannot be found. now
			// return null.

			if (logger.isDebugEnabled()) {
				logger.debug("login(String, String) - end"); //$NON-NLS-1$
			}
			return null;
		}
		else if (result.size() > 1) {
			// more than 1 result returned. wrong data for this user.
			throw new ApplicationException("Corrupted data for this user. User ID is " + username);
		}
		else {
			// XXX: Login Audits will come here. if necessary
			UserDto returnUserDto = result.get(0);
			if (logger.isDebugEnabled()) {
				logger.debug("login(String, String) - end"); //$NON-NLS-1$
			}
			return returnUserDto; // return the first object.
		}
	}

	/**
	 *Returns boolean indicating whether user has the appropriate role for the
	 * specified URI.
	 */
	public boolean isUserAuthorised(UserDto user, String uri) {
		if (logger.isDebugEnabled()) {
			logger.debug("isUserAuthorised(UserDto, String) - start"); //$NON-NLS-1$
		}

		boolean authorised = true;

		String userLoginID = user.getUsrLoginId();
		
		HashMap<String, String> parameterMap = new HashMap<String, String>();
		parameterMap.put("userLoginID", userLoginID);
		parameterMap.put("uri", uri);
		
		List<Long> accessRightsCountList = manager.findByNamedQuery("PermissionDto.findCountOfAccessRightsByUserLoginIDAndURI", parameterMap, null);
		if (accessRightsCountList == null || accessRightsCountList.size() == 0)
			authorised = false;
		else {
			if (accessRightsCountList.get(0).longValue() == 0)
				authorised = false;
		}

		if (logger.isDebugEnabled()) {
			logger.debug("isUserAuthorised(UserDto, String) - List data: " + accessRightsCountList.toString());
			logger.debug("isUserAuthorised(UserDto, String) - end"); //$NON-NLS-1$
		}
		return authorised;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllowedMenus(UserDto user) {
		String query = "SELECT menufunction.menuFuncNme " +
		"FROM MenuFunctionDto menufunction, PermissionDto permission, UserRoleDto userRole, UserDto user, PermissionRoleDto permissionRole " +
		"WHERE permission.permiId = permissionRole.permiId " +
		"AND userRole.roleId = permissionRole.roleId " +
		"AND user.usrId = userRole.usrId " +
		"AND menufunction.permiId = permission.permiId " +
		"AND user.usrLoginId = '"+user.getUsrLoginId() + "'";
		List<String> allowedMenus = (List<String>)manager.find(query);	
		return allowedMenus;
	}

}
