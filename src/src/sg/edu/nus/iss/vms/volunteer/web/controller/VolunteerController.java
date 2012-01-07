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
import sg.edu.nus.iss.vms.common.dto.CodeDto;
import sg.edu.nus.iss.vms.common.exception.ApplicationException;
import sg.edu.nus.iss.vms.common.service.CodeManagementServices;
import sg.edu.nus.iss.vms.common.util.CodeLookupUtil;
import sg.edu.nus.iss.vms.common.util.DateUtil;
import sg.edu.nus.iss.vms.common.util.StringUtil;
import sg.edu.nus.iss.vms.common.vo.UserSessionInfoVo;
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
import sg.edu.nus.iss.vms.project.vo.ProjectMemberVo;
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
	// modelAndView = new ModelAndView("volunteer/registerVolunteer");// jsp
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
			modelAndView = new ModelAndView("volunteer/updateVolunteer");// jsp
			// page
			modelAndView.addObject("titleList", CodeLookupUtil
					.getListOfCodeByCategory(VMSConstants.TITLE_CATEGORY));
			modelAndView.addObject("countryList", CodeLookupUtil
					.getListOfCodeByCategory(VMSConstants.COUNTRY_CATEGORY));
			// volunteer.setCmdType(VMSConstants.SCREEN_CMD_UPDATE);
			modelAndView.addObject("command", volunteer);

			if (logger.isDebugEnabled()) {
				logger.debug("updateVolunteer(HttpServletRequest, HttpServletResponse, VolunteerVo) - end");
			}
			return modelAndView;
		} else {
			validate(command);
			modelAndView = new ModelAndView("volunteer/updateVolunteer");
			modelAndView.addObject("titleList", CodeLookupUtil
					.getListOfCodeByCategory(VMSConstants.TITLE_CATEGORY));
			modelAndView.addObject("countryList", CodeLookupUtil
					.getListOfCodeByCategory(VMSConstants.COUNTRY_CATEGORY));
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

		modelAndView = new ModelAndView("volunteer/browseProject");// jsp page
		List<ProjectDto> projectList = projectManagementService
				.getAllProjectObjectList(ProjectDto.class);
		List<CodeDto> projectCodeList = CodeLookupUtil
				.getListOfCodeByCategory(VMSConstants.PROJECT_STATUS);
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

		modelAndView = new ModelAndView("volunteer/browseProject");// jsp page
		List<CodeDto> projectCodeList = CodeLookupUtil
				.getListOfCodeByCategory(VMSConstants.PROJECT_STATUS);

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

		List<CodeDto> projectStatusCodeList = CodeLookupUtil
				.getListOfCodeByCategory(VMSConstants.PROJECT_STATUS);
		List<CodeDto> roleCodeList = CodeLookupUtil
				.getListOfCodeByCategory(VMSConstants.MEMBER_ROLE);
		List<CodeDto> countryCodeList = CodeLookupUtil
				.getListOfCodeByCategory(VMSConstants.COUNTRY_CATEGORY);

		String projectStatus = "Unknown";
		String country = "Unknown";

		for (CodeDto codeDto : projectStatusCodeList) {
			if (codeDto.getCdId().equals(projectDto.getStsCd())) {
				projectStatus = codeDto.getVal();
				break;
			}
		}
		for (CodeDto codeDto : countryCodeList) {
			if (codeDto.getCdId().equals(projectDto.getCtryCd())) {
				country = codeDto.getVal();
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

		List<ProjectExperienceDto> experienceList = projectManagementService
				.getProjectExperienceList(projectDto);
		List<ProjectFeedbackDto> feedbackList = projectManagementService
				.getProjectFeedbackList(projectDto);
		modelAndView = new ModelAndView("volunteer/viewProjectDetails");

		PagedListHolder feedbackPagedListHolder = new PagedListHolder(
				feedbackList);
		if (!feedbackList.isEmpty()) {
			int page = ServletRequestUtils.getIntParameter(request, "p1", 0);
			feedbackPagedListHolder.setPage(page);
			feedbackPagedListHolder.setPageSize(6);
		}

		PagedListHolder exPagedListHolder = new PagedListHolder(experienceList);
		if (!experienceList.isEmpty()) {
			int page = ServletRequestUtils.getIntParameter(request, "p2", 0);
			exPagedListHolder.setPage(page);
			exPagedListHolder.setPageSize(6);
		}

		modelAndView.addObject("fbPagedListHolder", feedbackPagedListHolder);

		modelAndView.addObject("exPagedListHolder", exPagedListHolder);

		modelAndView.addObject("projectVo", projectVo);
		modelAndView.addObject("project", projectDto);
		modelAndView.addObject("memberList", memberList);

		modelAndView.addObject("projectInfo", new ProjectInfoVo());

		for (ProjectMemberVo projectMemberVo : memberList) {
			for (CodeDto codeDto : roleCodeList) {
				if (codeDto.getCdId().equals(
						Long.valueOf(projectMemberVo.getRoleCd()))) {
					projectMemberVo.setRoleCd(codeDto.getVal());
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

		CodeDto codeDto = CodeLookupUtil
				.getCodeDescriptionByCodeCategoryAndCodeDesc(
						VMSConstants.CERTIFIATE_REQUEST_TYPE,
						VMSConstants.CERTIFIATE_REQUEST_TYPE_INDIVIDUAL);

		ProjectInterestDto projectInterestDto = new ProjectInterestDto();
		projectInterestDto.setPrjId(projectDto);
		projectInterestDto.setCreatedDte(new Date());

		projectInterestDto.setVersion(1);

		projectInterestDto.setUpdDte(new Date());
		projectInterestDto.setStsCd(codeDto.getCdId());

		String loginId = "SuperUser";
		if (UserUtil.getUserSessionInfoVo() != null
				&& !StringUtil.isNullOrEmpty(UserUtil.getUserSessionInfoVo()
						.getUserID())) {
			loginId = UserUtil.getUserSessionInfoVo().getUserID();
		}

		List<ProjectInterestDto> projectInterestDtos = projectManagementService
				.getProjectInterestListbyProject(projectDto, loginId);

		if (projectInterestDtos.size() == 0) {

			projectInterestDto.setCreatedBy(loginId);
			projectInterestDto.setReqBy(loginId);
			projectInterestDto.setUpdBy(loginId);

			projectManagementService
					.saveOrUpdateProjectObject(projectInterestDto);

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

	public ModelAndView postExperienceAndFb(HttpServletRequest request,
			HttpServletResponse response, ProjectInfoVo projectInfoVo)
			throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("postExperienceAndFb(HttpServletRequest, HttpServletResponse, ProjectInfoVo) - start");
		}

		ProjectDto projectDto = (ProjectDto) modelAndView.getModel().get(
				"project");
		ProjectVo projectVo = (ProjectVo) modelAndView.getModel().get(
				"projectVo");

		String loginId = UserUtil.getUserSessionInfoVo().getUserID();

		modelAndView = new ModelAndView("volunteer/viewProjectDetails");

		if (!StringUtil.isNullOrEmpty(projectInfoVo.getExperience())) {

			ProjectExperienceDto projectExperienceDto = new ProjectExperienceDto();
			projectExperienceDto.setPrjId(projectDto);
			projectExperienceDto.setCont(projectInfoVo.getExperience());
			projectExperienceDto.setCreatedBy(loginId);
			projectExperienceDto.setCreatedDte(DateUtil.formatDate(new Date()));
			projectManagementService
					.saveOrUpdateProjectObject(projectExperienceDto);
			modelAndView.addObject("riMsg", Messages.getString(
					"message.common.submit.msg",
					new String[] { "Project Experience" }));

		}

		if (!StringUtil.isNullOrEmpty(projectInfoVo.getFbTitle())) {

			CodeDto codeDto = CodeLookupUtil
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
			projectFeedbackDto.setCreatedBy(loginId);
			projectFeedbackDto.setUpdBy(loginId);
			projectFeedbackDto.setVersion(1);

			projectManagementService
					.saveOrUpdateProjectObject(projectFeedbackDto);
			modelAndView.addObject("riMsg", Messages.getString(
					"message.common.submitreview.msg",
					new String[] { "Project Feedback" }));

		}

		List<ProjectMemberDto> memberList = memberManagementService
				.getListOfMembers(projectDto.getPrjId());
		List<ProjectExperienceDto> experienceList = projectManagementService
				.getProjectExperienceList(projectDto);
		List<ProjectFeedbackDto> feedbackList = projectManagementService
				.getProjectFeedbackList(projectDto);

		PagedListHolder feedbackPagedListHolder = new PagedListHolder(
				feedbackList);

		if (!feedbackList.isEmpty()) {
			int page = ServletRequestUtils.getIntParameter(request, "p1", 0);
			feedbackPagedListHolder.setPage(page);
			feedbackPagedListHolder.setPageSize(4);
		}

		PagedListHolder exPagedListHolder = new PagedListHolder(experienceList);
		if (!experienceList.isEmpty()) {
			int page = ServletRequestUtils.getIntParameter(request, "p2", 0);
			exPagedListHolder.setPage(page);
			exPagedListHolder.setPageSize(4);
		}

		modelAndView.addObject("fbPagedListHolder", feedbackPagedListHolder);

		modelAndView.addObject("exPagedListHolder", exPagedListHolder);

		modelAndView.addObject("project", projectDto);
		modelAndView.addObject("memberList", memberList);
		modelAndView.addObject("experienceList", experienceList);
		modelAndView.addObject("feedbackList", feedbackList);
		modelAndView.addObject("projectVo", projectVo);
		modelAndView.addObject("projectInfo", new ProjectInfoVo());

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
		ProjectVo projectVo = (ProjectVo) modelAndView.getModel().get(
				"projectVo");

		if (logger.isDebugEnabled()) {
			logger.debug("requestCertificate(HttpServletRequest, HttpServletResponse) - @@@@@@@@@@@@@@requestCertificate@@@@@@@@@: "
					+ projectDto.getPrjId());
		}

		CodeDto codeDto = CodeLookupUtil
				.getCodeDescriptionByCodeCategoryAndCodeDesc(
						VMSConstants.CERTIFIATE_REQUEST_TYPE,
						VMSConstants.CERTIFIATE_REQUEST_TYPE_INDIVIDUAL);

		CodeDto codeStatusDto = CodeLookupUtil
				.getCodeDescriptionByCodeCategoryAndCodeDesc(
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
			certificateRequestDto.setReqSts(codeStatusDto.getCdId());
			certificateRequestDto.setReqTp(codeDto.getCdId());
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
