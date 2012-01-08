package sg.edu.nus.iss.vms.volunteer.service;

import java.util.List;
import sg.edu.nus.iss.vms.project.dto.ProjectMemberDto;
import sg.edu.nus.iss.vms.volunteer.vo.VolunteerVo;

public interface VolunteerManagementService {

        public List<ProjectMemberDto> getListOfMembers(long projectId);

        public List<ProjectMemberDto> getListOfMembers();

        public void saveNewVolunteer(VolunteerVo volunteerVo) throws Exception;

        boolean isLoginIdExists(String loginId);

        VolunteerVo getVolunteer(String loginid);

        void updateVolunteer(VolunteerVo volunteerVo) throws Exception;
}
