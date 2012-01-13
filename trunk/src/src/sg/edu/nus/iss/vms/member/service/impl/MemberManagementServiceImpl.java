package sg.edu.nus.iss.vms.member.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import sg.edu.nus.iss.vms.common.Messages;
import sg.edu.nus.iss.vms.common.SysConfig;
import sg.edu.nus.iss.vms.common.exception.ApplicationException;
import sg.edu.nus.iss.vms.common.mail.BasicMailMessage;
import sg.edu.nus.iss.vms.common.mail.MailSenderUtil;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.common.util.CodeLookupUtil;
import sg.edu.nus.iss.vms.member.service.MemberManagementService;
import sg.edu.nus.iss.vms.project.dto.ProjectDto;
import sg.edu.nus.iss.vms.project.dto.ProjectMemberDto;
import sg.edu.nus.iss.vms.project.vo.ProjectMemberVo;
import sg.edu.nus.iss.vms.security.dto.UserDto;

public class MemberManagementServiceImpl implements MemberManagementService {

	private Manager manager;
	private MailSenderUtil mailSenderUtil;

	private final Logger logger = Logger
			.getLogger(MemberManagementServiceImpl.class);

	public Manager getManager() {
		return this.manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public MailSenderUtil getMailSenderUtil() {
		return mailSenderUtil;
	}

	public void setMailSenderUtil(MailSenderUtil mailSenderUtil) {
		this.mailSenderUtil = mailSenderUtil;
	}

	@Override
	public List<ProjectMemberDto> getListOfMembers(long projectId) {
		// try{debug();}catch(Exception ex){ex.printStackTrace();}
		List<ProjectMemberDto> memberList = new ArrayList<ProjectMemberDto>();
		try {
			this.logger.debug("@ Service Layer getting user 1");
			String hQL = "from ProjectMemberDto where prjId.prjId ="
					+ projectId;
			memberList = manager.find(hQL);
		} catch (Exception ex) {
			this.logger.error("Data Access Error", ex);
		} finally {
			this.logger.debug("@ Service Layer getting user 2");
		}
		return memberList;
	}

	@Override
	public List<ProjectMemberVo> getMemberListbyProject(Long prjId) {
		try {
			DetachedCriteria criteria = DetachedCriteria
					.forClass(ProjectMemberDto.class);
			criteria.setFetchMode("prjId", FetchMode.JOIN)
					.createAlias("prjId", "prjId")
					.add(Restrictions.eq("prjId.prjId", prjId))
					.add(Restrictions.eq("actInd", true));
			List<ProjectMemberDto> memberList = manager
					.findByDetachedCriteria(criteria);

			List<ProjectMemberVo> projectMemberVos = new ArrayList<ProjectMemberVo>();

			for (ProjectMemberDto projectMemberDto : memberList) {

				String hQL = "from UserDto where  usrLoginId ='"
						+ projectMemberDto.getUsrLoginId() + "'";
				List<UserDto> userDtos = manager.find(hQL);
				ProjectMemberVo projectMemberVo = new ProjectMemberVo();
				projectMemberVo.setRoleCd(String.valueOf(projectMemberDto
						.getRoleCd().longValue()));

				projectMemberVo.setUsrLoginId(projectMemberDto.getUsrLoginId());
				if (!userDtos.isEmpty())
					projectMemberVo.setNme(userDtos.get(0).getNme());

				projectMemberVos.add(projectMemberVo);

			}

			return projectMemberVos;
		} catch (Exception ex) {
			this.logger.error("Data Access Error", ex);
		}
		return null;
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
	public void deleteProjectMember(String projectMemberId) throws Exception {
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
	public void updateProjectMemberRole(String projectMemberId, Long roleCd)
			throws Exception {
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
	public void inviteProjectMemberToAllUser(Long projectId, Long userStatus)
			throws Exception {

		ProjectDto projectDto = (ProjectDto) manager.get(ProjectDto.class,
				projectId);
		String memberList = "";

		String hQL = "from ProjectMemberDto where prjId.prjId=" + projectId;
		List<ProjectMemberDto> projectMemberDtos = manager.find(hQL);
		for (ProjectMemberDto memberDto : projectMemberDtos) {
			if (!memberList.isEmpty()) {
				memberList += ",";
			}
			ProjectMemberDto projectMemberDto = (ProjectMemberDto) manager.get(
					ProjectMemberDto.class, memberDto.getPrjMbrId());
			memberList += "'" + projectMemberDto.getUsrLoginId() + "'";
		}
		hQL = "from UserDto where tpCd=" + userStatus
				+ " and usrLoginId not in(" + memberList + ")";
		List<UserDto> userDtos = manager.find(hQL);
		for (UserDto userDto : userDtos) {
			try {
				BasicMailMessage bmm = new BasicMailMessage();
				bmm.setSubject(Messages
						.getString("message.projectManagement.inviteVolunteer.email.subject"));
				bmm.setTo(userDto.getEmail());

				Map props = new HashMap();
				props.put("FullName", userDto.getNme());
				props.put("ProjectName", projectDto.getNme());

				String country = CodeLookupUtil.getCodeValueByCodeId(projectDto
						.getCtryCd());

				props.put("ProjectLocation", projectDto.getLoc() + ", "
						+ country);

				String url = SysConfig
						.getString("url.projectManagement.inviteProject.viewProject");
				props.put("ProjectUrl", url + projectDto.getPrjId());

				mailSenderUtil.send(bmm, "memberInvitationMail.vm", props);
			} catch (Exception ex) {
				logger.error("send mail error", ex);
			}
		}
	}

}
