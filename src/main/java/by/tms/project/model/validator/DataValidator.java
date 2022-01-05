package by.tms.project.model.validator;

import by.tms.project.model.util.PropertyLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

public final class DataValidator {
    private static final Logger logger = LogManager.getLogger();
    private static final String PROPERTY_PATH = "message.properties";
    private static final Properties property = PropertyLoader.getProperty(PROPERTY_PATH);
    private static final String COMMA = ", ";
    private static final String WHITESPACE = " ";
    private static final String LOGIN_REGEX = "^(\\w)[\\w_-]{1,18}(\\w)$";
    private static final String PASSWORD_REGEX = "^(.{8,40})$";
    private static final String EMAIL_REGEX = "^((\\w|[-+])+(\\.(\\w|[-+])*)*@[a-z]+\\.[a-z]+)$";
    private static final String PHONE_NUMBER_REGEX = "^((\\+375|80)(25|29|33|44)\\d{7})$";
    private static DataValidator instance;

    private DataValidator() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static DataValidator getInstance() {
        if (instance == null) {
            instance = new DataValidator();
        }

        return instance;
    }

    /**
     * Is login valid.
     *
     * @param login the login
     * @return the boolean
     */
    public boolean isLoginValid(String login) {
        return login != null && login.matches(LOGIN_REGEX);
    }

    /**
     * Is password valid.
     *
     * @param password the password
     * @return the boolean
     */
    public boolean isPasswordValid(String password) {
        return password != null && password.matches(PASSWORD_REGEX);
    }

    /**
     * Is email valid.
     *
     * @param email the email
     * @return the boolean
     */
    public boolean isEmailValid(String email) {
        return email != null && email.matches(EMAIL_REGEX);
    }

    /**
     * Is phone number valid.
     *
     * @param phoneNumber the phone number
     * @return the boolean
     */
    public boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches(PHONE_NUMBER_REGEX);
    }

}