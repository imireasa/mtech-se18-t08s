package sg.edu.nus.iss.vms.member.web.controller;

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

public class MemberController extends MultiActionController {
	private Logger logger = Logger.getLogger(MemberController.class);
	private MemberManagementService memberManagementService;
	private ProjectManagementService projectManagementService;
	private String formView;

	public String getFormView() {
		return formView;
	}

	public void setFormView(String formView) {
		this.formView = formView;
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

	public ModelAndView searchProjectMember(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ModelAndView modelAndView = new ModelAndView("member/searchMember");
		logger.debug("member/searchMember");
		List memberList = new ArrayList();

		logger.debug("REQUEST Project Name "
				+ request.getParameter("projectName"));
		logger.debug("REQUEST Project Id   "
				+ request.getParameter("projectId"));

		if (request.getParameter("projectId") != null
				&& !request.getParameter("projectId").isEmpty()) {
			long projectId = Long.parseLong(request.getParameter("projectId"));
			List projectList = new ArrayList();
			projectList.add(projectManagementService.getProject(projectId));
			modelAndView.addObject("projectList", projectList);
			modelAndView.addObject("projectName",
					request.getParameter("projectName"));
			memberList = memberManagementService.getListOfMembers(projectId);

		} else if (request.getParameter("projectName") != null) {
			String projectName = request.getParameter("projectName");
			List projectList = projectManagementService
					.getListOfProject(projectName);
			modelAndView.addObject("projectList", projectList);
			modelAndView.addObject("projectName",
					request.getParameter("projectName"));
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
