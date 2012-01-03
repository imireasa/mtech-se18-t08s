package sg.edu.nus.iss.vms.member.service;

import java.util.List;

import sg.edu.nus.iss.vms.project.dto.ProjectDto;
import sg.edu.nus.iss.vms.project.dto.ProjectMemberDto;

public interface MemberManagementService {

	public List<ProjectMemberDto> getListOfMembers(long projectId);

	public List<ProjectMemberDto> getListOfMembers();

	public List<ProjectMemberDto> getListOfMembersbyProject(
			ProjectDto projectDto);
}