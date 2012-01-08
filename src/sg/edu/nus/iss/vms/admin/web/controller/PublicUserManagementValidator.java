/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.admin.web.controller;

import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.edu.nus.iss.vms.admin.vo.UserManagementVo;

/**
 * 
 * @author Peishan
 */
public class PublicUserManagementValidator implements Validator {

	private final Logger logger = Logger.getLogger(PublicUserManagementValidator.class);

	@Override
	public void validate(Object o, Errors errors) {
		if (logger.isDebugEnabled()) {
			logger.debug("validate(Object, Errors) - start"); //$NON-NLS-1$
		}

		UserManagementVo obj = (UserManagementVo) o;
		if (obj.getEmail() != null) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password", "New Password is required.");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "currentPassword", "currentPassword", "Current Password is required.");
			if (obj.getPassword() != null) {
				if (!obj.getPassword().equals(obj.getConfirmedPassword())) {
					errors.reject("pwd", "Required Password not the same");
				}
			}
		}
		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title",
		// "Required field");
		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nme", "nme",
		// "Required Name  field");
		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email",
		// "Required Email field");
		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dob", "dob",
		// "Required Date Of Birth field");
		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "pwd",
		// "Required Password field. Can not be a blank.");
		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cfpwd", "cfpwd",
		// "Required Password field. Can not be a blank.");

		if (logger.isDebugEnabled()) {
			logger.debug("validate(Object, Errors) - end"); //$NON-NLS-1$
		}
	}

	@Override
	public boolean supports(Class clazz) {
		if (logger.isDebugEnabled()) {
			logger.debug("supports(Class) - start"); //$NON-NLS-1$
		}

		boolean returnboolean = UserManagementVo.class.isAssignableFrom(clazz);
		if (logger.isDebugEnabled()) {
			logger.debug("supports(Class) - end"); //$NON-NLS-1$
		}
		return returnboolean;
	}
}
