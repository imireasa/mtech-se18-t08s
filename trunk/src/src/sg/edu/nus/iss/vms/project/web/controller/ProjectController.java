package sg.edu.nus.iss.vms.project.web.controller;

import java.util.ArrayList;
import java.util.Calendar;
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

import sg.edu.nus.iss.vms.admin.service.UserManagementServices;
import sg.edu.nus.iss.vms.common.Messages;
import sg.edu.nus.iss.vms.common.constants.VMSConstants;
import sg.edu.nus.iss.vms.common.dto.CodeDto;
import sg.edu.nus.iss.vms.common.exception.ApplicationException;
import sg.edu.nus.iss.vms.common.util.CodeLookupUtil;
import sg.edu.nus.iss.vms.common.util.DateUtil;
import sg.edu.nus.iss.vms.common.util.StringUtil;
import sg.edu.nus.iss.vms.common.web.controller.BaseMultiActionFormController;
import sg.edu.nus.iss.vms.common.web.util.UserUtil;
import sg.edu.nus.iss.vms.member.service.MemberManagementService;
import sg.edu.nus.iss.vms.project.dto.ProjectDto;
import sg.edu.nus.iss.vms.project.dto.ProjectMemberDto;
import sg.edu.nus.iss.vms.project.dto.ProjectProposalDto;
import sg.edu.nus.iss.vms.project.service.ProjectFeedbackService;
import sg.edu.nus.iss.vms.project.service.ProjectManagementService;
import sg.edu.nus.iss.vms.project.vo.ProjectFeedbackVo;
import sg.edu.nus.iss.vms.project.vo.ProjectInterestSearchVo;
import sg.edu.nus.iss.vms.project.vo.ProjectInterestVo;
import sg.edu.nus.iss.vms.project.vo.ProjectMemberVo;
import sg.edu.nus.iss.vms.project.vo.ProjectProposalVo;
import sg.edu.nus.iss.vms.project.vo.ProjectVo;
import sg.edu.nus.iss.vms.security.dto.UserDto;

public class ProjectController extends BaseMultiActionFormController {

	private final Logger logger = Logger.getLogger(ProjectController.class);
	private MemberManagementService memberManagementService;
	private ProjectManagementService projectManagementService;
	private ProjectFeedbackService projectFeedbackService;
	private UserManagementServices userManagementServices;
	private BindingResult errors;

	public void setProjectFeedbackService(
			ProjectFeedbackService projectFeedbackService) {
		this.projectFeedbackService = projectFeedbackService;
	}

	public MemberManagementService getMemberManagementService() {
		return memberManagementService;
	}

	public void setMemberManagementService(
			MemberManagementService memberManagementService) {
		this.memberManagementService = memberManagementService;
	}

	public ProjectManagementService getProjectManagementService() {
		return projectManagementService;
	}

	public void setProjectManagementService(
			ProjectManagementService projectManagementService) {
		this.projectManagementService = projectManagementService;
	}

	public UserManagementServices getUserManagementServices() {
		return userManagementServices;
	}

	public void setUserManagementServices(
			UserManagementServices userManagementServices) {
		this.userManagementServices = userManagementServices;
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

	public ModelAndView assignPrjMemberRole(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("assignPrjMemberRole(HttpServletRequest, HttpServletResponse) - start");
		}

		modelAndView = new ModelAndView("project/assignMemberRole");
		List memberList = new ArrayList();

		if (logger.isDebugEnabled()) {
			logger.debug("assignPrjMemberRole(HttpServletRequest, HttpServletResponse) - REQUEST Project "
					+ request.getParameter("project"));
			logger.debug("assignPrjMemberRole(HttpServletRequest, HttpServletResponse) - REQUEST Member  "
					+ request.getParameter("member"));
		}

		List projectList = projectManagementService.getListAllProject();
		modelAndView.addObject("projectList", projectList);

		List projectRoleList = new ArrayList<CodeDto>();
		modelAndView.addObject("projectRoleList", projectRoleList);

		if (request.getParameter("project") != null
				&& !request.getParameter("project").isEmpty()) {
			long projectId = Long.parseLong(request.getParameter("project"));
			memberList = projectManagementService.getProjectMember(projectId);
		}

		PagedListHolder memberPagedListHolder = new PagedListHolder(memberList);
		if (!memberList.isEmpty()) {
			int page = ServletRequestUtils.getIntParameter(request, "p", 0);
			memberPagedListHolder.setPage(page);
			int pageSize = 10;
			memberPagedListHolder.setPageSize(pageSize);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("assignPrjMemberRole(HttpServletRequest, HttpServletResponse) - Completed the request");
		}

		modelAndView.addObject("pagedListHolder", memberPagedListHolder);

		if (logger.isDebugEnabled()) {
			logger.debug("assignPrjMemberRole(HttpServletRequest, HttpServletResponse) - end");
		}
		return modelAndView;

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

	public void validate(Object command) {
		if (logger.isDebugEnabled()) {
			logger.debug("validate(Object) - start");
		}

		Validator[] validators = getValidators();
		if (validators != null) {
			for (int index = 0; index < validators.length; index++) {
				Validator validator = validators[index];
				if (validator instanceof ProjectValidator) {
					if (((ProjectValidator) validator).supports(command
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

	public ModelAndView createProject(HttpServletRequest request,
			HttpServletResponse response, ProjectVo command) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("createProject(HttpServletRequest, HttpServletResponse, ProjectVo) - start");
		}

		if (command.getName() == null) {
			modelAndView = new ModelAndView("project/createProject");
			// page
			modelAndView.addObject("countryList", CodeLookupUtil
					.getListOfCodeByCategory(VMSConstants.COUNTRY_CATEGORY));
			ProjectVo projectVo = new ProjectVo();
			projectVo.setCmdType(VMSConstants.SCREEN_CMD_CREATE);
			modelAndView.addObject("command", projectVo);

			if (logger.isDebugEnabled()) {
				logger.debug("createProject(HttpServletRequest, HttpServletResponse, ProjectVo) - end");
			}
			return modelAndView;
		} else {
			validate(command);
			modelAndView = new ModelAndView("project/createProject");
			modelAndView.addObject("countryList", CodeLookupUtil
					.getListOfCodeByCategory(VMSConstants.COUNTRY_CATEGORY));
			ProjectVo projectVo = command;

			if (errors.hasErrors()) {
				logger.debug("Error Handling : ");
				saveError(request, errors.getFieldError().getDefaultMessage());
				modelAndView.addObject("command", projectVo);

				if (logger.isDebugEnabled()) {
					logger.debug("createProject(HttpServletRequest, HttpServletResponse, ProjectVo) - end");
				}
				return modelAndView;
			}

			try {
				CodeDto stsNew = CodeLookupUtil.getCodeDtoByCatVal(
						VMSConstants.PROJECT_STATUS_CATEGORY,
						VMSConstants.PROJECT_STATUS_CATEGORY_NEW);
				projectVo.setStsCd(stsNew.getCdId() + "");

				projectManagementService.saveProject(projectVo);
				modelAndView.addObject("command", new ProjectVo());
			} catch (ApplicationException ae) {
				logger.error(
						"createProject(HttpServletRequest, HttpServletResponse, ProjectVo)",
						ae);

				List list = new ArrayList();
				list.add(ae.getMessage());
				modelAndView.addObject("errors", list);
				modelAndView.addObject("command", projectVo);

				if (logger.isDebugEnabled()) {
					logger.debug("createProject(HttpServletRequest, HttpServletResponse, ProjectVo) - end");
				}
				return modelAndView;
			}

			modelAndView.addObject("msg",
					Messages.getString("message.common.save"));
			if (logger.isDebugEnabled()) {
				logger.debug("createProject(HttpServletRequest, HttpServletResponse, ProjectVo) - end");
			}
			return modelAndView;
		}
	}

	public ModelAndView updateProject(HttpServletRequest request,
			HttpServletResponse response, ProjectVo command) throws Exception {
		if (logger.isInfoEnabled()) {
			logger.info("updateProject(HttpServletRequest, HttpServletResponse, ProjectVo) - updateProject");
		}
		Long projectId = 1L;
		if (!StringUtil.isNullOrEmpty(request.getParameter("prjId"))) {
			projectId = Long.parseLong(request.getParameter("prjId"));
		}

		if (command.getName() == null) {
			ProjectVo project = projectManagementService
					.getProjectVoById(projectId);
			modelAndView = new ModelAndView("project/updateProject");
			// page
			modelAndView.addObject("countryList", CodeLookupUtil
					.getListOfCodeByCategory(VMSConstants.COUNTRY_CATEGORY));
			modelAndView
					.addObject(
							"statusList",
							CodeLookupUtil
									.getListOfCodeByCategory(VMSConstants.PROJECT_STATUS_CATEGORY));
			project.setCmdType(VMSConstants.SCREEN_CMD_UPDATE);
			modelAndView.addObject("command", project);

			if (logger.isDebugEnabled()) {
				logger.debug("updateProject(HttpServletRequest, HttpServletResponse, ProjectVo) - end");
			}
			return modelAndView;
		} else {
			validate(command);
			modelAndView = new ModelAndView("project/updateProject");
			modelAndView.addObject("countryList", CodeLookupUtil
					.getListOfCodeByCategory(VMSConstants.COUNTRY_CATEGORY));
			modelAndView
					.addObject(
							"statusList",
							CodeLookupUtil
									.getListOfCodeByCategory(VMSConstants.PROJECT_STATUS_CATEGORY));

			ProjectVo projectVo = command;
			if (errors.hasErrors()) {
				if (logger.isDebugEnabled()) {
					logger.debug("updateProject(HttpServletRequest, HttpServletResponse, ProjectVo) - Error Handling :");
				}
				saveError(request, errors.getFieldError().getDefaultMessage());
				modelAndView.addObject("command", projectVo);

				if (logger.isDebugEnabled()) {
					logger.debug("updateProject(HttpServletRequest, HttpServletResponse, ProjectVo) - end");
				}
				return modelAndView;
			}

			try {
				projectManagementService.updateProject(projectVo);
			} catch (ApplicationException ae) {
				logger.error(
						"updateProject(HttpServletRequest, HttpServletResponse, ProjectVo)",
						ae);

				List list = new ArrayList();
				list.add(ae.getMessage());
				modelAndView.addObject("errors", list);
				modelAndView.addObject("command", projectVo);

				if (logger.isDebugEnabled()) {
					logger.debug("updateProject(HttpServletRequest, HttpServletResponse, ProjectVo) - end");
				}
				return modelAndView;
			}
			ProjectVo projectVo2 = projectManagementService
					.getProjectVoById(projectId);
			modelAndView.addObject("command", projectVo2);
			modelAndView.addObject("msg",
					Messages.getString("message.common.update"));

			if (logger.isDebugEnabled()) {
				logger.debug("updateProject(HttpServletRequest, HttpServletResponse, ProjectVo) - end");
			}
			return modelAndView;
		}
	}

	public ModelAndView viewProject(HttpServletRequest request,
			HttpServletResponse response, ProjectVo command) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("viewProject(HttpServletRequest, HttpServletResponse, ProjectVo) - start");
		}

		Long projectId = 1L;
		if (!StringUtil.isNullOrEmpty(request.getParameter("prjId"))) {
			projectId = Long.parseLong(request.getParameter("prjId"));
		}

		ProjectVo projectVo = projectManagementService
				.getProjectVoById(projectId);
		modelAndView = new ModelAndView("project/viewProject");

		projectVo.setCtryCd(CodeLookupUtil.getCodeDescriptionByCodeId(Long
				.parseLong(projectVo.getCtryCd())));
		projectVo.setStsCd(CodeLookupUtil.getCodeDescriptionByCodeId(Long
				.parseLong(projectVo.getStsCd())));
		modelAndView.addObject("command", projectVo);

		// Getting Project Member..

		List projMemberList = projectManagementService
				.getProjectMember(projectId);
		List projMemberVoList = new ArrayList();
		if (projMemberList != null) {
			for (int i = 0; i < projMemberList.size(); i++) {
				ProjectMemberDto obj = (ProjectMemberDto) projMemberList.get(i);
				ProjectMemberVo voObj = new ProjectMemberVo();

				UserDto member = userManagementServices.getUserByLoginId(obj
						.getUsrLoginId());
				String title = CodeLookupUtil.getCodeDescriptionByCodeId(member
						.getTitleCd());
				voObj.setNme(title + " " + member.getNme());
				voObj.setCtry(CodeLookupUtil.getCodeDescriptionByCodeId(member
						.getCtryCd()));
				voObj.setRole(CodeLookupUtil.getCodeDescriptionByCodeId(obj
						.getRoleCd()));
				projMemberVoList.add(voObj);
			}
		}

		PagedListHolder projMemberPagedListHolder = new PagedListHolder(
				projMemberVoList);
		if (!projMemberVoList.isEmpty()) {
			int page = ServletRequestUtils.getIntParameter(request, "p", 0);
			projMemberPagedListHolder.setPage(page);
			projMemberPagedListHolder.setPageSize(VMSConstants.MAX_PAGE_SIZE);
		}
		modelAndView.addObject("pagedListHolder", projMemberPagedListHolder);

		if (logger.isDebugEnabled()) {
			logger.debug("viewProject(HttpServletRequest, HttpServletResponse, ProjectVo) - end");
		}
		return modelAndView;
	}

	public ModelAndView browseProjectFeedback(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("browseProjectFeedback(HttpServletRequest, HttpServletResponse) - start");
		}

		List<ProjectFeedbackVo> projectFeedbackList = projectFeedbackService
				.getProjectFeedbackList();

		List<CodeDto> codeDtos = CodeLookupUtil
				.getListOfCodeByCategory(VMSConstants.FEEDBACK_STATUS);

		modelAndView = new ModelAndView("project/browseProjectFeedback");
		modelAndView.addObject("feedbackList", projectFeedbackList);
		modelAndView.addObject("feedbackVo", new ProjectFeedbackVo());
		modelAndView.addObject("fbCodeList", codeDtos);

		PagedListHolder projectPagedListHolder = new PagedListHolder(
				projectFeedbackList);
		if (!projectFeedbackList.isEmpty()) {
			int page = ServletRequestUtils.getIntParameter(request, "p", 0);
			projectPagedListHolder.setPage(page);
			projectPagedListHolder.setPageSize(VMSConstants.MAX_PAGE_SIZE);
		}
		modelAndView.addObject("pagedListHolder", projectPagedListHolder);

		if (logger.isDebugEnabled()) {
			logger.debug("browseProjectFeedback(HttpServletRequest, HttpServletResponse) - end");
		}
		return modelAndView;

	}

	public ModelAndView searchProjectFeedback(HttpServletRequest request,
			HttpServletResponse response, ProjectFeedbackVo projectFeedbackVo)
			throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("searchProjectFeedback(HttpServletRequest, HttpServletResponse, ProjectInfoVo) - start");
		}

		List<ProjectFeedbackVo> projectFeedbackList = projectFeedbackService
				.getProjectFeedbackListbySearchCriteria(projectFeedbackVo);

		modelAndView.addObject("feedbackVo", projectFeedbackVo);

		modelAndView.addObject("feedbackList", projectFeedbackList);

		PagedListHolder projectPagedListHolder = new PagedListHolder(
				projectFeedbackList);
		if (!projectFeedbackList.isEmpty()) {
			int page = ServletRequestUtils.getIntParameter(request, "p", 0);
			projectPagedListHolder.setPage(page);
			projectPagedListHolder.setPageSize(VMSConstants.MAX_PAGE_SIZE);
		}
		modelAndView.addObject("pagedListHolder", projectPagedListHolder);

		if (logger.isDebugEnabled()) {
			logger.debug("searchProjectFeedback(HttpServletRequest, HttpServletResponse, ProjectInfoVo) - end");
		}
		return modelAndView;

	}

	public ModelAndView viewProjectFeedbackDetails(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("viewProjectFeedbackDetails(HttpServletRequest, HttpServletResponse) - start");
		}

		long prjFbId = Long.parseLong(request.getParameter("prjFbId"));

		ProjectFeedbackVo projectFeedbackVo = projectFeedbackService
				.getProjectFeedbackbyId(prjFbId);

		modelAndView = new ModelAndView("project/viewProjectFeedbackDetails");
		modelAndView.addObject("projectFbVo", projectFeedbackVo);
		if (logger.isDebugEnabled()) {
			logger.debug("viewProjectFeedbackDetails(HttpServletRequest, HttpServletResponse) - XXXXXXXXXXXXXXXXXXXXXXcretaed date"
					+ projectFeedbackVo.getCreatedBy()
					+ ","
					+ projectFeedbackVo.getCreatedBy());
			logger.debug("viewProjectFeedbackDetails(HttpServletRequest, HttpServletResponse) - end");
		}

		return modelAndView;
	}

	public ModelAndView approveFb(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("approveFb(HttpServletRequest, HttpServletResponse) - start");
		}

		ProjectFeedbackVo projectFbVo = (ProjectFeedbackVo) modelAndView
				.getModel().get("projectFbVo");

		CodeDto codeDto = CodeLookupUtil.getCodeByCategoryAndCodeValue(
				VMSConstants.FEEDBACK_STATUS,
				VMSConstants.FEEDBACK_STATUS_APPROVED);

		projectFbVo.setStsCd(codeDto.getCdId());

		projectFeedbackService.updateProjectFeedback(projectFbVo);
		modelAndView.addObject("fbMsg", Messages.getString(
				"message.common.publish", new String[] { "Feedback" }));

		if (logger.isDebugEnabled()) {
			logger.debug("approveFb(HttpServletRequest, HttpServletResponse) - end");
		}
		return modelAndView;
	}

	public ModelAndView rejectFb(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("rejectFb(HttpServletRequest, HttpServletResponse) - start");
		}

		ProjectFeedbackVo projectFbVo = (ProjectFeedbackVo) modelAndView
				.getModel().get("projectFbVo");

		CodeDto codeDto = CodeLookupUtil.getCodeByCategoryAndCodeValue(
				VMSConstants.FEEDBACK_STATUS,
				VMSConstants.FEEDBACK_STATUS_REJECTED);

		projectFbVo.setStsCd(codeDto.getCdId());

		projectFeedbackService.updateProjectFeedback(projectFbVo);
		modelAndView.addObject("fbMsg", Messages.getString(
				"message.common.reject", new String[] { "Feedback" }));

		if (logger.isDebugEnabled()) {
			logger.debug("rejectFb(HttpServletRequest, HttpServletResponse) - end");
		}
		return modelAndView;
	}

	public ModelAndView proposeNewProject(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("proposeNewProject(HttpServletRequest, HttpServletResponse) - start");
		}

		ModelAndView modelAndView = new ModelAndView(
				"project/proposeNewProject");
		modelAndView.addObject("proposalVo", new ProjectProposalVo());

		modelAndView.addObject("countryList", CodeLookupUtil
				.getListOfCodeByCategory(VMSConstants.COUNTRY_CATEGORY));

		if (logger.isDebugEnabled()) {
			logger.debug("proposeNewProject(HttpServletRequest, HttpServletResponse) - end");
		}
		return modelAndView;
	}

	public ModelAndView submitProjectProposal(HttpServletRequest request,
			HttpServletResponse response, ProjectProposalVo proposalVo)
			throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("submitProjectProposal(HttpServletRequest, HttpServletResponse, ProjectProposalVo) - start");
		}

		validate(proposalVo);

		ModelAndView modelAndView = new ModelAndView(
				"project/proposeNewProject");
		modelAndView.addObject("proposalVo", proposalVo);

		List<CodeDto> countryCodeDtos = CodeLookupUtil
				.getListOfCodeByCategory(VMSConstants.COUNTRY_CATEGORY);
		modelAndView.addObject("countryList", countryCodeDtos);

		if (errors.hasErrors()) {
			logger.debug("Error Handling : ");
			saveError(request, errors.getFieldError().getDefaultMessage());

			if (logger.isDebugEnabled()) {
				logger.debug("submitProjectProposal(HttpServletRequest, HttpServletResponse, ProjectProposalVo) - end");
			}
			return modelAndView;
		}

		CodeDto codeDto = CodeLookupUtil.getCodeByCategoryAndCodeValue(
				VMSConstants.PROPOSAL_STATUS,
				VMSConstants.PROPOSAL_STATUS_SUMBITTED);

		long countryCodeId = 0;
		for (CodeDto countryCodeDto : countryCodeDtos) {
			if (countryCodeDto.getVal().equals(proposalVo.getCtryCd())) {
				countryCodeId = codeDto.getCdId();
				break;
			}
		}

		String loginId = UserUtil.getUserSessionInfoVo().getUserID();

		ProjectProposalDto projectProposalDto = new ProjectProposalDto();
		projectProposalDto.setCtryCd(countryCodeId);
		projectProposalDto.setEstDur(Integer.valueOf(proposalVo
				.getEstDuration()));
		projectProposalDto.setLoc(proposalVo.getLoc());
		projectProposalDto.setNme(proposalVo.getName());
		projectProposalDto.setDesc(proposalVo.getDesc());
		projectProposalDto.setCreatedDte(new Date());
		projectProposalDto.setUpdDte(new Date());
		projectProposalDto.setStsCd(codeDto.getCdId());
		projectProposalDto.setProposerId(loginId);
		projectProposalDto.setCreatedBy(loginId);
		projectProposalDto.setUpdBy(loginId);
		projectProposalDto.setVersion(1);

		projectManagementService.saveOrUpdateProjectObject(projectProposalDto);
		modelAndView
				.addObject("msg", Messages.getString("message.common.save"));

		if (logger.isDebugEnabled()) {
			logger.debug("submitProjectProposal(HttpServletRequest, HttpServletResponse, ProjectProposalVo) - end");
		}
		return modelAndView;
	}

	public ModelAndView browseProjectProposal(HttpServletRequest request,
			HttpServletResponse response) {
		if (logger.isDebugEnabled()) {
			logger.debug("browseProjectProposal(HttpServletRequest, HttpServletResponse) - start");
		}

		List<ProjectProposalDto> projectProposalDtos = projectManagementService
				.getAllProjectObjectList(ProjectProposalDto.class);

		List<CodeDto> codeDtos = CodeLookupUtil
				.getListOfCodeByCategory(VMSConstants.PROPOSAL_STATUS);

		modelAndView = new ModelAndView("project/browseProjectProposal");
		modelAndView.addObject("proposalList", projectProposalDtos);
		modelAndView.addObject("proposalVo", new ProjectProposalVo());
		modelAndView.addObject("stsCdList", codeDtos);

		PagedListHolder projectPagedListHolder = new PagedListHolder(
				projectProposalDtos);
		if (!projectProposalDtos.isEmpty()) {
			int page = ServletRequestUtils.getIntParameter(request, "p", 0);
			projectPagedListHolder.setPage(page);
			projectPagedListHolder.setPageSize(VMSConstants.MAX_PAGE_SIZE);
		}
		modelAndView.addObject("pagedListHolder", projectPagedListHolder);

		if (logger.isDebugEnabled()) {
			logger.debug("browseProjectProposal(HttpServletRequest, HttpServletResponse) - end");
		}
		return modelAndView;

	}

	public ModelAndView searchProjectProposal(HttpServletRequest request,
			HttpServletResponse response, ProjectProposalVo proposalVo)
			throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("searchProjectProposal(HttpServletRequest, HttpServletResponse, ProjectVo) - start");
		}

		List<ProjectProposalDto> projectProposalDtos = projectManagementService
				.getProjectProposalListbyVo(proposalVo);

		List<CodeDto> codeDtos = CodeLookupUtil
				.getListOfCodeByCategory(VMSConstants.PROPOSAL_STATUS);
		modelAndView = new ModelAndView("project/browseProjectProposal");
		modelAndView.addObject("proposalList", projectProposalDtos);

		modelAndView.addObject("proposalVo", proposalVo);
		modelAndView.addObject("stsCdList", codeDtos);

		modelAndView.addObject("proposalList", projectProposalDtos);

		PagedListHolder projectPagedListHolder = new PagedListHolder(
				projectProposalDtos);
		if (!projectProposalDtos.isEmpty()) {
			int page = ServletRequestUtils.getIntParameter(request, "p", 0);
			projectPagedListHolder.setPage(page);
			projectPagedListHolder.setPageSize(VMSConstants.MAX_PAGE_SIZE);
		}
		modelAndView.addObject("pagedListHolder", projectPagedListHolder);

		if (logger.isDebugEnabled()) {
			logger.debug("searchProjectProposal(HttpServletRequest, HttpServletResponse, ProjectVo) - end");
		}
		return modelAndView;

	}

	public ModelAndView viewProjectProposalDetails(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("viewProjectProposalDetails(HttpServletRequest, HttpServletResponse) - start");
		}

		List<CodeDto> codeDtos = CodeLookupUtil
				.getListOfCodeByCategory(VMSConstants.PROPOSAL_STATUS);

		long prjProId = Long.parseLong(request.getParameter("prjPropId"));

		ProjectProposalDto projectPropDto = (ProjectProposalDto) projectManagementService
				.getProjectObjbyId(prjProId, ProjectProposalDto.class);

		List<CodeDto> projectStatusCodeList = CodeLookupUtil
				.getListOfCodeByCategory(VMSConstants.PROPOSAL_STATUS);
		List<CodeDto> countryCodeList = CodeLookupUtil
				.getListOfCodeByCategory(VMSConstants.COUNTRY_CATEGORY);
		String projectStatus = "Unknown";
		String country = "Unknown";

		for (CodeDto codeDto : projectStatusCodeList) {
			if (codeDto.getCdId().equals(projectPropDto.getStsCd())) {
				projectStatus = codeDto.getVal();
				break;
			}
		}
		for (CodeDto codeDto : countryCodeList) {
			if (codeDto.getCdId().equals(projectPropDto.getCtryCd())) {
				country = codeDto.getVal();
				break;
			}
		}

		ProjectProposalVo projectProposalVo = new ProjectProposalVo();
		projectProposalVo.setName(projectPropDto.getNme());
		projectProposalVo.setDesc(projectPropDto.getDesc());
		projectProposalVo.setEstDuration(projectPropDto.getEstDur());
		projectProposalVo.setLoc(projectPropDto.getLoc());
		projectProposalVo.setRmk(projectPropDto.getRmk());
		projectProposalVo.setCtryCd(country);
		projectProposalVo.setStatus(projectStatus);
		projectProposalVo.setProposerId(projectPropDto.getProposerId());

		modelAndView = new ModelAndView("project/viewProjectProposalDetails");
		modelAndView.addObject("proposal", projectPropDto);
		modelAndView.addObject("stsCdList", codeDtos);
		modelAndView.addObject("proposalVo", projectProposalVo);

		if (logger.isDebugEnabled()) {
			logger.debug("viewProjectProposalDetails(HttpServletRequest, HttpServletResponse) - end");
		}
		return modelAndView;

	}

	public ModelAndView reviewProposal(HttpServletRequest request,
			HttpServletResponse response, ProjectProposalVo proposalVo)
			throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("reviewProposal(HttpServletRequest, HttpServletResponse, ProjectProposalVo) - start");
		}

		ProjectProposalDto projectPropDto = (ProjectProposalDto) modelAndView
				.getModel().get("proposal");

		List<CodeDto> codeDtos = (List<CodeDto>) modelAndView.getModel().get(
				"stsCdList");

		long approveCodeId = 0;
		long rejectCodeId = 0;
		for (CodeDto codeDto : codeDtos) {
			if (codeDto.getVal().equals(VMSConstants.PROPOSAL_STATUS_APPROVED)) {
				approveCodeId = codeDto.getCdId();
			} else if (codeDto.getVal().equals(
					VMSConstants.PROPOSAL_STATUS_REJECTED)) {
				rejectCodeId = codeDto.getCdId();
			}

		}

		String loginId = UserUtil.getUserSessionInfoVo().getUserID();

		String propMsg = Messages.getString("message.common.update");

		if (VMSConstants.PROPOSAL_STATUS_APPROVED
				.equals(proposalVo.getStatus())
				|| VMSConstants.PROPOSAL_STATUS_REJECTED.equals(proposalVo
						.getStatus())) {

			projectPropDto.setApprDte(new Date());
			projectPropDto.setUpdDte(new Date());
			projectPropDto.setApprBy(loginId);
			projectPropDto.setUpdBy(loginId);
			projectPropDto.setUpdBy(loginId);

			if (VMSConstants.PROPOSAL_STATUS_APPROVED.equals(proposalVo
					.getStatus())) {
				projectPropDto.setStsCd(approveCodeId);
				propMsg = Messages.getString("message.common.approve",
						new String[] { "Project Proposal" });

				ProjectDto projectDto = new ProjectDto();
				projectDto.setNme(projectPropDto.getNme());
				projectDto.setDesc(projectPropDto.getDesc());
				projectDto.setCtryCd(projectPropDto.getCtryCd());
				projectDto.setLoc(projectPropDto.getLoc());
				projectDto.setStrDte(new Date());
				projectDto.setEndDte(DateUtil.add(projectDto.getStrDte(),
						Calendar.DAY_OF_YEAR, projectPropDto.getEstDur()));
				projectDto.setPrjMgr(loginId);

				CodeDto projectStsCodeDto = CodeLookupUtil
						.getCodeByCategoryAndCodeValue(
								VMSConstants.PROJECT_STATUS,
								VMSConstants.PROJECT_STATUS_CATEGORY_NEW);
				projectDto.setStsCd(projectStsCodeDto.getCdId());
				projectDto.setPrjPropId(projectPropDto);
				projectDto.setCreatedBy(loginId);
				projectDto.setCreatedDte(new Date());
				projectDto.setUpdBy(loginId);
				projectDto.setUpdDte(new Date());

				projectManagementService.saveOrUpdateProjectObject(projectDto);

			} else {
				projectPropDto.setStsCd(rejectCodeId);
				propMsg = Messages.getString("message.common.reject",
						new String[] { "Project Proposal" });

			}
		}
		projectPropDto.setRmk(proposalVo.getRmk());

		String projectStatus = "Unknown";
		String country = "Unknown";

		List<CodeDto> countryCodeList = CodeLookupUtil
				.getListOfCodeByCategory(VMSConstants.COUNTRY_CATEGORY);

		for (CodeDto codeDto : codeDtos) {
			if (codeDto.getCdId().equals(projectPropDto.getStsCd())) {
				projectStatus = codeDto.getVal();
				break;
			}
		}
		for (CodeDto codeDto : countryCodeList) {
			if (codeDto.getCdId().equals(projectPropDto.getCtryCd())) {
				country = codeDto.getVal();
				break;
			}
		}

		proposalVo.setName(projectPropDto.getNme());
		proposalVo.setDesc(projectPropDto.getDesc());
		proposalVo.setEstDuration(projectPropDto.getEstDur());
		proposalVo.setLoc(projectPropDto.getLoc());
		proposalVo.setRmk(projectPropDto.getRmk());
		proposalVo.setProposerId(projectPropDto.getProposerId());
		proposalVo.setStatus(projectStatus);
		proposalVo.setCtryCd(country);

		projectManagementService.saveOrUpdateProjectObject(projectPropDto);
		modelAndView.addObject("propMsg", propMsg);
		modelAndView.addObject("proposalVo", proposalVo);

		if (logger.isDebugEnabled()) {
			logger.debug("reviewProposal(HttpServletRequest, HttpServletResponse, ProjectProposalVo) - end");
		}
		return modelAndView;

	}

	public ModelAndView listProjects(HttpServletRequest request,
			HttpServletResponse response, ProjectVo command) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("listProjects(HttpServletRequest, HttpServletResponse, ProjectVo) - start");
		}

		modelAndView = new ModelAndView("project/listProjects");
		modelAndView.addObject("projectStatusList", CodeLookupUtil
				.getListOfCodeByCategory(VMSConstants.PROJECT_STATUS));
		List projectList = null;
		if (command != null
				&& (command.getName() != null || command.getStrDte() != null || command
						.getStsCd() != null)) {
			projectList = projectManagementService
					.getProjectListbyProjectVo(command);
		} else {
			projectList = projectManagementService.getListAllProject();
		}

		PagedListHolder memberPagedListHolder = new PagedListHolder(projectList);
		if (!projectList.isEmpty()) {
			int page = ServletRequestUtils.getIntParameter(request, "p", 0);
			memberPagedListHolder.setPage(page);
			memberPagedListHolder.setPageSize(VMSConstants.MAX_PAGE_SIZE);
		}

		modelAndView.addObject("command", command);
		modelAndView.addObject("pagedListHolder", memberPagedListHolder);

		if (logger.isDebugEnabled()) {
			logger.debug("listProjects(HttpServletRequest, HttpServletResponse, ProjectVo) - end");
		}
		return modelAndView;
	}

	public ModelAndView manageProjectMember(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("manageProjectMember(HttpServletRequest, HttpServletResponse) - start");
		}

		ProjectVo projectVo = new ProjectVo();
		if (!StringUtil.isNullOrEmpty(request.getParameter("prjId"))) {
			Long prjId = Long.parseLong(request.getParameter("prjId"));
			modelAndView = new ModelAndView("project/manageProjectMember");
			logger.debug("project/manageProjectMember");
			try {
				if (request.getParameter("removeMember") != null) {// REMOVE
					// COMMAND
					if (request.getParameter("prjMbrId") != null) {
						String[] prjMbrIdList = request
								.getParameterValues("prjMbrId");
						for (int i = 0; i < prjMbrIdList.length; i++) {
							logger.debug("Removing Project Member "
									+ prjMbrIdList[i]);
							String[] val = prjMbrIdList[i].split("[,]");
							projectManagementService
									.deleteProjectMemberByProjectMemberId(val[0]);
							modelAndView
									.addObject(
											"msg",
											Messages.getString("message.projectManagement.removeMemberRole"));
						}
					} else {
						modelAndView
								.addObject(
										"errors",
										Messages.getString("message.projectManagement.error.noSelectdMember"));
					}
				} else if (request.getParameter("updateMember") != null) {// UPDATE
					// COMMAND
					if (request.getParameter("prjMbrId") != null) {
						String[] prjMbrIdList = request
								.getParameterValues("prjMbrId");
						for (int i = 0; i < prjMbrIdList.length; i++) {
							logger.debug("Update Project Member Role"
									+ prjMbrIdList[i]);
							String[] val = prjMbrIdList[i].split("[,]");
							String roleValue = request.getParameter("roleCd_"
									+ val[0]);
							if (!StringUtil.isNullOrEmpty(roleValue)) {
								Long roleCd = Long.parseLong(roleValue);
								projectManagementService
										.updateProjectMemberRoleByProjectMemberIdnRole(
												val[0], roleCd);
								modelAndView
										.addObject(
												"msg",
												Messages.getString("message.projectManagement.updateMemberRole"));
							} else {
								modelAndView
										.addObject(
												"errors",
												Messages.getString("message.common.error.update"));
							}
						}
					} else {
						modelAndView
								.addObject(
										"errors",
										Messages.getString("message.projectManagement.error.noSelectdMember"));
					}
				} else if (request.getParameter("inviteProjectMember") != null) {// invite
					// COMMAND
					try {
						Long userStatus = CodeLookupUtil.getCodeDtoByCatVal(
								VMSConstants.USER_TYPE_CATEGORY,
								VMSConstants.USER_TYPE_CATEGORY_VOLUNTEER)
								.getCdId();
						projectManagementService
								.sendInviteProjectMemberToAllUser(prjId,
										userStatus);
						modelAndView
								.addObject(
										"msg",
										Messages.getString("message.projectManagement.inviteVolunteer"));
					} catch (ApplicationException ae) {
						modelAndView.addObject("errors", ae.getMessage());
					} catch (Exception ex) {
						modelAndView.addObject("errors", Messages
								.getString("message.common.error.system"));
					}

				} else if (request.getParameter("requestProjectCertificate") != null) {// request
																						// certificate
					// COMMAND
					try {
						projectManagementService
								.requestProjectCertificateByProjectId(prjId);
						modelAndView
								.addObject(
										"msg",
										Messages.getString("message.projectManagement.error.certificate.requested"));
					} catch (ApplicationException ex) {
						modelAndView.addObject("errors", ex.getMessage());
					} catch (Exception ex) {
						modelAndView.addObject("errors", Messages
								.getString("message.common.error.system"));
					}
				}
			} catch (ApplicationException ex) {
				modelAndView.addObject("errors", ex.toString());
			}
			projectVo = projectManagementService
					.getProjectVoByLoginUserAccessRight(prjId);

			// get list of project
			PagedListHolder memberPagedListHolder = new PagedListHolder(
					projectVo.getProjectMemberVo());
			if (!projectVo.getProjectMemberVo().isEmpty()) {
				int page = ServletRequestUtils.getIntParameter(request,
						"p_member", 0);
				memberPagedListHolder.setPage(page);
				memberPagedListHolder.setPageSize(VMSConstants.MAX_PAGE_SIZE);
			}
			modelAndView.addObject("projectMemberList",
					projectVo.getProjectMemberVo());
			modelAndView.addObject("projectVo", projectVo);
			modelAndView.addObject("memberPagedListHolder",
					memberPagedListHolder);
			modelAndView.addObject("roleList", CodeLookupUtil
					.getListOfCodeByCategory(VMSConstants.MEMBER_ROLE));

			modelAndView.addObject("prjId", prjId);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("manageProjectMember(HttpServletRequest, HttpServletResponse) - end");
		}
		return modelAndView;
	}

	public ModelAndView manageProjectInterest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("manageProjectInterest(HttpServletRequest, HttpServletResponse) - start");
		}
		modelAndView = new ModelAndView("project/manageProjectInterest");
		ProjectVo projectVo = new ProjectVo();

		String newStatus = "";

		if (request.getParameter("acceptInterest") != null) {
			newStatus = VMSConstants.PROJECT_INTEREST_APPROVED;
		} else if (request.getParameter("rejectInterest") != null) {
			newStatus = VMSConstants.PROJECT_INTEREST_REJECTED;
		}

		if (!StringUtil.isNullOrEmpty(request.getParameter("prjId"))) {
			Long prjId = Long.parseLong(request.getParameter("prjId"));
			try {
				if (!StringUtil.isNullOrEmpty(newStatus)) {// REMOVE
					// COMMAND
					if (request.getParameter("prjIntrstId") != null) {
						String[] prjIntrstId = request
								.getParameterValues("prjIntrstId");

						CodeDto codeDto = CodeLookupUtil.getCodeDtoByCatVal(
								VMSConstants.PROJECT_INTREST_STATUS, newStatus);

						for (int i = 0; i < prjIntrstId.length; i++) {
							logger.debug("Accept/reject Project Member "
									+ prjIntrstId[i]);
							Long _prjIntrstId = Long.parseLong(prjIntrstId[i]);

							ProjectInterestVo projectInterestVo = projectManagementService
									.getProjectInterestbyId(_prjIntrstId);

							projectInterestVo.setStsCd(codeDto.getCdId());
							projectManagementService
									.updateProjectIntrest(projectInterestVo);
						}
						modelAndView.addObject("msg",
								Messages.getString("message.common.update"));
					} else {
						modelAndView
								.addObject(
										"errors",
										Messages.getString("message.projectManagement.error.noSelectdMember"));
					}
				}
			} catch (ApplicationException ex) {
				modelAndView.addObject("errors", ex.toString());

			}
			projectVo = projectManagementService
					.getProjectVoByLoginUserAccessRight(prjId);

			// get list of project intrest
			List<ProjectInterestVo> projectInterestVoList = projectManagementService
					.getProjectIntrestByLoginUserAccessRight(prjId);
			PagedListHolder projectInterestPagedListHolder = new PagedListHolder(
					projectInterestVoList);
			if (projectInterestVoList != null
					&& !projectInterestVoList.isEmpty()) {
				int page = ServletRequestUtils.getIntParameter(request,
						"p_projectInterest", 0);
				projectInterestPagedListHolder.setPage(page);
				projectInterestPagedListHolder
						.setPageSize(VMSConstants.MAX_PAGE_SIZE);
			}

			modelAndView.addObject("projectVo", projectVo);
			modelAndView.addObject("projectInterestPagedListHolder",
					projectInterestPagedListHolder);
			modelAndView
					.addObject(
							"roleList",
							CodeLookupUtil
									.getListOfCodeByCategory(VMSConstants.PROJECT_ROLE_CATEGORY));

			modelAndView.addObject("prjId", prjId);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("manageProjectInterest(HttpServletRequest, HttpServletResponse) - end");
		}
		return modelAndView;
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

	public ModelAndView viewProjectInterest(HttpServletRequest request,
			HttpServletResponse response, ProjectInterestSearchVo command)
			throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("viewProjectInterest(HttpServletRequest, HttpServletResponse, ProjectInterestSearchVo) - start");
		}

		modelAndView = new ModelAndView("project/viewProjectInterest");
		modelAndView.addObject("projInterestStatusList", CodeLookupUtil
				.getListOfCodeByCategory(VMSConstants.PROJECT_INTREST_STATUS));
		List projectInterestVoList = null;
		if (command != null
				&& (command.getPrjId() != null || command.getProjNme() != null || command
						.getPrjIntStatus() != null)) {
			projectInterestVoList = projectManagementService
					.getProjectInterestListByUserWithSearch(command);
		} else {
			projectInterestVoList = projectManagementService
					.getProjectInterestListByUserLoginId();
		}

		PagedListHolder projInterestPagedListHolder = new PagedListHolder(
				projectInterestVoList);
		if (!projectInterestVoList.isEmpty()) {
			int page = ServletRequestUtils.getIntParameter(request, "p", 0);
			projInterestPagedListHolder.setPage(page);
			projInterestPagedListHolder.setPageSize(VMSConstants.MAX_PAGE_SIZE);
		}

		modelAndView.addObject("command", command);
		modelAndView.addObject("pagedListHolder", projInterestPagedListHolder);

		if (logger.isDebugEnabled()) {
			logger.debug("viewProjectInterest(HttpServletRequest, HttpServletResponse, ProjectInterestSearchVo) - end");
		}
		return modelAndView;
	}
}
