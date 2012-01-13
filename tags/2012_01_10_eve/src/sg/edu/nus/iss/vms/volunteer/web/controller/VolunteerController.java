package sg.edu.nus.iss.vms.volunteer.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;

import sg.edu.nus.iss.vms.common.Messages;
import sg.edu.nus.iss.vms.common.constants.VMSConstants;
import sg.edu.nus.iss.vms.common.dto.CertificateRequestDto;
import sg.edu.nus.iss.vms.common.exception.ApplicationException;
import sg.edu.nus.iss.vms.common.service.CodeManagementServices;
import sg.edu.nus.iss.vms.common.util.CodeLookupUtil;
import sg.edu.nus.iss.vms.common.util.DateUtil;
import sg.edu.nus.iss.vms.common.util.StringUtil;
import sg.edu.nus.iss.vms.common.vo.CodeLookupVo;
import sg.edu.nus.iss.vms.common.vo.UserSessionInfoVo;
import sg.edu.nus.iss.vms.common.web.controller.BaseMultiActionFormController;
import sg.edu.nus.iss.vms.common.web.util.UserUtil;
import sg.edu.nus.iss.vms.member.service.MemberManagementService;
import sg.edu.nus.iss.vms.project.dto.ProjectDto;
import sg.edu.nus.iss.vms.project.dto.ProjectMemberDto;
import sg.edu.nus.iss.vms.project.service.ProjectExperienceService;
import sg.edu.nus.iss.vms.project.service.ProjectFeedbackService;
import sg.edu.nus.iss.vms.project.service.ProjectInterestService;
import sg.edu.nus.iss.vms.project.service.ProjectManagementService;
import sg.edu.nus.iss.vms.project.vo.ProjectExperienceVo;
import sg.edu.nus.iss.vms.project.vo.ProjectFeedbackVo;
import sg.edu.nus.iss.vms.project.vo.ProjectInterestVo;
import sg.edu.nus.iss.vms.project.vo.ProjectMemberVo;
import sg.edu.nus.iss.vms.project.vo.ProjectVo;
import sg.edu.nus.iss.vms.volunteer.service.VolunteerManagementService;
import sg.edu.nus.iss.vms.volunteer.vo.VolunteerVo;

public class VolunteerController extends BaseMultiActionFormController {

	private CodeManagementServices codeManagementServices;
	private VolunteerManagementService volunteerManagementService;
	private ProjectManagementService projectManagementService;
	private MemberManagementService memberManagementService;

	private ProjectFeedbackService projectFeedbackService;
	private ProjectExperienceService projectExperienceService;

	private ProjectInterestService projectInterestService;
	// local
	private final Logger logger = Logger.getLogger(VolunteerController.class);
	BindingResult errors;

	public void setProjectFeedbackService(
			ProjectFeedbackService projectFeedbackService) {
		this.projectFeedbackService = projectFeedbackService;
	}

	public void setProjectExperienceService(
			ProjectExperienceService projectExperienceService) {
		this.projectExperienceService = projectExperienceService;
	}

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

	public void setProjectInterestService(
			ProjectInterestService projectInterestService) {
		this.projectInterestService = projectInterestService;
	}

	@Override
	public long getLastModified(HttpServletRequest arg0) {
		if (logger.isDebugEnabled()) {
			logger.debug("getLastModified(HttpServletRequest) - start");
			logger.debug("getLastModified(HttpServletRequest) - ###################################################################################");
		}
		long returnlong = super.getLastModified(arg0);
		if (logger.isDebugEnabled()) {
			logger.debug("getLastModified(HttpServletRequest) - end");
		}
		return returnlong;
	}

	public BindingResult getErrors() {
		if (logger.isDebugEnabled()) {
			logger.debug("getErrors() - start");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getErrors() - end");
		}
		return errors;
	}

	public void setErrors(BindingResult errors) {
		if (logger.isDebugEnabled()) {
			logger.debug("setErrors(BindingResult) - start");
		}

		this.errors = errors;

		if (logger.isDebugEnabled()) {
			logger.debug("setErrors(BindingResult) - end");
		}
	}

	public ProjectManagementService getProjectManagementService() {
		if (logger.isDebugEnabled()) {
			logger.debug("getProjectManagementService() - start");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getProjectManagementService() - end");
		}
		return projectManagementService;
	}

	public void setProjectManagementService(
			ProjectManagementService projectManagementService) {
		this.projectManagementService = projectManagementService;
	}

	@Override
	protected void bind(HttpServletRequest request, Object command)
			throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("bind(HttpServletRequest, Object) - start");
		}

		// TODO Auto-generated method stub

		ServletRequestDataBinder binder = createBinder(request, command);
		binder.bind(request);
		errors = binder.getBindingResult();

		if (logger.isDebugEnabled()) {
			logger.debug("bind(HttpServletRequest, Object) - end");
		}
	}

	public void setMemberManagementService(
			MemberManagementService memberManagementService) {
		if (logger.isDebugEnabled()) {
			logger.debug("setMemberManagementService(MemberManagementService) - start");
		}

		this.memberManagementService = memberManagementService;

		if (logger.isDebugEnabled()) {
			logger.debug("setMemberManagementService(MemberManagementService) - end");
		}
	}

	public void validate(Object command) {
		if (logger.isDebugEnabled()) {
			logger.debug("validate(Object) - start");
		}

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

		if (logger.isDebugEnabled()) {
			logger.debug("validate(Object) - end");
		}
	}

	// public ModelAndView registerVolunteer(HttpServletRequest request,
	// HttpServletResponse response, VolunteerVo command) throws Exception {
	// if (logger.isDebugEnabled()) {
	// logger.debug("registerVolunteer(HttpServletRequest, HttpServletResponse, VolunteerVo) - start");
	// }
	//
	// modelAndView = new ModelAndView("volunteer/createProfile");// jsp
	// if (command.getLoginId() == null) {
	// // page
	// modelAndView.addObject("titleList", CodeLookupUtil
	// .getListOfCodeByCategory(VMSConstants.TITLE_CATEGORY));
	// modelAndView.addObject("countryList", CodeLookupUtil
	// .getListOfCodeByCategory(VMSConstants.COUNTRY_CATEGORY));
	// VolunteerVo volVo = new VolunteerVo();
	// volVo.setCmdType(VMSConstants.SCREEN_CMD_REGISTER);
	// modelAndView.addObject("command", volVo);
	//
	// if (logger.isDebugEnabled()) {
	// logger.debug("registerVolunteer(HttpServletRequest, HttpServletResponse, VolunteerVo) - end");
	// }
	// return modelAndView;
	// } else {
	// validate(command);
	// modelAndView.addObject("titleList", CodeLookupUtil
	// .getListOfCodeByCategory(VMSConstants.TITLE_CATEGORY));
	// modelAndView.addObject("countryList", CodeLookupUtil
	// .getListOfCodeByCategory(VMSConstants.COUNTRY_CATEGORY));
	// VolunteerVo volunteerVo = command;
	// if (errors.hasErrors()) {
	// logger.debug("registerVolunteer(HttpServletRequest, HttpServletResponse, VolunteerVo) - Error Handling : ");
	// saveError(request, errors.getFieldError().getDefaultMessage());
	// modelAndView.addObject("command", volunteerVo);
	//
	// if (logger.isDebugEnabled()) {
	// logger.debug("registerVolunteer(HttpServletRequest, HttpServletResponse, VolunteerVo) - end");
	// }
	// return modelAndView;
	// }
	// try {
	// volunteerManagementService.saveNewVolunteer(volunteerVo);
	// } catch (ApplicationException ae) {
	// logger.error(
	// "registerVolunteer(HttpServletRequest, HttpServletResponse, VolunteerVo)",
	// ae);
	//
	// List list = new ArrayList();
	// list.add(ae.getMessage());
	// modelAndView.addObject("errors", list);
	// modelAndView.addObject("command", volunteerVo);
	//
	// if (logger.isDebugEnabled()) {
	// logger.debug("registerVolunteer(HttpServletRequest, HttpServletResponse, VolunteerVo) - end");
	// }
	// return modelAndView;
	// }
	// volunteerVo.setCmdType(VMSConstants.SCREEN_CMD_REGISTER);
	// modelAndView.addObject("command", volunteerVo);
	// modelAndView.addObject("msg",
	// Messages.getString("message.common.save"));
	//
	// if (logger.isDebugEnabled()) {
	// logger.debug("registerVolunteer(HttpServletRequest, HttpServletResponse, VolunteerVo) - end");
	// }
	// return modelAndView;
	// }
	// }

	public ModelAndView updateVolunteer(HttpServletRequest request,
			HttpServletResponse response, VolunteerVo command) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("updateVolunteer(HttpServletRequest, HttpServletResponse, VolunteerVo) - start");
		}

		// TODO: get current login volunteer
		if (command.getLoginId() == null) {
			VolunteerVo volunteer = volunteerManagementService
					.getVolunteer(UserUtil.getUserSessionInfoVo().getUserID());
			volunteer.setCmdType(VMSConstants.SCREEN_CMD_UPDATE);
			// TODO: Update Session User
			modelAndView = new ModelAndView("volunteer/updateProfile");
			// page
			modelAndView.addObject("titleList", CodeLookupUtil
					.getCodeListByCategory(VMSConstants.TITLE_CATEGORY));
			modelAndView.addObject("countryList", CodeLookupUtil
					.getCodeListByCategory(VMSConstants.COUNTRY_CATEGORY));
			// volunteer.setCmdType(VMSConstants.SCREEN_CMD_UPDATE);
			modelAndView.addObject("command", volunteer);

			if (logger.isDebugEnabled()) {
				logger.debug("updateVolunteer(HttpServletRequest, HttpServletResponse, VolunteerVo) - end");
			}
			return modelAndView;
		} else {
			validate(command);
			modelAndView = new ModelAndView("volunteer/updateProfile");
			modelAndView.addObject("titleList", CodeLookupUtil
					.getCodeListByCategory(VMSConstants.TITLE_CATEGORY));
			modelAndView.addObject("countryList", CodeLookupUtil
					.getCodeListByCategory(VMSConstants.COUNTRY_CATEGORY));
			VolunteerVo volunteerVo = command;
			if (errors.hasErrors()) {
				logger.debug("updateVolunteer(HttpServletRequest, HttpServletResponse, VolunteerVo) - Error Handling : ");
				saveError(request, errors.getFieldError().getDefaultMessage());
				modelAndView.addObject("command", volunteerVo);

				if (logger.isDebugEnabled()) {
					logger.debug("updateVolunteer(HttpServletRequest, HttpServletResponse, VolunteerVo) - end");
				}
				return modelAndView;
			}

			try {
				volunteerManagementService.updateVolunteer(volunteerVo);
				// once updated, update the user session info vo to reflect the
				// changes
				UserSessionInfoVo userSessionInfoVo = UserUtil
						.getUserSessionInfoVo();
				userSessionInfoVo.setEmail(volunteerVo.getEmail());
				userSessionInfoVo.setName(volunteerVo.getNme());
				request.getSession()
						.setAttribute(
								(Messages
										.getString("AuthorisationFilter.SESSION_USER_SESSION_INFO_VO_ATTR_NME")),
								userSessionInfoVo);

				volunteerVo = volunteerManagementService.getVolunteer(UserUtil
						.getUserSessionInfoVo().getUserID());

			} catch (ApplicationException ae) {
				logger.error(
						"updateVolunteer(HttpServletRequest, HttpServletResponse, VolunteerVo)",
						ae);

				List list = new ArrayList();
				list.add(ae.getMessage());
				modelAndView.addObject("errors", list);
				modelAndView.addObject("command", volunteerVo);

				if (logger.isDebugEnabled()) {
					logger.debug("updateVolunteer(HttpServletRequest, HttpServletResponse, VolunteerVo) - end");
				}
				return modelAndView;
			}
			volunteerVo.setCmdType(VMSConstants.SCREEN_CMD_UPDATE);
			modelAndView.addObject("command", volunteerVo);
			modelAndView.addObject("msg",
					Messages.getString("message.common.save"));

			if (logger.isDebugEnabled()) {
				logger.debug("updateVolunteer(HttpServletRequest, HttpServletResponse, VolunteerVo) - end");
			}
			return modelAndView;
		}
	}

	public ModelAndView browseProject(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("browseProject(HttpServletRequest, HttpServletResponse) - start");
		}

		modelAndView = new ModelAndView("volunteer/viewProjectList");// jsp page
		List<ProjectDto> projectList = projectManagementService
				.getAllProjectObjectList(ProjectDto.class);
		List<CodeLookupVo> projectCodeList = CodeLookupUtil
				.getCodeListByCategory(VMSConstants.PROJECT_STATUS);
		logger.debug("The project size is" + projectList.size());
		modelAndView.addObject("projectList", projectList);
		modelAndView.addObject("command", new ProjectVo());
		modelAndView.addObject("projectCodeList", projectCodeList);

		PagedListHolder projectPagedListHolder = new PagedListHolder(
				projectList);
		if (!projectList.isEmpty()) {
			int page = ServletRequestUtils.getIntParameter(request, "p", 0);
			projectPagedListHolder.setPage(page);
			projectPagedListHolder.setPageSize(VMSConstants.MAX_PAGE_SIZE);
		}
		modelAndView.addObject("pagedListHolder", projectPagedListHolder);

		if (logger.isDebugEnabled()) {
			logger.debug("browseProject(HttpServletRequest, HttpServletResponse) - end");
		}
		return modelAndView;
	}

	public ModelAndView searchProjects(HttpServletRequest request,
			HttpServletResponse response, ProjectVo command) throws Exception {

		if (logger.isDebugEnabled()) {
			logger.debug("searchProjects(HttpServletRequest, HttpServletResponse, ProjectVo) - start");
		}

		modelAndView = new ModelAndView("volunteer/viewProjectList");// jsp page
		List<CodeLookupVo> projectCodeList = CodeLookupUtil
				.getCodeListByCategory(VMSConstants.PROJECT_STATUS);

		modelAndView.addObject("projectCodeList", projectCodeList);

		List<ProjectDto> projectList = projectManagementService
				.getProjectbyProjectVo(command);
		logger.debug("The project size is" + projectList.size());
		modelAndView.addObject("projectList", projectList);
		modelAndView.addObject("command", command);

		PagedListHolder projectPagedListHolder = new PagedListHolder(
				projectList);
		if (!projectList.isEmpty()) {
			int page = ServletRequestUtils.getIntParameter(request, "p", 0);
			projectPagedListHolder.setPage(page);
			projectPagedListHolder.setPageSize(VMSConstants.MAX_PAGE_SIZE);
		}
		modelAndView.addObject("pagedListHolder", projectPagedListHolder);

		if (logger.isDebugEnabled()) {
			logger.debug("searchProjects(HttpServletRequest, HttpServletResponse, ProjectVo) - end");
		}
		return modelAndView;

	}

	public ModelAndView viewProjectDetails(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("viewProjectDetails(HttpServletRequest, HttpServletResponse) - start");
		}

		long prjId = Long.parseLong(request.getParameter("prjId"));

		if (prjId <= 0) {
			if (logger.isDebugEnabled()) {
				logger.debug("viewProjectDetails(HttpServletRequest, HttpServletResponse) - end");
			}
			return modelAndView;
		}
		ProjectDto projectDto = (ProjectDto) projectManagementService
				.getProjectObjbyId(prjId, ProjectDto.class);

		List<CodeLookupVo> projectStatusCodeList = CodeLookupUtil
				.getCodeListByCategory(VMSConstants.PROJECT_STATUS);
		List<CodeLookupVo> roleCodeList = CodeLookupUtil
				.getCodeListByCategory(VMSConstants.MEMBER_ROLE);
		List<CodeLookupVo> countryCodeList = CodeLookupUtil
				.getCodeListByCategory(VMSConstants.COUNTRY_CATEGORY);

		String projectStatus = "Unknown";
		String country = "Unknown";

		for (CodeLookupVo codeLookupVo : projectStatusCodeList) {
			if (codeLookupVo.getCdId().equals(projectDto.getStsCd())) {
				projectStatus = codeLookupVo.getVal();
				break;
			}
		}
		for (CodeLookupVo codeLookupVo : countryCodeList) {
			if (codeLookupVo.getCdId().equals(projectDto.getCtryCd())) {
				country = codeLookupVo.getVal();
				break;
			}
		}

		String loginId = UserUtil.getUserSessionInfoVo().getUserID();

		ProjectVo projectVo = new ProjectVo();
		projectVo.setName(projectDto.getNme());
		projectVo.setLoginId(loginId);
		projectVo.setDesc(projectDto.getDesc());
		projectVo.setStrDte(DateUtil.formatDate(projectDto.getStrDte()));
		projectVo.setLoc(projectDto.getLoc());
		projectVo.setCtryCd(country);
		projectVo.setStsCd(projectStatus);

		List<ProjectMemberVo> memberList = memberManagementService
				.getListOfMembersbyProject(projectDto);

		List<ProjectExperienceVo> experienceList = projectExperienceService
				.getProjectExperienceListbyProjectId(projectDto.getPrjId());
		List<ProjectFeedbackVo> feedbackList = projectFeedbackService
				.getProjectFeedbackListbyProjectId(projectDto.getPrjId());
		modelAndView = new ModelAndView("volunteer/viewProject");

		PagedListHolder feedbackPagedListHolder = new PagedListHolder(
				feedbackList);
		if (!feedbackList.isEmpty()) {
			int page = ServletRequestUtils.getIntParameter(request, "p1", 0);
			feedbackPagedListHolder.setPage(page);
			feedbackPagedListHolder.setPageSize(100);
		}

		PagedListHolder exPagedListHolder = new PagedListHolder(experienceList);
		if (!experienceList.isEmpty()) {
			int page = ServletRequestUtils.getIntParameter(request, "p2", 0);
			exPagedListHolder.setPage(page);
			exPagedListHolder.setPageSize(100);
		}

		modelAndView.addObject("fbPagedListHolder", feedbackPagedListHolder);

		modelAndView.addObject("exPagedListHolder", exPagedListHolder);

		modelAndView.addObject("projectVo", projectVo);
		modelAndView.addObject("project", projectDto);
		modelAndView.addObject("memberList", memberList);

		modelAndView.addObject("feedbackVo", new ProjectFeedbackVo());

		modelAndView.addObject("experienceVo", new ProjectExperienceVo());

		for (ProjectMemberVo projectMemberVo : memberList) {
			for (CodeLookupVo codeLookupVo : roleCodeList) {
				if (codeLookupVo.getCdId().equals(
						Long.valueOf(projectMemberVo.getRoleCd()))) {
					projectMemberVo.setRoleCd(codeLookupVo.getVal());
					break;
				}
			}

		}

		if (logger.isDebugEnabled()) {
			logger.debug("viewProjectDetails(HttpServletRequest, HttpServletResponse) - Total memebr:"
					+ memberList.size());
			logger.debug("viewProjectDetails(HttpServletRequest, HttpServletResponse) - end");
		}

		return modelAndView;

	}

	public ModelAndView raiseInterest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("raiseInterest(HttpServletRequest, HttpServletResponse) - start");
		}

		ProjectDto projectDto = (ProjectDto) modelAndView.getModel().get(
				"project");

		if (logger.isDebugEnabled()) {
			logger.debug("raiseInterest(HttpServletRequest, HttpServletResponse) - @@@@@@@@@@@@@@raiseInterest@@@@@@@@@:"
					+ projectDto.getPrjId());
		}

		ProjectInterestVo projectInterestVo = new ProjectInterestVo();
		projectInterestVo.setPrjId(projectDto.getPrjId());

		String loginId = UserUtil.getUserSessionInfoVo().getUserID();

		List<ProjectInterestVo> projectInterestVos = projectInterestService
				.getProjectInterestListbyProjectIdAndUserId(
						projectDto.getPrjId(), loginId);

		if (projectInterestVos.size() == 0) {

			projectInterestService.createProjectInterest(projectInterestVo);

			if (logger.isDebugEnabled()) {
				logger.debug("raiseInterest(HttpServletRequest, HttpServletResponse) - @@@@@@@@@@@@@@successfully raise new project interest@@@@@@@@@:"
						+ projectDto.getPrjId());
			}

			modelAndView.addObject("riMsg", Messages.getString(
					"message.common.submit.msg",
					new String[] { "Project Interest" }));

		} else {

			modelAndView.addObject("riMsg", Messages.getString(
					"message.common.submit.adi.msg",
					new String[] { "Project Interest" }));
		}

		if (logger.isDebugEnabled()) {
			logger.debug("raiseInterest(HttpServletRequest, HttpServletResponse) - end");
		}
		return modelAndView;

	}

	public ModelAndView postExperience(HttpServletRequest request,
			HttpServletResponse response, ProjectExperienceVo experienceVo)
			throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("postExperienceAndFb(HttpServletRequest, HttpServletResponse, ProjectInfoVo) - start");
		}

		ProjectDto projectDto = (ProjectDto) modelAndView.getModel().get(
				"project");
		ProjectVo projectVo = (ProjectVo) modelAndView.getModel().get(
				"projectVo");

		logger.debug("experienceVoexperienceVoexperienceVo:"
				+ experienceVo.getCont());
		modelAndView = new ModelAndView("volunteer/viewProject");

		if (!StringUtil.isNullOrEmpty(experienceVo.getCont())) {

			logger.debug("Save experienceSave experienceSave experience");

			projectExperienceService.createProjectExperience(experienceVo);
			modelAndView.addObject("riMsg", Messages.getString(
					"message.common.submit.msg",
					new String[] { "Project Experience" }));

		}

		List<ProjectMemberDto> memberList = memberManagementService
				.getListOfMembers(projectDto.getPrjId());
		List<ProjectExperienceVo> experienceList = projectExperienceService
				.getProjectExperienceListbyProjectId(projectDto.getPrjId());
		List<ProjectFeedbackVo> feedbackList = projectFeedbackService
				.getProjectFeedbackListbyProjectId(projectDto.getPrjId());

		PagedListHolder feedbackPagedListHolder = new PagedListHolder(
				feedbackList);

		if (!feedbackList.isEmpty()) {
			int page = ServletRequestUtils.getIntParameter(request, "p1", 0);
			feedbackPagedListHolder.setPage(page);
			feedbackPagedListHolder.setPageSize(100);
		}

		PagedListHolder exPagedListHolder = new PagedListHolder(experienceList);
		if (!experienceList.isEmpty()) {
			int page = ServletRequestUtils.getIntParameter(request, "p2", 0);
			exPagedListHolder.setPage(page);
			exPagedListHolder.setPageSize(100);
		}

		modelAndView.addObject("fbPagedListHolder", feedbackPagedListHolder);

		modelAndView.addObject("exPagedListHolder", exPagedListHolder);

		modelAndView.addObject("project", projectDto);
		modelAndView.addObject("memberList", memberList);
		modelAndView.addObject("experienceList", experienceList);
		modelAndView.addObject("feedbackList", feedbackList);
		modelAndView.addObject("projectVo", projectVo);
		modelAndView.addObject("feedbackVo", new ProjectFeedbackVo());
		modelAndView.addObject("experienceVo", new ProjectExperienceVo());

		if (logger.isDebugEnabled()) {
			logger.debug("postExperienceAndFb(HttpServletRequest, HttpServletResponse, ProjectInfoVo) - end");
		}
		return modelAndView;

	}

	public ModelAndView postFeedback(HttpServletRequest request,
			HttpServletResponse response, ProjectFeedbackVo feedbackVo)
			throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("postExperienceAndFb(HttpServletRequest, HttpServletResponse, ProjectInfoVo) - start");
		}

		ProjectDto projectDto = (ProjectDto) modelAndView.getModel().get(
				"project");
		ProjectVo projectVo = (ProjectVo) modelAndView.getModel().get(
				"projectVo");

		modelAndView = new ModelAndView("volunteer/viewProject");

		if (!StringUtil.isNullOrEmpty(feedbackVo.getTitle())) {

			projectFeedbackService.createProjectFeedback(feedbackVo);
			modelAndView.addObject("riMsg", Messages.getString(
					"message.common.submitreview.msg",
					new String[] { "Project Feedback" }));

		}

		List<ProjectMemberDto> memberList = memberManagementService
				.getListOfMembers(projectDto.getPrjId());
		List<ProjectExperienceVo> experienceList = projectExperienceService
				.getProjectExperienceListbyProjectId(projectDto.getPrjId());
		List<ProjectFeedbackVo> feedbackList = projectFeedbackService
				.getProjectFeedbackListbyProjectId(projectDto.getPrjId());

		PagedListHolder feedbackPagedListHolder = new PagedListHolder(
				feedbackList);

		if (!feedbackList.isEmpty()) {
			int page = ServletRequestUtils.getIntParameter(request, "p1", 0);
			feedbackPagedListHolder.setPage(page);
			feedbackPagedListHolder.setPageSize(100);
		}

		PagedListHolder exPagedListHolder = new PagedListHolder(experienceList);
		if (!experienceList.isEmpty()) {
			int page = ServletRequestUtils.getIntParameter(request, "p2", 0);
			exPagedListHolder.setPage(page);
			exPagedListHolder.setPageSize(100);
		}

		modelAndView.addObject("fbPagedListHolder", feedbackPagedListHolder);

		modelAndView.addObject("exPagedListHolder", exPagedListHolder);

		modelAndView.addObject("project", projectDto);
		modelAndView.addObject("memberList", memberList);
		modelAndView.addObject("experienceList", experienceList);
		modelAndView.addObject("feedbackList", feedbackList);
		modelAndView.addObject("projectVo", projectVo);
		modelAndView.addObject("feedbackVo", new ProjectFeedbackVo());
		modelAndView.addObject("experienceVo", new ProjectExperienceVo());

		if (logger.isDebugEnabled()) {
			logger.debug("postExperienceAndFb(HttpServletRequest, HttpServletResponse, ProjectInfoVo) - end");
		}
		return modelAndView;

	}

	public ModelAndView requestCertificate(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("requestCertificate(HttpServletRequest, HttpServletResponse) - start");
		}

		ProjectDto projectDto = (ProjectDto) modelAndView.getModel().get(
				"project");

		if (logger.isDebugEnabled()) {
			logger.debug("requestCertificate(HttpServletRequest, HttpServletResponse) - @@@@@@@@@@@@@@requestCertificate@@@@@@@@@: "
					+ projectDto.getPrjId());
		}

		CodeLookupVo codeVo = CodeLookupUtil.getCodeByCategoryAndCodeValue(
				VMSConstants.CERTIFIATE_REQUEST_TYPE,
				VMSConstants.CERTIFIATE_REQUEST_TYPE_INDIVIDUAL);

		CodeLookupVo codeStatusVo = CodeLookupUtil
				.getCodeByCategoryAndCodeValue(
						VMSConstants.CERTIFICATE_REQUEST_STATUS,
						VMSConstants.CERTIFICATE_REQUEST_STATUS_REQUESTED);

		String loginId = UserUtil.getUserSessionInfoVo().getUserID();

		List<CertificateRequestDto> certificateRequestDtos = projectManagementService
				.getCertificateRequestsbyProject(projectDto.getPrjId(), loginId);

		if (certificateRequestDtos.size() == 0) {

			CertificateRequestDto certificateRequestDto = new CertificateRequestDto();
			certificateRequestDto.setPrjId(projectDto.getPrjId());
			certificateRequestDto.setCreatedBy(loginId);
			certificateRequestDto.setCreatedDte(new Date());
			certificateRequestDto.setReqBy(loginId);
			certificateRequestDto.setReqDte(new Date());
			certificateRequestDto.setReqSts(codeStatusVo.getCdId());
			certificateRequestDto.setReqTp(codeVo.getCdId());
			certificateRequestDto.setUpdBy(loginId);
			certificateRequestDto.setUpdDte(new Date());
			certificateRequestDto.setVersion(1);

			projectManagementService
					.saveOrUpdateProjectObject(certificateRequestDto);

			modelAndView.addObject("riMsg", Messages.getString(
					"message.common.submit.msg",
					new String[] { "Certificate Request" }));
		} else {
			modelAndView.addObject("riMsg", Messages.getString(
					"message.common.submit.adi.msg",
					new String[] { "Certificate Request" }));

		}

		if (logger.isDebugEnabled()) {
			logger.debug("requestCertificate(HttpServletRequest, HttpServletResponse) - @@@@@@@@@@@@@@successfully reqCertifictae@@@@@@@@@:"
					+ projectDto.getPrjId());
			logger.debug("requestCertificate(HttpServletRequest, HttpServletResponse) - start");
		}

		return modelAndView;

	}
}