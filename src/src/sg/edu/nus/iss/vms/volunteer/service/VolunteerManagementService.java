package sg.edu.nus.iss.vms.volunteer.service;

import sg.edu.nus.iss.vms.volunteer.vo.VolunteerVo;

public interface VolunteerManagementService {

        public void createVolunteer(VolunteerVo volunteerVo) throws Exception;

        boolean isLoginIdExists(String loginId);

        VolunteerVo getVolunteer(String loginid);

        void updateVolunteer(VolunteerVo volunteerVo) throws Exception;
}
