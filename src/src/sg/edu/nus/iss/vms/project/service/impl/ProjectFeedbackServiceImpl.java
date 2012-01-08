package sg.edu.nus.iss.vms.project.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import sg.edu.nus.iss.vms.common.constants.VMSConstants;
import sg.edu.nus.iss.vms.common.dto.CodeDto;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.common.util.CodeLookupUtil;
import sg.edu.nus.iss.vms.common.util.StringUtil;
import sg.edu.nus.iss.vms.common.web.util.UserUtil;
import sg.edu.nus.iss.vms.project.dto.ProjectDto;
import sg.edu.nus.iss.vms.project.dto.ProjectFeedbackDto;
import sg.edu.nus.iss.vms.project.service.ProjectFeedbackService;
import sg.edu.nus.iss.vms.project.vo.ProjectFeedbackVo;

public class ProjectFeedbackServiceImpl implements ProjectFeedbackService {
	private Manager manager;

	private static Logger logger = Logger
			.getLogger(ProjectFeedbackServiceImpl.class);

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public List<ProjectFeedbackVo> getProjectFeedbackList() {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(ProjectFeedbackDto.class);
		List<ProjectFeedbackDto> projectFeedbackDtos = manager
				.findByDetachedCriteria(criteria);

		List<ProjectFeedbackVo> prjFeedbackVos = new ArrayList<ProjectFeedbackVo>();

		for (ProjectFeedbackDto dto : projectFeedbackDtos) {
			prjFeedbackVos.add(new ProjectFeedbackVo(dto));

		}

		return prjFeedbackVos;
	}

	@Override
	public List<ProjectFeedbackVo> getProjectFeedbackListbyProjectId(Long prjId) {
		CodeDto codeDto = CodeLookupUtil.getCodeByCategoryAndCodeValue(
				VMSConstants.FEEDBACK_STATUS,
				VMSConstants.FEEDBACK_STATUS_APPROVED);
		DetachedCriteria criteria = DetachedCriteria
				.forClass(ProjectFeedbackDto.class);
		criteria.setFetchMode("prjId", FetchMode.JOIN)
				.createAlias("prjId", "prj")
				.add(Restrictions.eq("prj.prjId", prjId))
				.add(Restrictions.eq("stsCd", codeDto.getCdId()));
		List<ProjectFeedbackDto> prjFeedbackDtos = manager
				.findByDetachedCriteria(criteria);
		List<ProjectFeedbackVo> projectFeedbackVos = new ArrayList<ProjectFeedbackVo>();
		for (ProjectFeedbackDto projectFeedbackDto : prjFeedbackDtos) {
			projectFeedbackVos.add(new ProjectFeedbackVo(projectFeedbackDto));
		}

		return projectFeedbackVos;
	}

	@Override
	public List<ProjectFeedbackVo> getProjectFeedbackListbySearchCriteria(
			ProjectFeedbackVo prjFeedbackVo) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(ProjectFeedbackDto.class);

		if (prjFeedbackVo.getPrjId() != null) {

			criteria.setFetchMode("prjId", FetchMode.JOIN)
					.createAlias("prjId", "prj")
					.add(Restrictions.eq("prj.prjId",
							prjFeedbackVo.getPrjFbId()));
		}
		if (!StringUtil.isNullOrEmpty(prjFeedbackVo.getTitle())) {
			criteria.add(Restrictions.like("title", prjFeedbackVo.getTitle(),
					MatchMode.ANYWHERE));
		}
		if (!StringUtil.isNullOrEmpty(prjFeedbackVo.getStsVal())) {

			List<CodeDto> codeDtos = CodeLookupUtil
					.getListOfCodeByCategory(VMSConstants.FEEDBACK_STATUS);
			for (CodeDto codeDto : codeDtos) {

				if (codeDto.getVal().equals(prjFeedbackVo.getStsVal())) {
					criteria.add(Restrictions.eq("stsCd", codeDto.getCdId()));
				}
			}

		}

		if (!StringUtil.isNullOrEmpty(prjFeedbackVo.getPrjNme())) {
			criteria.setFetchMode("prjId", FetchMode.JOIN)
					.createAlias("prjId", "prj")
					.add(Restrictions.like("prj.nme",
							prjFeedbackVo.getPrjNme(), MatchMode.ANYWHERE));
		}

		List<ProjectFeedbackDto> projectFeedbackDtos = manager
				.findByDetachedCriteria(criteria);
		List<ProjectFeedbackVo> projectFeedbackVos = new ArrayList<ProjectFeedbackVo>();
		for (ProjectFeedbackDto dto : projectFeedbackDtos) {
			projectFeedbackVos.add(new ProjectFeedbackVo(dto));

		}

		return projectFeedbackVos;
	}

	@Override
	public void createProjectFeedback(ProjectFeedbackVo projectFeedbackVo) {

		CodeDto codeDto = CodeLookupUtil
				.getCodeDescriptionByCodeCategoryAndCodeDesc(
						VMSConstants.FEEDBACK_STATUS,
						VMSConstants.FEEDBACK_STATUS_SUMBITTED);

		ProjectFeedbackDto projectFeedbackDto = new ProjectFeedbackDto();
		projectFeedbackDto.setPrjId((ProjectDto) getProjectObjbyId(
				projectFeedbackVo.getPrjId(), ProjectDto.class));
		projectFeedbackDto.setCont(projectFeedbackVo.getCont());
		projectFeedbackDto.setTitle(projectFeedbackVo.getTitle());

		projectFeedbackDto.setUpdDte(new Date());
		projectFeedbackDto.setStsCd(codeDto.getCdId());
		manager.save(projectFeedbackDto);

	}

	@Override
	public ProjectFeedbackVo getProjectFeedbackbyId(Long id) {
		ProjectFeedbackDto projectFbDto = (ProjectFeedbackDto) getProjectObjbyId(
				id, ProjectFeedbackDto.class);

		if (projectFbDto != null) {
			return new ProjectFeedbackVo(projectFbDto);
		}
		return null;
	}

	private Object getProjectObjbyId(long id, Class type) {
		try {
			return manager.get(type, id);
		} catch (Exception ex) {
			this.logger.error("Data Access Error", ex);
			return null;
		} finally {
			this.logger.debug("@ Service Layer getting user 2");
		}

	}

	@Override
	public void updateProjectFeedback(ProjectFeedbackVo projectFeedbackVo) {

		ProjectFeedbackDto projectFbDto = (ProjectFeedbackDto) getProjectObjbyId(
				projectFeedbackVo.getPrjFbId(), ProjectFeedbackDto.class);
		String loginId = UserUtil.getUserSessionInfoVo().getUserID();

		projectFbDto.setStsCd(projectFeedbackVo.getStsCd());
		projectFbDto.setApprBy(loginId);
		projectFbDto.setApprDte(new Date());
		manager.save(projectFbDto);

	}
}
