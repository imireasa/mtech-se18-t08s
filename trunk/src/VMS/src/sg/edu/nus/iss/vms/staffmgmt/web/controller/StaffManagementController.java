package sg.edu.nus.iss.vms.staffmgmt.web.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import sg.edu.nus.iss.vms.common.web.controller.BaseFormController;
import sg.edu.nus.iss.vms.staffmgmt.dto.Staff;
import sg.edu.nus.iss.vms.staffmgmt.service.impl.StaffManagementServices;

public class StaffManagementController extends BaseFormController {
	private Logger logger = Logger.getLogger(StaffManagementController.class);
	private StaffManagementServices staffManagementServices;

	public StaffManagementServices getStaffManagementServices() {
		return this.staffManagementServices;
	}

	public void setStaffManagementServices(StaffManagementServices staffManagementServices) {
		this.staffManagementServices = staffManagementServices;
	}

	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		this.modelAndView = new ModelAndView(getFormView());
		this.logger.debug(getFormView());
		List<Staff> staffList = this.staffManagementServices.getListOfUser();

		for (Staff user : staffList) {
			this.logger.debug("Message " + user.getStaffId());
		}
		this.modelAndView.addObject("listUser", staffList);
		this.logger.debug("Completed the request");
		return super.handleRequestInternal(request, response);
	}
}