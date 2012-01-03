package sg.edu.nus.iss.vms.volunteer.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import org.springframework.security.providers.encoding.PasswordEncoder;
import sg.edu.nus.iss.vms.common.Messages;
import sg.edu.nus.iss.vms.common.SessionBean;
import sg.edu.nus.iss.vms.common.constants.VMSConstants;
import sg.edu.nus.iss.vms.common.dto.CodeDto;
import sg.edu.nus.iss.vms.common.exception.ApplicationException;
import sg.edu.nus.iss.vms.common.orm.Manager;

import sg.edu.nus.iss.vms.common.util.CodeLookupUtil;
import sg.edu.nus.iss.vms.common.web.util.UserUtil;
import sg.edu.nus.iss.vms.project.dto.ProjectMemberDto;
import sg.edu.nus.iss.vms.security.dto.UserDto;
import sg.edu.nus.iss.vms.volunteer.dto.UserDetailDto;
import sg.edu.nus.iss.vms.volunteer.service.VolunteerManagementService;
import sg.edu.nus.iss.vms.volunteer.vo.VolunteerVo;

public class VolunteerManagementServiceImpl implements
		VolunteerManagementService {

	private Manager manager;
	private SessionBean sessionBean;
	private Logger logger = Logger
			.getLogger(VolunteerManagementServiceImpl.class);
	private PasswordEncoder passwordEncoder;

	public Manager getManager() {
		return this.manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public SessionBean getSessionBean() {
		return this.sessionBean;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public List<ProjectMemberDto> getListOfMembers(long projectId) {
		if (logger.isDebugEnabled()) {
			logger.debug("getListOfMembers(long) - start");
		}
		// try{debug();}catch(Exception ex){ex.printStackTrace();}
		List<ProjectMemberDto> memberList = new ArrayList<ProjectMemberDto>();
		try {
			this.logger
					.debug("getListOfMembers(long) - @ Service Layer getting user 1");
			String hQL = "from ProjectMember where projectId=" + projectId;
			memberList = manager.find(hQL);
		} catch (Exception ex) {
			this.logger.error("getListOfMembers(long) - Data Access Error", ex);
		} finally {
			this.logger
					.debug("getListOfMembers(long) - @ Service Layer getting user 2");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getListOfMembers(long) - end");
		}
		return memberList;
	}

	@Override
	public List<ProjectMemberDto> getListOfMembers() {
		if (logger.isDebugEnabled()) {
			logger.debug("getListOfMembers() - start");
		}

		// try{debug();}catch(Exception ex){ex.printStackTrace();}
		List<ProjectMemberDto> userList = new ArrayList<ProjectMemberDto>();
		try {
			this.logger
					.debug("getListOfMembers() - @ Service Layer getting user 1");

		} catch (Exception ex) {
			this.logger.error("getListOfMembers() - Data Access Error", ex);
		} finally {
			this.logger
					.debug("getListOfMembers() - @ Service Layer getting user 2");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getListOfMembers() - end");
		}
		return userList;
	}

	public boolean isLoginIdExists(String loginId) {
		if (logger.isDebugEnabled()) {
			logger.debug("isLoginIdExists(String) - start");
		}

		String hQL = "from UserDto where usrLoginId='" + loginId + "'";
		List<UserDto> userList = manager.find(hQL);
		if (userList != null && !userList.isEmpty()) {
			if (logger.isDebugEnabled()) {
				logger.debug("isLoginIdExists(String) - end");
			}
			return true;
		}

		if (logger.isDebugEnabled()) {
			logger.debug("isLoginIdExists(String) - end");
		}
		return false;
	}

	@Override
	public void saveNewVolunteer(VolunteerVo volunteerVo) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("saveNewVolunteer(VolunteerVo) - start");
		}

		try {
			UserDto user = new UserDto();
			user.setUsrLoginId(volunteerVo.getLoginId());
			user.setNme(volunteerVo.getNme());
			user.setTitleCd(Long.parseLong(volunteerVo.getTitle()));
			CodeDto codeDto = CodeLookupUtil.getCodeByCategoryAndCodeValue(
					VMSConstants.USER_TYPE_CATEGORY,
					VMSConstants.USER_TYPE_CATEGORY_VOLUNTEER);
			user.setTpCd(codeDto.getCdId());
			user.setEmail(volunteerVo.getEmail());
			user.setMobile(volunteerVo.getMobile());
			user.setPwd(passwordEncoder.encodePassword(volunteerVo.getPwd(),
					null));
			user.setAddr(volunteerVo.getAddr());
			user.setPostCd(Integer.parseInt(volunteerVo.getPostCd()));
			user.setCtryCd(Long.parseLong(volunteerVo.getCtryCd()));
			user.setJoinDte(new Date());
			user.setUpdBy(volunteerVo.getLoginId());
			user.setCreatedBy(volunteerVo.getLoginId());
			UserDetailDto userDetail = new UserDetailDto();

			userDetail.setIntrst(volunteerVo.getIntrst());
			userDetail.setQualAtt(volunteerVo.getQualAtt());
			userDetail.setSkillSet(volunteerVo.getSkillSet());

			if (isLoginIdExists(volunteerVo.getLoginId())) {
				throw new ApplicationException(
						Messages.getString("message.volunteerManagement.error.userDublicate"));// TODO:
																								// Implement
																								// Message
			}

			manager.save(user);
			userDetail.setUsrId(user);
			manager.save(userDetail);
		} catch (Exception ex) {
			logger.error("Save Volunteer", ex);
			throw new ApplicationException(
					Messages.getString("message.common.error.save"));
		}

		if (logger.isDebugEnabled()) {
			logger.debug("saveNewVolunteer(VolunteerVo) - end");
		}
	}

	@Override
	public void updateVolunteer(VolunteerVo volunteerVo) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("updateVolunteer(VolunteerVo) - start");
		}

		try {
			String hQL = "from UserDto where usrLoginId = '"
					+ volunteerVo.getLoginId() + "' " + "and usrId="
					+ UserUtil.getUserSessionInfoVo().getUserSeqID();
			// assemption: only update by the login user
			List<UserDto> userList = manager.find(hQL);
			UserDto user = null;
			UserDetailDto userDetail = null;
			if (userList != null && !userList.isEmpty()) {
				user = userList.get(0);
				userDetail = user.getTbUserDetail();// TODO: Renaming
			} else {
				throw new ApplicationException(
						Messages.getString("message.common.error.update"));
			}
			//
			user.setNme(volunteerVo.getNme());
			user.setEmail(volunteerVo.getEmail());
			user.setMobile(volunteerVo.getMobile());
			user.setPwd(volunteerVo.getPwd());
			user.setAddr(volunteerVo.getAddr());
			user.setPostCd(Integer.parseInt(volunteerVo.getPostCd()));
			user.setCtryCd(Long.parseLong(volunteerVo.getCtryCd()));
			user.setJoinDte(new Date());
			user.setCreatedBy(volunteerVo.getLoginId());// TODO: Should be login
														// user
			user.setCreatedDte(new Date());
			user.setUpdBy(volunteerVo.getLoginId());// TODO: Should be login
													// user
			user.setUpdDte(new Date());
			user.setVersion(1);
			//
			userDetail.setIntrst(volunteerVo.getIntrst());
			userDetail.setQualAtt(volunteerVo.getQualAtt());
			userDetail.setSkillSet(volunteerVo.getSkillSet());

			manager.save(user);
			userDetail.setUsrId(user);
			manager.save(userDetail);
		} catch (Exception ex) {
			logger.error("Save Volunteer", ex);
			throw new ApplicationException(
					Messages.getString("message.common.error.update"));
		}

		if (logger.isDebugEnabled()) {
			logger.debug("updateVolunteer(VolunteerVo) - end");
		}
	}

	@Override
	public VolunteerVo getVolunteer(String loginid) {
		if (logger.isDebugEnabled()) {
			logger.debug("getVolunteer(String) - start");
		}

		String hQL = "from UserDto where usrLoginId = '" + loginid + "'";
		List<UserDto> userList = manager.find(hQL);
		UserDto user = null;
		UserDetailDto userDetail = null;
		if (userList != null && !userList.isEmpty()) {
			user = userList.get(0);
			userDetail = user.getTbUserDetail();// TODO: Renaming
		} else {
			if (logger.isDebugEnabled()) {
				logger.debug("getVolunteer(String) - end");
			}
			return null;
		}

		VolunteerVo volunteerVo = new VolunteerVo();
		if (user != null) {
			volunteerVo.setLoginId(user.getUsrLoginId());
			volunteerVo.setNme(user.getNme());
			volunteerVo.setEmail(user.getEmail());
			volunteerVo.setAddr(user.getAddr());
			volunteerVo.setMobile(user.getMobile());
			volunteerVo.setPostCd(user.getPostCd() + "");
			volunteerVo.setCtryCd(user.getCtryCd() + "");
			volunteerVo.setVersion(user.getVersion() + "");
		}
		if (userDetail != null) {
			volunteerVo.setIntrst(userDetail.getIntrst());
			volunteerVo.setQualAtt(userDetail.getQualAtt());
			volunteerVo.setSkillSet(userDetail.getSkillSet());
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getVolunteer(String) - end");
		}
		return volunteerVo;
	}
}
