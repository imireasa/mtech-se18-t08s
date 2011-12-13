package sg.edu.nus.iss.vms.security.service.impl;

import java.util.List;

import sg.edu.nus.iss.vms.common.SessionBean;
import sg.edu.nus.iss.vms.common.constants.VMSConstants;
import sg.edu.nus.iss.vms.common.dao.Dao;
import sg.edu.nus.iss.vms.common.exception.ApplicationException;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.security.dto.UserDto;
import sg.edu.nus.iss.vms.security.service.SecurityManagementService;

public class SecurityManagementServiceImpl implements SecurityManagementService{
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
	public UserDto login(String username, String password) throws ApplicationException{
		if((username == null || username.trim().equalsIgnoreCase("")) || 
				(password==null || password.trim().equalsIgnoreCase(""))){
			//username and password is not valid
			return null;
		}
		String loginQuery=NAMED_QUERY_LOGIN;
		String[] loginValues = new String[3];
		loginValues[0] = username;
		loginValues[1] = password;
		List result=null;
		loginValues[2] = VMSConstants.ACTIVE; //XXX active indicator maybe not in use.
		//List result = securityManagementDao.getObjectsByNamedQuery(loginQuery, loginValues, null);
		if (result == null){
			//TODO: username and /or password not valid. now return null.
			return null;
		}else if (result.size()>1){
			//more than 1 result returned. wrong data for this user.
			throw new ApplicationException("Corrupted data for this user. User ID is "+username);
		}else{
			//TODO: Login Audits will come here. if necessary
			return (UserDto) result.get(0); //return the first object.
		}
	}
	
	/**
	 *Returns boolean indicating whether user has the appropriate role
	 *for the specified URI.
	 */
	public boolean isUserAuthorized(UserDto user, String uri) {

	    boolean matchFound = false;
	    boolean authorized = false;

	 //TODO
	        return authorized;
	    }

}
