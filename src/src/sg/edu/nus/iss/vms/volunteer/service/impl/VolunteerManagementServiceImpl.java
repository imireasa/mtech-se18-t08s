package sg.edu.nus.iss.vms.volunteer.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import sg.edu.nus.iss.vms.common.SessionBean;
import sg.edu.nus.iss.vms.common.exception.ApplicationException;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.project.dto.ProjectMemberDto;
import sg.edu.nus.iss.vms.security.dto.UserDto;
import sg.edu.nus.iss.vms.volunteer.dto.UserDetailDto;
import sg.edu.nus.iss.vms.volunteer.service.VolunteerManagementService;
import sg.edu.nus.iss.vms.volunteer.vo.VolunteerVo;

public class VolunteerManagementServiceImpl implements
		VolunteerManagementService {

	private Manager manager;
	private SessionBean sessionBean;
	private static Logger logger = Logger
			.getLogger(VolunteerManagementServiceImpl.class);

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

	@Override
	public List<ProjectMemberDto> getListOfMembers(long projectId) {
		// try{debug();}catch(Exception ex){ex.printStackTrace();}
		List<ProjectMemberDto> memberList = new ArrayList<ProjectMemberDto>();
		try {
			this.logger.debug("@ Service Layer getting user 1");
			String hQL = "from ProjectMember where projectId=" + projectId;
			memberList = manager.find(hQL);
		} catch (Exception ex) {
			this.logger.error("Data Access Error", ex);
		} finally {
			this.logger.debug("@ Service Layer getting user 2");
		}
		return memberList;
	}

	@Override
	public List<ProjectMemberDto> getListOfMembers() {
		// try{debug();}catch(Exception ex){ex.printStackTrace();}
		List<ProjectMemberDto> userList = new ArrayList<ProjectMemberDto>();
		try {
			this.logger.debug("@ Service Layer getting user 1");
			// List<Person> tempList = this.manager.list(Person.class);
			// for (Person person : tempList) {
			// MemberVo newMember = new MemberVo();
			// newMember.setPersonId(person.getPersonId());
			// newMember.setFirstName(person.getFirstName());
			// newMember.setLastName(person.getLastName());
			// newMember.setEmail(person.getEmail());
			// newMember.setMobile(person.getMobile());
			// newMember.setMemberType(person.getTypeId().getCodeName());
			// userList.add(newMember);
			// }

		} catch (Exception ex) {
			this.logger.error("Data Access Error", ex);
		} finally {
			this.logger.debug("@ Service Layer getting user 2");
		}
		return userList;
	}

	@Override
	public void saveNewVolunteer(VolunteerVo volunteerVo) throws Exception {
		UserDto user = new UserDto();

		user.setUsrLoginId(volunteerVo.getLoginId());
		user.setNme(volunteerVo.getNme());
		user.setEmail(volunteerVo.getEmail());
		user.setMobile(volunteerVo.getMobile());
		user.setPwd(volunteerVo.getPwd());
		user.setAddr(volunteerVo.getAddr());
		user.setPostCd(Integer.parseInt(volunteerVo.getPostCd()));
		user.setCtryCd(Long.parseLong(volunteerVo.getCtryCd()));

		UserDetailDto userDetail = new UserDetailDto();

		userDetail.setIntrst(volunteerVo.getIntrst());
		userDetail.setQualAtt(volunteerVo.getQualAtt());
		userDetail.setSkillSet(volunteerVo.getSkillSet());

		String hQL = "from UserDto where usrLoginId='" + user.getUsrLoginId()
				+ "'";

		List<UserDto> userList = manager.find(hQL);
		if (userList != null && !userList.isEmpty()) {
			throw new ApplicationException("User Id is in used");// TODO:
																	// Implement
																	// Message
		}
		user.setJoinDte(new Date());
		user.setCreatedBy("zawhtet");
		user.setCreatedDte(new Date());
		user.setUpdBy("zawhtet");
		user.setUpdDte(new Date());
		user.setVersion(1);

		manager.save(user);
		userDetail.setUsrId(user);
		manager.save(userDetail);
	}
}
