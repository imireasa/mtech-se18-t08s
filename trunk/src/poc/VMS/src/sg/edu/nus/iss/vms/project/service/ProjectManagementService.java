package sg.edu.nus.iss.vms.project.service;

import java.util.List;

import sg.edu.nus.iss.vms.member.vo.MemberVo;
import sg.edu.nus.iss.vms.project.dto.Project;
import sg.edu.nus.iss.vms.project.dto.ProjectMember;
import sg.edu.nus.iss.vms.project.dto.ProjectRole;

public interface ProjectManagementService {
	public List<Project> getListOfProject(String projectName);
	
	public Project getProject(long projectId);
	
	public List<ProjectMember> getProjectMember(long projectId, String memberName);
	
	public List<Project> getListAllProject();
	
	public List<ProjectRole> getProjectRoleList();
	
}
