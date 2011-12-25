package sg.edu.nus.iss.vms.security.service.impl;

import org.apache.log4j.Logger;

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

	private static final String NAMED_QUERY_LOGIN = "login";
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
		UserDto userSearchCriteria = new UserDto();
		userSearchCriteria.setUsrLoginId(username);
		userSearchCriteria.setPwd(password);
		userSearchCriteria.setActInd(VMSConstants.ACTIVE);
		List<UserDto> result = null;
		result = manager.list(UserDto.class, userSearchCriteria);
		
		// List result =
		// securityManagementDao.getObjectsByNamedQuery(loginQuery, loginValues,
		// null);
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
			// TODO: Login Audits will come here. if necessary
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

		boolean matchFound = false;
		boolean authorized = true;

		// TODO

		if (logger.isDebugEnabled()) {
			logger.debug("isUserAuthorised(UserDto, String) - end"); //$NON-NLS-1$
		}
		return authorized;
	}

}
