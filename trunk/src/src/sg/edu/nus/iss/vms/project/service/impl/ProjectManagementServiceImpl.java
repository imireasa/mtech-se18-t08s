package sg.edu.nus.iss.vms.project.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import sg.edu.nus.iss.vms.common.Messages;
import sg.edu.nus.iss.vms.common.SysConfig;
import sg.edu.nus.iss.vms.common.constants.VMSConstants;
import sg.edu.nus.iss.vms.common.dto.CertificateRequestDto;
import sg.edu.nus.iss.vms.common.exception.ApplicationException;
import sg.edu.nus.iss.vms.common.mail.BasicMailMessage;
import sg.edu.nus.iss.vms.common.mail.MailSenderUtil;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.common.util.CodeLookupUtil;
import sg.edu.nus.iss.vms.common.util.DateUtil;
import sg.edu.nus.iss.vms.common.util.StringUtil;
import sg.edu.nus.iss.vms.common.web.util.UserUtil;
import sg.edu.nus.iss.vms.project.dto.ProjectDto;
import sg.edu.nus.iss.vms.project.dto.ProjectMemberDto;
import sg.edu.nus.iss.vms.project.service.ProjectManagementService;
import sg.edu.nus.iss.vms.project.vo.ProjectMemberVo;
import sg.edu.nus.iss.vms.project.vo.ProjectVo;
import sg.edu.nus.iss.vms.security.dto.UserDto;

public class ProjectManagementServiceImpl implements ProjectManagementService {

	private Manager manager;
	// private SessionBean sessionBean;
	private static Logger logger = Logger
			.getLogger(ProjectManagementServiceImpl.class);

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public List<ProjectVo> getListAllProject() {
		String hQL = "from ProjectDto where prjMgr='"
				+ UserUtil.getUserSessionInfoVo().getUserID() + "'";
		List<ProjectDto> projectDtoList = manager.find(hQL);
		List<ProjectVo> projectList = new ArrayList<ProjectVo>();
		for (ProjectDto projectDto : projectDtoList) {
			projectList.add(new ProjectVo(projectDto));
		}
		return projectList;
	}

	@Override
	public ProjectVo getProjectVoByLoginUserAccessRight(Long projectId) {
		ProjectVo projectVo = new ProjectVo();
		ProjectDto projectDto = (ProjectDto) manager.get(ProjectDto.class,
				projectId);
		projectVo = new ProjectVo(projectDto);

		List<ProjectMemberVo> memberVoList = new ArrayList<ProjectMemberVo>();
		String hQL = "from ProjectMemberDto where prjId.prjId=" + projectId
				+ " and actInd=1";
		List<ProjectMemberDto> _projectMemberList = manager.find(hQL);
		for (ProjectMemberDto _projectMemberDto : _projectMemberList) {
			ProjectMemberVo memberVo = new ProjectMemberVo();
			memberVo.setPrjId(_projectMemberDto.getPrjId().getPrjId());
			memberVo.setPrjMbrId(_projectMemberDto.getPrjMbrId());
			memberVo.setRoleCd(_projectMemberDto.getRoleCd() + "");
			memberVo.setRole(CodeLookupUtil
					.getCodeDescriptionByCodeId(_projectMemberDto.getRoleCd()));
			memberVo.setVersion(_projectMemberDto.getVersion());
			List<UserDto> userList = manager
					.find("from UserDto where usrLoginId='"
							+ _projectMemberDto.getUsrLoginId() + "'");
			if (userList != null && !userList.isEmpty()) {
				memberVo.setNme(userList.get(0).getNme());
				memberVo.setEmail(userList.get(0).getEmail());
				memberVo.setMobile(userList.get(0).getMobile());
				memberVo.setTitleCd(userList.get(0).getTitleCd());
				memberVo.setTitle(CodeLookupUtil
						.getCodeDescriptionByCodeId(userList.get(0)
								.getTitleCd()));
				memberVo.setCtry(CodeLookupUtil
						.getCodeDescriptionByCodeId(userList.get(0).getCtryCd()));
			}
			memberVoList.add(memberVo);
		}
		projectVo.setProjectMemberVo(memberVoList);
		return projectVo;
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
	public ProjectVo getProjectbyId(long id) {
		try {
			ProjectDto projectDto = (ProjectDto) manager.get(ProjectDto.class,
					id);

			return new ProjectVo(projectDto);
		} catch (Exception ex) {
			this.logger.error("Data Access Error", ex);
			return null;
		} finally {
			this.logger.debug("@ Service Layer getting user 2");
		}

	}

	// Thida
	@Override
	public ProjectVo getProjectVoById(Long projectId) {

		ProjectDto project = null;
		project = (ProjectDto) manager.get(ProjectDto.class, projectId);

		ProjectVo projectVo = new ProjectVo();
		if (project != null) {
			projectVo.setPrjId(project.getPrjId());
			projectVo.setPrjIdDisplayed(project.getPrjId());
			projectVo.setName(project.getNme());
			projectVo.setDesc(project.getDesc());
			projectVo.setPrjMgr(project.getPrjMgr());
			projectVo.setStrDte(DateUtil.formatDate(project.getStrDte()));
			projectVo.setEndDte(DateUtil.formatDate(project.getEndDte()));
			projectVo.setCtryCd(Long.toString(project.getCtryCd()));
			projectVo.setLoc(project.getLoc());
			projectVo.setRmk(project.getRmk());
			if (project.getPrjPropId() != null) {
				projectVo.setPrjPropId(Long.toString(project.getPrjPropId()
						.getPrjPropId()));
			} else {
				projectVo.setPrjPropId("0");
			}
			projectVo.setStsCd(Long.toString(project.getStsCd()));
			projectVo.setVersion(Integer.toString(project.getVersion()));
		}
		return projectVo;
	}

	@Override
	public void saveProject(ProjectVo projectVo) throws Exception {
		try {
			ProjectDto project = new ProjectDto();
			project.setNme(projectVo.getName());
			project.setDesc(projectVo.getDesc());
			project.setPrjMgr(UserUtil.getUserSessionInfoVo().getUserID());
			project.setStrDte(DateUtil.parseDate(projectVo.getStrDte()));
			project.setEndDte(DateUtil.parseDate(projectVo.getEndDte()));
			project.setCtryCd(Long.parseLong(projectVo.getCtryCd()));
			project.setLoc(projectVo.getLoc());
			project.setRmk(projectVo.getRmk());
			project.setPrjPropId(null);
			project.setStsCd(Long.parseLong(projectVo.getStsCd()));
			project.setCreatedBy(UserUtil.getUserSessionInfoVo().getUserID());
			project.setCreatedDte(DateUtil.getDate());
			project.setUpdBy(UserUtil.getUserSessionInfoVo().getUserID());
			project.setUpdDte(DateUtil.getDate());
			project.setVersion(1);
			manager.save(project);

		} catch (Exception ex) {
			logger.error("Save Project", ex);
			throw new ApplicationException(
					Messages.getString("message.common.error.save"));
		}
	}

	@Override
	public void updateProject(ProjectVo projectVo) throws Exception {
		try {
			ProjectDto project = null;
			String hQL = "from ProjectDto where prjId = "
					+ projectVo.getPrjId();
			List<ProjectDto> projectList = manager.find(hQL);
			if (projectList != null && !projectList.isEmpty()) {
				project = projectList.get(0);

			} else {
				throw new ApplicationException(
						Messages.getString("message.common.error.update"));
			}
			project.setNme(projectVo.getName());
			project.setDesc(projectVo.getDesc());
			project.setStrDte(DateUtil.parseDate(projectVo.getStrDte()));
			project.setEndDte(DateUtil.parseDate(projectVo.getEndDte()));
			project.setCtryCd(Long.parseLong(projectVo.getCtryCd()));
			project.setLoc(projectVo.getLoc());
			project.setRmk(projectVo.getRmk());
			project.setStsCd(Long.parseLong(projectVo.getStsCd()));
			project.setUpdBy(UserUtil.getUserSessionInfoVo().getUserID());
			project.setUpdDte(DateUtil.getDate());
			manager.save(project);

		} catch (Exception ex) {
			logger.error("Update Project", ex);
			throw new ApplicationException(
					Messages.getString("message.common.error.update"));
		}
	}

	@Override
	public List<ProjectVo> getProjectListbyProjectVo(ProjectVo projectVo) {

		Date startDate = DateUtil.parseDate(projectVo.getStrDte());
		String hQL = "from ProjectDto where prjMgr='"
				+ UserUtil.getUserSessionInfoVo().getUserID() + "'";

		if (!StringUtil.isNullOrEmpty(projectVo.getName())) {
			hQL += " and prjId.nme LIKE '%" + projectVo.getName() + "%'";
		}
		if (!StringUtil.isNullOrEmpty(projectVo.getStsCd())) {
			hQL += " and prjId.stsCd=" + Long.parseLong(projectVo.getStsCd());
		}
		if (!StringUtil.isNullOrEmpty(projectVo.getStrDte())) {
			hQL += " and prjId.strDte BETWEEN '"
					+ DateUtil.getMonthStartDate(startDate) + "' AND '"
					+ DateUtil.getMonthEndDate(startDate) + "'";
		}
		logger.debug("Find Project By " + hQL);

		List<ProjectDto> projectDtoList = manager.find(hQL);
		List<ProjectVo> projectList = new ArrayList<ProjectVo>();
		for (ProjectDto projectDto : projectDtoList) {
			projectList.add(new ProjectVo(projectDto));
		}
		return projectList;
	}

	@Override
	public List<ProjectMemberDto> getProjectMember(long projectId) {
		String hQL = "from ProjectMemberDto where prjId=" + projectId;
		List<ProjectMemberDto> projMemList = manager.find(hQL);
		return projMemList;
	}

	public List<ProjectVo> getProjectsbyProjectVo(ProjectVo projectVo) {

		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(ProjectDto.class);
		if (!StringUtil.isNullOrEmpty(projectVo.getName())) {

			detachedCriteria.add(Restrictions.eq("nme", projectVo.getName()));
		}
		if (!StringUtil.isNullOrEmpty(projectVo.getStsCd())) {

			detachedCriteria
					.add(Restrictions.eq("stsCd", projectVo.getStsCd()));

		}
		if (!StringUtil.isNullOrEmpty(projectVo.getStrDte())) {
			detachedCriteria.add(Restrictions.gt("strDte",
					DateUtil.parseDate(projectVo.getStrDte())));

		}

		List<ProjectDto> projectDtoList = manager
				.findByDetachedCriteria(detachedCriteria);
		List<ProjectVo> projectList = new ArrayList<ProjectVo>();
		for (ProjectDto projectDto : projectDtoList) {
			projectList.add(new ProjectVo(projectDto));
		}
		return projectList;
	}

}
