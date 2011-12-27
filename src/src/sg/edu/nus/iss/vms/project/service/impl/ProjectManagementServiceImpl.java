package sg.edu.nus.iss.vms.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import sg.edu.nus.iss.vms.common.SessionBean;
import sg.edu.nus.iss.vms.common.dto.CodeDto;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.project.dto.ProjectDto;
import sg.edu.nus.iss.vms.project.dto.ProjectMemberDto;
import sg.edu.nus.iss.vms.project.service.ProjectManagementService;

public class ProjectManagementServiceImpl implements ProjectManagementService {

	private Manager manager;
	private SessionBean sessionBean;

	private static Logger logger = Logger
			.getLogger(ProjectManagementServiceImpl.class);

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public SessionBean getSessionBean() {
		return sessionBean;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	// @Override
	// public List<Project> getListOfProject(String projectName) {
	// String hQL = "from Project where projectName LIKE '%" + projectName +
	// "%'";
	// List<Project> projectMemberList = manager.find(hQL);
	// return projectMemberList;
	// }
	//
	// @Override
	// public Project getProject(long projectId) {
	// Project project = (Project) manager.get(Project.class, projectId);
	// return project;
	// }
	//
	// @Override
	// public List<ProjectMember> getProjectMember(long projectId, String
	// memberName) {
	// String hQL = "from ProjectMember where projectId.projectId=" + projectId;
	// if (memberName != null && !memberName.isEmpty())
	// hQL += " and (volunteerId.firstName LIKE '%" + memberName + "%' " +
	// "OR volunteerId.lastName LIKE '%" + memberName + "%')";
	// List<ProjectMember> projectMemberList = manager.find(hQL);
	// return projectMemberList;
	// }
	//
	// @Override
	// public List<Project> getListAllProject() {
	// List<Project> project = manager.list(Project.class);
	// return project;
	// }
	//
	// @Override
	// public List<ProjectRole> getProjectRoleList() {
	// List<ProjectRole> projectRoleList = manager.list(ProjectRole.class);
	// return projectRoleList;
	// }
	@Override
	public List<ProjectDto> getListOfProject(String projectName) {
		List<ProjectDto> memberList = new ArrayList<ProjectDto>();
		return memberList;
	}

	@Override
	public ProjectDto getProject(long projectId) {
		return null;
	}

	@Override
	public List<ProjectMemberDto> getProjectMember(long projectId,
			String memberName) {
		return null;
	}

	@Override
	public List<ProjectDto> getListAllProject() {
		List<ProjectDto> project = manager.list(ProjectDto.class);
		return project;
	}

	@Override
	public List<CodeDto> getProjectRoleList() {
		return null;
	}
}
