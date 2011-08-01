package sg.edu.nus.iss.vms.staffmgmt.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import sg.edu.nus.iss.vms.common.SessionBean;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.staffmgmt.dto.Staff;

public class StaffManagementServices {
	private Logger logger = Logger.getLogger(StaffManagementServices.class);
	private Manager manager;
	private SessionBean sessionBean;

	public Manager getManager() {
		return this.manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public SessionBean getSessionBean() {
		return this.sessionBean;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	public List<Staff> getListOfUser() {
		this.logger.debug("@ Service Layer getting user 1");
		List<Staff> userList = new ArrayList<Staff>();
		try {
			userList = this.manager.list(Staff.class);
			for (Staff user : userList)
				this.logger.debug("@ User : " + user.getStaffId());
		} catch (Exception ex) {
			this.logger.error("Data Access Error", ex);
		} finally {
			this.logger.debug("@ Service Layer getting user 2");
		}
		return userList;
	}
}