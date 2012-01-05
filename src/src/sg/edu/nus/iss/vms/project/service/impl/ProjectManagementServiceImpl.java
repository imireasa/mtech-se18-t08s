package sg.edu.nus.iss.vms.project.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
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
import sg.edu.nus.iss.vms.common.mail.BasicMailMessage;
import sg.edu.nus.iss.vms.common.mail.MailSenderUtil;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.common.util.CodeLookupUtil;
import sg.edu.nus.iss.vms.common.util.DateUtil;
import sg.edu.nus.iss.vms.common.util.RamdomPasswordGeneratorUtil;
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
import sg.edu.nus.iss.vms.project.vo.ProjectInterestSearchVo;
import sg.edu.nus.iss.vms.project.vo.ProjectInterestVo;
import sg.edu.nus.iss.vms.project.vo.ProjectMemberVo;
import sg.edu.nus.iss.vms.project.vo.ProjectProposalVo;
import sg.edu.nus.iss.vms.project.vo.ProjectVo;
import sg.edu.nus.iss.vms.security.dto.UserDto;

public class ProjectManagementServiceImpl implements ProjectManagementService {

    private Manager manager;
    private SessionBean sessionBean;
    private static Logger logger = Logger.getLogger(ProjectManagementServiceImpl.class);
    private MailSenderUtil mailSenderUtil;

    public MailSenderUtil getMailSenderUtil() {
        return mailSenderUtil;
    }

    public void setMailSenderUtil(MailSenderUtil mailSenderUtil) {
        this.mailSenderUtil = mailSenderUtil;
    }

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
        String hQL = "from ProjectDto where prjId = " + projectId;
        List<ProjectDto> projectList = manager.find(hQL);
        ProjectDto project = null;

        if (projectList != null && !projectList.isEmpty()) {
            project = projectList.get(0);
        }

        return project;
    }

    @Override
    public List<ProjectMemberDto> getProjectMember(long projectId,
            String memberName) {
        return null;
    }

    @Override
    public List<ProjectVo> getListAllProject() {
        String userLogInId = UserUtil.getUserSessionInfoVo().getUserID();
        String hQL = "from ProjectMemberDto where usrLoginId='" + userLogInId
                + "' and actInd=1";
        List<ProjectMemberDto> projectMemberList = manager.find(hQL);
        List<ProjectVo> projectList = new ArrayList<ProjectVo>();
        for (ProjectMemberDto projectMemberDto : projectMemberList) {
            projectList.add(getProjectVo(projectMemberDto.getPrjId()));
        }
        return projectList;
    }

    @Override
    public ProjectVo getProjectVoByLoginUserAccessRight(Long projectId) {
        ProjectVo projectVo = new ProjectVo();
        String userLogInId = UserUtil.getUserSessionInfoVo().getUserID();
        String hQL = "from ProjectMemberDto where usrLoginId='" + userLogInId
                + "'" + " and actInd=1" + " and prjId.prjId=" + projectId;

        List<ProjectMemberDto> projectMemberList = manager.find(hQL);
        for (ProjectMemberDto projectMemberDto : projectMemberList) {

            projectVo = getProjectVo(projectMemberDto.getPrjId());

            List<ProjectMemberVo> memberVoList = new ArrayList<ProjectMemberVo>();
            hQL = "from ProjectMemberDto where prjId.prjId=" + projectId
                    + " and actInd=1";
            List<ProjectMemberDto> _projectMemberList = manager.find(hQL);
            for (ProjectMemberDto _projectMemberDto : _projectMemberList) {
                ProjectMemberVo memberVo = new ProjectMemberVo();
                memberVo.setPrjId(_projectMemberDto.getPrjId().getPrjId());
                memberVo.setPrjMbrId(_projectMemberDto.getPrjMbrId());
                memberVo.setRoleCd(_projectMemberDto.getRoleCd() + "");
                memberVo.setRole(CodeLookupUtil.getCodeDescriptionByCodeId(_projectMemberDto.getRoleCd()));
                memberVo.setVersion(_projectMemberDto.getVersion());
                List<UserDto> userList = manager.find("from UserDto where usrLoginId='"
                        + _projectMemberDto.getUsrLoginId() + "'");
                if (userList != null && !userList.isEmpty()) {
                    memberVo.setNme(userList.get(0).getNme());
                    memberVo.setEmail(userList.get(0).getEmail());
                    memberVo.setMobile(userList.get(0).getMobile());
                    memberVo.setTitleCd(userList.get(0).getTitleCd());
                    memberVo.setTitle(CodeLookupUtil.getCodeDescriptionByCodeId(userList.get(0).getTitleCd()));
                    memberVo.setCtry(CodeLookupUtil.getCodeDescriptionByCodeId(userList.get(0).getCtryCd()));
                }
                memberVoList.add(memberVo);
            }
            projectVo.setProjectMemberVo(memberVoList);
            break;
        }
        return projectVo;
    }

    @Override
    public List<ProjectInterestVo> getProjectIntrestVoByLoginUserAccessRight(
            Long projectId) {
        String userLogInId = UserUtil.getUserSessionInfoVo().getUserID();

        String hQL = "from ProjectInterestDto where prjId.prjId="
                + projectId
                + " and stsCd="
                + CodeLookupUtil.getCodeByCategoryAndCodeValue(
                VMSConstants.PROJECT_INTREST_STATUS,
                VMSConstants.PROJECT_INTEREST_NEW).getCdId();
        List<ProjectInterestVo> projectInterestVoList = new ArrayList<ProjectInterestVo>();
        List<ProjectInterestDto> projectInterestList = manager.find(hQL);
        for (ProjectInterestDto projectInterest : projectInterestList) {
            ProjectInterestVo projectInterestVo = new ProjectInterestVo();
            projectInterestVo.setPrjIntrstId(projectInterest.getPrjIntrstId());
            projectInterestVo.setReqBy(projectInterest.getReqBy());

            List<UserDto> userList = manager.find("from UserDto where usrLoginId='"
                    + projectInterest.getReqBy() + "'");
            if (userList != null && !userList.isEmpty()) {
                projectInterestVo.setReqByNme(userList.get(0).getNme());
                projectInterestVo.setReqByTitle(CodeLookupUtil.getCodeDescriptionByCodeId(userList.get(0).getTitleCd()));
                projectInterestVo.setReqByCtry(CodeLookupUtil.getCodeDescriptionByCodeId(userList.get(0).getCtryCd()));
            }

            projectInterestVo.setApprBy(projectInterest.getApprBy());
            projectInterestVo.setApprDte(projectInterest.getApprDte());
            projectInterestVo.setSts(CodeLookupUtil.getCodeDescriptionByCodeId(projectInterest.getStsCd()));
            projectInterestVo.setStsCd(projectInterest.getStsCd());
            projectInterestVoList.add(projectInterestVo);
        }
        return projectInterestVoList;
    }

    @Override
    public void deleteProjectMemberByProjectMemberId(String projectMemberId)
            throws Exception {
        try {
            Long _projectMemberId = Long.parseLong(projectMemberId);
            ProjectMemberDto dto = (ProjectMemberDto) manager.get(
                    ProjectMemberDto.class, _projectMemberId);
            dto.setActInd(false);
            manager.save(dto);

        } catch (Exception ex) {
            logger.debug("Delete Project Member Fail.", ex);
            throw new ApplicationException(
                    Messages.getString("message.common.error.remove"));
        }
    }

    @Override
    public void requestProjectCertificateByProjectId(Long projectId)
            throws Exception {
        // TODO: Implement requestProjectCertificateByProjectId

        Long newRequest = CodeLookupUtil.getCodeDtoByCatVal(VMSConstants.CERTIFIATE_REQUEST_TYPE, VMSConstants.CERTIFICATE_REQUEST_TYPE_PROJECT).getCdId();
        Long requestd = CodeLookupUtil.getCodeDtoByCatVal(VMSConstants.CERTIFICATE_REQUEST_STATUS, VMSConstants.CERTIFICATE_REQUEST_STATUS_REQUESTED).getCdId();

        String hQL = "from CertificateRequestDto where prjId=" + projectId
                + " and reqTp=" + newRequest + " and reqSts=" + requestd;

        List<CertificateRequestDto> certificateRequestDtos = manager.find(hQL);
        if (certificateRequestDtos != null && !certificateRequestDtos.isEmpty()) {
            throw new ApplicationException(Messages.getString(hQL));
        }

        ProjectDto projectDto = (ProjectDto) manager.get(ProjectDto.class, projectId);



    }

    @Override
    public void updateProjectMemberRoleByProjectMemberIdnRole(
            String projectMemberId, Long roleCd) throws Exception {
        try {
            Long _projectMemberId = Long.parseLong(projectMemberId);
            ProjectMemberDto dto = (ProjectMemberDto) manager.get(
                    ProjectMemberDto.class, _projectMemberId);
            dto.setRoleCd(roleCd);
            manager.save(dto);

        } catch (Exception ex) {
            logger.debug("Delete Project Member Fail.", ex);
            throw new ApplicationException(
                    Messages.getString("message.common.error.remove"));
        }
    }

    @Override
    public void sendInviteProjectMemberToAllUser(Long projectId, Long userStatus)
            throws Exception {
        String hQL = "from UserDto where " + "tpCd='TODO'";

        List<UserDto> userDtos = manager.find(hQL);
        for (UserDto dto : userDtos) {
            if (false) {
                try {
                    String toEmail = "";
                    String toName = "";
                    String subject = "";
                    BasicMailMessage bmm = new BasicMailMessage();
                    bmm.setSubject(subject);
                    bmm.setTo(toEmail);

                    Map props = new HashMap();
                    props.put("name", toName);
                    props.put("password",
                            RamdomPasswordGeneratorUtil.getPassword(6));
                    mailSenderUtil.send(bmm, "forgotPasswordMail.vm", props);
                } catch (Exception ex) {
                    logger.error("send mail error", ex);
                }
            }
        }
    }

    @Override
    public void acceptProjectIntrest(Long prjIntrstId) throws Exception {
        ProjectInterestDto projectInterestDto = (ProjectInterestDto) manager.get(ProjectInterestDto.class, prjIntrstId);
        if (projectInterestDto != null) {
            throw new ApplicationException(
                    Messages.getString("message.projectManagement.error.invalidProjectInterest"));
        }

        String hQL = "from ProjectMemberDto where " + "prjId.prjId="
                + projectInterestDto + " and usrLoginId='"
                + projectInterestDto.getReqBy();
        List<ProjectMemberDto> projectMemberDtos = manager.find(hQL);
        if (projectMemberDtos == null || projectMemberDtos.isEmpty()) {
            ProjectMemberDto projectMemberDto = new ProjectMemberDto();
            projectMemberDto.setPrjId(projectInterestDto.getPrjId());
            projectMemberDto.setRoleCd(CodeLookupUtil.getCodeDtoByCatVal(
                    VMSConstants.MEMBER_ROLE, VMSConstants.PROJECT_ROLE_MEMBER).getCdId());
            projectMemberDto.setUsrLoginId(projectInterestDto.getReqBy());

        }
    }

    private ProjectVo getProjectVo(ProjectDto _projectVo) {
        ProjectVo project = new ProjectVo();
        project.setPrjId(_projectVo.getPrjId());
        project.setName(_projectVo.getNme());
        project.setDesc(_projectVo.getDesc());
        project.setPrjMgr(UserUtil.getUserSessionInfoVo().getUserID());
        project.setStrDte(DateUtil.formatDate(_projectVo.getStrDte(),
                DateUtil.DEFAULT_DATE_FORMAT));
        project.setEndDte(DateUtil.formatDate(_projectVo.getEndDte(),
                DateUtil.DEFAULT_DATE_FORMAT));
        project.setCtryCd(_projectVo.getCtryCd() + "");
        project.setCtry(CodeLookupUtil.getCodeDescriptionByCodeId(_projectVo.getCtryCd()));
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
        CodeDto codeDto = CodeLookupUtil.getCodeByCategoryAndCodeValue(
                VMSConstants.FEEDBACK_STATUS,
                VMSConstants.FEEDBACK_STATUS_APPROVED);
        DetachedCriteria criteria = DetachedCriteria.forClass(ProjectFeedbackDto.class);
        criteria.add(Restrictions.eq("prjId", projectDto));
        criteria.add(Restrictions.eq("stsCd", codeDto.getCdId()));
        return manager.findByDetachedCriteria(criteria);
    }

    @Override
    public List<ProjectFeedbackDto> getProjectFeedbackListbyVo(
            ProjectInfoVo projectInfoVo) {
        DetachedCriteria criteria = DetachedCriteria.forClass(ProjectFeedbackDto.class);

        if (!StringUtil.isNullOrEmpty(projectInfoVo.getPrjId())) {

            Object projectDto = getProjectObjbyId(
                    Long.parseLong(projectInfoVo.getPrjId()), ProjectDto.class);
            criteria.add(Restrictions.eq("prjId", projectDto));
        }
        if (!StringUtil.isNullOrEmpty(projectInfoVo.getFbTitle())) {
            criteria.add(Restrictions.like("title", projectInfoVo.getFbTitle(),
                    MatchMode.ANYWHERE));
        }
        if (!StringUtil.isNullOrEmpty(projectInfoVo.getFbStatus())) {

            List<CodeDto> codeDtos = CodeLookupUtil.getListOfCodeByCategory(VMSConstants.FEEDBACK_STATUS);
            for (CodeDto codeDto : codeDtos) {

                if (codeDto.getVal().equals(projectInfoVo.getFbStatus())) {
                    criteria.add(Restrictions.eq("stsCd", codeDto.getCdId()));
                }
            }

        }

        if (!StringUtil.isNullOrEmpty(projectInfoVo.getPrjName())) {
            criteria.setFetchMode("prjId", FetchMode.JOIN).createAlias("prjId", "prj").add(Restrictions.like("prj.nme",
                    projectInfoVo.getPrjName(), MatchMode.ANYWHERE));
        }

        return manager.findByDetachedCriteria(criteria);
    }

    @Override
    public ProjectFeedbackDto getProjectFeedbackbyId(long projectFbId) {
        try {
            return (ProjectFeedbackDto) manager.get(ProjectFeedbackDto.class,
                    projectFbId);
        } catch (Exception ex) {
            this.logger.error("Data Access Error", ex);
            return null;
        } finally {
            this.logger.debug("@ Service Layer getting user 2");
        }

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
            ProjectProposalVo proposalVo) {
        DetachedCriteria criteria = DetachedCriteria.forClass(ProjectProposalDto.class);
        if (!StringUtil.isNullOrEmpty(proposalVo.getName())) {
            criteria.add(Restrictions.like("nme", proposalVo.getName(),
                    MatchMode.ANYWHERE));
        }
        if (!StringUtil.isNullOrEmpty(proposalVo.getStatus())) {

            List<CodeDto> codeDtos = CodeLookupUtil.getListOfCodeByCategory(VMSConstants.PROPOSAL_STATUS);
            for (CodeDto codeDto : codeDtos) {

                if (codeDto.getVal().equals(proposalVo.getStatus())) {
                    criteria.add(Restrictions.eq("stsCd", codeDto.getCdId()));
                }
            }

        }

        return manager.findByDetachedCriteria(criteria);
    }

    @Override
    public List<CodeDto> getProjectStatusList() {
        return CodeLookupUtil.getListOfCodeByCategory(VMSConstants.PROJECT_STATUS);
    }

    @Override
    public List<ProjectVo> listProjectbyProjectVo(ProjectVo projectVo) {
        String hQL = "from ProjectMemberDto where usrLoginId=' and actInd=1"
                + UserUtil.getUserSessionInfoVo().getUserID() + "'";
        if (!StringUtil.isNullOrEmpty(projectVo.getName())) {
            hQL += " and prjId.nme LIKE '%" + projectVo.getName() + "%'";
        }
        if (!StringUtil.isNullOrEmpty(projectVo.getStrDte())) {
            hQL += " and prjId.strDte LIKE '"
                    + DateUtil.parseDate(projectVo.getStrDte()) + "'";
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

    @Override
    public List<ProjectInterestDto> getProjectInterestListbyProject(
            ProjectDto projectDto, String userId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(ProjectInterestDto.class);
        criteria.add(Restrictions.eq("prjId", projectDto)).add(
                Restrictions.eq("reqBy", userId));
        return manager.findByDetachedCriteria(criteria);
    }

    @Override
    public List<CertificateRequestDto> getCertificateRequestsbyProject(
            Long prjId, String userId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(ProjectInterestDto.class);
        criteria.add(Restrictions.eq("prjId", prjId)).add(
                Restrictions.eq("reqBy", userId));
        return manager.findByDetachedCriteria(criteria);
    }

    @Override
    public List<CodeDto> getProjectInterestStatusList() {
        return CodeLookupUtil.getListOfCodeByCategory(VMSConstants.PROJECT_INTREST_STATUS);
    }

    @Override
    public List<ProjectInterestVo> getProjectInterestListByUser() {
        String hQL = "from ProjectInterestDto";
        logger.debug("Find Project Interest By User" + hQL);
        List<ProjectInterestDto> projInterestList = manager.find(hQL);
        List<ProjectInterestVo> projIntrestVoList = new ArrayList<ProjectInterestVo>();
        return projIntrestVoList;
    }

    @Override
    public List<CodeDto> getProjectInterestStatusList2() {
        return CodeLookupUtil.getListOfCodeByCategory(VMSConstants.PROJECT_INTREST_STATUS);
    }

    @Override
    public List<ProjectInterestVo> getProjectInterestListByUserWithSearch(
            ProjectInterestSearchVo searchVo) {
        String hQL = "from ProjectInterestDto where reqBy='"
                + UserUtil.getUserSessionInfoVo().getUserID() + "'";
        if (!StringUtil.isNullOrEmpty(searchVo.getProjNme())) {
            hQL += " and prjId.nme LIKE '%" + searchVo.getProjNme() + "%'";
        }
        if (searchVo.getPrjId() != null) {
            hQL += " and prjId.prjId =" + searchVo.getPrjId();
        }
        if (!StringUtil.isNullOrEmpty(searchVo.getPrjIntStatus())) {
            hQL += " and stsCd=" + Long.parseLong(searchVo.getPrjIntStatus());
        }
        logger.debug("Find Project By " + hQL);
        List<ProjectInterestDto> projIntDtoList = manager.find(hQL);

        return changeProjectInterestDtoToVo(projIntDtoList);
    }

    @Override
    public List<ProjectInterestVo> getProjectInterestListByUserLoginId() {
        String hQL = "from ProjectInterestDto where reqBy='"
                + UserUtil.getUserSessionInfoVo().getUserID() + "'";

        List<ProjectInterestDto> projIntDtoList = manager.find(hQL);

        return changeProjectInterestDtoToVo(projIntDtoList);
    }

    private List<ProjectInterestVo> changeProjectInterestDtoToVo(List dtoList) {

        List projIntVoList = new ArrayList();
        if (dtoList != null) {
            for (int i = 0; i < dtoList.size(); i++) {
                ProjectInterestDto obj = (ProjectInterestDto) dtoList.get(i);
                ProjectInterestVo objVo = new ProjectInterestVo();
                objVo.setPrjIntrstId(obj.getPrjIntrstId());
                objVo.setPrjId(obj.getPrjId().getPrjId());
                objVo.setPrjName(obj.getPrjId().getNme());
                objVo.setPrjStartDate(obj.getPrjId().getStrDte());
                objVo.setReqBy(obj.getReqBy());
                objVo.setApprBy(obj.getApprBy());
                objVo.setApprDte(obj.getApprDte());
                objVo.setApprRmk(obj.getApprRmk());
                objVo.setStsCD(obj.getStsCd());
                objVo.setStsVal(CodeLookupUtil.getCodeValueByCodeId(obj.getStsCd()));
                objVo.setCreatedBy(obj.getCreatedBy());
                objVo.setCreatedDate(obj.getCreatedDte());
                objVo.setUpdBy(obj.getUpdBy());
                objVo.setUpdDate(obj.getUpdDte());
                objVo.setVersion(obj.getVersion());
                projIntVoList.add(objVo);

            }
        }
        return projIntVoList;
    }

    @Override
    public List<ProjectInterestVo> getProjectInterestListByUser(Long prjId,
            String userId) {
        // TODO Auto-generated method stub
        return null;
    }
}
