package by.tms.project.model.util.mail;

import by.tms.project.exception.MailException;
import by.tms.project.model.util.property.PropertyLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mail {
    private static final Logger logger = LogManager.getLogger();
    private static final String MAIL_PROP_PATH = "mail.properties";
    private static final String SUBJECT = "registration";
    private static final Properties properties = PropertyLoader.getProperty(MAIL_PROP_PATH);
    private MimeMessage mimeMessage;

    public void sendMessage(long id,String email) throws MailException {
        try {
            initMessage(id, email);
            Transport.send(mimeMessage);
        } catch (MessagingException e) {
            throw new MailException(e);
        }
    }

    private void initMessage(long id, String email){
        Session session = MailSessionCreator.createSession(properties);
        session.setDebug(true);

        mimeMessage = new MimeMessage(session);
        try {
            mimeMessage.setSubject(SUBJECT);
            mimeMessage.setContent("registration success","text/html");
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
        } catch (MessagingException e) {
            logger.error(e);
        }
    }
}
