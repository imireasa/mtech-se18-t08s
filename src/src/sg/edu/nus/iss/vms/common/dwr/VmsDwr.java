/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.common.dwr;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import org.apache.log4j.Logger;

import sg.edu.nus.iss.vms.common.mail.BasicMailMessage;
import sg.edu.nus.iss.vms.common.mail.MailSenderUtil;
import sg.edu.nus.iss.vms.common.mail.impl.MailSenderUtilImpl;
import sg.edu.nus.iss.vms.common.util.RamdomPasswordGeneratorUtil;
import sg.edu.nus.iss.vms.volunteer.service.VolunteerManagementService;

/**
 *
 * @author Zaw
 */
public class VmsDwr {

        private Logger logger = Logger.getLogger(VmsDwr.class);
        private VolunteerManagementService volunteerManagementService;
        private MailSenderUtil mailSenderUtil;

        public MailSenderUtil getMailSenderUtil() {
                return mailSenderUtil;
        }

        public void setMailSenderUtil(MailSenderUtil mailSenderUtil) {
                this.mailSenderUtil = mailSenderUtil;
        }

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
