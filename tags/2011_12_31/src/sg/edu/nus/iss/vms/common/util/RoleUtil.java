package sg.edu.nus.iss.vms.common.util;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import sg.edu.nus.iss.vms.common.service.UserManagementServices;
import sg.edu.nus.iss.vms.security.dto.RoleDto;

public class RoleUtil {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(RoleUtil.class);

	/**
	 * Retrieves a list of role Id based on user login Id.
	 * 
	 * @param userLoginId
	 * @return
	 */
	public static List<String> getRoleStringListByUserLoginId(String userLoginId) {
		if (logger.isDebugEnabled()) {
			logger.debug("getRoleStringListByUserLoginId(String) - start");
		}

		List<String> roleStringList = null;
		
		UserManagementServices userMgr = getUserManagementServices();
		List<RoleDto> roleList = userMgr.getRoleListByUserLoginId(userLoginId);
		
		if (roleList == null || roleList.size() == 0) return roleStringList;
		
		roleStringList = new ArrayList<String>();
		
		for (RoleDto role:roleList) {
			if (role != null)
				roleStringList.add(CodeLookupUtil.getCodeDescriptionByCodeId(role.getRoleCd()));
		}
		

		if (logger.isDebugEnabled()) {
			logger.debug("getRoleStringListByUserLoginId(String) - end");
		}
		return roleStringList;
	}
	
	/**
	 * @return the reference to User management Services
	 */
	private static UserManagementServices getUserManagementServices() {
		if (logger.isDebugEnabled()) {
			logger.debug("getUserManagementServices() - start");
		}

		HttpServletRequest curRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		HttpSession session = curRequest.getSession();
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
		UserManagementServices userMgr = (UserManagementServices) ctx.getBean("userManagementServiceImpl"); //$NON-NLS-1$

		if (logger.isDebugEnabled()) {
			logger.debug("getUserManagementServices() - end");
		}
		return userMgr;
	}

}
