package by.tms.project.model.validator.impl;

import by.tms.project.model.validator.UserValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static by.tms.project.controller.command.RequestAttribute.LOGIN;
import static by.tms.project.controller.command.RequestAttribute.PASSWORD;
import static by.tms.project.controller.command.RequestParameter.*;

/**
 * @author ShchebetovaEK
 *
 * final class UserValidatorImpl
 */
public final class UserValidatorImpl implements UserValidator {
    private static final Logger logger = LogManager.getLogger();
    private static final String COMMA = ", ";
    private static final String WHITESPACE = " ";
    private static final String LOGIN_REGEX = "^(\\w)[\\w_-]{1,18}(\\w)$";
    private static final String PASSWORD_REGEX = "^(.{4,40})$";
    private static final String FIRST_NAME_REGEX = "^([А-Я]{1}[а-яё]{1,23}|[A-Z]{1}[a-z]{1,23})$";
    private static final String LAST_NAME_REGEX = "^([А-Я]{1}[а-яё]{1,30}|[A-Z]{1}[a-z]{1,30})$";
    private static final String DATABIRTHDAY_REGEX = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$";
    private static final String ADDRESS_REGEX = "^([А-Я]{1}[а-яё]{1,23}|[A-Z]{1}[a-z]{1,23})(\\s)(\\d{2})\\-(\\d{2})$";
    private static final String EMAIL_REGEX = "^((\\w|[-+])+(\\.(\\w|[-+])*)*@[a-z]+\\.[a-z]+)$";
    private static final String PHONE_NUMBER_REGEX = "^((\\+375|80)(25|29|33|44)\\d{7})$";

    private static UserValidatorImpl instance;

    private UserValidatorImpl() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static UserValidatorImpl getInstance() {
        if (instance == null) {
            instance = new UserValidatorImpl();
        }

        return instance;
    }

    /**
     * Is login valid.
     *
     * @param login the login
     * @return the boolean
     */
    @Override
    public boolean isLoginValid(String login) {
        return login != null && login.matches(LOGIN_REGEX);
    }

    /**
     * Is password valid.
     *
     * @param password the password
     * @return the boolean
     */
    @Override
    public boolean isPasswordValid(String password) {
        return password != null && password.matches(PASSWORD_REGEX);
    }

    /**
     * Is first name valid.
     *
     * @param firstName
     * @return the boolean.
     */
    @Override
    public boolean isFirstNameValid(String firstName) {
        return firstName != null && firstName.matches(FIRST_NAME_REGEX);
    }

    /**
     * Is last name valid.
     *
     * @param lastName
     * @return the boolean.
     */
    @Override
    public boolean isLastNameValid(String lastName) {
        return lastName != null && lastName.matches(LAST_NAME_REGEX);
    }

    /**
     * Is DataBirthday valid.
     *
     * @param dataBirthday
     * @return the boolean.
     */
    @Override
    public boolean isDataBirthdayValid(String dataBirthday) {
        return dataBirthday != null && dataBirthday.matches(DATABIRTHDAY_REGEX);
    }

    /**
     * Is address valid.
     *
     * @param address
     * @return the boolean.
     */
    @Override
    public boolean isAddressValid(String address) {
        return address != null && address.matches(ADDRESS_REGEX);
    }

    /**
     * Is email valid.
     *
     * @param email the email
     * @return the boolean
     */
    @Override
    public boolean isEmailValid(String email) {
        return email != null && email.matches(EMAIL_REGEX);
    }

    /**
     * Is phone number valid.
     *
     * @param phoneNumber the phone number
     * @return the boolean
     */
    @Override
    public boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches(PHONE_NUMBER_REGEX);
    }

//    /**
//     * check user
//     *
//     * @param userData
//     * @return the boolean.
//     */
//
//    public Map<String, String> checkUserData(Map<String, String> userData) {
//        Map<String, String> mapErrorValidation = new HashMap<>();
//        if (!isLoginValid(userData.get(LOGIN))) {
//            mapErrorValidation.put(LOGIN, INVALID_LOGIN);
//        }
//        if (!isPasswordValid(userData.get(PASSWORD))) {
//            mapErrorValidation.put(PASSWORD, INVALID_PASSWORD);
//        }
//        if (!isFirstNameValid(userData.get(FIRST_NAME))) {
//            mapErrorValidation.put(FIRST_NAME, INVALID_FIRST_NAME);
//
//        }
//        if (!isLastNameValid(userData.get(LAST_NAME))) {
//            mapErrorValidation.put(LAST_NAME, INVALID_LAST_NAME);
//        }
//        if (!isAddressValid(userData.get(ADDRESS))) {
//            mapErrorValidation.put(ADDRESS, INVALID_ADDRESS);
//        }
//        if (!isDataBirthdayValid(userData.get(DATA_BIRTHDAY))) {
//            mapErrorValidation.put(DATA_BIRTHDAY, INVALID_DATA_BIRTHDAY);
//        }
//        if (!isEmailValid(userData.get(EMAIL))) {
//            mapErrorValidation.put(EMAIL, INVALID_EMAIL);
//        }
//        if (!isPhoneNumberValid(userData.get(PHONE_NUMBER))) {
//            mapErrorValidation.put(PHONE_NUMBER, INVALID_PHONE_NUMBER);
//
//        }
//        return mapErrorValidation;
//    }
//}
    /**
     * check user
     * @param userData
     * @return the boolean.
     */

    public boolean checkUserData(Map<String, String> userData) {
        boolean isValid = true;
        if (!isLoginValid(userData.get(LOGIN))) {
            userData.put(LOGIN, INVALID_LOGIN);
            isValid = false;
        }
        if (!isPasswordValid(userData.get(PASSWORD))) {
            userData.put(PASSWORD, INVALID_PASSWORD);
            isValid = false;
        }
        isValid = checkUserPersonalData(userData) && isValid;
        return isValid;
    }

    /**
     * check personal user data.
     * @param userData
     * @return the boolean.
     */
    public boolean checkUserPersonalData(Map<String, String> userData) {
        boolean isValid = true;
        if (!isFirstNameValid(userData.get(FIRST_NAME))) {
            userData.put(FIRST_NAME, INVALID_FIRST_NAME);
            isValid = false;
        }
        if (!isLastNameValid(userData.get(LAST_NAME))) {
            userData.put(LAST_NAME, INVALID_LAST_NAME);
            isValid = false;
        }
        if (!isAddressValid(userData.get(ADDRESS))) {
            userData.put(ADDRESS, INVALID_ADDRESS);
            isValid = false;
        }
        if (!isDataBirthdayValid(userData.get(DATA_BIRTHDAY))) {
            userData.put(DATA_BIRTHDAY, INVALID_DATA_BIRTHDAY);
            isValid = false;
        }
        if (!isEmailValid(userData.get(EMAIL))) {
            userData.put(EMAIL, INVALID_EMAIL);
            isValid = false;
        }
        if (!isPhoneNumberValid(userData.get(PHONE_NUMBER))) {
            userData.put(PHONE_NUMBER, INVALID_PHONE_NUMBER);
            isValid = false;
        }
        return isValid;
    }
}


