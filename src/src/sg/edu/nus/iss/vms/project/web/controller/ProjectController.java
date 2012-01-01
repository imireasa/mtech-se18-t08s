package sg.edu.nus.iss.vms.project.web.controller;

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
import sg.edu.nus.iss.vms.common.dto.CodeDto;
import sg.edu.nus.iss.vms.common.exception.ApplicationException;
import sg.edu.nus.iss.vms.common.service.CodeManagementServices;
import sg.edu.nus.iss.vms.common.util.CodeLookupUtil;
import sg.edu.nus.iss.vms.common.web.controller.BaseMultiActionFormController;
import sg.edu.nus.iss.vms.member.service.MemberManagementService;
import sg.edu.nus.iss.vms.project.dto.ProjectFeedbackDto;
import sg.edu.nus.iss.vms.project.dto.ProjectProposalDto;
import sg.edu.nus.iss.vms.project.service.ProjectManagementService;
import sg.edu.nus.iss.vms.project.vo.ProjectInfoVo;
import sg.edu.nus.iss.vms.project.vo.ProjectVo;

public class ProjectController extends BaseMultiActionFormController {

        private final Logger logger = Logger.getLogger(ProjectController.class);
        private CodeManagementServices codeManagementServices;
        private MemberManagementService memberManagementService;
        private ProjectManagementService projectManagementService;
        private BindingResult errors;

        public void setCodeManagementServices(
                CodeManagementServices codeManagementServices) {
                this.codeManagementServices = codeManagementServices;
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

        @Override
        public long getLastModified(HttpServletRequest arg0) {
                logger.debug("###################################################################################");
                return super.getLastModified(arg0);
        }

        public ModelAndView assignPrjMemberRole(HttpServletRequest request,
                HttpServletResponse response) throws Exception {

                modelAndView = new ModelAndView("project/assignMemberRole");
                List memberList = new ArrayList();

                logger.debug("REQUEST Project " + request.getParameter("project"));
                logger.debug("REQUEST Member  " + request.getParameter("member"));

                List projectList = projectManagementService.getListAllProject();
                modelAndView.addObject("projectList", projectList);

                List projectRoleList = projectManagementService.getProjectRoleList();
                modelAndView.addObject("projectRoleList", projectRoleList);

                if (request.getParameter("project") != null
                        && !request.getParameter("project").isEmpty()) {
                        long projectId = Long.parseLong(request.getParameter("project"));
                        memberList = projectManagementService.getProjectMember(projectId,
                                request.getParameter("member"));
                }

                PagedListHolder memberPagedListHolder = new PagedListHolder(memberList);
                if (!memberList.isEmpty()) {
                        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
                        memberPagedListHolder.setPage(page);
                        int pageSize = 10;
                        memberPagedListHolder.setPageSize(pageSize);
                }
                logger.debug("Completed the request");
                modelAndView.addObject("pagedListHolder", memberPagedListHolder);
                return modelAndView;

        }

        @Override
        protected void bind(HttpServletRequest request, Object command)
                throws Exception {
                // TODO Auto-generated method stub

                ServletRequestDataBinder binder = createBinder(request, command);
                binder.bind(request);
                errors = binder.getBindingResult();
        }

        public void validate(Object command) {
                Validator[] validators = getValidators();
                if (validators != null) {
                        for (int index = 0; index < validators.length; index++) {
                                Validator validator = validators[index];
                                if (validator instanceof ProjectValidator) {
                                        if (((ProjectValidator) validator).supports(command.getClass())) {
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

        public ModelAndView createProject(HttpServletRequest request,
                HttpServletResponse response, ProjectVo command) throws Exception {

                if (command.getName() == null) {
                        modelAndView = new ModelAndView("project/createProject");
                        // page
                        modelAndView.addObject("countryList", codeManagementServices.getListOfCodeByCategory(VMSConstants.COUNTRY_CATEGORY));
                        ProjectVo projectVo = new ProjectVo();
                        projectVo.setCmdType(VMSConstants.SCREEN_CMD_CREATE);
                        modelAndView.addObject("command", projectVo);
                        return modelAndView;
                } else {
                        validate(command);
                        modelAndView = new ModelAndView("project/createProject");
                        modelAndView.addObject("countryList", codeManagementServices.getListOfCodeByCategory(VMSConstants.COUNTRY_CATEGORY));
                        ProjectVo projectVo = command;
                        System.out.println("after assigning the command to projectvo....");
                        if (errors.hasErrors()) {
                                logger.debug("Error Handling : ");
                                saveError(request, errors.getFieldError().getDefaultMessage());
                                modelAndView.addObject("command", projectVo);
                                return modelAndView;
                        }

                        try {
                                CodeDto stsNew = codeManagementServices.getCodeDtoByCatVal(
                                        VMSConstants.PROJECT_STATUS_CATEGORY,
                                        VMSConstants.PROJECT_STATUS_CATEGORY_NEW);
                                projectVo.setStsCd(stsNew.getCdId() + "");

                                projectManagementService.saveProject(projectVo);
                        } catch (ApplicationException ae) {
                                List list = new ArrayList();
                                list.add(ae.getMessage());
                                modelAndView.addObject("errors", list);
                                modelAndView.addObject("command", projectVo);
                                return modelAndView;
                        }

                        modelAndView.addObject("command", projectVo);
                        modelAndView.addObject("msg",
                                Messages.getString("message.common.save"));
                        return modelAndView;
                }
        }

        public ModelAndView updateProject(HttpServletRequest request,
                HttpServletResponse response, ProjectVo command) throws Exception {
                if (logger.isInfoEnabled()) {
                        logger.info("updateProject(HttpServletRequest, HttpServletResponse, ProjectVo) - updateProject");
                }

                if (command.getName() == null) {
                        // TODO: have to connect to Project List Page , now hard code the
                        // project id....
                        Long projectId = 1L;
                        ProjectVo project = projectManagementService.getProjectVoById(projectId);
                        modelAndView = new ModelAndView("project/updateProject");
                        // page
                        modelAndView.addObject("countryList", CodeLookupUtil.getListOfCodeByCategory(VMSConstants.COUNTRY_CATEGORY));
                        modelAndView.addObject(
                                "statusList",
                                CodeLookupUtil.getListOfCodeByCategory(VMSConstants.PROJECT_STATUS_CATEGORY));
                        project.setCmdType(VMSConstants.SCREEN_CMD_UPDATE);
                        modelAndView.addObject("command", project);
                        return modelAndView;
                } else {
                        validate(command);
                        modelAndView = new ModelAndView("project/updateProject");
                        modelAndView.addObject("countryList", codeManagementServices.getListOfCodeByCategory(VMSConstants.COUNTRY_CATEGORY));
                        modelAndView.addObject(
                                "statusList",
                                CodeLookupUtil.getListOfCodeByCategory(VMSConstants.PROJECT_STATUS_CATEGORY));
                        ProjectVo projectVo = command;
                        if (errors.hasErrors()) {
                                logger.debug("Error Handling : ");
                                saveError(request, errors.getFieldError().getDefaultMessage());
                                modelAndView.addObject("command", projectVo);
                                return modelAndView;
                        }

                        try {
                                projectManagementService.updateProject(projectVo);
                        } catch (ApplicationException ae) {
                                List list = new ArrayList();
                                list.add(ae.getMessage());
                                modelAndView.addObject("errors", list);
                                modelAndView.addObject("command", projectVo);
                                return modelAndView;
                        }

                        modelAndView.addObject("command", projectVo);
                        modelAndView.addObject("msg",
                                Messages.getString("message.common.update"));
                        return modelAndView;
                }
        }

        public ModelAndView viewProject(HttpServletRequest request,
                HttpServletResponse response, ProjectVo command) throws Exception {

                // TODO: have to connect to Project List Page , now hard code the
                // project id....
                Long projectId = 1L;
                ProjectVo projectVo = projectManagementService.getProjectVoById(projectId);
                modelAndView = new ModelAndView("project/viewProject");
                // page

                projectVo.setCtryCd(CodeLookupUtil.getCodeDescriptionByCodeId(Long.parseLong(projectVo.getCtryCd())));
                projectVo.setStsCd(CodeLookupUtil.getCodeDescriptionByCodeId(Long.parseLong(projectVo.getStsCd())));
                modelAndView.addObject("command", projectVo);
                return modelAndView;
        }

        public ModelAndView browseProjectFeedback(HttpServletRequest request,
                HttpServletResponse response) throws Exception {

                List<ProjectFeedbackDto> projectFeedbackList = projectManagementService.getAllProjectObjectList(ProjectFeedbackDto.class);

                List<CodeDto> codeDtos = CodeLookupUtil.getListOfCodeByCategory(VMSConstants.FEEDBACK_STATUS);

                modelAndView = new ModelAndView("project/browseProjectFeedback");
                modelAndView.addObject("feedbackList", projectFeedbackList);
                modelAndView.addObject("feedbackVo", new ProjectInfoVo());
                modelAndView.addObject("fbCodeList", codeDtos);

                return modelAndView;

        }

        public ModelAndView searchProjectFeedback(HttpServletRequest request,
                HttpServletResponse response, ProjectInfoVo projectInfoVo)
                throws Exception {

                List<ProjectFeedbackDto> projectFeedbackList = projectManagementService.getProjectFeedbackListbyVo(projectInfoVo);

                modelAndView.addObject("feedbackList", projectFeedbackList);

                return modelAndView;

        }

        public ModelAndView viewProjectFeedbackDetails(HttpServletRequest request,
                HttpServletResponse response) throws Exception {

                long prjFbId = Long.parseLong(request.getParameter("prjFbId"));

                ProjectFeedbackDto projectFbDto = (ProjectFeedbackDto) projectManagementService.getProjectObjbyId(prjFbId, ProjectFeedbackDto.class);

                modelAndView = new ModelAndView("project/viewProjectFeedbackDetails");
                modelAndView.addObject("projectFb", projectFbDto);
                return modelAndView;
        }

        public ModelAndView approveFb(HttpServletRequest request,
                HttpServletResponse response) throws Exception {

                ProjectFeedbackDto projectFbDto = (ProjectFeedbackDto) modelAndView.getModel().get("projectFb");

                CodeDto codeDto = CodeLookupUtil.getCodeByCategoryAndCodeValue(
                        VMSConstants.FEEDBACK_STATUS,
                        VMSConstants.FEEDBACK_STATUS_APPROVED);

                projectFbDto.setApprBy("pendingToUpdate");
                projectFbDto.setApprDte(new Date());
                projectFbDto.setUpdBy("pendingToUpdate");
                projectFbDto.setUpdDte(new Date());
                projectFbDto.setStsCd(codeDto.getCdId());
                projectManagementService.saveOrUpdateProjectObject(projectFbDto);

                return modelAndView;
        }

        public ModelAndView rejectFb(HttpServletRequest request,
                HttpServletResponse response) throws Exception {

                ProjectFeedbackDto projectFbDto = (ProjectFeedbackDto) modelAndView.getModel().get("projectFb");
                CodeDto codeDto = CodeLookupUtil.getCodeByCategoryAndCodeValue(
                        VMSConstants.FEEDBACK_STATUS,
                        VMSConstants.FEEDBACK_STATUS_REJECTED);

                projectFbDto.setApprBy("pendingToUpdate");
                projectFbDto.setApprDte(new Date());
                projectFbDto.setUpdBy("pendingToUpdate");
                projectFbDto.setUpdDte(new Date());
                projectFbDto.setStsCd(codeDto.getCdId());
                projectManagementService.saveOrUpdateProjectObject(projectFbDto);

                return modelAndView;
        }

        public ModelAndView proposeNewProject(HttpServletRequest request,
                HttpServletResponse response) throws Exception {

                ModelAndView modelAndView = new ModelAndView(
                        "project/proposeNewProject");
                modelAndView.addObject("projectVo", new ProjectVo());

                modelAndView.addObject("countryList", CodeLookupUtil.getListOfCodeByCategory(VMSConstants.COUNTRY_CATEGORY));

                return modelAndView;
        }

        public ModelAndView submitProjectProposal(HttpServletRequest request,
                HttpServletResponse response, ProjectVo projectVo) throws Exception {

                validateProjectProposal(projectVo);
                if (errors.hasErrors()) {
                        logger.debug("Error Handling : ");
                        saveError(request, errors.getFieldError().getDefaultMessage());

                        return modelAndView;
                }

                CodeDto codeDto = CodeLookupUtil.getCodeByCategoryAndCodeValue(
                        VMSConstants.PROPOSAL_STATUS,
                        VMSConstants.PROPOSAL_STATUS_SUMBITTED);

                ProjectProposalDto projectProposalDto = new ProjectProposalDto();
                projectProposalDto.setCtryCd(Long.parseLong(projectVo.getCtryCd()));
                projectProposalDto.setEstDur(Integer.valueOf(projectVo.getEstDuration()));
                projectProposalDto.setLoc(projectVo.getLoc());
                projectProposalDto.setNme(projectVo.getName());
                projectProposalDto.setDesc(projectVo.getDesc());
                projectProposalDto.setCreatedDte(new Date());
                projectProposalDto.setUpdDte(new Date());
                projectProposalDto.setStsCd(codeDto.getCdId());
                projectProposalDto.setProposerId("PendingToUpdate");
                projectProposalDto.setCreatedBy("PendingToUpdate");
                projectProposalDto.setUpdBy("PendingToUpdate");
                projectProposalDto.setVersion(1);

                logger.debug("ctycd:" + projectProposalDto.getCtryCd());
                logger.debug("Name:" + projectProposalDto.getNme());
                logger.debug("location:" + projectProposalDto.getLoc());
                logger.debug("status:" + projectProposalDto.getStsCd());

                projectManagementService.saveOrUpdateProjectObject(projectProposalDto);

                return modelAndView;
        }

        public ModelAndView browseProjectProposal(HttpServletRequest request,
                HttpServletResponse response) {

                List<ProjectProposalDto> projectProposalDtos = projectManagementService.getAllProjectObjectList(ProjectProposalDto.class);

                List<CodeDto> codeDtos = CodeLookupUtil.getListOfCodeByCategory(VMSConstants.PROPOSAL_STATUS);

                modelAndView = new ModelAndView("project/browseProjectProposal");
                modelAndView.addObject("proposalList", projectProposalDtos);
                modelAndView.addObject("proposalVo", new ProjectVo());
                modelAndView.addObject("stsCdList", codeDtos);

                return modelAndView;

        }

        public ModelAndView searchProjectProposal(HttpServletRequest request,
                HttpServletResponse response, ProjectVo projectVo) throws Exception {

<<<<<<< .mine
		List<CodeDto> codeDtos = CodeLookupUtil
				.getListOfCodeByCategory(VMSConstants.PROPOSAL_STATUS);
		modelAndView = new ModelAndView("project/browseProjectProposal");
		modelAndView.addObject("proposalList", projectProposalDtos);
=======
                List<ProjectProposalDto> projectProposalDtos = projectManagementService.getProjectProposalListbyVo(projectVo);
>>>>>>> .r1179
		modelAndView.addObject("proposalVo", new ProjectVo());
		modelAndView.addObject("stsCdList", codeDtos);

                modelAndView.addObject("proposalList", projectProposalDtos);

                return modelAndView;

        }

	public ModelAndView viewProjectProposalDetails(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<CodeDto> codeDtos = CodeLookupUtil
				.getListOfCodeByCategory(VMSConstants.PROPOSAL_STATUS);

		long prjProId = Long.parseLong(request.getParameter("prjPropId"));

		ProjectProposalDto projectPropDto = (ProjectProposalDto) projectManagementService
				.getProjectObjbyId(prjProId, ProjectProposalDto.class);

		modelAndView = new ModelAndView("project/viewProjectProposalDetails");
		modelAndView.addObject("proposal", projectPropDto);
		modelAndView.addObject("stsCdList", codeDtos);
		logger.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@total status"
				+ codeDtos.size());

		modelAndView.addObject("proposalVo", new ProjectVo());
		return modelAndView;

	}

	public ModelAndView reviewProposal(HttpServletRequest request,
			HttpServletResponse response, ProjectVo proposalVo)
			throws Exception {

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
		if (projectPropDto.getStsCd() == approveCodeId
				|| projectPropDto.getStsCd() == rejectCodeId) {
			projectPropDto.setApprBy("toBeUpdated");
			projectPropDto.setApprDte(new Date());
			projectPropDto.setUpdBy("toBeUpdated");
			projectPropDto.setUpdBy("toBeUpdated");
		}
		projectPropDto.setRmk(proposalVo.getRmk());
		projectManagementService.saveOrUpdateProjectObject(projectPropDto);

		return modelAndView;

	}

        public void validateProjectProposal(Object command) {
                Validator[] validators = getValidators();
                if (validators != null) {
                        for (int index = 0; index < validators.length; index++) {
                                Validator validator = validators[index];
                                if (validator instanceof ProjectProposalValidator) {
                                        if (((ProjectProposalValidator) validator).supports(command.getClass())) {
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

        public ModelAndView listProjects(HttpServletRequest request, HttpServletResponse response,
                ProjectVo command) throws Exception {
                modelAndView = new ModelAndView("project/listProjects");
                modelAndView.addObject("projectStatusList", projectManagementService.getProjectStatusList());
                List projectList = null;
                if (command != null
                        && (command.getName() != null || command.getStrDte() != null || command.getStsCd() != null)) {
                        projectList = projectManagementService.listProjectbyProjectVo(command);
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
                return modelAndView;
        }

        public BindingResult getErrors() {
                return errors;
        }

        public void setErrors(BindingResult errors) {
                this.errors = errors;
        }
}
