package sg.edu.nus.iss.vms.project.service;

import java.util.List;

import sg.edu.nus.iss.vms.common.dto.CodeDto;
import sg.edu.nus.iss.vms.project.dto.ProjectDto;
import sg.edu.nus.iss.vms.project.dto.ProjectMemberDto;

public interface ProjectManagementService {

    public List<ProjectDto> getListOfProject(String projectName);

    public ProjectDto getProject(long projectId);

    public List<ProjectMemberDto> getProjectMember(long projectId, String memberName);

    public List<ProjectDto> getListAllProject();

    public List<CodeDto> getProjectRoleList();
}
