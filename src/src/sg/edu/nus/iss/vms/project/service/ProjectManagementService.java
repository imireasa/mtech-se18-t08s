package sg.edu.nus.iss.vms.project.service;

import java.util.List;

import java.util.Map;
import sg.edu.nus.iss.vms.common.dto.CertificateRequestDto;
import sg.edu.nus.iss.vms.common.dto.CodeDto;
import sg.edu.nus.iss.vms.project.dto.ProjectDto;
import sg.edu.nus.iss.vms.project.dto.ProjectExperienceDto;
import sg.edu.nus.iss.vms.project.dto.ProjectFeedbackDto;
import sg.edu.nus.iss.vms.project.dto.ProjectInterestDto;
import sg.edu.nus.iss.vms.project.dto.ProjectMemberDto;
import sg.edu.nus.iss.vms.project.dto.ProjectProposalDto;
import sg.edu.nus.iss.vms.project.vo.ProjectInfoVo;
import sg.edu.nus.iss.vms.project.vo.ProjectVo;

public interface ProjectManagementService {

        public List<ProjectDto> getListOfProject(String projectName);

        public ProjectDto getProject(long projectId);

	public List<ProjectMemberDto> getProjectMember(long projectId,
			String memberName);

        public List<ProjectVo> getListAllProject();

        public List<CodeDto> getProjectRoleList();

        public List<ProjectDto> getProjectbyProjectVo(ProjectVo projectVo);

	public Object getProjectObjbyId(long id, Class type);

        public void raseInterest(ProjectInterestDto projectInterestDto);

	public List<ProjectExperienceDto> getProjectExperienceList(
			ProjectDto projectDto);

	public List<ProjectFeedbackDto> getProjectFeedbackList(ProjectDto projectDto);

	public void postProjectExperience(ProjectExperienceDto projectExperienceDto);

	public void postProjectFeedback(ProjectFeedbackDto projectFeedbackDto);

        public void requestCertificate(CertificateRequestDto certificateRequestDto);

	public List getAllProjectObjectList(Class type);

	public ProjectVo getProjectVoById(Long projectId);

	public void saveProject(ProjectVo projectVo) throws Exception;

	public void updateProject(ProjectVo projectVo) throws Exception;

	public List<ProjectFeedbackDto> getProjectFeedbackListbyVo(
			ProjectInfoVo projectInfoVo);

	public void saveOrUpdateProjectObject(Object obj);

	public List<ProjectProposalDto> getProjectProposalListbyVo(
			ProjectVo projectVo);

        List<CodeDto> getProjectStatusList();

        List<ProjectVo> listProjectbyProjectVo(ProjectVo projectVo);
}
