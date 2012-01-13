package sg.edu.nus.iss.vms.project.service;

import java.util.List;

import sg.edu.nus.iss.vms.project.vo.ProjectInterestVo;

public interface ProjectInterestService {

	public List<ProjectInterestVo> getProjectInterestListbyProjectIdAndUserId(
			Long prjId, String userId);

	public void createProjectInterest(ProjectInterestVo projectInterestVo)
			throws Exception;

	public ProjectInterestVo getProjectInterestbyId(Long id);

	public void updateProjectInterest(ProjectInterestVo projectInterestVo)
			throws Exception;

	public List<ProjectInterestVo> getProjectIntrestByProjectId(Long projectId);

	public List<ProjectInterestVo> getProjectInterestListByUserLoginId();

	public List<ProjectInterestVo> getProjectInterestListBySearchCriteria(
			ProjectInterestVo projectInterestVo);

}
