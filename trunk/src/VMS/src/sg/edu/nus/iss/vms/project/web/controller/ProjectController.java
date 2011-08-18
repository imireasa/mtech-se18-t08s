package sg.edu.nus.iss.vms.project.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.transaction.jta.SpringJtaSynchronizationAdapter;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import sg.edu.nus.iss.vms.common.web.controller.BaseMultiActionFormController;
import sg.edu.nus.iss.vms.member.service.MemberManagementService;
import sg.edu.nus.iss.vms.project.service.ProjectManagementService;

public class ProjectController extends BaseMultiActionFormController {
	private Logger logger = Logger.getLogger(ProjectController.class);
	private MemberManagementService memberManagementService;
	private ProjectManagementService projectManagementService;

	public MemberManagementService getMemberManagementService() {
		return memberManagementService;
	}

	public void setMemberManagementService(MemberManagementService memberManagementService) {
		this.memberManagementService = memberManagementService;
	}

	public ProjectManagementService getProjectManagementService() {
		return projectManagementService;
	}

	public void setProjectManagementService(ProjectManagementService projectManagementService) {
		this.projectManagementService = projectManagementService;
	}

	@Override
	public long getLastModified(HttpServletRequest arg0) {
		logger.debug("###################################################################################");
		return super.getLastModified(arg0);
	}

	public ModelAndView assignPrjMemberRole(HttpServletRequest request, HttpServletResponse response) throws Exception {

		modelAndView = new ModelAndView("project/assignMemberRole");
		List memberList = new ArrayList();

		logger.debug("REQUEST Project " + request.getParameter("project"));
		logger.debug("REQUEST Member  " + request.getParameter("member"));

		List projectList = projectManagementService.getListAllProject();
		modelAndView.addObject("projectList", projectList);
		
		List projectRoleList = projectManagementService.getProjectRoleList();
		modelAndView.addObject("projectRoleList", projectRoleList);

		if (request.getParameter("project") != null && !request.getParameter("project").isEmpty()) {
			long projectId = Long.parseLong(request.getParameter("project"));
			memberList = projectManagementService.getProjectMember(projectId, request.getParameter("member"));
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

}
