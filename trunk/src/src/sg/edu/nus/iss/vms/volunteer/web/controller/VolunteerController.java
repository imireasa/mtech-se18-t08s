package sg.edu.nus.iss.vms.volunteer.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

import sg.edu.nus.iss.vms.common.Messages;
import sg.edu.nus.iss.vms.common.constants.VMSConstants;
import sg.edu.nus.iss.vms.common.dto.CertificateRequestDto;
import sg.edu.nus.iss.vms.common.dto.CodeDto;
import sg.edu.nus.iss.vms.common.exception.ApplicationException;
import sg.edu.nus.iss.vms.common.service.CodeManagementServices;
import sg.edu.nus.iss.vms.common.util.CodeLookupUtil;
import sg.edu.nus.iss.vms.common.util.DateUtil;
import sg.edu.nus.iss.vms.common.util.StringUtil;
import sg.edu.nus.iss.vms.common.web.controller.BaseMultiActionFormController;
import sg.edu.nus.iss.vms.common.web.util.UserUtil;
import sg.edu.nus.iss.vms.member.service.MemberManagementService;
import sg.edu.nus.iss.vms.project.dto.ProjectDto;
import sg.edu.nus.iss.vms.project.dto.ProjectExperienceDto;
import sg.edu.nus.iss.vms.project.dto.ProjectFeedbackDto;
import sg.edu.nus.iss.vms.project.dto.ProjectInterestDto;
import sg.edu.nus.iss.vms.project.dto.ProjectMemberDto;
import sg.edu.nus.iss.vms.project.service.ProjectManagementService;
import sg.edu.nus.iss.vms.project.vo.ProjectInfoVo;
import sg.edu.nus.iss.vms.project.vo.ProjectVo;
import sg.edu.nus.iss.vms.volunteer.service.VolunteerManagementService;
import sg.edu.nus.iss.vms.volunteer.vo.VolunteerVo;

public class VolunteerController extends BaseMultiActionFormController {

	private CodeManagementServices codeManagementServices;
	private VolunteerManagementService volunteerManagementService;
	private ProjectManagementService projectManagementService;
	private MemberManagementService memberManagementService;
	// local
	private final Logger logger = Logger.getLogger(VolunteerController.class);
	BindingResult errors;

	public VolunteerController() {
	}

	public void setCodeManagementServices(
			CodeManagementServices codeManagementServices) {
		this.codeManagementServices = codeManagementServices;
	}

	public void setVolunteerManagementService(
			VolunteerManagementService volunteerManagementService) {
		this.volunteerManagementService = volunteerManagementService;
	}

	@Override
	public long getLastModified(HttpServletRequest arg0) {
		logger.debug("###################################################################################");
		return super.getLastModified(arg0);
	}

	public BindingResult getErrors() {
		return errors;
	}

	public void setErrors(BindingResult errors) {
		this.errors = errors;
	}

	public ProjectManagementService getProjectManagementService() {
		return projectManagementService;
	}

	public void setProjectManagementService(
			ProjectManagementService projectManagementService) {
		this.projectManagementService = projectManagementService;
	}

	@Override
	protected void bind(HttpServletRequest request, Object command)
			throws Exception {
		// TODO Auto-generated method stub

		ServletRequestDataBinder binder = createBinder(request, command);
		binder.bind(request);
		errors = binder.getBindingResult();
	}

	public void setMemberManagementService(
			MemberManagementService memberManagementService) {
		this.memberManagementService = memberManagementService;
	}

	public void validate(Object command) {
		Validator[] validators = getValidators();
		if (validators != null) {
			for (int index = 0; index < validators.length; index++) {
				Validator validator = validators[index];
				if (validator instanceof VolunteerValidator) {
					if (((VolunteerValidator) validator).supports(command
							.getClass())) {
						ValidationUtils.invokeValidator(validators[index],
								command, errors);
					}
				} else if (validator.supports(command.getClass())) {
					ValidationUtils.invokeValidator(validators[index], command,
							errors);
				}
			}
		}
	}

	public ModelAndView registerVolunteer(HttpServletRequest request,
			HttpServletResponse response, VolunteerVo command) throws Exception {

		if (command.getLoginId() == null) {
			modelAndView = new ModelAndView("volunteer/registerVolunteer");// jsp
			// page
			modelAndView.addObject("titalList", codeManagementServices
					.getListOfCodeByCategory(VMSConstants.TITAL_CATEGORY));
			modelAndView.addObject("countryList", codeManagementServices
					.getListOfCodeByCategory(VMSConstants.COUNTRY_CATEGORY));
			VolunteerVo volVo = new VolunteerVo();
			// volVo.setCmdType(VMSConstants.SCREEN_CMD_REGISTER);
			modelAndView.addObject("command", volVo);
			return modelAndView;
		} else {
			validate(command);
			modelAndView = new ModelAndView("volunteer/updateVolunteer");
			modelAndView.addObject("titalList", codeManagementServices
					.getListOfCodeByCategory(VMSConstants.TITAL_CATEGORY));
			modelAndView.addObject("countryList", codeManagementServices
					.getListOfCodeByCategory(VMSConstants.COUNTRY_CATEGORY));
			VolunteerVo volunteerVo = command;
			if (errors.hasErrors()) {
				logger.debug("Error Handling : ");
				saveError(request, errors.getFieldError().getDefaultMessage());
				modelAndView.addObject("command", volunteerVo);
				return modelAndView;
			}

			try {
				volunteerManagementService.saveNewVolunteer(volunteerVo);
			} catch (ApplicationException ae) {
				List list = new ArrayList();
				list.add(ae.getMessage());
				modelAndView.addObject("errors", list);
				modelAndView.addObject("command", volunteerVo);
				return modelAndView;
			}

			modelAndView.addObject("command", volunteerVo);
			modelAndView.addObject("msg",
					Messages.getString("message.common.save"));
			return modelAndView;
		}
	}

	public ModelAndView updateVolunteer(HttpServletRequest request,
			HttpServletResponse response, VolunteerVo command) throws Exception {
		// TODO: get current login volunteer
		if (command.getLoginId() == null) {
			VolunteerVo volunteer = volunteerManagementService
					.getVolunteer(UserUtil.getUserSessionInfoVo().getUserID());
			// TODO: Update Session User
			modelAndView = new ModelAndView("volunteer/updateVolunteer");// jsp
			// page
			modelAndView.addObject("titalList", CodeLookupUtil
					.getListOfCodeByCategory(VMSConstants.TITAL_CATEGORY));
			modelAndView.addObject("countryList", CodeLookupUtil
					.getListOfCodeByCategory(VMSConstants.COUNTRY_CATEGORY));
			// volunteer.setCmdType(VMSConstants.SCREEN_CMD_UPDATE);
			modelAndView.addObject("command", volunteer);
			return modelAndView;
		} else {
			validate(command);
			modelAndView = new ModelAndView("volunteer/updateVolunteer");
			modelAndView.addObject("titalList", codeManagementServices
					.getListOfCodeByCategory(VMSConstants.TITAL_CATEGORY));
			modelAndView.addObject("countryList", codeManagementServices
					.getListOfCodeByCategory(VMSConstants.COUNTRY_CATEGORY));
			VolunteerVo volunteerVo = command;
			if (errors.hasErrors()) {
				logger.debug("Error Handling : ");
				saveError(request, errors.getFieldError().getDefaultMessage());
				modelAndView.addObject("command", volunteerVo);
				return modelAndView;
			}

			try {
				volunteerManagementService.updateVolunteer(volunteerVo);
			} catch (ApplicationException ae) {
				List list = new ArrayList();
				list.add(ae.getMessage());
				modelAndView.addObject("errors", list);
				modelAndView.addObject("command", volunteerVo);
				return modelAndView;
			}

			modelAndView.addObject("command", volunteerVo);
			modelAndView.addObject("msg",
					Messages.getString("message.common.update"));
			return modelAndView;
		}
	}

	public ModelAndView browseProject(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		modelAndView = new ModelAndView("volunteer/browseProject");// jsp page
		List<ProjectDto> projectList = projectManagementService
				.getListAllProject();
		List<CodeDto> projectCodeList = codeManagementServices
				.getListOfCodeByCategory(VMSConstants.PROJECT_STATUS);
		logger.debug("The project size is" + projectList.size());
		modelAndView.addObject("projectList", projectList);
		modelAndView.addObject("command", new ProjectVo());
		modelAndView.addObject("projectCodeList", projectCodeList);
		return modelAndView;
	}

	public ModelAndView searchProjects(HttpServletRequest request,
			HttpServletResponse response, ProjectVo command) throws Exception {

		logger.debug("searchProjects");

		List<ProjectDto> projectList = projectManagementService
				.getProjectbyProjectVo(command);
		logger.debug("The project size is" + projectList.size());
		modelAndView.addObject("projectList", projectList);
		modelAndView.addObject("command", command);

		return modelAndView;

	}

	public ModelAndView viewProjectDetails(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		long prjId = Long.parseLong(request.getParameter("prjId"));

		ProjectDto projectDto = (ProjectDto) projectManagementService
				.getProjectObjbyId(prjId, ProjectDto.class);
		List<ProjectMemberDto> memberList = memberManagementService
				.getListOfMembersbyProject(projectDto);
		logger.debug("!!!!!!!!!!!!!!!!!!!!Total memebr:" + memberList.size());
		List<ProjectExperienceDto> experienceList = projectManagementService
				.getProjectExperienceList(projectDto);
		List<ProjectFeedbackDto> feedbackList = projectManagementService
				.getProjectFeedbackList(projectDto);
		modelAndView = new ModelAndView("volunteer/viewProjectDetails");
		modelAndView.addObject("project", projectDto);
		modelAndView.addObject("memberList", memberList);
		modelAndView.addObject("experienceList", experienceList);
		modelAndView.addObject("feedbackList", feedbackList);
		modelAndView.addObject("projectInfo", new ProjectInfoVo());
		logger.debug("!!!!!!!!!!!!!!!!!!!!Total memebr:" + memberList.size());
		return modelAndView;

	}

	public ModelAndView raiseInterest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ProjectDto projectDto = (ProjectDto) modelAndView.getModel().get(
				"project");

		logger.debug("@@@@@@@@@@@@@@raiseInterest@@@@@@@@@:"
				+ projectDto.getPrjId());

		CodeDto codeDto = codeManagementServices
				.getCodeDescriptionByCodeCategoryAndCodeDesc(
						VMSConstants.CERTIFIATE_REQUEST_TYPE,
						VMSConstants.CERTIFIATE_REQUEST_TYPE_INDIVIDUAL);

		ProjectInterestDto projectInterestDto = new ProjectInterestDto();
		projectInterestDto.setPrjId(projectDto);
		projectInterestDto.setCreatedDte(new Date());

		projectInterestDto.setVersion(1);

		projectInterestDto.setUpdDte(new Date());
		projectInterestDto.setStsCd(codeDto.getCdId());

		projectInterestDto.setCreatedBy("XXX");
		projectInterestDto.setReqBy("ss");
		projectInterestDto.setUpdBy("ss");

		projectManagementService.raseInterest(projectInterestDto);

		logger.debug("@@@@@@@@@@@@@@successfully raise new project interest@@@@@@@@@:"
				+ projectDto.getPrjId());

		return modelAndView;

	}

	public ModelAndView postExperienceAndFb(HttpServletRequest request,
			HttpServletResponse response, ProjectInfoVo projectInfoVo)
			throws Exception {

		ProjectDto projectDto = (ProjectDto) modelAndView.getModel().get(
				"project");

		if (!StringUtil.isNullOrEmpty(projectInfoVo.getExperience())) {

			ProjectExperienceDto projectExperienceDto = new ProjectExperienceDto();
			projectExperienceDto.setPrjId(projectDto);
			projectExperienceDto.setCont(projectInfoVo.getExperience());
			projectExperienceDto.setCreatedBy(projectDto.getCreatedBy());
			projectExperienceDto.setCreatedDte(DateUtil.formatDate(new Date()));
			projectManagementService
					.postProjectExperience(projectExperienceDto);

		}

		if (!StringUtil.isNullOrEmpty(projectInfoVo.getFbTitle())) {

			CodeDto codeDto = codeManagementServices
					.getCodeDescriptionByCodeCategoryAndCodeDesc(
							VMSConstants.FEEDBACK_STATUS,
							VMSConstants.FEEDBACK_STATUS_SUMBITTED);

			ProjectFeedbackDto projectFeedbackDto = new ProjectFeedbackDto();
			projectFeedbackDto.setPrjId(projectDto);
			projectFeedbackDto.setCont(projectInfoVo.getFbContent());
			projectFeedbackDto.setTitle(projectInfoVo.getFbTitle());

			projectFeedbackDto.setUpdDte(new Date());
			projectFeedbackDto.setCreatedDte(new Date());
			projectFeedbackDto.setStsCd(codeDto.getCdId());
			projectFeedbackDto.setCreatedBy(projectDto.getCreatedBy());
			projectFeedbackDto.setUpdBy(projectDto.getCreatedBy());

			projectManagementService.postProjectFeedback(projectFeedbackDto);

		}

		List<ProjectMemberDto> memberList = memberManagementService
				.getListOfMembers(projectDto.getPrjId());
		List<ProjectExperienceDto> experienceList = projectManagementService
				.getProjectExperienceList(projectDto);
		List<ProjectFeedbackDto> feedbackList = projectManagementService
				.getProjectFeedbackList(projectDto);
		modelAndView = new ModelAndView("volunteer/viewProjectDetails");
		modelAndView.addObject("project", projectDto);
		modelAndView.addObject("memberList", memberList);
		modelAndView.addObject("experienceList", experienceList);
		modelAndView.addObject("feedbackList", feedbackList);
		modelAndView.addObject("projectInfo", new ProjectInfoVo());
		return modelAndView;

	}

	public ModelAndView requestCertificate(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ProjectDto projectDto = (ProjectDto) modelAndView.getModel().get(
				"project");

		logger.debug("@@@@@@@@@@@@@@requestCertificate@@@@@@@@@:"
				+ projectDto.getPrjId());

		CodeDto codeDto = codeManagementServices
				.getCodeDescriptionByCodeCategoryAndCodeDesc(
						VMSConstants.CERTIFIATE_REQUEST_TYPE,
						VMSConstants.CERTIFIATE_REQUEST_TYPE_INDIVIDUAL);

		CodeDto codeStatusDto = codeManagementServices
				.getCodeDescriptionByCodeCategoryAndCodeDesc(
						VMSConstants.CERTIFICATE_REQUEST_STATUS,
						VMSConstants.CERTIFICATE_REQUEST_STATUS_REQUEST);

		CertificateRequestDto certificateRequestDto = new CertificateRequestDto();
		certificateRequestDto.setPrjId(projectDto.getPrjId());
		certificateRequestDto.setCreatedBy(projectDto.getCreatedBy());
		certificateRequestDto.setCreatedDte(new Date());
		certificateRequestDto.setReqBy(projectDto.getCreatedBy());
		certificateRequestDto.setReqDte(new Date());
		certificateRequestDto.setReqSts(codeStatusDto.getCdId());
		certificateRequestDto.setReqTp(codeDto.getCdId());
		certificateRequestDto.setUpdBy(projectDto.getCreatedBy());
		certificateRequestDto.setUpdDte(new Date());
		certificateRequestDto.setVersion(1);

		projectManagementService.requestCertificate(certificateRequestDto);

		logger.debug("@@@@@@@@@@@@@@successfully reqCertifictae@@@@@@@@@:"
				+ projectDto.getPrjId());

		return modelAndView;

	}
}
