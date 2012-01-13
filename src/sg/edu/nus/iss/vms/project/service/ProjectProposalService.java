package sg.edu.nus.iss.vms.project.service;

import java.util.List;

import sg.edu.nus.iss.vms.project.vo.ProjectProposalDocumentVo;
import sg.edu.nus.iss.vms.project.vo.ProjectProposalVo;

public interface ProjectProposalService {

	public List<ProjectProposalVo> getProjectProposalListbySearchCriteria(
			ProjectProposalVo proposalVo);

	public List<ProjectProposalVo> getProjectProposalList();

	public ProjectProposalVo getProjectProposalbyId(Long id);

	public void createProjectProposal(ProjectProposalVo projectProposalVo, List<ProjectProposalDocumentVo> projectProposalDocumentVos);

	public void updateProjectProposal(ProjectProposalVo projectProposalVo);

	public void convertProposalToProject(ProjectProposalVo projectProposalVo);

}
