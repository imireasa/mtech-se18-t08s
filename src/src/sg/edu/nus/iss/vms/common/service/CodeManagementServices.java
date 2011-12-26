package sg.edu.nus.iss.vms.common.service;

import java.util.List;

import sg.edu.nus.iss.vms.common.dto.CodeDto;

public interface CodeManagementServices {

        public List<CodeDto> getListOfCodeByCategory(String Category);
}