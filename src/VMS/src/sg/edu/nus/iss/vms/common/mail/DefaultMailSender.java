package sg.edu.nus.iss.vms.common.mail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.NullArgumentException;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * @author zaw.htet
 *
 */
public class DefaultMailSender extends JavaMailSenderImpl implements MailSender
{
	protected Log log = LogFactory.getLog( getClass() );

	//---------------------------------------------------------------------
	// Implementation of MailSender
	//---------------------------------------------------------------------

	public void send(BasicMailMessage basicMessage) throws MailException {
		send(new BasicMailMessage[] { basicMessage });
	}

    private VelocityEngine velocityEngine;

    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }

    
    
	public void send(BasicMailMessage[] basicMessages) throws MailException {
		List mimeMessages = new ArrayList(basicMessages.length);
		for (int i = 0; i < basicMessages.length; i++) {
			BasicMailMessage simpleMessage = basicMessages[i];
			MimeMailMessage mimeMessage = new MimeMailMessage(createMimeMessage());
			simpleMessage.copyTo(mimeMessage);
			
			// Create MIME messages
			MimeMessage message = mimeMessage.getMimeMessage();
			
			// Create multipart
			Multipart multipart = new MimeMultipart();
			MimeBodyPart messageBodyPart;

			try {
				// Part one - create the message part 
				messageBodyPart = new MimeBodyPart();
				messageBodyPart.setText( basicMessages[i].getText() );
				multipart.addBodyPart(messageBodyPart);

				// Part two and next is attachment
				List fileAttachments = basicMessages[i].getFileAttachments();
				for (int j=0, size = fileAttachments.size(); j < size; j++) {
					String fileAttachment = (String) fileAttachments.get( j );
					
					messageBodyPart = new MimeBodyPart();
					DataSource source =  new FileDataSource(fileAttachment);
					messageBodyPart.setDataHandler(new DataHandler(source));
					messageBodyPart.setFileName(FilenameUtils.getName(fileAttachment));
					multipart.addBodyPart(messageBodyPart);
				}

				// Put parts in message
				message.setContent(multipart);

				mimeMessages.add(message);
			}
			catch (Exception e) {
				log.warn("Can't create MimeBodyPart", e);
			}
		}
		doSend((MimeMessage[]) mimeMessages.toArray(new MimeMessage[mimeMessages.size()]), basicMessages);
	}

    public void send(BasicMailMessage basicMessage, String templateName,Map model) throws MailException {
        if (basicMessage == null) {
			throw new NullArgumentException("msg");
		}

		if (StringUtils.isBlank(templateName)) {
			throw new NullArgumentException("templateName");
		}

		String mailText = null;

		try
		{
			mailText = VelocityEngineUtils.mergeTemplateIntoString(
					this.velocityEngine, templateName,model);
		}
		catch (VelocityException ve)
		{
			// log the error
			log.error(ve.getMessage(), ve);
		}

		basicMessage.setText(mailText);

		// sending mail
		this.send(basicMessage);
    }
}
