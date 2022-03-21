package by.tms.project.controller.command;

public final class RequestAttribute {

    public static final String CURRENT_PAGE = "current_page";
    public static final String USER = "user";
    public static final String PATIENT_REQ = "patient_req";
    public static final String DOCTOR_REQ = "doctor_req";

    public static final String USER_LIST = "users";
    public static final String DOCTORS_LIST = "doctors";
    public static final String PATIENTS_LIST = "patients";
    public static final String PROTOCOL_LIST = "protocols";
    public static final String PROTOCOL = "protocol";
    public static final String OPTIONAL_USER = "optional_users";

    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String NEW_PASSWORD = "new_password";
    public static final String CONFIRM_PASSWORD = "confirm_password";

    public static final String SESSION_USER = "user";
    public static final String SESSION_DOCTOR = "doctor";
    public static final String SESSION_PATIENT = "patient";

    public static final String REGISTRATION = "registration";
    public static final String SESSION_LOCALE = "locale";
    public static final String AUTHENTICATION = "authentication";
    public static final String WRONG_COMMAND = "wrong_command";

    public static final String FIRST_NAME_CHANGE = "first_name_change";
    public static final String LAST_NAME_CHANGE = "last_name_change";
    public static final String DATA_BIRTHDAY_CHANGE = "data_birthday_change";
    public static final String ADDRESS_CHANGE = "address_change";
    public static final String PHONE_NUMBER_CHANGE = "phone_number_change";
    public static final String EMAIL_CHANGE = "email_change";

    /* registration*/
    public static final String INVALID_LOGIN = "invalid_login";
    public static final String INVALID_PASSWORD = "invalid_password";
    public static final String INVALID_FIRST_NAME = "invalid_firstName";
    public static final String INVALID_LAST_NAME = "invalid_lastName";
    public static final String INVALID_DATA_BIRTHDAY = "invalid_dataBirthday";
    public static final String INVALID_ADDRESS = "invalid_address";
    public static final String INVALID_PHONE_NUMBER = "invalid_phone_number";
    public static final String INVALID_EMAIL = "invalid_email";
    public static final String INVALID_CATEGORY = "invalid_category";
    public static final String INVALID_SPECIALITY = "invalid_speciality";
    public static final String INVALID_DISCOUNT = "invalid_discount";

    private RequestAttribute() {
    }
}
