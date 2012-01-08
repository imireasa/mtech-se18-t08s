package sg.edu.nus.iss.vms.staffmgmt.service;

import java.util.List;

import sg.edu.nus.iss.vms.security.dto.UserDto;

public interface StaffManagementServices {

        public List<UserDto> getListOfUser();
}