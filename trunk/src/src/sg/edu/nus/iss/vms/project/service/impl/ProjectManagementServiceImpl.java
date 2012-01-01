package sg.edu.nus.iss.vms.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import sg.edu.nus.iss.vms.common.Messages;
import sg.edu.nus.iss.vms.common.SessionBean;
import sg.edu.nus.iss.vms.common.constants.VMSConstants;
import sg.edu.nus.iss.vms.common.dto.CertificateRequestDto;
import sg.edu.nus.iss.vms.common.dto.CodeDto;
import sg.edu.nus.iss.vms.common.exception.ApplicationException;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.common.util.CodeLookupUtil;
import sg.edu.nus.iss.vms.common.util.DateUtil;
import sg.edu.nus.iss.vms.common.util.StringUtil;
import sg.edu.nus.iss.vms.common.web.util.UserUtil;
import sg.edu.nus.iss.vms.project.dto.ProjectDto;
import sg.edu.nus.iss.vms.project.dto.ProjectExperienceDto;
import sg.edu.nus.iss.vms.project.dto.ProjectFeedbackDto;
import sg.edu.nus.iss.vms.project.dto.ProjectInterestDto;
import sg.edu.nus.iss.vms.project.dto.ProjectMemberDto;
import sg.edu.nus.iss.vms.project.dto.ProjectProposalDto;
import sg.edu.nus.iss.vms.project.service.ProjectManagementService;
import sg.edu.nus.iss.vms.project.vo.ProjectInfoVo;
import sg.edu.nus.iss.vms.project.vo.ProjectVo;

public class ProjectManagementServiceImpl implements ProjectManagementService {

        private Manager manager;
        private SessionBean sessionBean;
        private static Logger logger = Logger.getLogger(ProjectManagementServiceImpl.class);

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
        public List<ProjectVo> getListAllProject() {
                String userLogInId = UserUtil.getUserSessionInfoVo().getUserID();
                String hQL = "from ProjectMemberDto where usrLoginId='" + userLogInId + "'";
                List<ProjectMemberDto> projectMemberList = manager.find(hQL);
                List<ProjectVo> projectList = new ArrayList<ProjectVo>();
                for (ProjectMemberDto projectMemberDto : projectMemberList) {
                        projectList.add(getProjectVo(projectMemberDto.getPrjId()));
                }
                return projectList;
        }

        private ProjectVo getProjectVo(ProjectDto _projectVo) {
                ProjectVo project = new ProjectVo();
                project.setName(_projectVo.getNme());
                project.setDesc(_projectVo.getDesc());
                project.setPrjMgr(UserUtil.getUserSessionInfoVo().getUserID());
                project.setStrDte(DateUtil.formatDate(_projectVo.getStrDte(), DateUtil.DEFAULT_DATE_FORMAT));
                project.setEndDte(DateUtil.formatDate(_projectVo.getEndDte(), DateUtil.DEFAULT_DATE_FORMAT));
                project.setCtryCd(CodeLookupUtil.getCodeDescriptionByCodeId(_projectVo.getCtryCd()));
                project.setLoc(_projectVo.getLoc());
                project.setRmk(_projectVo.getRmk());
                project.setPrjPropId(null);
                project.setStsCd(CodeLookupUtil.getCodeDescriptionByCodeId(_projectVo.getStsCd()));
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

                        logger.debug("sssssssssssssss"
                                + DateUtil.parseDate(projectVo.getStrDte()));
                }

                if (!StringUtil.isNullOrEmpty(projectVo.getStsCd())) {
                        criteria.add(Restrictions.eq("stsCd",
                                Long.parseLong(projectVo.getStsCd())));
                }

                List<ProjectDto> projectList = manager.findByDetachedCriteria(criteria);
                return projectList;
        }

        @Override
        public Object getProjectObjbyId(long id, Class type) {
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

                DetachedCriteria criteria = DetachedCriteria.forClass(ProjectExperienceDto.class);
                criteria.add(Restrictions.eq("prjId", projectDto));
                return manager.findByDetachedCriteria(criteria);

        }

        @Override
        public void requestCertificate(CertificateRequestDto certificateRequestDto) {

                manager.save(certificateRequestDto);

        }

        @Override
        public void postProjectExperience(ProjectExperienceDto projectExperienceDto) {

                manager.save(projectExperienceDto);

        }

        @Override
        public void postProjectFeedback(ProjectFeedbackDto projectFeedbackDto) {

                manager.save(projectFeedbackDto);

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
                                projectVo.setPrjPropId(Long.toString(project.getPrjPropId().getPrjPropId()));
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
                        int currentVersion = Integer.parseInt(projectVo.getVersion());
                        project.setVersion(currentVersion + 1);
                        // Todo: have to test save after updating the "DESC" column in DB
                        manager.save(project);

                } catch (Exception ex) {
                        logger.error("Update Project", ex);
                        throw new ApplicationException(
                                Messages.getString("message.common.error.update"));
                }
        }

        @Override
        public List<ProjectFeedbackDto> getProjectFeedbackList(ProjectDto projectDto) {
                DetachedCriteria criteria = DetachedCriteria.forClass(ProjectFeedbackDto.class);
                criteria.add(Restrictions.eq("prjId", projectDto));
                return manager.findByDetachedCriteria(criteria);
        }

        @Override
        public List<ProjectFeedbackDto> getProjectFeedbackListbyVo(
                ProjectInfoVo projectInfoVo) {
                DetachedCriteria criteria = DetachedCriteria.forClass(ProjectFeedbackDto.class);
                if (!StringUtil.isNullOrEmpty(projectInfoVo.getFbTitle())) {
                        criteria.add(Restrictions.like("title", projectInfoVo.getFbTitle(),
                                MatchMode.ANYWHERE));
                }
                if (!StringUtil.isNullOrEmpty(projectInfoVo.getFbStatus())) {
                        criteria.add(Restrictions.eq("stsCd",
                                Long.parseLong(projectInfoVo.getFbStatus())));

                }

                if (!StringUtil.isNullOrEmpty(projectInfoVo.getPrjName())) {
                        criteria.setFetchMode("prjId", FetchMode.JOIN).createAlias("prjId", "prj").add(Restrictions.like("prj.nme",
                                projectInfoVo.getPrjName(), MatchMode.ANYWHERE));
                }

                return manager.findByDetachedCriteria(criteria);
        }

        @Override
        public void saveOrUpdateProjectObject(Object obj) {
                manager.save(obj);
        }

        @Override
        public List getAllProjectObjectList(Class type) {
                DetachedCriteria criteria = DetachedCriteria.forClass(type);
                return manager.findByDetachedCriteria(criteria);
        }

        @Override
        public List<ProjectProposalDto> getProjectProposalListbyVo(
                ProjectVo projectVo) {
                DetachedCriteria criteria = DetachedCriteria.forClass(ProjectProposalDto.class);
                if (!StringUtil.isNullOrEmpty(projectVo.getProposalName())) {
                        criteria.add(Restrictions.like("nme", projectVo.getProposalName(),
                                MatchMode.ANYWHERE));
                }
                if (!StringUtil.isNullOrEmpty(projectVo.getStsCd())) {
                        criteria.add(Restrictions.eq("stsCd",
                                Long.parseLong(projectVo.getStsCd())));

                }

                if (!StringUtil.isNullOrEmpty(projectVo.getName())) {
                        criteria.setFetchMode("prjId", FetchMode.JOIN).createAlias("prjId", "prj").add(Restrictions.like("prj.nme", projectVo.getName(),
                                MatchMode.ANYWHERE));
                }

                return manager.findByDetachedCriteria(criteria);
        }

        @Override
        public List<CodeDto> getProjectStatusList() {
                return CodeLookupUtil.getListOfCodeByCategory(VMSConstants.PROJECT_STATUS);
        }

        @Override
        public List<ProjectVo> listProjectbyProjectVo(ProjectVo projectVo) {
                String hQL = "from ProjectMemberDto where usrLoginId='" + UserUtil.getUserSessionInfoVo().getUserID() + "'";
                if (!StringUtil.isNullOrEmpty(projectVo.getName())) {
                        hQL += " and prjId.nme LIKE '%" + projectVo.getName() + "%'";
                }
                if (!StringUtil.isNullOrEmpty(projectVo.getStrDte())) {
                        hQL += " and prjId.strDte LIKE '" + DateUtil.parseDate(projectVo.getStrDte()) + "'";
                }
                if (!StringUtil.isNullOrEmpty(projectVo.getStsCd())) {
                        hQL += " and prjId.stsCd=" + Long.parseLong(projectVo.getStsCd());
                }
                logger.debug("Find Project By " + hQL);
                List<ProjectMemberDto> projectMemberList = manager.find(hQL);
                List<ProjectVo> projectList = new ArrayList<ProjectVo>();
                for (ProjectMemberDto projectMember : projectMemberList) {
                        projectList.add(getProjectVo(projectMember.getPrjId()));
                }
                return projectList;
        }
}
