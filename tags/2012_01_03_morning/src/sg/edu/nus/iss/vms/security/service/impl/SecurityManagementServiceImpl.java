package sg.edu.nus.iss.vms.security.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.security.providers.encoding.PasswordEncoder;

import sg.edu.nus.iss.vms.common.SessionBean;
import sg.edu.nus.iss.vms.common.exception.ApplicationException;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.common.util.StringUtil;
import sg.edu.nus.iss.vms.common.vo.UserSessionInfoVo;
import sg.edu.nus.iss.vms.security.dto.UserDto;
import sg.edu.nus.iss.vms.security.service.SecurityManagementService;

public class SecurityManagementServiceImpl implements SecurityManagementService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SecurityManagementServiceImpl.class);

	private Manager manager;
	private SessionBean sessionBean;
	private PasswordEncoder passwordEncorder;

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
	
	public PasswordEncoder getPasswordEncorder() {
		return passwordEncorder;
	}

	public void setPasswordEncorder(PasswordEncoder passwordEncorder) {
		this.passwordEncorder = passwordEncorder;
	}

	public UserDto login(String username, String password) throws ApplicationException {
		if (logger.isDebugEnabled()) {
			logger.debug("login(String, String) - start"); //$NON-NLS-1$
		}

		if (StringUtil.isNullOrBlank(username) || StringUtil.isNullOrBlank(password)) {
			// username and password is not valid

			if (logger.isDebugEnabled()) {
				logger.debug("login(String, String) - end"); //$NON-NLS-1$
			}
			return null;
		}
		
		//String encodedPassword = passwordEncorder.encodePassword(password, null); //TODO: To enable check for encode password.
		
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
	public boolean isUserAuthorised(UserSessionInfoVo user, String uri) {
		if (logger.isDebugEnabled()) {
			logger.debug("isUserAuthorised(UserDto, String) - start"); //$NON-NLS-1$
                        return true;//TODO: Close when debug is done.
		}

		boolean authorised = true;

		String userLoginID = user.getUserID();
		
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
		"FROM MenuFunctionDto menufunction, PermissionDto permission, UserRoleDto userRole, UserDto user, RoleFunctionDto roleFunction " +
		"WHERE menufunction.menuFuncId = roleFunction.menuFuncId " +
		"AND userRole.roleId = roleFunction.roleId " +
		"AND user.usrId = userRole.usrId " +
		"AND menufunction.menuFuncId = permission.menuFuncId " +
		"AND user.usrLoginId = '"+user.getUsrLoginId() + "'";
		List<String> allowedMenus = (List<String>)manager.find(query);	
		return allowedMenus;
	}

}
