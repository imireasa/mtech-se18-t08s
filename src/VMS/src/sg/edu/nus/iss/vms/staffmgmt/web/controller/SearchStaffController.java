package sg.edu.nus.iss.vms.staffmgmt.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import sg.edu.nus.iss.vms.common.web.controller.BaseFormController;
import sg.edu.nus.iss.vms.staffmgmt.dto.Staff;
import sg.edu.nus.iss.vms.staffmgmt.service.StaffManagementServices;

public class SearchStaffController extends BaseFormController {
	private Logger logger = Logger.getLogger(SearchStaffController.class);
	private StaffManagementServices staffManagementServices;
	protected ApplicationContext springAppContext = null;

	public StaffManagementServices getStaffManagementServices() {
		return this.staffManagementServices;
	}

	public void setStaffManagementServices(StaffManagementServices staffManagementServicesImpl) {
		this.staffManagementServices = staffManagementServicesImpl;
	}

	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		this.modelAndView = new ModelAndView(getFormView());
		this.logger.debug(getFormView());
		
		List staffList = staffManagementServices.getListOfUser();
		
		PagedListHolder pagedListHolder = new PagedListHolder(staffList);
		
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		int pageSize = 10;
		pagedListHolder.setPageSize(pageSize);
		
		this.modelAndView.addObject("pagedListHolder", pagedListHolder);
		this.logger.debug("Completed the request");
		return super.handleRequestInternal(request, response);

	}
}
