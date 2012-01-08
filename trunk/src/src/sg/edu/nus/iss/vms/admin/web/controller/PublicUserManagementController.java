package sg.edu.nus.iss.vms.admin.web.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

import sg.edu.nus.iss.vms.admin.service.UserManagementServices;
import sg.edu.nus.iss.vms.admin.vo.UserManagementVo;
import sg.edu.nus.iss.vms.common.Messages;
import sg.edu.nus.iss.vms.common.constants.VMSConstants;
import sg.edu.nus.iss.vms.common.exception.ApplicationException;
import sg.edu.nus.iss.vms.common.util.CodeLookupUtil;
import sg.edu.nus.iss.vms.common.web.controller.BaseMultiActionFormController;
import sg.edu.nus.iss.vms.volunteer.service.VolunteerManagementService;
import sg.edu.nus.iss.vms.volunteer.vo.VolunteerVo;

public class PublicUserManagementController extends BaseMultiActionFormController {

    private static final Logger logger = Logger.getLogger(PublicUserManagementController.class);
    private UserManagementServices userManagementServices;
    private VolunteerManagementService volunteerManagementService;
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
                } else if (validator.supports(command.getClass())) {
                    ValidationUtils.invokeValidator(validators[index], command, errors);
                }
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("validate(Object) - end"); //$NON-NLS-1$
        }
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

    public VolunteerManagementService getVolunteerManagementService() {
        return volunteerManagementService;
    }

    public void setVolunteerManagementService(VolunteerManagementService volunteerManagementService) {
        this.volunteerManagementService = volunteerManagementService;
    }

    public BindingResult getErrors() {
        return errors;
    }

    public void setErrors(BindingResult errors) {
        this.errors = errors;
    }

    /**
     * Registers a volunteer.
     * 
     * @param request takes in the 
     * @param response
     * @param command
     * @return
     * @throws Exception
     */
    public ModelAndView registerVolunteer(HttpServletRequest request,
            HttpServletResponse response, VolunteerVo command) throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("registerVolunteer(HttpServletRequest, HttpServletResponse, VolunteerVo) - start");
        }

        modelAndView = new ModelAndView("volunteer/registerVolunteer");// jsp
        if (command.getLoginId() == null) {
            // page
            modelAndView.addObject("titleList", CodeLookupUtil.getCodeListByCategory(VMSConstants.TITLE_CATEGORY));
            modelAndView.addObject("countryList", CodeLookupUtil.getCodeListByCategory(VMSConstants.COUNTRY_CATEGORY));
            VolunteerVo volVo = new VolunteerVo();
            volVo.setCmdType(VMSConstants.SCREEN_CMD_REGISTER);
            modelAndView.addObject("command", volVo);

            if (logger.isDebugEnabled()) {
                logger.debug("registerVolunteer(HttpServletRequest, HttpServletResponse, VolunteerVo) - end");
            }
            return modelAndView;
        } else {
            validate(command);
            modelAndView.addObject("titleList", CodeLookupUtil.getCodeListByCategory(VMSConstants.TITLE_CATEGORY));
            modelAndView.addObject("countryList", CodeLookupUtil.getCodeListByCategory(VMSConstants.COUNTRY_CATEGORY));
            VolunteerVo volunteerVo = command;
            if (errors.hasErrors()) {
                logger.debug("registerVolunteer(HttpServletRequest, HttpServletResponse, VolunteerVo) - Error Handling : ");
                saveError(request, errors.getFieldError().getDefaultMessage());
                modelAndView.addObject("command", volunteerVo);

                if (logger.isDebugEnabled()) {
                    logger.debug("registerVolunteer(HttpServletRequest, HttpServletResponse, VolunteerVo) - end");
                }
                return modelAndView;
            }
            try {
                volunteerManagementService.saveVolunteer(volunteerVo);
            } catch (ApplicationException ae) {
                logger.error(
                        "registerVolunteer(HttpServletRequest, HttpServletResponse, VolunteerVo)",
                        ae);

                List list = new ArrayList();
                list.add(ae.getMessage());
                modelAndView.addObject("errors", list);
                modelAndView.addObject("command", volunteerVo);

                if (logger.isDebugEnabled()) {
                    logger.debug("registerVolunteer(HttpServletRequest, HttpServletResponse, VolunteerVo) - end");
                }
                return modelAndView;
            }
            volunteerVo.setCmdType(VMSConstants.SCREEN_CMD_REGISTER);
            modelAndView.addObject("command", volunteerVo);
            modelAndView.addObject("msg",
                    Messages.getString("message.common.save"));

            if (logger.isDebugEnabled()) {
                logger.debug("registerVolunteer(HttpServletRequest, HttpServletResponse, VolunteerVo) - end");
            }
            return modelAndView;
        }
    }

    public ModelAndView forgetPassword(HttpServletRequest request, HttpServletResponse response, UserManagementVo command) {
        if (logger.isDebugEnabled()) {
            logger.debug("forgetPassword(HttpServletRequest, HttpServletResponse, UserManagementVo) - start"); //$NON-NLS-1$
        }

        if (command == null || command.getUserLoginId() == null || command.getUserLoginId() == "") {
            modelAndView = new ModelAndView("user/forgetPassword");
            command = new UserManagementVo();
            modelAndView.addObject("command", command);
        } else {
            try {
                String userLoginId = command.getUserLoginId();
                command = new UserManagementVo();
                if (userManagementServices.isLoginIdExists(userLoginId)) {
                    if (userManagementServices.forgetPassword(userLoginId)) {
                        command.setMessage(Messages.getString("message.userManagement.success"));
                    } else {
                        command.setMessage(Messages.getString("message.userManagement.error.request.failed"));
                    }
                } else {
                    command.setMessage(Messages.getString("message.userManagement.error.invalid.user.id"));
                }

                modelAndView = new ModelAndView("user/forgetPassword");
                modelAndView.addObject("command", command);                
            } catch (ApplicationException e) {
                e.printStackTrace();                
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("forgetPassword(HttpServletRequest, HttpServletResponse, UserManagementVo) - end"); //$NON-NLS-1$
        }
        return modelAndView;
    }
}
