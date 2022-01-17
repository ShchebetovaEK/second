package by.tms.project.model.validator;

import by.tms.project.model.util.property.PropertyLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

public final class UserValidator {
    private static final Logger logger = LogManager.getLogger();
    private static final String PROPERTY_PATH = "message.properties";
    private static final Properties property = PropertyLoader.getProperty(PROPERTY_PATH);
    private static final String COMMA = ", ";
    private static final String WHITESPACE = " ";
    private static final String LOGIN_REGEX = "^(\\w)[\\w_-]{1,18}(\\w)$";
    private static final String PASSWORD_REGEX = "^(.{8,40})$";
    private static final String FIRST_NAME_REGEX = " todo"; //todo
    private static final String LAST_NAME_REGEX = " todo"; //todo
    private static final String DATABIRTHDAY_REGEX ="todo"; // todo
    private static final String ADDRESS_REGEX ="todo "; // todo
    private static final String EMAIL_REGEX = "^((\\w|[-+])+(\\.(\\w|[-+])*)*@[a-z]+\\.[a-z]+)$";
    private static final String PHONE_NUMBER_REGEX = "^((\\+375|80)(25|29|33|44)\\d{7})$";

    private static UserValidator instance;

    private UserValidator() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static UserValidator getInstance() {
        if (instance == null) {
            instance = new UserValidator();
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
     * Is first name valid.
     * @param firstName
     * @return the boolean.
     */
    public boolean isFirstNameValid(String firstName){ return firstName!= null && firstName.matches(FIRST_NAME_REGEX);}

    /**
     * Is last name valid.
     * @param lastName
     * @return the boolean.
     */
    public boolean isLastNameValid(String lastName){ return lastName!= null && lastName.matches(LAST_NAME_REGEX);}

    /**
     * Is DataBirthday valid.
     * @param dataBirthday
     * @return the boolean.
     */
    public boolean isDataBirthdayValid(String dataBirthday){ return dataBirthday!= null && dataBirthday.matches(DATABIRTHDAY_REGEX);}

    /**
     * Is address valid.
     * @param lastName
     * @return the boolean.
     */
    public boolean isAddressValid(String lastName){ return lastName!= null && lastName.matches(ADDRESS_REGEX);}

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