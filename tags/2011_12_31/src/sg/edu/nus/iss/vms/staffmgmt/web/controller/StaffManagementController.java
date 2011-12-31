package sg.edu.nus.iss.vms.staffmgmt.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import sg.edu.nus.iss.vms.common.web.controller.BaseFormController;
import sg.edu.nus.iss.vms.staffmgmt.service.StaffManagementServices;

public class StaffManagementController extends BaseFormController {
	private Logger logger = Logger.getLogger(StaffManagementController.class);
	private StaffManagementServices staffManagementServicesImpl;

	public StaffManagementServices getStaffManagementServices() {
		return this.staffManagementServicesImpl;
	}

	public void setStaffManagementServices(StaffManagementServices staffManagementServicesImpl) {
		this.staffManagementServicesImpl = staffManagementServicesImpl;
	}

	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		this.modelAndView = new ModelAndView(getFormView());
		this.logger.debug(getFormView());
//		List<Staff> staffList = this.staffManagementServicesImpl.getListOfUser();
//		this.modelAndView.addObject("listUser", staffList);
		this.logger.debug("Completed the request");
		return super.handleRequestInternal(request, response);
	}
}