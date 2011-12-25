package sg.edu.nus.iss.vms.web.security;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import sg.edu.nus.iss.vms.common.Messages;
import sg.edu.nus.iss.vms.security.dto.UserDto;
import sg.edu.nus.iss.vms.security.service.SecurityManagementService;

@SuppressWarnings("deprecation")
public class LoginFormController extends SimpleFormController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(LoginFormController.class);

	private SecurityManagementService securityManager;

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

		UserDto user = securityManager.login(username, password);

		if (user == null){
			//no such user, forward to form
			//ModelAndView modelAndView = new ModelAndView(getFormView());
			ModelAndView returnModelAndView = new ModelAndView("login", null);
			if (logger.isDebugEnabled()) {
				logger.debug("onSubmit(Object) - end with no user found or in session"); //$NON-NLS-1$
			}
			
			return new ModelAndView(new RedirectView("login.html"));

		}else{
			//user is found, set session var
			RequestContextHolder.currentRequestAttributes().setAttribute(Messages.getString("AuthorisationFilter.SESSION_USER_ATTR_NME"), user, RequestAttributes.SCOPE_SESSION);
		}
		
		ModelAndView modelAndView = new ModelAndView(getSuccessView());
		modelAndView.addObject("username", username);

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
