package sg.edu.nus.iss.vms.common.mail;

import java.util.Map;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * @author zaw.htet
 *
 */
public interface MailSender extends JavaMailSender
{
	public void send(BasicMailMessage basicMessage) throws MailException;

    public void send(BasicMailMessage basicMessage,String templateName,Map model) throws MailException;

	public void send(BasicMailMessage[] basicMessages) throws MailException;
}
