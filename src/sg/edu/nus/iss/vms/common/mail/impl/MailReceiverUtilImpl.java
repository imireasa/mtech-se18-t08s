/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.common.mail.impl;

import sg.edu.nus.iss.vms.common.mail.MailReceiverUtil;
import javax.mail.Address;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import javax.mail.AuthenticationFailedException;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.FolderNotFoundException;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.ReadOnlyFolderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.StoreClosedException;
import javax.mail.internet.InternetAddress;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author zaw.htet
 */
public class MailReceiverUtilImpl extends JavaMailSenderImpl implements MailReceiverUtil {

        private Log log = LogFactory.getLog(getClass());

        @Override
        public void processMail() {
                log.info("insert process mail");
                Session session = null;
                Store store = null;
                Folder folder = null;
                Message message = null;
                Message[] messages = null;
                Object messagecontentObject = null;
                String sender = null;
                String subject = null;
                Multipart multipart = null;
                Part part = null;
                String contentType = null;
                String content;
                Address cc[];
                String[] recipient;

                try {

                        session = Session.getDefaultInstance(System.getProperties(), null);
                        store = session.getStore("pop3");
                        store.connect(getHost(), getUsername(), getPassword());
                        // Get a handle on the default folder
                        folder = store.getDefaultFolder();

                        // Retrieve the "Inbox"
                        folder = folder.getFolder("inbox");

                        //Reading the Email Index in Read / Write Mode
                        folder.open(Folder.READ_WRITE);

                        // Retrieve the messages
                        messages = folder.getMessages();


                        for (int messageNumber = 0; messageNumber < messages.length; messageNumber++) {
                                // Retrieve the next message to be read
                                message = messages[messageNumber];
                                log.info("the message " + message);

                                // Retrieve the message content
                                messagecontentObject = message.getContent();
                                log.info("the message content " + messagecontentObject);
                                // Determine email type
                                if (messagecontentObject instanceof Multipart) {
                                        sender = ((InternetAddress) message.getFrom()[0]).getAddress();

                                        // If the "personal" information has no entry, check the address for the sender information
                                        if (sender == null) {
                                                sender = ((InternetAddress) message.getFrom()[0]).getAddress();

                                        }
                                        // Get the subject information
                                        subject = message.getSubject();
                                        log.info(subject);
                                        cc = message.getRecipients(Message.RecipientType.CC);

                                        // Retrieve the Multipart object from the message
                                        multipart = (Multipart) message.getContent();
                                        log.info(multipart);

                                        // Loop over the parts of the email
                                        for (int i = 0; i < multipart.getCount(); i++) {
                                                // Retrieve the next part

                                                part = multipart.getBodyPart(i);
                                                log.info(part);

                                                // Get the content type
                                                contentType = part.getContentType();
                                                log.info(contentType);


                                                // Display the content type
                                                if (contentType.startsWith("text/plain")) {
                                                        content = StringUtils.trimToEmpty((String) part.getContent());

                                                        log.info(StringUtils.trimToEmpty((String) part.getContent()));
                                                        message.setFlag(Flags.Flag.DELETED, true);
                                                } else {
                                                        // Retrieve the file name
                                                        String fileName = part.getFileName();
                                                }
                                        }

                                } else {
                                        sender = ((InternetAddress) message.getFrom()[0]).getPersonal();

                                        // If the "personal" information has no entry, check the address for the sender information


                                        if (sender == null) {
                                                sender = ((InternetAddress) message.getFrom()[0]).getAddress();

                                        }

                                        // Get the subject information
                                        subject = message.getSubject();
                                        log.info(subject);
                                        cc = message.getRecipients(Message.RecipientType.CC);

                                        message.setFlag(Flags.Flag.DELETED, true);
                                }
                        }
                        // Close the folder
                        folder.close(true);
                        // Close the message store
                        store.close();
                } catch (AuthenticationFailedException e) {

                        log.error(e);
                } catch (FolderClosedException e) {

                        log.error(e);
                } catch (FolderNotFoundException e) {

                        log.error(e);
                } catch (NoSuchProviderException e) {

                        log.error(e);
                } catch (ReadOnlyFolderException e) {

                        log.error(e);
                } catch (StoreClosedException e) {

                        log.error(e);
                } catch (Exception e) {

                        log.error(e);
                }
        }
}
