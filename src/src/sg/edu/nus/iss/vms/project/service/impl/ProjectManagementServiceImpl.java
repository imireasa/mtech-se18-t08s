package sg.edu.nus.iss.vms.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import sg.edu.nus.iss.vms.common.SessionBean;
import sg.edu.nus.iss.vms.common.dto.CertificateRequestDto;
import sg.edu.nus.iss.vms.common.dto.CodeDto;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.common.util.DateUtil;
import sg.edu.nus.iss.vms.common.util.StringUtil;
import sg.edu.nus.iss.vms.project.dto.ProjectDto;
import sg.edu.nus.iss.vms.project.dto.ProjectExperienceDto;
import sg.edu.nus.iss.vms.project.dto.ProjectFeedbackDto;
import sg.edu.nus.iss.vms.project.dto.ProjectInterestDto;
import sg.edu.nus.iss.vms.project.dto.ProjectMemberDto;
import sg.edu.nus.iss.vms.project.service.ProjectManagementService;
import sg.edu.nus.iss.vms.project.vo.ProjectVo;

public class ProjectManagementServiceImpl implements ProjectManagementService {

	private Manager manager;
	private SessionBean sessionBean;

	private static Logger logger = Logger
			.getLogger(ProjectManagementServiceImpl.class);

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public SessionBean getSessionBean() {
		return sessionBean;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	// @Override
	// public List<Project> getListOfProject(String projectName) {
	// String hQL = "from Project where projectName LIKE '%" + projectName +
	// "%'";
	// List<Project> projectMemberList = manager.find(hQL);
	// return projectMemberList;
	// }
	//
	// @Override
	// public Project getProject(long projectId) {
	// Project project = (Project) manager.get(Project.class, projectId);
	// return project;
	// }
	//
	// @Override
	// public List<ProjectMember> getProjectMember(long projectId, String
	// memberName) {
	// String hQL = "from ProjectMember where projectId.projectId=" + projectId;
	// if (memberName != null && !memberName.isEmpty())
	// hQL += " and (volunteerId.firstName LIKE '%" + memberName + "%' " +
	// "OR volunteerId.lastName LIKE '%" + memberName + "%')";
	// List<ProjectMember> projectMemberList = manager.find(hQL);
	// return projectMemberList;
	// }
	//
	// @Override
	// public List<Project> getListAllProject() {
	// List<Project> project = manager.list(Project.class);
	// return project;
	// }
	//
	// @Override
	// public List<ProjectRole> getProjectRoleList() {
	// List<ProjectRole> projectRoleList = manager.list(ProjectRole.class);
	// return projectRoleList;
	// }
	@Override
	public List<ProjectDto> getListOfProject(String projectName) {
		List<ProjectDto> memberList = new ArrayList<ProjectDto>();
		return memberList;
	}

	@Override
	public ProjectDto getProject(long projectId) {
		return null;
	}

	@Override
	public List<ProjectMemberDto> getProjectMember(long projectId,
			String memberName) {
		return null;
	}

	@Override
	public List<ProjectDto> getListAllProject() {
		List<ProjectDto> project = manager.list(ProjectDto.class);
		return project;
	}

	@Override
	public List<ProjectDto> getProjectbyProjectVo(ProjectVo projectVo) {

		DetachedCriteria criteria = DetachedCriteria.forClass(ProjectDto.class);
		if (!StringUtil.isNullOrEmpty(projectVo.getName())) {
			criteria.add(Restrictions.like("nme", projectVo.getName(),
					MatchMode.ANYWHERE));
		}
		if (!StringUtil.isNullOrEmpty(projectVo.getStrDte())) {
			criteria.add(Restrictions.gt("strDte",
					DateUtil.parseDate(projectVo.getStrDte())));
		}

		if (!StringUtil.isNullOrEmpty(projectVo.getStsCd())) {
			criteria.add(Restrictions.eq("stsCd",
					Long.parseLong(projectVo.getStsCd())));
		}

		List<ProjectDto> projectList = manager.findByDetachedCriteria(criteria);
		return projectList;
	}

	@Override
	public ProjectDto getProjectbyId(long projectId) {
		try {
			return (ProjectDto) manager.get(ProjectDto.class, projectId);
		} catch (Exception ex) {
			this.logger.error("Data Access Error", ex);
			return null;
		} finally {
			this.logger.debug("@ Service Layer getting user 2");
		}

	}

	@Override
	public void raseInterest(ProjectInterestDto projectInterestDto) {

		manager.save(projectInterestDto);

	}

	@Override
	public List<CodeDto> getProjectRoleList() {
		return null;
	}

	@Override
	public List<ProjectExperienceDto> getProjectExperienceList(
			ProjectDto projectDto) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(ProjectExperienceDto.class);
		criteria.add(Restrictions.eq("prjId", projectDto));
		return manager.findByDetachedCriteria(criteria);

	}

	@Override
	public void requestCertificate(CertificateRequestDto certificateRequestDto) {

		manager.save(certificateRequestDto);

	}

	@Override
	public List<ProjectFeedbackDto> getProjectFeedbackList(ProjectDto projectDto) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(ProjectFeedbackDto.class);
		criteria.add(Restrictions.eq("prjId", projectDto));
		return manager.findByDetachedCriteria(criteria);

	}

	@Override
	public void postProjectExperience(ProjectExperienceDto projectExperienceDto) {

		manager.save(projectExperienceDto);

	}

	@Override
	public void postProjectFeedback(ProjectFeedbackDto projectFeedbackDto) {

		manager.save(projectFeedbackDto);

	}
}
