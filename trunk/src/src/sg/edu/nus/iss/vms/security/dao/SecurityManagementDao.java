package sg.edu.nus.iss.vms.security.dao;

import sg.edu.nus.iss.vms.common.orm.Manager;

public class SecurityManagementDao {
	private Manager manager;

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Manager getManager() {
		return manager;
	}
	
}
