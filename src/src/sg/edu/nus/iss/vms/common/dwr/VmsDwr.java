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

        public void sendEmail(String toEmail, String toName, String subject) {
                try {
                        BasicMailMessage bmm = new BasicMailMessage();
                        bmm.setSubject(subject);
                        bmm.setTo(toEmail);

                        Map props = new HashMap();
                        props.put("name", toName);
                        props.put("password", RamdomPasswordGeneratorUtil.getPassword(6));
                        mailSenderUtil.send(bmm, "forgotPasswordMail.vm", props);
                } catch (Exception ex) {
                        logger.error("send mail error", ex);
                }
        }
}
