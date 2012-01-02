package sg.edu.nus.iss.vms.web.security;

import org.apache.log4j.Logger;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import sg.edu.nus.iss.vms.common.Messages;
import sg.edu.nus.iss.vms.common.util.StringUtil;


public class LoginValidator implements Validator {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(LoginValidator.class);

   @Override
    public boolean supports(Class clazz) {
		if (logger.isDebugEnabled()) {
			logger.debug("supports(Class) - start");
		}

		boolean returnboolean = LoginCommand.class.isAssignableFrom(clazz);
		if (logger.isDebugEnabled()) {
			logger.debug("supports(Class) - end");
		}
        return returnboolean;
    }
    public void validate(Object obj, Errors errors) {
		if (logger.isDebugEnabled()) {
			logger.debug("validate(Object, Errors) - start");
		}

        LoginCommand login = (LoginCommand) obj;        
        if (StringUtil.isNullOrEmpty(login.getUsername())) {
            errors.rejectValue("username", "error.empty.field", Messages.getString("message.common.error.mandatory", new String[]{"User ID"})); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        }
        if (StringUtil.isNullOrEmpty(login.getPassword())) {
            errors.rejectValue("password", "error.empty.field", Messages.getString("message.common.error.mandatory", new String[]{"Password"})); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        }
        

		if (logger.isDebugEnabled()) {
			logger.debug("validate(Object, Errors) - end");
		}
    }
}



 
