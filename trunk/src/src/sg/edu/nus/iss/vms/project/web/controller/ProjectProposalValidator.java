package sg.edu.nus.iss.vms.project.web.controller;

import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.edu.nus.iss.vms.project.vo.ProjectVo;

public class ProjectProposalValidator implements Validator {

	private final Logger logger = Logger
			.getLogger(ProjectProposalValidator.class);

	@Override
	public void validate(Object o, Errors errors) {
		ProjectVo obj = (ProjectVo) o;
		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loginId",
		// "loginId",
		// "Required LoginId field");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name",
				"Required Name  field");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loc", "loc",
				"Required Location field");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ctryCd", "ctryCd",
				"Required Country field. Can not be a blank.");

		logger.debug("Project Proposal Validation Done.");
	}

	@Override
	public boolean supports(Class type) {
		boolean val = type.equals(ProjectVo.class);
		return val;
	}
}
