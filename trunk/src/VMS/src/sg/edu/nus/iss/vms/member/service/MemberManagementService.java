package sg.edu.nus.iss.vms.member.service;

import java.util.List;
import sg.edu.nus.iss.vms.member.vo.MemberVo;
import sg.edu.nus.iss.vms.project.dto.ProjectMember;

public interface MemberManagementService {
	public List<ProjectMember> getListOfMembers(long projectId);

}
