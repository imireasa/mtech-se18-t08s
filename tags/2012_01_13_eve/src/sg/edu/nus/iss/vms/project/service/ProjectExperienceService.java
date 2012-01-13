package sg.edu.nus.iss.vms.project.service;

import java.util.List;

import sg.edu.nus.iss.vms.project.vo.ProjectExperienceVo;

public interface ProjectExperienceService {

	public List<ProjectExperienceVo> getProjectExperienceListbyProjectId(
			Long prjId);

	public void createProjectExperience(ProjectExperienceVo projectExperienceVo);

}
