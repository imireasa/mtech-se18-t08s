package sg.edu.nus.iss.vms.project.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;

import sg.edu.nus.iss.vms.common.constants.VMSConstants;
import sg.edu.nus.iss.vms.common.dto.CodeDto;
import sg.edu.nus.iss.vms.common.util.CodeLookupUtil;
import sg.edu.nus.iss.vms.common.web.controller.BaseMultiActionFormController;
import sg.edu.nus.iss.vms.member.service.MemberManagementService;
import sg.edu.nus.iss.vms.project.dto.ProjectFeedbackDto;
import sg.edu.nus.iss.vms.project.service.ProjectManagementService;
import sg.edu.nus.iss.vms.project.vo.ProjectInfoVo;

public class ProjectController extends BaseMultiActionFormController {
	private final Logger logger = Logger.getLogger(ProjectController.class);
	private MemberManagementService memberManagementService;
	private ProjectManagementService projectManagementService;

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

	public ModelAndView browseProjectFeedback(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.debug("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXbrowseProject");

		List<ProjectFeedbackDto> projectFeedbackList = projectManagementService
				.getAllProjectFeedbackList();

		List<CodeDto> codeDtos = CodeLookupUtil
				.getListOfCodeByCategory(VMSConstants.FEEDBACK_STATUS);

		modelAndView = new ModelAndView("project/browseProjectFeedback");
		modelAndView.addObject("feedbackList", projectFeedbackList);
		modelAndView.addObject("feedbackVo", new ProjectInfoVo());
		modelAndView.addObject("fbCodeList", codeDtos);

		return modelAndView;

	}

	public ModelAndView searchProjectFeedback(HttpServletRequest request,
			HttpServletResponse response, ProjectInfoVo projectInfoVo)
			throws Exception {

		List<ProjectFeedbackDto> projectFeedbackList = projectManagementService
				.getProjectFeedbackListbyVo(projectInfoVo);

		modelAndView.addObject("feedbackList", projectFeedbackList);

		return modelAndView;

	}

	public ModelAndView viewProjectFeedbackDetails(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		long prjFbId = Long.parseLong(request.getParameter("prjFbId"));

		ProjectFeedbackDto projectFbDto = projectManagementService
				.getProjectFeedbackbyId(prjFbId);

		modelAndView = new ModelAndView("project/viewProjectFeedbackDetails");
		modelAndView.addObject("projectFb", projectFbDto);
		return modelAndView;
	}

	public ModelAndView approveFb(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ProjectFeedbackDto projectFbDto = (ProjectFeedbackDto) modelAndView
				.getModel().get("projectFb");

		CodeDto codeDto = CodeLookupUtil.getCodeByCategoryAndCodeValue(
				VMSConstants.FEEDBACK_STATUS,
				VMSConstants.FEEDBACK_STATUS_APPROVED);

		projectFbDto.setApprBy("pendingToUpdate");
		projectFbDto.setApprDte(new Date());
		projectFbDto.setUpdBy("pendingToUpdate");
		projectFbDto.setUpdDte(new Date());
		projectFbDto.setStsCd(codeDto.getCdId());
		projectManagementService.saveProjectObject(projectFbDto);

		return modelAndView;
	}

	public ModelAndView rejectFb(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ProjectFeedbackDto projectFbDto = (ProjectFeedbackDto) modelAndView
				.getModel().get("projectFb");
		CodeDto codeDto = CodeLookupUtil.getCodeByCategoryAndCodeValue(
				VMSConstants.FEEDBACK_STATUS,
				VMSConstants.FEEDBACK_STATUS_REJECTED);

		projectFbDto.setApprBy("pendingToUpdate");
		projectFbDto.setApprDte(new Date());
		projectFbDto.setUpdBy("pendingToUpdate");
		projectFbDto.setUpdDte(new Date());
		projectFbDto.setStsCd(codeDto.getCdId());
		projectManagementService.saveProjectObject(projectFbDto);

		return modelAndView;
	}

}
