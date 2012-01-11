package sg.edu.nus.iss.vms.project.service;

import java.util.List;

import sg.edu.nus.iss.vms.project.dto.ProjectDto;
import sg.edu.nus.iss.vms.project.dto.ProjectMemberDto;
import sg.edu.nus.iss.vms.project.vo.ProjectVo;

public interface ProjectManagementService {

	public List<ProjectVo> getListAllProject();

	public List<ProjectDto> getProjectbyProjectVo(ProjectVo projectVo);

	public ProjectVo getProjectbyId(long id);

	public ProjectVo getProjectVoById(Long projectId);

	public void saveProject(ProjectVo projectVo) throws Exception;

	public void updateProject(ProjectVo projectVo) throws Exception;

	public List<ProjectVo> getProjectListbyProjectVo(ProjectVo projectVo);

	public ProjectVo getProjectVoByLoginUserAccessRight(Long projectId);

	public List<ProjectMemberDto> getProjectMember(long projectId);

	public List<ProjectVo> getProjectsbyProjectVo(ProjectVo projectVo);

}
