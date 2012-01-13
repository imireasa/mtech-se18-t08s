package sg.edu.nus.iss.vms.member.web.controller;


import org.apache.log4j.Logger;

import sg.edu.nus.iss.vms.common.web.controller.BaseMultiActionFormController;
import sg.edu.nus.iss.vms.member.service.MemberManagementService;
import sg.edu.nus.iss.vms.project.service.ProjectManagementService;

public class MemberController extends BaseMultiActionFormController {

        private Logger logger = Logger.getLogger(MemberController.class);
        private MemberManagementService memberManagementService;
        private ProjectManagementService projectManagementService;

        public MemberManagementService getMemberManagementService() {
                return memberManagementService;
        }

        public void setMemberManagementService(
                MemberManagementService memberManagementService) {
                this.memberManagementService = memberManagementService;
        }

        public ProjectManagementService getProjectManagementService() {
                return projectManagementService;
        }

        public void setProjectManagementService(
                ProjectManagementService projectManagementService) {
                this.projectManagementService = projectManagementService;
        }

        
}
