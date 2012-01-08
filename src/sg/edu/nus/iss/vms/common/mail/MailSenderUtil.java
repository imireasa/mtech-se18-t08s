/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.common.mail;

import java.util.Map;
import org.springframework.mail.MailException;

/**
 *
 * @author zaw
 */
public interface MailSenderUtil {

        void send(BasicMailMessage basicMessage) throws MailException;

        void send(BasicMailMessage[] basicMessages) throws MailException;

        void send(BasicMailMessage basicMessage, String templateName, Map model) throws MailException;
}
