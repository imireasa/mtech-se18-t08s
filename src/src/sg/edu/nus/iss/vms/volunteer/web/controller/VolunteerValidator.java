/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.volunteer.web.controller;

import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import sg.edu.nus.iss.vms.volunteer.service.VolunteerManagementService;
import sg.edu.nus.iss.vms.volunteer.vo.VolunteerVo;

/**
 *
 * @author zaw
 */
public class VolunteerValidator implements Validator {

        private Logger logger = Logger.getLogger(VolunteerValidator.class);
        private VolunteerManagementService volunteerManagementService;

        public VolunteerManagementService getVolunteerManagementService() {
                return volunteerManagementService;
        }

        public void setVolunteerManagementService(VolunteerManagementService volunteerManagementService) {
                this.volunteerManagementService = volunteerManagementService;
        }

        @Override
        public boolean supports(Class type) {
                boolean val = type.equals(VolunteerVo.class);
                return val;
        }

        @Override
        public void validate(Object o, Errors errors) {
                VolunteerVo obj = (VolunteerVo) o;
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loginId", "loginId", "Required LoginId field");
                
                
                
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title", "Required field");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nme", "nme", "Required Name  field");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email", "Required Email field");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobile", "mobile", "Required Mobile field");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobile", "mobile", "Required Mobile field");


                logger.debug("Validation Done.");
        }
}
