package sg.edu.nus.iss.vms.project.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.common.util.DateUtil;
import sg.edu.nus.iss.vms.common.web.util.UserUtil;
import sg.edu.nus.iss.vms.project.dto.ProjectDto;
import sg.edu.nus.iss.vms.project.dto.ProjectExperienceDto;
import sg.edu.nus.iss.vms.project.service.ProjectExperienceService;
import sg.edu.nus.iss.vms.project.vo.ProjectExperienceVo;

public class ProjectExperienceServiceImpl implements ProjectExperienceService {
	private Manager manager;

	private static Logger logger = Logger
			.getLogger(ProjectExperienceServiceImpl.class);

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public List<ProjectExperienceVo> getProjectExperienceListbyProjectId(
			Long prjId) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(ProjectExperienceDto.class);
		criteria.setFetchMode("prjId", FetchMode.JOIN)
				.createAlias("prjId", "prj")
				.add(Restrictions.eq("prj.prjId", prjId));
		List<ProjectExperienceDto> projectExperienceDtos = manager
				.findByDetachedCriteria(criteria);

		List<ProjectExperienceVo> projectExperienceVos = new ArrayList<ProjectExperienceVo>();

		for (ProjectExperienceDto dto : projectExperienceDtos) {
			projectExperienceVos.add(new ProjectExperienceVo(dto));
		}
		return projectExperienceVos;

	}

	@Override
	public void createProjectExperience(ProjectExperienceVo projectExperienceVo) {

		ProjectExperienceDto projectExperienceDto = new ProjectExperienceDto();
		projectExperienceDto.setPrjId((ProjectDto) getProjectObjbyId(
				projectExperienceVo.getPrjId(), ProjectDto.class));
		projectExperienceDto.setCont(projectExperienceVo.getCont());
		String loginId = UserUtil.getUserSessionInfoVo().getUserID();

		projectExperienceDto.setCreatedBy(loginId);
		projectExperienceDto.setCreatedDte(DateUtil.formatDate(new Date()));
		manager.save(projectExperienceDto);
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
}
