package sg.edu.nus.iss.vms.common.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import sg.edu.nus.iss.vms.common.SessionBean;
import sg.edu.nus.iss.vms.common.dto.CodeDto;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.common.service.UserManagementServices;
import sg.edu.nus.iss.vms.security.dto.RoleDto;

public class UserManagementServicesImpl implements UserManagementServices {

	private Logger logger = Logger.getLogger(UserManagementServicesImpl.class);
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
	
	public List<RoleDto> getRoleListByUserLoginId(String userLoginId) {
		if (logger.isDebugEnabled()) {
			logger.debug("getRoleListByUserLoginId(RoleDto) - start");
		}

		List<RoleDto> roleList = null;
			
		try {
			String query = "SELECT role " +
			"FROM UserRoleDto userRole, UserDto user, RoleDto role, " +
			"WHERE user.usrId = userRole.usrId " +
			"AND userRole.roleId = role.roleId " +
			"AND user.usrLoginId = '"+ userLoginId + "'";
			roleList = (List<RoleDto>) manager.find(query);
		} catch (Exception ex) {
			this.logger.error("getRoleListByUserLoginId(RoleDto) - error: ", ex);
		} finally {
			if (logger.isDebugEnabled()) {
				logger.debug("getRoleListByUserLoginId(RoleDto) - end");
			}
			return roleList;
		}
	}
}