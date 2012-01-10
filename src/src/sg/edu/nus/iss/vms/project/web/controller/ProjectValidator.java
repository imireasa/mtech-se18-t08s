/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.project.web.controller;

import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.edu.nus.iss.vms.common.Messages;
import sg.edu.nus.iss.vms.common.constants.VMSConstants;
import sg.edu.nus.iss.vms.common.util.StringUtil;
import sg.edu.nus.iss.vms.project.vo.ProjectProposalVo;
import sg.edu.nus.iss.vms.project.vo.ProjectVo;

/**
 * 
 * @author zaw
 */
public class ProjectValidator implements Validator {

	private final Logger logger = Logger.getLogger(ProjectValidator.class);

	@Override
	public boolean supports(Class type) {
		boolean val = ProjectVo.class.isAssignableFrom(type)
				|| ProjectProposalVo.class.isAssignableFrom(type);
		return val;
	}

	@Override
	public void validate(Object o, Errors errors) {
		if (logger.isDebugEnabled()) {
			logger.debug("validate(Object, Errors) - start");
		}

		if (o instanceof ProjectVo) {
			ProjectVo obj = (ProjectVo) o;

			if (obj.getCmdType().equalsIgnoreCase(
					VMSConstants.SCREEN_CMD_UPDATE))

				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "stsCd",
						"stsCd", Messages.getString(
								"message.common.error.mandatory",
								new String[] { "Status" }));

			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name",
					Messages.getString("message.common.error.mandatory",
							new String[] { "Name" }));
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "desc", "desc",
					Messages.getString("message.common.error.mandatory",
							new String[] { "Description" }));
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "strDte",
					"strDte", Messages.getString(
							"message.common.error.mandatory",
							new String[] { "startDate" }));
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endDte",
					"endDte", Messages.getString(
							"message.common.error.mandatory",
							new String[] { "endDate" }));
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ctryCd",
					"ctryCd", Messages.getString(
							"message.common.error.mandatory",
							new String[] { "Country" }));
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loc", "loc",
					Messages.getString("message.common.error.mandatory",
							new String[] { "Location" }));

			if (logger.isDebugEnabled()) {
				logger.debug("validate(Object, Errors) - end");
			}
		}

		else if (o instanceof ProjectProposalVo) {
			validateProposal(o, errors);

		}
	}

	public void validateProposal(Object o, Errors errors) {
		if (logger.isDebugEnabled()) {
			logger.debug("validateProposal(Object, Errors) - start");
		}
		ProjectProposalVo projectProposalVo = (ProjectProposalVo) o;

		if (StringUtil.isNullOrEmpty(projectProposalVo.getNme())) {
			errors.rejectValue("nme", "nme", Messages.getString(
					"message.common.error.mandatory", new String[] { "Name" }));
		}

		if (StringUtil.isNullOrEmpty(projectProposalVo.getLoc())) {
			errors.rejectValue("loc", "loc", Messages.getString(
					"message.common.error.mandatory",
					new String[] { "Location" }));
		}

		if (StringUtil.isNullOrEmpty(projectProposalVo.getCtryVal())) {
			errors.rejectValue("ctryVal", "ctryVal", Messages.getString(
					"message.common.error.mandatory",
					new String[] { "Country" }));
		}

		if (projectProposalVo.getEstDur() <= 0) {
			errors.rejectValue(
					"estDur", "error.empty.field", Messages.getString("message.common.error.numeric.gt.invalid", new String[] { "Estimated Duration", "0" })); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("validateProposal(Object, Errors) - end");
		}
	}

}
