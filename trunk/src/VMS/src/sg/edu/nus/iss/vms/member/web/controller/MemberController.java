package sg.edu.nus.iss.vms.member.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import sg.edu.nus.iss.vms.common.web.controller.BaseFormController;
import sg.edu.nus.iss.vms.common.web.controller.BaseMultiActionFormController;
import sg.edu.nus.iss.vms.member.service.MemberManagementService;
import sg.edu.nus.iss.vms.staffmgmt.service.StaffManagementServices;
import sg.edu.nus.iss.vms.staffmgmt.web.controller.SearchStaffController;

public class MemberController extends MultiActionController {
	private Logger logger = Logger.getLogger(SearchStaffController.class);
	private MemberManagementService memberManagementService;
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

	public void setMemberManagementService(MemberManagementService memberManagementService) {
		this.memberManagementService = memberManagementService;
	}

	@Override
	public long getLastModified(HttpServletRequest arg0) {
		logger.debug("###################################################################################");
		return super.getLastModified(arg0);
	}

	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView modelAndView = new ModelAndView("member/searchMember");
		logger.debug("member/searchMember");
			
		List staffList = memberManagementService.getListOfMembers();
		PagedListHolder pagedListHolder = new PagedListHolder(staffList);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		int pageSize = 10;
		pagedListHolder.setPageSize(pageSize);

		modelAndView.addObject("pagedListHolder", pagedListHolder);
		logger.debug("Completed the request");
		// return super.handleRequestInternal(request, response);
		return modelAndView;

	}
}
