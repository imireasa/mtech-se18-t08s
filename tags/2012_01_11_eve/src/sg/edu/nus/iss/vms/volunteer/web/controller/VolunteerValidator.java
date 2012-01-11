/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.volunteer.web.controller;

import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.edu.nus.iss.vms.common.Messages;
import sg.edu.nus.iss.vms.common.constants.VMSConstants;
import sg.edu.nus.iss.vms.common.util.FormatUtils;
import sg.edu.nus.iss.vms.volunteer.service.VolunteerManagementService;
import sg.edu.nus.iss.vms.volunteer.vo.VolunteerVo;

/**
 * 
 * @author zaw
 */
public class VolunteerValidator implements Validator {

    private final Logger logger = Logger.getLogger(VolunteerValidator.class);
    private VolunteerManagementService volunteerManagementService;

    public VolunteerManagementService getVolunteerManagementService() {
        return volunteerManagementService;
    }

    public void setVolunteerManagementService(
            VolunteerManagementService volunteerManagementService) {
        this.volunteerManagementService = volunteerManagementService;
    }

    @Override
    public boolean supports(Class type) {
        boolean val = type.equals(VolunteerVo.class);
        return val;
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (logger.isDebugEnabled()) {
            logger.debug("validate(Object, Errors) - start");
        }

        VolunteerVo obj = (VolunteerVo) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loginId", "loginId",
                Messages.getString("message.common.error.mandatory", new String[]{"Login ID"}));

        //password is required only for register volunteer...
        if (!obj.getCmdType().equalsIgnoreCase(VMSConstants.SCREEN_CMD_UPDATE)) {
            if (!obj.getPwd().equals(obj.getCfpwd())) {
                errors.reject("pwd", Messages.getString("message.common.error.notMatch", new String[]{"Password", "Confirm Password"}));
            }
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "pwd",
                    Messages.getString("message.common.error.mandatory", new String[]{"Password"}));
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cfpwd", "cfpwd",
                    Messages.getString("message.common.error.mandatory", new String[]{"Confirm Password"}));
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title",
                Messages.getString("message.common.error.mandatory", new String[]{"Title"}));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nme", "nme",
                Messages.getString("message.common.error.mandatory", new String[]{"Name"}));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email",
                Messages.getString("message.common.error.mandatory", new String[]{"Email"}));
        if (!FormatUtils.isEmailFormat(obj.getEmail())) {
            errors.reject("email", Messages.getString("message.common.error.format", new String[]{"Email"}));
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email",
                Messages.getString("message.common.error.mandatory", new String[]{"Email"}));

        if (logger.isDebugEnabled()) {
            logger.debug("validate(Object, Errors) - end");
        }
    }
}
