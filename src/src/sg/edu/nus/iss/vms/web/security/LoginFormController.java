package sg.edu.nus.iss.vms.web.security;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.navigator.menu.PermissionsAdapter;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import sg.edu.nus.iss.vms.common.Messages;
import sg.edu.nus.iss.vms.common.constants.VMSConstants;
import sg.edu.nus.iss.vms.common.util.RoleUtil;
import sg.edu.nus.iss.vms.common.vo.UserSessionInfoVo;
import sg.edu.nus.iss.vms.common.web.util.UserUtil;
import sg.edu.nus.iss.vms.security.dto.UserDto;
import sg.edu.nus.iss.vms.security.service.SecurityManagementService;

@SuppressWarnings("deprecation")
public class LoginFormController extends SimpleFormController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(LoginFormController.class);

	private SecurityManagementService securityManager;

	@SuppressWarnings("unchecked")
	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("onSubmit(Object) - start"); //$NON-NLS-1$
		}

		LoginCommand loginCommand = (LoginCommand) command;
		String username = loginCommand.getUsername();
		String password = loginCommand.getPassword();

		if (logger.isDebugEnabled()) {
			logger.debug("onSubmit(Object) - Before calling Security Manager - username=" + username + ", password=" + password); //$NON-NLS-1$ //$NON-NLS-2$
		}
		UserSessionInfoVo userSessionInfoVo = new UserSessionInfoVo();
		UserDto user = securityManager.login(username, password);

		if (user == null) {
			// no such user, forward to form
			// ModelAndView modelAndView = new ModelAndView(getFormView());
			ModelAndView returnModelAndView = new ModelAndView("login", null);
			if (logger.isDebugEnabled()) {
				logger.debug("onSubmit(Object) - end with no user found or in session"); //$NON-NLS-1$
			}

			return new ModelAndView(new RedirectView("login.html"));

		}
		else {
			// user is found, set session var
			// user has logged in.
			// First step is to get the security manager. Will be using the
			// security manager.
			HttpServletRequest curRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
			HttpSession session = curRequest.getSession();
			ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
			SecurityManagementService authMgr = (SecurityManagementService) ctx.getBean("SecurityManagementServiceImpl"); //$NON-NLS-1$

			// see if the allowed menus are loaded into the
			// session for the user. if not loaded, load now.
			List<String> allowedMenus = (List<String>) session.getAttribute(Messages
					.getString("AuthorisationFilter.SESSION_USER_ALLOWED_MENU_ATTR_NME")); //$NON-NLS-1$

			if (allowedMenus == null) {
				// allowed menus not loaded. Load now.
				allowedMenus = authMgr.getAllowedMenus(user);
				// set the allowed menus into session for retrieval later.
				session.setAttribute((Messages.getString("AuthorisationFilter.SESSION_USER_ALLOWED_MENU_ATTR_NME")), allowedMenus);//$NON-NLS-1$
				// create a new menu permission adapter and set it in.
				PermissionsAdapter permissions = new MenuPermissionsAdapter(allowedMenus);
				session.setAttribute(VMSConstants.MENU_PERMISSION_ADAPTER_ATTRIBUTE_NAME, permissions);

			}// else if allowedMenus is not null, no need to check.

			
			userSessionInfoVo.setName(user.getNme());
			userSessionInfoVo.setSessionID(session.getId());
			userSessionInfoVo.setUserID(user.getUsrLoginId());
			 userSessionInfoVo.setRoles(RoleUtil.getRoleStringListByUserLoginId(user.getUsrLoginId()));
			userSessionInfoVo.setUserSeqID(user.getUsrId());

			session.setAttribute((Messages.getString("AuthorisationFilter.SESSION_USER_SESSION_INFO_VO_ATTR_NME")), userSessionInfoVo);

			if (logger.isDebugEnabled()) {
				if (UserUtil.getUserSessionInfoVo() != null) 
					logger.debug("onSubmit(Object) - User Session Info Object - Session Id: "
						+ UserUtil.getUserSessionInfoVo().getSessionID() + ", Name: " + UserUtil.getUserSessionInfoVo().getName() + ", User Roles: "
						+ UserUtil.getUserSessionInfoVo().getRoles().toString());
			}
		}

		ModelAndView modelAndView = new ModelAndView(new RedirectView("/VMS/common/welcome.html"));

		if (logger.isDebugEnabled()) {
			logger.debug("onSubmit(Object) - end , user found and placed in session"); //$NON-NLS-1$
		}
		return modelAndView;

	}

	public SecurityManagementService getSecurityManager() {
		return securityManager;
	}

	public void setSecurityManager(SecurityManagementService securityManager) {
		this.securityManager = securityManager;
	}
}
