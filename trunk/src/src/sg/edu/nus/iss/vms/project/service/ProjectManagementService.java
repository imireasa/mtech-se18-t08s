package sg.edu.nus.iss.vms.project.service;

import java.util.List;

import sg.edu.nus.iss.vms.common.dto.CertificateRequestDto;
import sg.edu.nus.iss.vms.common.dto.CodeDto;
import sg.edu.nus.iss.vms.project.dto.ProjectDto;
import sg.edu.nus.iss.vms.project.dto.ProjectExperienceDto;
import sg.edu.nus.iss.vms.project.dto.ProjectFeedbackDto;
import sg.edu.nus.iss.vms.project.dto.ProjectInterestDto;
import sg.edu.nus.iss.vms.project.dto.ProjectMemberDto;
import sg.edu.nus.iss.vms.project.dto.ProjectProposalDto;
import sg.edu.nus.iss.vms.project.vo.ProjectInfoVo;
import sg.edu.nus.iss.vms.project.vo.ProjectInterestSearchVo;
import sg.edu.nus.iss.vms.project.vo.ProjectInterestVo;
import sg.edu.nus.iss.vms.project.vo.ProjectProposalVo;
import sg.edu.nus.iss.vms.project.vo.ProjectVo;

public interface ProjectManagementService {

	public List<ProjectDto> getListOfProject(String projectName);

	public ProjectDto getProject(long projectId);

	public List<ProjectMemberDto> getProjectMember(long projectId,
			String memberName);

	public List<ProjectVo> getListAllProject();

	public List<ProjectDto> getProjectbyProjectVo(ProjectVo projectVo);

	public Object getProjectObjbyId(long id, Class type);

	public List<ProjectExperienceDto> getProjectExperienceList(
			ProjectDto projectDto);

	public List<ProjectFeedbackDto> getProjectFeedbackList(ProjectDto projectDto);

	public void requestCertificate(CertificateRequestDto certificateRequestDto);

	public List getAllProjectObjectList(Class type);

	public ProjectVo getProjectVoById(Long projectId);

	public void saveProject(ProjectVo projectVo) throws Exception;

	public void updateProject(ProjectVo projectVo) throws Exception;

	public List<ProjectFeedbackDto> getProjectFeedbackListbyVo(
			ProjectInfoVo projectInfoVo);

	public void saveOrUpdateProjectObject(Object obj);

	public ProjectFeedbackDto getProjectFeedbackbyId(long projectFbId);

	public List<ProjectProposalDto> getProjectProposalListbyVo(
			ProjectProposalVo proposalVo);

	public List<CodeDto> getProjectStatusList();

	public List<ProjectVo> listProjectbyProjectVo(ProjectVo projectVo);

	public List<CodeDto> getProjectInterestStatusList();

	public List<ProjectInterestVo> getProjectInterestListByUser();

	public List<ProjectInterestVo> getProjectIntrestVoByLoginUserAccessRight(
			Long projectId);

	public void acceptProjectIntrest(Long prjIntrstId) throws Exception;

	public void sendInviteProjectMemberToAllUser(Long projectId, Long userStatus)
			throws Exception;

	public void deleteProjectMemberByProjectMemberId(String projectMemberId)
			throws Exception;

	public void requestProjectCertificateByProjectId(Long projectId)
			throws Exception;

	public void updateProjectMemberRoleByProjectMemberIdnRole(
			String projectMemberId, Long roleCd) throws Exception;

	public ProjectVo getProjectVoByLoginUserAccessRight(Long projectId);

	public List getProjectInterestListByUserWithSearch(
			ProjectInterestSearchVo command);

	public List<CertificateRequestDto> getCertificateRequestsbyProject(
			Long prjId, String userId);

	public List<ProjectInterestDto> getProjectInterestListbyProject(
			ProjectDto projectDto, String userId);

	public List<ProjectInterestVo> getProjectInterestListByUser(Long prjId,
			String userId);

	public List<CodeDto> getProjectInterestStatusList2();

	public List<ProjectInterestVo> getProjectInterestListByUserLoginId();
}
