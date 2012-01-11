package sg.edu.nus.iss.vms.member.service;

import java.util.List;

import sg.edu.nus.iss.vms.project.dto.ProjectMemberDto;
import sg.edu.nus.iss.vms.project.vo.ProjectMemberVo;

public interface MemberManagementService {

	public List<ProjectMemberDto> getListOfMembers(long projectId);

	public List<ProjectMemberDto> getListOfMembers();

	public List<ProjectMemberVo> getMemberListbyProject(Long prjId);
	
	public void deleteProjectMember(String projectMemberId)throws Exception;

	public void updateProjectMemberRole(String projectMemberId,Long roleCd) throws Exception;

	public void inviteProjectMemberToAllUser(Long projectId, Long userStatus)throws Exception;

}