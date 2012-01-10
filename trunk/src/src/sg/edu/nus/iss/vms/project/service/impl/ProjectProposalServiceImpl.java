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
import sg.edu.nus.iss.vms.common.dto.DocumentDto;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.common.util.CodeLookupUtil;
import sg.edu.nus.iss.vms.common.util.DateUtil;
import sg.edu.nus.iss.vms.common.util.StringUtil;
import sg.edu.nus.iss.vms.common.vo.CodeLookupVo;
import sg.edu.nus.iss.vms.common.web.util.UserUtil;
import sg.edu.nus.iss.vms.project.dto.ProjectDto;
import sg.edu.nus.iss.vms.project.dto.ProjectProposalDocumentDto;
import sg.edu.nus.iss.vms.project.dto.ProjectProposalDto;
import sg.edu.nus.iss.vms.project.service.ProjectProposalService;
import sg.edu.nus.iss.vms.project.vo.ProjectProposalDocumentVo;
import sg.edu.nus.iss.vms.project.vo.ProjectProposalVo;

public class ProjectProposalServiceImpl implements ProjectProposalService {

	private Manager manager;

	private static Logger logger = Logger.getLogger(ProjectFeedbackServiceImpl.class);

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public List<ProjectProposalVo> getProjectProposalList() {
		DetachedCriteria criteria = DetachedCriteria.forClass(ProjectProposalDto.class);
		List<ProjectProposalDto> projectProposalDtos = manager.findByDetachedCriteria(criteria);

		List<ProjectProposalVo> prjFeedbackVos = new ArrayList<ProjectProposalVo>();

		for (ProjectProposalDto dto : projectProposalDtos) {
			prjFeedbackVos.add(new ProjectProposalVo(dto));

		}

		return prjFeedbackVos;
	}

	@Override
	public List<ProjectProposalVo> getProjectProposalListbySearchCriteria(ProjectProposalVo proposalVo) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ProjectProposalDto.class);
		if (!StringUtil.isNullOrEmpty(proposalVo.getNme())) {
			criteria.add(Restrictions.like("nme", proposalVo.getNme(), MatchMode.ANYWHERE));
		}
		if (!StringUtil.isNullOrEmpty(proposalVo.getStsVal())) {

			List<CodeLookupVo> codeLookupVos = CodeLookupUtil.getCodeListByCategory(VMSConstants.PROPOSAL_STATUS);
			for (CodeLookupVo codeLookupVo : codeLookupVos) {

				if (codeLookupVo.getVal().equals(proposalVo.getStsVal())) {
					criteria.add(Restrictions.eq("stsCd", codeLookupVo.getCdId()));
				}
			}

		}

		List<ProjectProposalDto> projectProposalDtos = manager.findByDetachedCriteria(criteria);

		List<ProjectProposalVo> projectProposalVos = new ArrayList<ProjectProposalVo>();

		for (ProjectProposalDto dto : projectProposalDtos) {
			projectProposalVos.add(new ProjectProposalVo(dto));

		}

		return projectProposalVos;

	}

	@Override
	public void createProjectProposal(ProjectProposalVo projectProposalVo, List<ProjectProposalDocumentVo> projectProposalDocumentVos) {

		String loginId = UserUtil.getUserSessionInfoVo().getUserID();

		long countryCodeId = 0;
		List<CodeLookupVo> countryCodeVos = CodeLookupUtil.getCodeListByCategory(VMSConstants.COUNTRY_CATEGORY);
		for (CodeLookupVo countryCodeVo : countryCodeVos) {
			if (countryCodeVo.getVal().equals(projectProposalVo.getCtryVal())) {
				countryCodeId = countryCodeVo.getCdId();
				break;
			}
		}

		ProjectProposalDto projectProposalDto = new ProjectProposalDto();
		projectProposalDto.setCtryCd(countryCodeId);
		projectProposalDto.setEstDur(projectProposalVo.getEstDur());
		projectProposalDto.setLoc(projectProposalVo.getLoc());
		projectProposalDto.setNme(projectProposalVo.getNme());
		projectProposalDto.setDesc(projectProposalVo.getDesc());
		List<DocumentDto> documentDtoList = createAndGetDocumentDtoList(projectProposalDocumentVos);
		projectProposalDto.setDocumentList(documentDtoList);
		CodeLookupVo codeVo = CodeLookupUtil.getCodeByCategoryAndCodeValue(VMSConstants.PROPOSAL_STATUS, VMSConstants.PROPOSAL_STATUS_SUMBITTED);

		projectProposalDto.setStsCd(codeVo.getCdId());
		projectProposalDto.setProposerId(loginId);

		manager.save(projectProposalDto);

	}

	private List<DocumentDto> createAndGetDocumentDtoList(List<ProjectProposalDocumentVo> projectProposalDocumentVos) {
		if (logger.isDebugEnabled()) {
			logger.debug("getDocumentDtoList(List<ProjectProposalDocumentVo>) - start"); //$NON-NLS-1$
		}

		ArrayList<DocumentDto> result = new ArrayList<DocumentDto>();
		String loginId = UserUtil.getUserSessionInfoVo().getUserID();
		CodeLookupVo codeVo = CodeLookupUtil.getCodeByCategoryAndCodeValue(VMSConstants.REFERENCE_TYPE_CATEGORY, VMSConstants.REFERENCE_TYPE_CATEGORY_PROPOSAL);

		for (ProjectProposalDocumentVo documentVo : projectProposalDocumentVos) {
			DocumentDto tempDto = new DocumentDto();
			tempDto.setFle(documentVo.getContent());
			tempDto.setFleNme(documentVo.getFileName());
			tempDto.setVersion(1);
			tempDto.setCreatedBy(loginId);
			tempDto.setUpdBy(loginId);
			tempDto.setCreatedDte(new Date());
			tempDto.setUpdDte(new Date());
			tempDto.setRefTp(codeVo.getCdId());
			manager.save(tempDto);
			result.add(tempDto);
			
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getDocumentDtoList(List<ProjectProposalDocumentVo>) - end with size ="+result.size()); //$NON-NLS-1$
		}
		return result;
	}

	@Override
	public ProjectProposalVo getProjectProposalbyId(Long id) {
		ProjectProposalDto projectProposalDto = (ProjectProposalDto) manager.get(ProjectProposalDto.class, id);

		if (projectProposalDto != null) {
			return new ProjectProposalVo(projectProposalDto);
		}
		return null;
	}

	@Override
	public void updateProjectProposal(ProjectProposalVo projectProposalVo) {

		ProjectProposalDto projectProposalDto = (ProjectProposalDto) manager.get(ProjectProposalDto.class, projectProposalVo.getPrjPropId());

		CodeLookupVo codeVo = CodeLookupUtil.getCodeByCategoryAndCodeValue(VMSConstants.PROPOSAL_STATUS, projectProposalVo.getStsVal());

		String loginId = UserUtil.getUserSessionInfoVo().getUserID();

		if (VMSConstants.PROPOSAL_STATUS_APPROVED.equals(projectProposalVo.getStsVal())
				|| VMSConstants.PROPOSAL_STATUS_REJECTED.equals(projectProposalVo.getStsVal())) {
			projectProposalDto.setApprBy(loginId);
			projectProposalDto.setApprDte(new Date());
		}
		projectProposalDto.setRmk(projectProposalVo.getRmk());
		projectProposalDto.setStsCd(codeVo.getCdId());

		manager.save(projectProposalDto);

	}

	public void convertProposalToProject(ProjectProposalVo projectProposalVo) {

		ProjectProposalDto projectProposalDto = (ProjectProposalDto) manager.get(ProjectProposalDto.class, projectProposalVo.getPrjPropId());
		String loginId = UserUtil.getUserSessionInfoVo().getUserID();

		ProjectDto projectDto = new ProjectDto();
		projectDto.setNme(projectProposalDto.getNme());
		projectDto.setDesc(projectProposalDto.getDesc());
		projectDto.setCtryCd(projectProposalDto.getCtryCd());
		projectDto.setLoc(projectProposalDto.getLoc());
		projectDto.setStrDte(new Date());
		projectDto.setEndDte(DateUtil.add(projectDto.getStrDte(), Calendar.DAY_OF_YEAR, projectProposalDto.getEstDur()));
		projectDto.setPrjMgr(loginId);

		CodeLookupVo projectStsCodeVo = CodeLookupUtil.getCodeByCategoryAndCodeValue(VMSConstants.PROJECT_STATUS,
				VMSConstants.PROJECT_STATUS_CATEGORY_NEW);
		projectDto.setStsCd(projectStsCodeVo.getCdId());
		projectDto.setPrjPropId(projectProposalDto);
		projectDto.setCreatedBy(loginId);
		projectDto.setCreatedDte(new Date());
		projectDto.setUpdBy(loginId);
		projectDto.setUpdDte(new Date());

		manager.save(projectDto);

	}

}
