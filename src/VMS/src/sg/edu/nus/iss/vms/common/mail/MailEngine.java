package sg.edu.nus.iss.vms.common.mail;

import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.NullArgumentException;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * Class for sending e-mail messages based on Velocity templates or with
 * attachments.
 * 
 * <p><a href="MailEngine.java.html"><i>View Source</i></a></p>
 * 
 * @author  Matt Raible
 * @author  zaw.htet
 */
public class MailEngine
{
	/**
	 * Logger
	 */
	protected static final Log log = LogFactory.getLog(MailEngine.class);

	/**
	 * Sender
	 */
	private MailSender mailSender;

	/**
	 * Velocity Engine
	 */
	private VelocityEngine velocityEngine;

	public void setMailSender(MailSender mailSender)
	{
		this.mailSender = mailSender;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine)
	{
		this.velocityEngine = velocityEngine;
	}

	/**
	 * Send a simple message with pre-populated values.
	 * 
	 * @param msg
	 */
	public void sendMessage(SimpleMailMessage msg)
	{
		if (msg == null) 
		{
			throw new NullArgumentException("msg");
		}

		try
		{
			if (log.isTraceEnabled())
			{
				log.trace("Attempt to send the mail...");
			}
			this.mailSender.send(msg);
		}
		catch (MailException e)
		{
			// log the error
			log.error(e.getMessage());

			// debug the exception
			if (log.isDebugEnabled())
			{
				log.debug(e.getMessage(), e);
			}
		}
	}

	/**
	 * Send a simple message based on a Velocity template.
	 * 
	 * @param msg
	 * @param templateName
	 * @param model
	 */
	public void sendMessage(SimpleMailMessage msg, String templateName, Map model)
	{
		if (msg == null) {
			throw new NullArgumentException("msg");
		}

		if (StringUtils.isBlank(templateName)) {
			throw new NullArgumentException("templateName");
		}

		String mailText = null;

		try
		{
			mailText = VelocityEngineUtils.mergeTemplateIntoString(
					this.velocityEngine, templateName, model);
		}
		catch (VelocityException ve)
		{
			// log the error
			log.error(ve.getMessage(), ve);
		}

		msg.setText(mailText);

		// sending mail
		this.sendMessage(msg);
	}

	/**
	 * Convenience method for sending messages with attachments.
	 * <p>
	 * Author: Ben Gill
	 * 
	 * @param emailAddresses
	 * @param resource
	 * @param bodyText
	 * @param subject
	 * @plaram attachmentName
	 * @throws MessagingException
	 */
	public void sendMessage(
			String[] emailAddresses,
			ClassPathResource resource,
			String bodyText,
			String subject,
			String attachmentName)
	throws MessagingException
	{
		MimeMessage message = ((JavaMailSenderImpl) this.mailSender).createMimeMessage();

		// use the true flag to indicate you need a multipart message
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setTo(emailAddresses);
		helper.setText(bodyText);
		helper.setSubject(subject);

		helper.addAttachment(attachmentName, resource);

		((JavaMailSenderImpl) this.mailSender).send(message);
	}
}
