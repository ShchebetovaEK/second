package by.tms.project.model.util.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class MailSessionCreator {
    private static final String NAME = "mail.user.name";
    private static final String PASSWORD = "mail.user.password";

    private MailSessionCreator(){}

    public static Session createSession(Properties properties){
        String name = properties.getProperty(NAME);
        String password = properties.getProperty(PASSWORD);
        return Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(name, password);
            }
        });
    }
}
