package sg.edu.nus.iss.vms.admin.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

import sg.edu.nus.iss.vms.admin.service.UserManagementServices;
import sg.edu.nus.iss.vms.admin.vo.UserManagementVo;
import sg.edu.nus.iss.vms.common.exception.ApplicationException;
import sg.edu.nus.iss.vms.common.vo.UserSessionInfoVo;
import sg.edu.nus.iss.vms.common.web.controller.BaseMultiActionFormController;
import sg.edu.nus.iss.vms.common.web.util.UserUtil;

import com.mysql.jdbc.Messages;

public class UserManagementController extends BaseMultiActionFormController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(UserManagementController.class);

	private UserManagementServices userManagementServices;
	private BindingResult errors;

	public void validate(Object command) {
		if (logger.isDebugEnabled()) {
			logger.debug("validate(Object) - start"); //$NON-NLS-1$
		}

		Validator[] validators = getValidators();
		if (validators != null) {
			for (int index = 0; index < validators.length; index++) {
				Validator validator = validators[index];
				if (validator instanceof UserManagementValidator) {
					if (((UserManagementValidator) validator).supports(command.getClass())) {
						ValidationUtils.invokeValidator(validators[index], command, errors);
					}
				}
				else if (validator.supports(command.getClass())) {
					ValidationUtils.invokeValidator(validators[index], command, errors);
				}
			}
		}

		if (logger.isDebugEnabled()) {
			logger.debug("validate(Object) - end"); //$NON-NLS-1$
		}
	}

	public ModelAndView changePassword(HttpServletRequest request, HttpServletResponse response, UserManagementVo command) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("changePassword(HttpServletRequest, HttpServletResponse, UserManagementVo) - start"); //$NON-NLS-1$
		}

		if (command == null || command.getEmail() == null) {
			modelAndView = new ModelAndView("user/changePassword");
			UserSessionInfoVo userSessionInfoVo = UserUtil.getUserSessionInfoVo();
			command = new UserManagementVo();
			command.setEmail(userSessionInfoVo.getEmail());
			modelAndView.addObject("command", command);
		}
		else {
			validate(command);
			modelAndView = new ModelAndView("user/changePassword");
			if (errors.hasErrors()) {
				modelAndView.addAllObjects(errors.getModel());
				modelAndView.addObject("command", command);
			}
			else {
				try {
					userManagementServices.updatePassword(command.getEmail(), command.getCurrentPassword(), command.getPassword(), UserUtil
							.getUserSessionInfoVo().getUserID());
					ObjectError error = new ObjectError(getCommandName(command), "Update Completed.");
					errors.addError(error);
					modelAndView.addObject("command", command);
					modelAndView.addAllObjects(errors.getModel());
				}
				catch (ApplicationException e) {
					ObjectError error = new ObjectError(getCommandName(command), "Record cannot be updated. Please check your Current Password.");
					errors.addError(error);
					modelAndView.addObject("command", command);
					modelAndView.addAllObjects(errors.getModel());
					return modelAndView;
				}
			}
		}

		if (logger.isDebugEnabled()) {
			logger.debug("changePassword(HttpServletRequest, HttpServletResponse, UserManagementVo) - end"); //$NON-NLS-1$
		}
		return modelAndView;
	}

	@Override
	protected void bind(HttpServletRequest request, Object command) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("bind(HttpServletRequest, Object) - start");
		}

		ServletRequestDataBinder binder = createBinder(request, command);
		binder.bind(request);
		errors = binder.getBindingResult();

		if (logger.isDebugEnabled()) {
			logger.debug("bind(HttpServletRequest, Object) - end");
		}
	}

	public UserManagementServices getUserManagementServices() {
		return userManagementServices;
	}

	public void setUserManagementServices(UserManagementServices userManagementServices) {
		this.userManagementServices = userManagementServices;
	}

	public BindingResult getErrors() {
		return errors;
	}

	public void setErrors(BindingResult errors) {
		this.errors = errors;
	}

	public ModelAndView forgetPassword(HttpServletRequest request, HttpServletResponse response, UserManagementVo command) {
		if (logger.isDebugEnabled()) {
			logger.debug("forgetPassword(HttpServletRequest, HttpServletResponse, UserManagementVo) - start"); //$NON-NLS-1$
		}

		if (command == null || command.getUserLoginId() == null || command.getUserLoginId() == "") {
			modelAndView = new ModelAndView("user/forgetPassword");
			command = new UserManagementVo();
			modelAndView.addObject("command", command);
		}
		else {
			try {
				String userLoginId = command.getUserLoginId();
				command = new UserManagementVo();
				if (userManagementServices.isLoginIdExists(userLoginId)) {
					if (userManagementServices.forgetPassword(userLoginId)) command.setMessage(Messages.getString("message.userManagement.success"));
					else
						command.setMessage(Messages.getString("message.userManagement.error.request.failed"));
				}
				else
					command.setMessage(Messages.getString("message.userManagement.error.invalid.user.id"));

				modelAndView = new ModelAndView("user/forgetPassword");
				modelAndView.addObject("command", command);

			}
			catch (ApplicationException e) {
				e.printStackTrace();
			}
		}

		if (logger.isDebugEnabled()) {
			logger.debug("forgetPassword(HttpServletRequest, HttpServletResponse, UserManagementVo) - end"); //$NON-NLS-1$
		}
		return modelAndView;
	}

}
