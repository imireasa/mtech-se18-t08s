/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.project.web.controller;

import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import sg.edu.nus.iss.vms.common.constants.VMSConstants;
import sg.edu.nus.iss.vms.project.service.ProjectManagementService;
import sg.edu.nus.iss.vms.project.vo.ProjectVo;

/**
 *
 * @author zaw
 */
public class ProjectValidator implements Validator {

        private Logger logger = Logger.getLogger(ProjectValidator.class);
        private ProjectManagementService projectManagementService;

        public ProjectManagementService getProjectManagementService() {
			return projectManagementService;
		}

		public void setProjectManagementService(
				ProjectManagementService projectManagementService) {
			this.projectManagementService = projectManagementService;
		}

        @Override
        public boolean supports(Class type) {
                boolean val = type.equals(ProjectVo.class);
                return val;
        }

        @Override
        public void validate(Object o, Errors errors) {
        	
        		ProjectVo obj = (ProjectVo) o;
        		
        		if(obj.getCmdType().equalsIgnoreCase(VMSConstants.SCREEN_CMD_UPDATE))
        				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "stsCd", "stsCd", "Required Status field");
        
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name", "Required Name field");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "desc", "desc", "Required Description field");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "strDte", "strDte", "Required Start Date field");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endDte", "endDte", "Required endDte field");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ctryCd", "ctryCd", "Required Country Code field");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loc", "loc", "Required Location field");
 
 
                logger.debug("Validation Done.");
        }
        
}
