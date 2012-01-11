package sg.edu.nus.iss.vms.project.service;

import java.util.List;

import sg.edu.nus.iss.vms.project.vo.ProjectFeedbackVo;

public interface ProjectFeedbackService {

	public List<ProjectFeedbackVo> getProjectFeedbackList();

	public List<ProjectFeedbackVo> getProjectFeedbackListbyProjectId(Long prjId);

	public List<ProjectFeedbackVo> getProjectFeedbackListbySearchCriteria(
			ProjectFeedbackVo prjFeedbackVo);

	public void createProjectFeedback(ProjectFeedbackVo projectFeedbackVo);

	public ProjectFeedbackVo getProjectFeedbackbyId(Long id);

	public void updateProjectFeedback(ProjectFeedbackVo projectFeedbackVo);
}
