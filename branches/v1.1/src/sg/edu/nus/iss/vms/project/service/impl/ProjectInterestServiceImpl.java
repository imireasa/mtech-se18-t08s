package sg.edu.nus.iss.vms.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import sg.edu.nus.iss.vms.common.Messages;
import sg.edu.nus.iss.vms.common.constants.VMSConstants;
import sg.edu.nus.iss.vms.common.dto.CodeDto;
import sg.edu.nus.iss.vms.common.exception.ApplicationException;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.common.util.CodeLookupUtil;
import sg.edu.nus.iss.vms.common.util.StringUtil;
import sg.edu.nus.iss.vms.common.vo.CodeLookupVo;
import sg.edu.nus.iss.vms.common.web.util.UserUtil;
import sg.edu.nus.iss.vms.member.service.MemberManagementService;
import sg.edu.nus.iss.vms.project.dto.ProjectDto;
import sg.edu.nus.iss.vms.project.dto.ProjectInterestDto;
import sg.edu.nus.iss.vms.project.dto.ProjectMemberDto;
import sg.edu.nus.iss.vms.project.service.ProjectInterestService;
import sg.edu.nus.iss.vms.project.vo.ProjectInterestSearchVo;
import sg.edu.nus.iss.vms.project.vo.ProjectInterestVo;
import sg.edu.nus.iss.vms.security.dto.UserDto;

public class ProjectInterestServiceImpl implements ProjectInterestService {

	private Manager manager;
        private MemberManagementService memberManagementService;
	private static Logger logger = Logger
			.getLogger(ProjectInterestServiceImpl.class);

        public MemberManagementService getMemberManagementService() {
            return memberManagementService;
        }

        public void setMemberManagementService(MemberManagementService memberManagementService) {
            this.memberManagementService = memberManagementService;
        }
        
	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public void updateProjectInterest(ProjectInterestVo projectInterestVo)
			throws Exception {

		ProjectInterestDto projectInterestDto = (ProjectInterestDto) manager
				.get(ProjectInterestDto.class,
						projectInterestVo.getPrjIntrstId());
		if (projectInterestDto == null) {
			throw new ApplicationException(
					Messages.getString("message.projectManagement.error.invalidProjectInterest"));
		}

		projectInterestDto.setStsCd(projectInterestVo.getStsCd());
		projectInterestDto.setApprBy(UserUtil.getUserSessionInfoVo()
				.getUserID());

                ProjectMemberDto projectMemberDto = null;

                CodeLookupVo codeAccept = CodeLookupUtil.
                            getCodeByCategoryAndCodeValue(
                            VMSConstants.PROJECT_INTREST_STATUS, VMSConstants.PROJECT_INTEREST_APPROVED);
                
                String hQL = "from ProjectMemberDto where prjId=" + projectInterestDto.getPrjId().getPrjId()
                        + " and usrLoginId='" + projectInterestDto.getReqBy() + "'";
		List<ProjectMemberDto> projMemList = manager.find(hQL);
                if(projMemList!= null && !projMemList.isEmpty()){
                    projectMemberDto = projMemList.get(0);
                }else if(codeAccept.getCdId().longValue()==projectInterestVo.getStsCd().longValue()){
                    CodeLookupVo codeMemberRole = CodeLookupUtil.
                            getCodeByCategoryAndCodeValue(
                            VMSConstants.PROJECT_ROLE_CATEGORY, VMSConstants.PROJECT_ROLE_MEMBER);

                    projectMemberDto = new ProjectMemberDto();
                    projectMemberDto.setPrjId(projectInterestDto.getPrjId());
                    projectMemberDto.setRoleCd(codeMemberRole.getCdId());
                    projectMemberDto.setUsrLoginId(projectInterestDto.getReqBy());
                }
                
                if(codeAccept.getCdId().longValue()==projectInterestVo.getStsCd().longValue())
                    projectMemberDto.setActInd(true);
                else
                    projectMemberDto.setActInd(false);

                manager.save(projectMemberDto);
		manager.save(projectInterestDto);
	}

	@Override
	public List<ProjectInterestVo> getProjectIntrestByProjectId(Long projectId) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(ProjectInterestDto.class);
		criteria.setFetchMode("prjId", FetchMode.JOIN)
				.createAlias("prjId", "prj")
				.add(Restrictions.eq("prj.prjId", projectId));

		List<ProjectInterestVo> projectInterestVoList = new ArrayList<ProjectInterestVo>();
		List<ProjectInterestDto> projectInterestList = manager
				.findByDetachedCriteria(criteria);

		for (ProjectInterestDto projectInterest : projectInterestList) {
			ProjectInterestVo projectInterestVo = new ProjectInterestVo(
					projectInterest);

			List<UserDto> userList = manager
					.find("from UserDto where usrLoginId='"
							+ projectInterest.getReqBy() + "'");
			if (userList != null && !userList.isEmpty()) {
				projectInterestVo.setReqByNme(userList.get(0).getNme());
				projectInterestVo.setReqByTitle(CodeLookupUtil
						.getCodeDescriptionByCodeId(userList.get(0)
								.getTitleCd()));
				projectInterestVo
						.setReqByCtry(CodeLookupUtil
								.getCodeDescriptionByCodeId(userList.get(0)
										.getCtryCd()));
			}

			projectInterestVo.setApprBy(projectInterest.getApprBy());
			projectInterestVo.setApprDte(projectInterest.getApprDte());
			projectInterestVo.setStsVal(CodeLookupUtil
					.getCodeDescriptionByCodeId(projectInterest.getStsCd()));
			projectInterestVo.setStsCd(projectInterest.getStsCd());
			projectInterestVoList.add(projectInterestVo);
		}
		return projectInterestVoList;
	}

	@Override
	public List<ProjectInterestVo> getProjectInterestListbyProjectIdAndUserId(
			Long prjId, String userId) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(ProjectInterestDto.class);
		criteria.setFetchMode("prjId", FetchMode.JOIN)
				.createAlias("prjId", "prj")
				.add(Restrictions.eq("prj.prjId", prjId))
				.add(Restrictions.eq("reqBy", userId));
		List<ProjectInterestDto> projectInterestDtos = manager
				.findByDetachedCriteria(criteria);

		List<ProjectInterestVo> projectInterestVos = new ArrayList<ProjectInterestVo>();

		for (ProjectInterestDto dto : projectInterestDtos) {
			projectInterestVos.add(new ProjectInterestVo(dto));
		}

		return projectInterestVos;
	}

	public List<ProjectInterestVo> getProjectInterestListByUser() {
		String hQL = "from ProjectInterestDto";
		logger.debug("Find Project Interest By User" + hQL);
		List<ProjectInterestDto> projInterestList = manager.find(hQL);
		List<ProjectInterestVo> projIntrestVoList = new ArrayList<ProjectInterestVo>();
		return projIntrestVoList;
	}

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

	@Override
	public ProjectInterestVo getProjectInterestbyId(Long id) {
		try {
			ProjectInterestDto projectInterestDto = (ProjectInterestDto) manager
					.get(ProjectInterestDto.class, id);

			return new ProjectInterestVo(projectInterestDto);
		} catch (Exception ex) {
			this.logger.error("Data Access Error", ex);
			return null;
		} finally {
			this.logger.debug("@ Service Layer getting user 2");
		}

	}

	private List<ProjectInterestVo> changeProjectInterestDtoToVo(List dtoList) {

		List<ProjectInterestVo> projIntVoList = new ArrayList<ProjectInterestVo>();
		if (dtoList != null) {
			for (int i = 0; i < dtoList.size(); i++) {
				ProjectInterestDto obj = (ProjectInterestDto) dtoList.get(i);
				ProjectInterestVo objVo = new ProjectInterestVo(obj);

				projIntVoList.add(objVo);

			}
		}
		return projIntVoList;
	}

	@Override
	public void createProjectInterest(ProjectInterestVo projectInterestVo)
			throws Exception {

		CodeLookupVo codeVo = CodeLookupUtil.getCodeByCategoryAndCodeValue(
				VMSConstants.PROJECT_INTREST_STATUS,
				VMSConstants.PROJECT_INTEREST_NEW);

		ProjectInterestDto projectInterestDto = new ProjectInterestDto();
		projectInterestDto.setStsCd(codeVo.getCdId());
		projectInterestDto.setPrjId((ProjectDto) getProjectObjbyId(
				projectInterestVo.getPrjId(), ProjectDto.class));

		String loginId = UserUtil.getUserSessionInfoVo().getUserID();

		projectInterestDto.setReqBy(loginId);
		manager.save(projectInterestDto);
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
	public List<ProjectInterestVo> getProjectInterestListBySearchCriteria(
			ProjectInterestVo projectInterestVo) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(ProjectInterestDto.class);

		if (projectInterestVo.getPrjId() != null) {

			criteria.setFetchMode("prjId", FetchMode.JOIN)
					.createAlias("prjId", "prj")
					.add(Restrictions.eq("prj.prjId",
							projectInterestVo.getPrjId()));
		}

		if (!StringUtil.isNullOrEmpty(projectInterestVo.getStsVal())) {

			List<CodeLookupVo> codeLookupVos = CodeLookupUtil
					.getCodeListByCategory(VMSConstants.PROJECT_INTREST_STATUS);
			for (CodeLookupVo codeLookupVo : codeLookupVos) {

				if (codeLookupVo.getVal().equals(projectInterestVo.getStsVal())) {
					criteria.add(Restrictions.eq("stsCd", codeLookupVo.getCdId()));
				}
			}

		}

		List<ProjectInterestDto> projectInterestDtos = manager
				.findByDetachedCriteria(criteria);
		List<ProjectInterestVo> projectInterestVos = new ArrayList<ProjectInterestVo>();
		for (ProjectInterestDto dto : projectInterestDtos) {
			projectInterestVos.add(new ProjectInterestVo(dto));

		}

		return projectInterestVos;
	}

}
