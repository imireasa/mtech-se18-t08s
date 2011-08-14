package sg.edu.nus.iss.vms.project.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import sg.edu.nus.iss.vms.common.SessionBean;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.member.service.impl.MemberManagementServiceImpl;
import sg.edu.nus.iss.vms.project.dto.Project;
import sg.edu.nus.iss.vms.project.dto.ProjectMember;
import sg.edu.nus.iss.vms.project.service.ProjectManagementService;

public class ProjectManagementServiceImpl implements ProjectManagementService {
	private Manager manager;
	private SessionBean sessionBean;
	private Logger logger = Logger.getLogger(MemberManagementServiceImpl.class);

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

	@Override
	public List<Project> getListOfProject(String projectName) {
		String hQL = "from Project where projectName LIKE '%" + projectName + "%'";
		List<Project> projectMemberList = manager.find(hQL);
		return projectMemberList;
	}

	@Override
	public Project getProject(long projectId) {		
		Project project = (Project) manager.get(Project.class, projectId);
		return project;
	}
	
	
	@Override
	public List<Project> getListAllProject() {
		List<Project> project = manager.list(Project.class);
		return project;
	}
	
	
}
