package sg.edu.nus.iss.vms.security.service.impl;

import sg.edu.nus.iss.vms.common.SessionBean;
import sg.edu.nus.iss.vms.security.service.SecurityManagementService;

public class SecurityManagementServiceImpl implements SecurityManagementService{
	private SessionBean sessionBean;

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	public SessionBean getSessionBean() {
		return sessionBean;
	}
}
