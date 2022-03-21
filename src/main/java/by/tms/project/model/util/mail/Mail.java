package by.tms.project.model.util.mail;

import by.tms.project.exception.MailException;
import by.tms.project.model.util.property.PropertyLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mail {
    private static final Logger logger = LogManager.getLogger();
    private static final String MAIL_PROP_PATH = "prop/mail.properties";
    private static final Properties properties = PropertyLoader.getProperty(MAIL_PROP_PATH);
    private MimeMessage mimeMessage;

    public void sendMessage(String subject, String firstName, String lastName, String email) throws MailException {
        try {
            initMessage(subject, firstName, lastName, email);
            Transport.send(mimeMessage);
        } catch (MessagingException e) {
            throw new MailException(e);
        }
    }

    private void initMessage(String subject, String firstName, String lastName, String email) {
        Session session = MailSessionCreator.createSession(properties);
        mimeMessage = new MimeMessage(session);
        try {
            switch (subject) {
                case "CHANGE PASSWORD" -> {
                    mimeMessage.setSubject(subject);
                    mimeMessage.setContent("you change your password", "text/html");
                    mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email));

                }
                case "REGISTRATION" -> {
                    mimeMessage.setSubject(subject);
                    mimeMessage.setContent(" Hello, " + firstName + " " + lastName + "  from Forestmed ! " + "\n"
                            + " Your registration was successful ! " + "\n"
                            + " If you haven't done, so let us know ! " + "\n"
                            + " Your, Forestmed ! ", "text/html");
                    mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
                }
                case "CONGRATULATIONS" -> {
                    mimeMessage.setSubject(subject);
                    mimeMessage.setContent(firstName + " " +
                            " In honor of your birthday, we give you a discount ", "text/html");
                    mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email));

                }
                case "REPLENISH" -> {
                    mimeMessage.setSubject(subject);
                    mimeMessage.setContent(firstName+ " " + lastName +
                            "\n" +
                            "It's time to replenish the balance. \n" +
                            "Your balance is less than 10 rubles." +
                            "We recommend replenishing the balance as soon as possible."+
                            " Your, Forestmed! ", "text/html");
                    mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
                }
                case "APPLICATION APPROVED" -> {
                    mimeMessage.setSubject(subject);
                    mimeMessage.setContent( firstName + " " + lastName +
                            " Your application approved!"+" Your, Forestmed! ", "text/html");
                    mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
                }
            }

        } catch (MessagingException e) {
            logger.error(" Have problems ");
        }
    }
}
