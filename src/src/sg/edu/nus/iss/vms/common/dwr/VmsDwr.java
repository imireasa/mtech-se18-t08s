/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.common.dwr;

import org.apache.log4j.Logger;

import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.volunteer.service.VolunteerManagementService;

/**
 *
 * @author Zaw
 */
public class VmsDwr {
        
        private Logger log = Logger.getLogger(VmsDwr.class);
        private VolunteerManagementService volunteerManagementService;
        
        public VolunteerManagementService getVolunteerManagementService() {
                return volunteerManagementService;
        }
        
        public void setVolunteerManagementService(VolunteerManagementService volunteerManagementService) {
                this.volunteerManagementService = volunteerManagementService;
        }
        
        public boolean isUserLoginIdExist(String userloginId) {
                return volunteerManagementService.isLoginIdExists(userloginId);
        }
}
