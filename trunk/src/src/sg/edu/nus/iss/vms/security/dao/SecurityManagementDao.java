package sg.edu.nus.iss.vms.security.dao;

import sg.edu.nus.iss.vms.common.SessionBean;
import sg.edu.nus.iss.vms.common.dao.hibernate.BaseDaoHibernate;
import sg.edu.nus.iss.vms.common.orm.Manager;

public class SecurityManagementDao extends BaseDaoHibernate{
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
}
