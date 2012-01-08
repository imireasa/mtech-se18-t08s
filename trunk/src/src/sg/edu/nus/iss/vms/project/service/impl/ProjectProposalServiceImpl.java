package sg.edu.nus.iss.vms.project.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import sg.edu.nus.iss.vms.common.constants.VMSConstants;
import sg.edu.nus.iss.vms.common.dto.CodeDto;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.common.util.CodeLookupUtil;
import sg.edu.nus.iss.vms.common.util.DateUtil;
import sg.edu.nus.iss.vms.common.util.StringUtil;
import sg.edu.nus.iss.vms.common.web.util.UserUtil;
import sg.edu.nus.iss.vms.project.dto.ProjectDto;
import sg.edu.nus.iss.vms.project.dto.ProjectProposalDto;
import sg.edu.nus.iss.vms.project.service.ProjectProposalService;
import sg.edu.nus.iss.vms.project.vo.ProjectProposalVo;

public class ProjectProposalServiceImpl implements ProjectProposalService {

	private Manager manager;

	private static Logger logger = Logger
			.getLogger(ProjectFeedbackServiceImpl.class);

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public List<ProjectProposalVo> getProjectProposalList() {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(ProjectProposalDto.class);
		List<ProjectProposalDto> projectProposalDtos = manager
				.findByDetachedCriteria(criteria);

		List<ProjectProposalVo> prjFeedbackVos = new ArrayList<ProjectProposalVo>();

		for (ProjectProposalDto dto : projectProposalDtos) {
			prjFeedbackVos.add(new ProjectProposalVo(dto));

		}

		return prjFeedbackVos;
	}

	@Override
	public List<ProjectProposalVo> getProjectProposalListbySearchCriteria(
			ProjectProposalVo proposalVo) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(ProjectProposalDto.class);
		if (!StringUtil.isNullOrEmpty(proposalVo.getNme())) {
			criteria.add(Restrictions.like("nme", proposalVo.getNme(),
					MatchMode.ANYWHERE));
		}
		if (!StringUtil.isNullOrEmpty(proposalVo.getStsVal())) {

			List<CodeDto> codeDtos = CodeLookupUtil
					.getListOfCodeByCategory(VMSConstants.PROPOSAL_STATUS);
			for (CodeDto codeDto : codeDtos) {

				if (codeDto.getVal().equals(proposalVo.getStsVal())) {
					criteria.add(Restrictions.eq("stsCd", codeDto.getCdId()));
				}
			}

		}

		List<ProjectProposalDto> projectProposalDtos = manager
				.findByDetachedCriteria(criteria);

		List<ProjectProposalVo> projectProposalVos = new ArrayList<ProjectProposalVo>();

		for (ProjectProposalDto dto : projectProposalDtos) {
			projectProposalVos.add(new ProjectProposalVo(dto));

		}

		return projectProposalVos;

	}

	@Override
	public void createProjectProposal(ProjectProposalVo projectProposalVo) {

		String loginId = UserUtil.getUserSessionInfoVo().getUserID();

		long countryCodeId = 0;
		List<CodeDto> countryCodeDtos = CodeLookupUtil
				.getListOfCodeByCategory(VMSConstants.COUNTRY_CATEGORY);
		for (CodeDto countryCodeDto : countryCodeDtos) {
			if (countryCodeDto.getVal().equals(projectProposalVo.getCtryVal())) {
				countryCodeId = countryCodeDto.getCdId();
				break;
			}
		}

		ProjectProposalDto projectProposalDto = new ProjectProposalDto();
		projectProposalDto.setCtryCd(countryCodeId);
		projectProposalDto.setEstDur(projectProposalVo.getEstDur());
		projectProposalDto.setLoc(projectProposalVo.getLoc());
		projectProposalDto.setNme(projectProposalVo.getNme());
		projectProposalDto.setDesc(projectProposalVo.getDesc());

		CodeDto codeDto = CodeLookupUtil.getCodeByCategoryAndCodeValue(
				VMSConstants.PROPOSAL_STATUS,
				VMSConstants.PROPOSAL_STATUS_SUMBITTED);

		projectProposalDto.setStsCd(codeDto.getCdId());
		projectProposalDto.setProposerId(loginId);

		manager.save(projectProposalDto);

	}

	@Override
	public ProjectProposalVo getProjectProposalbyId(Long id) {
		ProjectProposalDto projectProposalDto = (ProjectProposalDto) manager
				.get(ProjectProposalDto.class, id);

		if (projectProposalDto != null) {
			return new ProjectProposalVo(projectProposalDto);
		}
		return null;
	}

	@Override
	public void updateProjectProposal(ProjectProposalVo projectProposalVo) {

		ProjectProposalDto projectProposalDto = (ProjectProposalDto) manager
				.get(ProjectProposalDto.class, projectProposalVo.getPrjPropId());

		CodeDto codeDto = CodeLookupUtil.getCodeByCatAndVal(
				VMSConstants.PROPOSAL_STATUS, projectProposalVo.getStsVal());

		String loginId = UserUtil.getUserSessionInfoVo().getUserID();

		if (VMSConstants.PROPOSAL_STATUS_APPROVED.equals(projectProposalVo
				.getStsVal())
				|| VMSConstants.PROPOSAL_STATUS_REJECTED
						.equals(projectProposalVo.getStsVal())) {
			projectProposalDto.setApprBy(loginId);
			projectProposalDto.setApprDte(new Date());
		}
		projectProposalDto.setRmk(projectProposalVo.getRmk());
		projectProposalDto.setStsCd(codeDto.getCdId());

		manager.save(projectProposalDto);

	}

	public void convertProposalToProject(ProjectProposalVo projectProposalVo) {

		ProjectProposalDto projectProposalDto = (ProjectProposalDto) manager
				.get(ProjectProposalDto.class, projectProposalVo.getPrjPropId());
		String loginId = UserUtil.getUserSessionInfoVo().getUserID();

		ProjectDto projectDto = new ProjectDto();
		projectDto.setNme(projectProposalDto.getNme());
		projectDto.setDesc(projectProposalDto.getDesc());
		projectDto.setCtryCd(projectProposalDto.getCtryCd());
		projectDto.setLoc(projectProposalDto.getLoc());
		projectDto.setStrDte(new Date());
		projectDto.setEndDte(DateUtil.add(projectDto.getStrDte(),
				Calendar.DAY_OF_YEAR, projectProposalDto.getEstDur()));
		projectDto.setPrjMgr(loginId);

		CodeDto projectStsCodeDto = CodeLookupUtil
				.getCodeByCategoryAndCodeValue(VMSConstants.PROJECT_STATUS,
						VMSConstants.PROJECT_STATUS_CATEGORY_NEW);
		projectDto.setStsCd(projectStsCodeDto.getCdId());
		projectDto.setPrjPropId(projectProposalDto);
		projectDto.setCreatedBy(loginId);
		projectDto.setCreatedDte(new Date());
		projectDto.setUpdBy(loginId);
		projectDto.setUpdDte(new Date());

		manager.save(projectDto);

	}

}
