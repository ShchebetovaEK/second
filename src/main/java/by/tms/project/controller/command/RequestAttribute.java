package by.tms.project.controller.command;

public final class RequestAttribute {

    public static final String CURRENT_PAGE = "current_page";
    public static final String USER = "user";
    public static final String ADMIN = "admin";
    public static final String PATIENT = "patient";
    public static final String DOCTOR = "doctor";


    public static final String USER_LIST = "users";
    public static final String DOCTORS_LIST = "doctors";
    public static final String PATIENTS_LIST = "patients";
    public static final String PROTOCOL_LIST = "protocol";
    public static final String OPTIONAL_USER = "optional_users";

    public static final String LOGIN ="login";
    public static final String PASSWORD = "password";

    public static final String VALID_ROLE = "valid_role";
    public static final String VALID_LOGIN = "valid_login";
    public static final String VALID_PASSWORD = "valid_password";
    public static final String VALID_FIRST_NAME = "valid_first_name";
    public static final String VALID_LAST_NAME = "valid_last_name";
    public static final String VALID_DATA_BIRTHDAY = "valid_data_birthday";
    public static final String VALID__ADDRESS = "valid_address";
    public static final String VALID_PHONE_NUMBER = "valid_phone_number";
    public static final String VALID_EMAIL = "valid_email";

    public static final String INVALID_MESSAGE = "invalid_message";
    public static final String NOT_UNIQUE_MESSAGE = "not_unique_message";

    public static final String SESSION_USER = "user";
    public static final String SESSION_DOCTOR = "doctor";
    public static final String SESSION_PATIENT = "patient";

    public static final String REGISTRATION = "registration";
    public static final String SESSION_LOCALE = "locale";
    public static final String AUTHENTICATION = "authentication";
    public static final String WRONG_COMMAND = "wrong_command";


    public static final String FIRST_NAME_CHANGE = "first_name_change";
    public static final String LAST_NAME_CHANGE = "last_name_change";
    public static final String DATA_BIRTHDAY_CHANGE ="data_birthday_change";
    public static final String ADDRESS_CHANGE = "address_change";
    public static final String PHONE_NUMBER_CHANGE="phone_number_change";
    public static final String EMAIL_CHANGE = "email_change";


    private RequestAttribute() {
    }
}
