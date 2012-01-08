package sg.edu.nus.iss.vms.project.service;

import java.util.List;

import sg.edu.nus.iss.vms.common.dto.CertificateRequestDto;
import sg.edu.nus.iss.vms.project.dto.ProjectDto;
import sg.edu.nus.iss.vms.project.dto.ProjectMemberDto;
import sg.edu.nus.iss.vms.project.vo.ProjectVo;

public interface ProjectManagementService {

	public List<ProjectVo> getListAllProject();

	public List<ProjectDto> getProjectbyProjectVo(ProjectVo projectVo);

	public Object getProjectObjbyId(long id, Class type);

	public List getAllProjectObjectList(Class type);

	public ProjectVo getProjectVoById(Long projectId);

	public void saveProject(ProjectVo projectVo) throws Exception;

	public void updateProject(ProjectVo projectVo) throws Exception;

	public void saveOrUpdateProjectObject(Object obj);

	public List<ProjectVo> getProjectListbyProjectVo(ProjectVo projectVo);

	public void sendInviteProjectMemberToAllUser(Long projectId, Long userStatus)
			throws Exception;

	public void deleteProjectMemberByProjectMemberId(String projectMemberId)
			throws Exception;

	public void requestProjectCertificateByProjectId(Long projectId)
			throws Exception;

	public void updateProjectMemberRoleByProjectMemberIdnRole(
			String projectMemberId, Long roleCd) throws Exception;

	public ProjectVo getProjectVoByLoginUserAccessRight(Long projectId);

	public List<CertificateRequestDto> getCertificateRequestsbyProject(
			Long prjId, String userId);

	public List<ProjectMemberDto> getProjectMember(long projectId);

}
