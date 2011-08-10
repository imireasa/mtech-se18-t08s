package sg.edu.nus.iss.vms.staffmgmt.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import sg.edu.nus.iss.vms.common.SessionBean;
import sg.edu.nus.iss.vms.common.dto.Person;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.member.dto.Staff;
import sg.edu.nus.iss.vms.staffmgmt.service.StaffManagementServices;

public class StaffManagementServicesImpl implements StaffManagementServices {
	private Logger logger = Logger.getLogger(StaffManagementServicesImpl.class);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see sg.edu.nus.iss.vms.staffmgmt.service.impl.StaffManagementServices#
	 * getListOfUser()
	 */
	public List<Staff> getListOfUser() {
//		this.logger.debug("@ Service Layer getting user 1");
//		logger.debug("Start Debug Data");
//		for (int i = 1000; i < 1100; i++) {
//			Staff newStaff = new Staff();
//			newStaff.setFirstName("" + i);
//			newStaff.setLastName("" + i);
//			newStaff.setMobile("" + i);
//			newStaff.setSalary(i);
//			this.manager.save(newStaff);
//			logger.debug("Data " + newStaff.getFirstName());
//		}
//		logger.debug("End Debug Data");

		List<Staff> userList = new ArrayList<Staff>();
		try {
			userList = this.manager.list(Staff.class);
		} catch (Exception ex) {
			this.logger.error("Data Access Error", ex);
		} finally {
			this.logger.debug("@ Service Layer getting user 2");
		}
		return userList;
	}
}